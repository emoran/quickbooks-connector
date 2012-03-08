/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.api;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.Validate;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.mule.modules.quickbooks.EntityType;
import org.mule.modules.quickbooks.api.Exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.api.gateway.MuleOAuthCredentialStorage;
import org.mule.modules.quickbooks.api.gateway.oauth.OAuthGateway;
import org.mule.modules.quickbooks.schema.CdmBase;
import org.mule.modules.quickbooks.schema.FaultInfo;
import org.mule.modules.quickbooks.schema.IdType;
import org.mule.modules.quickbooks.schema.QboUser;
import org.mule.modules.quickbooks.schema.SearchResults;
import org.mule.modules.quickbooks.utils.QBOMessageUtils;
import org.mule.modules.utils.MuleSoftException;
import org.mule.modules.utils.pagination.PaginatedIterable;
import org.springframework.core.io.ClassPathResource;

import com.intuit.ipp.oauth.signing.RsaSha1MessageSigner;
import com.intuit.ipp.oauth.signing.XoAuthAuthorizationHeaderSigningStrategy;
import com.intuit.platform.client.transport.HttpProtocolConstants;

/**
 * 
 * @author Gaston Ponti
 * @since Aug 19, 2011
 */
public class DefaultQuickBooksClient implements QuickBooksClient
{
    private static final String INTERNAL_GATEWAY_PROPS = "internal-gateway.properties";
    private Properties properties;
    private final String baseUri;

    private Integer resultsPerPage = 100;
    private PrivateKey privateKey;
    
    private String serviceProviderId;
    
    private final Map<String, CompanyConnectionData> connectionDatas;
    
    public DefaultQuickBooksClient(final String baseUri)
    {
        Validate.notEmpty(baseUri);
        
        this.baseUri = baseUri;
        
        connectionDatas = new HashMap<String, CompanyConnectionData>();
        
        try 
        {
            loadProperties(INTERNAL_GATEWAY_PROPS);
            loadPrivateKey();
        } 
        catch (Exception e) 
        {
            throw MuleSoftException.soften(e);
        }
    }
    
