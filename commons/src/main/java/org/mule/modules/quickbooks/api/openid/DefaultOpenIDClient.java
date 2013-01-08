/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.api.openid;

import org.apache.log4j.Logger;
import org.mule.api.store.ObjectStoreException;
import org.mule.modules.quickbooks.api.ObjectStoreHelper;
import org.openid4java.OpenIDException;
import org.openid4java.association.AssociationSessionType;
import org.openid4java.consumer.*;
import org.openid4java.discovery.DiscoveryException;
import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.discovery.Identifier;
import org.openid4java.message.AuthRequest;
import org.openid4java.message.AuthSuccess;
import org.openid4java.message.MessageException;
import org.openid4java.message.ParameterList;
import org.openid4java.message.ax.AxMessage;
import org.openid4java.message.ax.FetchRequest;
import org.openid4java.message.ax.FetchResponse;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Default implementation for Intuit OpenID client
 *
 * @author Mulesoft, Inc
 */
public class DefaultOpenIDClient implements OpenIDClient {

    public static final Logger logger = Logger.getLogger(DefaultOpenIDClient.class);
    private ObjectStoreHelper objectStoreHelper;

    public DefaultOpenIDClient(ObjectStoreHelper objectStoreHelper) {
        setObjectStoreHelper(objectStoreHelper);
    }

    /**
     * This method starts the OpenID auth mechanism. The provider will return the information to OPENID_RETURN_URL
     * @return url to redirect the user
     */
    @Override
    public String initialize(String providerUrl, String returnUrl, boolean verifyResponse)
            throws ObjectStoreException {

        final List<DiscoveryInformation> discoveries = new ArrayList<DiscoveryInformation>();
        final ConsumerManager manager = new ConsumerManager();

        manager.setAssociations(new InMemoryConsumerAssociationStore());
        manager.setNonceVerifier(new InMemoryNonceVerifier(5000));
        manager.setMinAssocSessEnc(AssociationSessionType.DH_SHA256);

        DiscoveryInformation discovered;

        try {
            logger.info("OpenID Provider URL = "
                    + providerUrl);
            discovered = new DiscoveryInformation(new URL(
                    providerUrl));
        } catch (DiscoveryException e) {
            throw new OpenIdException(e);
        } catch (MalformedURLException me) {
            throw new OpenIdException(me);
        }

        discoveries.add(discovered);

        final DiscoveryInformation discoveryInfo = manager
                .associate(discoveries);

        final FetchRequest fetch = FetchRequest.createFetchRequest();

        try {
            fetch.addAttribute("FirstName",
                    "http://axschema.org/namePerson/first", true);
            fetch.addAttribute("LastName",
                    "http://axschema.org/namePerson/last", true);
            fetch.addAttribute("Email", "http://axschema.org/contact/email",
                    true);
            fetch.addAttribute("RealmId", "http://axschema.org/intuit/realmId",
                    true);
        } catch (MessageException e) {
            throw new OpenIdException(e);
        }

        fetch.setCount("Email", 3);

        AuthRequest authReq;
        logger.info("openIdReturnUrl = " + returnUrl);
        try {
            authReq = manager.authenticate(discoveryInfo,
                    returnUrl);
            authReq.addExtension(fetch);
        } catch (MessageException e) {
            throw new OpenIdException(e);
        } catch (ConsumerException e) {
            throw new OpenIdException(e);
        }
        logger.info("authReq.getDestinationUrl: "
                + authReq.getDestinationUrl(true));

        if (verifyResponse) {
            logger.info("Storing OpenID manager information using key: " + authReq.getHandle());
            getObjectStoreHelper().store(authReq.getHandle(), new OpenIDManager(manager, discoveryInfo), true);
        }

        return authReq.getDestinationUrl(true);
    }

    /**
     * This method receives the callback from OpenID provider
     *
     * @param receivingUrl url from OpenID provider response
     * @param params parameters returned from OpenIdProvider response
     * @return true if openIdFromIntuit was verified
     */
    @Override
    public OpenIDCredentials verifyOpenIDFromIntuit(String receivingUrl, Map<String, String> params,
                                                    boolean verifyResponse)
            throws MessageException, ObjectStoreException {
        OpenIDCredentials credentials = new OpenIDCredentials();
        if (verifyResponse) {
            final Identifier identifier = verifyResponse(receivingUrl, params);
            logger.debug("OpenID identifier:"
                + ((identifier == null) ? "null" : identifier.getIdentifier()));
        }

        credentials.setIdentity(params.get("openid.identity"));
        credentials.setFirstName(params.get("openid.alias3.value.alias1"));
        credentials.setLastName(params.get("openid.alias3.value.alias2"));
        credentials.setEmail(params.get("openid.alias3.value.alias3"));
        credentials.setRealmId(params.get("openid.alias3.value.alias4"));

        logger.debug("openid.identity: " + credentials.getIdentity());
        logger.debug("openid.alias3.value.alias1: " + credentials.getFirstName());
        logger.debug("openid.alias3.value.alias2: " + credentials.getLastName());
        logger.debug("openid.alias3.value.alias3: " + credentials.getEmail());
        logger.debug("openid.alias3.value.alias4: " + credentials.getRealmId());

        logger.info("VerifyOpenIDFromIntuit completed");

        return credentials;
    }

    /**
     * Verify OpenID response
     *
     * @param receivingUrl url from OpenID provider
     * @param params map with response parameters
     * @return openId identifier
     */
    public Identifier verifyResponse(String receivingUrl, Map<String, String> params) throws MessageException,
            ObjectStoreException {
        Identifier verified;
        try {

            final ParameterList response = new ParameterList(params);
            logger.debug("Retrieving OpenID manager information using key: " + params.get("openid.assoc_handle"));
            OpenIDManager openIdManager = (OpenIDManager) getObjectStoreHelper().retrieve(params.get("openid.assoc_handle"));
            logger.debug("ReceivingUrl: " + receivingUrl);

            final DiscoveryInformation discovered = openIdManager.getDiscovery();

            // Extract the receiving URL from the HTTP request.
            // Verify the response.  Note that ConsumerManager needs to be the same
            // instance used to place the authentication request.
            final ConsumerManager manager = openIdManager.getManager();
            final VerificationResult verification = manager.verify(receivingUrl, response, discovered);

            // Examine the verification result and extract the verified
            // identifier.
            verified = verification.getVerifiedId();
            if (verified != null) {
                final AuthSuccess authSuccess = (AuthSuccess) verification
                        .getAuthResponse();

                if (authSuccess.hasExtension(AxMessage.OPENID_NS_AX)) {
                    FetchResponse fetchResp = (FetchResponse) authSuccess
                            .getExtension(AxMessage.OPENID_NS_AX);
                    logger.debug(fetchResp.getAttributeValue("FirstName"));
                    logger.debug(fetchResp.getAttributeValue("LastName"));
                    logger.debug(fetchResp.getAttributeValue("FullName"));
                    logger.debug(fetchResp.getAttributeValue("RealmID"));
                }

                //Verified is ok
                return verified;
            }
        } catch (OpenIDException e) {
            throw new org.mule.modules.quickbooks.api.openid.OpenIdException("OpenIDException caught in verifyResponse: "
                    + e.toString());
        }

        logger.error("OpenID verified is null. Verification failed.");
        return null;
    }

    public ObjectStoreHelper getObjectStoreHelper() {
        return objectStoreHelper;
    }

    public void setObjectStoreHelper(ObjectStoreHelper objectStoreHelper) {
        this.objectStoreHelper = objectStoreHelper;
    }
}
