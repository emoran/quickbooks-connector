
package org.mule.modules.quickbooks.windows.basic;

import javax.annotation.Generated;


/**
 * This interface is implemented for every {@link org.mule.api.annotations.Module} annotated class, to dynamically query what its capabilities are.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-21T02:51:05-05:00", comments = "Build 3.4.3.1620.30ea288")
public interface Capabilities {

        /**
     * Returns true if this module implements such
     * capability
     *
     * @param capability The capability to test for
     * @return True if it does, false otherwise
     */
    boolean isCapableOf(Capability capability);
}
