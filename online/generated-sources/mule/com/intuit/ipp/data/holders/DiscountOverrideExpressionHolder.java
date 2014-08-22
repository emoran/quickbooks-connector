
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import javax.annotation.Generated;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T10:01:32-05:00", comments = "Build 3.4.3.1620.30ea288")
public class DiscountOverrideExpressionHolder {

    protected Object discountRef;
    protected ReferenceType _discountRefType;
    protected Object percentBased;
    protected Boolean _percentBasedType;
    protected Object discountPercent;
    protected BigDecimal _discountPercentType;
    protected Object discountAccountRef;
    protected ReferenceType _discountAccountRefType;

    /**
     * Sets discountRef
     * 
     * @param value Value to set
     */
    public void setDiscountRef(Object value) {
        this.discountRef = value;
    }

    /**
     * Retrieves discountRef
     * 
     */
    public Object getDiscountRef() {
        return this.discountRef;
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
     * Sets discountPercent
     * 
     * @param value Value to set
     */
    public void setDiscountPercent(Object value) {
        this.discountPercent = value;
    }

    /**
     * Retrieves discountPercent
     * 
     */
    public Object getDiscountPercent() {
        return this.discountPercent;
    }

    /**
     * Sets discountAccountRef
     * 
     * @param value Value to set
     */
    public void setDiscountAccountRef(Object value) {
        this.discountAccountRef = value;
    }

    /**
     * Retrieves discountAccountRef
     * 
     */
    public Object getDiscountAccountRef() {
        return this.discountAccountRef;
    }

}
