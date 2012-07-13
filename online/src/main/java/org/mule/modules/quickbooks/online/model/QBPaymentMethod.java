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

import org.mule.modules.quickbooks.online.schema.PaymentMethod;

/**
 * 
 * Wrapper class for QB online PaymentMethod
 * 
 * @author Mulesoft, inc
 *
 */
public class QBPaymentMethod {

    private PaymentMethod paymentMethod;
    
    public QBPaymentMethod() {

    }
    
    public QBPaymentMethod(PaymentMethod paymentMethod) {
        this.setPaymentMethod(paymentMethod);
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
