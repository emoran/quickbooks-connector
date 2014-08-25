
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import javax.annotation.Generated;
import com.intuit.ipp.data.IntuitAnyType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class JournalEntryExpressionHolder
    extends TransactionExpressionHolder
{

    protected Object adjustment;
    protected Boolean _adjustmentType;
    protected Object homeCurrencyAdjustment;
    protected Boolean _homeCurrencyAdjustmentType;
    protected Object enteredInHomeCurrency;
    protected Boolean _enteredInHomeCurrencyType;
    protected Object totalAmt;
    protected BigDecimal _totalAmtType;
    protected Object homeTotalAmt;
    protected BigDecimal _homeTotalAmtType;
    protected Object journalEntryEx;
    protected IntuitAnyType _journalEntryExType;

    /**
     * Sets adjustment
     * 
     * @param value Value to set
     */
    public void setAdjustment(Object value) {
        this.adjustment = value;
    }

    /**
     * Retrieves adjustment
     * 
     */
    public Object getAdjustment() {
        return this.adjustment;
    }

    /**
     * Sets homeCurrencyAdjustment
     * 
     * @param value Value to set
     */
    public void setHomeCurrencyAdjustment(Object value) {
        this.homeCurrencyAdjustment = value;
    }

    /**
     * Retrieves homeCurrencyAdjustment
     * 
     */
    public Object getHomeCurrencyAdjustment() {
        return this.homeCurrencyAdjustment;
    }

    /**
     * Sets enteredInHomeCurrency
     * 
     * @param value Value to set
     */
    public void setEnteredInHomeCurrency(Object value) {
        this.enteredInHomeCurrency = value;
    }

    /**
     * Retrieves enteredInHomeCurrency
     * 
     */
    public Object getEnteredInHomeCurrency() {
        return this.enteredInHomeCurrency;
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
     * Sets journalEntryEx
     * 
     * @param value Value to set
     */
    public void setJournalEntryEx(Object value) {
        this.journalEntryEx = value;
    }

    /**
     * Retrieves journalEntryEx
     * 
     */
    public Object getJournalEntryEx() {
        return this.journalEntryEx;
    }

}
