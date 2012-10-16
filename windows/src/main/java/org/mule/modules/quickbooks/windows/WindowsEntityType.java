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

import org.mule.modules.quickbooks.windows.schema.CompanyMetaData;
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
     * <p>Account is a component of a Chart Of Accounts, and is part of a Ledger. Used to record a total monetary amount 
     * allocated against a specific use. Accounts are one of five basic types:</p>
     * <p>* Asset</p>
     * <p>* Liability</p>
     * <p>* Revenue (Income)</p>
     * <p>* Expenses</p>
     * <p>* Equity</p>
     * <p>Business Rules:</p>
     * <p>* The account name must be unique.</p>
     * <p>* The account name cannot contain a colon (:).</p>
     * <p>For details of the fields, and query: 
	 * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
	 * 0500_QuickBooks_Windows/0600_Object_Reference/Account">Account</a></p>
	 */
    ACCOUNT(Account.class, AccountQuery.class),
//    don't know how to call it in the rest service
//    /** Report. Do not have Query*/
//    BALANCESHEETSTD(BalanceSheetStd.class, null),
    /**
     * <p>Bill is an AP transaction representing a request-for-payment from a third party for goods/services rendered 
     * and/or received. Bill is a request for payment from the vendor for the goods or services that are rendered. 
     * You can enter a bill for your expenses or the items that you track as part of your business. An item is anything 
     * that your company buys, sells, or resells in the course of business. For example, products, shipping and handling 
     * charges, discounts, and sales tax. An expense is the amount of money that you spend on the items that you want to 
     * buy. Expenses are linked to expense accounts. For example, if you pay $200 per month for utilities, you can set up 
     * an expense account for these utilities, and assign the bill to this account.</p>
     * <p>Business Rules:</p>
     * <p>* If an account is provided in the header of the bill, it must be the Account Payable (AP) account.</p>
     * <p>* A bill must have reference to a vendor in the header.</p>
     * <p>* A bill must have at least one line that describes the item or account.</p>
     * <p>* A bill must have reference to an object.</p>
     * <p>For details of the fields, and query: 
	 * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
	 * 0500_QuickBooks_Windows/0600_Object_Reference/Bill">Bill</a></p>
	 */
    BILL(Bill.class, BillQuery.class),
    /**
     * <p>Financial transaction representing a Payment by check issued to pay one or more bills received from 3rd 
     * party (vendor) for purchased goods or services.
     * <p>Business Rules:</p>
     * <p>* If an account is provided in the header of the bill payment, it must be the Account Payable (AP) account.</p>
     * <p>* A bill payment must have reference to a vendor in the header.</p>
     * <p>* A bill payment must have reference to an object.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/BillPayment">BillPayment</a></p>
     */
    BILLPAYMENT(BillPayment.class, BillPaymentQuery.class),
    /**
     * <p>Financial transaction representing a Payment by credit card issued to pay one or more bills received from 3rd 
     * party (vendor) for purchased goods or services. Creates a BillPaymentCreditCard transaction, representing a payment 
     * by credit card against a bill issued for goods or services. If using with QuickBooks desktop versions, if you want 
     * to pay multiple bills, you must issue a separate request for each bill you want to pay. Also, if you are using more 
     * than one A/P account, make sure that the APAccount used in the BillPaymentCreditCard matches the APAccount that was 
     * used when the Bill was originally added.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/BillPaymentCreditCard">BillPaymentCreditCard</a></p>
     */
    BILLPAYMENTCREDITCARD(BillPaymentCreditCard.class, BillPaymentCreditCardQuery.class),
    /**
     * <p>Describes one component of the BOM (Bill of Materials), an Inventory Assembly Item.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/BOMComponent">BOMComponent</a></p>
     */
    BOMCOMPONENT(BOMComponent.class, BOMComponentQuery.class),
    /**
     * <p>Transaction that adds Assembly Items to inventory. The assembly's components (identified by Line/ItemId) are deducted 
     * from inventory and the quantity of assembly items (identified by Header/ItemId) is increased accordingly. Note that while 
     * the QBSDK returns QuantityOnHand data for the assembly and the components of the assembly, Data Services does NOT. Quantity 
     * on hand data can be obtained by looking only at the Item object itself.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/BuildAssembly">BuildAssembly</a></p>
     */
    BUILDASSEMBLY(BuildAssembly.class, BuildAssemblyQuery.class),
    /**
     * <p>Financial transaction representing a request for payment for goods or services that have been sold.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/Charge">Charge</a></p>
     */
    CHARGE(Charge.class, ChargeQuery.class),
    /**  
     * <p>Financial transaction representing a payment to a payee. When used together with a realm synchronized with a QuickBooks 
     * company, the IDS Check object maps to the QuickBooks Check. Upon synchronization with QuickBooks, the Check Create operation 
     * results in a new Check added to the QuickBooks register. The Check Create operation creates a Check similar to what a user 
     * might create in the QuickBooks "Write Checks" form. The Write Checks form can be reached in the QuickBooks UI by selecting 
     * Banking->Write Checks or by clicking on the Write Checks icon in the Home page.
     * In the Check line items, you refer to an item via the ItemName field. That references automatically supplies the base unit 
     * of measure (UOM) for the item, and its description. You need only supply the quantity and unit price. At least one line item 
     * is required.</p>
     * <p>Business Rules:</p>
     * <p>* A check must have at least one line that describes the item or account.</p>
     * <p>* A check must have reference to a vendor in the header.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/Check">Check</a></p>
     */
    CHECK(Check.class, CheckQuery.class),
    /**   
     * <p>Classes provide a way to track different segments of the business, and to break down the income and expenses for each 
     * segment. Classes provide a system for categorizing transactions that goes beyond the basic ways of assigning transactions 
     * to expense or income accounts. With classes, it is possible to categorize each detail line on a transaction. This allows 
     * the customer to write one check to the office supply store for things bought for two different business units and still 
     * track the business unit for those purchases.</p>
     * <p>* Example uses of classes:</p>
     * <p>* Department</p>
     * <p>* Enterprise</p>
     * <p>* Properties</p>
     * <p>* Work categories (plumbing, electrical, etc.)</p>
     * <p>* Manufacturers</p>
     * <p>* Partners</p>
     * <p>* Product Lines</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/Class">Class</a></p>
     */
    CLASS(org.mule.modules.quickbooks.windows.schema.Class.class, org.mule.modules.quickbooks.windows.schema.ClassQuery.class),
    /**   
     * <p>Financial transaction representing a charge for purchase of goods or services. The CreditCardCharge represents an expense 
     * to the business as a credit card charge transaction. The expense is of the following types:</p>
     * <p>Item based expense for the item that is purchased for reselling.</p>
     * <p>Account based expense for the amount spend on an account, such as expense incurred on "advertisement expense" account.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/CreditCardCharge">CreditCardCharge</a></p>
     */
    CREDITCARDCHARGE(CreditCardCharge.class, CreditCardChargeQuery.class),
    
    /**
     * Reports information about the company, given the realm ID. 
     * The information is read-only through this API.
     *  
     */
    COMPANY_METADATA(CompanyMetaData.class, CompanyRequest.class, "company"),
    /**   
     * <p>Financial transaction representing a credit for purchase of goods or services.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/CreditCardCredit">CreditCardCredit</a></p>
     */ 
    CREDITCARDCREDIT(CreditCardCredit.class, CreditCardCreditQuery.class),
    /**   
     * <p>The CreditCardRefund object helps you to refund a sale transaction that involves the credit card of a customer. You can use 
     * this object to refund transactions such as invoice, sales receipt, and statement charge.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/CreditCardRefund">CreditCardRefund</a></p>
     */ 
    CREDITCARDREFUND(CreditCardRefund.class, CreditCardRefundQuery.class),
    /**   
     * <p>Financial transaction representing a refund (or credit) of payment or part of a payment for goods or services that have 
     * been sold.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/CreditMemo">CreditMemo</a></p>
     */ 
    CREDITMEMO(CreditMemo.class, CreditMemoQuery.class),
    /**   
     * <p>The currency object contains all of the information needed to display and use a foreign currency. For built-in currencies, 
     * the name and currency code values are internationally accepted values and thus are not editable. The comma format is editable, 
     * as is the IsActive status. For user-defined currencies, every value in the object is editable including name and currency code.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/CurrencyInfo">CurrencyInfo</a></p>
     */ 
    CURRENCYINFO(CurrencyInfo.class, CurrencyInfoQuery.class),
    /**   
     * <p>A customer is a consumer of the service or product that your business offers. The Customer object allows you to categorize 
     * customers according to your business requirements. For example, you can create a category of customers to indicate the industry 
     * that a customer represents, the geographic location of a customer, or the awareness of the business. Categorization of customers 
     * is useful for reports. While creating a customer, avoid entering any job data. If you enter a job data, the system can prevent 
     * you from adding any more jobs for that customer. You must first create a customer, and then create a job using that customer as 
     * a parent.</p>
     * <p>Business Rules:</p>
     * <p>* The customer name must be unique.</p>
     * <p>* The customer name must not contain a colon (:).</p>
     * <p>* The e-mail address of the customer must contain @ and . (dot).</p>
     * <p>* The customer address field is mandatory.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/Customer">Customer</a></p>
     */ 
    CUSTOMER(Customer.class, CustomerQuery.class),
    /**   
     * <p>A standard message to a customer that can be included at the bottom of a sales form. A customer message or a customer message
     * list appears at the bottom of a sales form. For example, you can create a thank you message using the CustomerMsg, and include 
     * this message in any invoice.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/CustomerMsg">CustomerMsg</a></p>
     */ 
    CUSTOMERMSG(CustomerMsg.class, CustomerMsgQuery.class),
    /**   
     * <p>Customer types allow categorizing customers in ways that are meaningful to the business. For example, one could set up customer 
     * types so that they indicate which industry a customer represents, a customer's geographic location, or how a customer first heard 
     * about the business. The categorization then can be used for reporting or mailings.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/CustomerType">CustomerType</a></p>
     */ 
    CUSTOMERTYPE(CustomerType.class, CustomerTypeQuery.class),
