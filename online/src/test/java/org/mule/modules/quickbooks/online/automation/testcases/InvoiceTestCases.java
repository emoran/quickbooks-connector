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

import java.util.ArrayList;
import java.util.List;

import org.mule.modules.quickbooks.online.automation.QuickBooksOnlineTestParent;

import com.intuit.ipp.data.Customer;
import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.data.Item;
import com.intuit.ipp.data.Line;
import com.intuit.ipp.data.ReferenceType;

public abstract class InvoiceTestCases extends QuickBooksOnlineTestParent {
	protected Item createdItem;
	protected Customer createdCustomer;
	protected Invoice createdInvoice;
	
    protected Line createInvoiceLine(Item item) throws Exception{
    	Line line = getBeanFromContext("lineObject");
    	
    	ReferenceType itemReference = new ReferenceType();
    	itemReference.setValue(item.getId());
    	line.getSalesItemLineDetail().setItemRef(itemReference);

    	return line;
    }
    
    protected List<Line> createInvoiceLineList(Item item) throws Exception {
    	List<Line> lineList = new ArrayList<Line>();
    	lineList.add(this.createInvoiceLine(item));
    	return lineList;
    }
    
    protected Invoice createInvoiceInQBO(Customer customer, Item item) throws Exception {
    	ReferenceType customerReference = new ReferenceType();
		customerReference.setValue(customer.getId());
		
		Invoice invoice = getBeanFromContext("invoiceObject");
		invoice.setLine(this.createInvoiceLineList(item));
		invoice.setCustomerRef(customerReference);
		
		upsertPayloadContentOnTestRunMessage(invoice);
		return runFlowAndGetPayload("CreateInvoice");
    }
    
    protected void deleteInvoiceInQBO(Invoice invoice) throws Exception {
    	upsertPayloadContentOnTestRunMessage(invoice);
    	runFlowAndGetPayload("DeleteObject");
    }
    
}
