
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import javax.annotation.Generated;
import com.intuit.ipp.data.BillableStatusEnum;
import com.intuit.ipp.data.EntityTypeRef;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.PostingTypeEnum;
import com.intuit.ipp.data.ReferenceType;
import com.intuit.ipp.data.TaxApplicableOnEnum;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-21T02:54:07-05:00", comments = "Build 3.4.3.1620.30ea288")
public class JournalEntryLineDetailExpressionHolder {

    protected Object postingType;
    protected PostingTypeEnum _postingTypeType;
    protected Object entity;
    protected EntityTypeRef _entityType;
    protected Object accountRef;
    protected ReferenceType _accountRefType;
    protected Object classRef;
    protected ReferenceType _classRefType;
    protected Object departmentRef;
    protected ReferenceType _departmentRefType;
    protected Object taxCodeRef;
    protected ReferenceType _taxCodeRefType;
    protected Object taxApplicableOn;
    protected TaxApplicableOnEnum _taxApplicableOnType;
    protected Object taxAmount;
    protected BigDecimal _taxAmountType;
    protected Object billableStatus;
    protected BillableStatusEnum _billableStatusType;
    protected Object journalEntryLineDetailEx;
    protected IntuitAnyType _journalEntryLineDetailExType;

    /**
     * Sets postingType
     * 
     * @param value Value to set
     */
    public void setPostingType(Object value) {
        this.postingType = value;
    }

    /**
     * Retrieves postingType
     * 
     */
    public Object getPostingType() {
        return this.postingType;
    }

    /**
     * Sets entity
     * 
     * @param value Value to set
     */
    public void setEntity(Object value) {
        this.entity = value;
    }

    /**
     * Retrieves entity
     * 
     */
    public Object getEntity() {
        return this.entity;
    }

    /**
     * Sets accountRef
     * 
     * @param value Value to set
     */
    public void setAccountRef(Object value) {
        this.accountRef = value;
    }

    /**
     * Retrieves accountRef
     * 
     */
    public Object getAccountRef() {
        return this.accountRef;
    }

    /**
     * Sets classRef
     * 
     * @param value Value to set
     */
    public void setClassRef(Object value) {
        this.classRef = value;
    }

    /**
     * Retrieves classRef
     * 
     */
    public Object getClassRef() {
        return this.classRef;
    }

    /**
     * Sets departmentRef
     * 
     * @param value Value to set
     */
    public void setDepartmentRef(Object value) {
        this.departmentRef = value;
    }

    /**
     * Retrieves departmentRef
     * 
     */
    public Object getDepartmentRef() {
        return this.departmentRef;
    }

    /**
     * Sets taxCodeRef
     * 
     * @param value Value to set
     */
    public void setTaxCodeRef(Object value) {
        this.taxCodeRef = value;
    }

    /**
     * Retrieves taxCodeRef
     * 
     */
    public Object getTaxCodeRef() {
        return this.taxCodeRef;
    }

    /**
     * Sets taxApplicableOn
     * 
     * @param value Value to set
     */
    public void setTaxApplicableOn(Object value) {
        this.taxApplicableOn = value;
    }

    /**
     * Retrieves taxApplicableOn
     * 
     */
    public Object getTaxApplicableOn() {
        return this.taxApplicableOn;
    }

    /**
     * Sets taxAmount
     * 
     * @param value Value to set
     */
    public void setTaxAmount(Object value) {
        this.taxAmount = value;
    }

    /**
     * Retrieves taxAmount
     * 
     */
    public Object getTaxAmount() {
        return this.taxAmount;
    }

    /**
     * Sets billableStatus
     * 
     * @param value Value to set
     */
    public void setBillableStatus(Object value) {
        this.billableStatus = value;
    }

    /**
     * Retrieves billableStatus
     * 
     */
    public Object getBillableStatus() {
        return this.billableStatus;
    }

    /**
     * Sets journalEntryLineDetailEx
     * 
     * @param value Value to set
     */
    public void setJournalEntryLineDetailEx(Object value) {
        this.journalEntryLineDetailEx = value;
    }

    /**
     * Retrieves journalEntryLineDetailEx
     * 
     */
    public Object getJournalEntryLineDetailEx() {
        return this.journalEntryLineDetailEx;
    }

}
