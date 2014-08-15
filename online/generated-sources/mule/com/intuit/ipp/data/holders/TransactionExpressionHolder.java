
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.Line;
import com.intuit.ipp.data.LinkedTxn;
import com.intuit.ipp.data.ReferenceType;
import com.intuit.ipp.data.TxnTaxDetail;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-15T04:14:53-05:00", comments = "Build 3.4.3.1620.30ea288")
public class TransactionExpressionHolder
    extends IntuitEntityExpressionHolder
{

    protected Object docNumber;
    protected String _docNumberType;
    protected Object txnDate;
    protected Date _txnDateType;
    protected Object departmentRef;
    protected ReferenceType _departmentRefType;
    protected Object currencyRef;
    protected ReferenceType _currencyRefType;
    protected Object exchangeRate;
    protected BigDecimal _exchangeRateType;
    protected Object privateNote;
    protected String _privateNoteType;
    protected Object txnStatus;
    protected String _txnStatusType;
    protected Object linkedTxn;
    protected List<LinkedTxn> _linkedTxnType;
    protected Object line;
    protected List<Line> _lineType;
    protected Object txnTaxDetail;
    protected TxnTaxDetail _txnTaxDetailType;
    protected Object txnSource;
    protected String _txnSourceType;

    /**
     * Sets docNumber
     * 
     * @param value Value to set
     */
    public void setDocNumber(Object value) {
        this.docNumber = value;
    }

    /**
     * Retrieves docNumber
     * 
     */
    public Object getDocNumber() {
        return this.docNumber;
    }

    /**
     * Sets txnDate
     * 
     * @param value Value to set
     */
    public void setTxnDate(Object value) {
        this.txnDate = value;
    }

    /**
     * Retrieves txnDate
     * 
     */
    public Object getTxnDate() {
        return this.txnDate;
    }

    /**
     * Sets departmentRef
     * 
     * @param value Value to set
     */
    public void setDepartmentRef(Object value) {
        this.departmentRef = value;
    }

    /**
     * Retrieves departmentRef
     * 
     */
    public Object getDepartmentRef() {
        return this.departmentRef;
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
     * Sets exchangeRate
     * 
     * @param value Value to set
     */
    public void setExchangeRate(Object value) {
        this.exchangeRate = value;
    }

    /**
     * Retrieves exchangeRate
     * 
     */
    public Object getExchangeRate() {
        return this.exchangeRate;
    }

    /**
     * Sets privateNote
     * 
     * @param value Value to set
     */
    public void setPrivateNote(Object value) {
        this.privateNote = value;
    }

    /**
     * Retrieves privateNote
     * 
     */
    public Object getPrivateNote() {
        return this.privateNote;
    }

    /**
     * Sets txnStatus
     * 
     * @param value Value to set
     */
    public void setTxnStatus(Object value) {
        this.txnStatus = value;
    }

    /**
     * Retrieves txnStatus
     * 
     */
    public Object getTxnStatus() {
        return this.txnStatus;
    }

    /**
     * Sets linkedTxn
     * 
     * @param value Value to set
     */
    public void setLinkedTxn(Object value) {
        this.linkedTxn = value;
    }

    /**
     * Retrieves linkedTxn
     * 
     */
    public Object getLinkedTxn() {
        return this.linkedTxn;
    }

    /**
     * Sets line
     * 
     * @param value Value to set
     */
    public void setLine(Object value) {
        this.line = value;
    }

    /**
     * Retrieves line
     * 
     */
    public Object getLine() {
        return this.line;
    }

    /**
     * Sets txnTaxDetail
     * 
     * @param value Value to set
     */
    public void setTxnTaxDetail(Object value) {
        this.txnTaxDetail = value;
    }

    /**
     * Retrieves txnTaxDetail
     * 
     */
    public Object getTxnTaxDetail() {
        return this.txnTaxDetail;
    }

    /**
     * Sets txnSource
     * 
     * @param value Value to set
     */
    public void setTxnSource(Object value) {
        this.txnSource = value;
    }

    /**
     * Retrieves txnSource
     * 
     */
    public Object getTxnSource() {
        return this.txnSource;
    }

}
