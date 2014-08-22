
package com.intuit.ipp.data.holders;

import java.util.Date;
import javax.annotation.Generated;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T10:01:32-05:00", comments = "Build 3.4.3.1620.30ea288")
public class DiscountLineDetailExpressionHolder
    extends DiscountOverrideExpressionHolder
{

    protected Object serviceDate;
    protected Date _serviceDateType;
    protected Object classRef;
    protected ReferenceType _classRefType;
    protected Object taxCodeRef;
    protected ReferenceType _taxCodeRefType;
    protected Object discountLineDetailEx;
    protected IntuitAnyType _discountLineDetailExType;

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
     * Sets discountLineDetailEx
     * 
     * @param value Value to set
     */
    public void setDiscountLineDetailEx(Object value) {
        this.discountLineDetailEx = value;
    }

    /**
     * Retrieves discountLineDetailEx
     * 
     */
    public Object getDiscountLineDetailEx() {
        return this.discountLineDetailEx;
    }

}
