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

import org.mule.modules.quickbooks.online.schema.CashPurchase;

/**
 * 
 * Wrapper class for QB online CashPurchase
 * 
 * @author Mulesoft, inc
 *
 */
public class QBCashPurchase {

    private CashPurchase cashPurchase;
    
    public QBCashPurchase() {

    }
    
    public QBCashPurchase(CashPurchase cashPurchase) {
        this.setCashPurchase(cashPurchase);
    }

    public CashPurchase getCashPurchase() {
        return cashPurchase;
    }

    public void setCashPurchase(CashPurchase cashPurchase) {
        this.cashPurchase = cashPurchase;
    }
}
