
package org.mule.modules.quickbooks.online.adapters;

import javax.annotation.Generated;
import org.mule.modules.quickbooks.online.QuickBooksOnlineModule;
import org.mule.modules.quickbooks.online.basic.Capabilities;
import org.mule.modules.quickbooks.online.basic.Capability;


/**
 * A <code>QuickBooksOnlineModuleCapabilitiesAdapter</code> is a wrapper around {@link QuickBooksOnlineModule } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class QuickBooksOnlineModuleCapabilitiesAdapter
    extends QuickBooksOnlineModule
    implements Capabilities
{


    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(Capability capability) {
        if (capability == Capability.LIFECYCLE_CAPABLE) {
            return true;
        }
        return false;
    }

}
