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
	private Integer usedStartPosition;

	public QuickBooksOnlinePage(QueryResult queryResult, Integer usedStartPosition, Integer pageNumber) {
		this.queryResult = queryResult;
		this.pageNumber = pageNumber;
		this.usedStartPosition = usedStartPosition;
	}
	
	public QueryResult getQueryResult() {
		return queryResult;
	}
	
	public Integer getPageNumber() {
		return pageNumber;
	}
	
	public Integer getUsedStartPosition() {
		return usedStartPosition;
	}

	public Integer getPageResultsSize() {
		return queryResult.getEntities().size();
	}
	
	public Integer nextPageNumber() {
		return pageNumber + 1;
	}
	
	public Integer nextStartPosition() {
		return usedStartPosition + this.getPageResultsSize();
	}
	
}
