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

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Class used for retrieving reconnect response from Intuit Platform
 * 
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReconnectResponse", namespace = "http://platform.intuit.com/api/v1")
@XmlRootElement
public class ReconnectResponse implements Serializable
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @XmlElement(name = "ServerTime", namespace = "http://platform.intuit.com/api/v1")
    protected String serverTime;
    @XmlElement(name = "ErrorCode", namespace = "http://platform.intuit.com/api/v1")
    protected Integer errorCode;
    @XmlElement(name = "ErrorMessage", namespace = "http://platform.intuit.com/api/v1")
    protected String errorMessage;
    @XmlElement(name = "OAuthToken", namespace = "http://platform.intuit.com/api/v1")
    protected String accessToken;
    @XmlElement(name = "OAuthTokenSecret", namespace = "http://platform.intuit.com/api/v1")
    protected String accessTokenSecret;

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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }

    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }
}
