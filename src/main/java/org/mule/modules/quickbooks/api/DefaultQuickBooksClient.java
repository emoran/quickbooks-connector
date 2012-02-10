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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.Validate;
import org.mule.modules.quickbooks.EntityType;
import org.mule.modules.quickbooks.api.Exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.schema.CdmBase;
import org.mule.modules.quickbooks.schema.FaultInfo;
import org.mule.modules.quickbooks.schema.IdType;
import org.mule.modules.quickbooks.schema.ObjectFactory;
import org.mule.modules.quickbooks.schema.QboUser;
import org.mule.modules.quickbooks.schema.SearchResults;
import org.mule.modules.quickbooks.utils.ObjectFactories;
import org.mule.modules.utils.pagination.PaginatedIterable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.sun.jersey.oauth.client.OAuthClientFilter;
import com.sun.jersey.oauth.signature.OAuthParameters;
import com.sun.jersey.oauth.signature.OAuthSecrets;

/**
 * 
 * @author Gaston Ponti
 * @since Aug 19, 2011
 */
public class DefaultQuickBooksClient implements QuickBooksClient
{
    private static Logger sLog = LoggerFactory.getLogger(DefaultQuickBooksClient.class);
    private static final String INTERNAL_GATEWAY_PROPS = "/../../../internal-gateway/src/main/resources/internal-gateway.properties";
    private Properties properties;
    private final String baseUri;
    private final String realmId;
    private final Client client;
    private final OAuthParameters params;
    private final OAuthSecrets secrets;
    private final ObjectFactory objectFactory;
    private String companyBaseUri = null;
    private Integer resultsPerPage = 100;
    private MuleOAuthCredentialStorage storage;
    
    private final String accessToken = null;
    private final String accessSecret = null;
    
    /*
        MuleOAuthCredentialStorage storage = new MuleOAuthCredentialStorage();
        storage.setConsumerKey("e53dxxcn2r6b2buxrgxgdujnd7v");
        storage.setConsumerSecret("secret");
        
        String keyStorePath = "/home/gaston/pruebasCerts/federatedconnectortestapp.zauberlabs.com.p12";
        String keyStorePassword = "intuit";
        String privateKeyPassword = "intuit";
        String privateKeyAlias = "federatedconnectortestapp.zauberlabs.com";
        String keyStoreType = "PKCS12";
        String tokens = null;
        try {
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(new FileInputStream(keyStorePath), keyStorePassword.toCharArray());
            PrivateKey privateKey = (PrivateKey) keyStore.getKey(privateKeyAlias, privateKeyPassword.toCharArray());
            tokens = new OAuthGateway(storage,
                                      new RsaSha1MessageSigner(privateKey),
                                      new XoAuthAuthorizationHeaderSigningStrategy())
                        .getOAuthToken(System.getenv("serviceProviderId"),
                                       System.getenv("authIdPseudonym"), 
                                       System.getenv("realmIdPseudonym"));
        } catch (Exception e) {
        }
        
        System.out.println(tokens);
        assertNotNull(tokens);
     */
    public DefaultQuickBooksClient(final String realmId, final String consumerKey,
                                   /*final String consumerSecret,*/ final String baseUri)
    {
        Validate.notNull(realmId);
        Validate.notNull(consumerKey);
        //Validate.notNull(consumerSecret);
        Validate.notEmpty(baseUri);
        
        this.objectFactory = new ObjectFactory();
        this.realmId = realmId;
        this.client = Client.create();
        
        this.params = new OAuthParameters().signatureMethod("HMAC-SHA1").consumerKey(consumerKey);
        //this.secrets = new OAuthSecrets().consumerSecret(consumerSecret);
        
        this.baseUri = baseUri;
        
        try 
        {
            loadProperties(INTERNAL_GATEWAY_PROPS);
            storage = new MuleOAuthCredentialStorage();
            storage.setConsumerKey(consumerKey);
        } 
        catch (Exception e) 
        {
            sLog.error("Can't locate properties file: " + INTERNAL_GATEWAY_PROPS, e);
        }
    }
    
