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

import org.mule.modules.quickbooks.online.schema.Customer;

/**
 * 
 * Wrapper class for QB online Customer
 * 
 * @author Mulesoft, inc
 *
 */
public class QBCustomer {
    
    private Customer customer;

    public QBCustomer() {

    }
    
    public QBCustomer(Customer customer){
        this.setCustomer(customer);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
