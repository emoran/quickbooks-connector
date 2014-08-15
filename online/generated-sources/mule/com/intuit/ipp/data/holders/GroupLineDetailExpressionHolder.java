
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.Line;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-15T04:14:53-05:00", comments = "Build 3.4.3.1620.30ea288")
public class GroupLineDetailExpressionHolder {

    protected Object groupItemRef;
    protected ReferenceType _groupItemRefType;
    protected Object quantity;
    protected BigDecimal _quantityType;
    protected Object serviceDate;
    protected Date _serviceDateType;
    protected Object line;
    protected List<Line> _lineType;
    protected Object groupLineDetailEx;
    protected IntuitAnyType _groupLineDetailExType;

    /**
     * Sets groupItemRef
     * 
     * @param value Value to set
     */
    public void setGroupItemRef(Object value) {
        this.groupItemRef = value;
    }

    /**
     * Retrieves groupItemRef
     * 
     */
    public Object getGroupItemRef() {
        return this.groupItemRef;
    }

    /**
     * Sets quantity
     * 
     * @param value Value to set
     */
    public void setQuantity(Object value) {
        this.quantity = value;
    }

    /**
     * Retrieves quantity
     * 
     */
    public Object getQuantity() {
        return this.quantity;
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
     * Sets groupLineDetailEx
     * 
     * @param value Value to set
     */
    public void setGroupLineDetailEx(Object value) {
        this.groupLineDetailEx = value;
    }

    /**
     * Retrieves groupLineDetailEx
     * 
     */
    public Object getGroupLineDetailEx() {
        return this.groupLineDetailEx;
    }

}
