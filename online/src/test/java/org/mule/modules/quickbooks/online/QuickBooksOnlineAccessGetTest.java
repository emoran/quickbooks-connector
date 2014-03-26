/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */


/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
 */

package org.mule.modules.quickbooks.online;

import org.junit.Ignore;
import org.mule.api.MuleContext;
import org.mule.tck.FunctionalTestCase;
import org.mule.transport.http.HttpConnector;


/**
 *   
 * @author Gaston Ponti
 * @since Sep 6, 2011
 */
@Ignore
public class QuickBooksOnlineAccessGetTest extends FunctionalTestCase
{
    @Override
    protected MuleContext createMuleContext() throws Exception
    {
         MuleContext muleContext = super.createMuleContext();
         muleContext.getRegistry().registerObject("connector.http.mule.default", new HttpConnector(muleContext));
        return muleContext;
    }

    @Override
    protected String getConfigResources()
    {
        return "mule-config.xml";
    }
}
