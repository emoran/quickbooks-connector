
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import com.intuit.ipp.data.AccountClassificationEnum;
import com.intuit.ipp.data.AccountTypeEnum;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-15T04:14:53-05:00", comments = "Build 3.4.3.1620.30ea288")
public class AccountExpressionHolder
    extends IntuitEntityExpressionHolder
{

    protected Object name;
    protected String _nameType;
    protected Object subAccount;
    protected Boolean _subAccountType;
    protected Object parentRef;
    protected ReferenceType _parentRefType;
    protected Object description;
    protected String _descriptionType;
    protected Object fullyQualifiedName;
    protected String _fullyQualifiedNameType;
    protected Object active;
    protected Boolean _activeType;
    protected Object classification;
    protected AccountClassificationEnum _classificationType;
    protected Object accountType;
    protected AccountTypeEnum _accountTypeType;
    protected Object accountSubType;
    protected String _accountSubTypeType;
    protected Object acctNum;
    protected String _acctNumType;
    protected Object bankNum;
    protected String _bankNumType;
    protected Object openingBalance;
    protected BigDecimal _openingBalanceType;
    protected Object openingBalanceDate;
    protected Date _openingBalanceDateType;
    protected Object currentBalance;
    protected BigDecimal _currentBalanceType;
    protected Object currentBalanceWithSubAccounts;
    protected BigDecimal _currentBalanceWithSubAccountsType;
    protected Object currencyRef;
    protected ReferenceType _currencyRefType;
    protected Object taxAccount;
    protected Boolean _taxAccountType;
    protected Object taxCodeRef;
    protected ReferenceType _taxCodeRefType;
    protected Object onlineBankingEnabled;
    protected Boolean _onlineBankingEnabledType;
    protected Object accountEx;
    protected IntuitAnyType _accountExType;

    /**
     * Sets name
     * 
     * @param value Value to set
     */
    public void setName(Object value) {
        this.name = value;
    }

    /**
     * Retrieves name
     * 
     */
    public Object getName() {
        return this.name;
    }

    /**
     * Sets subAccount
     * 
     * @param value Value to set
     */
    public void setSubAccount(Object value) {
        this.subAccount = value;
    }

    /**
     * Retrieves subAccount
     * 
     */
    public Object getSubAccount() {
        return this.subAccount;
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
     * Sets description
     * 
     * @param value Value to set
     */
    public void setDescription(Object value) {
        this.description = value;
    }

    /**
     * Retrieves description
     * 
     */
    public Object getDescription() {
        return this.description;
    }

    /**
     * Sets fullyQualifiedName
     * 
     * @param value Value to set
     */
    public void setFullyQualifiedName(Object value) {
        this.fullyQualifiedName = value;
    }

    /**
     * Retrieves fullyQualifiedName
     * 
     */
    public Object getFullyQualifiedName() {
        return this.fullyQualifiedName;
    }

    /**
     * Sets active
     * 
     * @param value Value to set
     */
    public void setActive(Object value) {
        this.active = value;
    }

    /**
     * Retrieves active
     * 
     */
    public Object getActive() {
        return this.active;
    }

    /**
     * Sets classification
     * 
     * @param value Value to set
     */
    public void setClassification(Object value) {
        this.classification = value;
    }

    /**
     * Retrieves classification
     * 
     */
    public Object getClassification() {
        return this.classification;
    }

    /**
     * Sets accountType
     * 
     * @param value Value to set
     */
    public void setAccountType(Object value) {
        this.accountType = value;
    }

    /**
     * Retrieves accountType
     * 
     */
    public Object getAccountType() {
        return this.accountType;
    }

    /**
     * Sets accountSubType
     * 
     * @param value Value to set
     */
    public void setAccountSubType(Object value) {
        this.accountSubType = value;
    }

    /**
     * Retrieves accountSubType
     * 
     */
    public Object getAccountSubType() {
        return this.accountSubType;
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
     * Sets bankNum
     * 
     * @param value Value to set
     */
    public void setBankNum(Object value) {
        this.bankNum = value;
    }

    /**
     * Retrieves bankNum
     * 
     */
    public Object getBankNum() {
        return this.bankNum;
    }

    /**
     * Sets openingBalance
     * 
     * @param value Value to set
     */
    public void setOpeningBalance(Object value) {
        this.openingBalance = value;
    }

    /**
     * Retrieves openingBalance
     * 
     */
    public Object getOpeningBalance() {
        return this.openingBalance;
    }

    /**
     * Sets openingBalanceDate
     * 
     * @param value Value to set
     */
    public void setOpeningBalanceDate(Object value) {
        this.openingBalanceDate = value;
    }

    /**
     * Retrieves openingBalanceDate
     * 
     */
    public Object getOpeningBalanceDate() {
        return this.openingBalanceDate;
    }

    /**
     * Sets currentBalance
     * 
     * @param value Value to set
     */
    public void setCurrentBalance(Object value) {
        this.currentBalance = value;
    }

    /**
     * Retrieves currentBalance
     * 
     */
    public Object getCurrentBalance() {
        return this.currentBalance;
    }

    /**
     * Sets currentBalanceWithSubAccounts
     * 
     * @param value Value to set
     */
    public void setCurrentBalanceWithSubAccounts(Object value) {
        this.currentBalanceWithSubAccounts = value;
    }

    /**
     * Retrieves currentBalanceWithSubAccounts
     * 
     */
    public Object getCurrentBalanceWithSubAccounts() {
        return this.currentBalanceWithSubAccounts;
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
     * Sets taxAccount
     * 
     * @param value Value to set
     */
    public void setTaxAccount(Object value) {
        this.taxAccount = value;
    }

    /**
     * Retrieves taxAccount
     * 
     */
    public Object getTaxAccount() {
        return this.taxAccount;
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
     * Sets onlineBankingEnabled
     * 
     * @param value Value to set
     */
    public void setOnlineBankingEnabled(Object value) {
        this.onlineBankingEnabled = value;
    }

    /**
     * Retrieves onlineBankingEnabled
     * 
     */
    public Object getOnlineBankingEnabled() {
        return this.onlineBankingEnabled;
    }

    /**
     * Sets accountEx
     * 
     * @param value Value to set
     */
    public void setAccountEx(Object value) {
        this.accountEx = value;
    }

    /**
     * Retrieves accountEx
     * 
     */
    public Object getAccountEx() {
        return this.accountEx;
    }

}
