
package org.mule.modules.quickbooks.windows.schema.holders;

import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import org.mule.modules.quickbooks.windows.schema.NgIdSet;
import org.mule.modules.quickbooks.windows.schema.OfferingId;
import org.mule.modules.quickbooks.windows.schema.SyncStatusParam;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-15T04:12:18-05:00", comments = "Build 3.4.3.1620.30ea288")
public class SyncStatusRequestExpressionHolder {

    protected Object offeringId;
    protected OfferingId _offeringIdType;
    protected Object ngIdSet;
    protected List<NgIdSet> _ngIdSetType;
    protected Object syncStatusParam;
    protected List<SyncStatusParam> _syncStatusParamType;
    protected Object requestId;
    protected List<String> _requestIdType;
    protected Object batchId;
    protected List<String> _batchIdType;
    protected Object startCreatedTMS;
    protected Date _startCreatedTMSType;
    protected Object endCreatedTMS;
    protected Date _endCreatedTMSType;
    protected Object erroredObjectsOnly;
    protected Boolean _erroredObjectsOnlyType;

    /**
     * Sets offeringId
     * 
     * @param value Value to set
     */
    public void setOfferingId(Object value) {
        this.offeringId = value;
    }

    /**
     * Retrieves offeringId
     * 
     */
    public Object getOfferingId() {
        return this.offeringId;
    }

    /**
     * Sets ngIdSet
     * 
     * @param value Value to set
     */
    public void setNgIdSet(Object value) {
        this.ngIdSet = value;
    }

    /**
     * Retrieves ngIdSet
     * 
     */
    public Object getNgIdSet() {
        return this.ngIdSet;
    }

    /**
     * Sets syncStatusParam
     * 
     * @param value Value to set
     */
    public void setSyncStatusParam(Object value) {
        this.syncStatusParam = value;
    }

    /**
     * Retrieves syncStatusParam
     * 
     */
    public Object getSyncStatusParam() {
        return this.syncStatusParam;
    }

    /**
     * Sets requestId
     * 
     * @param value Value to set
     */
    public void setRequestId(Object value) {
        this.requestId = value;
    }

    /**
     * Retrieves requestId
     * 
     */
    public Object getRequestId() {
        return this.requestId;
    }

    /**
     * Sets batchId
     * 
     * @param value Value to set
     */
    public void setBatchId(Object value) {
        this.batchId = value;
    }

    /**
     * Retrieves batchId
     * 
     */
    public Object getBatchId() {
        return this.batchId;
    }

    /**
     * Sets startCreatedTMS
     * 
     * @param value Value to set
     */
    public void setStartCreatedTMS(Object value) {
        this.startCreatedTMS = value;
    }

    /**
     * Retrieves startCreatedTMS
     * 
     */
    public Object getStartCreatedTMS() {
        return this.startCreatedTMS;
    }

    /**
     * Sets endCreatedTMS
     * 
     * @param value Value to set
     */
    public void setEndCreatedTMS(Object value) {
        this.endCreatedTMS = value;
    }

    /**
     * Retrieves endCreatedTMS
     * 
     */
    public Object getEndCreatedTMS() {
        return this.endCreatedTMS;
    }

    /**
     * Sets erroredObjectsOnly
     * 
     * @param value Value to set
     */
    public void setErroredObjectsOnly(Object value) {
        this.erroredObjectsOnly = value;
    }

    /**
     * Retrieves erroredObjectsOnly
     * 
     */
    public Object getErroredObjectsOnly() {
        return this.erroredObjectsOnly;
    }

}
