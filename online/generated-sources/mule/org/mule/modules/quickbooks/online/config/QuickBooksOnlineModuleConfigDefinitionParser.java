
package org.mule.modules.quickbooks.online.config;

import javax.annotation.Generated;
import org.mule.modules.quickbooks.online.adapters.QuickBooksOnlineModuleProcessAdapter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-25T05:23:44-05:00", comments = "Build 3.4.3.1620.30ea288")
public class QuickBooksOnlineModuleConfigDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        parseConfigName(element);
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(QuickBooksOnlineModuleProcessAdapter.class.getName());
        builder.setScope(BeanDefinition.SCOPE_SINGLETON);
        setInitMethodIfNeeded(builder, QuickBooksOnlineModuleProcessAdapter.class);
        setDestroyMethodIfNeeded(builder, QuickBooksOnlineModuleProcessAdapter.class);
        parseProperty(builder, element, "consumerKey", "consumerKey");
        parseProperty(builder, element, "consumerSecret", "consumerSecret");
        if (hasAttribute(element, "objectStore-ref")) {
            if (element.getAttribute("objectStore-ref").startsWith("#")) {
                builder.addPropertyValue("objectStore", element.getAttribute("objectStore-ref"));
            } else {
                builder.addPropertyValue("objectStore", new RuntimeBeanReference(element.getAttribute("objectStore-ref")));
            }
        }
        if (hasAttribute(element, "client-ref")) {
            if (element.getAttribute("client-ref").startsWith("#")) {
                builder.addPropertyValue("client", element.getAttribute("client-ref"));
            } else {
                builder.addPropertyValue("client", new RuntimeBeanReference(element.getAttribute("client-ref")));
            }
        }
        parseProperty(builder, element, "baseUri", "baseUri");
        parseProperty(builder, element, "platformBaseUri", "platformBaseUri");
        parseProperty(builder, element, "retryCount", "retryCount");
        parseProperty(builder, element, "retryInterval", "retryInterval");
        parseProperty(builder, element, "connectionTimeOut", "connectionTimeOut");
        parseProperty(builder, element, "requestTimeOut", "requestTimeOut");
        parseProperty(builder, element, "accessTokenIdentifierPrefix", "accessTokenIdentifierPrefix");
        parseProperty(builder, element, "verifyOpenIdResponse", "verifyOpenIdResponse");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        return definition;
    }

}
