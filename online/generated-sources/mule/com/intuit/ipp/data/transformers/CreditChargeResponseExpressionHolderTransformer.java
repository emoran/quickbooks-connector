
package com.intuit.ipp.data.transformers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.CCAVSMatchEnum;
import com.intuit.ipp.data.CCPaymentStatusEnum;
import com.intuit.ipp.data.CCSecurityCodeMatchEnum;
import com.intuit.ipp.data.CreditChargeResponse;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.holders.CreditChargeResponseExpressionHolder;
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

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T10:01:32-05:00", comments = "Build 3.4.3.1620.30ea288")
public class CreditChargeResponseExpressionHolderTransformer
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
        return (aClass == CreditChargeResponseExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == CreditChargeResponseExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {CreditChargeResponseExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(CreditChargeResponseExpressionHolder.class)});
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
        return CreditChargeResponse.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(CreditChargeResponse.class);
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
        CreditChargeResponseExpressionHolder holder = ((CreditChargeResponseExpressionHolder) src);
        CreditChargeResponse result = new CreditChargeResponse();
        try {
            final CCPaymentStatusEnum _transformedStatus = ((CCPaymentStatusEnum) evaluateAndTransform(this.muleContext, event, CreditChargeResponseExpressionHolder.class.getDeclaredField("_statusType").getGenericType(), null, holder.getStatus()));
            result.setStatus(_transformedStatus);
            final Integer _transformedResultCode = ((Integer) evaluateAndTransform(this.muleContext, event, CreditChargeResponseExpressionHolder.class.getDeclaredField("_resultCodeType").getGenericType(), null, holder.getResultCode()));
            result.setResultCode(_transformedResultCode);
            final String _transformedResultMsg = ((String) evaluateAndTransform(this.muleContext, event, CreditChargeResponseExpressionHolder.class.getDeclaredField("_resultMsgType").getGenericType(), null, holder.getResultMsg()));
            result.setResultMsg(_transformedResultMsg);
            final String _transformedMerchantAcctNum = ((String) evaluateAndTransform(this.muleContext, event, CreditChargeResponseExpressionHolder.class.getDeclaredField("_merchantAcctNumType").getGenericType(), null, holder.getMerchantAcctNum()));
            result.setMerchantAcctNum(_transformedMerchantAcctNum);
            final CCSecurityCodeMatchEnum _transformedCardSecurityCodeMatch = ((CCSecurityCodeMatchEnum) evaluateAndTransform(this.muleContext, event, CreditChargeResponseExpressionHolder.class.getDeclaredField("_cardSecurityCodeMatchType").getGenericType(), null, holder.getCardSecurityCodeMatch()));
            result.setCardSecurityCodeMatch(_transformedCardSecurityCodeMatch);
            final String _transformedAuthCode = ((String) evaluateAndTransform(this.muleContext, event, CreditChargeResponseExpressionHolder.class.getDeclaredField("_authCodeType").getGenericType(), null, holder.getAuthCode()));
            result.setAuthCode(_transformedAuthCode);
            final CCAVSMatchEnum _transformedAvsStreet = ((CCAVSMatchEnum) evaluateAndTransform(this.muleContext, event, CreditChargeResponseExpressionHolder.class.getDeclaredField("_avsStreetType").getGenericType(), null, holder.getAvsStreet()));
            result.setAvsStreet(_transformedAvsStreet);
            final CCAVSMatchEnum _transformedAvsZip = ((CCAVSMatchEnum) evaluateAndTransform(this.muleContext, event, CreditChargeResponseExpressionHolder.class.getDeclaredField("_avsZipType").getGenericType(), null, holder.getAvsZip()));
            result.setAvsZip(_transformedAvsZip);
            final String _transformedSecurityCode = ((String) evaluateAndTransform(this.muleContext, event, CreditChargeResponseExpressionHolder.class.getDeclaredField("_securityCodeType").getGenericType(), null, holder.getSecurityCode()));
            result.setSecurityCode(_transformedSecurityCode);
            final String _transformedReconBatchId = ((String) evaluateAndTransform(this.muleContext, event, CreditChargeResponseExpressionHolder.class.getDeclaredField("_reconBatchIdType").getGenericType(), null, holder.getReconBatchId()));
            result.setReconBatchId(_transformedReconBatchId);
            final Integer _transformedPaymentGroupingCode = ((Integer) evaluateAndTransform(this.muleContext, event, CreditChargeResponseExpressionHolder.class.getDeclaredField("_paymentGroupingCodeType").getGenericType(), null, holder.getPaymentGroupingCode()));
            result.setPaymentGroupingCode(_transformedPaymentGroupingCode);
            final Date _transformedTxnAuthorizationTime = ((Date) evaluateAndTransform(this.muleContext, event, CreditChargeResponseExpressionHolder.class.getDeclaredField("_txnAuthorizationTimeType").getGenericType(), null, holder.getTxnAuthorizationTime()));
            result.setTxnAuthorizationTime(_transformedTxnAuthorizationTime);
            final Integer _transformedTxnAuthorizationStamp = ((Integer) evaluateAndTransform(this.muleContext, event, CreditChargeResponseExpressionHolder.class.getDeclaredField("_txnAuthorizationStampType").getGenericType(), null, holder.getTxnAuthorizationStamp()));
            result.setTxnAuthorizationStamp(_transformedTxnAuthorizationStamp);
            final String _transformedClientTransID = ((String) evaluateAndTransform(this.muleContext, event, CreditChargeResponseExpressionHolder.class.getDeclaredField("_clientTransIDType").getGenericType(), null, holder.getClientTransID()));
            result.setClientTransID(_transformedClientTransID);
            final IntuitAnyType _transformedCreditChargeResponseEx = ((IntuitAnyType) evaluateAndTransform(this.muleContext, event, CreditChargeResponseExpressionHolder.class.getDeclaredField("_creditChargeResponseExType").getGenericType(), null, holder.getCreditChargeResponseEx()));
            result.setCreditChargeResponseEx(_transformedCreditChargeResponseEx);
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
