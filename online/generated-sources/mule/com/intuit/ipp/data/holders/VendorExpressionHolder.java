
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.PhysicalAddress;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:35:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class VendorExpressionHolder
    extends NameBaseExpressionHolder
{

    protected Object contactName;
    protected String _contactNameType;
    protected Object altContactName;
    protected String _altContactNameType;
    protected Object notes;
    protected String _notesType;
    protected Object billAddr;
    protected PhysicalAddress _billAddrType;
    protected Object shipAddr;
    protected PhysicalAddress _shipAddrType;
    protected Object otherAddr;
    protected List<PhysicalAddress> _otherAddrType;
    protected Object taxCountry;
    protected String _taxCountryType;
    protected Object taxIdentifier;
    protected String _taxIdentifierType;
    protected Object businessNumber;
    protected String _businessNumberType;
    protected Object parentRef;
    protected ReferenceType _parentRefType;
    protected Object vendorTypeRef;
    protected ReferenceType _vendorTypeRefType;
    protected Object termRef;
    protected ReferenceType _termRefType;
    protected Object prefillAccountRef;
    protected ReferenceType _prefillAccountRefType;
    protected Object balance;
    protected BigDecimal _balanceType;
    protected Object openBalanceDate;
    protected Date _openBalanceDateType;
    protected Object creditLimit;
    protected BigDecimal _creditLimitType;
    protected Object acctNum;
    protected String _acctNumType;
    protected Object vendor1099;
    protected Boolean _vendor1099Type;
    protected Object t4AEligible;
    protected Boolean _t4AEligibleType;
    protected Object t5018Eligible;
    protected Boolean _t5018EligibleType;
    protected Object currencyRef;
    protected ReferenceType _currencyRefType;
    protected Object vendorEx;
    protected IntuitAnyType _vendorExType;

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
     * Sets taxCountry
     * 
     * @param value Value to set
     */
    public void setTaxCountry(Object value) {
        this.taxCountry = value;
    }

    /**
     * Retrieves taxCountry
     * 
     */
    public Object getTaxCountry() {
        return this.taxCountry;
    }

    /**
     * Sets taxIdentifier
     * 
     * @param value Value to set
     */
    public void setTaxIdentifier(Object value) {
        this.taxIdentifier = value;
    }

    /**
     * Retrieves taxIdentifier
     * 
     */
    public Object getTaxIdentifier() {
        return this.taxIdentifier;
    }

    /**
     * Sets businessNumber
     * 
     * @param value Value to set
     */
    public void setBusinessNumber(Object value) {
        this.businessNumber = value;
    }

    /**
     * Retrieves businessNumber
     * 
     */
    public Object getBusinessNumber() {
        return this.businessNumber;
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
     * Sets vendorTypeRef
     * 
     * @param value Value to set
     */
    public void setVendorTypeRef(Object value) {
        this.vendorTypeRef = value;
    }

    /**
     * Retrieves vendorTypeRef
     * 
     */
    public Object getVendorTypeRef() {
        return this.vendorTypeRef;
    }

    /**
     * Sets termRef
     * 
     * @param value Value to set
     */
    public void setTermRef(Object value) {
        this.termRef = value;
    }

    /**
     * Retrieves termRef
     * 
     */
    public Object getTermRef() {
        return this.termRef;
    }

    /**
     * Sets prefillAccountRef
     * 
     * @param value Value to set
     */
    public void setPrefillAccountRef(Object value) {
        this.prefillAccountRef = value;
    }

    /**
     * Retrieves prefillAccountRef
     * 
     */
    public Object getPrefillAccountRef() {
        return this.prefillAccountRef;
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
     * Sets vendor1099
     * 
     * @param value Value to set
     */
    public void setVendor1099(Object value) {
        this.vendor1099 = value;
    }

    /**
     * Retrieves vendor1099
     * 
     */
    public Object getVendor1099() {
        return this.vendor1099;
    }

    /**
     * Sets t4AEligible
     * 
     * @param value Value to set
     */
    public void setT4AEligible(Object value) {
        this.t4AEligible = value;
    }

    /**
     * Retrieves t4AEligible
     * 
     */
    public Object getT4AEligible() {
        return this.t4AEligible;
    }

    /**
     * Sets t5018Eligible
     * 
     * @param value Value to set
     */
    public void setT5018Eligible(Object value) {
        this.t5018Eligible = value;
    }

    /**
     * Retrieves t5018Eligible
     * 
     */
    public Object getT5018Eligible() {
        return this.t5018Eligible;
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
     * Sets vendorEx
     * 
     * @param value Value to set
     */
    public void setVendorEx(Object value) {
        this.vendorEx = value;
    }

    /**
     * Retrieves vendorEx
     * 
     */
    public Object getVendorEx() {
        return this.vendorEx;
    }

}
