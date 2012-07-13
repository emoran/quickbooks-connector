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

import org.mule.modules.quickbooks.online.schema.Check;

/**
 * 
 * Wrapper class for QB online Check
 * 
 * @author Mulesoft, inc
 *
 */
public class QBCheck {

    private Check check;
    
    public QBCheck() {

    }
    
    public QBCheck (Check check) {
        this.setCheck(check);
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }
}
