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
import org.mule.modules.quickbooks.api.model.BlueDotMenu;
import org.mule.modules.quickbooks.api.model.UserInformation;
import org.mule.modules.quickbooks.api.oauth.OAuthCredentials;
import org.mule.modules.quickbooks.api.oauth.QuickBooksOAuthClient;
import org.mule.modules.quickbooks.api.oauth.QuickBooksObjectStore;
import org.mule.modules.quickbooks.api.openid.DefaultOpenIDClient;
import org.mule.modules.quickbooks.api.openid.OpenIDCredentials;
import org.mule.modules.quickbooks.online.api.QuickBooksOnlineClient;
import org.mule.modules.quickbooks.online.schema.CompanyMetaData;
import org.mule.modules.quickbooks.online.schema.IdType;
import org.openid4java.message.MessageException;

import com.intuit.ipp.data.Account;
import com.intuit.ipp.data.Bill;
import com.intuit.ipp.data.BillPayment;
import com.intuit.ipp.data.CompanyInfo;
import com.intuit.ipp.data.Customer;
import com.intuit.ipp.data.Estimate;
import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.data.Item;
import com.intuit.ipp.data.Payment;
import com.intuit.ipp.data.PaymentMethod;
import com.intuit.ipp.data.PaymentTypeEnum;
import com.intuit.ipp.data.Purchase;
import com.intuit.ipp.data.SalesReceipt;
import com.intuit.ipp.data.Term;
import com.intuit.ipp.data.Vendor;

