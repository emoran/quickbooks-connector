
package org.mule.modules.quickbooks.windows.adapters;

import javax.annotation.Generated;
import org.mule.modules.quickbooks.windows.QuickBooksWindowsModule;
import org.mule.modules.quickbooks.windows.basic.Capabilities;
import org.mule.modules.quickbooks.windows.basic.Capability;


/**
 * A <code>QuickBooksWindowsModuleCapabilitiesAdapter</code> is a wrapper around {@link QuickBooksWindowsModule } that implements {@link org.mule.api.Capabilities} interface.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:33:09-05:00", comments = "Build 3.4.3.1620.30ea288")
public class QuickBooksWindowsModuleCapabilitiesAdapter
    extends QuickBooksWindowsModule
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
