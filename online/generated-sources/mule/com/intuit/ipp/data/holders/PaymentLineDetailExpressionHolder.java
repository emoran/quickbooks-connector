
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import com.intuit.ipp.data.DiscountOverride;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-15T04:14:53-05:00", comments = "Build 3.4.3.1620.30ea288")
public class PaymentLineDetailExpressionHolder {

    protected Object itemRef;
    protected ReferenceType _itemRefType;
    protected Object serviceDate;
    protected Date _serviceDateType;
    protected Object classRef;
    protected ReferenceType _classRefType;
    protected Object balance;
    protected BigDecimal _balanceType;
    protected Object discount;
    protected DiscountOverride _discountType;
    protected Object paymentLineEx;
    protected IntuitAnyType _paymentLineExType;

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

    /**
     * Sets classRef
     * 
     * @param value Value to set
     */
    public void setClassRef(Object value) {
        this.classRef = value;
    }

    /**
     * Retrieves classRef
     * 
     */
    public Object getClassRef() {
        return this.classRef;
    }

    /**
     * Sets balance
     * 
     * @param value Value to set
     */
    public void setBalance(Object value) {
        this.balance = value;
    }

    /**
     * Retrieves balance
     * 
     */
    public Object getBalance() {
        return this.balance;
    }

    /**
     * Sets discount
     * 
     * @param value Value to set
     */
    public void setDiscount(Object value) {
        this.discount = value;
    }

    /**
     * Retrieves discount
     * 
     */
    public Object getDiscount() {
        return this.discount;
    }

    /**
     * Sets paymentLineEx
     * 
     * @param value Value to set
     */
    public void setPaymentLineEx(Object value) {
        this.paymentLineEx = value;
    }

    /**
     * Retrieves paymentLineEx
     * 
     */
    public Object getPaymentLineEx() {
        return this.paymentLineEx;
    }

}
