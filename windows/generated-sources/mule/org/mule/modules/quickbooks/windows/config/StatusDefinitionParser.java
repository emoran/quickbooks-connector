
package org.mule.modules.quickbooks.windows.config;

import javax.annotation.Generated;
import org.mule.modules.quickbooks.windows.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.quickbooks.windows.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.quickbooks.windows.processors.StatusMessageProcessor;
import org.mule.modules.quickbooks.windows.schema.holders.IdSetExpressionHolder;
import org.mule.modules.quickbooks.windows.schema.holders.IdTypeExpressionHolder;
import org.mule.modules.quickbooks.windows.schema.holders.NgIdSetExpressionHolder;
import org.mule.modules.quickbooks.windows.schema.holders.SyncStatusParamExpressionHolder;
import org.mule.modules.quickbooks.windows.schema.holders.SyncStatusRequestExpressionHolder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:33:09-05:00", comments = "Build 3.4.3.1620.30ea288")
public class StatusDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(StatusMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "accessTokenId", "accessTokenId");
        if (!parseObjectRefWithDefault(element, builder, "sync-status-request", "syncStatusRequest", "#[payload]")) {
            BeanDefinitionBuilder syncStatusRequestBuilder = BeanDefinitionBuilder.rootBeanDefinition(SyncStatusRequestExpressionHolder.class.getName());
            Element syncStatusRequestChildElement = DomUtils.getChildElementByTagName(element, "sync-status-request");
            if (syncStatusRequestChildElement!= null) {
                parseProperty(syncStatusRequestBuilder, syncStatusRequestChildElement, "offeringId", "offeringId");
                parseListAndSetProperty(syncStatusRequestChildElement, syncStatusRequestBuilder, "ngIdSet", "ng-id-set", "ng-id-set", new ParseDelegate<BeanDefinition>() {


                    public BeanDefinition parse(Element element) {
                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(NgIdSetExpressionHolder.class);
                        parseProperty(builder, element, "ngId", "ngId");
                        parseProperty(builder, element, "syncToken", "syncToken");
                        parseProperty(builder, element, "ngObjectType", "ngObjectType");
                        parseProperty(builder, element, "partyId", "partyId");
                        return builder.getBeanDefinition();
                    }

                }
                );
                parseListAndSetProperty(syncStatusRequestChildElement, syncStatusRequestBuilder, "syncStatusParam", "sync-status-param", "sync-status-param", new ParseDelegate<BeanDefinition>() {


                    public BeanDefinition parse(Element element) {
                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(SyncStatusParamExpressionHolder.class);
                        if (!parseObjectRef(element, builder, "id-set", "idSet")) {
                            BeanDefinitionBuilder __idSetBuilder = BeanDefinitionBuilder.rootBeanDefinition(IdSetExpressionHolder.class.getName());
                            Element __idSetChildElement = DomUtils.getChildElementByTagName(element, "id-set");
                            if (__idSetChildElement!= null) {
                                parseListAndSetProperty(__idSetChildElement, __idSetBuilder, "id", "id", "id", new ParseDelegate<BeanDefinition>() {


                                    public BeanDefinition parse(Element element) {
                                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(IdTypeExpressionHolder.class);
                                        parseProperty(builder, element, "value", "value");
                                        parseProperty(builder, element, "idDomain", "idDomain");
                                        return builder.getBeanDefinition();
                                    }

                                }
                                );
                                builder.addPropertyValue("idSet", __idSetBuilder.getBeanDefinition());
                            }
                        }
                        parseProperty(builder, element, "syncToken", "syncToken");
                        parseProperty(builder, element, "objectType", "objectType");
                        parseProperty(builder, element, "partyId", "partyId");
                        return builder.getBeanDefinition();
                    }

                }
                );
                parseListAndSetProperty(syncStatusRequestChildElement, syncStatusRequestBuilder, "requestId", "request-id", "request-id", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseListAndSetProperty(syncStatusRequestChildElement, syncStatusRequestBuilder, "batchId", "batch-id", "batch-id", new ParseDelegate<String>() {


                    public String parse(Element element) {
                        return element.getTextContent();
                    }

                }
                );
                parseProperty(syncStatusRequestBuilder, syncStatusRequestChildElement, "startCreatedTMS", "startCreatedTMS");
                parseProperty(syncStatusRequestBuilder, syncStatusRequestChildElement, "endCreatedTMS", "endCreatedTMS");
                parseProperty(syncStatusRequestBuilder, syncStatusRequestChildElement, "erroredObjectsOnly", "erroredObjectsOnly");
                builder.addPropertyValue("syncStatusRequest", syncStatusRequestBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
