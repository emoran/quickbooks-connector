
package org.mule.modules.quickbooks.online.config;

import javax.annotation.Generated;
import com.intuit.ipp.data.holders.AttachableRefExpressionHolder;
import com.intuit.ipp.data.holders.CustomFieldExpressionHolder;
import com.intuit.ipp.data.holders.IntuitAnyTypeExpressionHolder;
import com.intuit.ipp.data.holders.ModificationMetaDataExpressionHolder;
import com.intuit.ipp.data.holders.ReferenceTypeExpressionHolder;
import com.intuit.ipp.data.holders.TermExpressionHolder;
import org.mule.modules.quickbooks.online.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.quickbooks.online.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.quickbooks.online.processors.UpdateTermMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-15T04:14:53-05:00", comments = "Build 3.4.3.1620.30ea288")
public class UpdateTermDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(UpdateTermMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "accessTokenId", "accessTokenId");
        if (!parseObjectRefWithDefault(element, builder, "term", "term", "#[payload]")) {
            BeanDefinitionBuilder termBuilder = BeanDefinitionBuilder.rootBeanDefinition(TermExpressionHolder.class.getName());
            Element termChildElement = DomUtils.getChildElementByTagName(element, "term");
            if (termChildElement!= null) {
                parseProperty(termBuilder, termChildElement, "serialVersionUID", "serialVersionUID");
                parseProperty(termBuilder, termChildElement, "id", "id");
                parseProperty(termBuilder, termChildElement, "syncToken", "syncToken");
                if (!parseObjectRef(termChildElement, termBuilder, "meta-data", "metaData")) {
                    BeanDefinitionBuilder __metaDataBuilder = BeanDefinitionBuilder.rootBeanDefinition(ModificationMetaDataExpressionHolder.class.getName());
                    Element __metaDataChildElement = DomUtils.getChildElementByTagName(termChildElement, "meta-data");
                    if (__metaDataChildElement!= null) {
                        if (!parseObjectRef(__metaDataChildElement, __metaDataBuilder, "created-by-ref", "createdByRef")) {
                            BeanDefinitionBuilder ___createdByRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                            Element ___createdByRefChildElement = DomUtils.getChildElementByTagName(__metaDataChildElement, "created-by-ref");
                            if (___createdByRefChildElement!= null) {
                                parseProperty(___createdByRefBuilder, ___createdByRefChildElement, "value", "value");
                                parseProperty(___createdByRefBuilder, ___createdByRefChildElement, "name", "name");
                                parseProperty(___createdByRefBuilder, ___createdByRefChildElement, "type", "type");
                                __metaDataBuilder.addPropertyValue("createdByRef", ___createdByRefBuilder.getBeanDefinition());
                            }
                        }
                        parseProperty(__metaDataBuilder, __metaDataChildElement, "createTime", "createTime");
                        if (!parseObjectRef(__metaDataChildElement, __metaDataBuilder, "last-modified-by-ref", "lastModifiedByRef")) {
                            BeanDefinitionBuilder ___lastModifiedByRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                            Element ___lastModifiedByRefChildElement = DomUtils.getChildElementByTagName(__metaDataChildElement, "last-modified-by-ref");
                            if (___lastModifiedByRefChildElement!= null) {
                                parseProperty(___lastModifiedByRefBuilder, ___lastModifiedByRefChildElement, "value", "value");
                                parseProperty(___lastModifiedByRefBuilder, ___lastModifiedByRefChildElement, "name", "name");
                                parseProperty(___lastModifiedByRefBuilder, ___lastModifiedByRefChildElement, "type", "type");
                                __metaDataBuilder.addPropertyValue("lastModifiedByRef", ___lastModifiedByRefBuilder.getBeanDefinition());
                            }
                        }
                        parseProperty(__metaDataBuilder, __metaDataChildElement, "lastUpdatedTime", "lastUpdatedTime");
                        parseProperty(__metaDataBuilder, __metaDataChildElement, "lastChangedInQB", "lastChangedInQB");
                        termBuilder.addPropertyValue("metaData", __metaDataBuilder.getBeanDefinition());
                    }
                }
                parseListAndSetProperty(termChildElement, termBuilder, "customField", "custom-field", "custom-field", new ParseDelegate<BeanDefinition>() {


                    public BeanDefinition parse(Element element) {
                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(CustomFieldExpressionHolder.class);
                        parseProperty(builder, element, "definitionId", "definitionId");
                        parseProperty(builder, element, "name", "name");
                        parseProperty(builder, element, "type", "type");
                        parseProperty(builder, element, "stringValue", "stringValue");
                        parseProperty(builder, element, "booleanValue", "booleanValue");
                        parseProperty(builder, element, "dateValue", "dateValue");
                        parseProperty(builder, element, "numberValue", "numberValue");
                        return builder.getBeanDefinition();
                    }

                }
                );
                parseListAndSetProperty(termChildElement, termBuilder, "attachableRef", "attachable-ref", "attachable-ref", new ParseDelegate<BeanDefinition>() {


                    public BeanDefinition parse(Element element) {
                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(AttachableRefExpressionHolder.class);
                        if (!parseObjectRef(element, builder, "entity-ref", "entityRef")) {
                            BeanDefinitionBuilder ___entityRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                            Element ___entityRefChildElement = DomUtils.getChildElementByTagName(element, "entity-ref");
                            if (___entityRefChildElement!= null) {
                                parseProperty(___entityRefBuilder, ___entityRefChildElement, "value", "value");
                                parseProperty(___entityRefBuilder, ___entityRefChildElement, "name", "name");
                                parseProperty(___entityRefBuilder, ___entityRefChildElement, "type", "type");
                                builder.addPropertyValue("entityRef", ___entityRefBuilder.getBeanDefinition());
                            }
                        }
                        parseProperty(builder, element, "lineInfo", "lineInfo");
                        parseProperty(builder, element, "includeOnSend", "includeOnSend");
                        parseListAndSetProperty(element, builder, "customField", "custom-field", "custom-field", new ParseDelegate<BeanDefinition>() {


                            public BeanDefinition parse(Element element) {
                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(CustomFieldExpressionHolder.class);
                                parseProperty(builder, element, "definitionId", "definitionId");
                                parseProperty(builder, element, "name", "name");
                                parseProperty(builder, element, "type", "type");
                                parseProperty(builder, element, "stringValue", "stringValue");
                                parseProperty(builder, element, "booleanValue", "booleanValue");
                                parseProperty(builder, element, "dateValue", "dateValue");
                                parseProperty(builder, element, "numberValue", "numberValue");
                                return builder.getBeanDefinition();
                            }

                        }
                        );
                        if (!parseObjectRef(element, builder, "attachable-ref-ex", "attachableRefEx")) {
                            BeanDefinitionBuilder ___attachableRefExBuilder = BeanDefinitionBuilder.rootBeanDefinition(IntuitAnyTypeExpressionHolder.class.getName());
                            Element ___attachableRefExChildElement = DomUtils.getChildElementByTagName(element, "attachable-ref-ex");
                            if (___attachableRefExChildElement!= null) {
                                parseListAndSetProperty(___attachableRefExChildElement, ___attachableRefExBuilder, "any", "any", "any", new ParseDelegate<String>() {


                                    public String parse(Element element) {
                                        return element.getTextContent();
                                    }

                                }
                                );
                                builder.addPropertyValue("attachableRefEx", ___attachableRefExBuilder.getBeanDefinition());
                            }
                        }
                        return builder.getBeanDefinition();
                    }

                }
                );
                parseProperty(termBuilder, termChildElement, "domain", "domain");
                parseProperty(termBuilder, termChildElement, "status", "status");
                parseProperty(termBuilder, termChildElement, "sparse", "sparse");
                parseProperty(termBuilder, termChildElement, "name", "name");
                parseProperty(termBuilder, termChildElement, "active", "active");
                parseProperty(termBuilder, termChildElement, "type", "type");
                parseProperty(termBuilder, termChildElement, "discountPercent", "discountPercent");
                parseProperty(termBuilder, termChildElement, "dueDays", "dueDays");
                parseProperty(termBuilder, termChildElement, "discountDays", "discountDays");
                parseProperty(termBuilder, termChildElement, "dayOfMonthDue", "dayOfMonthDue");
                parseProperty(termBuilder, termChildElement, "dueNextMonthDays", "dueNextMonthDays");
                parseProperty(termBuilder, termChildElement, "discountDayOfMonth", "discountDayOfMonth");
                if (!parseObjectRef(termChildElement, termBuilder, "sales-term-ex", "salesTermEx")) {
                    BeanDefinitionBuilder _salesTermExBuilder = BeanDefinitionBuilder.rootBeanDefinition(IntuitAnyTypeExpressionHolder.class.getName());
                    Element _salesTermExChildElement = DomUtils.getChildElementByTagName(termChildElement, "sales-term-ex");
                    if (_salesTermExChildElement!= null) {
                        parseListAndSetProperty(_salesTermExChildElement, _salesTermExBuilder, "any", "any", "any", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        termBuilder.addPropertyValue("salesTermEx", _salesTermExBuilder.getBeanDefinition());
                    }
                }
                builder.addPropertyValue("term", termBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
