/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.online.automation;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.Timeout;
import org.mule.api.store.ObjectStore;
import org.mule.modules.quickbooks.api.oauth.OAuthCredentials;
import org.mule.modules.tests.ConnectorTestCase;

public class QuickBooksOnlineTestParent extends ConnectorTestCase {

	@Rule
	public Timeout globalTimeout = new Timeout(600000);

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Before
    public void setUp() throws Exception {
    	ObjectStore objectStore = muleContext.getRegistry().lookupObject("_defaultInMemoryObjectStore");
    	
    	OAuthCredentials credentials = getBeanFromContext("oAuthCredentials");

    	if(objectStore.contains(credentials.getRealmId()))
			objectStore.remove(credentials.getRealmId());
    	objectStore.store(credentials.getRealmId(), credentials);
    }
    
    protected Map<String,Object> createMapPayloadForGetAndDelete(String type, String id) {
		Map<String,Object> map = new HashMap<String,Object>(); 
		map.put("type", type);
		map.put("id", id);
		return map;
	}
    
}
