
package com.intuit.ipp.data.transformers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.AttachableRef;
import com.intuit.ipp.data.ContactInfo;
import com.intuit.ipp.data.CustomField;
import com.intuit.ipp.data.EmailAddress;
import com.intuit.ipp.data.EntityStatusEnum;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.ModificationMetaData;
import com.intuit.ipp.data.PhysicalAddress;
import com.intuit.ipp.data.ReferenceType;
import com.intuit.ipp.data.TelephoneNumber;
import com.intuit.ipp.data.Vendor;
import com.intuit.ipp.data.WebSiteAddress;
import com.intuit.ipp.data.holders.IntuitEntityExpressionHolder;
import com.intuit.ipp.data.holders.NameBaseExpressionHolder;
import com.intuit.ipp.data.holders.VendorExpressionHolder;
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

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class VendorExpressionHolderTransformer
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
        return (aClass == VendorExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == VendorExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {VendorExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(VendorExpressionHolder.class)});
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
        return Vendor.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(Vendor.class);
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
        VendorExpressionHolder holder = ((VendorExpressionHolder) src);
        Vendor result = new Vendor();
        try {
            final String _transformedContactName = ((String) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_contactNameType").getGenericType(), null, holder.getContactName()));
            result.setContactName(_transformedContactName);
            final String _transformedAltContactName = ((String) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_altContactNameType").getGenericType(), null, holder.getAltContactName()));
            result.setAltContactName(_transformedAltContactName);
            final String _transformedNotes = ((String) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_notesType").getGenericType(), null, holder.getNotes()));
            result.setNotes(_transformedNotes);
            final PhysicalAddress _transformedBillAddr = ((PhysicalAddress) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_billAddrType").getGenericType(), null, holder.getBillAddr()));
            result.setBillAddr(_transformedBillAddr);
            final PhysicalAddress _transformedShipAddr = ((PhysicalAddress) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_shipAddrType").getGenericType(), null, holder.getShipAddr()));
            result.setShipAddr(_transformedShipAddr);
            final List<PhysicalAddress> _transformedOtherAddr = ((List<PhysicalAddress> ) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_otherAddrType").getGenericType(), null, holder.getOtherAddr()));
            result.setOtherAddr(_transformedOtherAddr);
            final String _transformedTaxCountry = ((String) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_taxCountryType").getGenericType(), null, holder.getTaxCountry()));
            result.setTaxCountry(_transformedTaxCountry);
            final String _transformedTaxIdentifier = ((String) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_taxIdentifierType").getGenericType(), null, holder.getTaxIdentifier()));
            result.setTaxIdentifier(_transformedTaxIdentifier);
            final String _transformedBusinessNumber = ((String) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_businessNumberType").getGenericType(), null, holder.getBusinessNumber()));
            result.setBusinessNumber(_transformedBusinessNumber);
            final ReferenceType _transformedParentRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_parentRefType").getGenericType(), null, holder.getParentRef()));
            result.setParentRef(_transformedParentRef);
            final ReferenceType _transformedVendorTypeRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_vendorTypeRefType").getGenericType(), null, holder.getVendorTypeRef()));
            result.setVendorTypeRef(_transformedVendorTypeRef);
            final ReferenceType _transformedTermRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_termRefType").getGenericType(), null, holder.getTermRef()));
            result.setTermRef(_transformedTermRef);
            final ReferenceType _transformedPrefillAccountRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_prefillAccountRefType").getGenericType(), null, holder.getPrefillAccountRef()));
            result.setPrefillAccountRef(_transformedPrefillAccountRef);
            final BigDecimal _transformedBalance = ((BigDecimal) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_balanceType").getGenericType(), null, holder.getBalance()));
            result.setBalance(_transformedBalance);
            final Date _transformedOpenBalanceDate = ((Date) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_openBalanceDateType").getGenericType(), null, holder.getOpenBalanceDate()));
            result.setOpenBalanceDate(_transformedOpenBalanceDate);
            final BigDecimal _transformedCreditLimit = ((BigDecimal) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_creditLimitType").getGenericType(), null, holder.getCreditLimit()));
            result.setCreditLimit(_transformedCreditLimit);
            final String _transformedAcctNum = ((String) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_acctNumType").getGenericType(), null, holder.getAcctNum()));
            result.setAcctNum(_transformedAcctNum);
            final Boolean _transformedVendor1099 = ((Boolean) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_vendor1099Type").getGenericType(), null, holder.getVendor1099()));
            result.setVendor1099(_transformedVendor1099);
            final Boolean _transformedT4AEligible = ((Boolean) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_t4AEligibleType").getGenericType(), null, holder.getT4AEligible()));
            result.setT4AEligible(_transformedT4AEligible);
            final Boolean _transformedT5018Eligible = ((Boolean) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_t5018EligibleType").getGenericType(), null, holder.getT5018Eligible()));
            result.setT5018Eligible(_transformedT5018Eligible);
            final ReferenceType _transformedCurrencyRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_currencyRefType").getGenericType(), null, holder.getCurrencyRef()));
            result.setCurrencyRef(_transformedCurrencyRef);
            final IntuitAnyType _transformedVendorEx = ((IntuitAnyType) evaluateAndTransform(this.muleContext, event, VendorExpressionHolder.class.getDeclaredField("_vendorExType").getGenericType(), null, holder.getVendorEx()));
            result.setVendorEx(_transformedVendorEx);
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
