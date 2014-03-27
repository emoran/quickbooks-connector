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

import com.intuit.ipp.services.QueryResult;

public class QuickBooksOnlinePage {
	private QueryResult queryResult;
	private Integer pageNumber;

	public QuickBooksOnlinePage(QueryResult queryResult, Integer pageNumber) {
		this.queryResult = queryResult;
		this.pageNumber = pageNumber;
	}
	
	public QueryResult getQueryResult() {
		return queryResult;
	}
	
	public void setQueryResult(QueryResult queryResult) {
		this.queryResult = queryResult;
	}
	
	public Integer getPageNumber() {
		return pageNumber;
	}
	
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public Integer nextPageNumber() {
		return pageNumber+1;
	}
	
	public Integer getTotalCount() {
		return queryResult.getTotalCount();
	}
	
}
