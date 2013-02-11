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

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mule.api.store.ObjectStoreException;
import org.mule.modules.quickbooks.api.ObjectStoreHelper;
import org.mule.modules.quickbooks.api.model.AppMenuInformation;
import org.mule.modules.quickbooks.api.model.UserInformation;
import org.mule.modules.quickbooks.api.oauth.OAuthCredentials;
import org.mule.modules.quickbooks.api.oauth.QuickBooksOAuthClient;
import org.mule.modules.quickbooks.api.oauth.QuickBooksObjectStore;
import org.mule.modules.quickbooks.api.openid.DefaultOpenIDClient;
import org.mule.modules.quickbooks.api.openid.OpenIDCredentials;
import org.mule.modules.quickbooks.online.api.QuickBooksOnlineClient;
import org.mule.modules.quickbooks.online.schema.*;
import org.openid4java.message.MessageException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Mulesoft Inc
 */
@SuppressWarnings("unused")
public class QuickBooksOnlineTest {

    @Mock
    private QuickBooksOnlineClient quickBooksOnlineClient;
    @Mock
    private QuickBooksOAuthClient quickBooksOAuthClient;
    @Mock
    private DefaultOpenIDClient quickBooksOpenIdClient;

    private QuickBooksOnlineModule module;
    private ObjectStoreHelper objectStoreHelper;

    private static final String CONSUMER_KEY = "consumerkey";
    private static final String CONSUMER_SECRET = "consumersecret";
    private static final String ACCESS_TOKEN_ID_PREFIX = "qbo_";
    private static final boolean VERIFY_OPEN_ID_RESPONSE = false;
    private static final String REQUEST_TOKEN_URL = "REQUEST_TOKEN_URL";
    private static final String ACCESS_TOKEN_URL = "ACCESS_TOKEN_URL";
    private static final String AUTHORIZATION_URL = "AUTHORIZATION_URL";
    private static final String CALLBACK_URL = "CALLBACK_URL";
    private static final String REQUEST_TOKEN_ID = "REQUEST_TOKEN_ID";
    private static final String AUTH_URL = "AUTH_URL";
    private static final String ACCESS_TOKEN = "accesstoken";
    private static final String ACCESS_TOKEN_SECRET = "accesstokensecret";
    private static final String OAUTH_VERIFIER = "VERIFIER";
    private static final String PROVIDER_URL = "PROVIDER_URL";
    private static final String RETURN_URL = "RETURN_URL";
    private static final String OPEN_ID_AUTH_URL = "OPEN_ID_AUTH_URL";
    private static final String RECEIVING_URL = "RECEIVING_URL";
    private static final String OPENID_EMAIL = "muleftw@mulesoft.com";
    private static final String API_URL = "http://api.com";
    private static final String USER_IDENTIFIER = "myuser";
    private static final String ACCESS_TOKEN_ID = "ACCESS_TOKEN_ID";
    private static final OAuthCredentials OAUTH_CREDENTIALS = new OAuthCredentials(ACCESS_TOKEN, ACCESS_TOKEN_SECRET);
    private static final String SYNC_TOKEN = "SYNC_TOKEN";
    private static final String QUERY_FILTER = "QUERY_FILTER";
    private static final String QUERY_SORT = "QUERY_SORT";
    private static final String ANY_REGEX = "ANY_REGEX";

    @Before
    public void setup() throws ObjectStoreException {
        MockitoAnnotations.initMocks(this);
        objectStoreHelper = new ObjectStoreHelper(new QuickBooksObjectStore());
        module = new QuickBooksOnlineModule();
        module.setClient(quickBooksOnlineClient);
        module.setoAuthClient(quickBooksOAuthClient);
        module.setOpenIDClient(quickBooksOpenIdClient);
        module.setObjectStoreHelper(objectStoreHelper);
        module.setConsumerKey(CONSUMER_KEY);
        module.setConsumerSecret(CONSUMER_SECRET);
        module.setAccessTokenIdentifierPrefix(ACCESS_TOKEN_ID_PREFIX);
        module.setVerifyOpenIdResponse(VERIFY_OPEN_ID_RESPONSE);
        storeAccessToken();
    }

