/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
 */

package org.mulesoft.demo.quickbooks;

import org.mule.api.MuleEvent;
import org.mule.api.transport.PropertyScope;
import org.mule.construct.Flow;
import org.mule.tck.FunctionalTestCase;

public class QuickBooksFunctionalTestDriver extends FunctionalTestCase
{

    @Override
    protected String getConfigResources()
    {
        return "mule-config.xml";
    }
    /**Creation and Retrieve: this sample will be focused on showing basic CRUD features of
QuickBooks. It will integrate Mongo connector - entities created in QuickBooks will be imported
from a Mongo Collection, and with Scripting component - retrieved entities will be shown to the
user formatting it with a Groovy script.
*/

    public void testCreateCustomers() throws Exception
    {
        System.out.println(lookupFlowConstruct("CreateCustomers").process(getTestEvent("")).getMessage().getPayload());
    }
    
    public void testDeleteCustomer() throws Exception
    {
        MuleEvent event = getTestEvent("");
        event.getMessage().setProperty("idCustomerValue", "3023048", PropertyScope.INBOUND);
        System.out.println(lookupFlowConstruct("DeleteCustomer").process(event).getMessage().getPayload());
    }

    private Flow lookupFlowConstruct(final String name)
    {
        return (Flow) muleContext.getRegistry().lookupFlowConstruct(name);
    }

}
