
package org.mule.modules.quickbooks.online.config;

import javax.annotation.Generated;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/quickbooks</code>.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:35:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class QuickbooksNamespaceHandler
    extends NamespaceHandlerSupport
{


    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        registerBeanDefinitionParser("config", new QuickBooksOnlineModuleConfigDefinitionParser());
        registerBeanDefinitionParser("create-account", new CreateAccountDefinitionParser());
        registerBeanDefinitionParser("create-bill", new CreateBillDefinitionParser());
        registerBeanDefinitionParser("create-bill-payment", new CreateBillPaymentDefinitionParser());
        registerBeanDefinitionParser("create-purchase", new CreatePurchaseDefinitionParser());
        registerBeanDefinitionParser("create-customer", new CreateCustomerDefinitionParser());
        registerBeanDefinitionParser("create-estimate", new CreateEstimateDefinitionParser());
        registerBeanDefinitionParser("create-invoice", new CreateInvoiceDefinitionParser());
        registerBeanDefinitionParser("create-item", new CreateItemDefinitionParser());
        registerBeanDefinitionParser("create-journal-entry", new CreateJournalEntryDefinitionParser());
        registerBeanDefinitionParser("create-payment", new CreatePaymentDefinitionParser());
        registerBeanDefinitionParser("create-payment-method", new CreatePaymentMethodDefinitionParser());
        registerBeanDefinitionParser("create-sales-receipt", new CreateSalesReceiptDefinitionParser());
        registerBeanDefinitionParser("create-term", new CreateTermDefinitionParser());
        registerBeanDefinitionParser("create-vendor", new CreateVendorDefinitionParser());
        registerBeanDefinitionParser("get-object", new GetObjectDefinitionParser());
        registerBeanDefinitionParser("update-account", new UpdateAccountDefinitionParser());
        registerBeanDefinitionParser("update-bill", new UpdateBillDefinitionParser());
        registerBeanDefinitionParser("update-bill-payment", new UpdateBillPaymentDefinitionParser());
        registerBeanDefinitionParser("update-purchase", new UpdatePurchaseDefinitionParser());
        registerBeanDefinitionParser("update-customer", new UpdateCustomerDefinitionParser());
        registerBeanDefinitionParser("update-estimate", new UpdateEstimateDefinitionParser());
        registerBeanDefinitionParser("update-invoice", new UpdateInvoiceDefinitionParser());
        registerBeanDefinitionParser("update-item", new UpdateItemDefinitionParser());
        registerBeanDefinitionParser("update-journal-entry", new UpdateJournalEntryDefinitionParser());
        registerBeanDefinitionParser("update-payment", new UpdatePaymentDefinitionParser());
        registerBeanDefinitionParser("update-payment-method", new UpdatePaymentMethodDefinitionParser());
        registerBeanDefinitionParser("update-sales-receipt", new UpdateSalesReceiptDefinitionParser());
        registerBeanDefinitionParser("update-term", new UpdateTermDefinitionParser());
        registerBeanDefinitionParser("update-vendor", new UpdateVendorDefinitionParser());
        registerBeanDefinitionParser("delete-object", new DeleteObjectDefinitionParser());
        registerBeanDefinitionParser("delete-object-with-id", new DeleteObjectWithIdDefinitionParser());
        registerBeanDefinitionParser("query", new QueryDefinitionParser());
        registerBeanDefinitionParser("query-with-metadata", new QueryWithMetadataDefinitionParser());
        registerBeanDefinitionParser("paginated-query", new PaginatedQueryDefinitionParser());
        registerBeanDefinitionParser("get-current-user", new GetCurrentUserDefinitionParser());
        registerBeanDefinitionParser("get-company-info", new GetCompanyInfoDefinitionParser());
        registerBeanDefinitionParser("auth-user", new AuthUserDefinitionParser());
        registerBeanDefinitionParser("get-access-token", new GetAccessTokenDefinitionParser());
        registerBeanDefinitionParser("open-id-initialize", new OpenIdInitializeDefinitionParser());
        registerBeanDefinitionParser("verify-open-id", new VerifyOpenIdDefinitionParser());
        registerBeanDefinitionParser("get-blue-dot-information", new GetBlueDotInformationDefinitionParser());
        registerBeanDefinitionParser("disconnect", new DisconnectDefinitionParser());
        registerBeanDefinitionParser("reconnect", new ReconnectDefinitionParser());
    }

}
