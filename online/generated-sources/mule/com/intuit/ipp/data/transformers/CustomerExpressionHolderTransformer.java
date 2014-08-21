
package com.intuit.ipp.data.transformers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.AttachableRef;
import com.intuit.ipp.data.ContactInfo;
import com.intuit.ipp.data.CustomField;
import com.intuit.ipp.data.Customer;
import com.intuit.ipp.data.EmailAddress;
import com.intuit.ipp.data.EntityStatusEnum;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.JobInfo;
import com.intuit.ipp.data.ModificationMetaData;
import com.intuit.ipp.data.PhysicalAddress;
import com.intuit.ipp.data.ReferenceType;
import com.intuit.ipp.data.TelephoneNumber;
import com.intuit.ipp.data.WebSiteAddress;
import com.intuit.ipp.data.holders.CustomerExpressionHolder;
import com.intuit.ipp.data.holders.IntuitEntityExpressionHolder;
import com.intuit.ipp.data.holders.NameBaseExpressionHolder;
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
public class CustomerExpressionHolderTransformer
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
        return (aClass == CustomerExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == CustomerExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {CustomerExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(CustomerExpressionHolder.class)});
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
        return Customer.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(Customer.class);
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
        CustomerExpressionHolder holder = ((CustomerExpressionHolder) src);
        Customer result = new Customer();
        try {
            final Boolean _transformedTaxable = ((Boolean) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_taxableType").getGenericType(), null, holder.getTaxable()));
            result.setTaxable(_transformedTaxable);
            final PhysicalAddress _transformedBillAddr = ((PhysicalAddress) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_billAddrType").getGenericType(), null, holder.getBillAddr()));
            result.setBillAddr(_transformedBillAddr);
            final PhysicalAddress _transformedShipAddr = ((PhysicalAddress) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_shipAddrType").getGenericType(), null, holder.getShipAddr()));
            result.setShipAddr(_transformedShipAddr);
            final List<PhysicalAddress> _transformedOtherAddr = ((List<PhysicalAddress> ) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_otherAddrType").getGenericType(), null, holder.getOtherAddr()));
            result.setOtherAddr(_transformedOtherAddr);
            final String _transformedContactName = ((String) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_contactNameType").getGenericType(), null, holder.getContactName()));
            result.setContactName(_transformedContactName);
            final String _transformedAltContactName = ((String) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_altContactNameType").getGenericType(), null, holder.getAltContactName()));
            result.setAltContactName(_transformedAltContactName);
            final String _transformedNotes = ((String) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_notesType").getGenericType(), null, holder.getNotes()));
            result.setNotes(_transformedNotes);
            final Boolean _transformedJob = ((Boolean) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_jobType").getGenericType(), null, holder.getJob()));
            result.setJob(_transformedJob);
            final Boolean _transformedBillWithParent = ((Boolean) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_billWithParentType").getGenericType(), null, holder.getBillWithParent()));
            result.setBillWithParent(_transformedBillWithParent);
            final ReferenceType _transformedRootCustomerRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_rootCustomerRefType").getGenericType(), null, holder.getRootCustomerRef()));
            result.setRootCustomerRef(_transformedRootCustomerRef);
            final ReferenceType _transformedParentRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_parentRefType").getGenericType(), null, holder.getParentRef()));
            result.setParentRef(_transformedParentRef);
            final Integer _transformedLevel = ((Integer) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_levelType").getGenericType(), null, holder.getLevel()));
            result.setLevel(_transformedLevel);
            final ReferenceType _transformedCustomerTypeRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_customerTypeRefType").getGenericType(), null, holder.getCustomerTypeRef()));
            result.setCustomerTypeRef(_transformedCustomerTypeRef);
            final ReferenceType _transformedSalesTermRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_salesTermRefType").getGenericType(), null, holder.getSalesTermRef()));
            result.setSalesTermRef(_transformedSalesTermRef);
            final ReferenceType _transformedSalesRepRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_salesRepRefType").getGenericType(), null, holder.getSalesRepRef()));
            result.setSalesRepRef(_transformedSalesRepRef);
            final ReferenceType _transformedTaxGroupCodeRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_taxGroupCodeRefType").getGenericType(), null, holder.getTaxGroupCodeRef()));
            result.setTaxGroupCodeRef(_transformedTaxGroupCodeRef);
            final ReferenceType _transformedTaxRateRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_taxRateRefType").getGenericType(), null, holder.getTaxRateRef()));
            result.setTaxRateRef(_transformedTaxRateRef);
            final ReferenceType _transformedPaymentMethodRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_paymentMethodRefType").getGenericType(), null, holder.getPaymentMethodRef()));
            result.setPaymentMethodRef(_transformedPaymentMethodRef);
            final ReferenceType _transformedPriceLevelRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_priceLevelRefType").getGenericType(), null, holder.getPriceLevelRef()));
            result.setPriceLevelRef(_transformedPriceLevelRef);
            final BigDecimal _transformedBalance = ((BigDecimal) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_balanceType").getGenericType(), null, holder.getBalance()));
            result.setBalance(_transformedBalance);
            final Date _transformedOpenBalanceDate = ((Date) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_openBalanceDateType").getGenericType(), null, holder.getOpenBalanceDate()));
            result.setOpenBalanceDate(_transformedOpenBalanceDate);
            final BigDecimal _transformedBalanceWithJobs = ((BigDecimal) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_balanceWithJobsType").getGenericType(), null, holder.getBalanceWithJobs()));
            result.setBalanceWithJobs(_transformedBalanceWithJobs);
            final BigDecimal _transformedCreditLimit = ((BigDecimal) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_creditLimitType").getGenericType(), null, holder.getCreditLimit()));
            result.setCreditLimit(_transformedCreditLimit);
            final String _transformedAcctNum = ((String) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_acctNumType").getGenericType(), null, holder.getAcctNum()));
            result.setAcctNum(_transformedAcctNum);
            final ReferenceType _transformedCurrencyRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_currencyRefType").getGenericType(), null, holder.getCurrencyRef()));
            result.setCurrencyRef(_transformedCurrencyRef);
            final BigDecimal _transformedOverDueBalance = ((BigDecimal) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_overDueBalanceType").getGenericType(), null, holder.getOverDueBalance()));
            result.setOverDueBalance(_transformedOverDueBalance);
            final BigDecimal _transformedTotalRevenue = ((BigDecimal) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_totalRevenueType").getGenericType(), null, holder.getTotalRevenue()));
            result.setTotalRevenue(_transformedTotalRevenue);
            final BigDecimal _transformedTotalExpense = ((BigDecimal) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_totalExpenseType").getGenericType(), null, holder.getTotalExpense()));
            result.setTotalExpense(_transformedTotalExpense);
            final String _transformedPreferredDeliveryMethod = ((String) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_preferredDeliveryMethodType").getGenericType(), null, holder.getPreferredDeliveryMethod()));
            result.setPreferredDeliveryMethod(_transformedPreferredDeliveryMethod);
            final String _transformedResaleNum = ((String) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_resaleNumType").getGenericType(), null, holder.getResaleNum()));
            result.setResaleNum(_transformedResaleNum);
            final JobInfo _transformedJobInfo = ((JobInfo) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_jobInfoType").getGenericType(), null, holder.getJobInfo()));
            result.setJobInfo(_transformedJobInfo);
            final IntuitAnyType _transformedCustomerEx = ((IntuitAnyType) evaluateAndTransform(this.muleContext, event, CustomerExpressionHolder.class.getDeclaredField("_customerExType").getGenericType(), null, holder.getCustomerEx()));
            result.setCustomerEx(_transformedCustomerEx);
            final String _transformedIntuitId = ((String) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_intuitIdType").getGenericType(), null, holder.getIntuitId()));
            result.setIntuitId(_transformedIntuitId);
            final Boolean _transformedOrganization = ((Boolean) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_organizationType").getGenericType(), null, holder.getOrganization()));
            result.setOrganization(_transformedOrganization);
            final String _transformedTitle = ((String) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_titleType").getGenericType(), null, holder.getTitle()));
            result.setTitle(_transformedTitle);
            final String _transformedGivenName = ((String) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_givenNameType").getGenericType(), null, holder.getGivenName()));
            result.setGivenName(_transformedGivenName);
            final String _transformedMiddleName = ((String) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_middleNameType").getGenericType(), null, holder.getMiddleName()));
            result.setMiddleName(_transformedMiddleName);
            final String _transformedFamilyName = ((String) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_familyNameType").getGenericType(), null, holder.getFamilyName()));
            result.setFamilyName(_transformedFamilyName);
            final String _transformedSuffix = ((String) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_suffixType").getGenericType(), null, holder.getSuffix()));
            result.setSuffix(_transformedSuffix);
            final String _transformedFullyQualifiedName = ((String) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_fullyQualifiedNameType").getGenericType(), null, holder.getFullyQualifiedName()));
            result.setFullyQualifiedName(_transformedFullyQualifiedName);
            final String _transformedCompanyName = ((String) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_companyNameType").getGenericType(), null, holder.getCompanyName()));
            result.setCompanyName(_transformedCompanyName);
            final String _transformedDisplayName = ((String) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_displayNameType").getGenericType(), null, holder.getDisplayName()));
            result.setDisplayName(_transformedDisplayName);
            final String _transformedPrintOnCheckName = ((String) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_printOnCheckNameType").getGenericType(), null, holder.getPrintOnCheckName()));
            result.setPrintOnCheckName(_transformedPrintOnCheckName);
            final String _transformedUserId = ((String) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_userIdType").getGenericType(), null, holder.getUserId()));
            result.setUserId(_transformedUserId);
            final Boolean _transformedActive = ((Boolean) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_activeType").getGenericType(), null, holder.getActive()));
            result.setActive(_transformedActive);
            final TelephoneNumber _transformedPrimaryPhone = ((TelephoneNumber) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_primaryPhoneType").getGenericType(), null, holder.getPrimaryPhone()));
            result.setPrimaryPhone(_transformedPrimaryPhone);
            final TelephoneNumber _transformedAlternatePhone = ((TelephoneNumber) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_alternatePhoneType").getGenericType(), null, holder.getAlternatePhone()));
            result.setAlternatePhone(_transformedAlternatePhone);
            final TelephoneNumber _transformedMobile = ((TelephoneNumber) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_mobileType").getGenericType(), null, holder.getMobile()));
            result.setMobile(_transformedMobile);
            final TelephoneNumber _transformedFax = ((TelephoneNumber) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_faxType").getGenericType(), null, holder.getFax()));
            result.setFax(_transformedFax);
            final EmailAddress _transformedPrimaryEmailAddr = ((EmailAddress) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_primaryEmailAddrType").getGenericType(), null, holder.getPrimaryEmailAddr()));
            result.setPrimaryEmailAddr(_transformedPrimaryEmailAddr);
            final WebSiteAddress _transformedWebAddr = ((WebSiteAddress) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_webAddrType").getGenericType(), null, holder.getWebAddr()));
            result.setWebAddr(_transformedWebAddr);
            final List<ContactInfo> _transformedOtherContactInfo = ((List<ContactInfo> ) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_otherContactInfoType").getGenericType(), null, holder.getOtherContactInfo()));
            result.setOtherContactInfo(_transformedOtherContactInfo);
            final ReferenceType _transformedDefaultTaxCodeRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, NameBaseExpressionHolder.class.getDeclaredField("_defaultTaxCodeRefType").getGenericType(), null, holder.getDefaultTaxCodeRef()));
            result.setDefaultTaxCodeRef(_transformedDefaultTaxCodeRef);
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
