/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mule.api.store.ObjectStoreException;
import org.mule.modules.quickbooks.api.oauth.OAuthCredentials;
import org.mule.modules.quickbooks.api.oauth.QuickBooksOAuthClient;
import org.mule.modules.quickbooks.api.openid.OpenIDClient;
import org.mule.modules.quickbooks.api.openid.OpenIDCredentials;
import org.openid4java.message.MessageException;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Mulesoft Inc
 */
@SuppressWarnings("unused")
public class QuickBooksCommonsOAuthClientTest {

    @Mock
    private QuickBooksOAuthClient oAuthClient;
    @Mock
    private OpenIDClient openIDClient;
    private static final String CONSUMER_KEY = "CONSUMER_KEY";
    private static final String CONSUMER_SECRET = "CONSUMER_SECRET";
    private static final String REQUEST_TOKEN_URL = "REQUEST_TOKEN_URL";
    private static final String ACCESS_TOKEN_URL = "ACCESS_TOKEN_URL";
    private static final String AUTHORIZATION_URL = "AUTHORIZATION_URL";
    private static final String CALLBACK_URL = "CALLBACK_URL";
    private static final String REQUEST_TOKEN_ID = "REQUEST_TOKEN_ID";
    private static final String AUTH_URL = "AUTH_URL";
    private static final String ACCESS_TOKEN = "a1b2c3";
    private static final String ACCESS_TOKEN_SECRET = "d4e5f6";
    private static final String OAUTH_VERIFIER = "VERIFIER";
    private static final String PROVIDER_URL = "PROVIDER_URL";
    private static final String RETURN_URL = "RETURN_URL";
    private static final String OPEN_ID_AUTH_URL = "OPEN_ID_AUTH_URL";
    private static final String RECEIVING_URL = "RECEIVING_URL";
    private static final String OPENID_EMAIL = "muleftw@mulesoft.com";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAuthorize() throws ObjectStoreException, OAuthExpectationFailedException,
            OAuthMessageSignerException, OAuthCommunicationException, OAuthNotAuthorizedException {
        when(oAuthClient.authorize(REQUEST_TOKEN_URL, ACCESS_TOKEN_URL, AUTHORIZATION_URL, CALLBACK_URL,
                REQUEST_TOKEN_ID)).thenReturn(AUTH_URL);
        assertEquals(AUTH_URL, oAuthClient.authorize(REQUEST_TOKEN_URL, ACCESS_TOKEN_URL, AUTHORIZATION_URL, CALLBACK_URL,
                REQUEST_TOKEN_ID));
    }

    @Test
    public void testGetAccessToken() throws ObjectStoreException, OAuthExpectationFailedException,
            OAuthMessageSignerException, OAuthCommunicationException, OAuthNotAuthorizedException {
        when(oAuthClient.getAccessToken(OAUTH_VERIFIER, REQUEST_TOKEN_ID)).thenReturn(createOAuthCredentials());
        assertEquals(createOAuthCredentials().getAccessToken(),
                oAuthClient.getAccessToken(OAUTH_VERIFIER, REQUEST_TOKEN_ID).getAccessToken());
    }

    @Test
    public void testOpenIdInitialize() throws ObjectStoreException {
        when(openIDClient.initialize(PROVIDER_URL, RETURN_URL, true)).thenReturn(OPEN_ID_AUTH_URL);
        assertEquals(openIDClient.initialize(PROVIDER_URL, RETURN_URL, true), OPEN_ID_AUTH_URL);
    }

    @Test
    public void testOpenIdVerify() throws ObjectStoreException, MessageException {
        when(openIDClient.verifyOpenIDFromIntuit(RECEIVING_URL, createParamMaps(), true)).
                thenReturn(createOpenIdCredentials());
        assertEquals(openIDClient.verifyOpenIDFromIntuit(RECEIVING_URL, createParamMaps(), true).getEmail(),
                createOpenIdCredentials().getEmail());
    }

    private static OAuthCredentials createOAuthCredentials() {
        return new OAuthCredentials(ACCESS_TOKEN, ACCESS_TOKEN_SECRET);
    }

    private static OpenIDCredentials createOpenIdCredentials() {
        OpenIDCredentials credentials = new OpenIDCredentials();
        credentials.setEmail(OPENID_EMAIL);
        return credentials;
    }

    private static Map<String, String> createParamMaps() {
        return new HashMap<String, String>();
    }
}
