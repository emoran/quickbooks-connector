
package com.intuit.ipp.data.holders;

import javax.annotation.Generated;
import com.intuit.ipp.data.IntuitAnyType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T10:01:32-05:00", comments = "Build 3.4.3.1620.30ea288")
public class PaymentMethodExpressionHolder
    extends IntuitEntityExpressionHolder
{

    protected Object name;
    protected String _nameType;
    protected Object active;
    protected Boolean _activeType;
    protected Object type;
    protected String _typeType;
    protected Object paymentMethodEx;
    protected IntuitAnyType _paymentMethodExType;

    /**
     * Sets name
     * 
     * @param value Value to set
     */
    public void setName(Object value) {
        this.name = value;
    }

    /**
     * Retrieves name
     * 
     */
    public Object getName() {
        return this.name;
    }

    /**
     * Sets active
     * 
     * @param value Value to set
     */
    public void setActive(Object value) {
        this.active = value;
    }

    /**
     * Retrieves active
     * 
     */
    public Object getActive() {
        return this.active;
    }

    /**
     * Sets type
     * 
     * @param value Value to set
     */
    public void setType(Object value) {
        this.type = value;
    }

    /**
     * Retrieves type
     * 
     */
    public Object getType() {
        return this.type;
    }

    /**
     * Sets paymentMethodEx
     * 
     * @param value Value to set
     */
    public void setPaymentMethodEx(Object value) {
        this.paymentMethodEx = value;
    }

    /**
     * Retrieves paymentMethodEx
     * 
     */
    public Object getPaymentMethodEx() {
        return this.paymentMethodEx;
    }

}
