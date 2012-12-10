/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.api.openid;

/**
 * OpenID Exception
 *  
 */
@SuppressWarnings("unused")
public class OpenIdException extends RuntimeException {

    private static final long serialVersionUID = -6610171710776228369L;
    
    public OpenIdException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public OpenIdException(Throwable cause) {
        super(cause);
    }

    public OpenIdException(String exceptionMessage, Throwable cause) {
        super(exceptionMessage, cause);
    }
}
