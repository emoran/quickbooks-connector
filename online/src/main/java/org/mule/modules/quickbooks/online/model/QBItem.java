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

import org.mule.modules.quickbooks.online.schema.Item;

/**
 * 
 * Wrapper class for QB online Item
 * 
 * @author Mulesoft, inc
 *
 */
public class QBItem {

    private Item item;
    
    public QBItem() {

    }
    
    public QBItem(Item item) {
        this.setItem(item);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
