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

import org.mule.modules.quickbooks.online.schema.Vendor;

/**
 * 
 * Wrapper class for QB online Vendor
 * 
 * @author Mulesoft, inc
 *
 */
public class QBVendor {

    private Vendor vendor;
    
    public QBVendor() {

    }
    
    public QBVendor(Vendor vendor) {
        this.setVendor(vendor);
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
