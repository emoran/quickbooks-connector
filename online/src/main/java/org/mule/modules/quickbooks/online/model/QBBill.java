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

import org.mule.modules.quickbooks.online.schema.Bill;

/**
 * 
 * Wrapper class for QB online Bill
 * 
 * @author Mulesoft, inc
 *
 */
public class QBBill {

    private Bill bill;
    
    public QBBill() {

    }
    
    public QBBill(Bill bill) {
        this.setBill(bill);
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
    
}
