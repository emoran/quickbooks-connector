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
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;
import org.mule.modules.quickbooks.api.AbstractQuickBooksClientOAuth;
import org.mule.modules.quickbooks.api.exception.ExceptionInfo;
import org.mule.modules.quickbooks.api.exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.api.model.AppMenuInformation;
import org.mule.modules.quickbooks.api.model.BlueDotMenu;
import org.mule.modules.quickbooks.api.model.PlatformResponse;
import org.mule.modules.quickbooks.api.model.ReconnectResponse;
import org.mule.modules.quickbooks.api.model.UserInformation;
import org.mule.modules.quickbooks.api.model.UserResponse;
import org.mule.modules.quickbooks.api.oauth.OAuthCredentials;
import org.mule.modules.quickbooks.online.IntuitEntityEnum;
import org.mule.modules.quickbooks.online.OnlineEntityType;
import org.mule.modules.quickbooks.online.objectfactory.QBOMessageUtils;
import org.mule.modules.quickbooks.online.schema.CdmBase;
import org.mule.modules.quickbooks.online.schema.SearchResults;
import org.mule.modules.quickbooks.utils.MessageUtils;
import org.mule.modules.utils.MuleSoftException;
import org.mule.modules.utils.pagination.PaginatedIterable;
import org.springframework.util.CollectionUtils;

import com.intuit.ipp.core.Context;
import com.intuit.ipp.core.IEntity;
import com.intuit.ipp.core.ServiceType;
import com.intuit.ipp.data.CompanyInfo;
import com.intuit.ipp.data.Error;
import com.intuit.ipp.data.IntuitEntity;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.security.OAuthAuthorizer;
import com.intuit.ipp.services.DataService;

/**
 * 
 * @author damianpelaez
 *
 */
@SuppressWarnings("unchecked")
public class DefaultQuickBooksOnlineClient extends AbstractQuickBooksClientOAuth implements QuickBooksOnlineClient
{   
    private final ServiceType SERVICE_TYPE = ServiceType.QBO;
	
    public DefaultQuickBooksOnlineClient(final String baseUri, final String consumerKey, final String consumerSecret,
                                         final String appKey)
    {
        Validate.notEmpty(baseUri);
        
        init(baseUri, consumerKey, consumerSecret, appKey);
        setResultsPerPage(100);
    }
    
    // **********************************************************************************************
    // ************************** QuickBooks Online DataService Operations **************************
    // **********************************************************************************************
    
    private DataService createIntuitDataService(OAuthCredentials credentials) throws FMSException
    {
    	return new DataService(this.createIntuitContext(credentials));
    }
    
    private Context createIntuitContext(OAuthCredentials credentials) throws FMSException
    {
    	return new Context(this.createIntuitOAuthAuthorizer(credentials), this.SERVICE_TYPE, credentials.getRealmId());
    }
    
    private OAuthAuthorizer createIntuitOAuthAuthorizer(OAuthCredentials credentials)
    {
    	return new OAuthAuthorizer(this.getConsumerKey(), this.getConsumerSecret(), credentials.getAccessToken(), credentials.getAccessTokenSecret());
    }
    
    /** @throws QuickBooksRuntimeException 
     */
    @Override
    public <T extends IEntity> T create(final OAuthCredentials credentials, T obj)
    {
    	Validate.notNull(obj);
    	Validate.notNull(credentials);
    	
    	try
    	{
			DataService service = this.createIntuitDataService(credentials);
			return service.add(obj);
		} catch (FMSException e) {
			throw new QuickBooksRuntimeException(this.adaptFMSExceptionToExceptionInfo(e), e);
		}
    }
    
    /** @throws QuickBooksRuntimeException 
     */
    @Override
    public <T extends IEntity> T getObjectWithId(final OAuthCredentials credentials,
                                           final IntuitEntityEnum type,
                                           final String id)
    {   
    	Validate.notNull(credentials);
    	Validate.notNull(type);
        Validate.notNull(id);
        
        IntuitEntity obj = type.newInstance();
        obj.setId(id);

        return (T) this.getObject(credentials, obj);
    }
    
    private <T extends IEntity> T getObject(final OAuthCredentials credentials, IntuitEntity obj) {
    	try
    	{
        	DataService service = this.createIntuitDataService(credentials);
        	
        	return (T) service.findById(obj);
		} catch (FMSException e) {
			throw new QuickBooksRuntimeException(this.adaptFMSExceptionToExceptionInfo(e), e);
		}
    }
    
    @Override
    public CompanyInfo getCompanyInfo(OAuthCredentials credentials) {
    	Validate.notNull(credentials);
        
    	try
    	{
        	DataService service = this.createIntuitDataService(credentials);
        	List<CompanyInfo> companyInfoList = service.findAll(new CompanyInfo());
        	
        	if(CollectionUtils.isEmpty(companyInfoList)) {
        		throw new QuickBooksRuntimeException("The query for Company Info was empty.");
        	}
        	
        	return companyInfoList.get(0);
		} catch (FMSException e) {
			throw new QuickBooksRuntimeException(this.adaptFMSExceptionToExceptionInfo(e), e);
		}
    }

    /** @throws QuickBooksRuntimeException 
     */
    @Override
    public <T extends IEntity> T update(final OAuthCredentials credentials, T obj)
    {
        Validate.notNull(obj);
    	Validate.notNull(credentials);
    	
    	this.checkAndFillNullSyncToken(credentials, obj);
    	
    	try
    	{
			DataService service = this.createIntuitDataService(credentials);
			
			return service.update(obj);
		} catch (FMSException e) {
			throw new QuickBooksRuntimeException(this.adaptFMSExceptionToExceptionInfo(e), e);
		}
    }
    
