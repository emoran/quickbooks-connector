
package com.intuit.ipp.data.holders;

import javax.annotation.Generated;
import com.intuit.ipp.data.EntityTypeEnum;
import com.intuit.ipp.data.ReferenceType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:35:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class EntityTypeRefExpressionHolder {

    protected Object type;
    protected EntityTypeEnum _typeType;
    protected Object entityRef;
    protected ReferenceType _entityRefType;

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

}
