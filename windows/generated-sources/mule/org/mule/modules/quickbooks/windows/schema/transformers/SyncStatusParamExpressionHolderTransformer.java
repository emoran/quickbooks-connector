
package org.mule.modules.quickbooks.windows.schema.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.endpoint.ImmutableEndpoint;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.transformer.DataType;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.MessageTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transformer.TransformerMessagingException;
import org.mule.config.i18n.CoreMessages;
import org.mule.modules.quickbooks.windows.processors.AbstractExpressionEvaluator;
import org.mule.modules.quickbooks.windows.schema.IdSet;
import org.mule.modules.quickbooks.windows.schema.ObjectName;
import org.mule.modules.quickbooks.windows.schema.SyncStatusParam;
import org.mule.modules.quickbooks.windows.schema.holders.SyncStatusParamExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-21T02:51:05-05:00", comments = "Build 3.4.3.1620.30ea288")
public class SyncStatusParamExpressionHolderTransformer
    extends AbstractExpressionEvaluator
    implements DiscoverableTransformer, MessageTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;
    private ImmutableEndpoint endpoint;
    private MuleContext muleContext;
    private String name;

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

    public boolean isSourceTypeSupported(Class<?> aClass) {
        return (aClass == SyncStatusParamExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == SyncStatusParamExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {SyncStatusParamExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(SyncStatusParamExpressionHolder.class)});
    }

    public boolean isAcceptNull() {
        return false;
    }

    public boolean isIgnoreBadInput() {
        return false;
    }

    public Object transform(Object src)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public Object transform(Object src, String encoding)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public void setReturnClass(Class<?> theClass) {
        throw new UnsupportedOperationException();
    }

    public Class<?> getReturnClass() {
        return SyncStatusParam.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(SyncStatusParam.class);
    }

    public void setEndpoint(ImmutableEndpoint ep) {
        endpoint = ep;
    }

    public ImmutableEndpoint getEndpoint() {
        return endpoint;
    }

    public void dispose() {
    }

    public void initialise()
        throws InitialisationException
    {
    }

    public void setMuleContext(MuleContext context) {
        muleContext = context;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public Object transform(Object src, MuleEvent event)
        throws TransformerMessagingException
    {
        return transform(src, null, event);
    }

    public Object transform(Object src, String encoding, MuleEvent event)
        throws TransformerMessagingException
    {
        if (src == null) {
            return null;
        }
        SyncStatusParamExpressionHolder holder = ((SyncStatusParamExpressionHolder) src);
        SyncStatusParam result = new SyncStatusParam();
        try {
            final IdSet _transformedIdSet = ((IdSet) evaluateAndTransform(this.muleContext, event, SyncStatusParamExpressionHolder.class.getDeclaredField("_idSetType").getGenericType(), null, holder.getIdSet()));
            result.setIdSet(_transformedIdSet);
            final String _transformedSyncToken = ((String) evaluateAndTransform(this.muleContext, event, SyncStatusParamExpressionHolder.class.getDeclaredField("_syncTokenType").getGenericType(), null, holder.getSyncToken()));
            result.setSyncToken(_transformedSyncToken);
            final ObjectName _transformedObjectType = ((ObjectName) evaluateAndTransform(this.muleContext, event, SyncStatusParamExpressionHolder.class.getDeclaredField("_objectTypeType").getGenericType(), null, holder.getObjectType()));
            result.setObjectType(_transformedObjectType);
            final String _transformedPartyId = ((String) evaluateAndTransform(this.muleContext, event, SyncStatusParamExpressionHolder.class.getDeclaredField("_partyIdType").getGenericType(), null, holder.getPartyId()));
            result.setPartyId(_transformedPartyId);
        } catch (NoSuchFieldException e) {
            throw new TransformerMessagingException(CoreMessages.createStaticMessage("internal error"), event, this, e);
        } catch (TransformerException e) {
            throw new TransformerMessagingException(e.getI18nMessage(), event, this, e);
        }
        return result;
    }

    public MuleEvent process(MuleEvent event) {
        return null;
    }

    public String getMimeType() {
        return null;
    }

    public String getEncoding() {
        return null;
    }

    public MuleContext getMuleContext() {
        return muleContext;
    }

}