    private void getAccessTokensFromSaml()
    {   
        String keyStorePath = (String) properties.get("keystore.keystorePath");
        String keyStorePassword = (String) properties.get("keystore.password");
        String privateKeyPassword = (String) properties.get("keystore.privateKeyPassword");
        String privateKeyAlias = (String) properties.get("keystore.privateKeyAlias");
        String keyStoreType = (String) properties.get("keystore.keystoreType");
        String tokens = null;
        try 
        {
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(new FileInputStream(keyStorePath), keyStorePassword.toCharArray());
            PrivateKey privateKey = (PrivateKey) keyStore.getKey(privateKeyAlias, privateKeyPassword.toCharArray());
            tokens = new OAuthGateway(storage,
                                      new RsaSha1MessageSigner(privateKey),
                                      new XoAuthAuthorizationHeaderSigningStrategy())
                        .getOAuthToken(System.getenv("serviceProviderId"),
                                       System.getenv("authIdPseudonym"), 
                                       System.getenv("realmIdPseudonym"));
        } 
        catch (Exception e) 
        {
        }

        
    }

    /** @throws QuickBooksRuntimeException 
     * @see org.mule.modules.quickbooks.api.QuickBooksClient#create(java.lang.Object) */
    @Override
    public <T extends CdmBase> T create(final EntityType type, T obj, final String accessKey, final String accessSecret)
    {
        Validate.notNull(obj);
        Validate.notNull(accessKey);
        Validate.notNull(accessSecret);
        
        try
        {
            String str = String.format("/resource/%s/v2/%s",
                QuickBooksConventions.toQuickBooksPathVariable(obj.getClass().getSimpleName()),
                realmId);
            T response = getGateWay(accessKey, accessSecret).path(str)
            .type(MediaType.APPLICATION_XML)
            .post(type.<T>getType(), ObjectFactories.createJaxbElement(obj, objectFactory));
            
            return response;
        }
        catch (final UniformInterfaceException e)
        {
            final FaultInfo fault = e.getResponse().getEntity(FaultInfo.class);
            throw new QuickBooksRuntimeException(fault);
        }

    }

    /** @throws QuickBooksRuntimeException 
     * @see org.mule.modules.quickbooks.api.QuickBooksClient#getObject() */
    @Override
    public <T extends CdmBase> T getObject(final EntityType type, final IdType id, final String accessKey, final String accessSecret)
    {   
        Validate.notNull(type);
        Validate.notNull(id);
        Validate.notNull(accessKey);
        Validate.notNull(accessSecret);
        
        String str = String.format("/resource/%s/v2/%s/%s",
            type.getResouceName(), realmId, id.getValue());
        try
        {
            T response = getGateWay(accessKey, accessSecret).path(str)
                .type(MediaType.APPLICATION_FORM_URLENCODED)
                .get(type.<T>getType());
            
            return response;
        }
        catch (final UniformInterfaceException e)
        {
            final FaultInfo fault = e.getResponse().getEntity(FaultInfo.class);
            throw new QuickBooksRuntimeException(fault);
        }
    }

    /** @throws QuickBooksRuntimeException 
     * @see org.mule.modules.quickbooks.api.QuickBooksClient#update(java.lang.String) */
    @Override
    public <T extends CdmBase> T update(final EntityType type, T obj, final String accessKey, final String accessSecret)
    {
        Validate.notNull(obj);
        Validate.notNull(accessKey);
        Validate.notNull(accessSecret);
        
        if (obj.getSyncToken() == null)
        {
            obj.setSyncToken(getObject(type, obj.getId(), accessKey, accessSecret).getSyncToken());
        }
        String str = String.format("/resource/%s/v2/%s/%s",
            QuickBooksConventions.toQuickBooksPathVariable(obj.getClass().getSimpleName()),
            realmId,
            obj.getId().getValue());
        try
        {
            T response = getGateWay(accessKey, accessSecret).path(str)
                .type(MediaType.APPLICATION_XML)
                .post(type.<T>getType(), ObjectFactories.createJaxbElement(obj, objectFactory));
            return response;
        }
        catch (final UniformInterfaceException e)
        {
            final FaultInfo fault = e.getResponse().getEntity(FaultInfo.class);
            throw new QuickBooksRuntimeException(fault);
        }

    }

