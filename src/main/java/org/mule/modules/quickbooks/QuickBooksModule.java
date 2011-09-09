/**
 * Mule FWS Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

/**
 * This file was automatically generated by the Mule Development Kit
 */
package org.mule.modules.quickbooks;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang.Validate;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Module;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.oauth.OAuth;
import org.mule.api.annotations.oauth.OAuthAccessToken;
import org.mule.api.annotations.oauth.OAuthAccessTokenSecret;
import org.mule.api.annotations.oauth.OAuthConsumerKey;
import org.mule.api.annotations.oauth.OAuthConsumerSecret;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.modules.quickbooks.api.DefaultQuickBooksClient;
import org.mule.modules.quickbooks.api.MapBuilder;
import org.mule.modules.quickbooks.schema.Account;
import org.mule.modules.quickbooks.schema.Bill;
import org.mule.modules.quickbooks.schema.BillPayment;
import org.mule.modules.quickbooks.schema.CashPurchase;
import org.mule.modules.quickbooks.schema.Check;
import org.mule.modules.quickbooks.schema.CreditCardCharge;
import org.mule.modules.quickbooks.schema.Customer;
import org.mule.modules.quickbooks.schema.Estimate;
import org.mule.modules.quickbooks.schema.IdType;
import org.mule.modules.quickbooks.schema.Invoice;
import org.mule.modules.quickbooks.schema.Item;
import org.mule.modules.quickbooks.schema.Payment;
import org.mule.modules.quickbooks.schema.PaymentMethod;
import org.mule.modules.quickbooks.schema.SalesReceipt;
import org.mule.modules.quickbooks.schema.SalesTerm;
import org.mule.modules.quickbooks.schema.Vendor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.zauber.commons.mom.CXFStyle;
import ar.com.zauber.commons.mom.MapObjectMapper;




@Module(name = "quickbooks",
        namespace = "http://repository.mulesoft.org/releases/org/mule/modules/mule-module-quick-books",
        schemaLocation = "http://repository.mulesoft.org/releases/org/mule/modules/mule-module-quick-books/1.0/mule-quickbooks.xsd")
@OAuth(requestTokenUrl = "https://oauth.intuit.com/oauth/v1/get_request_token",
       accessTokenUrl = "https://oauth.intuit.com/oauth/v1/get_access_token",
       authorizationUrl = "https://workplace.intuit.com/Connect/Begin")
public class QuickBooksModule
{
    Logger logger = LoggerFactory.getLogger(QuickBooksModule.class);
    
    @Configurable
    private String realmId;
    
    @Configurable
    @OAuthConsumerKey
    private String consumerKey;
    
    @Configurable
    @OAuthConsumerSecret
    private String consumerSecret;
    
    @Configurable
    @Optional
    private DefaultQuickBooksClient client;
    
    private MapObjectMapper mom = new MapObjectMapper("org.mule.modules.quickbooks.schema");;

    @Processor
    public void createAccount(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                              String name, @Optional String desc, AccountDetail subtype, @Optional String acctNum,
                              @Optional String openingBalance, @Optional Date openingBalanceDate,
                              @Optional Map<String, Object> accountParentId)
    {
        BigDecimal bigD = openingBalance == null ? null :  new BigDecimal(openingBalance);
        
        Account account = client.create(
            mom.fromMap(Account.class,            
                new MapBuilder()
                .with("accountParentId", accountParentId)
                .with("desc", desc)
                .with("subtype", subtype.toWorkdayAccountDetail())
                .with("acctNum", acctNum)
                .with("openingBalance", bigD)
                .with("openingBalanceDate", openingBalanceDate)
                .build()
            )
        , accessToken, accessTokenSecret);
        return;
    }
    
