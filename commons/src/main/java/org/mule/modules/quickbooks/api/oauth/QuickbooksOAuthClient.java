/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.api.oauth;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;
import oauth.signpost.signature.OAuthMessageSigner;
import org.mule.api.store.ObjectStoreException;

public interface QuickbooksOAuthClient {

    OAuthCredentials getAccessToken(String verifier, String requestTokenId, OAuthMessageSigner messageSigner)
            throws OAuthMessageSignerException, OAuthNotAuthorizedException,
            OAuthExpectationFailedException, OAuthCommunicationException, ObjectStoreException;

    String authorize(String requestTokenUrl, String accessTokenUrl, String authorizationUrl,
                     String callbackUrl, String requestTokenId, OAuthMessageSigner messageSigner)
            throws OAuthMessageSignerException, OAuthNotAuthorizedException,
            OAuthExpectationFailedException, OAuthCommunicationException,
            ObjectStoreException;
}