    private <T extends IEntity> void checkAndFillNullSyncToken(final OAuthCredentials credentials, T obj) {
    	IntuitEntity intuitEntity = (IntuitEntity) obj;
		
    	if(StringUtils.isEmpty(intuitEntity.getSyncToken())) {
    		IntuitEntity entityToRetrieve = null;

    		try {
    			entityToRetrieve = intuitEntity.getClass().newInstance();
    			entityToRetrieve.setId(intuitEntity.getId());
    		} catch (InstantiationException e) {
    			this.throwFillNullSyncTokenException(intuitEntity);
    		} catch (IllegalAccessException e) {
    			this.throwFillNullSyncTokenException(intuitEntity);
    		}
    		
    		IntuitEntity retrievedEntity = (IntuitEntity) this.getObject(credentials, entityToRetrieve);
    		intuitEntity.setSyncToken(retrievedEntity.getSyncToken());
    	}
    }
    
    private void throwFillNullSyncTokenException(IntuitEntity intuitEntity){
    	throw new QuickBooksRuntimeException("Failed to fill Null SyncToken for class " + intuitEntity.getClass().getCanonicalName() + " with id: " + intuitEntity.getId());
    }

    /** @return 
     * @throws QuickBooksRuntimeException 
     */
    @Override
    public void deleteObject(final OAuthCredentials credentials, IEntity obj)
    {   
    	Validate.notNull(credentials);
    	Validate.notNull(obj);
    	
    	this.checkAndFillNullSyncToken(credentials, obj);

    	try
    	{
			DataService service = this.createIntuitDataService(credentials);
			
			service.delete(obj);
		} catch (FMSException e) {
			throw new QuickBooksRuntimeException(this.adaptFMSExceptionToExceptionInfo(e), e);
		}
    }
    
    /** @return 
     * @throws QuickBooksRuntimeException 
     */
    @Override
    public <T extends IEntity> void deleteObjectWithId(final OAuthCredentials credentials, IntuitEntityEnum type, final String id, final String syncToken)
    {   
    	Validate.notNull(credentials);
    	Validate.notNull(type);
    	Validate.notNull(id);
    	
    	T obj = this.getObjectWithId(credentials, type, id);
    	
    	if(StringUtils.isNotEmpty(syncToken)) {
    		IntuitEntity intuitEntity = (IntuitEntity) obj;
    		intuitEntity.setSyncToken(syncToken);
    	}
    	
    	try
    	{
			DataService service = this.createIntuitDataService(credentials);
			
			service.delete(obj);
		} catch (FMSException e) {
			throw new QuickBooksRuntimeException(this.adaptFMSExceptionToExceptionInfo(e), e);
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
    
    // **********************************************************************************************
    // ********************************** ExceptionInfo Operations **********************************
    // **********************************************************************************************
    
    private ExceptionInfo adaptFMSExceptionToExceptionInfo(FMSException exception) {
    	ExceptionInfo exceptionInfo = new ExceptionInfo(); 
    	
    	exceptionInfo.setMessage(StringUtils.defaultIfEmpty(exception.getMessage(), "No Message"));

    	List<Error> errorList = exception.getErrorList();
    	
    	if(!CollectionUtils.isEmpty(errorList))
    	{
    		for(Error error : errorList)
    		{
    			if(!StringUtils.isEmpty(error.getCode()))
    			{
    				exceptionInfo.setErrorCode(error.getCode());
    				exceptionInfo.setCause(error.getMessage());
    				return exceptionInfo;
    			}
    		}
    	}
    	
    	exceptionInfo.setErrorCode("No Cause Obtained");
    	exceptionInfo.setErrorCode("No ErrorCode Obtained");
    	return exceptionInfo;
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

    // **********************************************************************************************
    // ********************************* INTUIT Platform Operations *********************************
    // **********************************************************************************************
    
    @Override
    public UserInformation getCurrentUserInformation(OAuthCredentials credentials) {
        Object response = retrieveUserInformation(credentials);
        if(response instanceof UserResponse) {
            return ((UserResponse) response).getUser();
        }
        else if(response instanceof PlatformResponse) {
            PlatformResponse platformResponse = (PlatformResponse) response;
            throw new QuickBooksRuntimeException(String.format("Error Code: %s Error Message: %s", platformResponse.getErrorCode(),
                    platformResponse.getErrorMessage()));
        } else {
            throw new QuickBooksRuntimeException("It is not possible to parse the response from Intuit Platform");
        }
    }

    @Override
    public boolean disconnect(OAuthCredentials credentials) {
        PlatformResponse response = disconnectFromQB(credentials);
        if (response.getErrorCode() != 0) throw new QuickBooksRuntimeException(response.getErrorMessage());

        return true;
    }

    @Override
    public OAuthCredentials reconnect(OAuthCredentials credentials) {
        ReconnectResponse response = reconnectToQB(credentials);
        if (response.getErrorCode() != 0) {
            throw new QuickBooksRuntimeException(response.getErrorMessage());
        }

        credentials.setAccessToken(response.getAccessToken());
        credentials.setAccessTokenSecret(response.getAccessTokenSecret());
        return credentials;
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
    public BlueDotMenu getBlueDotInformation(OAuthCredentials credentials, String regex) {
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

        return new BlueDotMenu(menuInformationList, blueDotInformation);
    }
}
