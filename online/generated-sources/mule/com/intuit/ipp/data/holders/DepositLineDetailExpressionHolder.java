
package com.intuit.ipp.data.holders;

import javax.annotation.Generated;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.ReferenceType;
import com.intuit.ipp.data.TxnTypeEnum;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-15T04:14:53-05:00", comments = "Build 3.4.3.1620.30ea288")
public class DepositLineDetailExpressionHolder {

    protected Object entity;
    protected ReferenceType _entityType;
    protected Object classRef;
    protected ReferenceType _classRefType;
    protected Object accountRef;
    protected ReferenceType _accountRefType;
    protected Object paymentMethodRef;
    protected ReferenceType _paymentMethodRefType;
    protected Object checkNum;
    protected String _checkNumType;
    protected Object txnType;
    protected TxnTypeEnum _txnTypeType;
    protected Object depositLineDetailEx;
    protected IntuitAnyType _depositLineDetailExType;

    /**
     * Sets entity
     * 
     * @param value Value to set
     */
    public void setEntity(Object value) {
        this.entity = value;
    }

    /**
     * Retrieves entity
     * 
     */
    public Object getEntity() {
        return this.entity;
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
     * Sets checkNum
     * 
     * @param value Value to set
     */
    public void setCheckNum(Object value) {
        this.checkNum = value;
    }

    /**
     * Retrieves checkNum
     * 
     */
    public Object getCheckNum() {
        return this.checkNum;
    }

    /**
     * Sets txnType
     * 
     * @param value Value to set
     */
    public void setTxnType(Object value) {
        this.txnType = value;
    }

    /**
     * Retrieves txnType
     * 
     */
    public Object getTxnType() {
        return this.txnType;
    }

    /**
     * Sets depositLineDetailEx
     * 
     * @param value Value to set
     */
    public void setDepositLineDetailEx(Object value) {
        this.depositLineDetailEx = value;
    }

    /**
     * Retrieves depositLineDetailEx
     * 
     */
    public Object getDepositLineDetailEx() {
        return this.depositLineDetailEx;
    }

}
