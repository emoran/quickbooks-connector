
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import javax.annotation.Generated;
import com.intuit.ipp.data.CheckPayment;
import com.intuit.ipp.data.CreditCardPayment;
import com.intuit.ipp.data.GlobalTaxCalculationEnum;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.PaymentTypeEnum;
import com.intuit.ipp.data.PhysicalAddress;
import com.intuit.ipp.data.PrintStatusEnum;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:35:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class PurchaseExpressionHolder
    extends TransactionExpressionHolder
{

    protected Object accountRef;
    protected ReferenceType _accountRefType;
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
    protected Object entityRef;
    protected ReferenceType _entityRefType;
    protected Object credit;
    protected Boolean _creditType;
    protected Object remitToAddr;
    protected PhysicalAddress _remitToAddrType;
    protected Object totalAmt;
    protected BigDecimal _totalAmtType;
    protected Object txnId;
    protected String _txnIdType;
    protected Object txnNum;
    protected String _txnNumType;
    protected Object memo;
    protected String _memoType;
    protected Object printStatus;
    protected PrintStatusEnum _printStatusType;
    protected Object globalTaxCalculation;
    protected GlobalTaxCalculationEnum _globalTaxCalculationType;
    protected Object purchaseEx;
    protected IntuitAnyType _purchaseExType;

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
     * Sets entityRef
     * 
     * @param value Value to set
     */
    public void setEntityRef(Object value) {
        this.entityRef = value;
    }

    /**
     * Retrieves entityRef
     * 
     */
    public Object getEntityRef() {
        return this.entityRef;
    }

    /**
     * Sets credit
     * 
     * @param value Value to set
     */
    public void setCredit(Object value) {
        this.credit = value;
    }

    /**
     * Retrieves credit
     * 
     */
    public Object getCredit() {
        return this.credit;
    }

    /**
     * Sets remitToAddr
     * 
     * @param value Value to set
     */
    public void setRemitToAddr(Object value) {
        this.remitToAddr = value;
    }

    /**
     * Retrieves remitToAddr
     * 
     */
    public Object getRemitToAddr() {
        return this.remitToAddr;
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
     * Sets txnId
     * 
     * @param value Value to set
     */
    public void setTxnId(Object value) {
        this.txnId = value;
    }

    /**
     * Retrieves txnId
     * 
     */
    public Object getTxnId() {
        return this.txnId;
    }

    /**
     * Sets txnNum
     * 
     * @param value Value to set
     */
    public void setTxnNum(Object value) {
        this.txnNum = value;
    }

    /**
     * Retrieves txnNum
     * 
     */
    public Object getTxnNum() {
        return this.txnNum;
    }

    /**
     * Sets memo
     * 
     * @param value Value to set
     */
    public void setMemo(Object value) {
        this.memo = value;
    }

    /**
     * Retrieves memo
     * 
     */
    public Object getMemo() {
        return this.memo;
    }

    /**
     * Sets printStatus
     * 
     * @param value Value to set
     */
    public void setPrintStatus(Object value) {
        this.printStatus = value;
    }

    /**
     * Retrieves printStatus
     * 
     */
    public Object getPrintStatus() {
        return this.printStatus;
    }

    /**
     * Sets globalTaxCalculation
     * 
     * @param value Value to set
     */
    public void setGlobalTaxCalculation(Object value) {
        this.globalTaxCalculation = value;
    }

    /**
     * Retrieves globalTaxCalculation
     * 
     */
    public Object getGlobalTaxCalculation() {
        return this.globalTaxCalculation;
    }

    /**
     * Sets purchaseEx
     * 
     * @param value Value to set
     */
    public void setPurchaseEx(Object value) {
        this.purchaseEx = value;
    }

    /**
     * Retrieves purchaseEx
     * 
     */
    public Object getPurchaseEx() {
        return this.purchaseEx;
    }

}
