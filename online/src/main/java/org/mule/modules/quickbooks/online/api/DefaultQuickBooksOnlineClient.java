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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.mule.modules.quickbooks.api.AbstractQuickBooksClientOAuth;
import org.mule.modules.quickbooks.api.QuickBooksConventions;
import org.mule.modules.quickbooks.api.exception.ExceptionInfo;
import org.mule.modules.quickbooks.api.exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.api.model.*;
import org.mule.modules.quickbooks.api.oauth.OAuthCredentials;
import org.mule.modules.quickbooks.online.OnlineEntityType;
import org.mule.modules.quickbooks.online.objectfactory.QBOMessageUtils;
import org.mule.modules.quickbooks.online.schema.*;
import org.mule.modules.quickbooks.utils.MessageUtils;
import org.mule.modules.utils.MuleSoftException;
import org.mule.modules.utils.pagination.PaginatedIterable;

/**
 * 
 * @author Gaston Ponti
 * @since Aug 19, 2011
 */
@SuppressWarnings("unchecked")
public class DefaultQuickBooksOnlineClient extends AbstractQuickBooksClientOAuth implements QuickBooksOnlineClient
{   
    
    public DefaultQuickBooksOnlineClient(final String baseUri, final String consumerKey, final String consumerSecret,
                                         final String appKey)
    {
        Validate.notEmpty(baseUri);
        
        init(baseUri, consumerKey, consumerSecret, appKey);
        setResultsPerPage(100);
    }
    