//  don't know how to call it in the rest service
//    /** Do not have Query */
//    CUSTOMERTXNDETAIL(CustomTxnDetail.class, null),
    /**   
     * <p>Transaction recording the transfer of money from the Undeposited Funds account to the Bank account.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/Deposit">Deposit</a></p>
     */ 
    DEPOSIT(Deposit.class, DepositQuery.class),
    /**   
     * <p>Identifies the discount or allowance that the Customer is to receive off of the TotalAmount owed.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/Discount">Discount</a></p>
     */ 
    DISCOUNT(Discount.class, DiscountQuery.class),
    /**   
     * <p>The Employee represents the persons who are working for the company.</p>
     * <p>Business Rules:</p>
     * <p>* The employee name must be unique.</p>
     * <p>* The employee name, first name, or last name must not contain a colon (:).</p>
     * <p>* The name, first name or last name field should not be blank.</p>
     * <p>* The e-mail, phone, and address fields are mandatory.</p>
     * <p>* The e-mail address of the employee must contain @ and . (dot).</p>
     * <p>* The value for the EmployeeType element must be either of the following: Officer, Owner, Regular, 
     * or Statutory.</p>
     * <p>* The value for the DeviceType element must be either of the following: Landline, Mobile, Fax, or Pager.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/Employee">Employee</a></p>
     */ 
    EMPLOYEE(Employee.class, EmployeeQuery.class),
    /**   
     * <p>An estimate is a description of a sale that you propose to a current or prospective customer. An estimate 
     * contains a list of tasks that you can perform for, or products that you can provide to customers. An estimate 
     * is also called a bid or proposal. An estimate is a non-posting transaction that does not affect the balance 
     * sheet or income statement of a company.</p>
     * <p>Business Rules:</p>
     * <p>* An estimate must have at least one line that describes an item.</p>
     * <p>* An estimate must have a reference to a customer in the header.</p>
     * <p>* If you submit a query with the filter IncludeDiscountLineDetails, the system retrieves either DiscountAmount 
     * or DiscountRatePercent with associated values</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/Estimate">Estimate</a></p>
     */ 
    ESTIMATE(Estimate.class, EstimateQuery.class),
    /**   
     * <p>Fixed assets represent the business assets that you do not convert to cash within one year of operation. 
     * A fixed asset is usually integral to your business operations. For example, a truck, cash register, 
     * or computer.</p>
     * <p>Business Rules:</p>
     * <p>* If ItemID or ItemType are specified for a transaction, do not specify UnitPrice for the fixed asset.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/FixedAsset">FixedAsset</a></p>
     */ 
    FIXEDASSET(FixedAsset.class, FixedAssetQuery.class),
    /**   
     * <p>Financial transaction representing quantity or value adjustments of inventory items that either increase 
     * or decrease inventory for the specified items.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/InventoryAdjustment">InventoryAdjustment</a></p>
     */ 
    INVENTORYADJUSTMENT(InventoryAdjustment.class, InventoryAdjustmentQuery.class),
    /**   
     * <p>The InventorySite resource represents a location where inventory is stored.</p>
     * <p>Business Rules:</p>
     * <p>* The site name must be unique.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/InventorySite">InventorySite</a></p>
     */ 
    INVENTORYSITE(InventorySite.class, InventorySiteQuery.class),
    /**   
     * <p>Transaction reflecting the movement of inventory assets between inventory sites.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/InventoryTransfer">InventoryTransfer</a></p>
     */ 
    INVENTORYTRANSFER(InventoryTransfer.class, InventoryTransferQuery.class),
    /**   
     * <p>Financial transaction representing a request for payment for goods or services that have been sold. 
     * An invoice is a form that records the details of a customer's purchase, such as quantity and price of the 
     * goods or services. An invoice records the amount owed by a customer who does not pay in full at the time of 
     * purchase. If full payment is received at the time of purchase, the sale may be recorded as a sales receipt, 
     * not an invoice. See SalesReceipt.</p>
     * <p>Note: You can now make Payments for Invoices that you created in Data Services and simultaneously 
     * synchronize them back to QuickBooks.</p>
     * <p>An invoice for QuickBooks must contain a valid customer reference in the CustomerId field and at least 
     * one line item. The referenced customer must already exist in the QuickBooks company at the desktop and any 
     * line items must also already exists in the QuickBooks company, or the attempt to sync will fail.</p>
     * <p>In general, it is a good practice to specify all the QuickBooks header fields if you have the data. 
     * You should always specify the ARAccountId; otherwise a default AR account will be used and this may give 
     * you unexpected results.If you want to apply one tax to all the transaction line items, use the TaxId or 
     * TaxGroupId field. If you want to use more than one tax, you need to use Tax Line items instead.</p>
     * <p>Business Rules:</p>
     * <p>* An invoice must have at least one line that describes the item.</p>
     * <p>* If an account is specified in the header, the account must be of the Accounts Receivable (AR) type.</p>
     * <p>* An invoice must have a reference to a customer in the header.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/Invoice">Invoice</a></p>
     */ 
    INVOICE(Invoice.class, InvoiceQuery.class),
    /**   
     * <p>An item is a thing that your company buys, sells, or re-sells, such as products, shipping and handling 
     * charges, discounts, and sales tax (if applicable). An item is shown as a line on an invoice or other sales 
     * form. An item helps you to fill the line item area of the sales or purchase form quickly. When you select 
     * an item from the item list, QuickBooks fills in a description of the line item and calculates the amount 
     * for you. An item is of the following types:</p>
     * <p>* Assembly Item: The Assembly item allows you combine inventory part items and other assembly items 
     * (subassemblies) into a single item by defining a Bill of Materials, that lists the component parts of 
     * the assembly item. You can also include the cost of building the assembly item by adding the non-inventory 
     * part items, service items, and other charge items to the Bill of Materials.</p>
     * <p>* Fixed Asset Item: The Fixed Asset item represents those business assets that you do not convert to 
     * cash one year of normal operation. A fixed asset is usually something that is integral to your business 
     * operations. For example, a truck or computer.</p>
     * <p>* Group Item: The Group item helps you to quickly enter a group of individual items that you often 
     * purchase or sell together.</p>
     * <p>* Inventory Item: The Inventory item is used to track merchandise which your business purchases, stocks 
     * as inventory, and re-sells. QuickBooks tracks the current number of inventory items in stock and the average 
     * value of the inventory after the purchase and sale of every item.</p>
     * <p>* Other Charge Item: The Other Charge item is used to charge customers for the mileage expense.</p>
     * <p>* Product Item: The Product item is used to record the sales information of a product.</p>
     * <p>* Payment Item: The Payment item subtracts the amount of a customer payment from the total amount of 
     * an invoice or statement. You must create a payment item if you receive payment for an invoice or statement 
     * in parts. If you receive full payment at the time of sale, use a sales receipt form instead of an invoice 
     * with a payment item.</p>
     * <p>* Service Item: The Service item is used for the services that you charge on the purchase. For example, 
     * including specialized labor, consulting hours, and professional fees.</p>
     * <p>* Subtotal Item: The Subtotal item is used when you want the total of all the items. You can use this 
     * item to apply a percentage discount or surcharge.</p>
     * <p>Business Rules:</p>
     * <p>* The item name must be unique.</p>
     * <p>* The item type must not be NULL.</p>
     * <p>* The item cannot define both unit price and unit price percent simultaneously.</p>
     * <p>* For the Service, Product, and Other Charge items, you must specify the ID or name of the expense 
     * account or both.</p>
     * <p>* If the purchase order cost is specified for the Service, Product, and Other Charge items, you must 
     * specify the ID or name of the expense account or both.</p>
     * <p>* For the Inventory and Assembly items, you must specify:</p>
     * <p>|--> * the ID or name of the income account or both</p>
     * <p>|--> * the ID or name of the cogs account or both</p>
     * <p>|--> * the ID or name of the asset account or both</p>
     * <p>* For the Group item, you must specify the tax ID or tax name or both.</p>
     * <p>* For the Fixed Asset item, you must:</p>
     * <p>|--> * set the asset account type to Asset</p>
     * <p>|--> * specify the purchase date</p>
     * <p>|--> * specify the ID or name of the income account or both</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/Invoice">Invoice</a></p>
     */ 
    ITEM(Item.class, ItemQuery.class),
    /**   
     * <p>ItemConsolidated provides efficient parity between QuickBooks and applications that depend on the Data 
     * Services Item types that are synchronized with the QuickBooks Item type. This object allows collaboration 
     * of the following objects:</p>
     * <p>* Item</p>
     * <p>* Discount</p>
     * <p>* FixedAssets</p>
     * <p>* SalesTax</p>
     * <p>* SalesTaxGroup.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/ItemConsolidated">ItemConsolidated</a></p>
     */ 
    ITEMCONSOLIDATED(ItemConsolidated.class, ItemConsolidatedQuery.class),
    /**  
     * <p>Describes one line of the Item Group.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/ItemGroupComponent">ItemGroupComponent</a></p>
     */ 
    ITEMGROUPCOMPONENT(ItemGroupComponent.class, ItemGroupComponentQuery.class),
    /**   
     * <p>ItemReceipt is an AP transaction representing the delivery of goods from a 3rd party. The Bill is 
     * expected to be received at a later date. You can use the ItemReceipt object to manage your Account 
     * Receivable transactions with third party vendors.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/ItemReceipt">ItemReceipt</a></p>
     */ 
    ITEMRECEIPT(ItemReceipt.class, ItemReceiptQuery.class),
    /**   
     * <p>A job can be defined as a project, policy (insurance), or case (legal) according to your business. 
     * The Job object is a way to track larger orders, such as order placed by different departments within 
     * the same organization. You can use job types to track important information about your projects and jobs. 
     * Tracking the job types gives you an idea of the profitability of each job that you do. Tracking can also 
     * help you to determine the time that you spent on different types of projects or jobs. You can filter any 
     * project report based on the job type.</p>
     * <p>Business Rules:</p>
     * <p>* The job name must be unique.</p>
     * <p>* The job name must not contain a colon (:).</p>
     * <p>* Each job must have a valid customer ID or customer name reference.</p>
     * <p>* The job parent ID or job parent name must be valid.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/Job">Job</a></p>
     */ 
    JOB(Job.class, JobQuery.class),
    /**   
     * <p>Job types allow categorizing jobs so that similar jobs can be grouped and subtotaled on reports. 
     * Ultimately, they will help in determining which jobs are most profitable for the business.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/JobType">JobType</a></p>
     */ 
    JOBTYPE(JobType.class, JobTypeQuery.class),
    /**  
     * <p>Adds a Journal Entry. In traditional accounting, transactions are entered into the general journal 
     * and categorized exclusively by account. In QuickBooks, most transactions can be categorized either by 
     * account or by type (invoice, check, and so on). For a few activities in QuickBooks, you must use the 
     * general journal directly, for example for recording depreciation. Notice that you must supply the credit 
     * line and a corresponding debit line in the same request. It will not work to supply them in two distinct 
     * requests. You can supply as many credit lines and debit lines in one single request as you want so long 
     * as the total monetary amount from the credits equals the total monetary amount from the debits in that 
     * request. DO NOT supply negative sign for the monetary amounts.</p>
     * <p>Business Rules:</p>
     * <p>* The Line/PostingType attribute (either Credit or Debit) is required.</p>
     * <p>* The Line/Amount attribute may not be negative.</p>
     * <p>* Each request must have debits and credits.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/JournalEntry">JournalEntry</a></p>
     */ 
    JOURNALENTRY(JournalEntry.class, JournalEntryQuery.class),
    /**  
     * <p>A name/value pair allows for clients including data that is meaningful in the domain of origin, 
     * outside of the Intuit domain.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/NameValue">NameValue</a></p>
     */ 
    NAMEVALUE(NameValue.class, NameValueQuery.class),
    /**   
     * <p>The OtherName object represents a person or a company that is not your customer, vendor, or employee. 
     * For example, you can use OtherName object to represent owners or partners.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/OtherName">OtherName</a></p>
     */ 
    OTHERNAME(OtherName.class, OtherNameQuery.class),
    /**   
     * <p>Payment is a financial transaction, in which a customer pays for the goods and services purchased. 
     * You can make Payments for Invoices that you created in Data Service and simultaneously synchronize 
     * them back to QuickBooks.</p>
     * <p>Business Rules:</p>
     * <p>* If an account is specified in the header, the account must be of the Accounts Receivable (AR) type.</p>
     * <p>* A payment must have a reference to a customer in the header</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/Payment">Payment</a></p>
     */ 
    PAYMENT(Payment.class, PaymentQuery.class),
    /**   
     * <p>Payment methods provide information about the various ways through which a customer can make payment.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/PaymentMethod">PaymentMethod</a></p>
     */ 
    PAYMENTMETHOD(PaymentMethod.class, PaymentMethodQuery.class),
    /**  
     * <p>A payroll item (wage-based) is used to track individual amounts on a paycheck for wage, salary, commission, 
     * or bonus. You can assign these payroll items to various accounts. For non-wage based payroll items, such as 
     * taxes, saving plan (401K) contributions, or direct-deposit amounts, see PayrollNonWageItem.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/PayrollItem">PayrollItem</a></p>
     */ 
    PAYROLLITEM(PayrollItem.class, PayrollItemQuery.class),
    /**  
     * <p>A non-wage payroll item is used to track individual amounts on a paycheck for taxes, saving plan (401K) 
     * contributions, direct-deposit amounts - items other than wage, salary, commission, or bonus. You can assign 
     * these payroll items to various accounts. For wage-based payroll items, see PayrollItem.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/PayrollNonWageItem">PayrollNonWageItem</a></p>
     */ 
    PAYROLLNONWAGEITEM(PayrollNonWageItem.class, PayrollNonWageItemQuery.class), 
