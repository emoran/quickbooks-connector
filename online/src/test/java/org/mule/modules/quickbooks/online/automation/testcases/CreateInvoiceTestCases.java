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
import com.intuit.ipp.data.ReferenceType;

public class CreateInvoiceTestCases extends InvoiceTestCases {
	private Item createdItem;
	private Customer createdCustomer;
	private Invoice createdInvoice;
	
	@Before
    public void setUp() throws Exception {
		createdItem = this.createDefaultItemInQBO();
		createdCustomer = this.createDefaultCustomerInQBO();
    }
	
	@Category({RegressionTests.class})
	@Test
	public void createInvoice() throws Exception {
		ReferenceType customerReference = new ReferenceType();
		customerReference.setValue(createdCustomer.getId());
		
		Invoice invoice = getBeanFromContext("invoiceObject");
		invoice.setLine(this.createInvoiceLineList(createdItem));
		invoice.setCustomerRef(customerReference);
		
		upsertPayloadContentOnTestRunMessage(invoice);
		createdInvoice = runFlowAndGetPayload("CreateInvoice");

		assertEquals(createdInvoice.getCustomerRef().getValue(), createdInvoice.getCustomerRef().getValue());
		
		assertEquals(invoice.getBillAddr().getLine1(), createdInvoice.getBillAddr().getLine1());
		assertEquals(invoice.getBillAddr().getCity(), createdInvoice.getBillAddr().getCity());
		assertEquals(invoice.getBillAddr().getCountrySubDivisionCode(), createdInvoice.getBillAddr().getCountrySubDivisionCode());
		assertEquals(invoice.getBillAddr().getCountry(), createdInvoice.getBillAddr().getCountry());
		assertEquals(invoice.getBillAddr().getPostalCode(), createdInvoice.getBillAddr().getPostalCode());
		
		assertEquals(invoice.getLine().get(0).getAmount(), createdInvoice.getLine().get(0).getAmount());
		assertEquals(invoice.getLine().get(0).getDetailType(), createdInvoice.getLine().get(0).getDetailType());
		assertEquals(invoice.getLine().get(0).getSalesItemLineDetail().getQty(), createdInvoice.getLine().get(0).getSalesItemLineDetail().getQty());
	}
	
	@After
	public void tearDown() throws Exception {
		this.deleteInvoiceInQBO(createdInvoice);
		this.disableItemInQBO(createdItem);
		this.disableCustomerInQBO(createdCustomer);
	}

}
