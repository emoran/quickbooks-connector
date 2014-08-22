
package org.mule.modules.quickbooks.windows.processors;

import java.util.List;
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
import org.mule.config.i18n.CoreMessages;
import org.mule.modules.quickbooks.windows.QuickBooksWindowsModule;
import org.mule.modules.quickbooks.windows.WindowsEntityType;
import org.mule.modules.quickbooks.windows.adapters.QuickBooksWindowsModuleProcessAdapter;
import org.mule.modules.quickbooks.windows.process.ProcessAdapter;
import org.mule.modules.quickbooks.windows.process.ProcessCallback;
import org.mule.modules.quickbooks.windows.process.ProcessTemplate;


/**
 * UpdateMessageProcessor invokes the {@link org.mule.modules.quickbooks.windows.QuickBooksWindowsModule#update(java.lang.String, org.mule.modules.quickbooks.windows.WindowsEntityType, java.lang.Object, java.lang.Boolean, java.lang.Boolean)} method in {@link QuickBooksWindowsModule }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:33:09-05:00", comments = "Build 3.4.3.1620.30ea288")
public class UpdateMessageProcessor
    extends AbstractMessageProcessor<Object>
    implements Disposable, Initialisable, Startable, Stoppable, MessageProcessor
{

    protected Object accessTokenId;
    protected String _accessTokenIdType;
    protected Object type;
    protected WindowsEntityType _typeType;
    protected Object entityObject;
    protected Object _entityObjectType;
    protected Object draft;
    protected Boolean _draftType;
    protected Object fullResponse;
    protected Boolean _fullResponseType;

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
     * Sets draft
     * 
     * @param value Value to set
     */
    public void setDraft(Object value) {
        this.draft = value;
    }

    /**
     * Sets entityObject
     * 
     * @param value Value to set
     */
    public void setEntityObject(Object value) {
        this.entityObject = value;
    }

    /**
     * Sets fullResponse
     * 
     * @param value Value to set
     */
    public void setFullResponse(Object value) {
        this.fullResponse = value;
    }

    /**
     * Sets type
     * 
     * @param value Value to set
     */
    public void setType(Object value) {
        this.type = value;
    }

    /**
     * Sets accessTokenId
     * 
     * @param value Value to set
     */
    public void setAccessTokenId(Object value) {
        this.accessTokenId = value;
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
            moduleObject = findOrCreate(QuickBooksWindowsModuleProcessAdapter.class, false, event);
            final String _transformedAccessTokenId = ((String) evaluateAndTransform(getMuleContext(), event, UpdateMessageProcessor.class.getDeclaredField("_accessTokenIdType").getGenericType(), null, accessTokenId));
            final WindowsEntityType _transformedType = ((WindowsEntityType) evaluateAndTransform(getMuleContext(), event, UpdateMessageProcessor.class.getDeclaredField("_typeType").getGenericType(), null, type));
            final Object _transformedEntityObject = ((Object) evaluateAndTransform(getMuleContext(), event, UpdateMessageProcessor.class.getDeclaredField("_entityObjectType").getGenericType(), null, entityObject));
            final Boolean _transformedDraft = ((Boolean) evaluateAndTransform(getMuleContext(), event, UpdateMessageProcessor.class.getDeclaredField("_draftType").getGenericType(), null, draft));
            final Boolean _transformedFullResponse = ((Boolean) evaluateAndTransform(getMuleContext(), event, UpdateMessageProcessor.class.getDeclaredField("_fullResponseType").getGenericType(), null, fullResponse));
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
                    return ((QuickBooksWindowsModule) object).update(_transformedAccessTokenId, _transformedType, _transformedEntityObject, _transformedDraft, _transformedFullResponse);
                }

            }
            , this, event);
            overwritePayload(event, resultPayload);
            return event;
        } catch (MessagingException messagingException) {
            messagingException.setProcessedEvent(event);
            throw messagingException;
        } catch (Exception e) {
            throw new MessagingException(CoreMessages.failedToInvoke("update"), event, e);
        }
    }

}
