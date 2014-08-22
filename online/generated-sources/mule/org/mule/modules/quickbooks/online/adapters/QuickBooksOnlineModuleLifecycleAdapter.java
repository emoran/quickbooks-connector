
package org.mule.modules.quickbooks.online.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleException;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.mule.config.MuleManifest;
import org.mule.modules.quickbooks.online.QuickBooksOnlineModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A <code>QuickBooksOnlineModuleLifecycleAdapter</code> is a wrapper around {@link QuickBooksOnlineModule } that adds lifecycle methods to the pojo.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:35:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class QuickBooksOnlineModuleLifecycleAdapter
    extends QuickBooksOnlineModuleMetadataAdapater
    implements Disposable, Initialisable, Startable, Stoppable
{


    @Override
    public void start()
        throws MuleException
    {
    }

    @Override
    public void stop()
        throws MuleException
    {
    }

    @Override
    public void initialise()
        throws InitialisationException
    {
        Logger log = LoggerFactory.getLogger(QuickBooksOnlineModuleLifecycleAdapter.class);
        String runtimeVersion = MuleManifest.getProductVersion();
        if (runtimeVersion.equals("Unknown")) {
            log.warn("Unknown Mule runtime version. This module may not work properly!");
        } else {
            String[] expectedMinVersion = "3.2".split("\\.");
            if (runtimeVersion.contains("-")) {
                runtimeVersion = runtimeVersion.split("-")[ 0 ];
            }
            String[] currentRuntimeVersion = runtimeVersion.split("\\.");
            for (int i = 0; (i<expectedMinVersion.length); i ++) {
                try {
                    if (Integer.parseInt(currentRuntimeVersion[i])>Integer.parseInt(expectedMinVersion[i])) {
                        break;
                    }
                    if (Integer.parseInt(currentRuntimeVersion[i])<Integer.parseInt(expectedMinVersion[i])) {
                        throw new RuntimeException("This module requires at least Mule 3.2");
                    }
                } catch (NumberFormatException nfe) {
                    log.warn("Error parsing Mule version, cannot validate current Mule version");
                } catch (ArrayIndexOutOfBoundsException iobe) {
                    log.warn("Error parsing Mule version, cannot validate current Mule version");
                }
            }
        }
        super.init();
    }

    @Override
    public void dispose() {
    }

}
