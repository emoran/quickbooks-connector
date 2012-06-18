/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.api.gateway;

public final class MuleOAuthCredentialStorage implements OAuthCredentialsStorage {

    private String token;
    private String tokenSecret;
    private String requestToken;
    private String requestTokenSecret;

    private String consumerKey;
    private String consumerSecret;

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }

    public void setTokenSecret(final String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }

    public String getRequestToken() {
        return requestToken;
    }

    public void setRequestToken(final String requestToken) {
        this.requestToken = requestToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public String getRequestTokenSecret() {
        return requestTokenSecret;
    }

    public void setRequestTokenSecret(final String requestTokenSecret) {
        this.requestTokenSecret = requestTokenSecret;
    }

    @Override
    public String getRequestTokenURL() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getAccessTokenURL() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getAuthorizeURL() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getCallBackURL() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clearAuthentication() {
        // TODO Auto-generated method stub

    }

}