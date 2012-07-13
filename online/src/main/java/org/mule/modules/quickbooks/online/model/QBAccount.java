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

import org.mule.modules.quickbooks.online.schema.Account;

/**
 * 
 * Wrapper class for QB online Account
 * 
 * @author Mulesoft, inc
 *
 */
public class QBAccount {

    private Account account;
    
    public QBAccount() {
        
    }
    
    public QBAccount(Account account) {
        this.setAccount(account);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
