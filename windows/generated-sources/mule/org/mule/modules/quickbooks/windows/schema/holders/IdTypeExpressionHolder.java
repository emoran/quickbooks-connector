
package org.mule.modules.quickbooks.windows.schema.holders;

import javax.annotation.Generated;
import org.mule.modules.quickbooks.windows.schema.IdDomainEnum;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-15T04:12:18-05:00", comments = "Build 3.4.3.1620.30ea288")
public class IdTypeExpressionHolder {

    protected Object value;
    protected String _valueType;
    protected Object idDomain;
    protected IdDomainEnum _idDomainType;

    /**
     * Sets value
     * 
     * @param value Value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Retrieves value
     * 
     */
    public Object getValue() {
        return this.value;
    }

    /**
     * Sets idDomain
     * 
     * @param value Value to set
     */
    public void setIdDomain(Object value) {
        this.idDomain = value;
    }

    /**
     * Retrieves idDomain
     * 
     */
    public Object getIdDomain() {
        return this.idDomain;
    }

}
