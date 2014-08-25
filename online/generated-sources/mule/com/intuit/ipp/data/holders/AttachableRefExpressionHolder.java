
package com.intuit.ipp.data.holders;

import java.util.List;
import javax.annotation.Generated;
import com.intuit.ipp.data.CustomField;
import com.intuit.ipp.data.IntuitAnyType;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class AttachableRefExpressionHolder {

    protected Object entityRef;
    protected ReferenceType _entityRefType;
    protected Object lineInfo;
    protected String _lineInfoType;
    protected Object includeOnSend;
    protected Boolean _includeOnSendType;
    protected Object customField;
    protected List<CustomField> _customFieldType;
    protected Object attachableRefEx;
    protected IntuitAnyType _attachableRefExType;

    /**
     * Sets entityRef
     * 
     * @param value Value to set
     */
    public void setEntityRef(Object value) {
        this.entityRef = value;
    }

    /**
     * Retrieves entityRef
     * 
     */
    public Object getEntityRef() {
        return this.entityRef;
    }

    /**
     * Sets lineInfo
     * 
     * @param value Value to set
     */
    public void setLineInfo(Object value) {
        this.lineInfo = value;
    }

    /**
     * Retrieves lineInfo
     * 
     */
    public Object getLineInfo() {
        return this.lineInfo;
    }

    /**
     * Sets includeOnSend
     * 
     * @param value Value to set
     */
    public void setIncludeOnSend(Object value) {
        this.includeOnSend = value;
    }

    /**
     * Retrieves includeOnSend
     * 
     */
    public Object getIncludeOnSend() {
        return this.includeOnSend;
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
     * Sets attachableRefEx
     * 
     * @param value Value to set
     */
    public void setAttachableRefEx(Object value) {
        this.attachableRefEx = value;
    }

    /**
     * Retrieves attachableRefEx
     * 
     */
    public Object getAttachableRefEx() {
        return this.attachableRefEx;
    }

}
