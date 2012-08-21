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

import org.mule.modules.quickbooks.online.schema.Estimate;

/**
 * 
 * Wrapper class for QB online Estimate
 * 
 * @author Mulesoft, inc
 *
 */
public class QBEstimate {

    private Estimate estimate;
    
    public QBEstimate() {

    }
    
    public QBEstimate (Estimate estimate) {
        this.setEstimate(estimate);
    }

    public Estimate getEstimate() {
        return estimate;
    }

    public void setEstimate(Estimate estimate) {
        this.estimate = estimate;
    }
    
}