    @Test
    public void testAuthUser() throws ObjectStoreException, OAuthExpectationFailedException,
            OAuthMessageSignerException, OAuthCommunicationException, OAuthNotAuthorizedException {
        when(quickBooksOAuthClient.authorize(REQUEST_TOKEN_URL, ACCESS_TOKEN_URL, AUTHORIZATION_URL, CALLBACK_URL,
                REQUEST_TOKEN_ID)).thenReturn(AUTH_URL);
        assertEquals(AUTH_URL, module.authUser(REQUEST_TOKEN_URL, ACCESS_TOKEN_URL, AUTHORIZATION_URL,
                CALLBACK_URL, REQUEST_TOKEN_ID, createMap()));
    }

    @Test
    public void testGetAccessToken() throws ObjectStoreException, OAuthExpectationFailedException,
            OAuthMessageSignerException, OAuthCommunicationException, OAuthNotAuthorizedException {
        when(quickBooksOAuthClient.getAccessToken(OAUTH_VERIFIER, REQUEST_TOKEN_ID)).
                thenReturn(OAUTH_CREDENTIALS);
        assertEquals(module.getAccessToken(API_URL, OAUTH_VERIFIER, REQUEST_TOKEN_ID, USER_IDENTIFIER).getAccessToken(),
                OAUTH_CREDENTIALS.getAccessToken());
    }

    @Test
    public void testOpenIdInitialize() throws ObjectStoreException {
        when(quickBooksOpenIdClient.initialize(PROVIDER_URL, RETURN_URL, VERIFY_OPEN_ID_RESPONSE)).
                thenReturn(OPEN_ID_AUTH_URL);
        assertEquals(OPEN_ID_AUTH_URL, module.openIdInitialize(PROVIDER_URL, RETURN_URL, createMap()));
    }

    @Test
    public void testVerifyOpenId() throws ObjectStoreException, MessageException {
        when(quickBooksOpenIdClient.verifyOpenIDFromIntuit(RECEIVING_URL, createParamMaps(), VERIFY_OPEN_ID_RESPONSE)).
                thenReturn(createOpenIdCredentials());
        assertEquals(createOpenIdCredentials().getEmail(),
                module.verifyOpenId(null, RECEIVING_URL, createParamMaps()).getEmail());
    }

