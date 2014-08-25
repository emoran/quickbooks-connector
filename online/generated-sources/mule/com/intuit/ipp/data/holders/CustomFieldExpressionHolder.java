
package com.intuit.ipp.data.holders;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import com.intuit.ipp.data.CustomFieldTypeEnum;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class CustomFieldExpressionHolder {

    protected Object definitionId;
    protected String _definitionIdType;
    protected Object name;
    protected String _nameType;
    protected Object type;
    protected CustomFieldTypeEnum _typeType;
    protected Object stringValue;
    protected String _stringValueType;
    protected Object booleanValue;
    protected Boolean _booleanValueType;
    protected Object dateValue;
    protected Date _dateValueType;
    protected Object numberValue;
    protected BigDecimal _numberValueType;

    /**
     * Sets definitionId
     * 
     * @param value Value to set
     */
    public void setDefinitionId(Object value) {
        this.definitionId = value;
    }

    /**
     * Retrieves definitionId
     * 
     */
    public Object getDefinitionId() {
        return this.definitionId;
    }

    /**
     * Sets name
     * 
     * @param value Value to set
     */
    public void setName(Object value) {
        this.name = value;
    }

    /**
     * Retrieves name
     * 
     */
    public Object getName() {
        return this.name;
    }

    /**
     * Sets type
     * 
     * @param value Value to set
     */
    public void setType(Object value) {
        this.type = value;
    }

    /**
     * Retrieves type
     * 
     */
    public Object getType() {
        return this.type;
    }

    /**
     * Sets stringValue
     * 
     * @param value Value to set
     */
    public void setStringValue(Object value) {
        this.stringValue = value;
    }

    /**
     * Retrieves stringValue
     * 
     */
    public Object getStringValue() {
        return this.stringValue;
    }

    /**
     * Sets booleanValue
     * 
     * @param value Value to set
     */
    public void setBooleanValue(Object value) {
        this.booleanValue = value;
    }

    /**
     * Retrieves booleanValue
     * 
     */
    public Object getBooleanValue() {
        return this.booleanValue;
    }

    /**
     * Sets dateValue
     * 
     * @param value Value to set
     */
    public void setDateValue(Object value) {
        this.dateValue = value;
    }

    /**
     * Retrieves dateValue
     * 
     */
    public Object getDateValue() {
        return this.dateValue;
    }

    /**
     * Sets numberValue
     * 
     * @param value Value to set
     */
    public void setNumberValue(Object value) {
        this.numberValue = value;
    }

    /**
     * Retrieves numberValue
     * 
     */
    public Object getNumberValue() {
        return this.numberValue;
    }

}
