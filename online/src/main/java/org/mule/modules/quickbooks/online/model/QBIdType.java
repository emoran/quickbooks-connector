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

/**
 * 
 * Wrapper class for QB online IdType
 * 
 * @author Mulesoft, inc
 *
 */
import org.mule.modules.quickbooks.online.schema.IdType;

public class QBIdType {

    private IdType idType;
    
    public QBIdType() {

    }
    
    public QBIdType(IdType idType) {
        this.setIdType(idType);
    }

    public IdType getIdType() {
        return idType;
    }

    public void setIdType(IdType idType) {
        this.idType = idType;
    }
}
