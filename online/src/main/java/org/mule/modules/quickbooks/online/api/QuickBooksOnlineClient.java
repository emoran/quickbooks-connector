/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.online.api;

import org.mule.modules.quickbooks.api.model.UserInformation;
import org.mule.modules.quickbooks.api.oauth.OAuthCredentials;
import org.mule.modules.quickbooks.online.OnlineEntityType;
import org.mule.modules.quickbooks.online.schema.CdmBase;
import org.mule.modules.quickbooks.online.schema.IdType;


/**
 *   
 * 
 * 
 * @author Gaston Ponti
 * @since Aug 19, 2011
 */

public interface QuickBooksOnlineClient
{
    <T extends CdmBase> T create(final OAuthCredentials credentials, T obj);
    
    <T extends CdmBase> T getObject(final OAuthCredentials credentials, final OnlineEntityType type, final IdType id);
    
    <T extends CdmBase> T update(final OAuthCredentials credentials, final OnlineEntityType type, T obj);
    
    <T extends CdmBase> void deleteObject(final OAuthCredentials credentials, final OnlineEntityType type, final IdType id, String syncToken);

    <T extends CdmBase> Iterable<T> findObjects(final OAuthCredentials credentials, final OnlineEntityType type, final String queryFilter, final String querySort);

    <T extends CdmBase> Iterable<T> findObjectsGetPages(OAuthCredentials credentials, OnlineEntityType type, String queryFilter, String querySort);
    
    <T extends Object> T get(OAuthCredentials credentials, OnlineEntityType type);
    
    UserInformation getCurrentUserInformation(OAuthCredentials credentials);

    String getCompanyBaseUri(OAuthCredentials credentials);

    String getBlueDotInformation(OAuthCredentials credentials);
}

