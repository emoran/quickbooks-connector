
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import javax.annotation.Generated;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:35:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class ItemComponentLineExpressionHolder {

    protected Object itemRef;
    protected ReferenceType _itemRefType;
    protected Object qty;
    protected BigDecimal _qtyType;

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
     * Sets qty
     * 
     * @param value Value to set
     */
    public void setQty(Object value) {
        this.qty = value;
    }

    /**
     * Retrieves qty
     * 
     */
    public Object getQty() {
        return this.qty;
    }

}
