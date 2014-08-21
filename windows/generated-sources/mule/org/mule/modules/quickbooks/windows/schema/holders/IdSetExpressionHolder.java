
package org.mule.modules.quickbooks.windows.schema.holders;

import java.util.List;
import javax.annotation.Generated;
import org.mule.modules.quickbooks.windows.schema.IdType;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-21T02:51:05-05:00", comments = "Build 3.4.3.1620.30ea288")
public class IdSetExpressionHolder {

    protected Object id;
    protected List<IdType> _idType;

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

}
