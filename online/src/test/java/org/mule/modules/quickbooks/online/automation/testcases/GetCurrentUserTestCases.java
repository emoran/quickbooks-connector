/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.online.automation.testcases;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.quickbooks.api.model.UserInformation;
import org.mule.modules.quickbooks.online.automation.QuickBooksOnlineTestParent;
import org.mule.modules.quickbooks.online.automation.RegressionTests;

public class GetCurrentUserTestCases extends QuickBooksOnlineTestParent {
	
	@Category({RegressionTests.class})
	@Test
	public void getCurrentUser() throws Exception {
    	UserInformation userInformation = runFlowAndGetPayload("GetCurrentUser");
    	assertNotNull(userInformation);
	}

}
