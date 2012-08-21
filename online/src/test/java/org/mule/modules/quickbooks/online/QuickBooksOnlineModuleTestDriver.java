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

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.modules.quickbooks.MapBuilder;
import org.mule.modules.quickbooks.api.exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.online.model.QBAccount;
import org.mule.modules.quickbooks.online.model.QBCustomer;
import org.mule.modules.quickbooks.online.model.QBIdType;
import org.mule.modules.quickbooks.online.model.QBInvoice;
import org.mule.modules.quickbooks.online.model.QBItem;
import org.mule.modules.quickbooks.online.model.QBSalesTerm;
import org.mule.modules.quickbooks.online.schema.Account;
import org.mule.modules.quickbooks.online.schema.Customer;
import org.mule.modules.quickbooks.online.schema.GenericEntity;
import org.mule.modules.quickbooks.online.schema.IdType;
import org.mule.modules.quickbooks.online.schema.Invoice;
import org.mule.modules.quickbooks.online.schema.InvoiceHeader;
import org.mule.modules.quickbooks.online.schema.InvoiceLine;
import org.mule.modules.quickbooks.online.schema.Item;
import org.mule.modules.quickbooks.online.schema.Money;
import org.mule.modules.quickbooks.online.schema.Note;
import org.mule.modules.quickbooks.online.schema.PhysicalAddress;
import org.mule.modules.quickbooks.online.schema.SalesTerm;
import org.mule.modules.utils.mom.JaxbMapObjectMappers;

import com.zauberlabs.commons.mom.MapObjectMapper;


/**
 * 
 * 
 * @author Gaston Ponti
 * @since Sep 9, 2011
 */

public class QuickBooksOnlineModuleTestDriver
{

    private static QuickBooksModule module;
    private static String appKey = System.getenv("appKey");
    private final String realmId = System.getenv("realmId");
    private final String realmIdPseudonym = System.getenv("realmIdPseudonym");
    private final String authIdPseudonym = System.getenv("authIdPseudonym");
    private final MapObjectMapper mom = JaxbMapObjectMappers.defaultWithPackage("org.mule.modules.quickbooks.online.schema").build();
    
    /**
     * 
     */
    @BeforeClass
    public static void setup()
    {
        module = new QuickBooksModule();
        module.setBaseUri("https://qbo.intuit.com/qbo1/rest/user/v2");
        module.init();
    }
    
