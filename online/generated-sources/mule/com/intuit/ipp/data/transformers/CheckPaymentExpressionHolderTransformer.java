
package com.intuit.ipp.data.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.CheckPayment;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.holders.CheckPaymentExpressionHolder;
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
import org.mule.modules.quickbooks.online.processors.AbstractExpressionEvaluator;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-21T02:54:07-05:00", comments = "Build 3.4.3.1620.30ea288")
public class CheckPaymentExpressionHolderTransformer
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
        return (aClass == CheckPaymentExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == CheckPaymentExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {CheckPaymentExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(CheckPaymentExpressionHolder.class)});
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
        return CheckPayment.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(CheckPayment.class);
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
        CheckPaymentExpressionHolder holder = ((CheckPaymentExpressionHolder) src);
        CheckPayment result = new CheckPayment();
        try {
            final String _transformedCheckNum = ((String) evaluateAndTransform(this.muleContext, event, CheckPaymentExpressionHolder.class.getDeclaredField("_checkNumType").getGenericType(), null, holder.getCheckNum()));
            result.setCheckNum(_transformedCheckNum);
            final String _transformedStatus = ((String) evaluateAndTransform(this.muleContext, event, CheckPaymentExpressionHolder.class.getDeclaredField("_statusType").getGenericType(), null, holder.getStatus()));
            result.setStatus(_transformedStatus);
            final String _transformedNameOnAcct = ((String) evaluateAndTransform(this.muleContext, event, CheckPaymentExpressionHolder.class.getDeclaredField("_nameOnAcctType").getGenericType(), null, holder.getNameOnAcct()));
            result.setNameOnAcct(_transformedNameOnAcct);
            final String _transformedAcctNum = ((String) evaluateAndTransform(this.muleContext, event, CheckPaymentExpressionHolder.class.getDeclaredField("_acctNumType").getGenericType(), null, holder.getAcctNum()));
            result.setAcctNum(_transformedAcctNum);
            final String _transformedBankName = ((String) evaluateAndTransform(this.muleContext, event, CheckPaymentExpressionHolder.class.getDeclaredField("_bankNameType").getGenericType(), null, holder.getBankName()));
            result.setBankName(_transformedBankName);
            final IntuitAnyType _transformedCheckPaymentEx = ((IntuitAnyType) evaluateAndTransform(this.muleContext, event, CheckPaymentExpressionHolder.class.getDeclaredField("_checkPaymentExType").getGenericType(), null, holder.getCheckPaymentEx()));
            result.setCheckPaymentEx(_transformedCheckPaymentEx);
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
