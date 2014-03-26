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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.quickbooks.online.automation.QuickBooksOnlineTestParent;
import org.mule.modules.quickbooks.online.automation.RegressionTests;

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
	
	@Category({RegressionTests.class})
	@Test
	public void getCustomer() throws Exception {
		upsertPayloadContentOnTestRunMessage(this.createMapPayloadForGetAndDelete("CUSTOMER", createdCustomer.getId()));
    	Customer retrievedCustomer = runFlowAndGetPayload("GetObject");
    	
    	assertEquals(createdCustomer, retrievedCustomer);
	}
	
	@After
	public void tearDown() throws Exception {
		createdCustomer.setActive(false);
		upsertPayloadContentOnTestRunMessage(createdCustomer);
		runFlowAndGetPayload("UpdateCustomer");
	}

}