    @Test
    public void createAccount()
    {
        Account newAccount = new Account();
        newAccount.setName("Test Account82");
        newAccount.setSubtype(AccountOnlineDetail.SAVINGS.toString());
        newAccount.setAcctNum("36544");
        newAccount.setOpeningBalance(new BigDecimal(0));
        QBAccount acc = module.createAccount(realmId, appKey, realmIdPseudonym, authIdPseudonym, new QBAccount(newAccount));
                
        IdType idType = new IdType();
        idType.setValue(acc.getAccount().getId().getValue());
        
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.ACCOUNT, new QBIdType(idType), acc.getAccount().getSyncToken());
    }
    @Test
    public void createCustomerAnswersNonNullCustomerWithId() throws Exception
    {
        Customer customer = new Customer();
        
        customer.setName("Name");
        customer.setGivenName("GivenName");
        customer.setMiddleName("MiddleName");
        customer.setFamilyName("FamilyName");
        
        QBCustomer c = module.createCustomer(realmId, appKey, realmIdPseudonym, authIdPseudonym,
                new QBCustomer(customer));
        
        assertEquals("Name", c.getCustomer().getName());
        assertNotNull(c.getCustomer().getId());

        IdType idType = new IdType();
        idType.setValue(c.getCustomer().getId().getValue());
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, new QBIdType(idType), c.getCustomer().getSyncToken());
    }
    
    @Test
    @Ignore
    public void testname() throws Exception
    {
        
     List<Map<String, Object>> auxList = new ArrayList<Map<String, Object>>();
        
        Map<String, Object> auxMap = new HashMap<String, Object>();
        
        auxMap.put("Line1", null);
        auxMap.put("Line2", null);
        auxMap.put("City", null);
        auxMap.put("CountrySubDivisionCode", null);
        auxMap.put("PostalCode", null);
        auxMap.put("Tag", "Billing");
        
        auxList.add(auxMap);

        Customer c = (Customer) mom.unmap(
                new MapBuilder()
                .with("name", "Susana")
                .with("givenName", "Susana")
                .with("middleName", "Melina")
                .with("familyName", "Perez")
                .with("suffix", null)
                .with("DBAName", null)
                .with("showAs", null)
                .with("webSite", new ArrayList<Map<String, Object>>())
                .with("salesTermId", null)
                .with("salesTaxCodeId", null)
                .with("email", new ArrayList<String>())
                .with("phone", new ArrayList<Map<String, Object>>())
                .with("address", auxList)
                .build(), Customer.class
                );
        
        PhysicalAddress ph = c.getAddress().get(0);
        
        assertEquals(ph.getTag(), "Billing");
    }
    
    @Test
    public void getCustomerAnswersNonNullCustomerWithId() throws Exception
    {
        IdType idType = new IdType();
        idType.setValue("1");
        Customer c = (Customer) module.getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, new QBIdType(idType));
        
        assertEquals("Ricardo (deleted)", c.getName());
        assertNotNull(c.getId());
    }
    
    @Test
    public void modifyCustomer()
    {
        
        Customer customer = new Customer();
        
        customer.setName("Name");
        customer.setGivenName("GivenName");
        customer.setMiddleName("MiddleName");
        customer.setFamilyName("FamilyName");
        
        QBCustomer c = module.createCustomer(realmId, appKey, realmIdPseudonym, authIdPseudonym,
                new QBCustomer(customer));
        
        assertEquals("FamilyName", c.getCustomer().getFamilyName());
        
        IdType idType = new IdType();
        idType.setValue(c.getCustomer().getId().getValue());
        
        c.getCustomer().setFamilyName("NewFamilyName");
        
        module.updateCustomer(realmId, appKey, realmIdPseudonym, authIdPseudonym, c);
        Customer c3 = (Customer) module.getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, new QBIdType(idType));
        
        assertEquals("NewFamilyName", c3.getFamilyName());
        
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, new QBIdType(idType), null);
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void getAllCustomersAnswersNonNullListWithCustomers() throws Exception
    {       
        Iterable<Customer> it = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
                OnlineEntityType.CUSTOMER, null, null);
        
        for (Customer c : it)
        {
            assertNotNull(c.getId());
        }
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void getSomeCustomersAnswersNonNullListWithCustomers() throws Exception
    {
        Iterable<Customer> it = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
                OnlineEntityType.CUSTOMER, "GivenName :EQUALS: Susana", null);
        
        for (Customer c : it)
        {
            assertNotNull(c.getId());
        }
    }
    
    @Test
    public void createSalesTermAnswersNonNullSalesTermWithId()
    {
        SalesTerm salesTerm = new SalesTerm();
        salesTerm.setName("SalesTerm");
        salesTerm.setDueDays(BigInteger.valueOf(3));
        salesTerm.setDayOfMonthDue(BigInteger.valueOf(2));
        
        QBSalesTerm qbSalesTerm = module.createSalesTerm(realmId, appKey, realmIdPseudonym, authIdPseudonym, new QBSalesTerm(salesTerm));
        
        assertEquals("SalesTerm", qbSalesTerm.getSalesTerm().getName());
        IdType idType = new IdType();
        idType.setValue(qbSalesTerm.getSalesTerm().getId().getValue());
        
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
                OnlineEntityType.SALESTERM, new QBIdType(idType), null);
    }

    @Test
    public void retrievesAEmptyIterable()
    {
        @SuppressWarnings("unchecked")
        Iterable<Customer> it = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
                OnlineEntityType.CUSTOMER, "Name :EQUALS: MFASDAEAEAAASS", null);

        assertEquals(false, it.iterator().hasNext());
    }
    
    @SuppressWarnings("unchecked")
    @Test
    @Ignore
    public void deleteCustomer()
    {        
        Iterable<Customer> it= module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
                OnlineEntityType.CUSTOMER, "Name :EQUALS: Paul M. Jenkins 4", null);
        
        for (Customer customer: it)
        {
            module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
                    OnlineEntityType.CUSTOMER, new QBIdType(customer.getId()), customer.getSyncToken());
        }
    }
    
    @SuppressWarnings("unchecked")
    @Test
    @Ignore
    public void deleteItem()
    {        
        Iterable<Item> it= module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
                OnlineEntityType.ITEM, "Name :EQUALS: ItemTest0057", null);
        
        for (Item item: it)
        {
            module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
                    OnlineEntityType.ITEM, new QBIdType(item.getId()), item.getSyncToken());
        }
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void createInvoiceRetrieveAndUpdateIt()
    {
        
        Customer customer = new Customer();
        
        customer.setName("Paul M. Jenkins 4");
        customer.setGivenName("Paul");
        customer.setMiddleName("Mark");
        customer.setFamilyName("Jenkins");
        
        module.createCustomer(realmId, appKey, realmIdPseudonym, authIdPseudonym,
                new QBCustomer(customer));
        
        Item item = new Item();
        item.setName("ItemTest0057");
        
        Money money = new Money();
        money.setAmount(BigDecimal.valueOf(100));
        item.setUnitPrice(money);
        
        QBItem qbItem = module.createItem(realmId, appKey, realmIdPseudonym, authIdPseudonym, new QBItem(item));
        
        //create an invoice with the customer and item created before
        InvoiceHeader invHeader = new InvoiceHeader();
        invHeader.setCustomerId(customer.getId());
        invHeader.setDocNumber("DOC-00000010101");
        
        List<InvoiceLine> lines = new ArrayList<InvoiceLine>();
        InvoiceLine invoiceLine = new InvoiceLine();
        invoiceLine.setAmount(new BigDecimal(100));
        invoiceLine.setItemId(qbItem.getItem().getId());
        lines.add(invoiceLine);
        
        Invoice invoice = new Invoice();
        invoice.getLine().addAll(lines);
        invoice.setHeader(invHeader);
        
        //retrieve the invoices of our customer
        String filter = "CustomerId :EQUALS: " + customer.getId().getValue();
        Iterable<Invoice> iterableInv = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
                OnlineEntityType.INVOICE, filter, null);

        //We know that only has one invoice, because we have created him
        invoice = iterableInv.iterator().next();
        
        //change the docNumber and update it
        invoice.getHeader().setDocNumber("DOC-NEW:001111111101");
        module.updateInvoice(realmId, appKey, realmIdPseudonym, authIdPseudonym, new QBInvoice(invoice));
        
        //delete everything
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.INVOICE, 
                new QBIdType(invoice.getId()), invoice.getSyncToken());
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.ITEM, 
                new QBIdType(qbItem.getItem().getId()), item.getSyncToken());
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, OnlineEntityType.CUSTOMER, 
                new QBIdType(customer.getId()), customer.getSyncToken());
    
        //verify the change
        assertEquals("DOC-NEW:001111111101", invoice.getHeader().getDocNumber());
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void findChangeDataDeleted()
    {
        Iterable<GenericEntity> it = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
            OnlineEntityType.CHANGEDATADELETED, 
            "Entity :in: (Customer, Invoice, Item) :and: LastUpdatedTime :after: 2011-06-30T01:00:00-0700", null);
        
        for(GenericEntity ge : it)
        {
            assertTrue(ge.getEntityType().value().equals("Customer") || ge.getEntityType().value().equals("Invoice") 
                    || ge.getEntityType().value().equals("Item"));
        }
    }
    
    @Test
    public void testIfTheNotesHasBeenSaved()
    {
        List<Note> notes = new ArrayList<Note>();
        Note note = new Note();
        note.setContent("This is a test note");
        notes.add(note);
        
        Customer customer = new Customer();
        
        customer.setName("Name");
        customer.setGivenName("GivenName");
        customer.setMiddleName("MiddleName");
        customer.setFamilyName("FamilyName");
        customer.getNotes().addAll(notes);
        
        module.createCustomer(realmId, appKey, realmIdPseudonym, authIdPseudonym,
                new QBCustomer(customer));
        
        assertEquals(1, customer.getNotes().size());
        assertEquals("This is a test note", customer.getNotes().get(0).getContent());
        
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
                OnlineEntityType.CUSTOMER, new QBIdType(customer.getId()), customer.getSyncToken());
    }
    
    @Test
    @Ignore
    public void testASecondCompany()
    {
        String appKey2 = System.getenv("appKey");
        String realmId2 = System.getenv("realmId2");
        String realmIdPseudonym2 = System.getenv("realmIdPseudonym2");
        String authIdPseudonym2 = System.getenv("authIdPseudonym2");

        Account newAccount = new Account();
        newAccount.setName("Test Account82");
        newAccount.setSubtype(AccountOnlineDetail.SAVINGS.toString());
        newAccount.setAcctNum("36544");
        newAccount.setOpeningBalance(new BigDecimal(0));
        QBAccount acc = module.createAccount(realmId, appKey, realmIdPseudonym, authIdPseudonym, new QBAccount(newAccount));
                    
        IdType idType = new IdType();
        idType.setValue(acc.getAccount().getId().getValue());
        
        newAccount = new Account();
        newAccount.setName("Test Account82");
        newAccount.setSubtype(AccountOnlineDetail.SAVINGS.toString());
        newAccount.setAcctNum("36544");
        newAccount.setOpeningBalance(new BigDecimal(0));
        QBAccount acc2 = module.createAccount(realmId, appKey, realmIdPseudonym, authIdPseudonym, new QBAccount(newAccount));
                    
        IdType idType2 = new IdType();
        idType2.setValue(acc2.getAccount().getId().getValue());
            
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
                OnlineEntityType.ACCOUNT, new QBIdType(idType), acc.getAccount().getSyncToken());
        module.deleteObject(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2, 
                OnlineEntityType.ACCOUNT, new QBIdType(idType2), acc2.getAccount().getSyncToken());
    }
    
    @SuppressWarnings("unchecked")
    @Test
    @Ignore
    public void testCallBetweenLazyRetrieve()
    {
        String appKey2 = System.getenv("appKey");
        String realmId2 = System.getenv("realmId2");
        String realmIdPseudonym2 = System.getenv("realmIdPseudonym2");
        String authIdPseudonym2 = System.getenv("authIdPseudonym2");
        
        Iterable<Account> it = module.findObjects(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2, 
                OnlineEntityType.ACCOUNT, null, null);
        
        Iterator<Account> itAcc = it.iterator();
        assertNotNull(itAcc.next().getId());
        
        Account newAccount = new Account();
        newAccount.setName("Test Account82");
        newAccount.setSubtype(AccountOnlineDetail.SAVINGS.toString());
        newAccount.setAcctNum("36544");
        newAccount.setOpeningBalance(new BigDecimal(0));
        QBAccount acc = module.createAccount(realmId, appKey, realmIdPseudonym, authIdPseudonym, new QBAccount(newAccount));
        
        while(itAcc.hasNext()) {
            assertNotNull(itAcc.next().getId());
        }
        
        IdType idType = new IdType();
        idType.setValue(acc.getAccount().getId().getValue());
            
        module.deleteObject(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
                OnlineEntityType.ACCOUNT, new QBIdType(idType), acc.getAccount().getSyncToken());
    }
    
    @Test
    @Ignore
    public void testCreate20Accounts()
    {
        String appKey2 = System.getenv("appKey");
        String realmId2 = System.getenv("realmId2");
        String realmIdPseudonym2 = System.getenv("realmIdPseudonym2");
        String authIdPseudonym2 = System.getenv("authIdPseudonym2");
        
        Account acc = new Account();
        
        for (int i = 0;i<20;i++) {
            acc.setName("Test Account" + i);
            acc.setSubtype(AccountOnlineDetail.SAVINGS.toString());
            acc.setAcctNum("000" + i);
            acc.setOpeningBalance(new BigDecimal(0));
            module.createAccount(realmId2, appKey2, realmIdPseudonym2, authIdPseudonym2, new QBAccount(acc));
        }
    }
    
    @Test(expected = QuickBooksRuntimeException.class)
    public void createAccountThrowingExceptionForWrongCredentials()
    {
        QuickBooksModule module2;
        module2 = new QuickBooksModule();
        module2.setBaseUri("https://qbo.intuit.com/qbo1/rest/user/v2");
        module2.init();
        
        Account acc = new Account();
        acc.setName("Test Account");
        acc.setSubtype(AccountOnlineDetail.SAVINGS.toString());
        acc.setAcctNum("36547");
        acc.setOpeningBalance(new BigDecimal(0));       
    }
    
}
