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

import org.mule.modules.quickbooks.windows.WindowsEntityType;
import org.mule.modules.quickbooks.windows.schema.IdType;

public interface QuickBooksWindowsClient
{
    Object create(final String realmId, final String appKey, 
                   final String realmIdPseudonym, final String authIdPseudonym,
                   Object obj, final String requestId, 
                   final Boolean draft, final Boolean fullResponse);
    
    Object getObject(final String realmId, final String appKey, 
                     final String realmIdPseudonym, final String authIdPseudonym, 
                     final WindowsEntityType type, final IdType id);
    
    Object update(final String realmId, final String appKey, 
                  final String realmIdPseudonym, final String authIdPseudonym,
                  final WindowsEntityType type, Object obj,
                  final String requestId, final Boolean draft, final Boolean fullResponse);
    
    void delete(final String realmId, final String appKey, 
                final String realmIdPseudonym, final String authIdPseudonym, 
                final WindowsEntityType type, Object obj, final String requestId);

    Iterable findObjects(final String realmId, final String appKey, 
                         final String realmIdPseudonym, final String authIdPseudonym, 
                         final WindowsEntityType type, final Object query);
}
