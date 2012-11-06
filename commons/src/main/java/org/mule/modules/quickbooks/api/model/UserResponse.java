/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.api.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Class used for retrieving user information
 * 
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserResponse", namespace = "http://platform.intuit.com/api/v1")
@XmlRootElement
public class UserResponse implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    @XmlElement(name = "User", namespace = "http://platform.intuit.com/api/v1")
    protected UserInformation user;
    @XmlElement(name = "ServerTime", namespace = "http://platform.intuit.com/api/v1")
    protected String serverTime;
    @XmlElement(name = "ErrorCode", namespace = "http://platform.intuit.com/api/v1")
    protected Integer errorCode;
    
    
    public String getServerTime() {
        return serverTime;
    }
    
    public Integer getErrorCode() {
        return errorCode;
    }
    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public UserInformation getUser() {
        return user;
    }

    public void setUser(UserInformation user) {
        this.user = user;
    }
}