    @Processor
    public void createBill(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                           Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.create(
            mom.fromMap(Bill.class,
                new MapBuilder()
                .with("billHeader", header)
                .with("billLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void createBillPayment(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                                  Map<String, Object> header, List<Map<String, Object>> line)
    {    
        client.create(
            mom.fromMap(BillPayment.class,
                new MapBuilder()
                .with("billPaymentHeader", header)
                .with("billPaymentLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void createCashPurchase(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                                   Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.create(
            mom.fromMap(CashPurchase.class,
                new MapBuilder()
                .with("cashPurchaseHeader", header)
                .with("cashPurchaseLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void createCheck(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                            Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.create(
            mom.fromMap(Check.class,
                new MapBuilder()
                .with("checkHeader", header)
                .with("checkLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void createCreditCardCharge(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                                       Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.create(
            mom.fromMap(CreditCardCharge.class,
                new MapBuilder()
                .with("creditCardChargeHeader", header)
                .with("creditCardChargeLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }

    @Processor
    public void createCustomer(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                               @Optional String name, @Optional String givenName, @Optional String middleName,
                               @Optional String familyName, @Optional String suffix, @Optional String dBAName,
                               @Optional String showAs, List<Map<String, Object>> webSite, @Optional Map<String, Object> salesTermId,
                               @Optional String salesTaxCodeId, List<String> email, List<Map<String, Object>> phone,
                               Map<String, Object> address)
    {
        client.create(
            mom.fromMap(Customer.class,
                new MapBuilder()
                .with("name", name)
                .with("givenName", givenName)
                .with("middleName", middleName)
                .with("familyName", familyName)
                .with("suffix", suffix)
                .with("dBAName", dBAName)
                .with("showAs", showAs)
                .with("webSite", webSite)
                .with("salesTermId", salesTermId)
                .with("salesTaxCodeId", salesTaxCodeId)
                .with("email", email)
                .with("phone", phone)
                .with("address", address)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void createEstimate(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                               Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.create(
            mom.fromMap(Estimate.class,
                new MapBuilder()
                .with("estimateHeader", header)
                .with("estimateLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void createInvoice(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                              Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.create(
            mom.fromMap(Invoice.class,
                new MapBuilder()
                .with("invoiceHeader", header)
                .with("invoiceLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void createItem(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                           @Optional @Default("") String name, Map<String,Object> unitPrice, @Optional String desc,
                           @Optional @Default("false") Boolean tasable, Map<String, Object> incomeAccountRef,
                           Map<String, Object> itemParentId, String itemParentName, @Optional String purchaseDesc,
                           Map<String, Object> purchaseCost, Map<String, Object> expenseAccountRef)
    {
        client.create(
            mom.fromMap(Item.class,
                new MapBuilder()
                .with("name", name)
                .with("unitPrice", unitPrice)
                .with("desc", desc)
                .with("tasable", tasable)
                .with("incomeAccountRef", incomeAccountRef)
                .with("itemParentId", itemParentId)
                .with("itemParentName", itemParentName)
                .with("purchaseDesc", purchaseDesc)
                .with("purchaseCosto", purchaseCost)
                .with("expenseAccountRef", expenseAccountRef)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void createPayment(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                              Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.create(
            mom.fromMap(Payment.class,
                new MapBuilder()
                .with("paymentHeader", header)
                .with("paymentLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void createPaymentMethod(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                                    String name, @Optional @Default("NON_CREDIT_CARD") String type)
    {
        client.create(
            mom.fromMap(PaymentMethod.class,
                new MapBuilder()
                .with("name", name)
                .with("type", type)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void createSalesReceipt(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                                   Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.create(
            mom.fromMap(SalesReceipt.class,
                new MapBuilder()
                .with("salesReceiptHeader", header)
                .with("salesReceiptLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void createSalesTerm(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                                String name, Integer dueDays, @Optional Integer discountDays,
                                @Optional String discountPercent, Integer dayOfMonthDue,
                                @Optional Integer dueNextMonthDays, @Optional Integer discountDayOfMonth,
                                @Optional String dateDiscountPercent)
    {
        BigDecimal bigD1 = discountPercent == null ? null :  new BigDecimal(discountPercent);
        BigDecimal bigD2 = dateDiscountPercent == null ? null :  new BigDecimal(dateDiscountPercent);
        
        client.create(
            mom.fromMap(SalesTerm.class,
                new MapBuilder()
                .with("name", name)
                .with("dueDays", dueDays)
                .with("discountDays", discountDays)
                .with("discountPercent", bigD1)
                .with("dayOfMonthDue", dayOfMonthDue)
                .with("dueNextMonthDays", dueNextMonthDays)
                .with("discountDayOfMonth", discountDayOfMonth)
                .with("discountPercent", bigD2)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void createVendor(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                             String name, String givenName, @Optional String middleName, @Optional String familyName,
                             @Optional String dBAName, @Optional String showAs, List<Map<String, Object>> webSite,
                             @Optional Integer taxIdentifier, @Optional String acctNum, @Optional Boolean vendor1099,
                             List<String> email, List<Map<String, Object>> phone, Map<String, Object> address)
    { 
        client.create(
            mom.fromMap(Vendor.class,
                new MapBuilder()
                .with("name", name)
                .with("givenName", givenName)
                .with("middleName", middleName)
                .with("familyName", familyName)
                .with("dBAName", dBAName)
                .with("showAs", showAs)
                .with("webSite", webSite)
                .with("taxIdentifier", taxIdentifier)
                .with("acctNum", acctNum)
                .with("vendor1099", vendor1099)
                .with("email", email)
                .with("phone", phone)
                .with("address", address)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public Object getObject(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                            EntityType type, Map<String, Object> id)
    {
//        logger.error(accessToken);
//        logger.error(accessTokenSecret);
//        throw new RuntimeException(accessToken + " :::: " + accessTokenSecret);
        return client.getObject(type, mom.fromMap(IdType.class, id), accessToken, accessTokenSecret);
    }

    @Processor
    public void updateAccount(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                              String name, @Optional String desc, AccountDetail subtype, @Optional String acctNum,
                              @Optional String openingBalance, @Optional Date openingBalanceDate,
                              @Optional Map<String, Object> accountParentId) //Map<String,Address> address)
    {   
        BigDecimal bigD = openingBalance == null ? null :  new BigDecimal(openingBalance);

        client.update(
            mom.fromMap(Account.class,            
                new MapBuilder()
                .with("accountParentId", accountParentId)
                .with("desc", desc)
                .with("subtype", subtype.toWorkdayAccountDetail())
                .with("acctNum", acctNum)
                .with("openingBalance", bigD)
                .with("openingBalanceDate", openingBalanceDate)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void updateBill(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                           Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.update(
            mom.fromMap(Bill.class,
                new MapBuilder()
                .with("billHeader", header)
                .with("billLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void updateBillPayment(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                                  Map<String, Object> header, List<Map<String, Object>> line)
    {    
        client.update(
            mom.fromMap(BillPayment.class,
                new MapBuilder()
                .with("billPaymentHeader", header)
                .with("billPaymentLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void updateCashPurchase(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                                   Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.update(
            mom.fromMap(CashPurchase.class,
                new MapBuilder()
                .with("cashPurchaseHeader", header)
                .with("cashPurchaseLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void updateCheck(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                            Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.update(
            mom.fromMap(Check.class,
                new MapBuilder()
                .with("checkHeader", header)
                .with("checkLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void updateCreditCardCharge(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                                       Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.update(
            mom.fromMap(CreditCardCharge.class,
                new MapBuilder()
                .with("creditCardChargeHeader", header)
                .with("creditCardChargeLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }

    @Processor
    public void updateCustomer(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                               @Optional String name, @Optional String givenName, @Optional String middleName,
                               @Optional String familyName, @Optional String suffix, @Optional String dBAName,
                               @Optional String showAs, List<Map<String, Object>> webSite, @Optional Map<String, Object> salesTermId,
                               @Optional String salesTaxCodeId, List<String> email, List<Map<String, Object>> phone,
                               Map<String, Object> address)
    {
        client.update(
            mom.fromMap(Customer.class,
                new MapBuilder()
                .with("name", name)
                .with("givenName", givenName)
                .with("middleName", middleName)
                .with("familyName", familyName)
                .with("suffix", suffix)
                .with("dBAName", dBAName)
                .with("showAs", showAs)
                .with("webSite", webSite)
                .with("salesTermId", salesTermId)
                .with("salesTaxCodeId", salesTaxCodeId)
                .with("email", email)
                .with("phone", phone)
                .with("address", address)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void updateEstimate(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                               Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.update(
            mom.fromMap(Estimate.class,
                new MapBuilder()
                .with("estimateHeader", header)
                .with("estimateLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void updateInvoice(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                              Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.update(
            mom.fromMap(Invoice.class,
                new MapBuilder()
                .with("invoiceHeader", header)
                .with("invoiceLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void updateItem(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                           @Optional @Default("") String name, Map<String,Object> unitPrice, @Optional String desc,
                           @Optional @Default("false") Boolean tasable, Map<String, Object> incomeAccountRef,
                           Map<String, Object> itemParentId, String itemParentName, @Optional String purchaseDesc,
                           Map<String, Object> purchaseCost, Map<String, Object> expenseAccountRef)
    {
        client.update(
            mom.fromMap(Item.class,
                new MapBuilder()
                .with("name", name)
                .with("unitPrice", unitPrice)
                .with("desc", desc)
                .with("tasable", tasable)
                .with("incomeAccountRef", incomeAccountRef)
                .with("itemParentId", itemParentId)
                .with("itemParentName", itemParentName)
                .with("purchaseDesc", purchaseDesc)
                .with("purchaseCosto", purchaseCost)
                .with("expenseAccountRef", expenseAccountRef)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void updatePayment(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                              Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.update(
            mom.fromMap(Payment.class,
                new MapBuilder()
                .with("paymentHeader", header)
                .with("paymentLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void updatePaymentMethod(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                                    String name, @Optional @Default("NON_CREDIT_CARD") String type)
    {
        client.update(
            mom.fromMap(PaymentMethod.class,
                new MapBuilder()
                .with("name", name)
                .with("type", type)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void updateSalesReceipt(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                                   Map<String, Object> header, List<Map<String, Object>> line)
    {
        client.update(
            mom.fromMap(SalesReceipt.class,
                new MapBuilder()
                .with("salesReceiptHeader", header)
                .with("salesReceiptLine", line)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void updateSalesTerm(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                                String name, Integer dueDays, @Optional Integer discountDays,
                                @Optional String discountPercent, Integer dayOfMonthDue,
                                @Optional Integer dueNextMonthDays, @Optional Integer discountDayOfMonth,
                                @Optional String dateDiscountPercent)
    {
        BigDecimal bigD1 = discountPercent == null ? null :  new BigDecimal(discountPercent);
        BigDecimal bigD2 = dateDiscountPercent == null ? null :  new BigDecimal(dateDiscountPercent);
        
        client.update(
            mom.fromMap(SalesTerm.class,
                new MapBuilder()
                .with("name", name)
                .with("dueDays", dueDays)
                .with("discountDays", discountDays)
                .with("discountPercent", bigD1)
                .with("dayOfMonthDue", dayOfMonthDue)
                .with("dueNextMonthDays", dueNextMonthDays)
                .with("discountDayOfMonth", discountDayOfMonth)
                .with("discountPercent", bigD2)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void updateVendor(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                             String name, String givenName, @Optional String middleName, @Optional String familyName,
                             @Optional String dBAName, @Optional String showAs, List<Map<String, Object>> webSite,
                             @Optional Integer taxIdentifier, @Optional String acctNum, @Optional Boolean vendor1099,
                             List<String> email, List<Map<String, Object>> phone, Map<String, Object> address)
    {
        client.update(
            mom.fromMap(Vendor.class,
                new MapBuilder()
                .with("name", name)
                .with("givenName", givenName)
                .with("middleName", middleName)
                .with("familyName", familyName)
                .with("dBAName", dBAName)
                .with("showAs", showAs)
                .with("webSite", webSite)
                .with("taxIdentifier", taxIdentifier)
                .with("acctNum", acctNum)
                .with("vendor1099", vendor1099)
                .with("email", email)
                .with("phone", phone)
                .with("address", address)
                .build()
            )
        , accessToken, accessTokenSecret);
    }
    
    @Processor
    public void deleteObject(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                             EntityType type, Map<String, Object> id, @Optional String syncToken)
    {
        client.deleteObject(type, mom.fromMap(IdType.class, id), syncToken, accessToken, accessTokenSecret);
    }

    @SuppressWarnings("rawtypes")
    @Processor
    public Iterable findObjects(@OAuthAccessToken String accessToken, @OAuthAccessTokenSecret String accessTokenSecret,
                                EntityType type, @Optional String queryFilter,
                                @Optional String querySort)
    {
        return client.findObjects(type, queryFilter, querySort, accessToken, accessTokenSecret);
    }
    
    /**
     * 
     */
    @PostConstruct
    public void init()
    {
        if (client == null )
        {
            client = new DefaultQuickBooksClient(realmId, consumerKey, consumerSecret);
        }
        mom.setPropertyStyle(CXFStyle.STYLE);
    }
    
    /**
     * Sets the realmId. 
     *
     * @param realmId  with the realmId.
     */

    public void setRealmId(String realmId)
    {
        this.realmId = realmId;
    }
    /**
     * Returns the realmId.
     * 
     * @return  with the realmId.
     */

    public String getRealmId()
    {
        return realmId;
    }

    /**
     * Returns the consumerKey.
     * 
     * @return  with the consumerKey.
     */
    
    public String getConsumerKey()
    {
        return consumerKey;
    }

    /**
     * Sets the consumerKey. 
     *
     * @param consumerKey  with the consumerKey.
     */
    
    public void setConsumerKey(String consumerKey)
    {
        this.consumerKey = consumerKey;
    }

    /**
     * Returns the consumerSecret.
     * 
     * @return  with the consumerSecret.
     */
    
    public String getConsumerSecret()
    {
        return consumerSecret;
    }

    /**
     * Sets the consumerSecret. 
     *
     * @param consumerSecret  with the consumerSecret.
     */
    
    public void setConsumerSecret(String consumerSecret)
    {
        this.consumerSecret = consumerSecret;
    }
    
    private final DatatypeFactory datatypeFactory;
    {
        mom.registerConverter(new Converter()
        {
            
            @Override
            public Object convert(Class arg0, Object arg1)
            {
                Validate.isTrue(arg0 == XMLGregorianCalendar.class);
                
                return toGregorianCalendar((Date) arg1);
            }
        }, Date.class);
        try
        {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch (DatatypeConfigurationException e)
        {
            throw new AssertionError(e);
        }
    }
    
    private XMLGregorianCalendar toGregorianCalendar(Date openingBalanceDate)
    {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(openingBalanceDate);
        return datatypeFactory.newXMLGregorianCalendar(cal);
    }
}
