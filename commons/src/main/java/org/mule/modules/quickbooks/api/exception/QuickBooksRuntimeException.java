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

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *   Quickbook's runtime exception.
 *   
 * @author Gaston Ponti
 * @since Aug 30, 2011
 */

public class QuickBooksRuntimeException extends RuntimeException
{
/**
     * 
     */
    private static final long serialVersionUID = 1L;
    private ExceptionInfo info;
    
    /**
     * Creates the QuickBooksException.
     *
     * @param exceptionInfo
     */    
    public QuickBooksRuntimeException(final ExceptionInfo exceptionInfo)
    {
        super(ToStringBuilder.reflectionToString(exceptionInfo));
        this.info = exceptionInfo;
    }

    public QuickBooksRuntimeException(final ErrorInfo error)
    {
        super(ToStringBuilder.reflectionToString(error));
        this.info = null;
    }

    public boolean isAExpiredTokenFault()
    {
        return info != null && info.getCause().equals("SERVER") && info.getErrorCode().equals("401") && 
                info.getMessage().equals("Unauthorized OAuth Token: token_rejected");
    }

}

