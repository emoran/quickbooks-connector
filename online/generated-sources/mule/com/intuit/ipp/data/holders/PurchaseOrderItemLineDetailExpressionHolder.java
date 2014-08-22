
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import javax.annotation.Generated;
import com.intuit.ipp.data.IntuitAnyType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:35:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class PurchaseOrderItemLineDetailExpressionHolder
    extends SalesItemLineDetailExpressionHolder
{

    protected Object manPartNum;
    protected String _manPartNumType;
    protected Object manuallyClosed;
    protected Boolean _manuallyClosedType;
    protected Object openQty;
    protected BigDecimal _openQtyType;
    protected Object purchaseOrderItemLineDetailEx;
    protected IntuitAnyType _purchaseOrderItemLineDetailExType;

    /**
     * Sets manPartNum
     * 
     * @param value Value to set
     */
    public void setManPartNum(Object value) {
        this.manPartNum = value;
    }

    /**
     * Retrieves manPartNum
     * 
     */
    public Object getManPartNum() {
        return this.manPartNum;
    }

    /**
     * Sets manuallyClosed
     * 
     * @param value Value to set
     */
    public void setManuallyClosed(Object value) {
        this.manuallyClosed = value;
    }

    /**
     * Retrieves manuallyClosed
     * 
     */
    public Object getManuallyClosed() {
        return this.manuallyClosed;
    }

    /**
     * Sets openQty
     * 
     * @param value Value to set
     */
    public void setOpenQty(Object value) {
        this.openQty = value;
    }

    /**
     * Retrieves openQty
     * 
     */
    public Object getOpenQty() {
        return this.openQty;
    }

    /**
     * Sets purchaseOrderItemLineDetailEx
     * 
     * @param value Value to set
     */
    public void setPurchaseOrderItemLineDetailEx(Object value) {
        this.purchaseOrderItemLineDetailEx = value;
    }

    /**
     * Retrieves purchaseOrderItemLineDetailEx
     * 
     */
    public Object getPurchaseOrderItemLineDetailEx() {
        return this.purchaseOrderItemLineDetailEx;
    }

}
