
package com.intuit.ipp.data.holders;

import javax.annotation.Generated;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T10:01:32-05:00", comments = "Build 3.4.3.1620.30ea288")
public class LinkedTxnExpressionHolder {

    protected Object txnId;
    protected String _txnIdType;
    protected Object txnType;
    protected String _txnTypeType;
    protected Object txnLineId;
    protected String _txnLineIdType;

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
     * Sets txnLineId
     * 
     * @param value Value to set
     */
    public void setTxnLineId(Object value) {
        this.txnLineId = value;
    }

    /**
     * Retrieves txnLineId
     * 
     */
    public Object getTxnLineId() {
        return this.txnLineId;
    }

}
