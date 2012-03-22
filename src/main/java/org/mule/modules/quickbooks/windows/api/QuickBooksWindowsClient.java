package org.mule.modules.quickbooks.windows.api;

import org.mule.modules.quickbooks.online.OnlineEntityType;
import org.mule.modules.quickbooks.windows.schema.CdmBase;
import org.mule.modules.quickbooks.windows.schema.IdType;

public interface QuickBooksWindowsClient
{
    Object create(final String realmId, final String appKey, 
                   final String realmIdPseudonym, final String authIdPseudonym,
                   Object obj, String requestId, Boolean draft, Boolean fullResponse);
    
    <T extends CdmBase> T getObject(final String realmId, final String appKey, final String realmIdPseudonym, final String authIdPseudonym, final OnlineEntityType type, final IdType id);
    
    <T extends CdmBase> T update(final String realmId, final String appKey, final String realmIdPseudonym, final String authIdPseudonym, final OnlineEntityType type, T obj);
    
    <T extends CdmBase> void deleteObject(final String realmId, final String appKey, final String realmIdPseudonym, final String authIdPseudonym, final OnlineEntityType type, final IdType id, String syncToken);

    <T extends CdmBase> Iterable<T> findObjects(final String realmId, final String appKey, final String realmIdPseudonym, final String authIdPseudonym, final OnlineEntityType type, final String queryFilter, final String querySort);
}
