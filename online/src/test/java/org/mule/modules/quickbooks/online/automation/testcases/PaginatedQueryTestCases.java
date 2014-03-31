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
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.quickbooks.online.automation.QuickBooksOnlineTestParent;
import org.mule.modules.quickbooks.online.automation.RegressionTests;

import com.intuit.ipp.data.Item;

public class PaginatedQueryTestCases extends QuickBooksOnlineTestParent {
	private List<Item> createdItems;
	private Integer itemsSize = 25;
	
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
		String query = "SELECT * FROM ITEM WHERE Name LIKE 'TestItem_%'";
		upsertPayloadContentOnTestRunMessage(this.createPaginatedQueryPayload(query, 5));
		Iterable<Item> retrievedItems = runFlowAndGetPayload("PaginatedQuery");
		
		Integer i = 0;
		for(Item item : retrievedItems){
			assertTrue(item.getName().startsWith("TestItem"));
			i++;
		}
		
		assertEquals(itemsSize,i,0);
	}
	
	private Map<String,Object> createPaginatedQueryPayload(String query, Integer resultsPerPage){
		Map<String,Object> map = new HashMap<String,Object>(); 
		map.put("query", query);
		map.put("resultsPerPage", resultsPerPage);
		return map;
	}
	
	@After
	public void tearDown() throws Exception {
		for(Item item: createdItems) {
			this.disableItemInQBO(item);
		}
	}
}
