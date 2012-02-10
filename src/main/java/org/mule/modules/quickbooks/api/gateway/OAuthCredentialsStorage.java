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
