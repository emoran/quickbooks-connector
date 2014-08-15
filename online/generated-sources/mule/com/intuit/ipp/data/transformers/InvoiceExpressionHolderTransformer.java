
package com.intuit.ipp.data.transformers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.AttachableRef;
import com.intuit.ipp.data.CheckPayment;
import com.intuit.ipp.data.CreditCardPayment;
import com.intuit.ipp.data.CustomField;
import com.intuit.ipp.data.ETransactionStatusEnum;
import com.intuit.ipp.data.EmailAddress;
import com.intuit.ipp.data.EmailStatusEnum;
import com.intuit.ipp.data.EntityStatusEnum;
import com.intuit.ipp.data.GlobalTaxCalculationEnum;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.data.Line;
import com.intuit.ipp.data.LinkedTxn;
import com.intuit.ipp.data.MemoRef;
import com.intuit.ipp.data.ModificationMetaData;
import com.intuit.ipp.data.PaymentTypeEnum;
import com.intuit.ipp.data.PhysicalAddress;
import com.intuit.ipp.data.PrintStatusEnum;
import com.intuit.ipp.data.ReferenceType;
import com.intuit.ipp.data.TransactionDeliveryInfo;
import com.intuit.ipp.data.TxnTaxDetail;
import com.intuit.ipp.data.holders.IntuitEntityExpressionHolder;
import com.intuit.ipp.data.holders.InvoiceExpressionHolder;
import com.intuit.ipp.data.holders.SalesTransactionExpressionHolder;
import com.intuit.ipp.data.holders.TransactionExpressionHolder;
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

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-15T04:14:53-05:00", comments = "Build 3.4.3.1620.30ea288")
public class InvoiceExpressionHolderTransformer
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
        return (aClass == InvoiceExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == InvoiceExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {InvoiceExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(InvoiceExpressionHolder.class)});
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
        return Invoice.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(Invoice.class);
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
        InvoiceExpressionHolder holder = ((InvoiceExpressionHolder) src);
        Invoice result = new Invoice();
        try {
            final BigDecimal _transformedDeposit = ((BigDecimal) evaluateAndTransform(this.muleContext, event, InvoiceExpressionHolder.class.getDeclaredField("_depositType").getGenericType(), null, holder.getDeposit()));
            result.setDeposit(_transformedDeposit);
            final Boolean _transformedAllowIPNPayment = ((Boolean) evaluateAndTransform(this.muleContext, event, InvoiceExpressionHolder.class.getDeclaredField("_allowIPNPaymentType").getGenericType(), null, holder.getAllowIPNPayment()));
            result.setAllowIPNPayment(_transformedAllowIPNPayment);
            final Boolean _transformedAllowOnlinePayment = ((Boolean) evaluateAndTransform(this.muleContext, event, InvoiceExpressionHolder.class.getDeclaredField("_allowOnlinePaymentType").getGenericType(), null, holder.getAllowOnlinePayment()));
            result.setAllowOnlinePayment(_transformedAllowOnlinePayment);
            final Boolean _transformedAllowOnlineCreditCardPayment = ((Boolean) evaluateAndTransform(this.muleContext, event, InvoiceExpressionHolder.class.getDeclaredField("_allowOnlineCreditCardPaymentType").getGenericType(), null, holder.getAllowOnlineCreditCardPayment()));
            result.setAllowOnlineCreditCardPayment(_transformedAllowOnlineCreditCardPayment);
            final Boolean _transformedAllowOnlineACHPayment = ((Boolean) evaluateAndTransform(this.muleContext, event, InvoiceExpressionHolder.class.getDeclaredField("_allowOnlineACHPaymentType").getGenericType(), null, holder.getAllowOnlineACHPayment()));
            result.setAllowOnlineACHPayment(_transformedAllowOnlineACHPayment);
            final ETransactionStatusEnum _transformedEInvoiceStatus = ((ETransactionStatusEnum) evaluateAndTransform(this.muleContext, event, InvoiceExpressionHolder.class.getDeclaredField("_eInvoiceStatusType").getGenericType(), null, holder.getEInvoiceStatus()));
            result.setEInvoiceStatus(_transformedEInvoiceStatus);
            final Date _transformedECloudStatusTimeStamp = ((Date) evaluateAndTransform(this.muleContext, event, InvoiceExpressionHolder.class.getDeclaredField("_eCloudStatusTimeStampType").getGenericType(), null, holder.getECloudStatusTimeStamp()));
            result.setECloudStatusTimeStamp(_transformedECloudStatusTimeStamp);
            final IntuitAnyType _transformedInvoiceEx = ((IntuitAnyType) evaluateAndTransform(this.muleContext, event, InvoiceExpressionHolder.class.getDeclaredField("_invoiceExType").getGenericType(), null, holder.getInvoiceEx()));
            result.setInvoiceEx(_transformedInvoiceEx);
            final Boolean _transformedAutoDocNumber = ((Boolean) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_autoDocNumberType").getGenericType(), null, holder.getAutoDocNumber()));
            result.setAutoDocNumber(_transformedAutoDocNumber);
            final ReferenceType _transformedCustomerRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_customerRefType").getGenericType(), null, holder.getCustomerRef()));
            result.setCustomerRef(_transformedCustomerRef);
            final MemoRef _transformedCustomerMemo = ((MemoRef) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_customerMemoType").getGenericType(), null, holder.getCustomerMemo()));
            result.setCustomerMemo(_transformedCustomerMemo);
            final PhysicalAddress _transformedBillAddr = ((PhysicalAddress) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_billAddrType").getGenericType(), null, holder.getBillAddr()));
            result.setBillAddr(_transformedBillAddr);
            final PhysicalAddress _transformedShipAddr = ((PhysicalAddress) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_shipAddrType").getGenericType(), null, holder.getShipAddr()));
            result.setShipAddr(_transformedShipAddr);
            final ReferenceType _transformedRemitToRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_remitToRefType").getGenericType(), null, holder.getRemitToRef()));
            result.setRemitToRef(_transformedRemitToRef);
            final ReferenceType _transformedClassRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_classRefType").getGenericType(), null, holder.getClassRef()));
            result.setClassRef(_transformedClassRef);
            final ReferenceType _transformedSalesTermRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_salesTermRefType").getGenericType(), null, holder.getSalesTermRef()));
            result.setSalesTermRef(_transformedSalesTermRef);
            final Date _transformedDueDate = ((Date) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_dueDateType").getGenericType(), null, holder.getDueDate()));
            result.setDueDate(_transformedDueDate);
            final ReferenceType _transformedSalesRepRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_salesRepRefType").getGenericType(), null, holder.getSalesRepRef()));
            result.setSalesRepRef(_transformedSalesRepRef);
            final ReferenceType _transformedShipMethodRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_shipMethodRefType").getGenericType(), null, holder.getShipMethodRef()));
            result.setShipMethodRef(_transformedShipMethodRef);
            final Date _transformedShipDate = ((Date) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_shipDateType").getGenericType(), null, holder.getShipDate()));
            result.setShipDate(_transformedShipDate);
            final String _transformedTrackingNum = ((String) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_trackingNumType").getGenericType(), null, holder.getTrackingNum()));
            result.setTrackingNum(_transformedTrackingNum);
            final GlobalTaxCalculationEnum _transformedGlobalTaxCalculation = ((GlobalTaxCalculationEnum) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_globalTaxCalculationType").getGenericType(), null, holder.getGlobalTaxCalculation()));
            result.setGlobalTaxCalculation(_transformedGlobalTaxCalculation);
            final BigDecimal _transformedTotalAmt = ((BigDecimal) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_totalAmtType").getGenericType(), null, holder.getTotalAmt()));
            result.setTotalAmt(_transformedTotalAmt);
            final BigDecimal _transformedHomeTotalAmt = ((BigDecimal) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_homeTotalAmtType").getGenericType(), null, holder.getHomeTotalAmt()));
            result.setHomeTotalAmt(_transformedHomeTotalAmt);
            final Boolean _transformedApplyTaxAfterDiscount = ((Boolean) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_applyTaxAfterDiscountType").getGenericType(), null, holder.getApplyTaxAfterDiscount()));
            result.setApplyTaxAfterDiscount(_transformedApplyTaxAfterDiscount);
            final ReferenceType _transformedTemplateRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_templateRefType").getGenericType(), null, holder.getTemplateRef()));
            result.setTemplateRef(_transformedTemplateRef);
            final PrintStatusEnum _transformedPrintStatus = ((PrintStatusEnum) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_printStatusType").getGenericType(), null, holder.getPrintStatus()));
            result.setPrintStatus(_transformedPrintStatus);
            final EmailStatusEnum _transformedEmailStatus = ((EmailStatusEnum) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_emailStatusType").getGenericType(), null, holder.getEmailStatus()));
            result.setEmailStatus(_transformedEmailStatus);
            final EmailAddress _transformedBillEmail = ((EmailAddress) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_billEmailType").getGenericType(), null, holder.getBillEmail()));
            result.setBillEmail(_transformedBillEmail);
            final BigDecimal _transformedBalance = ((BigDecimal) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_balanceType").getGenericType(), null, holder.getBalance()));
            result.setBalance(_transformedBalance);
            final Boolean _transformedFinanceCharge = ((Boolean) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_financeChargeType").getGenericType(), null, holder.getFinanceCharge()));
            result.setFinanceCharge(_transformedFinanceCharge);
            final ReferenceType _transformedPaymentMethodRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_paymentMethodRefType").getGenericType(), null, holder.getPaymentMethodRef()));
            result.setPaymentMethodRef(_transformedPaymentMethodRef);
            final String _transformedPaymentRefNum = ((String) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_paymentRefNumType").getGenericType(), null, holder.getPaymentRefNum()));
            result.setPaymentRefNum(_transformedPaymentRefNum);
            final PaymentTypeEnum _transformedPaymentType = ((PaymentTypeEnum) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_paymentTypeType").getGenericType(), null, holder.getPaymentType()));
            result.setPaymentType(_transformedPaymentType);
            final CheckPayment _transformedCheckPayment = ((CheckPayment) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_checkPaymentType").getGenericType(), null, holder.getCheckPayment()));
            result.setCheckPayment(_transformedCheckPayment);
            final CreditCardPayment _transformedCreditCardPayment = ((CreditCardPayment) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_creditCardPaymentType").getGenericType(), null, holder.getCreditCardPayment()));
            result.setCreditCardPayment(_transformedCreditCardPayment);
            final ReferenceType _transformedDepositToAccountRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_depositToAccountRefType").getGenericType(), null, holder.getDepositToAccountRef()));
            result.setDepositToAccountRef(_transformedDepositToAccountRef);
            final TransactionDeliveryInfo _transformedDeliveryInfo = ((TransactionDeliveryInfo) evaluateAndTransform(this.muleContext, event, SalesTransactionExpressionHolder.class.getDeclaredField("_deliveryInfoType").getGenericType(), null, holder.getDeliveryInfo()));
            result.setDeliveryInfo(_transformedDeliveryInfo);
            final String _transformedDocNumber = ((String) evaluateAndTransform(this.muleContext, event, TransactionExpressionHolder.class.getDeclaredField("_docNumberType").getGenericType(), null, holder.getDocNumber()));
            result.setDocNumber(_transformedDocNumber);
            final Date _transformedTxnDate = ((Date) evaluateAndTransform(this.muleContext, event, TransactionExpressionHolder.class.getDeclaredField("_txnDateType").getGenericType(), null, holder.getTxnDate()));
            result.setTxnDate(_transformedTxnDate);
            final ReferenceType _transformedDepartmentRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, TransactionExpressionHolder.class.getDeclaredField("_departmentRefType").getGenericType(), null, holder.getDepartmentRef()));
            result.setDepartmentRef(_transformedDepartmentRef);
            final ReferenceType _transformedCurrencyRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, TransactionExpressionHolder.class.getDeclaredField("_currencyRefType").getGenericType(), null, holder.getCurrencyRef()));
            result.setCurrencyRef(_transformedCurrencyRef);
            final BigDecimal _transformedExchangeRate = ((BigDecimal) evaluateAndTransform(this.muleContext, event, TransactionExpressionHolder.class.getDeclaredField("_exchangeRateType").getGenericType(), null, holder.getExchangeRate()));
            result.setExchangeRate(_transformedExchangeRate);
            final String _transformedPrivateNote = ((String) evaluateAndTransform(this.muleContext, event, TransactionExpressionHolder.class.getDeclaredField("_privateNoteType").getGenericType(), null, holder.getPrivateNote()));
            result.setPrivateNote(_transformedPrivateNote);
            final String _transformedTxnStatus = ((String) evaluateAndTransform(this.muleContext, event, TransactionExpressionHolder.class.getDeclaredField("_txnStatusType").getGenericType(), null, holder.getTxnStatus()));
            result.setTxnStatus(_transformedTxnStatus);
            final List<LinkedTxn> _transformedLinkedTxn = ((List<LinkedTxn> ) evaluateAndTransform(this.muleContext, event, TransactionExpressionHolder.class.getDeclaredField("_linkedTxnType").getGenericType(), null, holder.getLinkedTxn()));
            result.setLinkedTxn(_transformedLinkedTxn);
            final List<Line> _transformedLine = ((List<Line> ) evaluateAndTransform(this.muleContext, event, TransactionExpressionHolder.class.getDeclaredField("_lineType").getGenericType(), null, holder.getLine()));
            result.setLine(_transformedLine);
            final TxnTaxDetail _transformedTxnTaxDetail = ((TxnTaxDetail) evaluateAndTransform(this.muleContext, event, TransactionExpressionHolder.class.getDeclaredField("_txnTaxDetailType").getGenericType(), null, holder.getTxnTaxDetail()));
            result.setTxnTaxDetail(_transformedTxnTaxDetail);
            final String _transformedTxnSource = ((String) evaluateAndTransform(this.muleContext, event, TransactionExpressionHolder.class.getDeclaredField("_txnSourceType").getGenericType(), null, holder.getTxnSource()));
            result.setTxnSource(_transformedTxnSource);
            final String _transformedId = ((String) evaluateAndTransform(this.muleContext, event, IntuitEntityExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
            result.setId(_transformedId);
            final String _transformedSyncToken = ((String) evaluateAndTransform(this.muleContext, event, IntuitEntityExpressionHolder.class.getDeclaredField("_syncTokenType").getGenericType(), null, holder.getSyncToken()));
            result.setSyncToken(_transformedSyncToken);
            final ModificationMetaData _transformedMetaData = ((ModificationMetaData) evaluateAndTransform(this.muleContext, event, IntuitEntityExpressionHolder.class.getDeclaredField("_metaDataType").getGenericType(), null, holder.getMetaData()));
            result.setMetaData(_transformedMetaData);
            final List<CustomField> _transformedCustomField = ((List<CustomField> ) evaluateAndTransform(this.muleContext, event, IntuitEntityExpressionHolder.class.getDeclaredField("_customFieldType").getGenericType(), null, holder.getCustomField()));
            result.setCustomField(_transformedCustomField);
            final List<AttachableRef> _transformedAttachableRef = ((List<AttachableRef> ) evaluateAndTransform(this.muleContext, event, IntuitEntityExpressionHolder.class.getDeclaredField("_attachableRefType").getGenericType(), null, holder.getAttachableRef()));
            result.setAttachableRef(_transformedAttachableRef);
            final String _transformedDomain = ((String) evaluateAndTransform(this.muleContext, event, IntuitEntityExpressionHolder.class.getDeclaredField("_domainType").getGenericType(), null, holder.getDomain()));
            result.setDomain(_transformedDomain);
            final EntityStatusEnum _transformedStatus = ((EntityStatusEnum) evaluateAndTransform(this.muleContext, event, IntuitEntityExpressionHolder.class.getDeclaredField("_statusType").getGenericType(), null, holder.getStatus()));
            result.setStatus(_transformedStatus);
            final Boolean _transformedSparse = ((Boolean) evaluateAndTransform(this.muleContext, event, IntuitEntityExpressionHolder.class.getDeclaredField("_sparseType").getGenericType(), null, holder.getSparse()));
            result.setSparse(_transformedSparse);
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
