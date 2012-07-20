/**
 * Mule QuickBooks Connector
 * 
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 * 
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

/*
 * Copyright (c) 2011 Zauber S.A. -- All rights reserved
 */

package org.mule.modules.quickbooks.windows;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.modules.quickbooks.MapBuilder;
import org.mule.modules.quickbooks.api.exception.QuickBooksRuntimeException;
import org.mule.modules.quickbooks.windows.schema.Account;
import org.mule.modules.quickbooks.windows.schema.AccountQuery;
import org.mule.modules.quickbooks.windows.schema.AccountSubtypeEnum;
import org.mule.modules.quickbooks.windows.schema.AccountTypeEnum;
import org.mule.modules.quickbooks.windows.schema.Customer;
import org.mule.modules.quickbooks.windows.schema.CustomerQuery;
import org.mule.modules.quickbooks.windows.schema.DraftFilterEnumType;
import org.mule.modules.quickbooks.windows.schema.IdSet;
import org.mule.modules.quickbooks.windows.schema.Invoice;
import org.mule.modules.quickbooks.windows.schema.InvoiceHeader;
import org.mule.modules.quickbooks.windows.schema.InvoiceLine;
import org.mule.modules.quickbooks.windows.schema.InvoiceQuery;
import org.mule.modules.quickbooks.windows.schema.Item;
import org.mule.modules.quickbooks.windows.schema.ItemQuery;
import org.mule.modules.quickbooks.windows.schema.ItemTypeEnum;
import org.mule.modules.quickbooks.windows.schema.Money;
import org.mule.modules.quickbooks.windows.schema.NgIdSet;
import org.mule.modules.quickbooks.windows.schema.ObjectName;
import org.mule.modules.quickbooks.windows.schema.ObjectRef;
import org.mule.modules.quickbooks.windows.schema.PartyType;
import org.mule.modules.quickbooks.windows.schema.PhysicalAddress;
import org.mule.modules.quickbooks.windows.schema.SalesTerm;
import org.mule.modules.quickbooks.windows.schema.SyncActivityRequest;
import org.mule.modules.quickbooks.windows.schema.SyncActivityResponse;
import org.mule.modules.quickbooks.windows.schema.SyncStatusRequest;
import org.mule.modules.quickbooks.windows.schema.SyncStatusResponse;
import org.mule.modules.utils.mom.JaxbMapObjectMappers;

import com.zauberlabs.commons.mom.MapObjectMapper;

/**
 * 
 * 
 * @author Gaston Ponti
 * @since Sep 9, 2011
 */

@SuppressWarnings("unchecked")
public class QuickBooksWindowsModuleTestDriver {

    private static QuickBooksWindowsModule module;
    private static String appKey = System.getenv("appKey");
    private final String realmId = System.getenv("realmId");
    private final String realmIdPseudonym = System.getenv("realmIdPseudonym");
    private final String authIdPseudonym = System.getenv("authIdPseudonym");
    private final MapObjectMapper mom = JaxbMapObjectMappers.defaultWithPackage(
            "org.mule.modules.quickbooks.windows.schema").build();

    /**
     * 
     */
    @BeforeClass
    public static void setup() {
        module = new QuickBooksWindowsModule();
        module.setBaseUri("https://services.intuit.com/sb");
        module.init();
    }

