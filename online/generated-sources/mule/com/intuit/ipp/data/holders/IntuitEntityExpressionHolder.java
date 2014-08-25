
package com.intuit.ipp.data.holders;

import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.AttachableRef;
import com.intuit.ipp.data.CustomField;
import com.intuit.ipp.data.EntityStatusEnum;
import com.intuit.ipp.data.ModificationMetaData;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class IntuitEntityExpressionHolder {

    protected Object id;
    protected String _idType;
    protected Object syncToken;
    protected String _syncTokenType;
    protected Object metaData;
    protected ModificationMetaData _metaDataType;
    protected Object customField;
    protected List<CustomField> _customFieldType;
    protected Object attachableRef;
    protected List<AttachableRef> _attachableRefType;
    protected Object domain;
    protected String _domainType;
    protected Object status;
    protected EntityStatusEnum _statusType;
    protected Object sparse;
    protected Boolean _sparseType;

    /**
     * Sets id
     * 
     * @param value Value to set
     */
    public void setId(Object value) {
        this.id = value;
    }

    /**
     * Retrieves id
     * 
     */
    public Object getId() {
        return this.id;
    }

    /**
     * Sets syncToken
     * 
     * @param value Value to set
     */
    public void setSyncToken(Object value) {
        this.syncToken = value;
    }

    /**
     * Retrieves syncToken
     * 
     */
    public Object getSyncToken() {
        return this.syncToken;
    }

    /**
     * Sets metaData
     * 
     * @param value Value to set
     */
    public void setMetaData(Object value) {
        this.metaData = value;
    }

    /**
     * Retrieves metaData
     * 
     */
    public Object getMetaData() {
        return this.metaData;
    }

    /**
     * Sets customField
     * 
     * @param value Value to set
     */
    public void setCustomField(Object value) {
        this.customField = value;
    }

    /**
     * Retrieves customField
     * 
     */
    public Object getCustomField() {
        return this.customField;
    }

    /**
     * Sets attachableRef
     * 
     * @param value Value to set
     */
    public void setAttachableRef(Object value) {
        this.attachableRef = value;
    }

    /**
     * Retrieves attachableRef
     * 
     */
    public Object getAttachableRef() {
        return this.attachableRef;
    }

    /**
     * Sets domain
     * 
     * @param value Value to set
     */
    public void setDomain(Object value) {
        this.domain = value;
    }

    /**
     * Retrieves domain
     * 
     */
    public Object getDomain() {
        return this.domain;
    }

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
     * Sets sparse
     * 
     * @param value Value to set
     */
    public void setSparse(Object value) {
        this.sparse = value;
    }

    /**
     * Retrieves sparse
     * 
     */
    public Object getSparse() {
        return this.sparse;
    }

}
