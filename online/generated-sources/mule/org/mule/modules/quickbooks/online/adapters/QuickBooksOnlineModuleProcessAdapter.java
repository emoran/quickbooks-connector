
package org.mule.modules.quickbooks.online.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.modules.quickbooks.online.QuickBooksOnlineModule;
import org.mule.modules.quickbooks.online.process.ProcessAdapter;
import org.mule.modules.quickbooks.online.process.ProcessCallback;
import org.mule.modules.quickbooks.online.process.ProcessTemplate;
import org.mule.modules.quickbooks.online.process.ProcessTemplate;


/**
 * A <code>QuickBooksOnlineModuleProcessAdapter</code> is a wrapper around {@link QuickBooksOnlineModule } that enables custom processing strategies.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:35:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class QuickBooksOnlineModuleProcessAdapter
    extends QuickBooksOnlineModuleLifecycleAdapter
    implements ProcessAdapter<QuickBooksOnlineModuleCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, QuickBooksOnlineModuleCapabilitiesAdapter> getProcessTemplate() {
        final QuickBooksOnlineModuleCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,QuickBooksOnlineModuleCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, QuickBooksOnlineModuleCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, QuickBooksOnlineModuleCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
