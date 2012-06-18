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

import org.mule.modules.quickbooks.api.QuickBooksConventions;
import org.mule.modules.quickbooks.online.schema.Account;
import org.mule.modules.quickbooks.online.schema.Bill;
import org.mule.modules.quickbooks.online.schema.BillPayment;
import org.mule.modules.quickbooks.online.schema.CashPurchase;
import org.mule.modules.quickbooks.online.schema.Check;
import org.mule.modules.quickbooks.online.schema.CreditCardCharge;
import org.mule.modules.quickbooks.online.schema.Customer;
import org.mule.modules.quickbooks.online.schema.DeletedEntities;
import org.mule.modules.quickbooks.online.schema.Estimate;
import org.mule.modules.quickbooks.online.schema.Invoice;
import org.mule.modules.quickbooks.online.schema.Item;
import org.mule.modules.quickbooks.online.schema.Payment;
import org.mule.modules.quickbooks.online.schema.PaymentMethod;
import org.mule.modules.quickbooks.online.schema.SalesReceipt;
import org.mule.modules.quickbooks.online.schema.SalesTerm;
import org.mule.modules.quickbooks.online.schema.Vendor;

/**
 * The supported objects for Data Services for QuickBooks Online.
 * 
 * @author Gaston Ponti
 * @since Oct 5, 2011
 */

public enum OnlineEntityType
{
    /**
     * The Account object represents the accounts that you keep to track your business.
     * Account is a component of a chart of accounts, and is part of a ledger. 
     * You can use Account to record the total monetary amount that is allocated 
     * for a specific use.
     */
    ACCOUNT(Account.class),
    
    /**
     * The Bill object represents an expense to the business.
     */
    BILL(Bill.class),
    
    /**
     * BillPayment represents the financial transaction of payment of bills that the 
     * business owner receives from a vendor for goods or services purchased from the vendor. 
     * QBO supports bill payments through a credit card or a bank account.
     */
    BILLPAYMENT(BillPayment.class),
    
    /**
     * CashPurchase represents an expense to the business as a cash transaction.
     */
    CASHPURCHASE(CashPurchase.class),
    
    /**
     * The Check object represents an expense to the business paid as a check transaction.
     */
    CHECK(Check.class),
    
    /**
     * The CreditCardCharge object represents an expense to the business as a credit
     * card charge transaction.
     */
    CREDITCARDCHARGE(CreditCardCharge.class),
    
    /**
     * The Customer object represents the consumer of the service or the product that 
     * your business offers. 
     * QBO allows categorizing the customers in a way that is meaningful to the business. 
     */
    CUSTOMER(Customer.class),
    
    /**
     * The Estimate object represents a proposal for a financial transaction from a 
     * business to a customer for goods or services proposed to be sold, including 
     * proposed pricing. It is also known as quote.
     */
    ESTIMATE(Estimate.class),
    
    /**
     * The Invoice object represents an invoice to a customer. 
     * Invoice could be based on salesterm with invoice and due dates for payment. 
     * Invoice supports tax, but as of now shipping charges are not supported.
     */
    INVOICE(Invoice.class),
    
    /**
     * The Item object represents any product or service that is sold or purchased.
     */
    ITEM(Item.class),
    
    /**
     * The Payment object  represents the financial transaction that signifies a 
     * payment from a customer for one or more sales transactions.
     */
    PAYMENT(Payment.class),
    
    /**
     * PaymentMethod represents the method of payment for a transaction. It can 
     * be a credit card payment type or a non-credit card payment type.
     */
    PAYMENTMETHOD(PaymentMethod.class),
    
    /**
     * SalesReceipt represents the sales receipt that is given to a customer.  
     * A sales receipt is similar to an invoice. However, for a sales receipt, payment 
     * is received as part of the sale of goods and services. The sales receipt 
     * specifies a deposit account where the customer deposits the payment. 
     * If the deposit account is not specified, the payment type is classified 
     * as Undeposited Account.
     */
    SALESRECEIPT(SalesReceipt.class),
    
    /**
     * The SalesTerm object  represents the terms under which a sale is made. 
     * SalesTerm is typically expressed in the form of days due after the goods are 
     * received. There is an optional discount part of the sales term, where a discount 
     * of total amount can automatically be applied if payment is made within a few 
     * days of the stipulated time.
     */
    SALESTERM(SalesTerm.class),
    
    /**
     * The Vendor object represents the buyer from whom you purchase any service or 
     * product for your organization.
     */
    VENDOR(Vendor.class),
    
