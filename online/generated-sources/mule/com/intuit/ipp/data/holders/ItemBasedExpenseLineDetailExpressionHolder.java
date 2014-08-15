
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import javax.annotation.Generated;
import com.intuit.ipp.data.BillableStatusEnum;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-15T04:14:53-05:00", comments = "Build 3.4.3.1620.30ea288")
public class ItemBasedExpenseLineDetailExpressionHolder
    extends ItemLineDetailExpressionHolder
{

    protected Object customerRef;
    protected ReferenceType _customerRefType;
    protected Object billableStatus;
    protected BillableStatusEnum _billableStatusType;
    protected Object taxInclusiveAmt;
    protected BigDecimal _taxInclusiveAmtType;
    protected Object itemBasedExpenseLineDetailEx;
    protected IntuitAnyType _itemBasedExpenseLineDetailExType;

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
     * Sets itemBasedExpenseLineDetailEx
     * 
     * @param value Value to set
     */
    public void setItemBasedExpenseLineDetailEx(Object value) {
        this.itemBasedExpenseLineDetailEx = value;
    }

    /**
     * Retrieves itemBasedExpenseLineDetailEx
     * 
     */
    public Object getItemBasedExpenseLineDetailEx() {
        return this.itemBasedExpenseLineDetailEx;
    }

}
