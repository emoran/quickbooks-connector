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
import java.util.UUID;

import javax.xml.bind.JAXBException;

import net.sf.staccatocommons.collections.stream.Streams;

import org.apache.commons.lang.Validate;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.mule.modules.quickbooks.api.AbstractQuickBooksClient;
import org.mule.modules.quickbooks.api.exception.ErrorInfo;
import org.mule.modules.quickbooks.api.exception.ExceptionInfo;
import org.mule.modules.quickbooks.api.exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.utils.MessageUtils;
import org.mule.modules.quickbooks.windows.WindowsEntityType;
import org.mule.modules.quickbooks.windows.objectfactory.QBWMessageUtils;
import org.mule.modules.quickbooks.windows.schema.AddRequest;
import org.mule.modules.quickbooks.windows.schema.CdmBase;
import org.mule.modules.quickbooks.windows.schema.DelRequest;
import org.mule.modules.quickbooks.windows.schema.ErrorResponse;
import org.mule.modules.quickbooks.windows.schema.IdType;
import org.mule.modules.quickbooks.windows.schema.ModRequest;
import org.mule.modules.quickbooks.windows.schema.QueryBase;
import org.mule.modules.quickbooks.windows.schema.RevertRequest;
import org.mule.modules.quickbooks.windows.schema.SuccessResponse;
import org.mule.modules.quickbooks.windows.schema.UserInformation;
import org.mule.modules.quickbooks.windows.schema.UserResponse;
import org.mule.modules.utils.MuleSoftException;
import org.mule.modules.utils.pagination.PaginatedIterable;

public class DefaultQuickBooksWindowsClient extends AbstractQuickBooksClient implements QuickBooksWindowsClient
{
    
    public DefaultQuickBooksWindowsClient(final String baseUri)
    {
        Validate.notEmpty(baseUri);
        
        init(baseUri);
    }
    
