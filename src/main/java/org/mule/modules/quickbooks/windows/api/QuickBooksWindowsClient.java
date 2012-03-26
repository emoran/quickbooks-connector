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
