
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import com.intuit.ipp.data.IntuitAnyType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class SalesItemLineDetailExpressionHolder
    extends ItemLineDetailExpressionHolder
{

    protected Object serviceDate;
    protected Date _serviceDateType;
    protected Object taxInclusiveAmt;
    protected BigDecimal _taxInclusiveAmtType;
    protected Object salesItemLineDetailEx;
    protected IntuitAnyType _salesItemLineDetailExType;

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
     * Sets taxInclusiveAmt
     * 
     * @param value Value to set
     */
    public void setTaxInclusiveAmt(Object value) {
        this.taxInclusiveAmt = value;
    }

    /**
     * Retrieves taxInclusiveAmt
     * 
     */
    public Object getTaxInclusiveAmt() {
        return this.taxInclusiveAmt;
    }

    /**
     * Sets salesItemLineDetailEx
     * 
     * @param value Value to set
     */
    public void setSalesItemLineDetailEx(Object value) {
        this.salesItemLineDetailEx = value;
    }

    /**
     * Retrieves salesItemLineDetailEx
     * 
     */
    public Object getSalesItemLineDetailEx() {
        return this.salesItemLineDetailEx;
    }

}
