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
import org.mule.modules.quickbooks.online.schema.FaultInfo;
import org.mule.modules.quickbooks.windows.schema.ErrorResponse;


/**
 *   Quickbook's runtime exception.
 *   
 * @author Gaston Ponti
 * @since Aug 30, 2011
 */

public class QuickBooksRuntimeException extends RuntimeException
{
    private final FaultInfo fault;
    
    /**
     * Creates the QuickBooksException.
     *
     * @param fault
     */
    public QuickBooksRuntimeException(final FaultInfo fault)
    {
        super(ToStringBuilder.reflectionToString(fault));
        this.fault = fault;
    }
    
    public QuickBooksRuntimeException(ErrorResponse error)
    {
        super(ToStringBuilder.reflectionToString(error));
        this.fault = null;
    }
    
    public boolean isAExpiredTokenFault()
    {
        return fault != null && fault.getCause().equals("SERVER") && fault.getErrorCode().equals("401") && fault.getMessage().equals("Unauthorized OAuth Token: token_rejected");
    }

}