    /** @throws QuickBooksRuntimeException 
     */
    @Override
    public <T extends CdmBase> T create(final OAuthCredentials credentials,
                                        T obj)
    {
        Validate.notNull(obj);
        
        String str = String.format("%s/resource/%s/v2/%s",
            credentials.getBaseUri(),
            QuickBooksConventions.toQuickBooksPathVariable(obj.getClass().getSimpleName()),
            credentials.getRealmId());
        
        HttpUriRequest httpRequest = new HttpPost(str);
        httpRequest.addHeader("Content-Type", "application/xml");
        prepareToPost(obj, httpRequest);

        try
        {
            return (T) makeARequestToQuickbooks(httpRequest, credentials, false);
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                destroyAccessToken(credentials);
                return create(credentials, obj);
            } 
            else 
            {
                throw e;
            }
        }
    }

    /** @throws QuickBooksRuntimeException 
     */
    @Override
    public <T extends CdmBase> T getObject(final OAuthCredentials credentials,
                                           final OnlineEntityType type,
                                           final IdType id)
    {   
        Validate.notNull(type);
        Validate.notNull(id);
        
        String str = String.format("%s/resource/%s/v2/%s/%s",
            credentials.getBaseUri(), type.getResouceName(), credentials.getRealmId(), id.getValue());

        HttpUriRequest httpRequest = new HttpGet(str);
        
        try
        {
            return (T) makeARequestToQuickbooks(httpRequest, credentials, false);
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                destroyAccessToken(credentials);
                return getObject(credentials, type, id);
            } 
            else 
            {
                throw e;
            }
        }
    }

    /** @throws QuickBooksRuntimeException 
     */
    @Override
    public <T extends CdmBase> T update(final OAuthCredentials credentials,
                                        final OnlineEntityType type,
                                        T obj)
    {
        Validate.notNull(obj);
        
        if (obj.getSyncToken() == null)
        {
            obj.setSyncToken(getObject(credentials, type, obj.getId()).getSyncToken());
        }
        
        String str = String.format("%s/resource/%s/v2/%s/%s",
            credentials.getBaseUri(),
            QuickBooksConventions.toQuickBooksPathVariable(obj.getClass().getSimpleName()),
            credentials.getRealmId(),
            obj.getId().getValue());
        
        HttpUriRequest httpRequest = new HttpPost(str);
        httpRequest.addHeader("Content-Type", "application/xml");
        prepareToPost(obj, httpRequest);
        
        try
        {
            return (T) makeARequestToQuickbooks(httpRequest, credentials, false);
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                destroyAccessToken(credentials);
                return update(credentials, type, obj);
            } 
            else 
            {
                throw e;
            }
        }
    }

    /** @throws QuickBooksRuntimeException 
     */
    @Override
    public <T extends CdmBase> void deleteObject(final OAuthCredentials credentials,
                                                 final OnlineEntityType type,
                                                 final IdType id,
                                                 String syncToken)
    {   
        Validate.notNull(type);
        Validate.notNull(id);
        
        if (syncToken == null)
        {
            syncToken = getObject(credentials, type, id).getSyncToken();
        }
        T obj = (T) type.newInstance();
        obj.setSyncToken(syncToken);
        obj.setId(id);
        
        String str = String.format("%s/resource/%s/v2/%s/%s?methodx=delete",
            credentials.getBaseUri(), type.getResouceName(), credentials.getRealmId(), id.getValue());
        
        HttpUriRequest httpRequest = new HttpPost(str);
        httpRequest.addHeader("Content-Type", "application/xml");
        prepareToPost(obj, httpRequest);
        try
        {
            makeARequestToQuickbooks(httpRequest, credentials, false);
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                destroyAccessToken(credentials);
                deleteObject(credentials, type, id, syncToken);
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
     */
    @Override
    public <T extends CdmBase> Iterable<T> findObjectsGetPages(final OAuthCredentials credentials,
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
                    return page.getCount().equals(getResultsPerPage());
                }

                @Override
                @SuppressWarnings("unchecked")
                protected Iterator<T> pageIterator(SearchResults page)
                {
                    try
                    {          
                        return ((List<T>) page.getCdmCollections().getClass()
                                        .getMethod("get" + type.getCdmCollectionName())
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
                    HttpUriRequest httpRequest = new HttpPost(String.format("%s/resource/%s/v2/%s", 
                        credentials.getBaseUri(), type.getResouceNameForFind(), credentials.getRealmId()));
                    
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
                        return (SearchResults) makeARequestToQuickbooks(httpRequest, credentials, false);
                    }
                    catch(QuickBooksRuntimeException e)
                    {
                        if(e.isAExpiredTokenFault())
                        {
                            destroyAccessToken(credentials);
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
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends CdmBase> Iterable<T> findObjects(final OAuthCredentials credentials,
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
                credentials.getBaseUri(), type.getResouceNameForFind(), credentials.getRealmId()));
            
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
                searchResults = (SearchResults) makeARequestToQuickbooks(httpRequest, credentials, false);
            }
            catch(QuickBooksRuntimeException e)
            {
                if(e.isAExpiredTokenFault())
                {
                    destroyAccessToken(credentials);
                    searchResults = (SearchResults) makeARequestToQuickbooks(httpRequest, credentials, false);
                } 
                else 
                {
                    throw e;
                }
            }
            
            hasMoreResults = searchResults.getCount() >= getResultsPerPage();
            
            try {                
                listOfResults.addAll((List<T>) searchResults.getCdmCollections().getClass()
                        .getMethod("get" + type.getCdmCollectionName())
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
    public String getCompanyBaseUri(OAuthCredentials credentials)
    {
        HttpUriRequest httpRequest = new HttpGet(String.format("%s/%s", this.baseUri,
                credentials.getRealmId()));

        QboUser qboUser = (QboUser) makeARequestToQuickbooks(httpRequest, credentials, false);

        return qboUser.getCurrentCompany().getBaseURI();
    }

    @Override
    protected ExceptionInfo getFaultInfo(String str) throws JAXBException
    {
        //This use of the QBWMessageUtils is because, in QBW it's not defined FaultInfo, 
        //but if the tokens expired of if they are wrong, they send us this object.
        return new ExceptionInfo(getMessageUtilsInstance().parseResponse(str));
    }
    
    @Override
    protected MessageUtils getMessageUtilsInstance()
    {
        return QBOMessageUtils.getInstance();
    }

    @Override
    public UserInformation getCurrentUserInformation(OAuthCredentials credentials) {
        return ((UserResponse) retrieveUserInformation(credentials)).getUser();
    }

    /**
     * Parse the HTML information for BlueDotMenu
     * @param credentials OAuth credentials
     * @param regex Regex for extracting the information
     *              <p>The regex has to extract the information in this way:</p>
     *              <p>match[0]: appId,appName,contextArea</p>
     *              <p>match[1]: logoImageUrl</p>
     *              <p>The method will split the application information to generate the @link{AppMenuInformation} object</p>
     * @return List with connected apps information
     */
    @Override
    public List<AppMenuInformation> getBlueDotInformation(OAuthCredentials credentials, String regex) {
        String blueDotInformation = (String) getBlueDotMenu(credentials);
        List<AppMenuInformation> menuInformationList = new ArrayList<AppMenuInformation>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(blueDotInformation);
        while(matcher.find()) {
            AppMenuInformation info = new AppMenuInformation();
            String[] parameters = StringUtils.split(matcher.group(1), ",");
            info.setAppId(StringUtils.trim(StringUtils.remove(parameters[0], "'")));
            info.setName(StringUtils.trim(StringUtils.remove(parameters[1], "'")));
            info.setContentArea(StringUtils.trim(StringUtils.remove(parameters[2], "'")));
            info.setImageUrl(StringUtils.trim(matcher.group(2)));

            menuInformationList.add(info);
        }

        return menuInformationList;
    }

    @Override
    public boolean disconnect(OAuthCredentials credentials) {
        PlatformResponse response = (PlatformResponse) disconnectFromQB(credentials);
        if (response.getErrorCode() != 0) throw new QuickBooksRuntimeException(response.getErrorMessage());

        return true;
    }

    @Override
    public OAuthCredentials reconnect(OAuthCredentials credentials) {
        ReconnectResponse response = (ReconnectResponse) reconnectToQB(credentials);
        if (response.getErrorCode() != 0) {
            throw new QuickBooksRuntimeException(response.getErrorMessage());
        }

        credentials.setAccessToken(response.getAccessToken());
        credentials.setAccessTokenSecret(response.getAccessTokenSecret());
        return credentials;
    }

    @Override
    public <T> T get(OAuthCredentials credentials, OnlineEntityType type) {
        Validate.notNull(type);
        
        String str = String.format("%s/resource/%s/v2/%s",
            credentials.getBaseUri(), type.getResouceName(), credentials.getRealmId());

        HttpUriRequest httpRequest = new HttpGet(str);
        
        try
        {
            return (T) makeARequestToQuickbooks(httpRequest, credentials, false);
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                destroyAccessToken(credentials);
                return get(credentials, type);
            } 
            else 
            {
                throw e;
            }
        }
    }
}
