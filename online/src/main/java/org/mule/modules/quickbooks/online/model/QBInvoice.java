/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.online.model;

import org.mule.modules.quickbooks.online.schema.Invoice;

/**
 * 
 * Wrapper class for QB online Invoice
 * 
 * @author Mulesoft, inc
 *
 */
public class QBInvoice {

    private Invoice invoice;
    
    public QBInvoice() {

    }
    
    public QBInvoice(Invoice invoice) {
        this.setInvoice(invoice);
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
    
}
