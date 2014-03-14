/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.online.automation.testcases;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.modules.quickbooks.online.automation.QuickBooksOnlineTestParent;

import com.intuit.ipp.data.Customer;

public class GetCustomerTestCases extends QuickBooksOnlineTestParent {
	private Customer createdCustomer;
	
	@Before
    public void setUp() throws Exception {
		super.setUp();
		Customer customer = getBeanFromContext("customerObject"); 
		upsertPayloadContentOnTestRunMessage(customer);
		createdCustomer = runFlowAndGetPayload("CreateCustomer");
    }
	
	@Test
	public void test() throws Exception {
		upsertPayloadContentOnTestRunMessage(this.createCustomerPayload(createdCustomer));
    	Customer retrievedCustomer = runFlowAndGetPayload("GetCustomer");
    	
    	assertEquals(createdCustomer, retrievedCustomer);
	}
	
	private Map<String,Object> createCustomerPayload(Customer customer) {
		Map<String,Object> map = new HashMap<String,Object>(); 
		map.put("type", "CUSTOMER");
		map.put("id", customer.getId());
		return map;
	}
	
	@After
	public void tearDown() throws Exception {
		createdCustomer.setActive(false);
		upsertPayloadContentOnTestRunMessage(createdCustomer);
		runFlowAndGetPayload("UpdateCustomer");
	}

}
