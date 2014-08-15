
package org.mule.modules.quickbooks.windows.config;

import javax.annotation.Generated;
import org.mule.modules.quickbooks.windows.processors.GetObjectMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-15T04:12:18-05:00", comments = "Build 3.4.3.1620.30ea288")
public class GetObjectDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(GetObjectMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "accessTokenId", "accessTokenId");
        parseProperty(builder, element, "type", "type");
        if (hasAttribute(element, "idType-ref")) {
            if (element.getAttribute("idType-ref").startsWith("#")) {
                builder.addPropertyValue("idType", element.getAttribute("idType-ref"));
            } else {
                builder.addPropertyValue("idType", (("#[registry:"+ element.getAttribute("idType-ref"))+"]"));
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
