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

import com.intuit.ipp.data.Account;
import com.intuit.ipp.data.Bill;
import com.intuit.ipp.data.BillPayment;
import com.intuit.ipp.data.CompanyInfo;
import com.intuit.ipp.data.Customer;
import com.intuit.ipp.data.Employee;
import com.intuit.ipp.data.Estimate;
import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.data.Item;
import com.intuit.ipp.data.JournalEntry;
import com.intuit.ipp.data.Payment;
import com.intuit.ipp.data.PaymentMethod;
import com.intuit.ipp.data.Purchase;
import com.intuit.ipp.data.SalesReceipt;
import com.intuit.ipp.data.Term;
import com.intuit.ipp.data.Vendor;

/**
 * The supported objects for Data Services for QuickBooks Online.
 * 
 * @author damianpelaez
 * 
 */
public enum IntuitEntityEnum
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
     * Purchase represents an expense to the business.
     */
    PURCHASE(Purchase.class),
    
    /**
     * The Customer object represents the consumer of the service or the product that 
     * your business offers. 
     * QBO allows categorizing the customers in a way that is meaningful to the business. 
     */
    CUSTOMER(Customer.class),

    /**
     * The Employee represents the persons who are working for the company. In QBO, the Employee resource is available
     * as a read-only resource. That is, only retrieve and simple query operations are supported for this resource.
     */
    EMPLOYEE(Employee.class),

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
     * A JournalEntry is a "free-form" transaction typically used to adjust the books. It must have at least 2 line items,
     * one for a credit and one for a debit, and the sum of the two line item amounts must be zero (that is, credit
     * and debit amounts must be balanced).
     */
    JOURNALENTRY(JournalEntry.class),
    
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
     * The Term object represents the terms under which a sale is made. 
     * Term is typically expressed in the form of days due after the goods are 
     * received. There is an optional discount part of the term, where a discount 
     * of total amount can automatically be applied if payment is made within a few 
     * days of the stipulated time.
     */
    TERM(Term.class),
    
    /**
     * The Vendor object represents the buyer from whom you purchase any service or 
     * product for your organization.
     */
    VENDOR(Vendor.class),
    
    /**
     * Reports information about the company, given the realm ID. 
     * The information is read-only through this API. 
     * The user may change values in the "Company/Preference/Company Contact Information" UI screen in QBO
     */
    COMPANY_INFO(CompanyInfo.class);
    
    private final Class<?> type;
    
    private IntuitEntityEnum(Class<?> type)
    {
        this.type = type;
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
     * @return
     */
    @SuppressWarnings("unchecked")
    public <A> Class<A> getType()
    {
        return (Class<A>) type;
    }

}
