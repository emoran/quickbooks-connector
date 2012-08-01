/**
 * (c) 2003-2012 MuleSoft, Inc. This software is protected under international
 * copyright law. All use of this software is subject to MuleSoft's Master
 * Subscription Agreement (or other Terms of Service) separately entered
 * into between you and MuleSoft. If such an agreement is not in
 * place, you may not use the software.
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