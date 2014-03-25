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

import org.mule.modules.quickbooks.api.model.BlueDotMenu;
import org.mule.modules.quickbooks.api.model.UserInformation;
import org.mule.modules.quickbooks.api.oauth.OAuthCredentials;
import org.mule.modules.quickbooks.online.IntuitEntityEnum;
import org.mule.modules.quickbooks.online.OnlineEntityType;
import org.mule.modules.quickbooks.online.schema.CdmBase;

import com.intuit.ipp.core.IEntity;


/**
 *   
 * 
 * 
 * @author Gaston Ponti
 * @since Aug 19, 2011
 */

public interface QuickBooksOnlineClient
{
    <T extends IEntity> T create(final OAuthCredentials credentials, T obj);
    
    <T extends IEntity> T getObjectWithId(final OAuthCredentials credentials, final IntuitEntityEnum type, final String id);
    
    <T extends IEntity> T getCompanyInfo(final OAuthCredentials credentials);

    <T extends IEntity> T update(final OAuthCredentials credentials, T obj);
    
    <T extends IEntity> void deleteObjectWithId(final OAuthCredentials credentials, IntuitEntityEnum type, final String id, String syncToken);
    
    void deleteObject(OAuthCredentials credentials, IEntity obj);

    <T extends CdmBase> Iterable<T> findObjects(final OAuthCredentials credentials, final OnlineEntityType type, final String queryFilter, final String querySort);

    <T extends CdmBase> Iterable<T> findObjectsGetPages(OAuthCredentials credentials, OnlineEntityType type, String queryFilter, String querySort);
    
    UserInformation getCurrentUserInformation(OAuthCredentials credentials);

    boolean disconnect(OAuthCredentials credentials);

    OAuthCredentials reconnect(OAuthCredentials credentials);

    BlueDotMenu getBlueDotInformation(OAuthCredentials credentials, String regex);
}

