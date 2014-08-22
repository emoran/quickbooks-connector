
package com.intuit.ipp.data.transformers;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.BillPaymentCheck;
import com.intuit.ipp.data.CheckPayment;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.PhysicalAddress;
import com.intuit.ipp.data.PrintStatusEnum;
import com.intuit.ipp.data.ReferenceType;
import com.intuit.ipp.data.holders.BillPaymentCheckExpressionHolder;
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

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:35:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class BillPaymentCheckExpressionHolderTransformer
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
        return (aClass == BillPaymentCheckExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == BillPaymentCheckExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {BillPaymentCheckExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(BillPaymentCheckExpressionHolder.class)});
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
        return BillPaymentCheck.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(BillPaymentCheck.class);
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
        BillPaymentCheckExpressionHolder holder = ((BillPaymentCheckExpressionHolder) src);
        BillPaymentCheck result = new BillPaymentCheck();
        try {
            final ReferenceType _transformedBankAccountRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, BillPaymentCheckExpressionHolder.class.getDeclaredField("_bankAccountRefType").getGenericType(), null, holder.getBankAccountRef()));
            result.setBankAccountRef(_transformedBankAccountRef);
            final PrintStatusEnum _transformedPrintStatus = ((PrintStatusEnum) evaluateAndTransform(this.muleContext, event, BillPaymentCheckExpressionHolder.class.getDeclaredField("_printStatusType").getGenericType(), null, holder.getPrintStatus()));
            result.setPrintStatus(_transformedPrintStatus);
            final CheckPayment _transformedCheckDetail = ((CheckPayment) evaluateAndTransform(this.muleContext, event, BillPaymentCheckExpressionHolder.class.getDeclaredField("_checkDetailType").getGenericType(), null, holder.getCheckDetail()));
            result.setCheckDetail(_transformedCheckDetail);
            final PhysicalAddress _transformedPayeeAddr = ((PhysicalAddress) evaluateAndTransform(this.muleContext, event, BillPaymentCheckExpressionHolder.class.getDeclaredField("_payeeAddrType").getGenericType(), null, holder.getPayeeAddr()));
            result.setPayeeAddr(_transformedPayeeAddr);
            final IntuitAnyType _transformedBillPaymentCheckEx = ((IntuitAnyType) evaluateAndTransform(this.muleContext, event, BillPaymentCheckExpressionHolder.class.getDeclaredField("_billPaymentCheckExType").getGenericType(), null, holder.getBillPaymentCheckEx()));
            result.setBillPaymentCheckEx(_transformedBillPaymentCheckEx);
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
