
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class TaxLineDetailExpressionHolder {

    protected Object taxRateRef;
    protected ReferenceType _taxRateRefType;
    protected Object percentBased;
    protected Boolean _percentBasedType;
    protected Object taxPercent;
    protected BigDecimal _taxPercentType;
    protected Object netAmountTaxable;
    protected BigDecimal _netAmountTaxableType;
    protected Object taxInclusiveAmount;
    protected BigDecimal _taxInclusiveAmountType;
    protected Object overrideDeltaAmount;
    protected BigDecimal _overrideDeltaAmountType;
    protected Object serviceDate;
    protected Date _serviceDateType;
    protected Object taxLineDetailEx;
    protected IntuitAnyType _taxLineDetailExType;

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
     * Sets percentBased
     * 
     * @param value Value to set
     */
    public void setPercentBased(Object value) {
        this.percentBased = value;
    }

    /**
     * Retrieves percentBased
     * 
     */
    public Object getPercentBased() {
        return this.percentBased;
    }

    /**
     * Sets taxPercent
     * 
     * @param value Value to set
     */
    public void setTaxPercent(Object value) {
        this.taxPercent = value;
    }

    /**
     * Retrieves taxPercent
     * 
     */
    public Object getTaxPercent() {
        return this.taxPercent;
    }

    /**
     * Sets netAmountTaxable
     * 
     * @param value Value to set
     */
    public void setNetAmountTaxable(Object value) {
        this.netAmountTaxable = value;
    }

    /**
     * Retrieves netAmountTaxable
     * 
     */
    public Object getNetAmountTaxable() {
        return this.netAmountTaxable;
    }

    /**
     * Sets taxInclusiveAmount
     * 
     * @param value Value to set
     */
    public void setTaxInclusiveAmount(Object value) {
        this.taxInclusiveAmount = value;
    }

    /**
     * Retrieves taxInclusiveAmount
     * 
     */
    public Object getTaxInclusiveAmount() {
        return this.taxInclusiveAmount;
    }

    /**
     * Sets overrideDeltaAmount
     * 
     * @param value Value to set
     */
    public void setOverrideDeltaAmount(Object value) {
        this.overrideDeltaAmount = value;
    }

    /**
     * Retrieves overrideDeltaAmount
     * 
     */
    public Object getOverrideDeltaAmount() {
        return this.overrideDeltaAmount;
    }

    /**
     * Sets serviceDate
     * 
     * @param value Value to set
     */
    public void setServiceDate(Object value) {
        this.serviceDate = value;
    }

    /**
     * Retrieves serviceDate
     * 
     */
    public Object getServiceDate() {
        return this.serviceDate;
    }

    /**
     * Sets taxLineDetailEx
     * 
     * @param value Value to set
     */
    public void setTaxLineDetailEx(Object value) {
        this.taxLineDetailEx = value;
    }

    /**
     * Retrieves taxLineDetailEx
     * 
     */
    public Object getTaxLineDetailEx() {
        return this.taxLineDetailEx;
    }

}
