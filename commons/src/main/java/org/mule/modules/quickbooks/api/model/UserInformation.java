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
import javax.xml.bind.annotation.XmlType;

/**
 * Class used for retrieving user information
 * 
 **/

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserInformation", namespace = "http://platform.intuit.com/api/v1")
public class UserInformation implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @XmlElement(name = "Id", namespace = "http://platform.intuit.com/api/v1")
    protected String id;
    @XmlElement(name = "FirstName", namespace = "http://platform.intuit.com/api/v1")
    protected String firstName;
    @XmlElement(name = "LastName", namespace = "http://platform.intuit.com/api/v1")
    protected String lastName;
    @XmlElement(name = "EmailAddress", namespace = "http://platform.intuit.com/api/v1")
    protected String emailAddress;
    @XmlElement(name = "IsVerified", namespace = "http://platform.intuit.com/api/v1")
    protected Boolean isVerified;
    @XmlElement(name = "ScreenName", namespace = "http://platform.intuit.com/api/v1")
    protected String screenName;

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public Boolean getIsVerified() {
        return isVerified;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getScreenName() {
        return screenName;
    }
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }
}
