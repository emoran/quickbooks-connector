
package org.mule.modules.quickbooks.windows.config;

import javax.annotation.Generated;
import org.mule.modules.quickbooks.windows.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.quickbooks.windows.processors.FindObjectsMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-15T04:12:18-05:00", comments = "Build 3.4.3.1620.30ea288")
public class FindObjectsDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(FindObjectsMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "accessTokenId", "accessTokenId");
        parseProperty(builder, element, "type", "type");
        parseProperty(builder, element, "startPage", "startPage");
        parseProperty(builder, element, "chunkSize", "chunkSize");
        parseMapAndSetProperty(element, builder, "query", "query", "query", new ParseDelegate<String>() {


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