//    /** Do not have Query */
//    PREFERENCES(Preferences.class, null),
    /**   
     * <p>PurchaseOrder is a non-posting transaction representing a request to purchase goods or services from a 
     * third party. You can use ItemReceipt Create to receive items against a purchase order as items arrive from 
     * the vendor. A purchase order is a non-posting transaction, so it does not affect a company's balance sheet 
     * or income statement.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/PayrollNonWageItem">PayrollNonWageItem</a></p>
     */ 
    PURCHASEORDER(PurchaseOrder.class, PurchaseOrderQuery.class),
    /**   
     * <p>A sales order is a financial transaction that represents a request received from a customer to purchase 
     * products or services. Sales orders help you manage the sale of products and services your customers order. 
     * For example, a sales order tracks inventory that is on back order for a customer. Sales Orders are supported 
     * only in QuickBooks Premier (desktop) and above. However, if you are accessing a company file created in 
     * Premier and above from a lesser edition of QuickBooks (such as Pro), you can do queries against SalesOrders. 
     * Using sales orders is optional.</p>
     * <p>Business Rules:</p>
     * <p>* A sales order must have at least one line that describes the item.</p>
     * <p>* A sales order must have a reference to a customer in the header.</p>
     * <p>* If you submit a query with the filter IncludeDiscountLineDetails, the system retrieves either 
     * DiscountAmount or DiscountRatePercent with associated values</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/SalesOrder">SalesOrder</a></p>
     */ 
    SALESORDER(SalesOrder.class, SalesOrderQuery.class),
    /**   
     * <p>A sales receipt is a financial transaction that represents the sale of goods or services where payment in 
     * full is received at the time of purchase. Do not use a sales receipt if customers pay in part at the time of 
     * purchase; instead, use an invoice. The Invoice object offers more options than the SalesReceipt, and because 
     * a customer name is required for an invoice but not a sales receipt, use the Invoice object to keep track of 
     * payments owed on a purchase.</p>
     * <p>Business Rules:</p>
     * <p>* A sales receipt must have at least one line that describes the item.</p>
     * <p>* A sales receipt must have a reference to a customer in the header.</p>
     * <p>* If an account is specified in the header, the account must be of the Accounts Receivable (AR) type.</p>
     * <p>* If you submit a query with the filter IncludeDiscountLineDetails, the system retrieves either 
     * DiscountAmount or DiscountRatePercent with associated values.</p>
     * <p>Note: The PONumber field in a sales receipt is removed after synchronization, as QBSDK does not support it.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/SalesReceipt">SalesReceipt</a></p>
     */ 
    SALESRECEIPT(SalesReceipt.class, SalesReceiptQuery.class),
    /**   
     * <p>The SalesRep object allows you to identify sales representatives and track their transactions. A sales 
     * representative can be an employee, a vendor, or an independent contractor. You can associate sales representatives 
     * with sales deals to track their transactions.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/SalesRep">SalesRep</a></p>
     */ 
    SALESREP(SalesRep.class, SalesRepQuery.class),
    /**   
     * <p>You can use the SalesTax object to manage the sales tax that you collect on behalf of the state or any other 
     * government agency, after completing a sales transaction.</p>
     * <p>Business Rules:</p>
     * <p>* If ItemID or ItemType are specified for a transaction, do not specify the following parameters for the sales 
     * tax: UnitPrice, Quantity.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/SalesTax">SalesTax</a></p>
     */ 
    SALESTAX(SalesTax.class, SalesTaxQuery.class),
    /**   
     * <p>A sales tax code is used to track the taxable or non-taxable status of products, services, and customers. 
     * You can assign a sales tax code to each of your products, services, and customers based on their taxable or 
     * non-taxable status. You can then use these codes to generate reports that provide information to the tax 
     * agencies about the taxable or non-taxable status of certain sales.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/SalesTaxCode">SalesTaxCode</a></p>
     */ 
    SALESTAXCODE(SalesTaxCode.class, SalesTaxCodeQuery.class),
    /**   
     * <p>Collection of Sales taxes which the business must collect on behalf of one or more state or government 
     * agencies when a sales transaction is completed.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/SalesTaxGroup">SalesTaxGroup</a></p>
     */ 
    SALESTAXGROUP(SalesTaxGroup.class, SalesTaxGroupQuery.class),
