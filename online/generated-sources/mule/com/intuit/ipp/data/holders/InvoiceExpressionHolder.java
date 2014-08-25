
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import com.intuit.ipp.data.ETransactionStatusEnum;
import com.intuit.ipp.data.IntuitAnyType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class InvoiceExpressionHolder
    extends SalesTransactionExpressionHolder
{

    protected Object deposit;
    protected BigDecimal _depositType;
    protected Object allowIPNPayment;
    protected Boolean _allowIPNPaymentType;
    protected Object allowOnlinePayment;
    protected Boolean _allowOnlinePaymentType;
    protected Object allowOnlineCreditCardPayment;
    protected Boolean _allowOnlineCreditCardPaymentType;
    protected Object allowOnlineACHPayment;
    protected Boolean _allowOnlineACHPaymentType;
    protected Object eInvoiceStatus;
    protected ETransactionStatusEnum _eInvoiceStatusType;
    protected Object eCloudStatusTimeStamp;
    protected Date _eCloudStatusTimeStampType;
    protected Object invoiceEx;
    protected IntuitAnyType _invoiceExType;

    /**
     * Sets deposit
     * 
     * @param value Value to set
     */
    public void setDeposit(Object value) {
        this.deposit = value;
    }

    /**
     * Retrieves deposit
     * 
     */
    public Object getDeposit() {
        return this.deposit;
    }

    /**
     * Sets allowIPNPayment
     * 
     * @param value Value to set
     */
    public void setAllowIPNPayment(Object value) {
        this.allowIPNPayment = value;
    }

    /**
     * Retrieves allowIPNPayment
     * 
     */
    public Object getAllowIPNPayment() {
        return this.allowIPNPayment;
    }

    /**
     * Sets allowOnlinePayment
     * 
     * @param value Value to set
     */
    public void setAllowOnlinePayment(Object value) {
        this.allowOnlinePayment = value;
    }

    /**
     * Retrieves allowOnlinePayment
     * 
     */
    public Object getAllowOnlinePayment() {
        return this.allowOnlinePayment;
    }

    /**
     * Sets allowOnlineCreditCardPayment
     * 
     * @param value Value to set
     */
    public void setAllowOnlineCreditCardPayment(Object value) {
        this.allowOnlineCreditCardPayment = value;
    }

    /**
     * Retrieves allowOnlineCreditCardPayment
     * 
     */
    public Object getAllowOnlineCreditCardPayment() {
        return this.allowOnlineCreditCardPayment;
    }

    /**
     * Sets allowOnlineACHPayment
     * 
     * @param value Value to set
     */
    public void setAllowOnlineACHPayment(Object value) {
        this.allowOnlineACHPayment = value;
    }

    /**
     * Retrieves allowOnlineACHPayment
     * 
     */
    public Object getAllowOnlineACHPayment() {
        return this.allowOnlineACHPayment;
    }

    /**
     * Sets eInvoiceStatus
     * 
     * @param value Value to set
     */
    public void setEInvoiceStatus(Object value) {
        this.eInvoiceStatus = value;
    }

    /**
     * Retrieves eInvoiceStatus
     * 
     */
    public Object getEInvoiceStatus() {
        return this.eInvoiceStatus;
    }

    /**
     * Sets eCloudStatusTimeStamp
     * 
     * @param value Value to set
     */
    public void setECloudStatusTimeStamp(Object value) {
        this.eCloudStatusTimeStamp = value;
    }

    /**
     * Retrieves eCloudStatusTimeStamp
     * 
     */
    public Object getECloudStatusTimeStamp() {
        return this.eCloudStatusTimeStamp;
    }

    /**
     * Sets invoiceEx
     * 
     * @param value Value to set
     */
    public void setInvoiceEx(Object value) {
        this.invoiceEx = value;
    }

    /**
     * Retrieves invoiceEx
     * 
     */
    public Object getInvoiceEx() {
        return this.invoiceEx;
    }

}
