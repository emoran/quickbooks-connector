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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBException;

import net.sf.staccatocommons.collections.stream.Streams;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.mule.modules.quickbooks.api.AbstractQuickBooksClientOAuth;
import org.mule.modules.quickbooks.api.exception.ErrorInfo;
import org.mule.modules.quickbooks.api.exception.ExceptionInfo;
import org.mule.modules.quickbooks.api.exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.api.model.*;
import org.mule.modules.quickbooks.api.oauth.OAuthCredentials;
import org.mule.modules.quickbooks.utils.MessageUtils;
import org.mule.modules.quickbooks.windows.WindowsEntityType;
import org.mule.modules.quickbooks.windows.objectfactory.QBWMessageUtils;
import org.mule.modules.quickbooks.windows.schema.*;
import org.mule.modules.quickbooks.windows.schema.PlatformResponse;
import org.mule.modules.quickbooks.windows.schema.UserResponse;
import org.mule.modules.quickbooks.windows.schema.UserInformation;
import org.mule.modules.utils.MuleSoftException;
import org.mule.modules.utils.pagination.PaginatedIterable;

public class DefaultQuickBooksWindowsClient extends AbstractQuickBooksClientOAuth implements QuickBooksWindowsClient
{
    
    public DefaultQuickBooksWindowsClient(final String baseUri, final String consumerKey, final String consumerSecret,
            							  final String appKey)
    {
        Validate.notEmpty(baseUri);
        
        init(baseUri, consumerKey, consumerSecret, appKey);
    }
    
