
package org.mule.modules.quickbooks.windows.config;

import javax.annotation.Generated;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/quickbooks-windows</code>.
 * 
 */
@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T09:57:16-05:00", comments = "Build 3.4.3.1620.30ea288")
public class QuickbooksWindowsNamespaceHandler
    extends NamespaceHandlerSupport
{


    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        registerBeanDefinitionParser("config", new QuickBooksWindowsModuleConfigDefinitionParser());
        registerBeanDefinitionParser("create", new CreateDefinitionParser());
        registerBeanDefinitionParser("get-object", new GetObjectDefinitionParser());
        registerBeanDefinitionParser("revert", new RevertDefinitionParser());
        registerBeanDefinitionParser("update", new UpdateDefinitionParser());
        registerBeanDefinitionParser("delete", new DeleteDefinitionParser());
        registerBeanDefinitionParser("find-objects", new FindObjectsDefinitionParser());
        registerBeanDefinitionParser("generate-a-new-request-id", new GenerateANewRequestIdDefinitionParser());
        registerBeanDefinitionParser("status", new StatusDefinitionParser());
        registerBeanDefinitionParser("sync-activity", new SyncActivityDefinitionParser());
        registerBeanDefinitionParser("get-current-user", new GetCurrentUserDefinitionParser());
        registerBeanDefinitionParser("get-company-metadata", new GetCompanyMetadataDefinitionParser());
        registerBeanDefinitionParser("auth-user", new AuthUserDefinitionParser());
        registerBeanDefinitionParser("get-access-token", new GetAccessTokenDefinitionParser());
        registerBeanDefinitionParser("open-id-initialize", new OpenIdInitializeDefinitionParser());
        registerBeanDefinitionParser("verify-open-id", new VerifyOpenIdDefinitionParser());
        registerBeanDefinitionParser("disconnect", new DisconnectDefinitionParser());
        registerBeanDefinitionParser("get-blue-dot-information", new GetBlueDotInformationDefinitionParser());
        registerBeanDefinitionParser("blue-dot-menu", new BlueDotMenuDefinitionParser());
        registerBeanDefinitionParser("reconnect", new ReconnectDefinitionParser());
    }

}
