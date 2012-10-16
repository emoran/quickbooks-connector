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
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

import org.apache.commons.lang.Validate;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;
import org.mule.modules.quickbooks.api.exception.ExceptionInfo;
import org.mule.modules.quickbooks.api.exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.api.gateway.MuleOAuthCredentialStorage;
import org.mule.modules.quickbooks.api.gateway.oauth.OAuthGateway;
import org.mule.modules.quickbooks.utils.MessageUtils;
import org.mule.modules.utils.MuleSoftException;
import org.springframework.core.io.ClassPathResource;

import com.intuit.ipp.oauth.signing.RsaSha1MessageSigner;
import com.intuit.ipp.oauth.signing.XoAuthAuthorizationHeaderSigningStrategy;

public abstract class AbstractQuickBooksClient
{   
    private static final String INTERNAL_GATEWAY_PROPS = "internal-gateway.properties";
    private static final String APP_CENTER_URI = "https://appcenter.intuit.com/api/v1/user/current";
    protected Properties properties;

    protected Integer resultsPerPage = 999;
    protected PrivateKey privateKey;
    
    protected String serviceProviderId;
    
    protected String baseUri;
    
    protected final HttpClient client = getThreadSafeClient();
    
    private final Map<String, CompanyConnectionData> connectionDatas = new HashMap<String, CompanyConnectionData>();

    public static DefaultHttpClient getThreadSafeClient() 
    {
        DefaultHttpClient client = new DefaultHttpClient();
        ClientConnectionManager mgr = client.getConnectionManager();
        HttpParams params = client.getParams();
     
        client = new DefaultHttpClient(new ThreadSafeClientConnManager(params, 
                mgr.getSchemeRegistry()), params);
     
        return client;
    }
    
    protected void init(final String baseUri)
    {
        Validate.notEmpty(baseUri);
        
        this.baseUri = baseUri;
        
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
    
    protected Object makeARequestToQuickbooks(HttpUriRequest httpRequest, String appKey, String accessToken)
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
                ExceptionInfo fault = getFaultInfo(responseBody.toString());
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
            return getMessageUtilsInstance().parseResponse(responseBody.toString());
        }
        catch (JAXBException e)
        {
            throw MuleSoftException.soften(e);
        }
    }
    
    protected abstract ExceptionInfo getFaultInfo(String str) throws JAXBException;
    
    protected abstract MessageUtils getMessageUtilsInstance();
    
    protected void prepareToPost(final Object obj, HttpUriRequest httpRequest)
    {
        JAXBElement jaxbElement = getMessageUtilsInstance().createJaxbElement(obj);
        try
        {   
            String documentToPost = getMessageUtilsInstance().getXmlDocument(jaxbElement);
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
        if ( resultsPerPage > 999 || resultsPerPage < 10 )
        {
            throw new IllegalArgumentException("Results Per Page must be a number between 10 and 999");
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
    
    protected abstract String loadCompanyBaseUri(String realmId, String appKey, String accessToken);
    
    protected String getBaseUri(String realmId)
    {
        return connectionDatas.get(realmId).getBaseUri();
    }
    
    protected String getAccessToken(String realmId)
    {
        return connectionDatas.get(realmId).getAccessToken();
    }
    
    protected void destroyAccessToken(String realmId)
    {
        connectionDatas.get(realmId).invalidateToken();
    }
    
    protected void loadCompanyData(String realmId, String appKey, String realmIdPseudonym, String authIdPseudonym)
    {
        if(!connectionDatas.containsKey(realmId) || !connectionDatas.get(realmId).isTokenValid())
        {
            String accessToken = getAccessTokensFromSaml(appKey, realmIdPseudonym, authIdPseudonym);
            if(!connectionDatas.containsKey(realmId))
            {
                connectionDatas.put(realmId, new CompanyConnectionData());
                connectionDatas.get(realmId).setBaseUri(loadCompanyBaseUri(realmId, appKey, accessToken));
            }
            connectionDatas.get(realmId).setAccessToken(accessToken);
        }
    }
    
    /**
     * Retrieves the current user information
     * @param realmId
     * @param appKey
     * @param realmIdPseudonym
     * @param authIdPseudonym
     * @return
     */
    @SuppressWarnings("unchecked")
    protected <T> T retrieveUserInformation(final String realmId,
                final String appKey,
                final String realmIdPseudonym, 
                final String authIdPseudonym)
    {        
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
        
        HttpUriRequest httpRequest = new HttpGet(APP_CENTER_URI);
        
        try
        {
            return (T) makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault()) {
                destroyAccessToken(realmId);
                return retrieveUserInformation(realmId, appKey, realmIdPseudonym, authIdPseudonym);
            } 
            else {
                throw e;
            }
        }
    }
    
    protected Integer getResultsPerPage()
    {
        return resultsPerPage;
    }
    
    private class CompanyConnectionData
    {
        private String baseUri;
        private String accessToken;
        
        protected CompanyConnectionData()
        {
            invalidateToken();
        }
        
        public String getBaseUri()
        {
            return baseUri;
        }

        public void setBaseUri(String baseUri)
        {
            this.baseUri = baseUri;
        }

        public String getAccessToken()
        {
            return accessToken;
        }

        public void setAccessToken(String accessToken)
        {
            this.accessToken = accessToken;
        }
        
        public void invalidateToken()
        {
            this.accessToken = "invalidToken";
        }
        
        public boolean isTokenValid()
        {
            return this.accessToken.equals("invalidToken");
        }
    }
}
