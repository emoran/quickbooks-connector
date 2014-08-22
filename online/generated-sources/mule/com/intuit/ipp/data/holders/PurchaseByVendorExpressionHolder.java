
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import javax.annotation.Generated;
import com.intuit.ipp.data.EmailAddress;
import com.intuit.ipp.data.GlobalTaxCalculationEnum;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T10:01:32-05:00", comments = "Build 3.4.3.1620.30ea288")
public class PurchaseByVendorExpressionHolder
    extends TransactionExpressionHolder
{

    protected Object vendorRef;
    protected ReferenceType _vendorRefType;
    protected Object totalAmt;
    protected BigDecimal _totalAmtType;
    protected Object billEmail;
    protected EmailAddress _billEmailType;
    protected Object replyEmail;
    protected EmailAddress _replyEmailType;
    protected Object memo;
    protected String _memoType;
    protected Object globalTaxCalculation;
    protected GlobalTaxCalculationEnum _globalTaxCalculationType;

    /**
     * Sets vendorRef
     * 
     * @param value Value to set
     */
    public void setVendorRef(Object value) {
        this.vendorRef = value;
    }

    /**
     * Retrieves vendorRef
     * 
     */
    public Object getVendorRef() {
        return this.vendorRef;
    }

    /**
     * Sets totalAmt
     * 
     * @param value Value to set
     */
    public void setTotalAmt(Object value) {
        this.totalAmt = value;
    }

    /**
     * Retrieves totalAmt
     * 
     */
    public Object getTotalAmt() {
        return this.totalAmt;
    }

    /**
     * Sets billEmail
     * 
     * @param value Value to set
     */
    public void setBillEmail(Object value) {
        this.billEmail = value;
    }

    /**
     * Retrieves billEmail
     * 
     */
    public Object getBillEmail() {
        return this.billEmail;
    }

    /**
     * Sets replyEmail
     * 
     * @param value Value to set
     */
    public void setReplyEmail(Object value) {
        this.replyEmail = value;
    }

    /**
     * Retrieves replyEmail
     * 
     */
    public Object getReplyEmail() {
        return this.replyEmail;
    }

    /**
     * Sets memo
     * 
     * @param value Value to set
     */
    public void setMemo(Object value) {
        this.memo = value;
    }

    /**
     * Retrieves memo
     * 
     */
    public Object getMemo() {
        return this.memo;
    }

    /**
     * Sets globalTaxCalculation
     * 
     * @param value Value to set
     */
    public void setGlobalTaxCalculation(Object value) {
        this.globalTaxCalculation = value;
    }

    /**
     * Retrieves globalTaxCalculation
     * 
     */
    public Object getGlobalTaxCalculation() {
        return this.globalTaxCalculation;
    }

}
