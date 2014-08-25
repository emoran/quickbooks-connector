
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.PhysicalAddress;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class BillExpressionHolder
    extends PurchaseByVendorExpressionHolder
{

    protected Object payerRef;
    protected ReferenceType _payerRefType;
    protected Object salesTermRef;
    protected ReferenceType _salesTermRefType;
    protected Object dueDate;
    protected Date _dueDateType;
    protected Object remitToAddr;
    protected PhysicalAddress _remitToAddrType;
    protected Object shipAddr;
    protected PhysicalAddress _shipAddrType;
    protected Object balance;
    protected BigDecimal _balanceType;
    protected Object billEx;
    protected IntuitAnyType _billExType;

    /**
     * Sets payerRef
     * 
     * @param value Value to set
     */
    public void setPayerRef(Object value) {
        this.payerRef = value;
    }

    /**
     * Retrieves payerRef
     * 
     */
    public Object getPayerRef() {
        return this.payerRef;
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
     * Sets billEx
     * 
     * @param value Value to set
     */
    public void setBillEx(Object value) {
        this.billEx = value;
    }

    /**
     * Retrieves billEx
     * 
     */
    public Object getBillEx() {
        return this.billEx;
    }

}
