package org.mule.modules.quickbooks.api.gateway.oauth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import net.sf.staccatocommons.lang.SoftException;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;
import oauth.signpost.http.HttpParameters;
import oauth.signpost.signature.OAuthMessageSigner;
import oauth.signpost.signature.SigningStrategy;

import org.mule.modules.quickbooks.api.gateway.OAuthCredentialsStorage;

public class OAuthGateway 
{

    private final OAuthConsumer consumer;
    private final OAuthProvider provider;
    private final OAuthCredentialsStorage client;

    public OAuthGateway(final OAuthCredentialsStorage client) 
    {
        this.client = client;
        consumer = new CommonsHttpOAuthConsumer(client.getConsumerKey(), client.getConsumerSecret());
        provider = new CommonsHttpOAuthProvider(client.getRequestTokenURL(), client.getAccessTokenURL(),
                client.getAuthorizeURL());
    }

    public OAuthGateway(final OAuthCredentialsStorage client, final OAuthMessageSigner messageSigner) 
    {
        this(client);
        consumer.setMessageSigner(messageSigner);
    }

    public OAuthGateway(final OAuthCredentialsStorage client, final SigningStrategy signingStrategy) 
    {
        this(client);
        consumer.setSigningStrategy(signingStrategy);
    }

    public OAuthGateway(final OAuthCredentialsStorage client, final OAuthMessageSigner messageSigner,
            final SigningStrategy signingStrategy) 
    {
        this(client);
        consumer.setMessageSigner(messageSigner);
        consumer.setSigningStrategy(signingStrategy);
    }

    public final String getAuthenticationURL() throws OAuthMessageSignerException,
            OAuthNotAuthorizedException, OAuthExpectationFailedException, OAuthCommunicationException 
    {
        String authUrl = provider.retrieveRequestToken(consumer, client.getCallBackURL());
        client.setRequestToken(consumer.getToken());
        client.setRequestTokenSecret(consumer.getTokenSecret());
        return authUrl;
    }

    public final void finishAuthentication(final String verifier) throws OAuthMessageSignerException,
            OAuthNotAuthorizedException, OAuthExpectationFailedException, OAuthCommunicationException 
    {
        String requestToken = client.getRequestToken();
        String requestTokenSecret = client.getRequestTokenSecret();
        consumer.setTokenWithSecret(requestToken, requestTokenSecret);
        provider.setOAuth10a(true);
        provider.retrieveAccessToken(consumer, verifier);
        String token = consumer.getToken();
        String tokenSecret = consumer.getTokenSecret();
        client.setToken(token);
        client.setTokenSecret(tokenSecret);

    }

    public final OAuthConsumer getConsumer() 
    {
        if (client.isAuthenticated() && consumer.getToken() == null || consumer.getTokenSecret() == null) 
        {
            consumer.setTokenWithSecret(client.getToken(), client.getTokenSecret());
        }

        return consumer;

    }

    private static String getUrlContentSigned(final OAuthConsumer consumer, final String url,
            final HttpParameters additionalParameters) 
    {
        try 
        {
            HttpGet request = new HttpGet(url);
            consumer.setAdditionalParameters(additionalParameters);
            consumer.sign(request);
            HttpResponse response = new DefaultHttpClient().execute(request);
            return parseContent(response);
        } 
        catch (Exception e) 
        {
            throw SoftException.soften(e);
        }
    }

    public static String getUrlContentSigned(final OAuthConsumer consumer, final String url) 
    {
        return getUrlContentSigned(consumer, url, null);
    }

    public static String getUrlContentUnsigned(final String url) throws ClientProtocolException, IOException 
    {
        HttpGet request = new HttpGet(url);
        HttpResponse response = new DefaultHttpClient().execute(request);
        return parseContent(response);
    }

    public static String postUrlContentSigned(final OAuthConsumer consumer, final String url,
            final String content) 
    {
        try 
        {
            HttpPost request = new HttpPost(url);
            request.setEntity(new StringEntity(content));
            consumer.sign(request);
            HttpResponse response = new DefaultHttpClient().execute(request);
            return parseContent(response);
        }
        catch (Exception e) 
        {
            throw SoftException.soften(e);
        }
    }

    private static String parseContent(HttpResponse response) throws IOException,
            UnsupportedEncodingException 
    {
        InputStream is = response.getEntity().getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String line;
        String str = "";
        while ((line = reader.readLine()) != null) 
        {
            str += "\n" + line;
        }
        return str;
    }

    public final String getOAuthToken(final String serviceProviderID, final String ippId,
            final String pseudoRealmId) 
    {
        HttpParameters additionalParameters = new HttpParameters();
        additionalParameters.put("xoauth_service_provider_id", serviceProviderID);
        additionalParameters.put("xoauth_auth_id_pseudonym", ippId);
        additionalParameters.put("xoauth_realm_id_pseudonym", pseudoRealmId);
        return OAuthGateway.getUrlContentSigned(this.getConsumer(),
                "https://oauth.intuit.com/oauth/v1/get_access_token_by_intuit_pseudonym",
                additionalParameters);
    }

}
