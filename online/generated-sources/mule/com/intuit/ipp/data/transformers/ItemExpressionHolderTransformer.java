
package com.intuit.ipp.data.transformers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.AttachableRef;
import com.intuit.ipp.data.CustomField;
import com.intuit.ipp.data.EntityStatusEnum;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.Item;
import com.intuit.ipp.data.ItemAssemblyDetail;
import com.intuit.ipp.data.ItemGroupDetail;
import com.intuit.ipp.data.ItemTypeEnum;
import com.intuit.ipp.data.ModificationMetaData;
import com.intuit.ipp.data.ReferenceType;
import com.intuit.ipp.data.SpecialItemTypeEnum;
import com.intuit.ipp.data.holders.IntuitEntityExpressionHolder;
import com.intuit.ipp.data.holders.ItemExpressionHolder;
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
public class ItemExpressionHolderTransformer
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
        return (aClass == ItemExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == ItemExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {ItemExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(ItemExpressionHolder.class)});
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
        return Item.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(Item.class);
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
        ItemExpressionHolder holder = ((ItemExpressionHolder) src);
        Item result = new Item();
        try {
            final String _transformedName = ((String) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_nameType").getGenericType(), null, holder.getName()));
            result.setName(_transformedName);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final Boolean _transformedActive = ((Boolean) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_activeType").getGenericType(), null, holder.getActive()));
            result.setActive(_transformedActive);
            final Boolean _transformedSubItem = ((Boolean) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_subItemType").getGenericType(), null, holder.getSubItem()));
            result.setSubItem(_transformedSubItem);
            final ReferenceType _transformedParentRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_parentRefType").getGenericType(), null, holder.getParentRef()));
            result.setParentRef(_transformedParentRef);
            final Integer _transformedLevel = ((Integer) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_levelType").getGenericType(), null, holder.getLevel()));
            result.setLevel(_transformedLevel);
            final String _transformedFullyQualifiedName = ((String) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_fullyQualifiedNameType").getGenericType(), null, holder.getFullyQualifiedName()));
            result.setFullyQualifiedName(_transformedFullyQualifiedName);
            final Boolean _transformedTaxable = ((Boolean) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_taxableType").getGenericType(), null, holder.getTaxable()));
            result.setTaxable(_transformedTaxable);
            final Boolean _transformedSalesTaxIncluded = ((Boolean) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_salesTaxIncludedType").getGenericType(), null, holder.getSalesTaxIncluded()));
            result.setSalesTaxIncluded(_transformedSalesTaxIncluded);
            final Boolean _transformedPercentBased = ((Boolean) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_percentBasedType").getGenericType(), null, holder.getPercentBased()));
            result.setPercentBased(_transformedPercentBased);
            final BigDecimal _transformedUnitPrice = ((BigDecimal) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_unitPriceType").getGenericType(), null, holder.getUnitPrice()));
            result.setUnitPrice(_transformedUnitPrice);
            final BigDecimal _transformedRatePercent = ((BigDecimal) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_ratePercentType").getGenericType(), null, holder.getRatePercent()));
            result.setRatePercent(_transformedRatePercent);
            final ItemTypeEnum _transformedType = ((ItemTypeEnum) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_typeType").getGenericType(), null, holder.getType()));
            result.setType(_transformedType);
            final ReferenceType _transformedPaymentMethodRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_paymentMethodRefType").getGenericType(), null, holder.getPaymentMethodRef()));
            result.setPaymentMethodRef(_transformedPaymentMethodRef);
            final ReferenceType _transformedIncomeAccountRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_incomeAccountRefType").getGenericType(), null, holder.getIncomeAccountRef()));
            result.setIncomeAccountRef(_transformedIncomeAccountRef);
            final String _transformedPurchaseDesc = ((String) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_purchaseDescType").getGenericType(), null, holder.getPurchaseDesc()));
            result.setPurchaseDesc(_transformedPurchaseDesc);
            final Boolean _transformedPurchaseTaxIncluded = ((Boolean) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_purchaseTaxIncludedType").getGenericType(), null, holder.getPurchaseTaxIncluded()));
            result.setPurchaseTaxIncluded(_transformedPurchaseTaxIncluded);
            final BigDecimal _transformedPurchaseCost = ((BigDecimal) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_purchaseCostType").getGenericType(), null, holder.getPurchaseCost()));
            result.setPurchaseCost(_transformedPurchaseCost);
            final ReferenceType _transformedExpenseAccountRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_expenseAccountRefType").getGenericType(), null, holder.getExpenseAccountRef()));
            result.setExpenseAccountRef(_transformedExpenseAccountRef);
            final ReferenceType _transformedAssetAccountRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_assetAccountRefType").getGenericType(), null, holder.getAssetAccountRef()));
            result.setAssetAccountRef(_transformedAssetAccountRef);
            final ReferenceType _transformedPrefVendorRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_prefVendorRefType").getGenericType(), null, holder.getPrefVendorRef()));
            result.setPrefVendorRef(_transformedPrefVendorRef);
            final BigDecimal _transformedAvgCost = ((BigDecimal) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_avgCostType").getGenericType(), null, holder.getAvgCost()));
            result.setAvgCost(_transformedAvgCost);
            final Boolean _transformedTrackQtyOnHand = ((Boolean) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_trackQtyOnHandType").getGenericType(), null, holder.getTrackQtyOnHand()));
            result.setTrackQtyOnHand(_transformedTrackQtyOnHand);
            final BigDecimal _transformedQtyOnHand = ((BigDecimal) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_qtyOnHandType").getGenericType(), null, holder.getQtyOnHand()));
            result.setQtyOnHand(_transformedQtyOnHand);
            final BigDecimal _transformedQtyOnPurchaseOrder = ((BigDecimal) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_qtyOnPurchaseOrderType").getGenericType(), null, holder.getQtyOnPurchaseOrder()));
            result.setQtyOnPurchaseOrder(_transformedQtyOnPurchaseOrder);
            final BigDecimal _transformedQtyOnSalesOrder = ((BigDecimal) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_qtyOnSalesOrderType").getGenericType(), null, holder.getQtyOnSalesOrder()));
            result.setQtyOnSalesOrder(_transformedQtyOnSalesOrder);
            final BigDecimal _transformedReorderPoint = ((BigDecimal) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_reorderPointType").getGenericType(), null, holder.getReorderPoint()));
            result.setReorderPoint(_transformedReorderPoint);
            final String _transformedManPartNum = ((String) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_manPartNumType").getGenericType(), null, holder.getManPartNum()));
            result.setManPartNum(_transformedManPartNum);
            final ReferenceType _transformedDepositToAccountRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_depositToAccountRefType").getGenericType(), null, holder.getDepositToAccountRef()));
            result.setDepositToAccountRef(_transformedDepositToAccountRef);
            final ReferenceType _transformedSalesTaxCodeRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_salesTaxCodeRefType").getGenericType(), null, holder.getSalesTaxCodeRef()));
            result.setSalesTaxCodeRef(_transformedSalesTaxCodeRef);
            final ReferenceType _transformedPurchaseTaxCodeRef = ((ReferenceType) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_purchaseTaxCodeRefType").getGenericType(), null, holder.getPurchaseTaxCodeRef()));
            result.setPurchaseTaxCodeRef(_transformedPurchaseTaxCodeRef);
            final Date _transformedInvStartDate = ((Date) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_invStartDateType").getGenericType(), null, holder.getInvStartDate()));
            result.setInvStartDate(_transformedInvStartDate);
            final BigDecimal _transformedBuildPoint = ((BigDecimal) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_buildPointType").getGenericType(), null, holder.getBuildPoint()));
            result.setBuildPoint(_transformedBuildPoint);
            final Boolean _transformedPrintGroupedItems = ((Boolean) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_printGroupedItemsType").getGenericType(), null, holder.getPrintGroupedItems()));
            result.setPrintGroupedItems(_transformedPrintGroupedItems);
            final Boolean _transformedSpecialItem = ((Boolean) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_specialItemType").getGenericType(), null, holder.getSpecialItem()));
            result.setSpecialItem(_transformedSpecialItem);
            final SpecialItemTypeEnum _transformedSpecialItemType = ((SpecialItemTypeEnum) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_specialItemTypeType").getGenericType(), null, holder.getSpecialItemType()));
            result.setSpecialItemType(_transformedSpecialItemType);
            final ItemGroupDetail _transformedItemGroupDetail = ((ItemGroupDetail) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_itemGroupDetailType").getGenericType(), null, holder.getItemGroupDetail()));
            result.setItemGroupDetail(_transformedItemGroupDetail);
            final ItemAssemblyDetail _transformedItemAssemblyDetail = ((ItemAssemblyDetail) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_itemAssemblyDetailType").getGenericType(), null, holder.getItemAssemblyDetail()));
            result.setItemAssemblyDetail(_transformedItemAssemblyDetail);
            final IntuitAnyType _transformedItemEx = ((IntuitAnyType) evaluateAndTransform(this.muleContext, event, ItemExpressionHolder.class.getDeclaredField("_itemExType").getGenericType(), null, holder.getItemEx()));
            result.setItemEx(_transformedItemEx);
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
