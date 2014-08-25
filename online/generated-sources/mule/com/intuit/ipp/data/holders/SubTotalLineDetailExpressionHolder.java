
package com.intuit.ipp.data.holders;

import java.util.Date;
import javax.annotation.Generated;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class SubTotalLineDetailExpressionHolder {

    protected Object itemRef;
    protected ReferenceType _itemRefType;
    protected Object serviceDate;
    protected Date _serviceDateType;

    /**
     * Sets itemRef
     * 
     * @param value Value to set
     */
    public void setItemRef(Object value) {
        this.itemRef = value;
    }

    /**
     * Retrieves itemRef
     * 
     */
    public Object getItemRef() {
        return this.itemRef;
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

}
