
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.Line;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:35:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class TxnTaxDetailExpressionHolder {

    protected Object defaultTaxCodeRef;
    protected ReferenceType _defaultTaxCodeRefType;
    protected Object txnTaxCodeRef;
    protected ReferenceType _txnTaxCodeRefType;
    protected Object totalTax;
    protected BigDecimal _totalTaxType;
    protected Object taxLine;
    protected List<Line> _taxLineType;

    /**
     * Sets defaultTaxCodeRef
     * 
     * @param value Value to set
     */
    public void setDefaultTaxCodeRef(Object value) {
        this.defaultTaxCodeRef = value;
    }

    /**
     * Retrieves defaultTaxCodeRef
     * 
     */
    public Object getDefaultTaxCodeRef() {
        return this.defaultTaxCodeRef;
    }

    /**
     * Sets txnTaxCodeRef
     * 
     * @param value Value to set
     */
    public void setTxnTaxCodeRef(Object value) {
        this.txnTaxCodeRef = value;
    }

    /**
     * Retrieves txnTaxCodeRef
     * 
     */
    public Object getTxnTaxCodeRef() {
        return this.txnTaxCodeRef;
    }

    /**
     * Sets totalTax
     * 
     * @param value Value to set
     */
    public void setTotalTax(Object value) {
        this.totalTax = value;
    }

    /**
     * Retrieves totalTax
     * 
     */
    public Object getTotalTax() {
        return this.totalTax;
    }

    /**
     * Sets taxLine
     * 
     * @param value Value to set
     */
    public void setTaxLine(Object value) {
        this.taxLine = value;
    }

    /**
     * Retrieves taxLine
     * 
     */
    public Object getTaxLine() {
        return this.taxLine;
    }

}
