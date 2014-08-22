
package com.intuit.ipp.data.transformers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.CreditChargeInfo;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.holders.CreditChargeInfoExpressionHolder;
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
public class CreditChargeInfoExpressionHolderTransformer
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
        return (aClass == CreditChargeInfoExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == CreditChargeInfoExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {CreditChargeInfoExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(CreditChargeInfoExpressionHolder.class)});
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
        return CreditChargeInfo.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(CreditChargeInfo.class);
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
        CreditChargeInfoExpressionHolder holder = ((CreditChargeInfoExpressionHolder) src);
        CreditChargeInfo result = new CreditChargeInfo();
        try {
            final String _transformedNumber = ((String) evaluateAndTransform(this.muleContext, event, CreditChargeInfoExpressionHolder.class.getDeclaredField("_numberType").getGenericType(), null, holder.getNumber()));
            result.setNumber(_transformedNumber);
            final String _transformedType = ((String) evaluateAndTransform(this.muleContext, event, CreditChargeInfoExpressionHolder.class.getDeclaredField("_typeType").getGenericType(), null, holder.getType()));
            result.setType(_transformedType);
            final String _transformedNameOnAcct = ((String) evaluateAndTransform(this.muleContext, event, CreditChargeInfoExpressionHolder.class.getDeclaredField("_nameOnAcctType").getGenericType(), null, holder.getNameOnAcct()));
            result.setNameOnAcct(_transformedNameOnAcct);
            final Integer _transformedCcExpiryMonth = ((Integer) evaluateAndTransform(this.muleContext, event, CreditChargeInfoExpressionHolder.class.getDeclaredField("_ccExpiryMonthType").getGenericType(), null, holder.getCcExpiryMonth()));
            result.setCcExpiryMonth(_transformedCcExpiryMonth);
            final Integer _transformedCcExpiryYear = ((Integer) evaluateAndTransform(this.muleContext, event, CreditChargeInfoExpressionHolder.class.getDeclaredField("_ccExpiryYearType").getGenericType(), null, holder.getCcExpiryYear()));
            result.setCcExpiryYear(_transformedCcExpiryYear);
            final String _transformedBillAddrStreet = ((String) evaluateAndTransform(this.muleContext, event, CreditChargeInfoExpressionHolder.class.getDeclaredField("_billAddrStreetType").getGenericType(), null, holder.getBillAddrStreet()));
            result.setBillAddrStreet(_transformedBillAddrStreet);
            final String _transformedPostalCode = ((String) evaluateAndTransform(this.muleContext, event, CreditChargeInfoExpressionHolder.class.getDeclaredField("_postalCodeType").getGenericType(), null, holder.getPostalCode()));
            result.setPostalCode(_transformedPostalCode);
            final String _transformedCommercialCardCode = ((String) evaluateAndTransform(this.muleContext, event, CreditChargeInfoExpressionHolder.class.getDeclaredField("_commercialCardCodeType").getGenericType(), null, holder.getCommercialCardCode()));
            result.setCommercialCardCode(_transformedCommercialCardCode);
            final String _transformedPrevCCTransId = ((String) evaluateAndTransform(this.muleContext, event, CreditChargeInfoExpressionHolder.class.getDeclaredField("_prevCCTransIdType").getGenericType(), null, holder.getPrevCCTransId()));
            result.setPrevCCTransId(_transformedPrevCCTransId);
            final BigDecimal _transformedAmount = ((BigDecimal) evaluateAndTransform(this.muleContext, event, CreditChargeInfoExpressionHolder.class.getDeclaredField("_amountType").getGenericType(), null, holder.getAmount()));
            result.setAmount(_transformedAmount);
            final Boolean _transformedProcessPayment = ((Boolean) evaluateAndTransform(this.muleContext, event, CreditChargeInfoExpressionHolder.class.getDeclaredField("_processPaymentType").getGenericType(), null, holder.getProcessPayment()));
            result.setProcessPayment(_transformedProcessPayment);
            final IntuitAnyType _transformedCreditCardChargeInfoEx = ((IntuitAnyType) evaluateAndTransform(this.muleContext, event, CreditChargeInfoExpressionHolder.class.getDeclaredField("_creditCardChargeInfoExType").getGenericType(), null, holder.getCreditCardChargeInfoEx()));
            result.setCreditCardChargeInfoEx(_transformedCreditCardChargeInfoEx);
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
