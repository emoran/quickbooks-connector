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

import com.intuit.ipp.core.IEntity;
import com.intuit.ipp.data.CompanyInfo;


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
    
    <T extends IEntity> T update(final OAuthCredentials credentials, T obj);

    <T extends IEntity> void deleteObjectWithId(final OAuthCredentials credentials, IntuitEntityEnum type, final String id, String syncToken);
    
    void deleteObject(OAuthCredentials credentials, IEntity obj);
    
    CompanyInfo getCompanyInfo(final OAuthCredentials credentials);

    <T extends IEntity> Iterable<T> query(OAuthCredentials credentials, String query);

    <T extends IEntity> Iterable<T> paginatedQuery(OAuthCredentials credentials, String query, Integer resultsPerPage);
    
    UserInformation getCurrentUserInformation(OAuthCredentials credentials);

    BlueDotMenu getBlueDotInformation(OAuthCredentials credentials, String regex);

    boolean disconnect(OAuthCredentials credentials);

    OAuthCredentials reconnect(OAuthCredentials credentials);

	
}

