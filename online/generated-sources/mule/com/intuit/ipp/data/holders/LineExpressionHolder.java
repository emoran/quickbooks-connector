
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.AccountBasedExpenseLineDetail;
import com.intuit.ipp.data.CustomField;
import com.intuit.ipp.data.DepositLineDetail;
import com.intuit.ipp.data.DescriptionLineDetail;
import com.intuit.ipp.data.DiscountLineDetail;
import com.intuit.ipp.data.GroupLineDetail;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.ItemBasedExpenseLineDetail;
import com.intuit.ipp.data.ItemReceiptLineDetail;
import com.intuit.ipp.data.JournalEntryLineDetail;
import com.intuit.ipp.data.LineDetailTypeEnum;
import com.intuit.ipp.data.LinkedTxn;
import com.intuit.ipp.data.PaymentLineDetail;
import com.intuit.ipp.data.PurchaseOrderItemLineDetail;
import com.intuit.ipp.data.SalesItemLineDetail;
import com.intuit.ipp.data.SalesOrderItemLineDetail;
import com.intuit.ipp.data.SubTotalLineDetail;
import com.intuit.ipp.data.TaxLineDetail;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T10:01:32-05:00", comments = "Build 3.4.3.1620.30ea288")
public class LineExpressionHolder {

    protected Object id;
    protected String _idType;
    protected Object lineNum;
    protected BigInteger _lineNumType;
    protected Object description;
    protected String _descriptionType;
    protected Object amount;
    protected BigDecimal _amountType;
    protected Object linkedTxn;
    protected List<LinkedTxn> _linkedTxnType;
    protected Object detailType;
    protected LineDetailTypeEnum _detailTypeType;
    protected Object paymentLineDetail;
    protected PaymentLineDetail _paymentLineDetailType;
    protected Object discountLineDetail;
    protected DiscountLineDetail _discountLineDetailType;
    protected Object taxLineDetail;
    protected TaxLineDetail _taxLineDetailType;
    protected Object salesItemLineDetail;
    protected SalesItemLineDetail _salesItemLineDetailType;
    protected Object descriptionLineDetail;
    protected DescriptionLineDetail _descriptionLineDetailType;
    protected Object itemBasedExpenseLineDetail;
    protected ItemBasedExpenseLineDetail _itemBasedExpenseLineDetailType;
    protected Object accountBasedExpenseLineDetail;
    protected AccountBasedExpenseLineDetail _accountBasedExpenseLineDetailType;
    protected Object depositLineDetail;
    protected DepositLineDetail _depositLineDetailType;
    protected Object purchaseOrderItemLineDetail;
    protected PurchaseOrderItemLineDetail _purchaseOrderItemLineDetailType;
    protected Object salesOrderItemLineDetail;
    protected SalesOrderItemLineDetail _salesOrderItemLineDetailType;
    protected Object itemReceiptLineDetail;
    protected ItemReceiptLineDetail _itemReceiptLineDetailType;
    protected Object journalEntryLineDetail;
    protected JournalEntryLineDetail _journalEntryLineDetailType;
    protected Object groupLineDetail;
    protected GroupLineDetail _groupLineDetailType;
    protected Object subTotalLineDetail;
    protected SubTotalLineDetail _subTotalLineDetailType;
    protected Object customField;
    protected List<CustomField> _customFieldType;
    protected Object lineEx;
    protected IntuitAnyType _lineExType;

    /**
     * Sets id
     * 
     * @param value Value to set
     */
    public void setId(Object value) {
        this.id = value;
    }

    /**
     * Retrieves id
     * 
     */
    public Object getId() {
        return this.id;
    }

    /**
     * Sets lineNum
     * 
     * @param value Value to set
     */
    public void setLineNum(Object value) {
        this.lineNum = value;
    }

