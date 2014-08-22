
package org.mule.modules.quickbooks.windows.schema.holders;

import javax.annotation.Generated;
import org.mule.modules.quickbooks.windows.schema.ObjectName;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:33:09-05:00", comments = "Build 3.4.3.1620.30ea288")
public class NgIdSetExpressionHolder {

    protected Object ngId;
    protected String _ngIdType;
    protected Object syncToken;
    protected String _syncTokenType;
    protected Object ngObjectType;
    protected ObjectName _ngObjectTypeType;
    protected Object partyId;
    protected String _partyIdType;

    /**
     * Sets ngId
     * 
     * @param value Value to set
     */
    public void setNgId(Object value) {
        this.ngId = value;
    }

    /**
     * Retrieves ngId
     * 
     */
    public Object getNgId() {
        return this.ngId;
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
     * Sets ngObjectType
     * 
     * @param value Value to set
     */
    public void setNgObjectType(Object value) {
        this.ngObjectType = value;
    }

    /**
     * Retrieves ngObjectType
     * 
     */
    public Object getNgObjectType() {
        return this.ngObjectType;
    }

    /**
     * Sets partyId
     * 
     * @param value Value to set
     */
    public void setPartyId(Object value) {
        this.partyId = value;
    }

    /**
     * Retrieves partyId
     * 
     */
    public Object getPartyId() {
        return this.partyId;
    }

}
