
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import javax.annotation.Generated;
import com.intuit.ipp.data.CheckPayment;
import com.intuit.ipp.data.CreditCardPayment;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.PaymentTypeEnum;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:35:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class PaymentExpressionHolder
    extends TransactionExpressionHolder
{

    protected Object customerRef;
    protected ReferenceType _customerRefType;
    protected Object remitToRef;
    protected ReferenceType _remitToRefType;
    protected Object depositToAccountRef;
    protected ReferenceType _depositToAccountRefType;
    protected Object paymentMethodRef;
    protected ReferenceType _paymentMethodRefType;
    protected Object paymentRefNum;
    protected String _paymentRefNumType;
    protected Object paymentType;
    protected PaymentTypeEnum _paymentTypeType;
    protected Object checkPayment;
    protected CheckPayment _checkPaymentType;
    protected Object creditCardPayment;
    protected CreditCardPayment _creditCardPaymentType;
    protected Object totalAmt;
    protected BigDecimal _totalAmtType;
    protected Object unappliedAmt;
    protected BigDecimal _unappliedAmtType;
    protected Object processPayment;
    protected Boolean _processPaymentType;
    protected Object paymentEx;
    protected IntuitAnyType _paymentExType;

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
     * Sets remitToRef
     * 
     * @param value Value to set
     */
    public void setRemitToRef(Object value) {
        this.remitToRef = value;
    }

    /**
     * Retrieves remitToRef
     * 
     */
    public Object getRemitToRef() {
        return this.remitToRef;
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
     * Sets paymentRefNum
     * 
     * @param value Value to set
     */
    public void setPaymentRefNum(Object value) {
        this.paymentRefNum = value;
    }

    /**
     * Retrieves paymentRefNum
     * 
     */
    public Object getPaymentRefNum() {
        return this.paymentRefNum;
    }

    /**
     * Sets paymentType
     * 
     * @param value Value to set
     */
    public void setPaymentType(Object value) {
        this.paymentType = value;
    }

    /**
     * Retrieves paymentType
     * 
     */
    public Object getPaymentType() {
        return this.paymentType;
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
     * Sets unappliedAmt
     * 
     * @param value Value to set
     */
    public void setUnappliedAmt(Object value) {
        this.unappliedAmt = value;
    }

    /**
     * Retrieves unappliedAmt
     * 
     */
    public Object getUnappliedAmt() {
        return this.unappliedAmt;
    }

    /**
     * Sets processPayment
     * 
     * @param value Value to set
     */
    public void setProcessPayment(Object value) {
        this.processPayment = value;
    }

    /**
     * Retrieves processPayment
     * 
     */
    public Object getProcessPayment() {
        return this.processPayment;
    }

    /**
     * Sets paymentEx
     * 
     * @param value Value to set
     */
    public void setPaymentEx(Object value) {
        this.paymentEx = value;
    }

    /**
     * Retrieves paymentEx
     * 
     */
    public Object getPaymentEx() {
        return this.paymentEx;
    }

}
