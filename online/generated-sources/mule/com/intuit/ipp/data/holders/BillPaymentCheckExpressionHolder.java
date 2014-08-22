
package com.intuit.ipp.data.holders;

import javax.annotation.Generated;
import com.intuit.ipp.data.CheckPayment;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.PhysicalAddress;
import com.intuit.ipp.data.PrintStatusEnum;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:35:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class BillPaymentCheckExpressionHolder {

    protected Object bankAccountRef;
    protected ReferenceType _bankAccountRefType;
    protected Object printStatus;
    protected PrintStatusEnum _printStatusType;
    protected Object checkDetail;
    protected CheckPayment _checkDetailType;
    protected Object payeeAddr;
    protected PhysicalAddress _payeeAddrType;
    protected Object billPaymentCheckEx;
    protected IntuitAnyType _billPaymentCheckExType;

    /**
     * Sets bankAccountRef
     * 
     * @param value Value to set
     */
    public void setBankAccountRef(Object value) {
        this.bankAccountRef = value;
    }

    /**
     * Retrieves bankAccountRef
     * 
     */
    public Object getBankAccountRef() {
        return this.bankAccountRef;
    }

    /**
     * Sets printStatus
     * 
     * @param value Value to set
     */
    public void setPrintStatus(Object value) {
        this.printStatus = value;
    }

    /**
     * Retrieves printStatus
     * 
     */
    public Object getPrintStatus() {
        return this.printStatus;
    }

    /**
     * Sets checkDetail
     * 
     * @param value Value to set
     */
    public void setCheckDetail(Object value) {
        this.checkDetail = value;
    }

    /**
     * Retrieves checkDetail
     * 
     */
    public Object getCheckDetail() {
        return this.checkDetail;
    }

    /**
     * Sets payeeAddr
     * 
     * @param value Value to set
     */
    public void setPayeeAddr(Object value) {
        this.payeeAddr = value;
    }

    /**
     * Retrieves payeeAddr
     * 
     */
    public Object getPayeeAddr() {
        return this.payeeAddr;
    }

    /**
     * Sets billPaymentCheckEx
     * 
     * @param value Value to set
     */
    public void setBillPaymentCheckEx(Object value) {
        this.billPaymentCheckEx = value;
    }

    /**
     * Retrieves billPaymentCheckEx
     * 
     */
    public Object getBillPaymentCheckEx() {
        return this.billPaymentCheckEx;
    }

}
