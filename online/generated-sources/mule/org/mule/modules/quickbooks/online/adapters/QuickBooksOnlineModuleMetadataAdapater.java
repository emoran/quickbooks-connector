
package org.mule.modules.quickbooks.online.adapters;

import javax.annotation.Generated;
import org.mule.modules.quickbooks.online.QuickBooksOnlineModule;
import org.mule.modules.quickbooks.online.basic.MetadataAware;


/**
 * A <code>QuickBooksOnlineModuleMetadataAdapater</code> is a wrapper around {@link QuickBooksOnlineModule } that adds support for querying metadata about the extension.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class QuickBooksOnlineModuleMetadataAdapater
    extends QuickBooksOnlineModuleCapabilitiesAdapter
    implements MetadataAware
{

    private final static String MODULE_NAME = "Quickbooks Online";
    private final static String MODULE_VERSION = "5.0.2-SNAPSHOT";
    private final static String DEVKIT_VERSION = "3.4.3";
    private final static String DEVKIT_BUILD = "3.4.3.1620.30ea288";

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

}