//  don't know how to call it in the rest service
//    /**   **/
//    SALESTAXPAYMENTCHECK(SalesTaxPaymentCheck.class, SalesTaxPaymentCheckQuery.class),
    /**   
     * <p>The SalesTerm object represents the terms under which a sale is made, typically expressed in the form of 
     * days due after the goods are received. There is an optional discount part of the sales term, where a discount 
     * of total amount can automatically be applied if payment is made within the stipulated time.</p>
     * <p>For example, net 30 indicates that you must make the payment within 30 days; 2%/15 net 60 indicates that 
     * you must make the payment within 60 days, and you can get a discount of 2% if you make payment within 15 days. 
     * SalesTerm also supports the ability to specify the absolute due date, a number of days from a start date, a 
     * percent discount, or an absolute discount.</p>
     * <p>The SalesTerm name itself is a text-only attribute and the desired application of the sales term must be 
     * coded. For example, a common term such as Net30Days is explicitly coded as a calculated DueDateTime or as a 
     * PaymentTermsDateTime and NumberOfDays.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/SalesTerm">SalesTerm</a></p>
     */ 
    SALESTERM(SalesTerm.class, TermQuery.class, "term"),
    /**   
     * <p>You can use the ShipMethod object to specify a method to ship the goods that are purchased or sold. 
     * For example, you can specify a method to ship goods to your customers when you make a sales transaction.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/ShipMethod">ShipMethod</a></p>
     */ 
    SHIPMETHOD(ShipMethod.class, ShipMethodQuery.class),
