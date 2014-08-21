
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import javax.annotation.Generated;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-21T02:54:07-05:00", comments = "Build 3.4.3.1620.30ea288")
public class MarkupInfoExpressionHolder {

    protected Object percentBased;
    protected Boolean _percentBasedType;
    protected Object value;
    protected BigDecimal _valueType;
    protected Object percent;
    protected BigDecimal _percentType;
    protected Object priceLevelRef;
    protected ReferenceType _priceLevelRefType;

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
     * Sets value
     * 
     * @param value Value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Retrieves value
     * 
     */
    public Object getValue() {
        return this.value;
    }

    /**
     * Sets percent
     * 
     * @param value Value to set
     */
    public void setPercent(Object value) {
        this.percent = value;
    }

    /**
     * Retrieves percent
     * 
     */
    public Object getPercent() {
        return this.percent;
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

}
