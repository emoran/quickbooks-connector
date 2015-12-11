
package org.mule.modules.quickbooks.online.processors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.mule.api.MessagingException;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.construct.FlowConstruct;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.transport.PropertyScope;
import org.mule.config.i18n.CoreMessages;
import org.mule.modules.quickbooks.online.QuickBooksOnlineModule;
import org.mule.modules.quickbooks.online.adapters.QuickBooksOnlineModuleProcessAdapter;
import org.mule.modules.quickbooks.online.process.ProcessAdapter;
import org.mule.modules.quickbooks.online.process.ProcessCallback;
import org.mule.modules.quickbooks.online.process.ProcessTemplate;


/**
 * AuthUserMessageProcessor invokes the {@link org.mule.modules.quickbooks.online.QuickBooksOnlineModule#authUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map)} method in {@link QuickBooksOnlineModule }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class AuthUserMessageProcessor
    extends AbstractMessageProcessor<Object>
    implements Disposable, Initialisable, Startable, Stoppable, MessageProcessor
{

    protected Object requestTokenUrl;
    protected String _requestTokenUrlType;
    protected Object accessTokenUrl;
    protected String _accessTokenUrlType;
    protected Object authorizationUrl;
    protected String _authorizationUrlType;
    protected Object callbackUrl;
    protected String _callbackUrlType;
    protected Object requestTokenId;
    protected String _requestTokenIdType;
    protected Object headers;
    protected Map<String, Object> _headersType;

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
    }

    public void start()
        throws MuleException
    {
    }

    public void stop()
        throws MuleException
    {
    }

    public void dispose() {
    }

    /**
     * Set the Mule context
     * 
     * @param context Mule context to set
     */
    public void setMuleContext(MuleContext context) {
        super.setMuleContext(context);
    }

    /**
     * Sets flow construct
     * 
     * @param flowConstruct Flow construct to set
     */
    public void setFlowConstruct(FlowConstruct flowConstruct) {
        super.setFlowConstruct(flowConstruct);
    }

    /**
     * Sets headers
     * 
     * @param value Value to set
     */
    public void setHeaders(Object value) {
        this.headers = value;
    }

    /**
     * Sets requestTokenUrl
     * 
     * @param value Value to set
     */
    public void setRequestTokenUrl(Object value) {
        this.requestTokenUrl = value;
    }

    /**
     * Sets callbackUrl
     * 
     * @param value Value to set
     */
    public void setCallbackUrl(Object value) {
        this.callbackUrl = value;
    }

    /**
     * Sets authorizationUrl
     * 
     * @param value Value to set
     */
    public void setAuthorizationUrl(Object value) {
        this.authorizationUrl = value;
    }

    /**
     * Sets accessTokenUrl
     * 
     * @param value Value to set
     */
    public void setAccessTokenUrl(Object value) {
        this.accessTokenUrl = value;
    }

    /**
     * Sets requestTokenId
     * 
     * @param value Value to set
     */
    public void setRequestTokenId(Object value) {
        this.requestTokenId = value;
    }

    /**
     * Invokes the MessageProcessor.
     * 
     * @param event MuleEvent to be processed
     * @throws MuleException
     */
    public MuleEvent process(final MuleEvent event)
        throws MuleException
    {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(QuickBooksOnlineModuleProcessAdapter.class, false, event);
            final String _transformedRequestTokenUrl = ((String) evaluateAndTransform(getMuleContext(), event, AuthUserMessageProcessor.class.getDeclaredField("_requestTokenUrlType").getGenericType(), null, requestTokenUrl));
            final String _transformedAccessTokenUrl = ((String) evaluateAndTransform(getMuleContext(), event, AuthUserMessageProcessor.class.getDeclaredField("_accessTokenUrlType").getGenericType(), null, accessTokenUrl));
            final String _transformedAuthorizationUrl = ((String) evaluateAndTransform(getMuleContext(), event, AuthUserMessageProcessor.class.getDeclaredField("_authorizationUrlType").getGenericType(), null, authorizationUrl));
            final String _transformedCallbackUrl = ((String) evaluateAndTransform(getMuleContext(), event, AuthUserMessageProcessor.class.getDeclaredField("_callbackUrlType").getGenericType(), null, callbackUrl));
            final String _transformedRequestTokenId = ((String) evaluateAndTransform(getMuleContext(), event, AuthUserMessageProcessor.class.getDeclaredField("_requestTokenIdType").getGenericType(), null, requestTokenId));
            final HashMap<String, Object> _transformedHeaders = new HashMap<String, Object>();
            Object resultPayload;
            ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) moduleObject).getProcessTemplate();
            resultPayload = processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class> getManagedExceptions() {
                    return null;
                }

                public boolean isProtected() {
                    return false;
                }

                public Object process(Object object)
                    throws Exception
                {
                    return ((QuickBooksOnlineModule) object).authUser(_transformedRequestTokenUrl, _transformedAccessTokenUrl, _transformedAuthorizationUrl, _transformedCallbackUrl, _transformedRequestTokenId, _transformedHeaders);
                }

            }
            , this, event);
            overwritePayload(event, resultPayload);
            if ((_transformedHeaders!= null)&&(!_transformedHeaders.isEmpty())) {
                event.getMessage().addProperties(_transformedHeaders, PropertyScope.OUTBOUND);
            }
            return event;
        } catch (MessagingException messagingException) {
            messagingException.setProcessedEvent(event);
            throw messagingException;
        } catch (Exception e) {
            throw new MessagingException(CoreMessages.failedToInvoke("authUser"), event, e);
        }
    }

}