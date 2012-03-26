/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.quickbooks.windows;

import org.mule.modules.quickbooks.api.QuickBooksConventions;
import org.mule.modules.quickbooks.windows.schema.*;

/**
 * The supported objects for Data Services for QuickBooks Online.
 * 
 * @author Gaston Ponti
 * @since Oct 5, 2011
 */

public enum WindowsEntityType
{
    /** Has Query **/
    ACCOUNT(Account.class, AccountQuery.class),
    /** Report. Do not have Query*/
    BALANCESHEETSTD(BalanceSheetStd.class, null),
    /** Has Query **/
    BILL(Bill.class, BillQuery.class),
    /** Has Query **/
    BILLPAYMENT(BillPayment.class, BillPaymentQuery.class),
    /** Has Query **/
    BILLPAYMENTCREDITCARD(BillPaymentCreditCard.class, BillPaymentCreditCardQuery.class),
    /** Has Query **/
    BOMBCOMPONENT(BOMComponent.class, BOMComponentQuery.class),
    /** Has Query **/
    BUILDASSEMBLY(BuildAssembly.class, BuildAssemblyQuery.class),
    /** Has Query **/
    CHARGE(Charge.class, ChargeQuery.class),
    /** Has Query **/
    CHECK(Check.class, CheckQuery.class),
    /** Has Query **/
    CLASS(org.mule.modules.quickbooks.windows.schema.Class.class, org.mule.modules.quickbooks.windows.schema.ClassQuery.class),
    /** Has Query **/
    CREDITCARDCHARGE(CreditCardCharge.class, CreditCardChargeQuery.class),
    /** Has Query **/
    CREDITCARDCREDIT(CreditCardCredit.class, CreditCardCreditQuery.class),
    /** Has Query **/
    CREDITCARDREDUND(CreditCardRefund.class, CreditCardRefundQuery.class),
    /** Has Query **/
    CREDITMEMO(CreditMemo.class, CreditMemoQuery.class),
    /** Has Query **/
    CURRENCYINFO(CurrencyInfo.class, CurrencyInfoQuery.class),
    /** Has Query **/
    CUSTOMER(Customer.class, CustomerQuery.class),
    /** Has Query **/
    CUSTOMERMSG(CustomerMsg.class, CustomerMsgQuery.class),
    /** Has Query **/
    CUSTOMERTYPE(CustomerType.class, CustomerTypeQuery.class),
    /** Do not have Query */
    CUSTOMERTXNDETAIL(CustomTxnDetail.class, null),
    /** Has Query **/
    DEPOSIT(Deposit.class, DepositQuery.class),
    /** Has Query **/
    DISCOUNT(Discount.class, DiscountQuery.class),
    /** Has Query **/
    EMPLOYEE(Employee.class, EmployeeQuery.class),
    /** Has Query **/
    ESTIMATE(Estimate.class, EstimateQuery.class),
    /** Has Query **/
    FIXEDASSET(FixedAsset.class, FixedAssetQuery.class),
    /** Has Query **/
    INVENTORYADJUSTMENT(InventoryAdjustment.class, InventoryAdjustmentQuery.class),
    /** Has Query **/
    INVENTORYSITE(InventorySite.class, InventorySiteQuery.class),
    /** Has Query **/
    INVENTORYTRANSFER(InventoryTransfer.class, InventoryTransferQuery.class),
    /** Has Query **/
    INVOICE(Invoice.class, InvoiceQuery.class),
    /** Has Query **/
    ITEM(Item.class, ItemQuery.class),
    /** Has Query **/
    ITEMCONSOLIDATED(ItemConsolidated.class, ItemConsolidatedQuery.class),
    /** Has Query **/
    ITEMRECEIPET(ItemReceipt.class, ItemReceiptQuery.class),
    /** Has Query **/
    JOB(Job.class, JobQuery.class),
    /** Has Query **/
    JOBTYPE(JobType.class, JobTypeQuery.class),
    /** Has Query **/
    OTHERNAME(OtherName.class, OtherNameQuery.class),
    /** Has Query **/
    PAYMENT(Payment.class, PaymentQuery.class),
    /** Has Query **/
    PAYMENTMETHOD(PaymentMethod.class, PaymentMethodQuery.class),
    /** Has Query **/
    PAYROLLITEM(PayrollItem.class, PayrollItemQuery.class),
    /** Do not have Query */
    PREFERENCES(Preferences.class, null),
    /** Has Query **/
    PURCHASEORDER(PurchaseOrder.class, PurchaseOrderQuery.class),
    /** Has Query **/
    SALESORDER(SalesOrder.class, SalesOrderQuery.class),
    /** Has Query **/
    SALESRECEIPT(SalesReceipt.class, SalesReceiptQuery.class),
    /** Has Query **/
    SALESREP(SalesRep.class, SalesRepQuery.class),
    /** Has Query **/
    SALESTAX(SalesTax.class, SalesTaxQuery.class),
    /** Has Query **/
    SALESTAXCODE(SalesTaxCode.class, SalesTaxCodeQuery.class),
    /** Has Query **/
    SALESTAXGROUP(SalesTaxGroup.class, SalesTaxGroupQuery.class),
    /** Has Query **/
    SALESTAXPAYMENTCHECK(SalesTaxPaymentCheck.class, SalesTaxPaymentCheckQuery.class),
    /** Do not have Query */
    SALESTERM(SalesTerm.class, null),
    /** Has Query **/
    SHIPMETHOD(ShipMethod.class, ShipMethodQuery.class),
    /** Do not have Query */
    SUMMARY1099(Summary1099.class, null),
    /** Has Query **/
    TASK(Task.class, TaskQuery.class),
    /** Has Query **/
    TEMPLATENAME(TemplateName.class, TemplateNameQuery.class),
    /** Has Query **/
    TIMEACTIVITY(TimeActivity.class, TimeActivityQuery.class),
    /** Has Query **/
    UOM(UOM.class, UOMQuery.class),
    /** Has Query **/
    VENDOR(Vendor.class, VendorQuery.class),
    /** Has Query **/
    VENDORCREDIT(VendorCredit.class, VendorCreditQuery.class),
    /** Has Query **/
    VENDORTYPE(VendorType.class, VendorTypeQuery.class);
//    /**
//     * The Account object represents the accounts that you keep to track your business.
//     * Account is a component of a chart of accounts, and is part of a ledger. 
//     * You can use Account to record the total monetary amount that is allocated 
//     * for a specific use.
//     */
//    ACCOUNT(Account.class),
//    
//    /**
//     * The Bill object represents an expense to the business.
//     */
//    BILL(Bill.class),
//    
//    /**
//     * BillPayment represents the financial transaction of payment of bills that the 
//     * business owner receives from a vendor for goods or services purchased from the vendor. 
//     * QBO supports bill payments through a credit card or a bank account.
//     */
//    BILLPAYMENT(BillPayment.class),
//    
//    /**
//     * CashPurchase represents an expense to the business as a cash transaction.
//     */
//    CASHPURCHASE(CashPurchase.class),
//    
//    /**
//     * The Check object represents an expense to the business paid as a check transaction.
//     */
//    CHECK(Check.class),
//    
//    /**
//     * The CreditCardCharge object represents an expense to the business as a credit
//     * card charge transaction.
//     */
//    CREDITCARDCHARGE(CreditCardCharge.class),
//    
//    /**
//     * The Customer object represents the consumer of the service or the product that 
//     * your business offers. 
//     * QBO allows categorizing the customers in a way that is meaningful to the business. 
//     */
//    CUSTOMER(Customer.class),
//    
//    /**
//     * The Estimate object represents a proposal for a financial transaction from a 
//     * business to a customer for goods or services proposed to be sold, including 
//     * proposed pricing. It is also known as quote.
//     */
//    ESTIMATE(Estimate.class),
//    
//    /**
//     * The Invoice object represents an invoice to a customer. 
//     * Invoice could be based on salesterm with invoice and due dates for payment. 
//     * Invoice supports tax, but as of now shipping charges are not supported.
//     */
//    INVOICE(Invoice.class),
//    
//    /**
//     * The Item object represents any product or service that is sold or purchased.
//     */
//    ITEM(Item.class),
//    
//    /**
//     * The Payment object  represents the financial transaction that signifies a 
//     * payment from a customer for one or more sales transactions.
//     */
//    PAYMENT(Payment.class),
//    
//    /**
//     * PaymentMethod represents the method of payment for a transaction. It can 
//     * be a credit card payment type or a non-credit card payment type.
//     */
//    PAYMENTMETHOD(PaymentMethod.class),
//    
//    /**
//     * SalesReceipt represents the sales receipt that is given to a customer.  
//     * A sales receipt is similar to an invoice. However, for a sales receipt, payment 
//     * is received as part of the sale of goods and services. The sales receipt 
//     * specifies a deposit account where the customer deposits the payment. 
//     * If the deposit account is not specified, the payment type is classified 
//     * as Undeposited Account.
//     */
//    SALESRECEIPT(SalesReceipt.class),
//    
//    /**
//     * The SalesTerm object  represents the terms under which a sale is made. 
//     * SalesTerm is typically expressed in the form of days due after the goods are 
//     * received. There is an optional discount part of the sales term, where a discount 
//     * of total amount can automatically be applied if payment is made within a few 
//     * days of the stipulated time.
//     */
//    SALESTERM(SalesTerm.class),
//    
//    /**
//     * The Vendor object represents the buyer from whom you purchase any service or 
//     * product for your organization.
//     */
//    VENDOR(Vendor.class);
    
    private final java.lang.Class<?> type;
    private final java.lang.Class<?> query;
    
    private WindowsEntityType(java.lang.Class<?> type, java.lang.Class<?> query)
    {
        this.type = type;
        this.query = query;
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
     * @return
     */
    @SuppressWarnings("unchecked")
    public <A> java.lang.Class<A> getType()
    {
        return (java.lang.Class<A>) type;
    }

    /**
     * @return the simple name of the associated class for this entity type
     */
    public String getSimpleName()
    {
        return getType().getSimpleName();
    }
    
    public <A> java.lang.Class<A> getQueryType()
    {
        return (java.lang.Class<A>) query;
    }
}
