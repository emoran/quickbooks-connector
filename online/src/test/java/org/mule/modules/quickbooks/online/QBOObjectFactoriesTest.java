/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

/*
 * Copyright (c) 2011 Zauber S.A.  -- All rights reserved
 */

package org.mule.modules.quickbooks.online;

import static org.junit.Assert.assertEquals;

import javax.xml.bind.JAXBElement;

import org.junit.Before;
import org.junit.Test;
import org.mule.modules.quickbooks.MapBuilder;
import org.mule.modules.quickbooks.api.model.PlatformResponse;
import org.mule.modules.quickbooks.online.objectfactory.QBOMessageUtils;
import org.mule.modules.utils.mom.JaxbMapObjectMappers;

import com.zauberlabs.commons.mom.MapObjectMapper;

/**
 * 
 * 
 * 
 * @author Gaston Ponti
 * @since Sep 9, 2011
 */

public class QBOObjectFactoriesTest {
	private MapObjectMapper mom;

	/**
     * 
     */
	@Before
	public void setup() {
		mom = JaxbMapObjectMappers.defaultWithPackage("org.mule.modules.quickbooks.schema").build();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void createTestJaxbElement() throws Exception {

		PlatformResponse platformResponse = (PlatformResponse) mom.unmap(
				new MapBuilder().with("serverTime", "1997-07-16T19:20:30+01:00")
								.with("errorCode", 500)
								.with("errorMessage", "ErrorMessage").build(),
								PlatformResponse.class);
		
		JAXBElement<PlatformResponse> jaxbPlatformResponse = QBOMessageUtils.getInstance().createJaxbElement(platformResponse);

		assertEquals("1997-07-16T19:20:30+01:00", jaxbPlatformResponse.getValue().getServerTime());
		assertEquals(500, jaxbPlatformResponse.getValue().getErrorCode(), 0);
		assertEquals("ErrorMessage", jaxbPlatformResponse.getValue().getErrorMessage());
	}
	
}
