
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import javax.annotation.Generated;
import com.intuit.ipp.data.BillPaymentCheck;
import com.intuit.ipp.data.BillPaymentCreditCard;
import com.intuit.ipp.data.BillPaymentTypeEnum;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class BillPaymentExpressionHolder
    extends TransactionExpressionHolder
{

    protected Object vendorRef;
    protected ReferenceType _vendorRefType;
    protected Object payType;
    protected BillPaymentTypeEnum _payTypeType;
    protected Object checkPayment;
    protected BillPaymentCheck _checkPaymentType;
    protected Object creditCardPayment;
    protected BillPaymentCreditCard _creditCardPaymentType;
    protected Object totalAmt;
    protected BigDecimal _totalAmtType;
    protected Object billPaymentEx;
    protected IntuitAnyType _billPaymentExType;

    /**
     * Sets vendorRef
     * 
     * @param value Value to set
     */
    public void setVendorRef(Object value) {
        this.vendorRef = value;
    }

    /**
     * Retrieves vendorRef
     * 
     */
    public Object getVendorRef() {
        return this.vendorRef;
    }

    /**
     * Sets payType
     * 
     * @param value Value to set
     */
    public void setPayType(Object value) {
        this.payType = value;
    }

    /**
     * Retrieves payType
     * 
     */
    public Object getPayType() {
        return this.payType;
    }

    /**
     * Sets checkPayment
     * 
     * @param value Value to set
     */
    public void setCheckPayment(Object value) {
        this.checkPayment = value;
    }

    /**
     * Retrieves checkPayment
     * 
     */
    public Object getCheckPayment() {
        return this.checkPayment;
    }

    /**
     * Sets creditCardPayment
     * 
     * @param value Value to set
     */
    public void setCreditCardPayment(Object value) {
        this.creditCardPayment = value;
    }

    /**
     * Retrieves creditCardPayment
     * 
     */
    public Object getCreditCardPayment() {
        return this.creditCardPayment;
    }

    /**
     * Sets totalAmt
     * 
     * @param value Value to set
     */
    public void setTotalAmt(Object value) {
        this.totalAmt = value;
    }

    /**
     * Retrieves totalAmt
     * 
     */
    public Object getTotalAmt() {
        return this.totalAmt;
    }

    /**
     * Sets billPaymentEx
     * 
     * @param value Value to set
     */
    public void setBillPaymentEx(Object value) {
        this.billPaymentEx = value;
    }

    /**
     * Retrieves billPaymentEx
     * 
     */
    public Object getBillPaymentEx() {
        return this.billPaymentEx;
    }

}
