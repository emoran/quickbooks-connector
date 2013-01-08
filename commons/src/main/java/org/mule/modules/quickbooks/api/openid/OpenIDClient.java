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

import org.mule.api.store.ObjectStoreException;
import org.openid4java.message.MessageException;

import java.util.Map;

/**
 * Interface for Intuit OpenID
 *
 * @author Mulesoft, Inc
 */
public interface OpenIDClient {

    public String initialize(String providerUrl, String returnUrl, boolean verifyResponse)
            throws ObjectStoreException;

    OpenIDCredentials verifyOpenIDFromIntuit(String receivingUrl, Map<String, String> params, boolean verifyResponse)
            throws MessageException, ObjectStoreException;
}
