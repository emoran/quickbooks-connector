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
import org.mule.modules.quickbooks.online.automation.QuickBooksOnlineTestParent;

import com.intuit.ipp.data.Customer;

public class UpdateCustomerWithNullSyncTokenTestCases extends QuickBooksOnlineTestParent {
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
		Customer customer = new Customer();
		
		customer.setId(createdCustomer.getId());
		customer.setGivenName("GivenNameUpdated");
		customer.setMiddleName("MiddleNameUpdated");
		customer.setFamilyName("FamilyNameUpdated");
		customer.setContactName("ContactNameUpdated");
		
		upsertPayloadContentOnTestRunMessage(customer);
    	Customer updatedCustomer = runFlowAndGetPayload("UpdateCustomer");
    	
    	Integer syncToken = new Integer(createdCustomer.getSyncToken()) + 1; 
    	
    	assertEquals(syncToken.toString(), updatedCustomer.getSyncToken());
    	assertEquals(customer.getGivenName(), updatedCustomer.getGivenName());
    	assertEquals(customer.getMiddleName(), updatedCustomer.getMiddleName());
    	assertEquals(customer.getFamilyName(), updatedCustomer.getFamilyName());
	}
	
	@After
	public void tearDown() throws Exception {
		createdCustomer.setActive(false);
		upsertPayloadContentOnTestRunMessage(createdCustomer);
		runFlowAndGetPayload("UpdateCustomer");
	}

}