import java.math.BigDecimal;
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
        bill.setId("newBill");
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, bill)).thenReturn(bill);
        assertEquals(bill.getId(), module.createBill(ACCESS_TOKEN_ID, bill).getId());
    }

    @Test
    public void testCreateBillPayment() {
        BillPayment billPayment = new BillPayment();
        billPayment.setId("newBillPayment");
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, billPayment)).
                thenReturn(billPayment);
        assertEquals(billPayment.getId(), module.createBillPayment(ACCESS_TOKEN_ID, billPayment).getId());
    }

    @Test
    public void testCreateCashPurchase() {
        Purchase cashPurchase = new Purchase();
        cashPurchase.setId("newCashPurchase");
        cashPurchase.setPaymentType(PaymentTypeEnum.CASH);
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, cashPurchase)).
                thenReturn(cashPurchase);
        assertEquals(cashPurchase.getId(), module.createPurchase(ACCESS_TOKEN_ID, cashPurchase).getId());
    }

    @Test
    public void testCreateCheckPurchase() {
    	Purchase checkPurchase = new Purchase();
        checkPurchase.setId("newCheckPurchase");
        checkPurchase.setPaymentType(PaymentTypeEnum.CHECK);
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, checkPurchase)).
                thenReturn(checkPurchase);
        assertEquals(checkPurchase.getId(), module.createPurchase(ACCESS_TOKEN_ID, checkPurchase).getId());
    }

    @Test
    public void testCreateCreditCardPurchase() {
    	Purchase creditCardPurchase = new Purchase();
        creditCardPurchase.setId("newCreditCardPurchase");
        creditCardPurchase.setPaymentType(PaymentTypeEnum.CREDIT_CARD);
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, creditCardPurchase)).
                thenReturn(creditCardPurchase);
        assertEquals(creditCardPurchase.getId(), module.createPurchase(ACCESS_TOKEN_ID, creditCardPurchase).getId());
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setId("newCustomer");
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, customer)).
                thenReturn(customer);
        assertEquals(customer.getId(), module.createCustomer(ACCESS_TOKEN_ID, customer).getId());
    }

    @Test
    public void testCreateEstimate() {
        Estimate estimate = new Estimate();
        estimate.setId("newEstimate");
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, estimate)).
                thenReturn(estimate);
        assertEquals(estimate.getId(),
                module.createEstimate(ACCESS_TOKEN_ID, estimate).getId());
    }

    @Test
    public void testCreateInvoice() {
        Invoice invoice = new Invoice();
        invoice.setId("newEstimate");
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, invoice)).
                thenReturn(invoice);
        assertEquals(invoice.getId(),
                module.createInvoice(ACCESS_TOKEN_ID, invoice).getId());
    }

    @Test
    public void testCreateItem() {
        Item item = new Item();
        item.setId("newItem");
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, item)).
                thenReturn(item);
        assertEquals(item.getId(),
                module.createItem(ACCESS_TOKEN_ID, item).getId());
    }

    @Test
    public void testCreatePayment() {
        Payment payment = new Payment();
        payment.setId("newItem");
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, payment)).
                thenReturn(payment);
        assertEquals(payment.getId(),
                module.createPayment(ACCESS_TOKEN_ID, payment).getId());
    }

    @Test
    public void testCreatePaymentMethod() {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setId("newItem");
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, paymentMethod)).
                thenReturn(paymentMethod);
        assertEquals(paymentMethod.getId(),
                module.createPaymentMethod(ACCESS_TOKEN_ID, paymentMethod).getId());
    }

    @Test
    public void testCreateSalesReceipt() {
        SalesReceipt salesReceipt = new SalesReceipt();
        salesReceipt.setId("newSalesReceipt");
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, salesReceipt)).
                thenReturn(salesReceipt);
        assertEquals(salesReceipt.getId(),
                module.createSalesReceipt(ACCESS_TOKEN_ID, salesReceipt).getId());
    }

    @Test
    public void testCreateTerm() {
        Term term = new Term();
        term.setId("newSalesReceipt");
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, term)).
                thenReturn(term);
        assertEquals(term.getId(),
                module.createTerm(ACCESS_TOKEN_ID, term).getId());
    }

    @Test
    public void testCreateVendor() {
        Vendor vendor = new Vendor();
        vendor.setId("newSalesReceipt");
        when(quickBooksOnlineClient.create(OAUTH_CREDENTIALS, vendor)).
                thenReturn(vendor);
        assertEquals(vendor.getId(),
                module.createVendor(ACCESS_TOKEN_ID, vendor).getId());
    }

    @Test
    public void testGetObject() {
        Account account = new Account();
        account.setId("1");
        when(quickBooksOnlineClient.getObjectWithId(OAUTH_CREDENTIALS, IntuitEntityEnum.ACCOUNT, "1")).
                thenReturn(account);
        assertEquals(account.getId(),
                ((Account) module.getObject(ACCESS_TOKEN_ID, IntuitEntityEnum.ACCOUNT, "1")).getId());
    }

    @Test
    public void testUpdateAccount() {
        Account account = new Account();
        account.setDescription("UpdatedAccount");
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, account)).thenReturn(account);
        assertEquals(account, module.updateAccount(ACCESS_TOKEN_ID, account));
    }

    @Test
    public void testUpdateBill() {
        Bill bill = new Bill();
        bill.setId("updatedBill");
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, bill)).thenReturn(bill);
        assertEquals(bill, module.updateBill(ACCESS_TOKEN_ID, bill));
    }

    @Test
    public void testUpdateBillPayment() {
        BillPayment billPayment = new BillPayment();
        billPayment.setTotalAmt(new BigDecimal(10));
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, billPayment)).thenReturn(billPayment);
        assertEquals(billPayment, module.updateBillPayment(ACCESS_TOKEN_ID, billPayment));
    }

    @Test
    public void testUpdateCashPurchase() {
    	Purchase cashPurchase = new Purchase();
    	cashPurchase.setPaymentType(PaymentTypeEnum.CASH);
        cashPurchase.setTotalAmt(new BigDecimal(10));
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, cashPurchase)).
                thenReturn(cashPurchase);
        assertEquals(cashPurchase, module.updatePurchase(ACCESS_TOKEN_ID, cashPurchase));
    }

    @Test
    public void testUpdateCheckPurchase() {
        Purchase checkPurchase = new Purchase();
        checkPurchase.setPaymentType(PaymentTypeEnum.CHECK);
        checkPurchase.setTotalAmt(new BigDecimal(10));
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, checkPurchase)).
                thenReturn(checkPurchase);
        assertEquals(checkPurchase, module.updatePurchase(ACCESS_TOKEN_ID, checkPurchase));
    }

    @Test
    public void testUpdateCreditCardPurchase() {
        Purchase creditCardPurchase = new Purchase();
        creditCardPurchase.setPaymentType(PaymentTypeEnum.CREDIT_CARD);
        creditCardPurchase.setTotalAmt(new BigDecimal(10));
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, creditCardPurchase)).
                thenReturn(creditCardPurchase);
        assertEquals(creditCardPurchase, module.updatePurchase(ACCESS_TOKEN_ID, creditCardPurchase));
    }

    @Test
     public void testUpdateCustomer() {
        Customer customer = new Customer();
        customer.setCompanyName("UpdatedCompanyName");
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, customer)).
                thenReturn(customer);
        assertEquals(customer, module.updateCustomer(ACCESS_TOKEN_ID, customer));
    }

    @Test
    public void testUpdateEstimate() {
        Estimate estimate = new Estimate();
        estimate.setTotalAmt(new BigDecimal(10));
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, estimate)).
                thenReturn(estimate);
        assertEquals(estimate, module.updateEstimate(ACCESS_TOKEN_ID, estimate));
    }

    @Test
    public void testUpdateInvoice() {
        Invoice invoice = new Invoice();
        invoice.setTotalAmt(new BigDecimal(10));
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, invoice)).
                thenReturn(invoice);
        assertEquals(invoice, module.updateInvoice(ACCESS_TOKEN_ID, invoice));
    }

    @Test
    public void testUpdateSalesReceipt() {
    	SalesReceipt salesReceipt = new SalesReceipt();
    	salesReceipt.setTotalAmt(new BigDecimal(10));
    	when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, salesReceipt)).
    	thenReturn(salesReceipt);
    	assertEquals(salesReceipt, module.updateSalesReceipt(ACCESS_TOKEN_ID, salesReceipt));
    }

    @Test
    public void testUpdateItem() {
        Item item = new Item();
        item.setDescription("updatedCashPurchase");
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, item)).
                thenReturn(item);
        assertEquals(item, module.updateItem(ACCESS_TOKEN_ID, item));
    }

    @Test
    public void testUpdatePayment() {
        Payment payment = new Payment();
        payment.setTotalAmt(new BigDecimal(10));
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, payment)).
                thenReturn(payment);
        assertEquals(payment, module.updatePayment(ACCESS_TOKEN_ID, payment));
    }

    @Test
    public void testUpdatePaymentMethod() {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setName("updatedPaymentMethod");
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, paymentMethod)).
                thenReturn(paymentMethod);
        assertEquals(paymentMethod, module.updatePaymentMethod(ACCESS_TOKEN_ID, paymentMethod));
    }

    @Test
    public void testUpdateTerm() {
        Term term = new Term();
        term.setName("updatedSalesTerm");
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, term)).
                thenReturn(term);
        assertEquals(term, module.updateTerm(ACCESS_TOKEN_ID, term));
    }

    @Test
    public void testUpdateVendor() {
        Vendor vendor = new Vendor();
        vendor.setCompanyName("updatedVendorCompany");
        when(quickBooksOnlineClient.update(OAUTH_CREDENTIALS, vendor)).
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
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setCompanyName("Mulesoft");
        when(quickBooksOnlineClient.getCompanyInfo(OAUTH_CREDENTIALS)).thenReturn(companyInfo);
        assertEquals(companyInfo.getCompanyName(),
                ((CompanyInfo) module.getCompanyInfo(ACCESS_TOKEN_ID)).getCompanyName());
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
        BlueDotMenu blueDotMenu = new BlueDotMenu(list, "SomeHTML");
        when(quickBooksOnlineClient.getBlueDotInformation(OAUTH_CREDENTIALS, ANY_REGEX)).thenReturn(blueDotMenu);
        assertEquals(menuInformation.getName(),
                module.getBlueDotInformation(ACCESS_TOKEN_ID, ANY_REGEX).getAppMenuInformationList().get(0).getName());
        assertEquals("SomeHTML",
                module.getBlueDotInformation(ACCESS_TOKEN_ID, ANY_REGEX).getBlueDotHtml());
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