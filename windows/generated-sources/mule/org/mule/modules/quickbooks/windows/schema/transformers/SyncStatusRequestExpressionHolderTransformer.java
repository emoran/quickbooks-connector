
package org.mule.modules.quickbooks.windows.schema.transformers;

import java.util.Arrays;
import java.util.Date;
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
import org.mule.modules.quickbooks.windows.schema.NgIdSet;
import org.mule.modules.quickbooks.windows.schema.OfferingId;
import org.mule.modules.quickbooks.windows.schema.SyncStatusParam;
import org.mule.modules.quickbooks.windows.schema.SyncStatusRequest;
import org.mule.modules.quickbooks.windows.schema.holders.SyncStatusRequestExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:33:09-05:00", comments = "Build 3.4.3.1620.30ea288")
public class SyncStatusRequestExpressionHolderTransformer
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
        return (aClass == SyncStatusRequestExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == SyncStatusRequestExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {SyncStatusRequestExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(SyncStatusRequestExpressionHolder.class)});
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
        return SyncStatusRequest.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(SyncStatusRequest.class);
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
        SyncStatusRequestExpressionHolder holder = ((SyncStatusRequestExpressionHolder) src);
        SyncStatusRequest result = new SyncStatusRequest();
        try {
            final OfferingId _transformedOfferingId = ((OfferingId) evaluateAndTransform(this.muleContext, event, SyncStatusRequestExpressionHolder.class.getDeclaredField("_offeringIdType").getGenericType(), null, holder.getOfferingId()));
            result.setOfferingId(_transformedOfferingId);
            final List<NgIdSet> _transformedNgIdSet = ((List<NgIdSet> ) evaluateAndTransform(this.muleContext, event, SyncStatusRequestExpressionHolder.class.getDeclaredField("_ngIdSetType").getGenericType(), null, holder.getNgIdSet()));
            result.setNgIdSet(_transformedNgIdSet);
            final List<SyncStatusParam> _transformedSyncStatusParam = ((List<SyncStatusParam> ) evaluateAndTransform(this.muleContext, event, SyncStatusRequestExpressionHolder.class.getDeclaredField("_syncStatusParamType").getGenericType(), null, holder.getSyncStatusParam()));
            result.setSyncStatusParam(_transformedSyncStatusParam);
            final List<String> _transformedRequestId = ((List<String> ) evaluateAndTransform(this.muleContext, event, SyncStatusRequestExpressionHolder.class.getDeclaredField("_requestIdType").getGenericType(), null, holder.getRequestId()));
            result.setRequestId(_transformedRequestId);
            final List<String> _transformedBatchId = ((List<String> ) evaluateAndTransform(this.muleContext, event, SyncStatusRequestExpressionHolder.class.getDeclaredField("_batchIdType").getGenericType(), null, holder.getBatchId()));
            result.setBatchId(_transformedBatchId);
            final Date _transformedStartCreatedTMS = ((Date) evaluateAndTransform(this.muleContext, event, SyncStatusRequestExpressionHolder.class.getDeclaredField("_startCreatedTMSType").getGenericType(), null, holder.getStartCreatedTMS()));
            result.setStartCreatedTMS(_transformedStartCreatedTMS);
            final Date _transformedEndCreatedTMS = ((Date) evaluateAndTransform(this.muleContext, event, SyncStatusRequestExpressionHolder.class.getDeclaredField("_endCreatedTMSType").getGenericType(), null, holder.getEndCreatedTMS()));
            result.setEndCreatedTMS(_transformedEndCreatedTMS);
            final Boolean _transformedErroredObjectsOnly = ((Boolean) evaluateAndTransform(this.muleContext, event, SyncStatusRequestExpressionHolder.class.getDeclaredField("_erroredObjectsOnlyType").getGenericType(), null, holder.getErroredObjectsOnly()));
            result.setErroredObjectsOnly(_transformedErroredObjectsOnly);
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
