
package org.mule.modules.quickbooks.windows.schema.holders;

import javax.annotation.Generated;
import org.mule.modules.quickbooks.windows.schema.IdSet;
import org.mule.modules.quickbooks.windows.schema.ObjectName;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:20:59-05:00", comments = "Build 3.4.3.1620.30ea288")
public class SyncStatusParamExpressionHolder {

    protected Object idSet;
    protected IdSet _idSetType;
    protected Object syncToken;
    protected String _syncTokenType;
    protected Object objectType;
    protected ObjectName _objectTypeType;
    protected Object partyId;
    protected String _partyIdType;

    /**
     * Sets idSet
     * 
     * @param value Value to set
     */
    public void setIdSet(Object value) {
        this.idSet = value;
    }

    /**
     * Retrieves idSet
     * 
     */
    public Object getIdSet() {
        return this.idSet;
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
     * Sets objectType
     * 
     * @param value Value to set
     */
    public void setObjectType(Object value) {
        this.objectType = value;
    }

    /**
     * Retrieves objectType
     * 
     */
    public Object getObjectType() {
        return this.objectType;
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
