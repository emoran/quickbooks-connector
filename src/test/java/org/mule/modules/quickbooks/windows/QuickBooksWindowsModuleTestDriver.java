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

package org.mule.modules.quickbooks.windows;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mule.modules.quickbooks.MapBuilder;
import org.mule.modules.quickbooks.windows.schema.AccountSubtypeEnum;
import org.mule.modules.quickbooks.windows.schema.AccountTypeEnum;


/**
 * 
 * 
 * @author Gaston Ponti
 * @since Sep 9, 2011
 */

public class QuickBooksWindowsModuleTestDriver
{

    private static QuickBooksWindowsModule module;
    private static String appKey = System.getenv("appKey");
    private final String realmId = System.getenv("realmId");
    private final String realmIdPseudonym = System.getenv("realmIdPseudonym");
    private final String authIdPseudonym = System.getenv("authIdPseudonym");
    
    /**
     * 
     */
    @BeforeClass
    public static void setup()
    {
        module = new QuickBooksWindowsModule();
        module.setBaseUri("https://services.intuit.com/sb");
        module.init();
    }

    @Test
    public void createAccount()
    {   
        Map<String, Object> mapAccount = new MapBuilder().with("name", "Test Account QW 88")
                                                         .with("active", true)
                                                         .with("type", AccountTypeEnum.EXPENSE)
                                                         .with("subtype", AccountSubtypeEnum.EXPENSE.value())
                                                         .with("acctNum", "9919823")
                                                         .with("openingBalance", 0)
                                                         .with("openingBalanceDate", "2012-02-02T00:00:00Z")
                                                         .build();
        Object acc = module.create(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.ACCOUNT, mapAccount, "09876543210987654321098765432116", null, true);
        System.out.println(acc);
    }

//    @Test
//    public void createCustomerAnswersNonNullCustomerWithId() throws Exception
//    {
//        List<Map<String, Object>> auxList = new ArrayList<Map<String, Object>>();
//        
//        Map<String, Object> auxMap = new HashMap<String, Object>();
//        
//        auxMap.put("Line1", null);
//        auxMap.put("Line2", null);
//        auxMap.put("City", null);
//        auxMap.put("CountrySubDivisionCode", null);
//        auxMap.put("PostalCode", null);
//        auxMap.put("Tag", "Billing");
//        
//        auxList.add(auxMap);
//
//        Customer c = module.createCustomer(realmId, appKey, realmIdPseudonym, authIdPseudonym,
//            "Susana", 
//            "Susana", 
//            "Melina", 
//            "Perez",
//            null, null, null, 
//            new ArrayList<Map<String, Object>>(), 
//            null, null, new ArrayList<Map<String, Object>>(),
//            new ArrayList<Map<String, Object>>(),
//            new ArrayList<Map<String, Object>>()
////            auxList
////            Arrays.<Map<String, Object>>asList(new HashMap<String, Object>()
////                {
////                    {
////                        put("Line1", null);
////                        put("Line2", null);
////                        put("City", null);
////                        put("CountrySubDivisionCode", null);
////                        put("PostalCode", null);
////                        put("Tag", "Billing");
////                    } 
////               }
////            )
//        );
//        
//        assertEquals("Susana", c.getName());
//        assertNotNull(c.getId());
//
//        Map<String, Object> idType = new HashMap<String, Object>();
//        idType.put("value", c.getId().getValue());
//        //idType.put("idDomain", c.getId().getIdDomain());
//        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, idType, c.getSyncToken());
//    }
//    
//    @Test
//    @Ignore
//    public void testname() throws Exception
//    {
//        
//     List<Map<String, Object>> auxList = new ArrayList<Map<String, Object>>();
//        
//        Map<String, Object> auxMap = new HashMap<String, Object>();
//        
//        auxMap.put("Line1", null);
//        auxMap.put("Line2", null);
//        auxMap.put("City", null);
//        auxMap.put("CountrySubDivisionCode", null);
//        auxMap.put("PostalCode", null);
//        auxMap.put("Tag", "Billing");
//        
//        auxList.add(auxMap);
//
//        MapObjectMapper mom = JaxbMapObjectMappers.defaultWithPackage("org.mule.modules.quickbooks.schema").build();
//        Customer c = (Customer) mom.unmap(
//                new MapBuilder()
//                .with("name", "Susana")
//                .with("givenName", "Susana")
//                .with("middleName", "Melina")
//                .with("familyName", "Perez")
//                .with("suffix", null)
//                .with("DBAName", null)
//                .with("showAs", null)
//                .with("webSite", new ArrayList<Map<String, Object>>())
//                .with("salesTermId", null)
//                .with("salesTaxCodeId", null)
//                .with("email", new ArrayList<String>())
//                .with("phone", new ArrayList<Map<String, Object>>())
//                .with("address", auxList)
//                .build(), Customer.class
//                );
//        
//        PhysicalAddress ph = c.getAddress().get(0);
//        
//        assertEquals(ph.getTag(), "Billing");
//    }
//    
//    @Test
//    public void getCustomerAnswersNonNullCustomerWithId() throws Exception
//    {
//        Map<String, Object> idType = new HashMap<String, Object>();
//        idType.put("value", "1");
//        //idType.put("idDomain", c.getId().getIdDomain());
//        Customer c = (Customer) module.getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, idType);
//        
//        assertEquals("Ricardo (deleted)", c.getName());
//        assertNotNull(c.getId());
//    }
//    
//    @Test
//    public void modifyCustomer()
//    {
//        Customer c1 = module.createCustomer(realmId, appKey, realmIdPseudonym, authIdPseudonym,
//            "Paul M. Jonhson", 
//            "Paul", 
//            "Mark", 
//            "Jhonson",
//            null, null, null, 
//            new ArrayList<Map<String, Object>>(), 
//            null, null, new ArrayList<Map<String, Object>>(),
//            new ArrayList<Map<String, Object>>(),
//            new ArrayList<Map<String, Object>>()
//        );
//        
//        assertEquals("Jhonson", c1.getFamilyName());
//        
//        Map<String, Object> idType = new HashMap<String, Object>();
//        idType.put("value", c1.getId().getValue());
//        
//        Customer c2 = module.updateCustomer(realmId, appKey, realmIdPseudonym, authIdPseudonym,
//            idType, 
//            c1.getSyncToken(), 
//            c1.getName(), 
//            c1.getGivenName(), 
//            c1.getMiddleName(), 
//            "Smith", 
//            null, null, null, 
//            new ArrayList<Map<String, Object>>(), 
//            null, null, new ArrayList<Map<String, Object>>(),
//            new ArrayList<Map<String, Object>>(),
//            new ArrayList<Map<String, Object>>()
//        );
//        
//        Customer c3 = (Customer) module.getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, idType);
//        
//        assertEquals("Smith", c3.getFamilyName());
//        
//        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, idType, null);
//    }
//    
//    @Test
//    public void getAllCustomersAnswersNonNullListWithCustomers() throws Exception
//    {
//        Iterable it = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, null, null);
//        
//        
//        for (Object c : it)
//        {
//            System.out.println(((Customer) c).getName());
//        }
//    }
//    
//    @Test
//    public void getSomeCustomersAnswersNonNullListWithCustomers() throws Exception
//    {
//        Iterable it = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, "GivenName :EQUALS: Susana", null);
//        
//        for (Object c : it)
//        {
//            System.out.println(((Customer) c).getName());
//        }
//    }
//    
//    @Test
//    public void createSalesTermAnswersNonNullSalesTermWithId()
//    {
//        SalesTerm salesTerm = module.createSalesTerm(realmId, appKey, realmIdPseudonym, authIdPseudonym,
//            "SalesTerm1",
//            3,
//            null,
//            null,
//            2,
//            null,
//            null,
//            null);
//        
//        assertEquals("SalesTerm1", salesTerm.getName());
//        Map<String, Object> idType = new HashMap<String, Object>();
//        idType.put("value", salesTerm.getId().getValue());
//        
//        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.SALESTERM, idType, null);
//    }
//
//    @Test
//    public void retrievesAEmptyIterable()
//    {
//        Iterable<Customer> it = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, "Name :EQUALS: MFASDAEAEAAASS", null);
//
//        assertEquals(false, it.iterator().hasNext());
//    }
//    
////    @Test
////    public void deleteCustomer()
////    {
////        MapObjectMapper mom = JaxbMapObjectMappers.defaultWithPackage("org.mule.modules.quickbooks.online.schema").build();
////        
////        Iterable<Customer> it= module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, EntityType.CUSTOMER, "Name :EQUALS: Paul M. Jenkins 4", null);
////        
////        for (Customer customer: it)
////        {
////            module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, EntityType.CUSTOMER, (Map<String, Object>) mom.map(customer.getId()), customer.getSyncToken());
////        }
////    }
//    
//    @Test
//    public void createInvoiceRetrieveAndUpdateIt()
//    {
//        MapObjectMapper mom = JaxbMapObjectMappers.defaultWithPackage("org.mule.modules.quickbooks.online.schema").build();
//
//        //creates a customer
//        Customer customer = module.createCustomer(realmId, appKey, realmIdPseudonym, authIdPseudonym,
//            "Paul M. Jenkins 4", 
//            "Paul", 
//            "Mark", 
//            "Jenkins",
//            null, null, null, 
//            new ArrayList<Map<String, Object>>(), 
//            null, null, new ArrayList<Map<String, Object>>(),
//            new ArrayList<Map<String, Object>>(),
//            new ArrayList<Map<String, Object>>()
//        );
//        
//        //create an item
//        Map<String, Object> unitPrice = new HashMap<String, Object>(){{
//            put("amount", 100);
//        }};
//        
//        Item item = module.createItem(realmId, appKey, realmIdPseudonym, authIdPseudonym,
//            "ItemTest0057", unitPrice, null, false, null, null, null, null, null, null);
//        
//        //create an invoice with the customer and item created before
//        InvoiceHeader invHeader = new InvoiceHeader();
//        invHeader.setCustomerId(customer.getId());
//        invHeader.setDocNumber("DOC-00000010101");
//        
//        List<InvoiceLine> lines = new ArrayList<InvoiceLine>();
//        InvoiceLine invoiceLine = new InvoiceLine();
//        invoiceLine.setAmount(new BigDecimal(100));
//        invoiceLine.setItemId(item.getId());
//        lines.add(invoiceLine);
//        Invoice invoice = module.createInvoice(realmId, appKey, realmIdPseudonym, authIdPseudonym, (Map<String, Object>) mom.map(invHeader), (List<Map<String, Object>>) mom.map(lines));
//        
//        //retrieve the invoices of our customer
//        String filter = "CustomerId :EQUALS: " + customer.getId().getValue();
//        Iterable<Invoice> iterableInv = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.INVOICE, filter, null);
//
//        //We know that only has one invoice, because we have created him
//        invoice = iterableInv.iterator().next();
//        
//        //change the docNumber and update it
//        invoice.getHeader().setDocNumber("DOC-NEW:001111111101");
//        invoice = module.updateInvoice(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
//                             (Map<String, Object>) mom.map(invoice.getId()), 
//                             invoice.getSyncToken(), 
//                             (Map<String, Object>) mom.map(invoice.getHeader()), 
//                             (List<Map<String, Object>>) mom.map(invoice.getLine()));
//        
//        //delete everything
//        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.INVOICE, (Map<String, Object>) mom.map(invoice.getId()), invoice.getSyncToken());
//        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.ITEM, (Map<String, Object>) mom.map(item.getId()), item.getSyncToken());
//        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, (Map<String, Object>) mom.map(customer.getId()), customer.getSyncToken());
//    
//        //verify the change
//        assertEquals("DOC-NEW:001111111101", invoice.getHeader().getDocNumber());
//    }
//    
//    @Test(expected = QuickBooksRuntimeException.class)
//    public void createAccountThrowingExceptionForWrongCredentials()
//    {
//        QuickBooksModule module2;
//        module2 = new QuickBooksModule();
//        module2.setBaseUri("https://qbo.intuit.com/qbo1/rest/user/v2");
//        module2.init();
//        
//        Account acc = module2.createAccount("wrongRealmId", appKey, realmIdPseudonym, authIdPseudonym,
//            "Test Account", null, AccountDetail.SAVINGS, "3654", "0", new Date(), null);
//    }
    
}
