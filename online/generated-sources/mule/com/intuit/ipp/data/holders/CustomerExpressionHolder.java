
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.JobInfo;
import com.intuit.ipp.data.PhysicalAddress;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class CustomerExpressionHolder
    extends NameBaseExpressionHolder
{

    protected Object taxable;
    protected Boolean _taxableType;
    protected Object billAddr;
    protected PhysicalAddress _billAddrType;
    protected Object shipAddr;
    protected PhysicalAddress _shipAddrType;
    protected Object otherAddr;
    protected List<PhysicalAddress> _otherAddrType;
    protected Object contactName;
    protected String _contactNameType;
    protected Object altContactName;
    protected String _altContactNameType;
    protected Object notes;
    protected String _notesType;
    protected Object job;
    protected Boolean _jobType;
    protected Object billWithParent;
    protected Boolean _billWithParentType;
    protected Object rootCustomerRef;
    protected ReferenceType _rootCustomerRefType;
    protected Object parentRef;
    protected ReferenceType _parentRefType;
    protected Object level;
    protected Integer _levelType;
    protected Object customerTypeRef;
    protected ReferenceType _customerTypeRefType;
    protected Object salesTermRef;
    protected ReferenceType _salesTermRefType;
    protected Object salesRepRef;
    protected ReferenceType _salesRepRefType;
    protected Object taxGroupCodeRef;
    protected ReferenceType _taxGroupCodeRefType;
    protected Object taxRateRef;
    protected ReferenceType _taxRateRefType;
    protected Object paymentMethodRef;
    protected ReferenceType _paymentMethodRefType;
    protected Object priceLevelRef;
    protected ReferenceType _priceLevelRefType;
    protected Object balance;
    protected BigDecimal _balanceType;
    protected Object openBalanceDate;
    protected Date _openBalanceDateType;
    protected Object balanceWithJobs;
    protected BigDecimal _balanceWithJobsType;
    protected Object creditLimit;
    protected BigDecimal _creditLimitType;
    protected Object acctNum;
    protected String _acctNumType;
    protected Object currencyRef;
    protected ReferenceType _currencyRefType;
    protected Object overDueBalance;
    protected BigDecimal _overDueBalanceType;
    protected Object totalRevenue;
    protected BigDecimal _totalRevenueType;
    protected Object totalExpense;
    protected BigDecimal _totalExpenseType;
    protected Object preferredDeliveryMethod;
    protected String _preferredDeliveryMethodType;
    protected Object resaleNum;
    protected String _resaleNumType;
    protected Object jobInfo;
    protected JobInfo _jobInfoType;
    protected Object customerEx;
    protected IntuitAnyType _customerExType;

    /**
     * Sets taxable
     * 
     * @param value Value to set
     */
    public void setTaxable(Object value) {
        this.taxable = value;
    }

    /**
     * Retrieves taxable
     * 
     */
    public Object getTaxable() {
        return this.taxable;
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
     * Sets otherAddr
     * 
     * @param value Value to set
     */
    public void setOtherAddr(Object value) {
        this.otherAddr = value;
    }

    /**
     * Retrieves otherAddr
     * 
     */
    public Object getOtherAddr() {
        return this.otherAddr;
    }

    /**
     * Sets contactName
     * 
     * @param value Value to set
     */
    public void setContactName(Object value) {
        this.contactName = value;
    }

    /**
     * Retrieves contactName
     * 
     */
    public Object getContactName() {
        return this.contactName;
    }

    /**
     * Sets altContactName
     * 
     * @param value Value to set
     */
    public void setAltContactName(Object value) {
        this.altContactName = value;
    }

    /**
     * Retrieves altContactName
     * 
     */
    public Object getAltContactName() {
        return this.altContactName;
    }

    /**
     * Sets notes
     * 
     * @param value Value to set
     */
    public void setNotes(Object value) {
        this.notes = value;
    }

    /**
     * Retrieves notes
     * 
     */
    public Object getNotes() {
        return this.notes;
    }

    /**
     * Sets job
     * 
     * @param value Value to set
     */
    public void setJob(Object value) {
        this.job = value;
    }

    /**
     * Retrieves job
     * 
     */
    public Object getJob() {
        return this.job;
    }

    /**
     * Sets billWithParent
     * 
     * @param value Value to set
     */
    public void setBillWithParent(Object value) {
        this.billWithParent = value;
    }

    /**
     * Retrieves billWithParent
     * 
     */
    public Object getBillWithParent() {
        return this.billWithParent;
    }

    /**
     * Sets rootCustomerRef
     * 
     * @param value Value to set
     */
    public void setRootCustomerRef(Object value) {
        this.rootCustomerRef = value;
    }

    /**
     * Retrieves rootCustomerRef
     * 
     */
    public Object getRootCustomerRef() {
        return this.rootCustomerRef;
    }

    /**
     * Sets parentRef
     * 
     * @param value Value to set
     */
    public void setParentRef(Object value) {
        this.parentRef = value;
    }

    /**
     * Retrieves parentRef
     * 
     */
    public Object getParentRef() {
        return this.parentRef;
    }

    /**
     * Sets level
     * 
     * @param value Value to set
     */
    public void setLevel(Object value) {
        this.level = value;
    }

    /**
     * Retrieves level
     * 
     */
    public Object getLevel() {
        return this.level;
    }

    /**
     * Sets customerTypeRef
     * 
     * @param value Value to set
     */
    public void setCustomerTypeRef(Object value) {
        this.customerTypeRef = value;
    }

    /**
     * Retrieves customerTypeRef
     * 
     */
    public Object getCustomerTypeRef() {
        return this.customerTypeRef;
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
     * Sets taxGroupCodeRef
     * 
     * @param value Value to set
     */
    public void setTaxGroupCodeRef(Object value) {
        this.taxGroupCodeRef = value;
    }

    /**
     * Retrieves taxGroupCodeRef
     * 
     */
    public Object getTaxGroupCodeRef() {
        return this.taxGroupCodeRef;
    }

    /**
     * Sets taxRateRef
     * 
     * @param value Value to set
     */
    public void setTaxRateRef(Object value) {
        this.taxRateRef = value;
    }

    /**
     * Retrieves taxRateRef
     * 
     */
    public Object getTaxRateRef() {
        return this.taxRateRef;
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
     * Sets priceLevelRef
     * 
     * @param value Value to set
     */
    public void setPriceLevelRef(Object value) {
        this.priceLevelRef = value;
    }

    /**
     * Retrieves priceLevelRef
     * 
     */
    public Object getPriceLevelRef() {
        return this.priceLevelRef;
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
     * Sets openBalanceDate
     * 
     * @param value Value to set
     */
    public void setOpenBalanceDate(Object value) {
        this.openBalanceDate = value;
    }

    /**
     * Retrieves openBalanceDate
     * 
     */
    public Object getOpenBalanceDate() {
        return this.openBalanceDate;
    }

    /**
     * Sets balanceWithJobs
     * 
     * @param value Value to set
     */
    public void setBalanceWithJobs(Object value) {
        this.balanceWithJobs = value;
    }

    /**
     * Retrieves balanceWithJobs
     * 
     */
    public Object getBalanceWithJobs() {
        return this.balanceWithJobs;
    }

    /**
     * Sets creditLimit
     * 
     * @param value Value to set
     */
    public void setCreditLimit(Object value) {
        this.creditLimit = value;
    }

    /**
     * Retrieves creditLimit
     * 
     */
    public Object getCreditLimit() {
        return this.creditLimit;
    }

    /**
     * Sets acctNum
     * 
     * @param value Value to set
     */
    public void setAcctNum(Object value) {
        this.acctNum = value;
    }

    /**
     * Retrieves acctNum
     * 
     */
    public Object getAcctNum() {
        return this.acctNum;
    }

    /**
     * Sets currencyRef
     * 
     * @param value Value to set
     */
    public void setCurrencyRef(Object value) {
        this.currencyRef = value;
    }

    /**
     * Retrieves currencyRef
     * 
     */
    public Object getCurrencyRef() {
        return this.currencyRef;
    }

    /**
     * Sets overDueBalance
     * 
     * @param value Value to set
     */
    public void setOverDueBalance(Object value) {
        this.overDueBalance = value;
    }

    /**
     * Retrieves overDueBalance
     * 
     */
    public Object getOverDueBalance() {
        return this.overDueBalance;
    }

    /**
     * Sets totalRevenue
     * 
     * @param value Value to set
     */
    public void setTotalRevenue(Object value) {
        this.totalRevenue = value;
    }

    /**
     * Retrieves totalRevenue
     * 
     */
    public Object getTotalRevenue() {
        return this.totalRevenue;
    }

    /**
     * Sets totalExpense
     * 
     * @param value Value to set
     */
    public void setTotalExpense(Object value) {
        this.totalExpense = value;
    }

    /**
     * Retrieves totalExpense
     * 
     */
    public Object getTotalExpense() {
        return this.totalExpense;
    }

    /**
     * Sets preferredDeliveryMethod
     * 
     * @param value Value to set
     */
    public void setPreferredDeliveryMethod(Object value) {
        this.preferredDeliveryMethod = value;
    }

    /**
     * Retrieves preferredDeliveryMethod
     * 
     */
    public Object getPreferredDeliveryMethod() {
        return this.preferredDeliveryMethod;
    }

    /**
     * Sets resaleNum
     * 
     * @param value Value to set
     */
    public void setResaleNum(Object value) {
        this.resaleNum = value;
    }

    /**
     * Retrieves resaleNum
     * 
     */
    public Object getResaleNum() {
        return this.resaleNum;
    }

    /**
     * Sets jobInfo
     * 
     * @param value Value to set
     */
    public void setJobInfo(Object value) {
        this.jobInfo = value;
    }

    /**
     * Retrieves jobInfo
     * 
     */
    public Object getJobInfo() {
        return this.jobInfo;
    }

    /**
     * Sets customerEx
     * 
     * @param value Value to set
     */
    public void setCustomerEx(Object value) {
        this.customerEx = value;
    }

    /**
     * Retrieves customerEx
     * 
     */
    public Object getCustomerEx() {
        return this.customerEx;
    }

}
