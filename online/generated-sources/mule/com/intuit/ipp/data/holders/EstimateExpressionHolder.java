
package com.intuit.ipp.data.holders;

import java.util.Date;
import javax.annotation.Generated;
import com.intuit.ipp.data.IntuitAnyType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:35:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class EstimateExpressionHolder
    extends SalesTransactionExpressionHolder
{

    protected Object expirationDate;
    protected Date _expirationDateType;
    protected Object acceptedBy;
    protected String _acceptedByType;
    protected Object acceptedDate;
    protected Date _acceptedDateType;
    protected Object estimateEx;
    protected IntuitAnyType _estimateExType;

    /**
     * Sets expirationDate
     * 
     * @param value Value to set
     */
    public void setExpirationDate(Object value) {
        this.expirationDate = value;
    }

    /**
     * Retrieves expirationDate
     * 
     */
    public Object getExpirationDate() {
        return this.expirationDate;
    }

    /**
     * Sets acceptedBy
     * 
     * @param value Value to set
     */
    public void setAcceptedBy(Object value) {
        this.acceptedBy = value;
    }

    /**
     * Retrieves acceptedBy
     * 
     */
    public Object getAcceptedBy() {
        return this.acceptedBy;
    }

    /**
     * Sets acceptedDate
     * 
     * @param value Value to set
     */
    public void setAcceptedDate(Object value) {
        this.acceptedDate = value;
    }

    /**
     * Retrieves acceptedDate
     * 
     */
    public Object getAcceptedDate() {
        return this.acceptedDate;
    }

    /**
     * Sets estimateEx
     * 
     * @param value Value to set
     */
    public void setEstimateEx(Object value) {
        this.estimateEx = value;
    }

    /**
     * Retrieves estimateEx
     * 
     */
    public Object getEstimateEx() {
        return this.estimateEx;
    }

}
