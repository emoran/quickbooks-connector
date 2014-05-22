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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;

import org.junit.Test;

public class QuickBooksOnlineQueryEvaluatorTest {

	@Test
	public void matchSelectFieldsPatternsTest() {
		
		this.assertPositiveMatchSelectFieldsPattern("SELECT COUNT(*)FROM ITEM", " COUNT(*)");
		this.assertPositiveMatchSelectFieldsPattern("SELECT  COUNT  (  *  )FROM ITEM", "  COUNT  (  *  )");
		this.assertPositiveMatchSelectFieldsPattern("SELECT*FROM ITEM", "*");
		this.assertPositiveMatchSelectFieldsPattern("SELECT* FROM ITEM", "* ");
		this.assertPositiveMatchSelectFieldsPattern("SELECT *FROM ITEM", " *");
		this.assertPositiveMatchSelectFieldsPattern("SELECT * FROM ITEM", " * ");
		this.assertPositiveMatchSelectFieldsPattern("Select * From ITEM", " * ");
		this.assertPositiveMatchSelectFieldsPattern("SELECT Name,Field FROM ITEM", " Name,Field ");
		
		this.assertNegativeMatchSelectFieldsPattern("SELECTCOUNT(*) FROM ITEM");
		this.assertNegativeMatchSelectFieldsPattern("SELECT )FROM ITEM");
		this.assertNegativeMatchSelectFieldsPattern("SELECT COUNT(*) FROM");
	}
	
	private void assertPositiveMatchSelectFieldsPattern(String query, String expectedSelectFields) {
		Matcher matcher = QuickBooksOnlineQueryEvaluator.matchSelectFieldsPattern(query);
		
		assertTrue(matcher.matches());
		assertEquals(expectedSelectFields, matcher.toMatchResult().group(1));
	}
	
	private void assertNegativeMatchSelectFieldsPattern(String query) {
		Matcher matcher = QuickBooksOnlineQueryEvaluator.matchSelectFieldsPattern(query);
		
		assertFalse(matcher.matches());
	}
	
}
