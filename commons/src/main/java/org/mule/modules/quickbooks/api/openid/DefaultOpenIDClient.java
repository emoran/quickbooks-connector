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
import org.openid4java.association.AssociationSessionType;
import org.openid4java.consumer.*;
import org.openid4java.discovery.DiscoveryException;
import org.openid4java.discovery.DiscoveryInformation;
import org.openid4java.message.AuthRequest;
import org.openid4java.message.MessageException;
import org.openid4java.message.ax.FetchRequest;

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

    public DefaultOpenIDClient() {
    }

    /**
     * This method starts the OpenID auth mechanism. The provider will return the information to OPENID_RETURN_URL
     * @return url to redirect the user
     */
    @Override
    public String initialize(String providerUrl, String returnUrl) {

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

        return authReq.getDestinationUrl(true);
    }

    /**
     * This method receives the callback from OpenID provider
     *
     * @param params parameters returned from OpenIdProvider response
     * @return true if openIdFromIntuit was verified
     */
    @Override
    public OpenIDCredentials verifyOpenIDFromIntuit(Map<String, String> params) {
        OpenIDCredentials credentials = new OpenIDCredentials();

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

        logger.debug("VerifyOpenIDFromIntuit completed");

        return credentials;
    }
}