    @Test
    @Ignore
    public void deleteInvoice() {
        InvoiceQuery query = new InvoiceQuery();

        Iterable<Invoice> iterable = module.findObjects(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, WindowsEntityType.INVOICE, (Map<String, Object>) mom.map(query));
        for (Invoice invoice : iterable) {
            module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.INVOICE,
                    (Map<String, Object>) mom.map(invoice));
        }
    }
    
    @Test
    @Ignore
    public void deleteItems() {
        ItemQuery query = new ItemQuery();

        Iterable<Item> iterable = module.findObjects(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, WindowsEntityType.ITEM, (Map<String, Object>) mom.map(query));
        for (Item item : iterable) {
            module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.ITEM,
                    (Map<String, Object>) mom.map(item));
        }
    }
    
    @Test
    @Ignore
    public void deleteCustomers() {
        CustomerQuery query = new CustomerQuery();

        Iterable<Customer> iterableCust = module.findObjects(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(query));
        for (Customer customer : iterableCust) {
            module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.CUSTOMER,
                    (Map<String, Object>) mom.map(customer));
        }
    }
    
    @Test
    @Ignore
    public void deleteAccounts() {
        AccountQuery query = new AccountQuery();

        Iterable<Account> iterable = module.findObjects(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, WindowsEntityType.ACCOUNT, (Map<String, Object>) mom.map(query));
        for (Account account : iterable) {
            module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.ACCOUNT,
                    (Map<String, Object>) mom.map(account));
        }
    }

    @Test
    public void createAndDeleteAnAccount()
    {
        Account account = new Account();
        account.setName("Test Account 1 QBW");
        account.setActive(true);
        account.setType(AccountTypeEnum.EXPENSE);
        account.setSubtype(AccountSubtypeEnum.EXPENSE.value());
        account.setAcctNum("6123123");
        account.setOpeningBalance(BigDecimal.valueOf(0));
        account.setOpeningBalanceDate("2012-04-04T00:00:00Z");
        
        Account createdAccount = (Account) module.create(realmId, appKey, realmIdPseudonym, authIdPseudonym, 
                WindowsEntityType.ACCOUNT, (Map<String, Object>) mom.map(account), false, true);
        
        assertEquals(account.getName(), createdAccount.getName());
        
        module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.ACCOUNT, (
                Map<String, Object>) mom.map(createdAccount));
    }
    
    @Test
    public void deleteCustomerSomeSpeficificCustomers() {
        Customer customerJane = createJaneDoe();
        // non draft
        final Customer createdNonDraftCustomer = (Customer) module.create(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(customerJane), null, true);

        // draft
        customerJane.setName("Jane Doe QBW DRAFT 1");
        final ObjectRef objRefDraft1 = (ObjectRef) module.create(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(customerJane), true, null);

        // draft
        customerJane.setName("Jane Doe QBW DRAFT 2");
        final ObjectRef objRefDraft2 = (ObjectRef) module.create(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(customerJane), true, null);

        CustomerQuery query = new CustomerQuery();

        // retrieve an especific list of Customers
        query.setListIdSet(new IdSet() {
            {
                getId().add(createdNonDraftCustomer.getId());
                getId().add(objRefDraft1.getId());
                getId().add(objRefDraft2.getId());
            }
        });

        // retrieve only the ones of that list that are draft Customers
        query.setDraftFilter(DraftFilterEnumType.DRAFT_ONLY);

        Iterable<Customer> iterableCust = module.findObjects(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(query));
        for (Customer customer : iterableCust) {
            assertTrue(customer.getName().contains("DRAFT"));
            module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.CUSTOMER,
                    (Map<String, Object>) mom.map(customer));
        }
        module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.CUSTOMER,
                (Map<String, Object>) mom.map(createdNonDraftCustomer));
    }

    @Test
    public void deleteACustomerWithItsIdType() {
        Customer customerJane = createJaneDoe();

        customerJane.setName("Jane Doe QBW Test delete 3");
        final ObjectRef objRef = (ObjectRef) module.create(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(customerJane), null, null);

        Customer aux = new Customer() {
            {
                setId(objRef.getId());
            }
        };

        module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.CUSTOMER,
                (Map<String, Object>) mom.map(aux));

        Customer customer = (Customer) module.getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym,
                WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(objRef.getId()));

        // was deleted before...
        assertNull(customer);
    }

    @Test
    public void createAccountAskingForFullResponse() {
        Map<String, Object> mapAccount = new MapBuilder().with("name", "Test Account 2 QBW")
                .with("active", true).with("type", AccountTypeEnum.EXPENSE)
                .with("subtype", AccountSubtypeEnum.EXPENSE.value()).with("acctNum", "9919823")
                .with("openingBalance", 0).with("openingBalanceDate", "2012-02-02T00:00:00Z").build();
        Account acc = (Account) module.create(realmId, appKey, realmIdPseudonym, authIdPseudonym,
                WindowsEntityType.ACCOUNT, mapAccount, null, true);

        assertNotNull(acc.getId());
        module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.ACCOUNT,
                (Map<String, Object>) mom.map(acc));
    }

    @Test
    public void createCustomerAnswersNonNullCustomerWithIdFullResponse() throws Exception {
        Customer customer = createJaneDoe();
        Customer responseCustomer = (Customer) module.create(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(customer),
                null, true);

        assertEquals(customer.getName(), responseCustomer.getName());

        module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.CUSTOMER,
                (Map<String, Object>) mom.map(responseCustomer));
    }

    @Test
    public void getCustomerAnswersNonNullCustomerWithId() throws Exception {
        Customer janeDoe = createJaneDoe();

        Customer createdCustomer = (Customer) module.create(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(janeDoe),
                null, true);

        Customer retrievedCustomer = (Customer) module.getObject(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, WindowsEntityType.CUSTOMER,
                (Map<String, Object>) mom.map(createdCustomer.getId()));

        assertEquals(janeDoe.getName(), retrievedCustomer.getName());
        module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.CUSTOMER,
                (Map<String, Object>) mom.map(retrievedCustomer));
    }

    @Test
    public void modifyCustomer() {
        Customer janeDoe = createJaneDoe();
        Customer createdCustomer = (Customer) module.create(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(janeDoe),
                null, true);

        assertEquals(janeDoe.getName(), createdCustomer.getName());

        createdCustomer.setName("Jane Doe Modified");

        Customer updatedCustomer = (Customer) module.update(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(createdCustomer),
                null, true);

        assertEquals(createdCustomer.getName(), updatedCustomer.getName());

        module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.CUSTOMER,
                (Map<String, Object>) mom.map(updatedCustomer));
    }

    @Test
    public void getAllAccountsAnswersNonNullListWithCustomers() throws Exception {
        Iterable<Account> it = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym,
                WindowsEntityType.ACCOUNT, null);

        for (Account c : it) {
            assertNotNull(c.getId());
        }
    }

    @Test
    public void createSalesTermAnswersNonNullSalesTermWithId() {
        SalesTerm salesTerm = new SalesTerm() {
            {
                setName("Net 3");
                setType("Standard");
                setDiscountDays(BigInteger.valueOf(3));
                setDiscountPercent(BigDecimal.valueOf(15));
            }
        };
        SalesTerm createdSalesTerm = (SalesTerm) module.create(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, WindowsEntityType.SALESTERM, (Map<String, Object>) mom.map(salesTerm),
                null, true);

        assertEquals(salesTerm.getName(), createdSalesTerm.getName());

        module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.SALESTERM,
                (Map<String, Object>) mom.map(createdSalesTerm));
    }

    @Test
    public void retrievesAEmptyIterable() {
        CustomerQuery query = new CustomerQuery();
        query.setFirstLastName("MFASDAEAEAAASS091823j09as");

        Iterable<Customer> it = module.findObjects(realmId, appKey, realmIdPseudonym, authIdPseudonym,
                WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(query));

        assertEquals(false, it.iterator().hasNext());
    }

    @Test
    public void createInvoiceAndUpdateIt() {
        // creates a customer
        final Customer createdCustomer = (Customer) module.create(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(createJaneDoe()),
                null, true);

        // create an item
        final Item item = new Item() {
            {
                setName("ItemTestQBW0058");
                setType(ItemTypeEnum.GROUP);
                setUnitPrice(new Money() {
                    {
                        setAmount(BigDecimal.valueOf(100));
                    }
                });
                setTaxable(false);
            }
        };

        final Item createdItem = (Item) module.create(realmId, appKey, realmIdPseudonym, authIdPseudonym,
                WindowsEntityType.ITEM, (Map<String, Object>) mom.map(item),
                null, true);

        // create an invoice with the customer and item created before
        Invoice invoice = new Invoice() {
            {
                setHeader(new InvoiceHeader() {
                    {
                        setCustomerId(createdCustomer.getId());
                        setDocNumber("DOC-QBW:001");
                    }
                });
                getLine().add(new InvoiceLine() {
                    {
                        setAmount(BigDecimal.valueOf(100));
                        setItemId(createdItem.getId());
                    }
                });
            }
        };

        Invoice createdInvoice = (Invoice) module.create(realmId, appKey, realmIdPseudonym, authIdPseudonym,
                WindowsEntityType.INVOICE, (Map<String, Object>) mom.map(invoice),
                null, true);

        // change the docNumber and update it
        createdInvoice.getHeader().setDocNumber("DOC-QBW:N02");
        Invoice updatedInvoice = (Invoice) module.create(realmId, appKey, realmIdPseudonym, authIdPseudonym,
                WindowsEntityType.INVOICE, (Map<String, Object>) mom.map(createdInvoice),
                null, true);

        // delete everything
        module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.INVOICE,
                (Map<String, Object>) mom.map(updatedInvoice));
        module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.ITEM,
                (Map<String, Object>) mom.map(createdItem));
        module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.CUSTOMER,
                (Map<String, Object>) mom.map(createdCustomer));

        // verify the change
        assertEquals(createdInvoice.getHeader().getDocNumber(), updatedInvoice.getHeader().getDocNumber());
    }

    @Test
    public void retrieveStatusFromASpecificCustomer() {
        SyncStatusRequest syncStatusRequest = new SyncStatusRequest();
        syncStatusRequest.getNgIdSet().add(new NgIdSet() {
            {
                setNgObjectType(ObjectName.CUSTOMER);
                setNgId("2948729");
            }
        });
        List<SyncStatusResponse> list = module.status(realmId, appKey, realmIdPseudonym, authIdPseudonym,
                (Map<String, Object>) mom.map(syncStatusRequest));

        for (SyncStatusResponse sr : list) {
            assertEquals("2948729", sr.getNgIdSet().getNgId());
            assertEquals(ObjectName.CUSTOMER, sr.getNgIdSet().getNgObjectType());
        }
    }

    @Test
    public void retrieveAllStatus() {
        SyncStatusRequest syncStatusRequest = new SyncStatusRequest();

        List<SyncStatusResponse> list = module.status(realmId, appKey, realmIdPseudonym, authIdPseudonym,
                (Map<String, Object>) mom.map(syncStatusRequest));

        assertTrue(list.size()!=0);
        
        for (SyncStatusResponse sr : list) {
            assertNotNull(sr);
        }
    }

    @Ignore
    @Test
    public void followTheRequestId() {
        String requestId = module.generateANewRequestId();
        Customer createdCustomer = (Customer) module.create(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, WindowsEntityType.CUSTOMER, (Map<String, Object>) mom.map(createJaneDoe()),
                null, true);

        SyncStatusRequest syncStatusRequest = new SyncStatusRequest();
        syncStatusRequest.getRequestId().add(requestId);

        List<SyncStatusResponse> list = module.status(realmId, appKey, realmIdPseudonym, authIdPseudonym,
                (Map<String, Object>) mom.map(syncStatusRequest));

        for (SyncStatusResponse sr : list) {
            assertEquals(requestId, sr.getRequestId());
        }

        module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.CUSTOMER,
                (Map<String, Object>) mom.map(createdCustomer));
    }

    @Test
    public void retrieveSyncActivity() {
        SyncActivityRequest syncActivityRequest = new SyncActivityRequest();

        List<SyncActivityResponse> list = module.syncActivity(realmId, appKey, realmIdPseudonym,
                authIdPseudonym, (Map<String, Object>) mom.map(syncActivityRequest));

        for (SyncActivityResponse sr : list) {
            assertNotNull(sr.getSyncType());
        }
    }

    // @Test
    // public void revertObject()
    // {
    // Vendor vendor = new Vendor(){{
    // setTypeOf(PartyType.PERSON);
    // setName("John Doe");
    // setDBAName("John");
    // setAcctNum("9001");
    // }};
    //
    // final Vendor createdVendor = (Vendor) module.create(realmId, appKey,
    // realmIdPseudonym, authIdPseudonym,
    // WindowsEntityType.VENDOR, (Map<String, Object>) mom.map(vendor),
    // module.generateANewRequestId(), null, true);
    //
    // Item item = new Item(){{
    // setName("ItemTestQBW0054");
    // setType(ItemTypeEnum.GROUP);
    // setUnitPrice(new Money(){{
    // setAmount(BigDecimal.valueOf(100));
    // }});
    // setTaxable(false);
    // }};
    //
    // final Item createdItem = (Item) module.create(realmId, appKey,
    // realmIdPseudonym, authIdPseudonym,
    // WindowsEntityType.ITEM, (Map<String, Object>) mom.map(item),
    // module.generateANewRequestId(), null, true);
    //
    // final Customer createdCustomer = (Customer) module.create(realmId,
    // appKey, realmIdPseudonym, authIdPseudonym,
    // WindowsEntityType.CUSTOMER, (Map<String, Object>)
    // mom.map(createJaneDoe()),
    // module.generateANewRequestId(), null, true);
    //
    // TimeActivity timeActivity = new TimeActivity(){{
    // setNameOf(TimeActivityTypeEnum.VENDOR);
    // setEmployee(new EmployeeRef(){{
    // setEmployeeId(createdVendor.getId());
    // }});
    // setCustomerId(createdCustomer.getId());
    // setItemId(createdItem.getId());
    // setDescription("Some Description");
    // }};
    //
    //
    // TimeActivity createdTimeActivity = (TimeActivity) module.create(realmId,
    // appKey, realmIdPseudonym, authIdPseudonym,
    // WindowsEntityType.TIMEACTIVITY, (Map<String, Object>)
    // mom.map(timeActivity), module.generateANewRequestId(), true, true);
    //
    // String auxName = createdTimeActivity.getDescription();
    //
    // createdTimeActivity.setDescription("Changing the description");
    // TimeActivity updatedTimeActivity = (TimeActivity) module.update(realmId,
    // appKey, realmIdPseudonym, authIdPseudonym,
    // WindowsEntityType.TIMEACTIVITY, (Map<String, Object>)
    // mom.map(createdTimeActivity),
    // module.generateANewRequestId(), true, true);
    //
    // updatedTimeActivity.setDescription("Changing the description 2nd");
    // TimeActivity updatedTimeActivity2 = (TimeActivity) module.update(realmId,
    // appKey, realmIdPseudonym, authIdPseudonym,
    // WindowsEntityType.TIMEACTIVITY, (Map<String, Object>)
    // mom.map(updatedTimeActivity),
    // module.generateANewRequestId(), false, true);
    //
    // assertFalse(auxName.equals(updatedTimeActivity2.getDescription()));
    //
    // module.revert(realmId, appKey, realmIdPseudonym, authIdPseudonym,
    // WindowsEntityType.TIMEACTIVITY,
    // (Map<String, Object>) mom.map(updatedTimeActivity2),
    // module.generateANewRequestId());
    //
    // TimeActivity retrievedTimeActivity = (TimeActivity)
    // module.getObject(realmId, appKey, realmIdPseudonym, authIdPseudonym,
    // WindowsEntityType.TIMEACTIVITY, (Map<String, Object>)
    // mom.map(updatedTimeActivity2.getId()));
    //
    // module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym,
    // WindowsEntityType.TIMEACTIVITY,
    // (Map<String, Object>) mom.map(retrievedTimeActivity),
    // module.generateANewRequestId());
    // module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym,
    // WindowsEntityType.ITEM,
    // (Map<String, Object>) mom.map(createdItem),
    // module.generateANewRequestId());
    // module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym,
    // WindowsEntityType.VENDOR,
    // (Map<String, Object>) mom.map(createdVendor),
    // module.generateANewRequestId());
    // module.delete(realmId, appKey, realmIdPseudonym, authIdPseudonym,
    // WindowsEntityType.CUSTOMER,
    // (Map<String, Object>) mom.map(createdCustomer),
    // module.generateANewRequestId());
    //
    // assertEquals(auxName, retrievedTimeActivity.getDescription());
    // }

    @Test(expected = QuickBooksRuntimeException.class)
    @Ignore
    public void createAccountThrowingExceptionForWrongCredentials() {
        QuickBooksWindowsModule module2;
        module2 = new QuickBooksWindowsModule();
        module2.setBaseUri("https://qbo.intuit.com/qbo1/rest/user/v2");
        module2.init();

        module2.create(realmId, appKey, realmIdPseudonym, authIdPseudonym, WindowsEntityType.CUSTOMER,
                (Map<String, Object>) mom.map(createJaneDoe()), null, true);
    }

    private Customer createJaneDoe() {
        return new Customer() {
            {
                setTypeOf(PartyType.PERSON);
                setName("Jane Doe QBW test106");
                getAddress().add(new PhysicalAddress() {
                    {
                        setLine1("5720 Peachtree Pkwy. 2");
                        setLine2("Norcross1");
                        setCity("Mountain View, CA 94043, CA 940");
                        setCountry("USA");
                        setCountrySubDivisionCode("ON");
                        setPostalCode("94042");
                        getTag().add("Billing");
                    }
                });
                setDBAName("Mint");
                setAcctNum("23423423");
            }
        };
    }
}
