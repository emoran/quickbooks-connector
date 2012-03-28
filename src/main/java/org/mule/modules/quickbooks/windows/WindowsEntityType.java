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
    /**
     * Has query.
     * <p>Account is a component of a Chart Of Accounts, and is part of a Ledger. Used to record a total monetary amount 
     * allocated against a specific use. Accounts are one of five basic types:</p>
     * <p>* Asset</p>
     * <p>* Liability</p>
     * <p>* Revenue (Income)</p>
     * <p>* Expenses</p>
     * <p>* Equity</p>
     * <p>The account name must be unique.
     * The account name cannot contain a colon (:).</p>
     */
    ACCOUNT(Account.class, AccountQuery.class, "account"),
//    don't know how to call it in the rest service
//    /** Report. Do not have Query*/
//    BALANCESHEETSTD(BalanceSheetStd.class, null),
    /** Has Query 
     * <p>Bill is an AP transaction representing a request-for-payment from a third party for goods/services rendered 
     * and/or received. Bill is a request for payment from the vendor for the goods or services that are rendered. 
     * You can enter a bill for your expenses or the items that you track as part of your business. An item is anything 
     * that your company buys, sells, or resells in the course of business. For example, products, shipping and handling 
     * charges, discounts, and sales tax. An expense is the amount of money that you spend on the items that you want to 
     * buy. Expenses are linked to expense accounts. For example, if you pay $200 per month for utilities, you can set up 
     * an expense account for these utilities, and assign the bill to this account.</p>
     * <p>If an account is provided in the header of the bill, it must be the Account Payable (AP) account.
     * A bill must have reference to a vendor in the header.
     * A bill must have at least one line that describes the item or account.
     * A bill must have reference to an object.</p>
     */
    BILL(Bill.class, BillQuery.class, "bill"),
    /** Has Query 
     * <p>Financial transaction representing a Payment by check issued to pay one or more bills received from 3rd 
     * party (vendor) for purchased goods or services.
     * <p>If an account is provided in the header of the bill payment, it must be the Account Payable (AP) account.
     * A bill payment must have reference to a vendor in the header.
     * A bill payment must have reference to an object.</p>
     */
    BILLPAYMENT(BillPayment.class, BillPaymentQuery.class, "billpayment"),
    /** Has Query 
     * <p>Financial transaction representing a Payment by credit card issued to pay one or more bills received from 3rd 
     * party (vendor) for purchased goods or services. Creates a BillPaymentCreditCard transaction, representing a payment 
     * by credit card against a bill issued for goods or services. If using with QuickBooks desktop versions, if you want 
     * to pay multiple bills, you must issue a separate request for each bill you want to pay. Also, if you are using more 
     * than one A/P account, make sure that the APAccount used in the BillPaymentCreditCard matches the APAccount that was 
     * used when the Bill was originally added.</p>
     */
    BILLPAYMENTCREDITCARD(BillPaymentCreditCard.class, BillPaymentCreditCardQuery.class, "billpaymentcreditcard"),
    /** Has Query 
     * <p>Describes one component of the BOM (Bill of Materials), an Inventory Assembly Item.</p>
     */
    BOMCOMPONENT(BOMComponent.class, BOMComponentQuery.class, "bomcomponent"),
    /** Has Query 
     * <p>Transaction that adds Assembly Items to inventory. The assembly's components (identified by Line/ItemId) are deducted 
     * from inventory and the quantity of assembly items (identified by Header/ItemId) is increased accordingly. Note that while 
     * the QBSDK returns QuantityOnHand data for the assembly and the components of the assembly, Data Services does NOT. Quantity 
     * on hand data can be obtained by looking only at the Item object itself.</p>**/
    BUILDASSEMBLY(BuildAssembly.class, BuildAssemblyQuery.class, "buildassembly"),
    /** Has Query 
     * <p>Financial transaction representing a request for payment for goods or services that have been sold.</p>
     */
    CHARGE(Charge.class, ChargeQuery.class, "charge"),
    /** Has Query 
     * <p>Financial transaction representing a payment to a payee. When used together with a realm synchronized with a QuickBooks 
     * company, the IDS Check object maps to the QuickBooks Check. Upon synchronization with QuickBooks, the Check Create operation 
     * results in a new Check added to the QuickBooks register. The Check Create operation creates a Check similar to what a user 
     * might create in the QuickBooks "Write Checks" form. The Write Checks form can be reached in the QuickBooks UI by selecting 
     * Banking->Write Checks or by clicking on the Write Checks icon in the Home page.
     * In the Check line items, you refer to an item via the ItemName field. That references automatically supplies the base unit 
     * of measure (UOM) for the item, and its description. You need only supply the quantity and unit price. At least one line item 
     * is required.</p>
     * <p>A check must have at least one line that describes the item or account.
     * A check must have reference to a vendor in the header.</p>
     */
    CHECK(Check.class, CheckQuery.class, "check"),
    /** Has Query 
     * <p>Classes provide a way to track different segments of the business, and to break down the income and expenses for each 
     * segment. Classes provide a system for categorizing transactions that goes beyond the basic ways of assigning transactions 
     * to expense or income accounts. With classes, it is possible to categorize each detail line on a transaction. This allows 
     * the customer to write one check to the office supply store for things bought for two different business units and still 
     * track the business unit for those purchases.</p>
     * <p>Example uses of classes:</p>
     * <p>Department</p>
     * <p>Enterprise</p>
     * <p>Properties</p>
     * <p>Work categories (plumbing, electrical, etc.)</p>
     * <p>Manufacturers</p>
     * <p>Partners</p>
     * <p>Product Lines</p>
     */
    CLASS(org.mule.modules.quickbooks.windows.schema.Class.class, org.mule.modules.quickbooks.windows.schema.ClassQuery.class, "class"),
    /** Has Query 
     * <p>Financial transaction representing a charge for purchase of goods or services. The CreditCardCharge represents an expense 
     * to the business as a credit card charge transaction. The expense is of the following types:</p>
     * <p>Item based expense for the item that is purchased for reselling.</p>
     * <p>Account based expense for the amount spend on an account, such as expense incurred on "advertisement expense" account.</p>
     */
    CREDITCARDCHARGE(CreditCardCharge.class, CreditCardChargeQuery.class, "creditcardcharge"),
    /** Has Query 
     * <p>Financial transaction representing a credit for purchase of goods or services.</p>
     */
    CREDITCARDCREDIT(CreditCardCredit.class, CreditCardCreditQuery.class, "creditcardcredit"),
    /** Has Query 
     * <p>The CreditCardRefund object helps you to refund a sale transaction that involves the credit card of a customer. You can use 
     * this object to refund transactions such as invoice, sales receipt, and statement charge.</p>
     */
    CREDITCARDREFUND(CreditCardRefund.class, CreditCardRefundQuery.class, "creditcardrefund"),
    /** Has Query 
     * <p>Financial transaction representing a refund (or credit) of payment or part of a payment for goods or services that have 
     * been sold.</p>
     */
    CREDITMEMO(CreditMemo.class, CreditMemoQuery.class, "creditmemo"),
    /** Has Query 
     * <p>The currency object contains all of the information needed to display and use a foreign currency. For built-in currencies, 
     * the name and currency code values are internationally accepted values and thus are not editable. The comma format is editable, 
     * as is the IsActive status. For user-defined currencies, every value in the object is editable including name and currency code.</p>
     */
    CURRENCYINFO(CurrencyInfo.class, CurrencyInfoQuery.class, "currencyinfo"),
    /** Has Query 
     * <p>A customer is a consumer of the service or product that your business offers. The Customer object allows you to categorize 
     * customers according to your business requirements. For example, you can create a category of customers to indicate the industry 
     * that a customer represents, the geographic location of a customer, or the awareness of the business. Categorization of customers 
     * is useful for reports. While creating a customer, avoid entering any job data. If you enter a job data, the system can prevent 
     * you from adding any more jobs for that customer. You must first create a customer, and then create a job using that customer as 
     * a parent.</p>
     * <p>The customer name must be unique.
     * The customer name must not contain a colon (:).
     * The e-mail address of the customer must contain @ and . (dot).
     * The customer address field is mandatory.</p>
     */
    CUSTOMER(Customer.class, CustomerQuery.class, "customer"),
    /** Has Query 
     * <p>A standard message to a customer that can be included at the bottom of a sales form. A customer message or a customer message
     * list appears at the bottom of a sales form. For example, you can create a thank you message using the CustomerMsg, and include 
     * this message in any invoice.</p>
     */
    CUSTOMERMSG(CustomerMsg.class, CustomerMsgQuery.class, "customermsg"),
    /** Has Query 
     * <p>Customer types allow categorizing customers in ways that are meaningful to the business. For example, one could set up customer 
     * types so that they indicate which industry a customer represents, a customer's geographic location, or how a customer first heard 
     * about the business. The categorization then can be used for reporting or mailings.</p>
     */
    CUSTOMERTYPE(CustomerType.class, CustomerTypeQuery.class, "customertype"),
//  don't know how to call it in the rest service
//    /** Do not have Query */
//    CUSTOMERTXNDETAIL(CustomTxnDetail.class, null),
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
    private final String urlReference;
    
    private WindowsEntityType(java.lang.Class<?> type, java.lang.Class<?> query, String urlReference)
    {
        this.type = type;
        this.query = query;
        this.urlReference = urlReference;
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
