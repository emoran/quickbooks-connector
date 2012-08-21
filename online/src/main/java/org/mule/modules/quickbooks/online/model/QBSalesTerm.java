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

import org.mule.modules.quickbooks.online.schema.SalesTerm;

/**
 * 
 * Wrapper class for QB online SalesTerm
 * 
 * @author Mulesoft, inc
 *
 */
public class QBSalesTerm {

    private SalesTerm salesTerm;
    
    public QBSalesTerm() {

    }
    
    public QBSalesTerm(SalesTerm salesTerm) {
        this.setSalesTerm(salesTerm);
    }

    public SalesTerm getSalesTerm() {
        return salesTerm;
    }

    public void setSalesTerm(SalesTerm salesTerm) {
        this.salesTerm = salesTerm;
    }
}
