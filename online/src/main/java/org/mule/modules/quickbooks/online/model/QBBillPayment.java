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

import org.mule.modules.quickbooks.online.schema.BillPayment;

/**
 * 
 * Wrapper class for QB online BillPayment
 * 
 * 
 * @author Mulesoft, inc
 *
 */
public class QBBillPayment {
    
    private BillPayment billPayment;
    
    public QBBillPayment() {

    }
    
    public QBBillPayment (BillPayment billPayment) {
        this.setBillPayment(billPayment);
    }

    public BillPayment getBillPayment() {
        return billPayment;
    }

    public void setBillPayment(BillPayment billPayment) {
        this.billPayment = billPayment;
    }
}
