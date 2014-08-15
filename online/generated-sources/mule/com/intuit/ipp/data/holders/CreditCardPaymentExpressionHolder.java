
package com.intuit.ipp.data.holders;

import javax.annotation.Generated;
import com.intuit.ipp.data.CreditChargeInfo;
import com.intuit.ipp.data.CreditChargeResponse;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-15T04:14:53-05:00", comments = "Build 3.4.3.1620.30ea288")
public class CreditCardPaymentExpressionHolder {

    protected Object creditChargeInfo;
    protected CreditChargeInfo _creditChargeInfoType;
    protected Object creditChargeResponse;
    protected CreditChargeResponse _creditChargeResponseType;

    /**
     * Sets creditChargeInfo
     * 
     * @param value Value to set
     */
    public void setCreditChargeInfo(Object value) {
        this.creditChargeInfo = value;
    }

    /**
     * Retrieves creditChargeInfo
     * 
     */
    public Object getCreditChargeInfo() {
        return this.creditChargeInfo;
    }

    /**
     * Sets creditChargeResponse
     * 
     * @param value Value to set
     */
    public void setCreditChargeResponse(Object value) {
        this.creditChargeResponse = value;
    }

    /**
     * Retrieves creditChargeResponse
     * 
     */
    public Object getCreditChargeResponse() {
        return this.creditChargeResponse;
    }

}
