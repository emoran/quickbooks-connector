
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import javax.annotation.Generated;
import com.intuit.ipp.data.BillableStatusEnum;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.MarkupInfo;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-15T04:14:53-05:00", comments = "Build 3.4.3.1620.30ea288")
public class AccountBasedExpenseLineDetailExpressionHolder {

    protected Object customerRef;
    protected ReferenceType _customerRefType;
    protected Object classRef;
    protected ReferenceType _classRefType;
    protected Object accountRef;
    protected ReferenceType _accountRefType;
    protected Object billableStatus;
    protected BillableStatusEnum _billableStatusType;
    protected Object markupInfo;
    protected MarkupInfo _markupInfoType;
    protected Object taxAmount;
    protected BigDecimal _taxAmountType;
    protected Object taxCodeRef;
    protected ReferenceType _taxCodeRefType;
    protected Object taxInclusiveAmt;
    protected BigDecimal _taxInclusiveAmtType;
    protected Object expenseDetailLineDetailEx;
    protected IntuitAnyType _expenseDetailLineDetailExType;

    /**
     * Sets customerRef
     * 
     * @param value Value to set
     */
    public void setCustomerRef(Object value) {
        this.customerRef = value;
    }

    /**
     * Retrieves customerRef
     * 
     */
    public Object getCustomerRef() {
        return this.customerRef;
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
     * Sets markupInfo
     * 
     * @param value Value to set
     */
    public void setMarkupInfo(Object value) {
        this.markupInfo = value;
    }

    /**
     * Retrieves markupInfo
     * 
     */
    public Object getMarkupInfo() {
        return this.markupInfo;
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
     * Sets taxInclusiveAmt
     * 
     * @param value Value to set
     */
    public void setTaxInclusiveAmt(Object value) {
        this.taxInclusiveAmt = value;
    }

    /**
     * Retrieves taxInclusiveAmt
     * 
     */
    public Object getTaxInclusiveAmt() {
        return this.taxInclusiveAmt;
    }

    /**
     * Sets expenseDetailLineDetailEx
     * 
     * @param value Value to set
     */
    public void setExpenseDetailLineDetailEx(Object value) {
        this.expenseDetailLineDetailEx = value;
    }

    /**
     * Retrieves expenseDetailLineDetailEx
     * 
     */
    public Object getExpenseDetailLineDetailEx() {
        return this.expenseDetailLineDetailEx;
    }

}
