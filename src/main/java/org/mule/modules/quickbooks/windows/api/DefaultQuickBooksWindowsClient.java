package org.mule.modules.quickbooks.windows.api;

import org.apache.commons.lang.Validate;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.mule.modules.quickbooks.api.AbstractQuickBooksClient;
import org.mule.modules.quickbooks.api.QuickBooksConventions;
import org.mule.modules.quickbooks.api.exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.online.OnlineEntityType;
import org.mule.modules.quickbooks.utils.MessageUtils;
import org.mule.modules.quickbooks.windows.objectfactory.QBWMessageUtils;
import org.mule.modules.quickbooks.windows.schema.AddRequest;
import org.mule.modules.quickbooks.windows.schema.CdmBase;
import org.mule.modules.quickbooks.windows.schema.ErrorResponse;
import org.mule.modules.quickbooks.windows.schema.IdType;

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
            Object auxObj = makeARequestToQuickbooks(httpRequest, appKey, getAccessToken(realmId));
            if(auxObj instanceof ErrorResponse)
            {
                throw new QuickBooksRuntimeException((ErrorResponse)auxObj);
            }
            return null;
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
    public <T extends CdmBase> T getObject(String realmId,
                                           String appKey,
                                           String realmIdPseudonym,
                                           String authIdPseudonym,
                                           OnlineEntityType type,
                                           IdType id)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T extends CdmBase> T update(String realmId,
                                        String appKey,
                                        String realmIdPseudonym,
                                        String authIdPseudonym,
                                        OnlineEntityType type,
                                        T obj)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T extends CdmBase> void deleteObject(String realmId,
                                                 String appKey,
                                                 String realmIdPseudonym,
                                                 String authIdPseudonym,
                                                 OnlineEntityType type,
                                                 IdType id,
                                                 String syncToken)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public <T extends CdmBase> Iterable<T> findObjects(String realmId,
                                                       String appKey,
                                                       String realmIdPseudonym,
                                                       String authIdPseudonym,
                                                       OnlineEntityType type,
                                                       String queryFilter,
                                                       String querySort)
    {
        
        // TODO Auto-generated method stub
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
        //Not field necessary. According to the documentation, it's the baseUri
        return baseUri;
    }

}