    @Override
    public Object create(String realmId,
                         String appKey,
                         String realmIdPseudonym,
                         String authIdPseudonym,
                         WindowsEntityType type,
                         Object obj,
                         String requestId,
                         Boolean draft,
                         Boolean fullResponse)
    {
        Validate.notNull(obj);
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
        
        String str = String.format("%s/%s/v2/%s",
            getBaseUri(realmId),
            type.getResouceName(),
            realmId);
        
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
            Object respObj = makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));
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
                destroyAccessToken(realmId);
                return create(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, obj, requestId, draft, fullResponse);
            } 
            else 
            {
                throw e;
            }
        }
    }

    @Override
    public Object getObject(String realmId,
                            String appKey,
                            String realmIdPseudonym,
                            String authIdPseudonym,
                            WindowsEntityType type,
                            IdType id)
    {   
        Validate.notNull(type);
        Validate.notNull(id);
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
        
        String str = String.format("%s/%s/v2/%s/%s?idDomain=%s",
            getBaseUri(realmId), type.getResouceName(), realmId, id.getValue(), id.getIdDomain().value());

        HttpUriRequest httpRequest = new HttpGet(str);
        
        try
        {
            Object respObj = makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));
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
                destroyAccessToken(realmId);
                return getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, id);
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
    public Object update(String realmId,
                         String appKey,
                         String realmIdPseudonym,
                         String authIdPseudonym,
                         WindowsEntityType type,
                         Object obj,
                         String requestId,
                         Boolean draft,
                         Boolean fullResponse)
    {
        Validate.notNull(obj);
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);

        if (((CdmBase)obj).getSyncToken() == null)
        {
            ((CdmBase)obj).setSyncToken(((CdmBase)getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, ((CdmBase)obj).getId())).getSyncToken());
        }
        
        String str = String.format("%s/%s/v2/%s",
            getBaseUri(realmId),
            type.getResouceName(),
            realmId);
        
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
            Object respObj = makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));
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
                destroyAccessToken(realmId);
                return update(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, obj, requestId, draft, fullResponse);
            } 
            else 
            {
                throw e;
            }
        }
    }

    @Override
    public void delete(String realmId,
                              String appKey,
                              String realmIdPseudonym,
                              String authIdPseudonym,
                              WindowsEntityType type,
                              Object obj,
                              String requestId)
    {
        Validate.notNull(type);
        Validate.notNull(obj);
        Validate.notNull(((CdmBase)obj).getId());
        Validate.isTrue(((CdmBase)obj).getId().getValue()!=null && !((CdmBase)obj).getId().getValue().equals(""));
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
        
        if (((CdmBase)obj).getSyncToken() == null || ((CdmBase)obj).getMetaData() == null)
        {
            obj = getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, ((CdmBase)obj).getId());
        }
        
        String str = String.format("%s/%s/v2/%s",
            getBaseUri(realmId), type.getResouceName(), realmId);
        
        HttpUriRequest httpRequest = new HttpPost(str);
        httpRequest.addHeader("Content-Type", "text/xml");
        
        DelRequest delRequest = new DelRequest();
        delRequest.setRequestId(requestId);
        delRequest.setCdmObject(getMessageUtilsInstance().createJaxbElement(obj));
        
        prepareToPost(delRequest, httpRequest);
        try
        {
            Object respObj = makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));
            if(respObj instanceof ErrorResponse)
            {
                throw new QuickBooksRuntimeException(new ErrorInfo(respObj));
            }
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                destroyAccessToken(realmId);
                delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, obj, requestId);
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
    public Iterable findObjectsGetPages(final String realmId,
                                final String appKey,
                                final String realmIdPseudonym,
                                final String authIdPseudonym,
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
                loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
                
                String str = String.format("%s/%s/v2/%s",
                    getBaseUri(realmId), type.getResouceName(), realmId);
                
                HttpUriRequest httpRequest = new HttpPost(str);
                httpRequest.addHeader("Content-Type", "text/xml");
                
                ((QueryBase) query).setStartPage(BigInteger.valueOf(pageNumber));
                ((QueryBase) query).setChunkSize(getResultsPerPage());
                
                prepareToPost(query, httpRequest);

                try
                {
                    Object respObj = makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));
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
     * Returns all the results from QB
     * 
     * @return List with all the results
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Iterable findObjects(final String realmId,
                                final String appKey,
                                final String realmIdPseudonym,
                                final String authIdPseudonym,
                                final WindowsEntityType type,
                                final Object query)
    {
        Validate.notNull(type);
        
        List<Object> listOfResults = new ArrayList<Object>();
        Boolean hasMoreResults = true;
        Integer pageNumber = 0;
        HttpUriRequest httpRequest;
        Object responseObject;
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
        
        String str = String.format("%s/%s/v2/%s",
                getBaseUri(realmId), type.getResouceName(), realmId);
            
        while (hasMoreResults) {
            pageNumber++;
            httpRequest = new HttpPost(str);
            httpRequest.addHeader("Content-Type", "text/xml");
            
            ((QueryBase) query).setStartPage(BigInteger.valueOf(pageNumber));
            ((QueryBase) query).setChunkSize(getResultsPerPage());
        
            prepareToPost(query, httpRequest);

            try
            {
                responseObject = makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));
                if(responseObject instanceof ErrorResponse)
                {
                    throw new QuickBooksRuntimeException(new ErrorInfo(responseObject));
                }                
            } 
            catch(QuickBooksRuntimeException e)
            {
                if(e.isAExpiredTokenFault())
                {
                    destroyAccessToken(realmId);
                    responseObject = makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));                    
                } 
                else 
                {
                    throw e;
                }
            }

            List intuitList = getListFromIntuitResponse(responseObject, type);
            
            if (intuitList != null) {
                hasMoreResults = intuitList.size() >= getResultsPerPage();
                listOfResults.addAll(intuitList);
            }
            else {
                hasMoreResults = false;
            }
        }
        
        return listOfResults;
    }

    @Override
    public Object retrieveWithoutUsingQueryObjects(String realmId,
                                           String appKey,
                                           String realmIdPseudonym,
                                           String authIdPseudonym,
                                           Object syncStatusRequest,
                                           String objectName)
    { 
        Validate.notNull(syncStatusRequest);
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
        
        String str = String.format("%s/%s/v2/%s",
            getBaseUri(realmId), objectName, realmId);

        HttpUriRequest httpRequest = new HttpPost(str);
        httpRequest.addHeader("Content-Type", "text/xml");
        
        prepareToPost(syncStatusRequest, httpRequest);
        try
        {
            Object respObj = makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));
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
                destroyAccessToken(realmId);
                return retrieveWithoutUsingQueryObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, syncStatusRequest, objectName);
            } 
            else 
            {
                throw e;
            }
        }
    }
    
    @Override
    public void revert(final String realmId, final String appKey, 
                final String realmIdPseudonym, final String authIdPseudonym, 
                WindowsEntityType type, Object obj, String requestId)
    {
        Validate.notNull(type);
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
        
        String str = String.format("%s/%s/v2/%s",
            getBaseUri(realmId), type.getResouceName(), realmId);

        HttpUriRequest httpRequest = new HttpPost(str);
        httpRequest.addHeader("Content-Type", "text/xml");
        
        RevertRequest revertRequest = new RevertRequest();
        revertRequest.setRequestId(requestId);
        revertRequest.setCdmObject(getMessageUtilsInstance().createJaxbElement(obj));
        
        prepareToPost(revertRequest, httpRequest);
        
        try
        {
            Object respObj = makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));
            if(respObj instanceof ErrorResponse)
            {
                throw new QuickBooksRuntimeException(new ErrorInfo(respObj));
            }
        }
        catch(QuickBooksRuntimeException e)
        {
            if(e.isAExpiredTokenFault())
            {
                destroyAccessToken(realmId);
                revert(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, obj, requestId);
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
    protected String loadCompanyBaseUri(String realmId, String appKey, String accessToken)
    {
        //Not fields necessary. According to the documentation, it's the baseUri
        return baseUri;
    }
    
    @Override
    public UserInformation getCurrentUserInformation(String realmId,
            String appKey, String realmIdPseudonym, String authIdPseudonym) {        
        return ((UserResponse) retrieveUserInformation(realmId, appKey, realmIdPseudonym, authIdPseudonym)).getUser();
    }
}
