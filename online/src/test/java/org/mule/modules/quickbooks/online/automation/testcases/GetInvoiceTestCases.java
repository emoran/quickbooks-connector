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

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.quickbooks.online.automation.QuickBooksOnlineTestParent;
import org.mule.modules.quickbooks.online.automation.RegressionTests;

import com.intuit.ipp.data.Customer;
import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.data.Item;
import com.intuit.ipp.data.Line;
import com.intuit.ipp.data.ReferenceType;

public class GetInvoiceTestCases extends QuickBooksOnlineTestParent {
	private Invoice createdInvoice;
	private Item createdItem;
	private Customer createdCustomer;
	
	@Before
    public void setUp() throws Exception {
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
	public void getInvoice() throws Exception {
		upsertPayloadContentOnTestRunMessage(this.createMapPayloadForGetAndDelete("INVOICE",createdInvoice.getId()));
    	Invoice retrievedInvoice = runFlowAndGetPayload("GetObject");
    	
    	assertEquals(createdInvoice, retrievedInvoice);
	}
	
	@After
	public void tearDown() throws Exception {
		upsertPayloadContentOnTestRunMessage(createdInvoice);
		runFlowAndGetPayload("DeleteObject");

		createdItem.setActive(false);
		upsertPayloadContentOnTestRunMessage(createdItem);
		runFlowAndGetPayload("UpdateItem");
		
		createdCustomer.setActive(false);
		upsertPayloadContentOnTestRunMessage(createdCustomer);
		runFlowAndGetPayload("UpdateCustomer");
	}

}
