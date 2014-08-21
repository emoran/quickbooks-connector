
package com.intuit.ipp.data.transformers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.Account;
import com.intuit.ipp.data.AccountClassificationEnum;
import com.intuit.ipp.data.AccountTypeEnum;
import com.intuit.ipp.data.AttachableRef;
import com.intuit.ipp.data.CustomField;
import com.intuit.ipp.data.EntityStatusEnum;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.ModificationMetaData;
import com.intuit.ipp.data.ReferenceType;
import com.intuit.ipp.data.holders.AccountExpressionHolder;
import com.intuit.ipp.data.holders.IntuitEntityExpressionHolder;
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
public class AccountExpressionHolderTransformer
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
        return (aClass == AccountExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == AccountExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {AccountExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(AccountExpressionHolder.class)});
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
        return Account.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(Account.class);
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
        AccountExpressionHolder holder = ((AccountExpressionHolder) src);
        Account result = new Account();
        try {
            final String _transformedName = ((String) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_nameType").getGenericType(), null, holder.getName()));
            result.setName(_transformedName);
            final Boolean _transformedSubAccount = ((Boolean) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_subAccountType").getGenericType(), null, holder.getSubAccount()));
            result.setSubAccount(_transformedSubAccount);
            final ReferenceType _transformedParentRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_parentRefType").getGenericType(), null, holder.getParentRef()));
            result.setParentRef(_transformedParentRef);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final String _transformedFullyQualifiedName = ((String) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_fullyQualifiedNameType").getGenericType(), null, holder.getFullyQualifiedName()));
            result.setFullyQualifiedName(_transformedFullyQualifiedName);
            final Boolean _transformedActive = ((Boolean) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_activeType").getGenericType(), null, holder.getActive()));
            result.setActive(_transformedActive);
            final AccountClassificationEnum _transformedClassification = ((AccountClassificationEnum) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_classificationType").getGenericType(), null, holder.getClassification()));
            result.setClassification(_transformedClassification);
            final AccountTypeEnum _transformedAccountType = ((AccountTypeEnum) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_accountTypeType").getGenericType(), null, holder.getAccountType()));
            result.setAccountType(_transformedAccountType);
            final String _transformedAccountSubType = ((String) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_accountSubTypeType").getGenericType(), null, holder.getAccountSubType()));
            result.setAccountSubType(_transformedAccountSubType);
            final String _transformedAcctNum = ((String) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_acctNumType").getGenericType(), null, holder.getAcctNum()));
            result.setAcctNum(_transformedAcctNum);
            final String _transformedBankNum = ((String) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_bankNumType").getGenericType(), null, holder.getBankNum()));
            result.setBankNum(_transformedBankNum);
            final BigDecimal _transformedOpeningBalance = ((BigDecimal) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_openingBalanceType").getGenericType(), null, holder.getOpeningBalance()));
            result.setOpeningBalance(_transformedOpeningBalance);
            final Date _transformedOpeningBalanceDate = ((Date) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_openingBalanceDateType").getGenericType(), null, holder.getOpeningBalanceDate()));
            result.setOpeningBalanceDate(_transformedOpeningBalanceDate);
            final BigDecimal _transformedCurrentBalance = ((BigDecimal) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_currentBalanceType").getGenericType(), null, holder.getCurrentBalance()));
            result.setCurrentBalance(_transformedCurrentBalance);
            final BigDecimal _transformedCurrentBalanceWithSubAccounts = ((BigDecimal) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_currentBalanceWithSubAccountsType").getGenericType(), null, holder.getCurrentBalanceWithSubAccounts()));
            result.setCurrentBalanceWithSubAccounts(_transformedCurrentBalanceWithSubAccounts);
            final ReferenceType _transformedCurrencyRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_currencyRefType").getGenericType(), null, holder.getCurrencyRef()));
            result.setCurrencyRef(_transformedCurrencyRef);
            final Boolean _transformedTaxAccount = ((Boolean) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_taxAccountType").getGenericType(), null, holder.getTaxAccount()));
            result.setTaxAccount(_transformedTaxAccount);
            final ReferenceType _transformedTaxCodeRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_taxCodeRefType").getGenericType(), null, holder.getTaxCodeRef()));
            result.setTaxCodeRef(_transformedTaxCodeRef);
            final Boolean _transformedOnlineBankingEnabled = ((Boolean) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_onlineBankingEnabledType").getGenericType(), null, holder.getOnlineBankingEnabled()));
            result.setOnlineBankingEnabled(_transformedOnlineBankingEnabled);
            final IntuitAnyType _transformedAccountEx = ((IntuitAnyType) evaluateAndTransform(this.muleContext, event, AccountExpressionHolder.class.getDeclaredField("_accountExType").getGenericType(), null, holder.getAccountEx()));
            result.setAccountEx(_transformedAccountEx);
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
