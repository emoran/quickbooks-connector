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

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.api.MessagingException;
import org.mule.modules.quickbooks.api.exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.online.automation.QuickBooksOnlineTestParent;
import org.mule.modules.quickbooks.online.automation.RegressionTests;

import com.intuit.ipp.data.Customer;
import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.data.Item;
import com.intuit.ipp.data.Line;
import com.intuit.ipp.data.ReferenceType;

public class DeleteInvoiceTestCases extends QuickBooksOnlineTestParent {
	private Invoice createdInvoice;
	private Item createdItem;
	private Customer createdCustomer;
	
	@Before
    public void setUp() throws Exception {
		super.setUp();
		
		Item item = getBeanFromContext("itemObject"); 
		upsertPayloadContentOnTestRunMessage(item);
		createdItem = runFlowAndGetPayload("CreateItem");
		
		Line line = getBeanFromContext("lineObject");
		
		ReferenceType itemReference = new ReferenceType();
		itemReference.setValue(createdItem.getId());
		
		line.getSalesItemLineDetail().setItemRef(itemReference);

		List<Line> lineList = new ArrayList<Line>();
		lineList.add(line);
		
		Customer customer = getBeanFromContext("customerObject"); 
		upsertPayloadContentOnTestRunMessage(customer);
		createdCustomer = runFlowAndGetPayload("CreateCustomer");
		
		ReferenceType customerReference = new ReferenceType();
		customerReference.setValue(createdCustomer.getId());
		
		Invoice invoice = getBeanFromContext("invoiceObject");
		invoice.setLine(lineList);
		invoice.setCustomerRef(customerReference);
		
		upsertPayloadContentOnTestRunMessage(invoice);
		createdInvoice = runFlowAndGetPayload("CreateInvoice");
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
		createdItem.setActive(false);
		upsertPayloadContentOnTestRunMessage(createdItem);
		runFlowAndGetPayload("UpdateItem");
		
		createdCustomer.setActive(false);
		upsertPayloadContentOnTestRunMessage(createdCustomer);
		runFlowAndGetPayload("UpdateCustomer");
	}

}