    /**
     * ChangeDataDeleted (Beta) ONLY FOR FIND-OBJECTS PROCESSOR
     * <p>Use this service to get all of the transactions and objects that have been deleted 
     * on the Data Serices server. Your application may consume QBO data by getting a 
     * snapshot of the data and caching it for later use. You can do this on an object-specific 
     * basis, querying for the object and applying a filter. However, this service provides a 
     * quick update of only those objects deleted, saving you the trouble of coding a lengthy 
     * query. Since the deleted object list is intended only for clearing the local cache, 
     * the returned information is a subset of the object fields: Id, EntityType, and L
     * astUpdatedTime (when the object was deleted).</p>
     * <p>Supported Objects:</p>
     * <p> * Account</p>
     * <p> * Item</p>
     * <p> * Customer</p>
     * <p> * Vendor</p>
     * <p> * Term (a.k.a SalesTerm)</p>
     * <p> * PaymentMethod</p>
     * <p> * Employee</p>
     * <p> * Class</p>
     * <p> * Job</p>
     * <p> * Invoice</p>
     * <p> * Estimate</p>
     * <p> * SalesReceipt</p>
     * <p> * QboStatementCharge</p>
     * <p> * Bill</p>
     * <p> * Check</p>
     * <p> * BillPayment</p>
     * <p> * CreditCardCharge</p>
     * <p> * CreditCardCredit</p>
     * <p> * VendorCredit</p>
     * <p> * Payment</p>
     * <p> * CashPurchase</p>
     * <p> * Journal (a.k.a JournalEntry)</p>
     * <p>Limitations:</p>
     * <p> * If the request filter includes Job, the return value may contain a Customer as a 
     * Job. (QBO treats Job as sub-Customer.)</p>
     * <p> * Only objects that are supported can be requested at this time. Other objects will 
     * cause a validation error.</p>
     * <p> * The "Sort" parameter is not supported for this filter.</p>
     * <p> * By default, the most recently deleted objects are returned first 
     * (descending order for LastUpdatedTime).</p>
     * <p>The Filter parameter in the body of the request must have the following format:</p>
     * <p>Entity :in: ( {entity-type} [, {entity-type}]* ) [:and: LastUpdatedTime :after: {date-time}]</p>
     * <p>For example:
     * Entity :in: (Customer, Invoice, Item) :and: LastUpdatedTime :after: 2011-06-30T01:00:00-0700</p>
     * <p>If the Filter is not specified, the query will return all deleted data.</p>
     * <p>Entity and LastUpdatedTime are the only parameters allowed in the filter.</p>
     * <p>All characters used in the filter syntax are case insensitive.</p>
     */
    CHANGEDATADELETED(DeletedEntities.class, "changedatadeleted", "Entity");
    
    private final Class<?> type;
    private final String simpleName;
    private final String cdmCollectionName;
    
    private OnlineEntityType(Class<?> type)
    {
        this.type = type;
        this.simpleName = getType().getSimpleName();
        this.cdmCollectionName = this.simpleName;
    }
    
    //this one is needed because of the ChangeDataDeleted that is beta in intuit, and they did not use
    //the same criteria of the other classes
    private OnlineEntityType(Class<?> type, String simpleName, String cdmCollectionName)
    {
        this.type = type;
        this.simpleName = simpleName;
        this.cdmCollectionName = cdmCollectionName;
    }
    
    @SuppressWarnings("unchecked")
    public <A> A newInstance()
    {
        try
        {
            return (A) type.newInstance();
        }
        catch (Exception e)
        {
            throw new AssertionError(e);
        }
    }

    /**
     * Answers the resource name of this entity type as present in the entity uri
     * 
     * @return
     */
    public String getResouceName()
    {
        return  QuickBooksConventions.toQuickBooksPathVariable(getSimpleName());
    }
    
    /**
     * Answers the resource name of this entity type as present in the entity uri
     * 
     * @return
     */
    public String getResouceNameForFind()
    {
        String str = QuickBooksConventions.toQuickBooksPathVariable(getSimpleName());
        
        //this one is needed because of the ChangeDataDeleted that is beta in intuit, and they did not use
        //the same criteria of the other classes
        if(!type.equals(DeletedEntities.class))
        {
            str += "s";
        }
        
        return str;
    }

    public String getCdmCollectionName()
    {
        return cdmCollectionName;
    }
    /**
     * @return
     */
    @SuppressWarnings("unchecked")
    public <A> Class<A> getType()
    {
        return (Class<A>) type;
    }

    /**
     * @return the simple name of the associated class for this entity type
     */
    public String getSimpleName()
    {
        return simpleName;
    }
}
