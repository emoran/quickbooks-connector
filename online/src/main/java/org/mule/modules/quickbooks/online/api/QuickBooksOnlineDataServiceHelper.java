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

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.mule.modules.quickbooks.api.exception.ExceptionInfo;
import org.mule.modules.quickbooks.api.oauth.OAuthCredentials;
import org.springframework.util.CollectionUtils;

import com.intuit.ipp.core.Context;
import com.intuit.ipp.core.ServiceType;
import com.intuit.ipp.data.Error;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.security.OAuthAuthorizer;
import com.intuit.ipp.services.DataService;

public class QuickBooksOnlineDataServiceHelper {
	private final ServiceType SERVICE_TYPE = ServiceType.QBO;
	private String consumerKey;
	private String consumerSecret;
	
	public QuickBooksOnlineDataServiceHelper(String consumerKey, String consumerSecret) {
		Validate.notEmpty(consumerKey);
		Validate.notEmpty(consumerSecret);
		
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
	}
	
    public DataService createIntuitDataService(OAuthCredentials credentials) throws FMSException
    {
    	return new DataService(this.createIntuitContext(credentials));
    }
    
    private Context createIntuitContext(OAuthCredentials credentials) throws FMSException
    {
    	return new Context(this.createIntuitOAuthAuthorizer(credentials), this.SERVICE_TYPE, credentials.getRealmId());
    }
    
    private OAuthAuthorizer createIntuitOAuthAuthorizer(OAuthCredentials credentials)
    {
    	return new OAuthAuthorizer(consumerKey, consumerSecret, credentials.getAccessToken(), credentials.getAccessTokenSecret());
    }
    
    public ExceptionInfo adaptFMSExceptionToExceptionInfo(FMSException exception) {
    	Validate.notNull(exception);
    	
    	ExceptionInfo exceptionInfo = new ExceptionInfo(); 
    	
    	exceptionInfo.setMessage(StringUtils.defaultIfEmpty(exception.getMessage(), "No Message"));

    	List<Error> errorList = exception.getErrorList();
    	
    	if(!CollectionUtils.isEmpty(errorList))
    	{
    		for(Error error : errorList)
    		{
    			if(!StringUtils.isEmpty(error.getCode()))
    			{
    				exceptionInfo.setErrorCode(error.getCode());
    				exceptionInfo.setCause(error.getMessage());
    				return exceptionInfo;
    			}
    		}
    	}
    	
    	exceptionInfo.setErrorCode("No Cause Obtained");
    	exceptionInfo.setErrorCode("No ErrorCode Obtained");
    	return exceptionInfo;
	}
    
}
