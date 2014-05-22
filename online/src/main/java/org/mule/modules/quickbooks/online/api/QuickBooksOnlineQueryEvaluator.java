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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuickBooksOnlineQueryEvaluator {
	private static Pattern selectFieldsPatterns = Pattern.compile("^select(\\s(.+)\\s|(\\s*)\\*(\\s*)|\\s+COUNT\\s*\\(\\s*\\*\\s*\\))from\\s.*$", Pattern.CASE_INSENSITIVE);
	
	public static Matcher matchSelectFieldsPattern(String input) {
		return selectFieldsPatterns.matcher(input);
	}
	
}
