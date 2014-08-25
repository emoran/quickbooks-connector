
package com.intuit.ipp.data.holders;

import java.util.Date;
import javax.annotation.Generated;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class DescriptionLineDetailExpressionHolder {

    protected Object serviceDate;
    protected Date _serviceDateType;
    protected Object taxCodeRef;
    protected ReferenceType _taxCodeRefType;
    protected Object descriptionLineDetailEx;
    protected IntuitAnyType _descriptionLineDetailExType;

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
     * Sets descriptionLineDetailEx
     * 
     * @param value Value to set
     */
    public void setDescriptionLineDetailEx(Object value) {
        this.descriptionLineDetailEx = value;
    }

    /**
     * Retrieves descriptionLineDetailEx
     * 
     */
    public Object getDescriptionLineDetailEx() {
        return this.descriptionLineDetailEx;
    }

}
