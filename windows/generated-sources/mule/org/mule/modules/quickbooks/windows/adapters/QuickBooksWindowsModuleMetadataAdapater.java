
package org.mule.modules.quickbooks.windows.adapters;

import javax.annotation.Generated;
import org.mule.modules.quickbooks.windows.QuickBooksWindowsModule;
import org.mule.modules.quickbooks.windows.basic.MetadataAware;


/**
 * A <code>QuickBooksWindowsModuleMetadataAdapater</code> is a wrapper around {@link QuickBooksWindowsModule } that adds support for querying metadata about the extension.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-21T02:51:05-05:00", comments = "Build 3.4.3.1620.30ea288")
public class QuickBooksWindowsModuleMetadataAdapater
    extends QuickBooksWindowsModuleCapabilitiesAdapter
    implements MetadataAware
{

    private final static String MODULE_NAME = "Quickbooks Windows";
    private final static String MODULE_VERSION = "5.0.1-SNAPSHOT";
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
