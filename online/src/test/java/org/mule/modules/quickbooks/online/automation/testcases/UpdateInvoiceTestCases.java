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
import org.mule.modules.quickbooks.online.automation.RegressionTests;

import com.intuit.ipp.data.Customer;
import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.data.Item;

public class UpdateInvoiceTestCases extends InvoiceTestCases {
	private Invoice createdInvoice;
	private Item createdItem;
	private Customer createdCustomer;
	
	@Before
    public void setUp() throws Exception {
		createdItem = this.createDefaultItemInQBO();
		createdCustomer = this.createDefaultCustomerInQBO();
		createdInvoice = this.createInvoiceInQBO(createdCustomer, createdItem);
    }
	
	@Category({RegressionTests.class})
	@Test
	public void updateInvoice() throws Exception {
		createdInvoice.getBillAddr().setLine1("ChangedAddressLine");
		createdInvoice.getBillAddr().setCountrySubDivisionCode("ChangedCountrySubDivisionCode");
		
		upsertPayloadContentOnTestRunMessage(this.createdInvoice);
    	Invoice updatedInvoice = runFlowAndGetPayload("UpdateInvoice");
    	
    	assertEquals("1", updatedInvoice.getSyncToken());
    	assertEquals(createdInvoice.getBillAddr().getLine1(), updatedInvoice.getBillAddr().getLine1());
    	assertEquals(createdInvoice.getBillAddr().getCountrySubDivisionCode(), updatedInvoice.getBillAddr().getCountrySubDivisionCode());
	}
	
	@Category({RegressionTests.class})
	@Test
	public void updateInvoiceWithNullSyncToken() throws Exception {
		createdInvoice.setSyncToken(null);
		this.updateInvoice();
	}
	
	@After
	public void tearDown() throws Exception {
		this.deleteInvoiceInQBO(createdInvoice);
		this.disableItemInQBO(createdItem);
		this.disableCustomerInQBO(createdCustomer);
	}
	
}
