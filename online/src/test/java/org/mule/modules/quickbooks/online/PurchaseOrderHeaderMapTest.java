/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.online;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.mule.modules.quickbooks.MapBuilder;
import org.mule.modules.quickbooks.online.schema.Customer;
import org.mule.modules.quickbooks.online.schema.InvoiceLine;
import org.mule.modules.quickbooks.online.schema.PurchaseOrderHeader;
import org.mule.modules.utils.mom.JaxbMapObjectMappers;

import com.zauberlabs.commons.mom.MapObjectMapper;

public class PurchaseOrderHeaderMapTest
{
    private final MapObjectMapper mom = JaxbMapObjectMappers.defaultWithPackage("org.mule.modules.quickbooks.online.schema").build();
    
    @Test
    public void purchaseOrderMap() {
        
        PurchaseOrderHeader purchaseOrderHeader = new PurchaseOrderHeader();
        
        purchaseOrderHeader.setToBePrinted(true);
        purchaseOrderHeader.setToBeEmailed(false);
        
        Map<String, Object> map = (Map<String, Object>) mom.map(purchaseOrderHeader);
        
    }
    
    @Test
    public void mapAndUnmapAcronymProperty() {
        
        List<InvoiceLine> lines = new ArrayList<InvoiceLine>();
        InvoiceLine invoiceLine = new InvoiceLine();
        invoiceLine.setUOMAbbrv("something");
        lines.add(invoiceLine);
        List<Map<String, Object>> listLines = (List<Map<String, Object>>) mom.map(lines);
        
        List<InvoiceLine> aux = (List<InvoiceLine>) mom.unmap(listLines, InvoiceLine.class);
    }
    
    @Test
    public void canUnmapAcronymProperties() {
        
        Customer c = (Customer) mom.unmap(
                new MapBuilder()
                .with("DBAName", "asdfasdf")
                .build(), Customer.class
                );
        
        assertEquals("asdfasdf", c.getDBAName());
        
    }
    
    
    @Test
    public void momPreservesIdempotencyWhenUsingAcronymProperties() {
        Customer c = (Customer) mom.unmap(
                new MapBuilder()
                .with("dBAName", "asdfasdf")
                .build(), Customer.class
                );
        
        Map<String,Object> map = (Map<String, Object>) mom.map(c);
        
        assertEquals("asdfasdf", map.get("DBAName"));
        
    }
}
