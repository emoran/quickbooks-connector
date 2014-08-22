
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import com.intuit.ipp.data.CheckPayment;
import com.intuit.ipp.data.CreditCardPayment;
import com.intuit.ipp.data.EmailAddress;
import com.intuit.ipp.data.EmailStatusEnum;
import com.intuit.ipp.data.GlobalTaxCalculationEnum;
import com.intuit.ipp.data.MemoRef;
import com.intuit.ipp.data.PaymentTypeEnum;
import com.intuit.ipp.data.PhysicalAddress;
import com.intuit.ipp.data.PrintStatusEnum;
import com.intuit.ipp.data.ReferenceType;
import com.intuit.ipp.data.TransactionDeliveryInfo;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:35:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class SalesTransactionExpressionHolder
    extends TransactionExpressionHolder
{

    protected Object autoDocNumber;
    protected Boolean _autoDocNumberType;
    protected Object customerRef;
    protected ReferenceType _customerRefType;
    protected Object customerMemo;
    protected MemoRef _customerMemoType;
    protected Object billAddr;
    protected PhysicalAddress _billAddrType;
    protected Object shipAddr;
    protected PhysicalAddress _shipAddrType;
    protected Object remitToRef;
    protected ReferenceType _remitToRefType;
    protected Object classRef;
    protected ReferenceType _classRefType;
    protected Object salesTermRef;
    protected ReferenceType _salesTermRefType;
    protected Object dueDate;
    protected Date _dueDateType;
    protected Object salesRepRef;
    protected ReferenceType _salesRepRefType;
    protected Object shipMethodRef;
    protected ReferenceType _shipMethodRefType;
    protected Object shipDate;
    protected Date _shipDateType;
    protected Object trackingNum;
    protected String _trackingNumType;
    protected Object globalTaxCalculation;
    protected GlobalTaxCalculationEnum _globalTaxCalculationType;
    protected Object totalAmt;
    protected BigDecimal _totalAmtType;
    protected Object homeTotalAmt;
    protected BigDecimal _homeTotalAmtType;
    protected Object applyTaxAfterDiscount;
    protected Boolean _applyTaxAfterDiscountType;
    protected Object templateRef;
    protected ReferenceType _templateRefType;
    protected Object printStatus;
    protected PrintStatusEnum _printStatusType;
    protected Object emailStatus;
    protected EmailStatusEnum _emailStatusType;
    protected Object billEmail;
    protected EmailAddress _billEmailType;
    protected Object balance;
    protected BigDecimal _balanceType;
    protected Object financeCharge;
    protected Boolean _financeChargeType;
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
    protected Object depositToAccountRef;
    protected ReferenceType _depositToAccountRefType;
    protected Object deliveryInfo;
    protected TransactionDeliveryInfo _deliveryInfoType;

    /**
     * Sets autoDocNumber
     * 
     * @param value Value to set
     */
    public void setAutoDocNumber(Object value) {
        this.autoDocNumber = value;
    }

    /**
     * Retrieves autoDocNumber
     * 
     */
    public Object getAutoDocNumber() {
        return this.autoDocNumber;
    }

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
     * Sets customerMemo
     * 
     * @param value Value to set
     */
    public void setCustomerMemo(Object value) {
        this.customerMemo = value;
    }

    /**
     * Retrieves customerMemo
     * 
     */
    public Object getCustomerMemo() {
        return this.customerMemo;
    }

    /**
     * Sets billAddr
     * 
     * @param value Value to set
     */
    public void setBillAddr(Object value) {
        this.billAddr = value;
    }

    /**
     * Retrieves billAddr
     * 
     */
    public Object getBillAddr() {
        return this.billAddr;
    }

    /**
     * Sets shipAddr
     * 
     * @param value Value to set
     */
    public void setShipAddr(Object value) {
        this.shipAddr = value;
    }

    /**
     * Retrieves shipAddr
     * 
     */
    public Object getShipAddr() {
        return this.shipAddr;
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
     * Sets salesTermRef
     * 
     * @param value Value to set
     */
    public void setSalesTermRef(Object value) {
        this.salesTermRef = value;
    }

    /**
     * Retrieves salesTermRef
     * 
     */
    public Object getSalesTermRef() {
        return this.salesTermRef;
    }

    /**
     * Sets dueDate
     * 
     * @param value Value to set
     */
    public void setDueDate(Object value) {
        this.dueDate = value;
    }

    /**
     * Retrieves dueDate
     * 
     */
    public Object getDueDate() {
        return this.dueDate;
    }

    /**
     * Sets salesRepRef
     * 
     * @param value Value to set
     */
    public void setSalesRepRef(Object value) {
        this.salesRepRef = value;
    }

    /**
     * Retrieves salesRepRef
     * 
     */
    public Object getSalesRepRef() {
        return this.salesRepRef;
    }

    /**
     * Sets shipMethodRef
     * 
     * @param value Value to set
     */
    public void setShipMethodRef(Object value) {
        this.shipMethodRef = value;
    }

    /**
     * Retrieves shipMethodRef
     * 
     */
    public Object getShipMethodRef() {
        return this.shipMethodRef;
    }

    /**
     * Sets shipDate
     * 
     * @param value Value to set
     */
    public void setShipDate(Object value) {
        this.shipDate = value;
    }

    /**
     * Retrieves shipDate
     * 
     */
    public Object getShipDate() {
        return this.shipDate;
    }

    /**
     * Sets trackingNum
     * 
     * @param value Value to set
     */
    public void setTrackingNum(Object value) {
        this.trackingNum = value;
    }

    /**
     * Retrieves trackingNum
     * 
     */
    public Object getTrackingNum() {
        return this.trackingNum;
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
     * Sets homeTotalAmt
     * 
     * @param value Value to set
     */
    public void setHomeTotalAmt(Object value) {
        this.homeTotalAmt = value;
    }

    /**
     * Retrieves homeTotalAmt
     * 
     */
    public Object getHomeTotalAmt() {
        return this.homeTotalAmt;
    }

    /**
     * Sets applyTaxAfterDiscount
     * 
     * @param value Value to set
     */
    public void setApplyTaxAfterDiscount(Object value) {
        this.applyTaxAfterDiscount = value;
    }

    /**
     * Retrieves applyTaxAfterDiscount
     * 
     */
    public Object getApplyTaxAfterDiscount() {
        return this.applyTaxAfterDiscount;
    }

    /**
     * Sets templateRef
     * 
     * @param value Value to set
     */
    public void setTemplateRef(Object value) {
        this.templateRef = value;
    }

    /**
     * Retrieves templateRef
     * 
     */
    public Object getTemplateRef() {
        return this.templateRef;
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
     * Sets emailStatus
     * 
     * @param value Value to set
     */
    public void setEmailStatus(Object value) {
        this.emailStatus = value;
    }

    /**
     * Retrieves emailStatus
     * 
     */
    public Object getEmailStatus() {
        return this.emailStatus;
    }

    /**
     * Sets billEmail
     * 
     * @param value Value to set
     */
    public void setBillEmail(Object value) {
        this.billEmail = value;
    }

    /**
     * Retrieves billEmail
     * 
     */
    public Object getBillEmail() {
        return this.billEmail;
    }

    /**
     * Sets balance
     * 
     * @param value Value to set
     */
    public void setBalance(Object value) {
        this.balance = value;
    }

    /**
     * Retrieves balance
     * 
     */
    public Object getBalance() {
        return this.balance;
    }

    /**
     * Sets financeCharge
     * 
     * @param value Value to set
     */
    public void setFinanceCharge(Object value) {
        this.financeCharge = value;
    }

    /**
     * Retrieves financeCharge
     * 
     */
    public Object getFinanceCharge() {
        return this.financeCharge;
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
     * Sets deliveryInfo
     * 
     * @param value Value to set
     */
    public void setDeliveryInfo(Object value) {
        this.deliveryInfo = value;
    }

    /**
     * Retrieves deliveryInfo
     * 
     */
    public Object getDeliveryInfo() {
        return this.deliveryInfo;
    }

}
