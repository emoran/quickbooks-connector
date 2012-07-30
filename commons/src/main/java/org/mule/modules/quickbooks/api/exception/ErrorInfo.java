/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.api.exception;

import java.math.BigInteger;

import org.mule.modules.utils.MuleSoftException;

public class ErrorInfo {

    private String errorDesc;
    private BigInteger errorCode;
    private String dbErrorCode;
    
    public ErrorInfo() {
    }
    
    public ErrorInfo(Object exception) {
        try {
            this.errorDesc = (String) exception.getClass().getMethod("getErrorDesc").invoke(exception);
            this.errorCode = (BigInteger) exception.getClass().getMethod("getErrorCode").invoke(exception);
            this.dbErrorCode = (String) exception.getClass().getMethod("getDBErrorCode").invoke(exception);
        } catch (Exception e) {
            throw MuleSoftException.soften(e);
        }
    }

    public String getCause() {
        return errorDesc;
    }

    public void setCause(String cause) {
        this.errorDesc = cause;
    }

    public BigInteger getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(BigInteger errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return dbErrorCode;
    }

    public void setMessage(String message) {
        this.dbErrorCode = message;
    }
}
