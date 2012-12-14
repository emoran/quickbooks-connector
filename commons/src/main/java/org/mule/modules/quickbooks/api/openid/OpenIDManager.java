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

import org.openid4java.consumer.ConsumerManager;
import org.openid4java.discovery.DiscoveryInformation;

import java.io.Serializable;

/**
 * POJO for OpenID manager and discovery objects
 *
 * @author Mulesoft, Inc
 */
public class OpenIDManager implements Serializable {

    private ConsumerManager manager;
    private DiscoveryInformation discovery;

    public OpenIDManager(ConsumerManager manager, DiscoveryInformation discovery) {
        setManager(manager);
        setDiscovery(discovery);
    }

    public ConsumerManager getManager() {
        return manager;
    }

    public void setManager(ConsumerManager manager) {
        this.manager = manager;
    }

    public DiscoveryInformation getDiscovery() {
        return discovery;
    }

    public void setDiscovery(DiscoveryInformation discovery) {
        this.discovery = discovery;
    }
}
