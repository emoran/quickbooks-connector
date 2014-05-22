/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.online.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mule.modules.quickbooks.api.oauth.OAuthCredentials;

import com.intuit.ipp.data.Item;
import com.intuit.ipp.services.DataService;
import com.intuit.ipp.services.QueryResult;

public class QuickBooksOnlinePaginatedIterableTest {
	private final String ITEM_QUERY = "SELECT * FROM ITEM";
	private final String ITEM_QUERY_COUNT = "SELECT COUNT(*) FROM ITEM";
	private final String START_POSITION_KEY = "STARTPOSITION";
	private final String MAX_RESULTS_KEY = "MAXRESULTS";
	
	private OAuthCredentials credentials;
	private QuickBooksOnlineDataServiceHelper dataServiceHelper;
	private List<Item> itemList;
	
	@Before
	public void setUp() throws Exception{
		credentials = mock(OAuthCredentials.class);
		dataServiceHelper = mock(QuickBooksOnlineDataServiceHelper.class);
		DataService dataService = mock(DataService.class);
		
		when(dataService.executeQuery(anyString())).thenAnswer(new Answer<QueryResult>(){

			@Override
			public QueryResult answer(InvocationOnMock invocation) throws Throwable {
				QueryResult queryResult = new QueryResult();
				
				String query = (String) invocation.getArguments()[0];
				
				if(StringUtils.contains(query, ITEM_QUERY)) {
					String parsedQuery = StringUtils.replaceEach(query, new String[]{ITEM_QUERY, START_POSITION_KEY, MAX_RESULTS_KEY}, new String[]{"","",""});
					
					String[] parameters = StringUtils.split(parsedQuery);
					
					Integer startPosition = new Integer(parameters[0]) - 1;
					Integer maxResults = new Integer(parameters[1]);
					
					Integer toIndex = (startPosition + maxResults > itemList.size() ? itemList.size() : startPosition + maxResults);
					Integer fromIndex = (startPosition > toIndex? toIndex : startPosition);
					
					queryResult.setEntities(itemList.subList(fromIndex, toIndex));
					queryResult.setMaxResults(queryResult.getEntities().size());
					return queryResult;
				
				} else if(StringUtils.contains(query, ITEM_QUERY_COUNT)) {
					queryResult.setTotalCount(itemList.size());
					return queryResult;
				} else {
					throw new IllegalArgumentException("The query cannot be tested.");
				}
			}
		});
		
		when(dataServiceHelper.createIntuitDataService(credentials)).thenReturn(dataService);
	}
	
	private void populateItemList(Integer numberOfItems) {
		itemList = new ArrayList<Item>();
		
		for(Integer i = 0; i < numberOfItems; i++){
			itemList.add(this.createItem("TestItemName_" + i, "TestItemDescription_" + i, new BigDecimal(10)));
		}
	}

	private Item createItem(String name, String description, BigDecimal unitPrice) {
		Item item = new Item();
		
		item.setName(name);
		item.setDescription(description);
		item.setUnitPrice(unitPrice);
		
		return item;
	}
	
	private void checkItemsOfPaginatedIterable(QuickBooksOnlinePaginatedIterable<Item> paginatedIterable, Integer numberOfItems){
		Integer i = 0;
		for(Item item : paginatedIterable){
			assertEquals(itemList.get(i++), item);
		}
		assertEquals(numberOfItems,i);
	}
	
	private void checkPageRequests(QuickBooksOnlinePaginatedIterable<Item> paginatedIterable, Integer listSize, Integer maxResults) {
		Integer startPosition = 1, pageNumber = 1;
		
		while(startPosition < listSize) {
			verify(paginatedIterable).askForPage(startPosition, maxResults, pageNumber++);
			startPosition += maxResults;
		}
		
		verify(paginatedIterable).askForPage(listSize+1, maxResults, pageNumber);
	}
	
	private void checkTotalResultsCount(QuickBooksOnlinePaginatedIterable<Item> paginatedIterable, Integer listSize) {
		Integer totalResultsCount = paginatedIterable.getTotalResultsCount();
		assertEquals(listSize, totalResultsCount);
	}

	private void testQuickBooksOnlineItemPaginatedIterable(Integer listSize, Integer maxResults){
		this.populateItemList(listSize);
		QuickBooksOnlinePaginatedIterable<Item> paginatedIterable = spy(new QuickBooksOnlinePaginatedIterable<Item>(dataServiceHelper, credentials, ITEM_QUERY, maxResults));

		this.checkItemsOfPaginatedIterable(paginatedIterable, listSize);
		this.checkPageRequests(paginatedIterable, listSize, maxResults);
		this.checkTotalResultsCount(paginatedIterable, listSize);
	}

	@Test
	public void testQuickBooksOnlineItemPaginatedIterable1() {
		this.testQuickBooksOnlineItemPaginatedIterable(124, 10);
	}
	
	@Test
	public void testQuickBooksOnlineItemPaginatedIterable2() {
		this.testQuickBooksOnlineItemPaginatedIterable(45, 6);
	}
	
	@Test
	public void testQuickBooksOnlineItemPaginatedIterable3() {
		this.testQuickBooksOnlineItemPaginatedIterable(34, 6);
	}
	
}
