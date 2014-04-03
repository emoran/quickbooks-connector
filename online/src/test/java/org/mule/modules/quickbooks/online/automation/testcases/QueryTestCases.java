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

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.quickbooks.online.automation.QuickBooksOnlineTestParent;
import org.mule.modules.quickbooks.online.automation.RegressionTests;

import com.intuit.ipp.data.Item;

public class QueryTestCases extends QuickBooksOnlineTestParent {
	private List<Item> createdItems;
	private Integer itemsSize = 4;
	
	@Before
    public void setUp() throws Exception {
		createdItems = new ArrayList<Item>();
		
		for(Integer i = 0; i < itemsSize; i++) {
			Item item = getBeanFromContext("itemObject");
			item.setName("TestItem_" + i);
			Item createdItem = this.createItemInQBO(item);
			createdItems.add(createdItem);
		}
    }
	
	@Category({RegressionTests.class})
	@Test
	public void queryItems() throws Exception {
		upsertPayloadContentOnTestRunMessage("SELECT * FROM ITEM WHERE Name LIKE 'TestItem_%'");
		List<Item> retrievedItems = runFlowAndGetPayload("Query");
		assertEquals(itemsSize, retrievedItems.size(), 0);
	}
	
	@After
	public void tearDown() throws Exception {
		for(Item item: createdItems) {
			this.disableItemInQBO(item);
		}
	}
}