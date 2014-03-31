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
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.quickbooks.online.automation.QuickBooksOnlineTestParent;
import org.mule.modules.quickbooks.online.automation.RegressionTests;

import com.intuit.ipp.data.Customer;

public class CreateCustomerTestCases extends QuickBooksOnlineTestParent {
	private Customer createdCustomer;
	
	@Category({RegressionTests.class})
	@Test
	public void createCustomer() throws Exception {
		Customer customer = getBeanFromContext("customerObject"); 
		createdCustomer = this.createCustomerInQBO(customer);
		
		assertNotNull(createdCustomer);
		assertEquals(customer.getGivenName(), createdCustomer.getGivenName());
		assertEquals(customer.getMiddleName(), createdCustomer.getMiddleName());
		assertEquals(customer.getFamilyName(), createdCustomer.getFamilyName());
		assertEquals(customer.isTaxable(), createdCustomer.isTaxable());
	}
	
	@After
	public void tearDown() throws Exception {
		this.disableCustomerInQBO(createdCustomer);
	}

}
