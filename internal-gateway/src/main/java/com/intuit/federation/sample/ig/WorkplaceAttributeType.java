/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package com.intuit.federation.sample.ig;

/**
 * Values known as of today (3/2009), though more may be added at a future time.
 * 
 * @author jruthenbeck
 */
public enum WorkplaceAttributeType 
{
    TICKET 
    {
        public String toString() 
        {
            return "ticket";
        }
    },
    // This one is the NameID element's value. Unsure how to refer to it, though
    AUTH_ID 
    {
        public String toString() 
        {
            return "authID";
        }
    },
    REALM_ID 
    {
        public String toString() 
        {
            return "realmID";
        }
    },
    REALM_ID_PSEUDONYM 
    {
        public String toString() 
        {
            return "Intuit.Federation.realmIDPseudonym";
        }
    },
    TARGET_URL 
    {
        public String toString() 
        {
            return "targetUrl";
        }
    };
}