    /** @throws QuickBooksRuntimeException 
     * @see org.mule.modules.quickbooks.api.QuickBooksClient#create(java.lang.Object) */
    @Override
    public <T extends CdmBase> T create(final String realmId,
                                        final String appKey,
                                        final String realmIdPseudonym, 
                                        final String authIdPseudonym,
                                        final EntityType type,
                                        T obj)
    {
        Validate.notNull(obj);
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
        
        String str = String.format("%s/resource/%s/v2/%s",
            connectionDatas.get(realmId).getBaseUri(),
            QuickBooksConventions.toQuickBooksPathVariable(obj.getClass().getSimpleName()),
            realmId);
        
        HttpUriRequest httpRequest = new HttpPost(str);
        prepareToPost(obj, httpRequest);

        try
        {
            return (T) makeARequestToQuickbooks(httpRequest, appKey, connectionDatas.get(realmId).getAccessToken());
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                connectionDatas.get(realmId).setAccessToken(null);
                return create(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, obj);
            } 
            else 
            {
                throw e;
            }
        }
    }

    /** @throws QuickBooksRuntimeException 
     * @see org.mule.modules.quickbooks.api.QuickBooksClient#getObject() */
    @Override
    public <T extends CdmBase> T getObject(final String realmId,
                                           final String appKey,
                                           final String realmIdPseudonym, 
                                           final String authIdPseudonym,
                                           final EntityType type,
                                           final IdType id)
    {   
        Validate.notNull(type);
        Validate.notNull(id);
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
        
        String str = String.format("%s/resource/%s/v2/%s/%s",
            connectionDatas.get(realmId).getBaseUri(), type.getResouceName(), realmId, id.getValue());

        HttpUriRequest httpRequest = new HttpGet(str);
        
        try
        {
            return (T) makeARequestToQuickbooks(httpRequest, appKey, connectionDatas.get(realmId).getAccessToken());
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                connectionDatas.get(realmId).setAccessToken(null);
                return getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, id);
            } 
            else 
            {
                throw e;
            }
        }
    }

    /** @throws QuickBooksRuntimeException 
     * @see org.mule.modules.quickbooks.api.QuickBooksClient#update(java.lang.String) */
    @Override
    public <T extends CdmBase> T update(final String realmId,
                                        final String appKey,
                                        final String realmIdPseudonym, 
                                        final String authIdPseudonym,
                                        final EntityType type,
                                        T obj)
    {
        Validate.notNull(obj);
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
        
        if (obj.getSyncToken() == null)
        {
            obj.setSyncToken(getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, obj.getId()).getSyncToken());
        }
        
        String str = String.format("%s/resource/%s/v2/%s/%s",
            connectionDatas.get(realmId).getBaseUri(),
            QuickBooksConventions.toQuickBooksPathVariable(obj.getClass().getSimpleName()),
            realmId,
            obj.getId().getValue());
        
        HttpUriRequest httpRequest = new HttpPost(str);
        
        prepareToPost(obj, httpRequest);
        
        try
        {
            return (T) makeARequestToQuickbooks(httpRequest, appKey, connectionDatas.get(realmId).getAccessToken());
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                connectionDatas.get(realmId).setAccessToken(null);
                return update(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, obj);
            } 
            else 
            {
                throw e;
            }
        }
    }

    /** @throws QuickBooksRuntimeException 
     * @see org.mule.modules.quickbooks.api.QuickBooksClient#deleteObject(java.lang.Object) */
    @Override
    public <T extends CdmBase> void deleteObject(final String realmId,
                                                 final String appKey,
                                                 final String realmIdPseudonym, 
                                                 final String authIdPseudonym,
                                                 final EntityType type,
                                                 final IdType id,
                                                 String syncToken)
    {   
        Validate.notNull(type);
        Validate.notNull(id);
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
        
        if (syncToken == null)
        {
            syncToken = getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, id).getSyncToken();
        }
        T obj = (T) type.newInstance();
        obj.setSyncToken(syncToken);
        obj.setId(id);
        
        String str = String.format("%s/resource/%s/v2/%s/%s?methodx=delete",
            connectionDatas.get(realmId).getBaseUri(), type.getResouceName(), realmId, id.getValue());
        HttpUriRequest httpRequest = new HttpPost(str);
        
        prepareToPost(obj, httpRequest);
        try
        {
            makeARequestToQuickbooks(httpRequest, appKey, connectionDatas.get(realmId).getAccessToken());
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                connectionDatas.get(realmId).setAccessToken(null);
                deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, id, syncToken);
            } 
            else 
            {
                throw e;
            }
        }
    }

    /** @param query 
     * @param type 
     * @see org.mule.modules.quickbooks.api.QuickBooksClient#findObjects() */
    @Override
    public <T extends CdmBase> Iterable<T> findObjects(final String realmId, 
                                                       final String appKey,
                                                       final String realmIdPseudonym, 
                                                       final String authIdPseudonym,
                                                       final EntityType type, 
                                                       final String queryFilter, 
                                                       final String querySort)
    {
        Validate.notNull(type);
        
        return new PaginatedIterable<T, SearchResults>()
            {
                @Override
                protected SearchResults firstPage()
                {
                    return askAnEspecificPage(1);
                }

                @Override
                protected SearchResults nextPage(SearchResults currentPage)
                {
                    return askAnEspecificPage(currentPage.getCurrentPage() + 1);
                }
                
                @Override
                protected boolean hasNextPage(SearchResults page)
                {
                    return page.getCount() == resultsPerPage;
                }

                @Override
                @SuppressWarnings("unchecked")
                protected Iterator<T> pageIterator(SearchResults page)
                {
                    try
                    {          
                        return ((List<T>) page.getCdmCollections().getClass()
                                        .getMethod("get" + type.getSimpleName(), null)
                                        .invoke(page.getCdmCollections())).iterator();
                    }
                    catch (IllegalAccessException e)
                    {
                            throw new NotImplementedException(e);
                    }
                    catch (InvocationTargetException e)
                    {
                            throw new NotImplementedException(e);
                    }
                    catch (NoSuchMethodException e)
                    {
                            throw new NotImplementedException(e);
                    }
                }
                
                private SearchResults askAnEspecificPage(Integer pageNumber)
                {
                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    if (queryFilter != null)
                    {
                        nameValuePairs.add(new BasicNameValuePair("Filter", queryFilter));
                    }
                    if (querySort != null)
                    {
                        nameValuePairs.add(new BasicNameValuePair("Sort", querySort));
                    }
                    nameValuePairs.add(new BasicNameValuePair("ResultsPerPage", resultsPerPage.toString()));
                    nameValuePairs.add(new BasicNameValuePair("PageNum", pageNumber.toString()));
                    HttpUriRequest httpRequest = new HttpPost(String.format("%s/resource/%ss/v2/%s", 
                        connectionDatas.get(realmId).getBaseUri(), type.getResouceName(), realmId));
                    
                    httpRequest.addHeader(HttpProtocolConstants.HEADER_CONTENT_TYPE, 
                        HttpProtocolConstants.CONTENT_TYPE_APPLICATION_URL_ENCODED);
                    try
                    {
                        ((HttpPost) httpRequest).setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    }
                    catch (UnsupportedEncodingException e)
                    {
                        throw MuleSoftException.soften(e);
                    } 
                    
                    try
                    {
                        return (SearchResults) makeARequestToQuickbooks(httpRequest, appKey, connectionDatas.get(realmId).getAccessToken());
                    }
                    catch(QuickBooksRuntimeException e)
                    {
                        if(e.isAExpiredTokenFault())
                        {
                            connectionDatas.get(realmId).setAccessToken(null);
                            return askAnEspecificPage(pageNumber);
                        } 
                        else 
                        {
                            throw e;
                        }
                    }
                }
            };
    }
    
    private String getAccessTokensFromSaml(String appKey, String realmIdPseudonym, String authIdPseudonym)
    {   
        String tokens = null;
        try 
        {
            MuleOAuthCredentialStorage storage = new MuleOAuthCredentialStorage();
            storage.setConsumerKey(appKey);
            storage.setConsumerSecret("");
            tokens = new OAuthGateway(storage,
                                      new RsaSha1MessageSigner(privateKey),
                                      new XoAuthAuthorizationHeaderSigningStrategy())
                        .getOAuthToken(serviceProviderId,
                                       authIdPseudonym, 
                                       realmIdPseudonym);
            
            //The accessSecret it's not used by Quickbooks SAML, but it send it anyway
            //String accessSecret = tokens.substring(tokens.indexOf("oauth_token_secret=") + "oauth_token_secret=".length(), tokens.indexOf("&"));
            
            return tokens.substring(tokens.indexOf("oauth_token=") + "oauth_token=".length());
        } 
        catch (Exception e) 
        {
            throw MuleSoftException.soften(e);
        }        
    }
    
    private Object makeARequestToQuickbooks(HttpUriRequest httpRequest, String appKey, String accessToken)
    {
        //httpRequest.addHeader("Accept-Enconding", "gzip,deflate");
        
        CommonsHttpOAuthConsumer postConsumer = new CommonsHttpOAuthConsumer(appKey, "");
        postConsumer.setTokenWithSecret(accessToken, "");
        postConsumer.setMessageSigner(new RsaSha1MessageSigner(privateKey));
        postConsumer.setSigningStrategy(new XoAuthAuthorizationHeaderSigningStrategy());       
        try
        {
            postConsumer.sign(httpRequest);
        }
        catch (Exception e)
        {
            throw MuleSoftException.soften(e);
        }

        HttpClient client = new DefaultHttpClient();
        
        BufferedReader br = null;
        StringBuffer responseBody = null;
        HttpResponse response = null;
        int statusCode = HttpStatus.SC_OK;
        try
        {
            response = client.execute(httpRequest);

            br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String readLine;
            responseBody = new StringBuffer();
            while((readLine = br.readLine()) != null) 
            {
                responseBody.append(readLine + System.getProperty("line.separator"));
            }
            statusCode = response.getStatusLine().getStatusCode();
            if ( statusCode != HttpStatus.SC_OK)
            {
                FaultInfo fault = (FaultInfo) QBOMessageUtils.parseResponse(responseBody.toString());
                throw new QuickBooksRuntimeException(fault);
            }   
        } 
        catch (Exception e) 
        {
            throw MuleSoftException.soften(e);
        } 
        finally 
        {
            if(br != null) 
            {
                try 
                { 
                    br.close(); 
                } 
                catch (Exception e) 
                {
                    throw MuleSoftException.soften(e);
                }
            }
        }
        try
        {
            return QBOMessageUtils.parseResponse(responseBody.toString());
        }
        catch (JAXBException e)
        {
            throw MuleSoftException.soften(e);
        }
    }
    
    private <T extends CdmBase> void prepareToPost(final T obj, HttpUriRequest httpRequest)
    {
        JAXBElement<T> jaxbElement = QBOMessageUtils.createJaxbElement(obj);
        try
        {
            httpRequest.addHeader(HttpProtocolConstants.HEADER_CONTENT_TYPE, HttpProtocolConstants.CONTENT_TYPE_APPLICATION_XML);
            
            String documentToPost = QBOMessageUtils.getXmlDocument(jaxbElement);
            ByteArrayInputStream payLoad = new ByteArrayInputStream(documentToPost.getBytes());
            InputStreamEntity entity = new InputStreamEntity(payLoad, -1);
            ((HttpPost) httpRequest).setEntity(entity);

        }
        catch (Exception e)
        {
            throw MuleSoftException.soften(e);
        }
    }
    
    public void setResultsPerPage(Integer resultsPerPage)
    {   
        if ( resultsPerPage > 100 || resultsPerPage < 10 )
        {
            throw new IllegalArgumentException("Results Per Page must be a number between 10 and 100");
        }    
        this.resultsPerPage = resultsPerPage;
    }

    private void loadProperties(String resourceName) throws IOException 
    {
        this.properties = new Properties();
        InputStream fileInputStream = null;
        try 
        {
            fileInputStream = new ClassPathResource(resourceName).getInputStream();
            this.properties.load(fileInputStream);
        }
        catch (Exception e) {
            throw new IOException("Configuration resource " + resourceName + " not found");
        }
        finally 
        {
            if (fileInputStream != null) 
            {
                fileInputStream.close();
            }
        }
    }
    
    private void loadPrivateKey() throws IOException
    {
        String keyStorePath = (String) properties.get("keystore.keystorePath");
        String keyStorePassword = (String) properties.get("keystore.password");
        String privateKeyPassword = (String) properties.get("keystore.privateKeyPassword");
        String privateKeyAlias = (String) properties.get("keystore.privateKeyAlias");
        String keyStoreType = (String) properties.get("keystore.keystoreType");
        serviceProviderId = (String) properties.get("serviceProviderId");
        
        try
        {
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(new ClassPathResource(keyStorePath).getInputStream(), keyStorePassword.toCharArray());
            privateKey = (PrivateKey) keyStore.getKey(privateKeyAlias, privateKeyPassword.toCharArray());
        }
        catch (Exception e) {
            throw new IOException("Properties file with wrong configuration");
        }

    }
    
    private void loadCompanyData(String realmId, String appKey, String realmIdPseudonym, String authIdPseudonym)
    {
        if(!connectionDatas.containsKey(realmId) || connectionDatas.get(realmId).getAccessToken() == null)
        {
            String accessToken = getAccessTokensFromSaml(appKey, realmIdPseudonym, authIdPseudonym);
            if(!connectionDatas.containsKey(realmId))
            {
                connectionDatas.put(realmId, new CompanyConnectionData());
            }
            connectionDatas.get(realmId).setAccessToken(accessToken);
        }
        
        if (connectionDatas.get(realmId).getBaseUri() == null)
        {
            HttpUriRequest httpRequest = new HttpGet(String.format("%s/%s", baseUri, realmId));
        
            QboUser qboUser = (QboUser) makeARequestToQuickbooks(httpRequest, appKey, connectionDatas.get(realmId).getAccessToken());
        
            connectionDatas.get(realmId).setBaseUri(qboUser.getCurrentCompany().getBaseURI());
        }
    }
    
    private class CompanyConnectionData
    {
        private String baseUri;
        private String accessToken;
        
        protected CompanyConnectionData()
        {
        }
        
        /**
         * @return the baseUri
         */
        public String getBaseUri()
        {
            return baseUri;
        }
        /**
         * @param baseUri the baseUri to set
         */
        public void setBaseUri(String baseUri)
        {
            this.baseUri = baseUri;
        }
        /**
         * @return the accessToken
         */
        public String getAccessToken()
        {
            return accessToken;
        }
        /**
         * @param accessToken the accessToken to set
         */
        public void setAccessToken(String accessToken)
        {
            this.accessToken = accessToken;
        }
        
        
    }
}