    @Override
    public Object create(final OAuthCredentials credentials,
                         WindowsEntityType type,
                         Object obj,
                         String requestId,
                         Boolean draft,
                         Boolean fullResponse)
    {
        Validate.notNull(obj);
        
        String str = String.format("%s/%s/v2/%s",
        	credentials.getBaseUri(),
            type.getResouceName(),
            credentials.getRealmId());
        
        HttpUriRequest httpRequest = new HttpPost(str);
        httpRequest.addHeader("Content-Type", "text/xml");
        
        AddRequest addRequest = new AddRequest();
        addRequest.setRequestId(requestId);
        addRequest.setCdmObject(getMessageUtilsInstance().createJaxbElement(obj));
        addRequest.setDraft(draft);
        addRequest.setFullResponse(fullResponse);
        
        prepareToPost(addRequest, httpRequest);

        try
        {
            Object respObj = makeARequestToQuickbooks(httpRequest, credentials, false);
            if(respObj instanceof ErrorResponse)
            {
                throw new QuickBooksRuntimeException(new ErrorInfo(respObj));
            }
            if (fullResponse != null && fullResponse)
            {
                return ((SuccessResponse) respObj).getCdmObject().getValue();
            }
            return ((SuccessResponse) respObj).getCdmObjectRef().getValue();
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                destroyAccessToken(credentials);
                return create(credentials, type, obj, requestId, draft, fullResponse);
            } 
            else 
            {
                throw e;
            }
        }
    }

    @Override
    public Object getObject(final OAuthCredentials credentials,
                            WindowsEntityType type,
                            IdType id)
    {   
        Validate.notNull(type);
        Validate.notNull(id);
        
        String str = String.format("%s/%s/v2/%s/%s?idDomain=%s",
            credentials.getBaseUri(), type.getResouceName(), credentials.getRealmId(), id.getValue(), id.getIdDomain().value());

        HttpUriRequest httpRequest = new HttpGet(str);
        
        try
        {
            Object respObj = makeARequestToQuickbooks(httpRequest, credentials, false);
            if(respObj instanceof ErrorResponse)
            {
                throw new QuickBooksRuntimeException(new ErrorInfo(respObj));
            }
            return Streams.from(getListFromIntuitResponse(respObj, type)).anyOrNull();
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

    private List getListFromIntuitResponse(Object response, WindowsEntityType type)
    {
        try
        {
            if (type.getType().getSimpleName().equals("Class")) {
                return (List) response.getClass().getMethod("getClazz").invoke(response);
            }

            return (List) response.getClass().getMethod("get" + type.getType().getSimpleName()).invoke(response);
        }
        catch (Exception e)
        {
            throw MuleSoftException.soften(e);
        }
    }
    @Override
    public Object update(final OAuthCredentials credentials,
                         WindowsEntityType type,
                         Object obj,
                         String requestId,
                         Boolean draft,
                         Boolean fullResponse)
    {
        Validate.notNull(obj);
        

        if (((CdmBase)obj).getSyncToken() == null)
        {
            ((CdmBase)obj).setSyncToken(((CdmBase)getObject(credentials, type, ((CdmBase)obj).getId())).getSyncToken());
        }
        
        String str = String.format("%s/%s/v2/%s",
            credentials.getBaseUri(),
            type.getResouceName(),
            credentials.getRealmId());
        
        HttpUriRequest httpRequest = new HttpPost(str);
        httpRequest.addHeader("Content-Type", "text/xml");
        
        ModRequest modRequest = new ModRequest();
        modRequest.setRequestId(requestId);
        modRequest.setCdmObject(getMessageUtilsInstance().createJaxbElement(obj));
        modRequest.setDraft(draft);
        modRequest.setFullResponse(fullResponse);
        
        prepareToPost(modRequest, httpRequest);
        
        try
        {
            Object respObj = makeARequestToQuickbooks(httpRequest, credentials, false);
            if(respObj instanceof ErrorResponse)
            {
                throw new QuickBooksRuntimeException(new ErrorInfo(respObj));
            }
            if (fullResponse != null && fullResponse)
            {
                return ((SuccessResponse) respObj).getCdmObject().getValue();
            }
            return ((SuccessResponse) respObj).getCdmObjectRef().getValue();
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                destroyAccessToken(credentials);
                return update(credentials, type, obj, requestId, draft, fullResponse);
            } 
            else 
            {
                throw e;
            }
        }
    }

    @Override
    public void delete(final OAuthCredentials credentials,
                              WindowsEntityType type,
                              Object obj,
                              String requestId)
    {
        Validate.notNull(type);
        Validate.notNull(obj);
        Validate.notNull(((CdmBase)obj).getId());
        Validate.isTrue(((CdmBase)obj).getId().getValue()!=null && !((CdmBase)obj).getId().getValue().equals(""));
        
        if (((CdmBase)obj).getSyncToken() == null || ((CdmBase)obj).getMetaData() == null)
        {
            obj = getObject(credentials, type, ((CdmBase)obj).getId());
        }
        
        String str = String.format("%s/%s/v2/%s",
            credentials.getBaseUri(), type.getResouceName(), credentials.getRealmId());
        
        HttpUriRequest httpRequest = new HttpPost(str);
        httpRequest.addHeader("Content-Type", "text/xml");
        
        DelRequest delRequest = new DelRequest();
        delRequest.setRequestId(requestId);
        delRequest.setCdmObject(getMessageUtilsInstance().createJaxbElement(obj));
        
        prepareToPost(delRequest, httpRequest);
        try
        {
            Object respObj = makeARequestToQuickbooks(httpRequest, credentials, false);
            if(respObj instanceof ErrorResponse)
            {
                throw new QuickBooksRuntimeException(new ErrorInfo(respObj));
            }
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                destroyAccessToken(credentials);
                delete(credentials, type, obj, requestId);
            } 
            else 
            {
                throw e;
            }
        }
    }

    /**
     * Returns the list of results pages from QB
     * 
     * @return List of pages with results
     */
    @Override
    public Iterable findObjectsGetPages(final OAuthCredentials credentials,
                                final WindowsEntityType type,
                                final Object query)
    {
        Validate.notNull(type);
        return new PaginatedIterable<Object, List<Object>>()
        {
            private Integer countPage = 1;

            @Override
            protected List<Object> firstPage()
            {
                return askAnEspecificPage(countPage);
            }

            @Override
            protected boolean hasNextPage(List<Object> arg0)
            {
                return arg0.isEmpty();
            }

            @Override
            protected List<Object> nextPage(List<Object> arg0)
            {
                countPage = countPage + 1;
                return askAnEspecificPage(countPage);
            }

            @Override
            protected Iterator<Object> pageIterator(List<Object> arg0)
            {
                return arg0.iterator();
            }
          
            private List<Object> askAnEspecificPage(Integer pageNumber)
            {
                String str = String.format("%s/%s/v2/%s",
                    credentials.getBaseUri(), type.getResouceName(), credentials.getRealmId());
                
                HttpUriRequest httpRequest = new HttpPost(str);
                httpRequest.addHeader("Content-Type", "text/xml");
                
                ((QueryBase) query).setStartPage(BigInteger.valueOf(pageNumber));
                ((QueryBase) query).setChunkSize(getResultsPerPage());
                
                prepareToPost(query, httpRequest);

                try
                {
                    Object respObj = makeARequestToQuickbooks(httpRequest, credentials, false);
                    if(respObj instanceof ErrorResponse)
                    {
                        throw new QuickBooksRuntimeException(new ErrorInfo(respObj));
                    }
                    return getListFromIntuitResponse(respObj, type);
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
     * Returns all the results from QB
     * 
     * @return List with all the results
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Iterable findObjects(final OAuthCredentials credentials,
                                final WindowsEntityType type,
                                Integer startPage,
                                Integer chunkSize,
                                final Object query)
    {
        Validate.notNull(type);
        
        List<Object> listOfResults = new ArrayList<Object>();
        Boolean hasMoreResults = true;
        Boolean externalPagination = false;
        Integer pageNumber = 1;
        
        if (startPage != null && chunkSize != null)
        {
        	setResultsPerPage(chunkSize);
        	pageNumber = startPage; 
        	externalPagination = true;
        }
        	
        HttpUriRequest httpRequest;
        Object responseObject;
        
        String str = String.format("%s/%s/v2/%s",
                credentials.getBaseUri(), type.getResouceName(), credentials.getRealmId());
            
        while (hasMoreResults) {
            httpRequest = new HttpPost(str);
            httpRequest.addHeader("Content-Type", "text/xml");
            
            ((QueryBase) query).setStartPage(BigInteger.valueOf(pageNumber));
            ((QueryBase) query).setChunkSize(getResultsPerPage());
        
            prepareToPost(query, httpRequest);

            try
            {
                responseObject = makeARequestToQuickbooks(httpRequest, credentials, false);
                if(responseObject instanceof ErrorResponse)
                {
                    throw new QuickBooksRuntimeException(new ErrorInfo(responseObject));
                }                
            } 
            catch(QuickBooksRuntimeException e)
            {
                if(e.isAExpiredTokenFault())
                {
                    destroyAccessToken(credentials);
                    responseObject = makeARequestToQuickbooks(httpRequest, credentials, false);                    
                } 
                else 
                {
                    throw e;
                }
            }

            List intuitList = getListFromIntuitResponse(responseObject, type);
            
            if (intuitList != null) {
            	listOfResults.addAll(intuitList);
           		hasMoreResults = (intuitList.size() >= getResultsPerPage()) && !externalPagination;
           		pageNumber++;
            }
            else {
                hasMoreResults = false;
            }
        }
        
        return listOfResults;
    }

    @Override
    public Object retrieveWithoutUsingQueryObjects(final OAuthCredentials credentials,
                                           Object syncStatusRequest,
                                           String objectName)
    { 
        Validate.notNull(syncStatusRequest);
        
        String str = String.format("%s/%s/v2/%s",
            credentials.getBaseUri(), objectName, credentials.getRealmId());

        HttpUriRequest httpRequest = new HttpPost(str);
        httpRequest.addHeader("Content-Type", "text/xml");
        
        prepareToPost(syncStatusRequest, httpRequest);
        try
        {
            Object respObj = makeARequestToQuickbooks(httpRequest, credentials, false);
            if(respObj instanceof ErrorResponse)
            {
                throw new QuickBooksRuntimeException(new ErrorInfo(respObj));
            }
            return respObj;
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                destroyAccessToken(credentials);
                return retrieveWithoutUsingQueryObjects(credentials, syncStatusRequest, objectName);
            } 
            else 
            {
                throw e;
            }
        }
    }
    
    @Override
    public void revert(final OAuthCredentials credentials, 
                WindowsEntityType type, Object obj, String requestId)
    {
        Validate.notNull(type);
        
        String str = String.format("%s/%s/v2/%s",
            credentials.getBaseUri(), type.getResouceName(), credentials.getRealmId());

        HttpUriRequest httpRequest = new HttpPost(str);
        httpRequest.addHeader("Content-Type", "text/xml");
        
        RevertRequest revertRequest = new RevertRequest();
        revertRequest.setRequestId(requestId);
        revertRequest.setCdmObject(getMessageUtilsInstance().createJaxbElement(obj));
        
        prepareToPost(revertRequest, httpRequest);
        
        try
        {
            Object respObj = makeARequestToQuickbooks(httpRequest, credentials, false);
            if(respObj instanceof ErrorResponse)
            {
                throw new QuickBooksRuntimeException(new ErrorInfo(respObj));
            }
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                destroyAccessToken(credentials);
                revert(credentials, type, obj, requestId);
            } 
            else 
            {
                throw e;
            }
        }
    }
    
    @Override
    public String generateARequestId()
    {
        return UUID.randomUUID().toString().replace("-", "");
    }
    
    
    @Override
    protected ExceptionInfo getFaultInfo(String str) throws JAXBException
    {
        if (str.contains("oauth_problem=token_rejected"))
        {
            //This use the QBO FaultInfo because, in QBW it's not defined FaultInfo, 
            //but if the tokens expired of if they are wrong, they send us this object.
            ExceptionInfo exceptionInfo = new ExceptionInfo();
            exceptionInfo.setCause("SERVER");
            exceptionInfo.setErrorCode("401");
            exceptionInfo.setMessage("Unauthorized OAuth Token: token_rejected");
            return exceptionInfo;
        }
        return null;
    }
    
    @Override
    protected MessageUtils getMessageUtilsInstance()
    {
        return QBWMessageUtils.getInstance();
    }

    @Override
    public UserInformation getCurrentUserInformation(final OAuthCredentials credentials) {        
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
        org.mule.modules.quickbooks.windows.schema.PlatformResponse response =
                disconnectFromQB(credentials);
        if (response.getErrorCode() != 0) throw new QuickBooksRuntimeException(response.getErrorMessage());

        return true;
    }

    @Override
    public OAuthCredentials reconnect(OAuthCredentials credentials) {
        org.mule.modules.quickbooks.windows.schema.ReconnectResponse response =
                reconnectToQB(credentials);
        if (response.getErrorCode() != 0) {
            throw new QuickBooksRuntimeException(response.getErrorMessage());
        }

        credentials.setAccessToken(response.getOAuthToken());
        credentials.setAccessTokenSecret(response.getOAuthTokenSecret());
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
    @Override
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
    
    @Override
    public Object get(final OAuthCredentials credentials,
                            WindowsEntityType type)
    {   
        Validate.notNull(type);
        
        String str = String.format("%s/%s/v2/%s",
            credentials.getBaseUri(), type.getResouceName(), credentials.getRealmId());

        HttpUriRequest httpRequest = new HttpGet(str);
        
        try
        {
            Object respObj = makeARequestToQuickbooks(httpRequest, credentials, false);
            if(respObj instanceof ErrorResponse)
            {
                throw new QuickBooksRuntimeException(new ErrorInfo(respObj));
            }
            return Streams.from(getListFromIntuitResponse(respObj, type)).anyOrNull();
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
