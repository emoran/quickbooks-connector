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

public class QuickBooksOnlinePaginatedIterable extends PaginatedIterable<IEntity, QuickBooksOnlinePage> {
	
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
	private QuickBooksOnlinePage askForAnEspecificPage(Integer pageNumber) {
		Validate.isTrue(pageNumber > 0);
		Integer startPosition = (pageNumber-1)*resultsPerPage+1;
		
		String pagedQuery = new StringBuilder(query)
							.append(" STARTPOSITION ").append(startPosition)
							.append(" MAXRESULTS ").append(resultsPerPage)
							.toString();
		
		try {
			DataService dataService = dataServiceHelper.createIntuitDataService(credentials);
			QueryResult queryResult = dataService.executeQuery(pagedQuery);
			
			return new QuickBooksOnlinePage(queryResult, pageNumber);
		} catch(FMSException e) {
			throw new QuickBooksRuntimeException(dataServiceHelper.adaptFMSExceptionToExceptionInfo(e), e);
		}
	}

	@Override
	protected QuickBooksOnlinePage firstPage() {
		return this.askForAnEspecificPage(1);
	}

	@Override
	protected boolean hasNextPage(QuickBooksOnlinePage page) {
		return page.getTotalCount().equals(resultsPerPage);
	}

	@Override
	protected QuickBooksOnlinePage nextPage(QuickBooksOnlinePage page) {
		return this.askForAnEspecificPage(page.nextPageNumber());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Iterator<IEntity> pageIterator(QuickBooksOnlinePage page) {
		List<IEntity> entities = (List<IEntity>) page.getQueryResult().getEntities();
		
		if(CollectionUtils.isEmpty(entities)) {
			entities = new ArrayList<IEntity>();
		}
		
		return entities.iterator();
	}

}
