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

public class UpdateCustomerTestCases extends QuickBooksOnlineTestParent {
	private Customer createdCustomer;
	
	@Before
    public void setUp() throws Exception {
		createdCustomer = this.createDefaultCustomerInQBO();
    }
	
	@Category({RegressionTests.class})
	@Test
	public void updateCustomer() throws Exception {
		createdCustomer.setGivenName("GivenNameUpdated");
		createdCustomer.setMiddleName("MiddleNameUpdated");
		createdCustomer.setFamilyName("FamilyNameUpdated");
		createdCustomer.setContactName("ContactNameUpdated");
		
		upsertPayloadContentOnTestRunMessage(createdCustomer);
    	Customer updatedCustomer = runFlowAndGetPayload("UpdateCustomer");
    	
    	Integer syncToken = new Integer(createdCustomer.getSyncToken()) + 1; 
    	
    	assertEquals(syncToken.toString(), updatedCustomer.getSyncToken());
    	assertEquals(createdCustomer.getGivenName(), updatedCustomer.getGivenName());
    	assertEquals(createdCustomer.getMiddleName(), updatedCustomer.getMiddleName());
    	assertEquals(createdCustomer.getFamilyName(), updatedCustomer.getFamilyName());
	}
	
	@Category({RegressionTests.class})
	@Test
	public void updateCustomerWithNullSyncToken() throws Exception {
		createdCustomer.setSyncToken(null);
		this.updateCustomer();
	}
	
	@After
	public void tearDown() throws Exception {
		this.disableCustomerInQBO(createdCustomer);
	}

}
