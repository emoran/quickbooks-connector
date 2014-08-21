
package org.mule.modules.quickbooks.online.config;

import javax.annotation.Generated;
import org.mule.modules.quickbooks.online.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.quickbooks.online.processors.VerifyOpenIdMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-21T02:54:07-05:00", comments = "Build 3.4.3.1620.30ea288")
public class VerifyOpenIdDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(VerifyOpenIdMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "receivingUrl", "receivingUrl");
        parseMapWithDefaultAndSetProperty(element, builder, "responseParameters", "response-parameters", "response-parameter", "#[header:INBOUND:http.query.params]", new ParseDelegate<String>() {


            public String parse(Element element) {
                return element.getTextContent();
            }

        }
        );
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
