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

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.mule.modules.quickbooks.api.AbstractQuickBooksClient;
import org.mule.modules.quickbooks.api.QuickBooksConventions;
import org.mule.modules.quickbooks.api.exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.online.OnlineEntityType;
import org.mule.modules.quickbooks.online.objectfactory.QBOMessageUtils;
import org.mule.modules.quickbooks.online.schema.CdmBase;
import org.mule.modules.quickbooks.online.schema.IdType;
import org.mule.modules.quickbooks.online.schema.QboUser;
import org.mule.modules.quickbooks.online.schema.SearchResults;
import org.mule.modules.quickbooks.utils.MessageUtils;
import org.mule.modules.utils.MuleSoftException;
import org.mule.modules.utils.pagination.PaginatedIterable;

/**
 * 
 * @author Gaston Ponti
 * @since Aug 19, 2011
 */
public class DefaultQuickBooksOnlineClient extends AbstractQuickBooksClient implements QuickBooksOnlineClient
{   
    public DefaultQuickBooksOnlineClient(final String baseUri)
    {
        Validate.notEmpty(baseUri);
        
        init(baseUri);
    }
    
    /** @throws QuickBooksRuntimeException 
     * @see org.mule.modules.quickbooks.online.api.QuickBooksOnlineClient#create(java.lang.Object) */
    @Override
    public <T extends CdmBase> T create(final String realmId,
                                        final String appKey,
                                        final String realmIdPseudonym, 
                                        final String authIdPseudonym,
                                        T obj)
    {
        Validate.notNull(obj);
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
        
        String str = String.format("%s/resource/%s/v2/%s",
            getBaseUri(realmId),
            QuickBooksConventions.toQuickBooksPathVariable(obj.getClass().getSimpleName()),
            realmId);
        
        HttpUriRequest httpRequest = new HttpPost(str);
        httpRequest.addHeader("Content-Type", "application/xml");
        prepareToPost(obj, httpRequest);

        try
        {
            return (T) makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                destroyAccessToken(realmId);
                return create(realmId, appKey, realmIdPseudonym, authIdPseudonym, obj);
            } 
            else 
            {
                throw e;
            }
        }
    }

    /** @throws QuickBooksRuntimeException 
     * @see org.mule.modules.quickbooks.online.api.QuickBooksOnlineClient#getObject() */
    @Override
    public <T extends CdmBase> T getObject(final String realmId,
                                           final String appKey,
                                           final String realmIdPseudonym, 
                                           final String authIdPseudonym,
                                           final OnlineEntityType type,
                                           final IdType id)
    {   
        Validate.notNull(type);
        Validate.notNull(id);
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
        
        String str = String.format("%s/resource/%s/v2/%s/%s",
            getBaseUri(realmId), type.getResouceName(), realmId, id.getValue());

        HttpUriRequest httpRequest = new HttpGet(str);
        
        try
        {
            return (T) makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                destroyAccessToken(realmId);
                return getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, id);
            } 
            else 
            {
                throw e;
            }
        }
    }

    /** @throws QuickBooksRuntimeException 
     * @see org.mule.modules.quickbooks.online.api.QuickBooksOnlineClient#update(java.lang.String) */
    @Override
    public <T extends CdmBase> T update(final String realmId,
                                        final String appKey,
                                        final String realmIdPseudonym, 
                                        final String authIdPseudonym,
                                        final OnlineEntityType type,
                                        T obj)
    {
        Validate.notNull(obj);
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
        
        if (obj.getSyncToken() == null)
        {
            obj.setSyncToken(getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, obj.getId()).getSyncToken());
        }
        
        String str = String.format("%s/resource/%s/v2/%s/%s",
            getBaseUri(realmId),
            QuickBooksConventions.toQuickBooksPathVariable(obj.getClass().getSimpleName()),
            realmId,
            obj.getId().getValue());
        
        HttpUriRequest httpRequest = new HttpPost(str);
        httpRequest.addHeader("Content-Type", "application/xml");
        prepareToPost(obj, httpRequest);
        
        try
        {
            return (T) makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                destroyAccessToken(realmId);
                return update(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, obj);
            } 
            else 
            {
                throw e;
            }
        }
    }

    /** @throws QuickBooksRuntimeException 
     * @see org.mule.modules.quickbooks.online.api.QuickBooksOnlineClient#deleteObject(java.lang.Object) */
    @Override
    public <T extends CdmBase> void deleteObject(final String realmId,
                                                 final String appKey,
                                                 final String realmIdPseudonym, 
                                                 final String authIdPseudonym,
                                                 final OnlineEntityType type,
                                                 final IdType id,
                                                 String syncToken)
    {   
        Validate.notNull(type);
        Validate.notNull(id);
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
        
        if (syncToken == null)
        {
            syncToken = getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, id).getSyncToken();
        }
        T obj = (T) type.newInstance();
        obj.setSyncToken(syncToken);
        obj.setId(id);
        
        String str = String.format("%s/resource/%s/v2/%s/%s?methodx=delete",
            getBaseUri(realmId), type.getResouceName(), realmId, id.getValue());
        
        HttpUriRequest httpRequest = new HttpPost(str);
        httpRequest.addHeader("Content-Type", "application/xml");
        prepareToPost(obj, httpRequest);
        try
        {
            makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                destroyAccessToken(realmId);
                deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, id, syncToken);
            } 
            else 
            {
                throw e;
            }
        }
    }

    /** @param query 
     * @param type 
     * @see org.mule.modules.quickbooks.online.api.QuickBooksOnlineClient#findObjects() */
    @Override
    public <T extends CdmBase> Iterable<T> findObjects(final String realmId, 
                                                       final String appKey,
                                                       final String realmIdPseudonym, 
                                                       final String authIdPseudonym,
                                                       final OnlineEntityType type, 
                                                       final String queryFilter, 
                                                       final String querySort)
    {
        Validate.notNull(type);
        
        return new PaginatedIterable<T, SearchResults>()
            {
                @Override
                protected SearchResults firstPage()
                {
                    loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
                    return askAnEspecificPage(1);
                }

                @Override
                protected SearchResults nextPage(SearchResults currentPage)
                {
                    return askAnEspecificPage(currentPage.getCurrentPage() + 1);
                }
                
                @Override
                protected boolean hasNextPage(SearchResults page)
                {
                    return page.getCount() == getResultsPerPage();
                }

                @Override
                @SuppressWarnings("unchecked")
                protected Iterator<T> pageIterator(SearchResults page)
                {
                    try
                    {          
                        return ((List<T>) page.getCdmCollections().getClass()
                                        .getMethod("get" + type.getSimpleName(), null)
                                        .invoke(page.getCdmCollections())).iterator();
                    }
                    catch (IllegalAccessException e)
                    {
                        throw new AssertionError(e);
                    }
                    catch (InvocationTargetException e)
                    {
                        throw new AssertionError(e);
                    }
                    catch (NoSuchMethodException e)
                    {
                        throw new AssertionError(e);
                    }
                }
                
                private SearchResults askAnEspecificPage(Integer pageNumber)
                {
                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    if (queryFilter != null)
                    {
                        nameValuePairs.add(new BasicNameValuePair("Filter", queryFilter));
                    }
                    if (querySort != null)
                    {
                        nameValuePairs.add(new BasicNameValuePair("Sort", querySort));
                    }
                    nameValuePairs.add(new BasicNameValuePair("ResultsPerPage", getResultsPerPage().toString()));
                    nameValuePairs.add(new BasicNameValuePair("PageNum", pageNumber.toString()));
                    HttpUriRequest httpRequest = new HttpPost(String.format("%s/resource/%ss/v2/%s", 
                        getBaseUri(realmId), type.getResouceName(), realmId));
                    
                    httpRequest.addHeader("Content-Type", "application/x-www-form-urlencoded");
                    try
                    {
                        ((HttpPost) httpRequest).setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    }
                    catch (UnsupportedEncodingException e)
                    {
                        throw MuleSoftException.soften(e);
                    } 
                    
                    try
                    {
                        return (SearchResults) makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));
                    }
                    catch(QuickBooksRuntimeException e)
                    {
                        if(e.isAExpiredTokenFault())
                        {
                            destroyAccessToken(realmId);
                            return askAnEspecificPage(pageNumber);
                        } 
                        else 
                        {
                            throw e;
                        }
                    }
                }
            };
    }
    
    @Override
    protected String loadCompanyBaseUri(String realmId, String appKey, String accessToken)
    {
        HttpUriRequest httpRequest = new HttpGet(String.format("%s/%s", baseUri, realmId));
        
        QboUser qboUser = (QboUser) makeARequestToQuickbooks(httpRequest, appKey, accessToken);
        
        return qboUser.getCurrentCompany().getBaseURI();
    }

    @Override
    protected MessageUtils getMessageUtilsInstance()
    {
        return QBOMessageUtils.getInstance();
    }
}