    /**
     * Retrieves lineNum
     * 
     */
    public Object getLineNum() {
        return this.lineNum;
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
     * Sets amount
     * 
     * @param value Value to set
     */
    public void setAmount(Object value) {
        this.amount = value;
    }

    /**
     * Retrieves amount
     * 
     */
    public Object getAmount() {
        return this.amount;
    }

    /**
     * Sets linkedTxn
     * 
     * @param value Value to set
     */
    public void setLinkedTxn(Object value) {
        this.linkedTxn = value;
    }

    /**
     * Retrieves linkedTxn
     * 
     */
    public Object getLinkedTxn() {
        return this.linkedTxn;
    }

    /**
     * Sets detailType
     * 
     * @param value Value to set
     */
    public void setDetailType(Object value) {
        this.detailType = value;
    }

    /**
     * Retrieves detailType
     * 
     */
    public Object getDetailType() {
        return this.detailType;
    }

    /**
     * Sets paymentLineDetail
     * 
     * @param value Value to set
     */
    public void setPaymentLineDetail(Object value) {
        this.paymentLineDetail = value;
    }

    /**
     * Retrieves paymentLineDetail
     * 
     */
    public Object getPaymentLineDetail() {
        return this.paymentLineDetail;
    }

    /**
     * Sets discountLineDetail
     * 
     * @param value Value to set
     */
    public void setDiscountLineDetail(Object value) {
        this.discountLineDetail = value;
    }

    /**
     * Retrieves discountLineDetail
     * 
     */
    public Object getDiscountLineDetail() {
        return this.discountLineDetail;
    }

    /**
     * Sets taxLineDetail
     * 
     * @param value Value to set
     */
    public void setTaxLineDetail(Object value) {
        this.taxLineDetail = value;
    }

    /**
     * Retrieves taxLineDetail
     * 
     */
    public Object getTaxLineDetail() {
        return this.taxLineDetail;
    }

    /**
     * Sets salesItemLineDetail
     * 
     * @param value Value to set
     */
    public void setSalesItemLineDetail(Object value) {
        this.salesItemLineDetail = value;
    }

    /**
     * Retrieves salesItemLineDetail
     * 
     */
    public Object getSalesItemLineDetail() {
        return this.salesItemLineDetail;
    }

    /**
     * Sets descriptionLineDetail
     * 
     * @param value Value to set
     */
    public void setDescriptionLineDetail(Object value) {
        this.descriptionLineDetail = value;
    }

    /**
     * Retrieves descriptionLineDetail
     * 
     */
    public Object getDescriptionLineDetail() {
        return this.descriptionLineDetail;
    }

    /**
     * Sets itemBasedExpenseLineDetail
     * 
     * @param value Value to set
     */
    public void setItemBasedExpenseLineDetail(Object value) {
        this.itemBasedExpenseLineDetail = value;
    }

    /**
     * Retrieves itemBasedExpenseLineDetail
     * 
     */
    public Object getItemBasedExpenseLineDetail() {
        return this.itemBasedExpenseLineDetail;
    }

    /**
     * Sets accountBasedExpenseLineDetail
     * 
     * @param value Value to set
     */
    public void setAccountBasedExpenseLineDetail(Object value) {
        this.accountBasedExpenseLineDetail = value;
    }

    /**
     * Retrieves accountBasedExpenseLineDetail
     * 
     */
    public Object getAccountBasedExpenseLineDetail() {
        return this.accountBasedExpenseLineDetail;
    }

    /**
     * Sets depositLineDetail
     * 
     * @param value Value to set
     */
    public void setDepositLineDetail(Object value) {
        this.depositLineDetail = value;
    }

    /**
     * Retrieves depositLineDetail
     * 
     */
    public Object getDepositLineDetail() {
        return this.depositLineDetail;
    }

    /**
     * Sets purchaseOrderItemLineDetail
     * 
     * @param value Value to set
     */
    public void setPurchaseOrderItemLineDetail(Object value) {
        this.purchaseOrderItemLineDetail = value;
    }

    /**
     * Retrieves purchaseOrderItemLineDetail
     * 
     */
    public Object getPurchaseOrderItemLineDetail() {
        return this.purchaseOrderItemLineDetail;
    }

    /**
     * Sets salesOrderItemLineDetail
     * 
     * @param value Value to set
     */
    public void setSalesOrderItemLineDetail(Object value) {
        this.salesOrderItemLineDetail = value;
    }

    /**
     * Retrieves salesOrderItemLineDetail
     * 
     */
    public Object getSalesOrderItemLineDetail() {
        return this.salesOrderItemLineDetail;
    }

    /**
     * Sets itemReceiptLineDetail
     * 
     * @param value Value to set
     */
    public void setItemReceiptLineDetail(Object value) {
        this.itemReceiptLineDetail = value;
    }

    /**
     * Retrieves itemReceiptLineDetail
     * 
     */
    public Object getItemReceiptLineDetail() {
        return this.itemReceiptLineDetail;
    }

    /**
     * Sets journalEntryLineDetail
     * 
     * @param value Value to set
     */
    public void setJournalEntryLineDetail(Object value) {
        this.journalEntryLineDetail = value;
    }

    /**
     * Retrieves journalEntryLineDetail
     * 
     */
    public Object getJournalEntryLineDetail() {
        return this.journalEntryLineDetail;
    }

    /**
     * Sets groupLineDetail
     * 
     * @param value Value to set
     */
    public void setGroupLineDetail(Object value) {
        this.groupLineDetail = value;
    }

    /**
     * Retrieves groupLineDetail
     * 
     */
    public Object getGroupLineDetail() {
        return this.groupLineDetail;
    }

    /**
     * Sets subTotalLineDetail
     * 
     * @param value Value to set
     */
    public void setSubTotalLineDetail(Object value) {
        this.subTotalLineDetail = value;
    }

    /**
     * Retrieves subTotalLineDetail
     * 
     */
    public Object getSubTotalLineDetail() {
        return this.subTotalLineDetail;
    }

    /**
     * Sets customField
     * 
     * @param value Value to set
     */
    public void setCustomField(Object value) {
        this.customField = value;
    }

    /**
     * Retrieves customField
     * 
     */
    public Object getCustomField() {
        return this.customField;
    }

    /**
     * Sets lineEx
     * 
     * @param value Value to set
     */
    public void setLineEx(Object value) {
        this.lineEx = value;
    }

    /**
     * Retrieves lineEx
     * 
     */
    public Object getLineEx() {
        return this.lineEx;
    }

}
