
package com.intuit.ipp.data.holders;

import java.util.Date;
import javax.annotation.Generated;
import com.intuit.ipp.data.DeliveryErrorTypeEnum;
import com.intuit.ipp.data.DeliveryTypeEnum;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class TransactionDeliveryInfoExpressionHolder {

    protected Object deliveryType;
    protected DeliveryTypeEnum _deliveryTypeType;
    protected Object deliveryTime;
    protected Date _deliveryTimeType;
    protected Object deliveryErrorType;
    protected DeliveryErrorTypeEnum _deliveryErrorTypeType;

    /**
     * Sets deliveryType
     * 
     * @param value Value to set
     */
    public void setDeliveryType(Object value) {
        this.deliveryType = value;
    }

    /**
     * Retrieves deliveryType
     * 
     */
    public Object getDeliveryType() {
        return this.deliveryType;
    }

    /**
     * Sets deliveryTime
     * 
     * @param value Value to set
     */
    public void setDeliveryTime(Object value) {
        this.deliveryTime = value;
    }

    /**
     * Retrieves deliveryTime
     * 
     */
    public Object getDeliveryTime() {
        return this.deliveryTime;
    }

    /**
     * Sets deliveryErrorType
     * 
     * @param value Value to set
     */
    public void setDeliveryErrorType(Object value) {
        this.deliveryErrorType = value;
    }

    /**
     * Retrieves deliveryErrorType
     * 
     */
    public Object getDeliveryErrorType() {
        return this.deliveryErrorType;
    }

}
