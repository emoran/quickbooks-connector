/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.windows.api;

import java.util.List;

import org.mule.modules.quickbooks.api.oauth.OAuthCredentials;
import org.mule.modules.quickbooks.windows.WindowsEntityType;
import org.mule.modules.quickbooks.windows.schema.IdType;
import org.mule.modules.quickbooks.windows.schema.UserInformation;

public interface QuickBooksWindowsClient
{
	Object blueDotMenu(final OAuthCredentials credentials);
	
    Object create(final OAuthCredentials credentials,
                   final WindowsEntityType type, Object obj, final String requestId, 
                   final Boolean draft, final Boolean fullResponse);
    
    Object getObject(final OAuthCredentials credentials,
                     final WindowsEntityType type, final IdType id);
    
    Object update(final OAuthCredentials credentials,
                  final WindowsEntityType type, Object obj,
                  final String requestId, final Boolean draft, final Boolean fullResponse);
    
    void delete(final OAuthCredentials credentials,
                final WindowsEntityType type, Object obj, final String requestId);

    Iterable findObjects(final OAuthCredentials credentials,
                         final WindowsEntityType type, final Object query);
    
    Iterable findObjectsGetPages(final OAuthCredentials credentials,
            				final WindowsEntityType type, final Object query);
    
    void revert(final OAuthCredentials credentials,
    		final WindowsEntityType type, Object obj, final String requestId);
    
    Object retrieveWithoutUsingQueryObjects(final OAuthCredentials credentials,
                  final Object syncStatusRequest, final String objectName);
    
    String generateARequestId();
    
    UserInformation getCurrentUserInformation(final OAuthCredentials credentials);
    
    boolean disconnect(OAuthCredentials credentials);

    OAuthCredentials reconnect(OAuthCredentials credentials);    
    
    Object get(final OAuthCredentials credentials, WindowsEntityType type);
}
