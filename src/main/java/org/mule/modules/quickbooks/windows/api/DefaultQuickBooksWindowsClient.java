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

import javax.xml.bind.JAXBException;

import org.apache.commons.lang.Validate;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.mule.modules.quickbooks.api.AbstractQuickBooksClient;
import org.mule.modules.quickbooks.api.QuickBooksConventions;
import org.mule.modules.quickbooks.api.exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.online.schema.FaultInfo;
import org.mule.modules.quickbooks.utils.MessageUtils;
import org.mule.modules.quickbooks.windows.WindowsEntityType;
import org.mule.modules.quickbooks.windows.objectfactory.QBWMessageUtils;
import org.mule.modules.quickbooks.windows.schema.AddRequest;
import org.mule.modules.quickbooks.windows.schema.CdmBase;
import org.mule.modules.quickbooks.windows.schema.DelRequest;
import org.mule.modules.quickbooks.windows.schema.ErrorResponse;
import org.mule.modules.quickbooks.windows.schema.IdType;
import org.mule.modules.quickbooks.windows.schema.ModRequest;
import org.mule.modules.quickbooks.windows.schema.SuccessResponse;

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
                         Object obj,
                         String requestId,
                         Boolean draft,
                         Boolean fullResponse)
    {
        Validate.notNull(obj);
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
        
        String str = String.format("%s/%s/v2/%s",
            getBaseUri(realmId),
            QuickBooksConventions.toQuickBooksPathVariable(obj.getClass().getSimpleName()),
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
                throw new QuickBooksRuntimeException((ErrorResponse)respObj);
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
                return create(realmId, appKey, realmIdPseudonym, authIdPseudonym, obj, requestId, draft, fullResponse);
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
                throw new QuickBooksRuntimeException((ErrorResponse)respObj);
            }
            return ((SuccessResponse) respObj).getCdmObject().getValue();
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
            QuickBooksConventions.toQuickBooksPathVariable(obj.getClass().getSimpleName()),
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
                throw new QuickBooksRuntimeException((ErrorResponse)respObj);
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
        
        loadCompanyData(realmId, appKey, realmIdPseudonym, authIdPseudonym);
        
        if (((CdmBase)obj).getSyncToken() == null)
        {
            ((CdmBase)obj).setSyncToken(((CdmBase)getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, type, ((CdmBase)obj).getId())).getSyncToken());
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
                throw new QuickBooksRuntimeException((ErrorResponse)respObj);
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

    @Override
    public Iterable findObjects(String realmId,
                            String appKey,
                            String realmIdPseudonym,
                            String authIdPseudonym,
                            WindowsEntityType type,
                            Object query)
    {
        
        // TODO Auto-generated method stub
        return null;
    }

    
    @Override
    protected FaultInfo getFaultInfo(String str) throws JAXBException
    {
        if (str.contains("oauth_problem=token_rejected"))
        {
            //This use the QBO FaultInfo because, in QBW it's not defined FaultInfo, 
            //but if the tokens expired of if they are wrong, they send us this object.
            FaultInfo fault = new FaultInfo();
            fault.setCause("SERVER");
            fault.setErrorCode("401");
            fault.setMessage("Unauthorized OAuth Token: token_rejected");
            return fault;
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

}
