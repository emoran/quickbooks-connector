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

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mule.modules.quickbooks.MapBuilder;
import org.mule.modules.quickbooks.api.exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.windows.schema.Account;
import org.mule.modules.quickbooks.windows.schema.AccountSubtypeEnum;
import org.mule.modules.quickbooks.windows.schema.AccountTypeEnum;
import org.mule.modules.quickbooks.windows.schema.Customer;
import org.mule.modules.quickbooks.windows.schema.PartyType;
import org.mule.modules.quickbooks.windows.schema.PhysicalAddress;
import org.mule.modules.quickbooks.windows.schema.SalesTerm;
import org.mule.modules.utils.mom.JaxbMapObjectMappers;

import com.zauberlabs.commons.mom.MapObjectMapper;


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
    private final MapObjectMapper mom = JaxbMapObjectMappers.defaultWithPackage("org.mule.modules.quickbooks.windows.schema").build();
    
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
    public void createAccountAskingForFullResponse()
    {   
        Map<String, Object> mapAccount = new MapBuilder().with("name", "Test Account QW 91")
                                                         .with("active", true)
                                                         .with("type", AccountTypeEnum.EXPENSE)
                                                         .with("subtype", AccountSubtypeEnum.EXPENSE.value())
                                                         .with("acctNum", "9919823")
                                                         .with("openingBalance", 0)
                                                         .with("openingBalanceDate", "2012-02-02T00:00:00Z")
                                                         .build();
        Account acc = (Account) module.create(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.ACCOUNT, mapAccount, module.generateANewRequestId(), null, true);
        
        System.out.println(acc);
        module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.ACCOUNT, (Map<String, Object>) mom.map(acc), module.generateANewRequestId());
    }
    

    @Test
    public void createCustomerAnswersNonNullCustomerWithIdFullResponse() throws Exception
    {
        Customer customer = createJaneDoe();
        Customer responseCustomer = (Customer) module.create(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
            WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(customer), module.generateANewRequestId(), null, true);
        
        assertEquals("Jane Doe QBW", responseCustomer.getName());

        module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
            WindowsEntityType.CUSTOMER, (Map<String, Object>)mom.map(responseCustomer), 
            module.generateANewRequestId()); 
    }
    
    @Test
    public void getCustomerAnswersNonNullCustomerWithId() throws Exception
    {
        Customer janeDoe = createJaneDoe();
        
        Customer createdCustomer = (Customer) module.create(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
            WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(janeDoe), module.generateANewRequestId(), null, true);

        Customer retrievedCustomer = (Customer) module.getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
            WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(createdCustomer.getId()));
        
        assertEquals(janeDoe.getName(), retrievedCustomer.getName());
        module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
            WindowsEntityType.CUSTOMER, (Map<String, Object>)mom.map(retrievedCustomer), 
            module.generateANewRequestId()); 
    }
    
    @Test
    public void modifyCustomer()
    {
        Customer janeDoe = createJaneDoe();
        Customer createdCustomer = (Customer) module.create(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
            WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(janeDoe), module.generateANewRequestId(), null, true);
        
        assertEquals(janeDoe.getName(), createdCustomer.getName());
        
        createdCustomer.setName("Jane Doe Modified");
        
        Customer updatedCustomer = (Customer) module.update(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
            WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(createdCustomer), 
            module.generateANewRequestId(), null, true);
        
        assertEquals("Jane Doe Modified", updatedCustomer.getName());
        
        module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
            WindowsEntityType.CUSTOMER, (Map<String, Object>)mom.map(updatedCustomer), 
            module.generateANewRequestId()); 
    }
    
    @Test
    public void getAllAccountsAnswersNonNullListWithCustomers() throws Exception
    {
        Iterable it = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.ACCOUNT, null);
        
        for (Object c : it)
        {
            System.out.println(((Account) c).getName());
        }
    }
    
//    @Test
//    public void getSomeAccountsAnswersNonNullListWithCustomers() throws Exception
//    {
//        CustomerQuery query = new CustomerQuery();
//        //query.
//        Iterable it = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
//            WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(query));
//        
//        for (Object c : it)
//        {
//            System.out.println(((Customer) c).getName());
//        }
//    }
//    
    @Test
    public void createSalesTermAnswersNonNullSalesTermWithId()
    {
        SalesTerm salesTerm = new SalesTerm(){{
           setName("Net 3");
           setType("Standard");
           setDiscountDays(BigInteger.valueOf(3));
           setDiscountPercent(BigDecimal.valueOf(15));
        }};
        SalesTerm createdSalesTerm = (SalesTerm) module.create(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
            WindowsEntityType.SALESTERM, (Map<String, Object>) mom.map(salesTerm), 
            module.generateANewRequestId(), null, true);
        
        assertEquals("Net 3", createdSalesTerm.getName());
        
        module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.SALESTERM, 
            (Map<String, Object>) mom.map(createdSalesTerm), module.generateANewRequestId());
    }

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
    @Test(expected = QuickBooksRuntimeException.class)
    public void createAccountThrowingExceptionForWrongCredentials()
    {
        QuickBooksWindowsModule module2;
        module2 = new QuickBooksWindowsModule();
        module2.setBaseUri("https://qbo.intuit.com/qbo1/rest/user/v2");
        module2.init();
        
        Customer responseCustomer = (Customer) module2.create(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
            WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(createJaneDoe()), module.generateANewRequestId(), null, true);
    }
    
    private Customer createJaneDoe()
    {
        return new Customer(){{
            setTypeOf(PartyType.PERSON);
            setName("Jane Doe QBW");
            getAddress().add(new PhysicalAddress(){{
                setLine1("5720 Peachtree Pkwy. 1");
                line2 = "Norcross";
                city = "Mountain View, CA 94043, CA 940";
                country = "USA";
                countrySubDivisionCode = "ON";
                postalCode = "94043";
                getTag().add("Billing");
            }});
            setDBAName("Mint");
            setAcctNum("23423423");
        }};
    }
}
