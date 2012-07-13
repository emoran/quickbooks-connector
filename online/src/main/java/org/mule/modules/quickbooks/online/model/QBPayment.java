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

import org.mule.modules.quickbooks.online.schema.Payment;

/**
 * 
 * Wrapper class for QB online Payment
 * 
 * @author Mulesoft, inc
 *
 */
public class QBPayment {

    private Payment payment;
    
    public QBPayment() {

    }
    
    public QBPayment(Payment payment) {
        this.setPayment(payment);
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
