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

import javax.xml.bind.JAXBException;

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
import org.mule.modules.quickbooks.online.schema.FaultInfo;
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
        setResultsPerPage(200);
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

    /** 
     * Returns the list of result pages from Quickbooks
     * 
     * @param query 
     * @param type 
     * @return List of pages
     * @see org.mule.modules.quickbooks.online.api.QuickBooksOnlineClient#findObjectsGetPages() */
    @Override
    public <T extends CdmBase> Iterable<T> findObjectsGetPages(final String realmId, 
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
                                        .getMethod("get" + type.getCdmCollectionName(), null)
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
                    loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);

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
                    HttpUriRequest httpRequest = new HttpPost(String.format("%s/resource/%s/v2/%s", 
                        getBaseUri(realmId), type.getResouceNameForFind(), realmId));
                    
                    httpRequest.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                    try
                    {
                        ((HttpPost) httpRequest).setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
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
    
    /** 
     * Return all the results from Quickbooks.
     *
     * 
     * @param query 
     * @param type
     * @return List with all the results 
     * @see org.mule.modules.quickbooks.online.api.QuickBooksOnlineClient#findObjects() */
    @SuppressWarnings("unchecked")
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
        
        List<T> listOfResults = new ArrayList<T>();
        Integer pageNumber = 0;
        Boolean hasMoreResults = true;
        List<NameValuePair> nameValuePairs;
        SearchResults searchResults;
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);

        while(hasMoreResults) {
            
            pageNumber++;
            nameValuePairs = new ArrayList<NameValuePair>();
            
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
            
            HttpUriRequest httpRequest = new HttpPost(String.format("%s/resource/%s/v2/%s", 
                getBaseUri(realmId), type.getResouceNameForFind(), realmId));
            
            httpRequest.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            try
            {
                ((HttpPost) httpRequest).setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            }
            catch (UnsupportedEncodingException e)
            {
                throw MuleSoftException.soften(e);
            }
            
            try
            {
                searchResults = (SearchResults) makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));
            }
            catch(QuickBooksRuntimeException e)
            {
                if(e.isAExpiredTokenFault())
                {
                    destroyAccessToken(realmId);
                    searchResults = (SearchResults) makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));
                } 
                else 
                {
                    throw e;
                }
            }
            
            hasMoreResults = searchResults.getCount() >= getResultsPerPage();
            
            try {                
                listOfResults.addAll((List<T>) searchResults.getCdmCollections().getClass()
                        .getMethod("get" + type.getCdmCollectionName(), null)
                        .invoke(searchResults.getCdmCollections()));            
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
        
        return listOfResults;
    }
    
    @Override
    protected String loadCompanyBaseUri(String realmId, String appKey, String accessToken)
    {
        HttpUriRequest httpRequest = new HttpGet(String.format("%s/%s", baseUri, realmId));
        
        QboUser qboUser = (QboUser) makeARequestToQuickbooks(httpRequest, appKey, accessToken);
        
        return qboUser.getCurrentCompany().getBaseURI();
    }

    @Override
    protected FaultInfo getFaultInfo(String str) throws JAXBException
    {
        //This use of the QBWMessageUtils is because, in QBW it's not defined FaultInfo, 
        //but if the tokens expired of if they are wrong, they send us this object.
        return (FaultInfo) getMessageUtilsInstance().parseResponse(str);
    }
    
    @Override
    protected MessageUtils getMessageUtilsInstance()
    {
        return QBOMessageUtils.getInstance();
    }
}
