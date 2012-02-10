/**
 * Copyright (c) 2009 Intuit, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.opensource.org/licenses/eclipse-1.0.php
 *
 * Contributors:
 *    Intuit Partner Platform - initial contribution
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