    /** @throws QuickBooksRuntimeException 
     * @see org.mule.modules.quickbooks.api.QuickBooksClient#deleteObject(java.lang.Object) */
    @Override
    public <T extends CdmBase> void deleteObject(final EntityType type, final IdType id, String syncToken,
                                                 final String accessKey, final String accessSecret)
    {   
        Validate.notNull(type);
        Validate.notNull(id);
        Validate.notNull(accessKey);
        Validate.notNull(accessSecret);
        
        if (syncToken == null)
        {
            syncToken = getObject(type, id, accessKey, accessSecret).getSyncToken();
        }
        T obj = (T) type.newInstance();
        obj.setSyncToken(syncToken);
        obj.setId(id);
        
        String str = String.format("/resource/%s/v2/%s/%s",
            type.getResouceName(), realmId, id.getValue());
        
        try
        {
            getGateWay(accessKey, accessSecret).path(str)
                .queryParam("methodx", "delete")
                .type(MediaType.APPLICATION_XML)
                .post(type.<T>getType(), ObjectFactories.createJaxbElement(obj, objectFactory));
        }
        catch (final UniformInterfaceException e)
        {
            final FaultInfo fault = e.getResponse().getEntity(FaultInfo.class);
            throw new QuickBooksRuntimeException(fault);
        }

    }

    /** @param query 
     * @param type 
     * @see org.mule.modules.quickbooks.api.QuickBooksClient#findObjects() */
    @Override
    public <T extends CdmBase> Iterable<T> findObjects(final EntityType type, final String queryFilter, final String querySort,
                                                       final String accessKey, final String accessSecret)
    {
        Validate.notNull(type);
        Validate.notNull(accessKey);
        Validate.notNull(accessSecret);
        
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
                    MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
                    if (queryFilter != null)
                    {
                        formData.add("Filter", queryFilter);
                    }
                    if (querySort != null)
                    {
                        formData.add("Sort", querySort);
                    }
                    formData.add("ResultsPerPage", resultsPerPage.toString());
                    formData.add("PageNum", pageNumber.toString());
                    try
                    {    
                        String str = String.format("/resource/%ss/v2/%s", type.getResouceName(), realmId); 
                        SearchResults response = getGateWay(accessKey, accessSecret).path(str)
                            .type(MediaType.APPLICATION_FORM_URLENCODED)
                            .post(SearchResults.class, formData);
                        
                        return response;
                    }
                    catch (final UniformInterfaceException e)
                    {
                        final FaultInfo fault = e.getResponse().getEntity(FaultInfo.class);
                        throw new QuickBooksRuntimeException(fault);
                    }
                }
            };
    }
    
    private WebResource getGateWay(String accessKey, String accessSecret)
    {
            String str = getCompanyBaseURI(accessKey, accessSecret);
            OAuthClientFilter oauthFilter = new OAuthClientFilter(client.getProviders(),
                params.token(accessKey), secrets.tokenSecret(accessSecret));
            
            WebResource webResource = this.client.resource(str);
            webResource.addFilter(oauthFilter);
            
            return webResource;
    }

    private String getCompanyBaseURI(String accessKey, String accessSecret)
    {
        Validate.notNull(accessKey);
        Validate.notNull(accessSecret);
        
        if (companyBaseUri == null)
        {
            OAuthClientFilter oauthFilter = new OAuthClientFilter(client.getProviders(),
                params.token(accessKey), secrets.tokenSecret(accessSecret));
            
            String str = String.format("%s/%s", baseUri, realmId);
            WebResource webResource = this.client.resource(str);
            webResource.addFilter(oauthFilter);
            
            try
            {
                QboUser response = webResource.header("Content-Type", "application/xml")
                    .type(MediaType.APPLICATION_XML)
                    .get(QboUser.class);
                
                companyBaseUri = response.getCurrentCompany().getBaseURI();
            }
            catch (final UniformInterfaceException e)
            {
                final FaultInfo fault = e.getResponse().getEntity(FaultInfo.class);
                throw new QuickBooksRuntimeException(fault);
            }
        }

        return companyBaseUri;
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
            fileInputStream = this.getClass().getResourceAsStream(resourceName);
            if (fileInputStream != null) 
            {
                this.properties.load(fileInputStream);
            } 
            else 
            {
                String name = resourceName.substring(1);
                fileInputStream = new FileInputStream(name);
                if (fileInputStream != null) 
                {
                    this.properties.load(fileInputStream);
                } 
                else 
                {
                    throw new IOException("Configuration resource " + resourceName + " not found");
                }
            }
        } 
        finally 
        {
            if (fileInputStream != null) 
            {
                fileInputStream.close();
                fileInputStream = null;
            }
        }
    }
}
