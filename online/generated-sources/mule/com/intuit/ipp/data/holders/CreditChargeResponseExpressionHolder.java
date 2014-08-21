
package com.intuit.ipp.data.holders;

import java.util.Date;
import javax.annotation.Generated;
import com.intuit.ipp.data.CCAVSMatchEnum;
import com.intuit.ipp.data.CCPaymentStatusEnum;
import com.intuit.ipp.data.CCSecurityCodeMatchEnum;
import com.intuit.ipp.data.IntuitAnyType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-21T02:54:07-05:00", comments = "Build 3.4.3.1620.30ea288")
public class CreditChargeResponseExpressionHolder {

    protected Object status;
    protected CCPaymentStatusEnum _statusType;
    protected Object resultCode;
    protected Integer _resultCodeType;
    protected Object resultMsg;
    protected String _resultMsgType;
    protected Object merchantAcctNum;
    protected String _merchantAcctNumType;
    protected Object cardSecurityCodeMatch;
    protected CCSecurityCodeMatchEnum _cardSecurityCodeMatchType;
    protected Object authCode;
    protected String _authCodeType;
    protected Object avsStreet;
    protected CCAVSMatchEnum _avsStreetType;
    protected Object avsZip;
    protected CCAVSMatchEnum _avsZipType;
    protected Object securityCode;
    protected String _securityCodeType;
    protected Object reconBatchId;
    protected String _reconBatchIdType;
    protected Object paymentGroupingCode;
    protected Integer _paymentGroupingCodeType;
    protected Object txnAuthorizationTime;
    protected Date _txnAuthorizationTimeType;
    protected Object txnAuthorizationStamp;
    protected Integer _txnAuthorizationStampType;
    protected Object clientTransID;
    protected String _clientTransIDType;
    protected Object creditChargeResponseEx;
    protected IntuitAnyType _creditChargeResponseExType;

    /**
     * Sets status
     * 
     * @param value Value to set
     */
    public void setStatus(Object value) {
        this.status = value;
    }

    /**
     * Retrieves status
     * 
     */
    public Object getStatus() {
        return this.status;
    }

    /**
     * Sets resultCode
     * 
     * @param value Value to set
     */
    public void setResultCode(Object value) {
        this.resultCode = value;
    }

    /**
     * Retrieves resultCode
     * 
     */
    public Object getResultCode() {
        return this.resultCode;
    }

    /**
     * Sets resultMsg
     * 
     * @param value Value to set
     */
    public void setResultMsg(Object value) {
        this.resultMsg = value;
    }

    /**
     * Retrieves resultMsg
     * 
     */
    public Object getResultMsg() {
        return this.resultMsg;
    }

    /**
     * Sets merchantAcctNum
     * 
     * @param value Value to set
     */
    public void setMerchantAcctNum(Object value) {
        this.merchantAcctNum = value;
    }

    /**
     * Retrieves merchantAcctNum
     * 
     */
    public Object getMerchantAcctNum() {
        return this.merchantAcctNum;
    }

    /**
     * Sets cardSecurityCodeMatch
     * 
     * @param value Value to set
     */
    public void setCardSecurityCodeMatch(Object value) {
        this.cardSecurityCodeMatch = value;
    }

    /**
     * Retrieves cardSecurityCodeMatch
     * 
     */
    public Object getCardSecurityCodeMatch() {
        return this.cardSecurityCodeMatch;
    }

    /**
     * Sets authCode
     * 
     * @param value Value to set
     */
    public void setAuthCode(Object value) {
        this.authCode = value;
    }

    /**
     * Retrieves authCode
     * 
     */
    public Object getAuthCode() {
        return this.authCode;
    }

    /**
     * Sets avsStreet
     * 
     * @param value Value to set
     */
    public void setAvsStreet(Object value) {
        this.avsStreet = value;
    }

    /**
     * Retrieves avsStreet
     * 
     */
    public Object getAvsStreet() {
        return this.avsStreet;
    }

    /**
     * Sets avsZip
     * 
     * @param value Value to set
     */
    public void setAvsZip(Object value) {
        this.avsZip = value;
    }

    /**
     * Retrieves avsZip
     * 
     */
    public Object getAvsZip() {
        return this.avsZip;
    }

    /**
     * Sets securityCode
     * 
     * @param value Value to set
     */
    public void setSecurityCode(Object value) {
        this.securityCode = value;
    }

    /**
     * Retrieves securityCode
     * 
     */
    public Object getSecurityCode() {
        return this.securityCode;
    }

    /**
     * Sets reconBatchId
     * 
     * @param value Value to set
     */
    public void setReconBatchId(Object value) {
        this.reconBatchId = value;
    }

    /**
     * Retrieves reconBatchId
     * 
     */
    public Object getReconBatchId() {
        return this.reconBatchId;
    }

    /**
     * Sets paymentGroupingCode
     * 
     * @param value Value to set
     */
    public void setPaymentGroupingCode(Object value) {
        this.paymentGroupingCode = value;
    }

    /**
     * Retrieves paymentGroupingCode
     * 
     */
    public Object getPaymentGroupingCode() {
        return this.paymentGroupingCode;
    }

    /**
     * Sets txnAuthorizationTime
     * 
     * @param value Value to set
     */
    public void setTxnAuthorizationTime(Object value) {
        this.txnAuthorizationTime = value;
    }

    /**
     * Retrieves txnAuthorizationTime
     * 
     */
    public Object getTxnAuthorizationTime() {
        return this.txnAuthorizationTime;
    }

    /**
     * Sets txnAuthorizationStamp
     * 
     * @param value Value to set
     */
    public void setTxnAuthorizationStamp(Object value) {
        this.txnAuthorizationStamp = value;
    }

    /**
     * Retrieves txnAuthorizationStamp
     * 
     */
    public Object getTxnAuthorizationStamp() {
        return this.txnAuthorizationStamp;
    }

    /**
     * Sets clientTransID
     * 
     * @param value Value to set
     */
    public void setClientTransID(Object value) {
        this.clientTransID = value;
    }

    /**
     * Retrieves clientTransID
     * 
     */
    public Object getClientTransID() {
        return this.clientTransID;
    }

    /**
     * Sets creditChargeResponseEx
     * 
     * @param value Value to set
     */
    public void setCreditChargeResponseEx(Object value) {
        this.creditChargeResponseEx = value;
    }

    /**
     * Retrieves creditChargeResponseEx
     * 
     */
    public Object getCreditChargeResponseEx() {
        return this.creditChargeResponseEx;
    }

}
