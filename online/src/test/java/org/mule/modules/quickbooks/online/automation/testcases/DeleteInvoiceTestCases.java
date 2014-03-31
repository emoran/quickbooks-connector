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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MessagingException;
import org.mule.modules.quickbooks.api.exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.online.automation.RegressionTests;

public class DeleteInvoiceTestCases extends InvoiceTestCases {

	@Before
    public void setUp() throws Exception {
		createdItem = this.createDefaultItemInQBO();
		createdCustomer = this.createDefaultCustomerInQBO();
		createdInvoice = this.createInvoiceInQBO(createdCustomer, createdItem);
	}
	
	@Category({RegressionTests.class})
	@Test
	public void deleteInvoice() throws Exception {
		assertNotNull(createdInvoice);
		
		upsertPayloadContentOnTestRunMessage(createdInvoice);
		runFlowAndGetPayload("DeleteObject");
		
		this.checkInexistentInvoice();
	}
	
	@Category({RegressionTests.class})
	@Test
	public void deleteInvoiceWithId() throws Exception {
		assertNotNull(createdInvoice);
		
		upsertPayloadContentOnTestRunMessage(this.createMapPayloadForGetAndDelete("INVOICE",createdInvoice.getId()));
		runFlowAndGetPayload("DeleteObjectWithId");
		
		this.checkInexistentInvoice();
	}
	
	private void checkInexistentInvoice() throws Exception {
		try {
			upsertPayloadContentOnTestRunMessage(this.createMapPayloadForGetAndDelete("INVOICE",createdInvoice.getId()));
			runFlowAndGetPayload("GetObject");
		} catch(MessagingException e) {
			QuickBooksRuntimeException qbe = (QuickBooksRuntimeException) e.getCause();
			assertTrue(qbe.getInfo().getErrorCode().equals("610"));
			assertTrue(qbe.getInfo().getCause().equals("Object Not Found"));
		}
	}
	
	@After
	public void tearDown() throws Exception {
		//The test tearDown attempts to delete the Invoice, even if the test is successful
		//If the test is successful the deletion will fail, but the tearDown will be completed
		try {
			this.deleteInvoiceInQBO(createdInvoice);
		} catch (Exception e) {}
		this.disableItemInQBO(createdItem);
		this.disableCustomerInQBO(createdCustomer);
	}

}
