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

import org.mule.modules.utils.MuleSoftException;

public class ExceptionInfo {

    private String cause;
    private String errorCode;
    private String message;
    
    public ExceptionInfo() {
    }
    
    public ExceptionInfo(Object exception) {
        try {
            this.cause = (String) exception.getClass().getMethod("getCause").invoke(exception);
            this.errorCode = (String) exception.getClass().getMethod("getErrorCode").invoke(exception);
            this.message = (String) exception.getClass().getMethod("getMessage").invoke(exception);
        } catch (Exception e) {
            throw MuleSoftException.soften(e);
        }
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