    @Test
    public void testCreateAccount() {
        Account account = new Account();
        account.setName("Testing account");
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, account)).thenReturn(account);
        assertEquals(account.getName(), module.createAccount(ACCESS_TOKEN_ID, account).getName());
    }

    @Test
    public void testCreateBill() {
        Bill bill = new Bill();
        IdType id = new IdType();
        id.setValue("newBill");
        bill.setId(id);
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, bill)).thenReturn(bill);
        assertEquals(bill.getId().getValue(), module.createBill(ACCESS_TOKEN_ID, bill).getId().getValue());
    }

    @Test
    public void testCreateBillPayment() {
        BillPayment billPayment = new BillPayment();
        IdType id = new IdType();
        id.setValue("newBillPayment");
        billPayment.setId(id);
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, billPayment)).
                thenReturn(billPayment);
        assertEquals(billPayment.getId().getValue(), module.createBillPayment(ACCESS_TOKEN_ID, billPayment).
                getId().getValue());
    }

    @Test
    public void testCreateCashPurchase() {
        CashPurchase cashPurchase = new CashPurchase();
        IdType id = new IdType();
        id.setValue("newCashPurchase");
        cashPurchase.setId(id);
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, cashPurchase)).
                thenReturn(cashPurchase);
        assertEquals(cashPurchase.getId().getValue(), module.createCashPurchase(ACCESS_TOKEN_ID, cashPurchase).
                getId().getValue());
    }

    @Test
    public void testCreateCheck() {
        Check check = new Check();
        IdType id = new IdType();
        id.setValue("newCheck");
        check.setId(id);
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, check)).
                thenReturn(check);
        assertEquals(check.getId().getValue(), module.createCheck(ACCESS_TOKEN_ID, check).
                getId().getValue());
    }

    @Test
    public void testCreateCreditCardCharge() {
        CreditCardCharge creditCardCharge = new CreditCardCharge();
        IdType id = new IdType();
        id.setValue("newCreditCardCharge");
        creditCardCharge.setId(id);
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, creditCardCharge)).
                thenReturn(creditCardCharge);
        assertEquals(creditCardCharge.getId().getValue(),
                module.createCreditCardCharge(ACCESS_TOKEN_ID, creditCardCharge).getId().getValue());
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        IdType id = new IdType();
        id.setValue("newCustomer");
        customer.setId(id);
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, customer)).
                thenReturn(customer);
        assertEquals(customer.getId().getValue(),
                module.createCustomer(ACCESS_TOKEN_ID, customer).getId().getValue());
    }

    @Test
    public void testCreateEstimate() {
        Estimate estimate = new Estimate();
        IdType id = new IdType();
        id.setValue("newEstimate");
        estimate.setId(id);
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, estimate)).
                thenReturn(estimate);
        assertEquals(estimate.getId().getValue(),
                module.createEstimate(ACCESS_TOKEN_ID, estimate).getId().getValue());
    }

    @Test
    public void testCreateInvoice() {
        Invoice invoice = new Invoice();
        IdType id = new IdType();
        id.setValue("newEstimate");
        invoice.setId(id);
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, invoice)).
                thenReturn(invoice);
        assertEquals(invoice.getId().getValue(),
                module.createInvoice(ACCESS_TOKEN_ID, invoice).getId().getValue());
    }

    @Test
    public void testCreateItem() {
        Item item = new Item();
        IdType id = new IdType();
        id.setValue("newItem");
        item.setId(id);
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, item)).
                thenReturn(item);
        assertEquals(item.getId().getValue(),
                module.createItem(ACCESS_TOKEN_ID, item).getId().getValue());
    }

    @Test
    public void testCreatePayment() {
        Payment payment = new Payment();
        IdType id = new IdType();
        id.setValue("newItem");
        payment.setId(id);
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, payment)).
                thenReturn(payment);
        assertEquals(payment.getId().getValue(),
                module.createPayment(ACCESS_TOKEN_ID, payment).getId().getValue());
    }

    @Test
    public void testCreatePaymentMethod() {
        PaymentMethod paymentMethod = new PaymentMethod();
        IdType id = new IdType();
        id.setValue("newItem");
        paymentMethod.setId(id);
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, paymentMethod)).
                thenReturn(paymentMethod);
        assertEquals(paymentMethod.getId().getValue(),
                module.createPaymentMethod(ACCESS_TOKEN_ID, paymentMethod).getId().getValue());
    }

    @Test
    public void testCreateSalesReceipt() {
        SalesReceipt salesReceipt = new SalesReceipt();
        IdType id = new IdType();
        id.setValue("newSalesReceipt");
        salesReceipt.setId(id);
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, salesReceipt)).
                thenReturn(salesReceipt);
        assertEquals(salesReceipt.getId().getValue(),
                module.createSalesReceipt(ACCESS_TOKEN_ID, salesReceipt).getId().getValue());
    }

    @Test
    public void testCreateSalesTerm() {
        SalesTerm salesTerm = new SalesTerm();
        IdType id = new IdType();
        id.setValue("newSalesReceipt");
        salesTerm.setId(id);
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, salesTerm)).
                thenReturn(salesTerm);
        assertEquals(salesTerm.getId().getValue(),
                module.createSalesTerm(ACCESS_TOKEN_ID, salesTerm).getId().getValue());
    }

    @Test
    public void testCreateVendor() {
        Vendor vendor = new Vendor();
        IdType id = new IdType();
        id.setValue("newSalesReceipt");
        vendor.setId(id);
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, vendor)).
                thenReturn(vendor);
        assertEquals(vendor.getId().getValue(),
                module.createVendor(ACCESS_TOKEN_ID, vendor).getId().getValue());
    }

    @Test
    public void testGetObject() {
        Account account = new Account();
        IdType id = new IdType();
        id.setValue("account");
        account.setId(id);
        when(quickBooksOnlineClient.getObject(OAUTH_CREDENTIALS, OnlineEntityType.ACCOUNT, id)).
                thenReturn(account);
        assertEquals(account.getId().getValue(),
                ((Account) module.getObject(ACCESS_TOKEN_ID, OnlineEntityType.ACCOUNT, id)).getId().getValue());
    }

    @Test
    public void testUpdateAccount() {
        Account account = new Account();
        account.setDesc("UpdatedAccount");
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, OnlineEntityType.ACCOUNT, account)).thenReturn(account);
        assertEquals(account, module.updateAccount(ACCESS_TOKEN_ID, account));
    }

    @Test
    public void testUpdateBill() {
        Bill bill = new Bill();
        IdType id = new IdType();
        id.setValue("updatedBill");
        bill.setId(id);
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, OnlineEntityType.BILL, bill)).thenReturn(bill);
        assertEquals(bill, module.updateBill(ACCESS_TOKEN_ID, bill));
    }

    @Test
    public void testUpdateBillPayment() {
        BillPayment billPayment = new BillPayment();
        IdType id = new IdType();
        id.setValue("updatedBillPayment");
        billPayment.setId(id);
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, OnlineEntityType.BILLPAYMENT, billPayment)).thenReturn(billPayment);
        assertEquals(billPayment, module.updateBillPayment(ACCESS_TOKEN_ID, billPayment));
    }

    @Test
    public void testUpdateCashPurchase() {
        CashPurchase cashPurchase = new CashPurchase();
        IdType id = new IdType();
        id.setValue("updatedCashPurchase");
        cashPurchase.setId(id);
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, OnlineEntityType.CASHPURCHASE, cashPurchase)).
                thenReturn(cashPurchase);
        assertEquals(cashPurchase, module.updateCashPurchase(ACCESS_TOKEN_ID, cashPurchase));
    }

    @Test
    public void testUpdateCheck() {
        Check check = new Check();
        IdType id = new IdType();
        id.setValue("updatedCheck");
        check.setId(id);
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, OnlineEntityType.CHECK, check)).
                thenReturn(check);
        assertEquals(check, module.updateCheck(ACCESS_TOKEN_ID, check));
    }

    @Test
    public void testUpdateCreditCardCharge() {
        CreditCardCharge creditCardCharge = new CreditCardCharge();
        IdType id = new IdType();
        id.setValue("updatedCreditCardCharge");
        creditCardCharge.setId(id);
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, OnlineEntityType.CREDITCARDCHARGE, creditCardCharge)).
                thenReturn(creditCardCharge);
        assertEquals(creditCardCharge, module.updateCreditCardCharge(ACCESS_TOKEN_ID, creditCardCharge));
    }

    @Test
     public void testUpdateCustomer() {
        Customer customer = new Customer();
        IdType id = new IdType();
        id.setValue("updatedCashPurchase");
        customer.setId(id);
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, OnlineEntityType.CUSTOMER, customer)).
                thenReturn(customer);
        assertEquals(customer, module.updateCustomer(ACCESS_TOKEN_ID, customer));
    }

    @Test
    public void testUpdateEstimate() {
        Estimate estimate = new Estimate();
        IdType id = new IdType();
        id.setValue("updatedEstimate");
        estimate.setId(id);
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, OnlineEntityType.ESTIMATE, estimate)).
                thenReturn(estimate);
        assertEquals(estimate, module.updateEstimate(ACCESS_TOKEN_ID, estimate));
    }

    @Test
    public void testUpdateInvoice() {
        Invoice invoice = new Invoice();
        IdType id = new IdType();
        id.setValue("updatedInvoice");
        invoice.setId(id);
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, OnlineEntityType.INVOICE, invoice)).
                thenReturn(invoice);
        assertEquals(invoice, module.updateInvoice(ACCESS_TOKEN_ID, invoice));
    }

    @Test
    public void testUpdateItem() {
        Item item = new Item();
        IdType id = new IdType();
        id.setValue("updatedCashPurchase");
        item.setId(id);
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, OnlineEntityType.ITEM, item)).
                thenReturn(item);
        assertEquals(item, module.updateItem(ACCESS_TOKEN_ID, item));
    }

    @Test
    public void testUpdatePayment() {
        Payment payment = new Payment();
        IdType id = new IdType();
        id.setValue("updatedItem");
        payment.setId(id);
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, OnlineEntityType.PAYMENT, payment)).
                thenReturn(payment);
        assertEquals(payment, module.updatePayment(ACCESS_TOKEN_ID, payment));
    }

    @Test
    public void testUpdatePaymentMethod() {
        PaymentMethod paymentMethod = new PaymentMethod();
        IdType id = new IdType();
        id.setValue("updatedPaymentMethod");
        paymentMethod.setId(id);
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, OnlineEntityType.PAYMENTMETHOD, paymentMethod)).
                thenReturn(paymentMethod);
        assertEquals(paymentMethod, module.updatePaymentMethod(ACCESS_TOKEN_ID, paymentMethod));
    }

    @Test
    public void testUpdateSalesReceipt() {
        SalesReceipt salesReceipt = new SalesReceipt();
        IdType id = new IdType();
        id.setValue("updatedSalesReceipt");
        salesReceipt.setId(id);
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, OnlineEntityType.SALESRECEIPT, salesReceipt)).
                thenReturn(salesReceipt);
        assertEquals(salesReceipt, module.updateSalesReceipt(ACCESS_TOKEN_ID, salesReceipt));
    }

    @Test
    public void testUpdateSalesTerm() {
        SalesTerm salesTerm = new SalesTerm();
        IdType id = new IdType();
        id.setValue("updatedSalesTerm");
        salesTerm.setId(id);
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, OnlineEntityType.SALESTERM, salesTerm)).
                thenReturn(salesTerm);
        assertEquals(salesTerm, module.updateSalesTerm(ACCESS_TOKEN_ID, salesTerm));
    }

    @Test
    public void testUpdateVendor() {
        Vendor vendor = new Vendor();
        IdType id = new IdType();
        id.setValue("updatedVendor");
        vendor.setId(id);
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, OnlineEntityType.VENDOR, vendor)).
                thenReturn(vendor);
        assertEquals(vendor, module.updateVendor(ACCESS_TOKEN_ID, vendor));
    }

    @Test
    public void testFindObjects() {
        when(quickBooksOnlineClient.findObjects(OAUTH_CREDENTIALS, OnlineEntityType.ACCOUNT, QUERY_FILTER, QUERY_SORT)).
                thenReturn(createListAccount());
        assertEquals("FoundAccount", ((List<Account>)
                module.findObjects(ACCESS_TOKEN_ID, OnlineEntityType.ACCOUNT, QUERY_FILTER, QUERY_SORT)).get(0).getName());
    }

    @Test
    public void testChangeDataDeleted() {
        when(quickBooksOnlineClient.findObjects(OAUTH_CREDENTIALS, OnlineEntityType.CHANGEDATADELETED, QUERY_FILTER, QUERY_SORT)).
                thenReturn(createListAccount());
        assertEquals("FoundAccount", ((List<Account>)
                module.changeDataDeleted(ACCESS_TOKEN_ID, QUERY_FILTER, QUERY_SORT)).get(0).getName());
    }

    @Test
    public void testGetCompanyMetadata() {
        CompanyMetaData companyMetaData = new CompanyMetaData();
        companyMetaData.setQBNRegisteredCompanyName("Mulesoft");
        when(quickBooksOnlineClient.get(OAUTH_CREDENTIALS, OnlineEntityType.COMPANY_METADATA)).thenReturn(companyMetaData);
        assertEquals(companyMetaData.getQBNRegisteredCompanyName(),
                ((CompanyMetaData) module.getCompanyMetadata(ACCESS_TOKEN_ID)).getQBNRegisteredCompanyName());
    }

    @Test
    public void testGetUserInformation() {
        UserInformation userInformation = new UserInformation();
        userInformation.setEmailAddress("newuser@mail.com");
        when(quickBooksOnlineClient.getCurrentUserInformation(OAUTH_CREDENTIALS)).thenReturn(userInformation);
        assertEquals(userInformation.getEmailAddress(), module.getCurrentUser(ACCESS_TOKEN_ID).getEmailAddress());
    }

    @Test
    public void testGetBlueDotInformation() {
        List<AppMenuInformation> list = new ArrayList<AppMenuInformation>();
        AppMenuInformation menuInformation = new AppMenuInformation();
        menuInformation.setName("MulesoftAPP");
        list.add(menuInformation);
        when(quickBooksOnlineClient.getBlueDotInformation(OAUTH_CREDENTIALS, ANY_REGEX)).thenReturn(list);
        assertEquals(menuInformation.getName(),
                module.getBlueDotInformation(ACCESS_TOKEN_ID, ANY_REGEX).get(0).getName());
    }


    private static OpenIDCredentials createOpenIdCredentials() {
        OpenIDCredentials credentials = new OpenIDCredentials();
        credentials.setEmail(OPENID_EMAIL);
        return credentials;
    }

    private static Map<String, String> createParamMaps() {
        return new HashMap<String, String>();
    }

    private static Map<String, Object> createMap() {
        return new HashMap<String, Object>();
    }

    private void storeAccessToken() throws ObjectStoreException {
        objectStoreHelper.store(ACCESS_TOKEN_ID_PREFIX + ACCESS_TOKEN_ID, OAUTH_CREDENTIALS, true);
    }

    private Iterable createListAccount() {
        List<Account> list = new ArrayList<Account>();
        Account account = new Account();
        account.setName("FoundAccount");
        list.add(account);
        return list;
    }
}