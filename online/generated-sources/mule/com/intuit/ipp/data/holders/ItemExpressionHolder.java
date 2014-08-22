
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.ItemAssemblyDetail;
import com.intuit.ipp.data.ItemGroupDetail;
import com.intuit.ipp.data.ItemTypeEnum;
import com.intuit.ipp.data.ReferenceType;
import com.intuit.ipp.data.SpecialItemTypeEnum;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T10:01:32-05:00", comments = "Build 3.4.3.1620.30ea288")
public class ItemExpressionHolder
    extends IntuitEntityExpressionHolder
{

    protected Object name;
    protected String _nameType;
    protected Object description;
    protected String _descriptionType;
    protected Object active;
    protected Boolean _activeType;
    protected Object subItem;
    protected Boolean _subItemType;
    protected Object parentRef;
    protected ReferenceType _parentRefType;
    protected Object level;
    protected Integer _levelType;
    protected Object fullyQualifiedName;
    protected String _fullyQualifiedNameType;
    protected Object taxable;
    protected Boolean _taxableType;
    protected Object salesTaxIncluded;
    protected Boolean _salesTaxIncludedType;
    protected Object percentBased;
    protected Boolean _percentBasedType;
    protected Object unitPrice;
    protected BigDecimal _unitPriceType;
    protected Object ratePercent;
    protected BigDecimal _ratePercentType;
    protected Object type;
    protected ItemTypeEnum _typeType;
    protected Object paymentMethodRef;
    protected ReferenceType _paymentMethodRefType;
    protected Object incomeAccountRef;
    protected ReferenceType _incomeAccountRefType;
    protected Object purchaseDesc;
    protected String _purchaseDescType;
    protected Object purchaseTaxIncluded;
    protected Boolean _purchaseTaxIncludedType;
    protected Object purchaseCost;
    protected BigDecimal _purchaseCostType;
    protected Object expenseAccountRef;
    protected ReferenceType _expenseAccountRefType;
    protected Object assetAccountRef;
    protected ReferenceType _assetAccountRefType;
    protected Object prefVendorRef;
    protected ReferenceType _prefVendorRefType;
    protected Object avgCost;
    protected BigDecimal _avgCostType;
    protected Object trackQtyOnHand;
    protected Boolean _trackQtyOnHandType;
    protected Object qtyOnHand;
    protected BigDecimal _qtyOnHandType;
    protected Object qtyOnPurchaseOrder;
    protected BigDecimal _qtyOnPurchaseOrderType;
    protected Object qtyOnSalesOrder;
    protected BigDecimal _qtyOnSalesOrderType;
    protected Object reorderPoint;
    protected BigDecimal _reorderPointType;
    protected Object manPartNum;
    protected String _manPartNumType;
    protected Object depositToAccountRef;
    protected ReferenceType _depositToAccountRefType;
    protected Object salesTaxCodeRef;
    protected ReferenceType _salesTaxCodeRefType;
    protected Object purchaseTaxCodeRef;
    protected ReferenceType _purchaseTaxCodeRefType;
    protected Object invStartDate;
    protected Date _invStartDateType;
    protected Object buildPoint;
    protected BigDecimal _buildPointType;
    protected Object printGroupedItems;
    protected Boolean _printGroupedItemsType;
    protected Object specialItem;
    protected Boolean _specialItemType;
    protected Object specialItemType;
    protected SpecialItemTypeEnum _specialItemTypeType;
    protected Object itemGroupDetail;
    protected ItemGroupDetail _itemGroupDetailType;
    protected Object itemAssemblyDetail;
    protected ItemAssemblyDetail _itemAssemblyDetailType;
    protected Object itemEx;
    protected IntuitAnyType _itemExType;

    /**
     * Sets name
     * 
     * @param value Value to set
     */
    public void setName(Object value) {
        this.name = value;
    }

    /**
     * Retrieves name
     * 
     */
    public Object getName() {
        return this.name;
    }

    /**
     * Sets description
     * 
     * @param value Value to set
     */
    public void setDescription(Object value) {
        this.description = value;
    }

    /**
     * Retrieves description
     * 
     */
    public Object getDescription() {
        return this.description;
    }

    /**
     * Sets active
     * 
     * @param value Value to set
     */
    public void setActive(Object value) {
        this.active = value;
    }

    /**
     * Retrieves active
     * 
     */
    public Object getActive() {
        return this.active;
    }

    /**
     * Sets subItem
     * 
     * @param value Value to set
     */
    public void setSubItem(Object value) {
        this.subItem = value;
    }

    /**
     * Retrieves subItem
     * 
     */
    public Object getSubItem() {
        return this.subItem;
    }

    /**
     * Sets parentRef
     * 
     * @param value Value to set
     */
    public void setParentRef(Object value) {
        this.parentRef = value;
    }

    /**
     * Retrieves parentRef
     * 
     */
    public Object getParentRef() {
        return this.parentRef;
    }

    /**
     * Sets level
     * 
     * @param value Value to set
     */
    public void setLevel(Object value) {
        this.level = value;
    }

    /**
     * Retrieves level
     * 
     */
    public Object getLevel() {
        return this.level;
    }

    /**
     * Sets fullyQualifiedName
     * 
     * @param value Value to set
     */
    public void setFullyQualifiedName(Object value) {
        this.fullyQualifiedName = value;
    }

    /**
     * Retrieves fullyQualifiedName
     * 
     */
    public Object getFullyQualifiedName() {
        return this.fullyQualifiedName;
    }

    /**
     * Sets taxable
     * 
     * @param value Value to set
     */
    public void setTaxable(Object value) {
        this.taxable = value;
    }

    /**
     * Retrieves taxable
     * 
     */
    public Object getTaxable() {
        return this.taxable;
    }

    /**
     * Sets salesTaxIncluded
     * 
     * @param value Value to set
     */
    public void setSalesTaxIncluded(Object value) {
        this.salesTaxIncluded = value;
    }

    /**
     * Retrieves salesTaxIncluded
     * 
     */
    public Object getSalesTaxIncluded() {
        return this.salesTaxIncluded;
    }

    /**
     * Sets percentBased
     * 
     * @param value Value to set
     */
    public void setPercentBased(Object value) {
        this.percentBased = value;
    }

    /**
     * Retrieves percentBased
     * 
     */
    public Object getPercentBased() {
        return this.percentBased;
    }

    /**
     * Sets unitPrice
     * 
     * @param value Value to set
     */
    public void setUnitPrice(Object value) {
        this.unitPrice = value;
    }

    /**
     * Retrieves unitPrice
     * 
     */
    public Object getUnitPrice() {
        return this.unitPrice;
    }

    /**
     * Sets ratePercent
     * 
     * @param value Value to set
     */
    public void setRatePercent(Object value) {
        this.ratePercent = value;
    }

    /**
     * Retrieves ratePercent
     * 
     */
    public Object getRatePercent() {
        return this.ratePercent;
    }

    /**
     * Sets type
     * 
     * @param value Value to set
     */
    public void setType(Object value) {
        this.type = value;
    }

    /**
     * Retrieves type
     * 
     */
    public Object getType() {
        return this.type;
    }

    /**
     * Sets paymentMethodRef
     * 
     * @param value Value to set
     */
    public void setPaymentMethodRef(Object value) {
        this.paymentMethodRef = value;
    }

    /**
     * Retrieves paymentMethodRef
     * 
     */
    public Object getPaymentMethodRef() {
        return this.paymentMethodRef;
    }

    /**
     * Sets incomeAccountRef
     * 
     * @param value Value to set
     */
    public void setIncomeAccountRef(Object value) {
        this.incomeAccountRef = value;
    }

    /**
     * Retrieves incomeAccountRef
     * 
     */
    public Object getIncomeAccountRef() {
        return this.incomeAccountRef;
    }

    /**
     * Sets purchaseDesc
     * 
     * @param value Value to set
     */
    public void setPurchaseDesc(Object value) {
        this.purchaseDesc = value;
    }

    /**
     * Retrieves purchaseDesc
     * 
     */
    public Object getPurchaseDesc() {
        return this.purchaseDesc;
    }

    /**
     * Sets purchaseTaxIncluded
     * 
     * @param value Value to set
     */
    public void setPurchaseTaxIncluded(Object value) {
        this.purchaseTaxIncluded = value;
    }

    /**
     * Retrieves purchaseTaxIncluded
     * 
     */
    public Object getPurchaseTaxIncluded() {
        return this.purchaseTaxIncluded;
    }

    /**
     * Sets purchaseCost
     * 
     * @param value Value to set
     */
    public void setPurchaseCost(Object value) {
        this.purchaseCost = value;
    }

    /**
     * Retrieves purchaseCost
     * 
     */
    public Object getPurchaseCost() {
        return this.purchaseCost;
    }

    /**
     * Sets expenseAccountRef
     * 
     * @param value Value to set
     */
    public void setExpenseAccountRef(Object value) {
        this.expenseAccountRef = value;
    }

    /**
     * Retrieves expenseAccountRef
     * 
     */
    public Object getExpenseAccountRef() {
        return this.expenseAccountRef;
    }

    /**
     * Sets assetAccountRef
     * 
     * @param value Value to set
     */
    public void setAssetAccountRef(Object value) {
        this.assetAccountRef = value;
    }

    /**
     * Retrieves assetAccountRef
     * 
     */
    public Object getAssetAccountRef() {
        return this.assetAccountRef;
    }

    /**
     * Sets prefVendorRef
     * 
     * @param value Value to set
     */
    public void setPrefVendorRef(Object value) {
        this.prefVendorRef = value;
    }

    /**
     * Retrieves prefVendorRef
     * 
     */
    public Object getPrefVendorRef() {
        return this.prefVendorRef;
    }

    /**
     * Sets avgCost
     * 
     * @param value Value to set
     */
    public void setAvgCost(Object value) {
        this.avgCost = value;
    }

    /**
     * Retrieves avgCost
     * 
     */
    public Object getAvgCost() {
        return this.avgCost;
    }

    /**
     * Sets trackQtyOnHand
     * 
     * @param value Value to set
     */
    public void setTrackQtyOnHand(Object value) {
        this.trackQtyOnHand = value;
    }

    /**
     * Retrieves trackQtyOnHand
     * 
     */
    public Object getTrackQtyOnHand() {
        return this.trackQtyOnHand;
    }

    /**
     * Sets qtyOnHand
     * 
     * @param value Value to set
     */
    public void setQtyOnHand(Object value) {
        this.qtyOnHand = value;
    }

    /**
     * Retrieves qtyOnHand
     * 
     */
    public Object getQtyOnHand() {
        return this.qtyOnHand;
    }

    /**
     * Sets qtyOnPurchaseOrder
     * 
     * @param value Value to set
     */
    public void setQtyOnPurchaseOrder(Object value) {
        this.qtyOnPurchaseOrder = value;
    }

    /**
     * Retrieves qtyOnPurchaseOrder
     * 
     */
    public Object getQtyOnPurchaseOrder() {
        return this.qtyOnPurchaseOrder;
    }

    /**
     * Sets qtyOnSalesOrder
     * 
     * @param value Value to set
     */
    public void setQtyOnSalesOrder(Object value) {
        this.qtyOnSalesOrder = value;
    }

    /**
     * Retrieves qtyOnSalesOrder
     * 
     */
    public Object getQtyOnSalesOrder() {
        return this.qtyOnSalesOrder;
    }

    /**
     * Sets reorderPoint
     * 
     * @param value Value to set
     */
    public void setReorderPoint(Object value) {
        this.reorderPoint = value;
    }

    /**
     * Retrieves reorderPoint
     * 
     */
    public Object getReorderPoint() {
        return this.reorderPoint;
    }

    /**
     * Sets manPartNum
     * 
     * @param value Value to set
     */
    public void setManPartNum(Object value) {
        this.manPartNum = value;
    }

    /**
     * Retrieves manPartNum
     * 
     */
    public Object getManPartNum() {
        return this.manPartNum;
    }

    /**
     * Sets depositToAccountRef
     * 
     * @param value Value to set
     */
    public void setDepositToAccountRef(Object value) {
        this.depositToAccountRef = value;
    }

    /**
     * Retrieves depositToAccountRef
     * 
     */
    public Object getDepositToAccountRef() {
        return this.depositToAccountRef;
    }

    /**
     * Sets salesTaxCodeRef
     * 
     * @param value Value to set
     */
    public void setSalesTaxCodeRef(Object value) {
        this.salesTaxCodeRef = value;
    }

    /**
     * Retrieves salesTaxCodeRef
     * 
     */
    public Object getSalesTaxCodeRef() {
        return this.salesTaxCodeRef;
    }

    /**
     * Sets purchaseTaxCodeRef
     * 
     * @param value Value to set
     */
    public void setPurchaseTaxCodeRef(Object value) {
        this.purchaseTaxCodeRef = value;
    }

    /**
     * Retrieves purchaseTaxCodeRef
     * 
     */
    public Object getPurchaseTaxCodeRef() {
        return this.purchaseTaxCodeRef;
    }

    /**
     * Sets invStartDate
     * 
     * @param value Value to set
     */
    public void setInvStartDate(Object value) {
        this.invStartDate = value;
    }

    /**
     * Retrieves invStartDate
     * 
     */
    public Object getInvStartDate() {
        return this.invStartDate;
    }

    /**
     * Sets buildPoint
     * 
     * @param value Value to set
     */
    public void setBuildPoint(Object value) {
        this.buildPoint = value;
    }

    /**
     * Retrieves buildPoint
     * 
     */
    public Object getBuildPoint() {
        return this.buildPoint;
    }

    /**
     * Sets printGroupedItems
     * 
     * @param value Value to set
     */
    public void setPrintGroupedItems(Object value) {
        this.printGroupedItems = value;
    }

    /**
     * Retrieves printGroupedItems
     * 
     */
    public Object getPrintGroupedItems() {
        return this.printGroupedItems;
    }

    /**
     * Sets specialItem
     * 
     * @param value Value to set
     */
    public void setSpecialItem(Object value) {
        this.specialItem = value;
    }

    /**
     * Retrieves specialItem
     * 
     */
    public Object getSpecialItem() {
        return this.specialItem;
    }

    /**
     * Sets specialItemType
     * 
     * @param value Value to set
     */
    public void setSpecialItemType(Object value) {
        this.specialItemType = value;
    }

    /**
     * Retrieves specialItemType
     * 
     */
    public Object getSpecialItemType() {
        return this.specialItemType;
    }

    /**
     * Sets itemGroupDetail
     * 
     * @param value Value to set
     */
    public void setItemGroupDetail(Object value) {
        this.itemGroupDetail = value;
    }

    /**
     * Retrieves itemGroupDetail
     * 
     */
    public Object getItemGroupDetail() {
        return this.itemGroupDetail;
    }

    /**
     * Sets itemAssemblyDetail
     * 
     * @param value Value to set
     */
    public void setItemAssemblyDetail(Object value) {
        this.itemAssemblyDetail = value;
    }

    /**
     * Retrieves itemAssemblyDetail
     * 
     */
    public Object getItemAssemblyDetail() {
        return this.itemAssemblyDetail;
    }

    /**
     * Sets itemEx
     * 
     * @param value Value to set
     */
    public void setItemEx(Object value) {
        this.itemEx = value;
    }

    /**
     * Retrieves itemEx
     * 
     */
    public Object getItemEx() {
        return this.itemEx;
    }

}
