
package org.mule.modules.quickbooks.windows.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.quickbooks.windows.QuickBooksWindowsModule;
import org.mule.modules.quickbooks.windows.process.ProcessAdapter;
import org.mule.modules.quickbooks.windows.process.ProcessCallback;
import org.mule.modules.quickbooks.windows.process.ProcessTemplate;
import org.mule.modules.quickbooks.windows.process.ProcessTemplate;


/**
 * A <code>QuickBooksWindowsModuleProcessAdapter</code> is a wrapper around {@link QuickBooksWindowsModule } that enables custom processing strategies.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:33:09-05:00", comments = "Build 3.4.3.1620.30ea288")
public class QuickBooksWindowsModuleProcessAdapter
    extends QuickBooksWindowsModuleLifecycleAdapter
    implements ProcessAdapter<QuickBooksWindowsModuleCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, QuickBooksWindowsModuleCapabilitiesAdapter> getProcessTemplate() {
        final QuickBooksWindowsModuleCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,QuickBooksWindowsModuleCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, QuickBooksWindowsModuleCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, QuickBooksWindowsModuleCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
