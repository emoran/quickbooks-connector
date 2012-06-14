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

public interface OAuthCredentialsStorage {

    String getRequestTokenURL();

    String getAccessTokenURL();

    String getAuthorizeURL();

    String getConsumerKey();

    String getConsumerSecret();

    String getCallBackURL();

    void setRequestToken(String token);

    String getRequestToken();

    void setRequestTokenSecret(String tokenSecret);

    String getRequestTokenSecret();

    void setToken(String token);

    String getToken();

    void setTokenSecret(String tokenSecret);

    String getTokenSecret();

    boolean isAuthenticated();

    void clearAuthentication();

}
