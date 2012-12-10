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

import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.signature.HmacSha1MessageSigner;
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
import org.apache.log4j.Logger;
import org.mule.modules.quickbooks.api.exception.ExceptionInfo;
import org.mule.modules.quickbooks.api.exception.QuickBooksExpiredTokenException;
import org.mule.modules.quickbooks.api.exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.api.oauth.OAuthCredentials;
import org.mule.modules.quickbooks.utils.MessageUtils;
import org.mule.modules.utils.MuleSoftException;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

public abstract class AbstractQuickBooksClientOAuth
{   
    private static final String APP_CENTER_URI = "https://appcenter.intuit.com/api/v1/user/current";
    private static final String BLUE_DOT_MENU_URI = "https://appcenter.intuit.com/api/v1/Account/AppMenu";
    private static final String DISCONNECT_API_URI = "https://appcenter.intuit.com/api/v1/Connection/Disconnect";
    private static final String RECONNECT_API_URI = "https://appcenter.intuit.com/api/v1/Connection/Reconnect";
    private static final Logger LOGGER = Logger.getLogger(AbstractQuickBooksClientOAuth.class);

    protected Integer resultsPerPage = 999;

    protected String serviceProviderId;
    
    protected String baseUri;
    
    protected final HttpClient client = getThreadSafeClient();

    private String consumerKey;
    private String consumerSecret;

    private String appKey;

    public static DefaultHttpClient getThreadSafeClient() 
    {
        DefaultHttpClient client = new DefaultHttpClient();
        ClientConnectionManager mgr = client.getConnectionManager();
        HttpParams params = client.getParams();
     
        client = new DefaultHttpClient(new ThreadSafeClientConnManager(params, 
                mgr.getSchemeRegistry()), params);
     
        return client;
    }
    
    protected void init(final String baseUri, final String serviceProviderId,
                        final String consumerKey, final String consumerSecret, final String appKey)
    {
        Validate.notEmpty(baseUri);
        
        this.baseUri = baseUri;
        this.serviceProviderId = serviceProviderId;
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.appKey = appKey;
    }
    
    @SuppressWarnings("ThrowFromFinallyBlock")
    protected Object makeARequestToQuickbooks(HttpUriRequest httpRequest, OAuthCredentials credentials,
                                              boolean rawResponse)
    {
        CommonsHttpOAuthConsumer postConsumer = new CommonsHttpOAuthConsumer(getConsumerKey(), getConsumerSecret());
        postConsumer.setMessageSigner(new HmacSha1MessageSigner());
        postConsumer.setTokenWithSecret(credentials.getAccessToken(), credentials.getAccessTokenSecret());
        try
        {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(String.format("## Signing HttpRequest: %s", httpRequest.getURI().toString()));
            }
            postConsumer.sign(httpRequest);
        }
        catch (Exception e)
        {
            throw MuleSoftException.soften(e);
        }
        
        BufferedReader br = null;
        StringBuffer responseBody = null;
        HttpResponse response;
        int statusCode;
        try
        {
            response = client.execute(httpRequest);

            br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String readLine;
            responseBody = new StringBuffer();
            while((readLine = br.readLine()) != null) 
            {
                responseBody.append(readLine).append(System.getProperty("line.separator"));
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
            if (rawResponse) return responseBody.toString();
            return getMessageUtilsInstance().parseResponse(responseBody.toString());
        }
        catch (JAXBException e)
        {
            throw MuleSoftException.soften(e);
        }
    }
    
    protected abstract ExceptionInfo getFaultInfo(String str) throws JAXBException;
    
    protected abstract MessageUtils getMessageUtilsInstance();
    
    @SuppressWarnings("unchecked")
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

    protected void destroyAccessToken(OAuthCredentials credentials)
    {
        credentials.setAccessToken("invalidToken");
    }

    /**
     * Retrieves the current user information
     * @param credentials OAuth credentials
     */
    @SuppressWarnings("unchecked")
    protected <T> T retrieveUserInformation(final OAuthCredentials credentials)
    {        
        
        HttpUriRequest httpRequest = new HttpGet(APP_CENTER_URI);
        
        try
        {
            return (T) makeARequestToQuickbooks(httpRequest, credentials, false);
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault()) {
                destroyAccessToken(credentials);
                return retrieveUserInformation(credentials);
            } 
            else {
                throw e;
            }
        }
    }

    /**
     * Retrieves the blue dot menu information
     * @param credentials OAuth credentials
     */
    @SuppressWarnings("unchecked")
    protected <T> T getBlueDotMenu(final OAuthCredentials credentials)
    {

        HttpUriRequest httpRequest = new HttpGet(BLUE_DOT_MENU_URI);

        try
        {
            return (T) makeARequestToQuickbooks(httpRequest, credentials, true);
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault()) {
                throw new QuickBooksExpiredTokenException(e);
            }
            else {
                throw e;
            }
        }
    }

    /**
     * Disconnect user from QB
     * @param credentials OAuth credentials
     */
    @SuppressWarnings("unchecked")
    protected <T> T disconnectFromQB(final OAuthCredentials credentials)
    {

        HttpUriRequest httpRequest = new HttpGet(DISCONNECT_API_URI);

        try
        {
            return (T) makeARequestToQuickbooks(httpRequest, credentials, false);
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault()) {
                throw new QuickBooksExpiredTokenException(e);
            }
            else {
                throw e;
            }
        }
    }

    /**
     * Reconnect user Intuit Platform. Used for refreshing tokens
     * @param credentials OAuth credentials
     */
    @SuppressWarnings("unchecked")
    protected <T> T reconnectToQB(final OAuthCredentials credentials)
    {

        HttpUriRequest httpRequest = new HttpGet(RECONNECT_API_URI);

        try
        {
            return (T) makeARequestToQuickbooks(httpRequest, credentials, false);
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault()) {
                throw new QuickBooksExpiredTokenException(e);
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

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    @SuppressWarnings("unused")
    public String getAppKey() {
        return appKey;
    }

    @SuppressWarnings("unused")
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }
}
