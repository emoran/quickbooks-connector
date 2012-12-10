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

/**
 * Quickbooks Access Token Expiration Exception
 *   
 * @author Mulesoft Inc
 */

@SuppressWarnings("unused")
public class QuickBooksExpiredTokenException extends RuntimeException
{
/**
     *
     */
    private static final long serialVersionUID = 1L;
    public QuickBooksExpiredTokenException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public QuickBooksExpiredTokenException(Throwable cause) {
        super(cause);
    }

    public QuickBooksExpiredTokenException(String exceptionMessage, Throwable cause) {
        super(exceptionMessage, cause);
    }



}