//  don't know how to call it in the rest service
//    /** Do not have Query */
//    SUMMARY1099(Summary1099.class, null),
    /**   
     * <p>A specific task to be completed, maps to a ToDo record in QuickBooks.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/Task">Task</a></p>
     */ 
    TASK(Task.class, TaskQuery.class),
    /**   
     * <p>The name of a template used for a specific form presentation.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/TemplateName">TemplateName</a></p>
     */ 
    TEMPLATENAME(TemplateName.class, TemplateNameQuery.class),
    /**   
     * <p>A record of time worked by a vendor or employee. A time activity records the time taken to complete a 
     * particular task. Professional service firms can track time for the following reasons:</p>
     * <p>* To know the tasks of a person and the time spent on various projects, and to use this information 
     * for job costing.</p>
     * <p>* To bill the clients using standard service item rates or custom billing rates.</p>
     * <p>* To view and quickly access the unbilled time or expenses for a customer.</p>
     * <p>* To view the number of unbilled hours in the project for each client in reports.</p>
     * <p>* To use the stopwatch to record the time for a current activity. For example, when you answer a 
     * phone call from a client.</p>
     * <p>* To preview the time records and paychecks of your employees when you pay your employees.</p>
     * <p>* To pay non-employees (owners, partners, subcontractors, and vendors) for the number of hours they 
     * work.</p>
     * <p>Business Rules:</p>
     * <p>* If you modify the time activity records that are more than 5 years old, an error occurs.</p>
     * <p>* The value of the NameOf element must be Employee or Vendor.</p>
     * <p>* The value of the BillableStatus element must be Billable or HasBeenBillable. The default value 
     * is Billable.</p>
     * <p>* The default value of the Taxable element is set to True.</p>
     * <p>* Both the Hours and Minutes elements are either positive or negative.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/TimeActivity">TimeActivity</a></p>
     */ 
    TIMEACTIVITY(TimeActivity.class, TimeActivityQuery.class),
    /**   
     * <p>You can use the UOM (Unit of Measure) object to represent data such as quantities, prices, rates, 
     * and costs, in units. This object also helps you to convert these units to related units. The UOM type 
     * defines the data used to represent a set of equivalent units and the conversion rates to other related 
     * units. It allows showing what quantities, prices, rates, and costs are based on.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/UOM">UOM</a></p>
     */ 
    UOM(UOM.class, UOMQuery.class),
    /**   
     * <p>You can use the Vendor object to store information about the people and companies you do business with. 
     * A vendor is an individual or an organization that provides goods and services to a customer. For example, 
     * banks and tax agencies.</p>
     * <p>Business Rules:</p>
     * <p>* The vendor name must be unique.</p>
     * <p>* The name, first name, and last name of the vendor must not contain a colon (:).</p>
     * <p>* The name, first name, or last name field should not be blank.</p>
     * <p>* The e-mail address of the vendor must contain @ and . (dot).</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/Vendor">Vendor</a></p>
     */ 
    VENDOR(Vendor.class, VendorQuery.class),
    /**   
     * <p>VendorCredit is an AP transaction representing a credit from a third party for returned goods or 
     * services not rendered. In QuickBooks desktop versions, a vendor credit is also known as a "bill credit". 
     * That is, it is a credit that a vendor owes you because you overpaid your bill, returned merchandise, or for 
     * some other reason. The VendorCredit is not applied until it is referenced in a Bill Payment transaction.</p>
     * <p>Note: A VendorCredit should not be confused with a Credit Memo, which is something you owe your customer.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/VendorCredit">VendorCredit</a></p>
     */ 
    VENDORCREDIT(VendorCredit.class, VendorCreditQuery.class),
    /**   
     * <p>Vendor types allow categorizing vendors in ways that are meaningful to the business. For example, one 
     * could set up vendor types so that they indicate a vendor's industry or geographic location. The categorization 
     * then can be used for reporting. You can also create a vendor type as a subtype of another vendor type.</p>
     * <p>For details of the fields, and query: 
     * <a href="https://ipp.developer.intuit.com/0010_Intuit_Partner_Platform/0050_Data_Services/
     * 0500_QuickBooks_Windows/0600_Object_Reference/VendorType">VendorType</a></p>
     */ 
    VENDORTYPE(VendorType.class, VendorTypeQuery.class);
    
    private final java.lang.Class<?> type;
    private final java.lang.Class<?> query;
    private final String urlReference;
    
    private WindowsEntityType(java.lang.Class<?> type, java.lang.Class<?> query)
    {
        this.type = type;
        this.query = query;
        this.urlReference = type.getSimpleName().toLowerCase();
    }
    
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
        return urlReference;
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
