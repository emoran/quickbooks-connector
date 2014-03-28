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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.Validate;
import org.mule.modules.quickbooks.api.exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.api.oauth.OAuthCredentials;
import org.mule.modules.utils.pagination.PaginatedIterable;
import org.springframework.util.CollectionUtils;

import com.intuit.ipp.core.IEntity;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.DataService;
import com.intuit.ipp.services.QueryResult;

public class QuickBooksOnlinePaginatedIterable<T extends IEntity> extends PaginatedIterable<T, QuickBooksOnlinePage> {
	private static final String START_POSITION_KEY = "STARTPOSITION"; 
	private static final String MAX_RESULTS_KEY = "MAXRESULTS";
	
	private QuickBooksOnlineDataServiceHelper dataServiceHelper;
	private OAuthCredentials credentials;
	private String query;
	private Integer resultsPerPage;
	
	public QuickBooksOnlinePaginatedIterable(QuickBooksOnlineDataServiceHelper dataServiceHelper, OAuthCredentials credentials, String query, Integer resultsPerPage){
		Validate.notNull(dataServiceHelper);
		Validate.notNull(credentials);
		Validate.notNull(query);
		Validate.notNull(resultsPerPage);
		
		this.dataServiceHelper = dataServiceHelper;
		this.credentials = credentials;
		this.query = query;
		this.resultsPerPage = resultsPerPage;
	}
	
	/*
	 * Query Format Example - with pagination parameters
	 * 
	 * SELECT ResponseSubset
	 * FROM IntuitEntity
	 * [WHERE WhereClause]
	 * [ORDERBY OrderByClause]
	 * [STARTPOSITION  Number] [MAXRESULTS  Number]
	 */
	protected QuickBooksOnlinePage askForPage(Integer startPosition, Integer maxResults, Integer pageNumber) {
		Validate.isTrue(startPosition > 0);
		Validate.isTrue(maxResults > 0);
		
		String pagedQuery = new StringBuilder(query)
							.append(" ").append(START_POSITION_KEY).append(" ").append(startPosition)
							.append(" ").append(MAX_RESULTS_KEY).append(" ").append(maxResults)
							.toString();
		
		try {
			DataService dataService = dataServiceHelper.createIntuitDataService(credentials);
			QueryResult queryResult = dataService.executeQuery(pagedQuery);
			
			return new QuickBooksOnlinePage(queryResult, startPosition, pageNumber);
		} catch(FMSException e) {
			throw new QuickBooksRuntimeException(dataServiceHelper.adaptFMSExceptionToExceptionInfo(e), e);
		}
	}

	@Override
	protected QuickBooksOnlinePage firstPage() {
		return this.askForPage(1, resultsPerPage, 1);
	}

	@Override
	protected boolean hasNextPage(QuickBooksOnlinePage page) {
		return page.getPageResultsSize() > 0;
	}

	@Override
	protected QuickBooksOnlinePage nextPage(QuickBooksOnlinePage page) {
		return this.askForPage(page.nextStartPosition(), resultsPerPage, page.nextPageNumber());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Iterator<T> pageIterator(QuickBooksOnlinePage page) {
		List<IEntity> entities = (List<IEntity>) page.getQueryResult().getEntities();
		
		if(CollectionUtils.isEmpty(entities)) {
			entities = new ArrayList<IEntity>();
		}
		
		return (Iterator<T>) entities.iterator();
	}

}
