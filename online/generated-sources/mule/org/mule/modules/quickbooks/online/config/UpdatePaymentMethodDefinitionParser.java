
package org.mule.modules.quickbooks.online.config;

import javax.annotation.Generated;
import com.intuit.ipp.data.holders.AttachableRefExpressionHolder;
import com.intuit.ipp.data.holders.CustomFieldExpressionHolder;
import com.intuit.ipp.data.holders.IntuitAnyTypeExpressionHolder;
import com.intuit.ipp.data.holders.ModificationMetaDataExpressionHolder;
import com.intuit.ipp.data.holders.PaymentMethodExpressionHolder;
import com.intuit.ipp.data.holders.ReferenceTypeExpressionHolder;
import org.mule.modules.quickbooks.online.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.quickbooks.online.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.quickbooks.online.processors.UpdatePaymentMethodMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T10:01:32-05:00", comments = "Build 3.4.3.1620.30ea288")
public class UpdatePaymentMethodDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(UpdatePaymentMethodMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "accessTokenId", "accessTokenId");
        if (!parseObjectRefWithDefault(element, builder, "payment-method", "paymentMethod", "#[payload]")) {
            BeanDefinitionBuilder paymentMethodBuilder = BeanDefinitionBuilder.rootBeanDefinition(PaymentMethodExpressionHolder.class.getName());
            Element paymentMethodChildElement = DomUtils.getChildElementByTagName(element, "payment-method");
            if (paymentMethodChildElement!= null) {
                parseProperty(paymentMethodBuilder, paymentMethodChildElement, "serialVersionUID", "serialVersionUID");
                parseProperty(paymentMethodBuilder, paymentMethodChildElement, "id", "id");
                parseProperty(paymentMethodBuilder, paymentMethodChildElement, "syncToken", "syncToken");
                if (!parseObjectRef(paymentMethodChildElement, paymentMethodBuilder, "meta-data", "metaData")) {
                    BeanDefinitionBuilder __metaDataBuilder = BeanDefinitionBuilder.rootBeanDefinition(ModificationMetaDataExpressionHolder.class.getName());
                    Element __metaDataChildElement = DomUtils.getChildElementByTagName(paymentMethodChildElement, "meta-data");
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
                        paymentMethodBuilder.addPropertyValue("metaData", __metaDataBuilder.getBeanDefinition());
                    }
                }
                parseListAndSetProperty(paymentMethodChildElement, paymentMethodBuilder, "customField", "custom-field", "custom-field", new ParseDelegate<BeanDefinition>() {


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
                parseListAndSetProperty(paymentMethodChildElement, paymentMethodBuilder, "attachableRef", "attachable-ref", "attachable-ref", new ParseDelegate<BeanDefinition>() {


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
                parseProperty(paymentMethodBuilder, paymentMethodChildElement, "domain", "domain");
                parseProperty(paymentMethodBuilder, paymentMethodChildElement, "status", "status");
                parseProperty(paymentMethodBuilder, paymentMethodChildElement, "sparse", "sparse");
                parseProperty(paymentMethodBuilder, paymentMethodChildElement, "name", "name");
                parseProperty(paymentMethodBuilder, paymentMethodChildElement, "active", "active");
                parseProperty(paymentMethodBuilder, paymentMethodChildElement, "type", "type");
                if (!parseObjectRef(paymentMethodChildElement, paymentMethodBuilder, "payment-method-ex", "paymentMethodEx")) {
                    BeanDefinitionBuilder _paymentMethodExBuilder = BeanDefinitionBuilder.rootBeanDefinition(IntuitAnyTypeExpressionHolder.class.getName());
                    Element _paymentMethodExChildElement = DomUtils.getChildElementByTagName(paymentMethodChildElement, "payment-method-ex");
                    if (_paymentMethodExChildElement!= null) {
                        parseListAndSetProperty(_paymentMethodExChildElement, _paymentMethodExBuilder, "any", "any", "any", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        paymentMethodBuilder.addPropertyValue("paymentMethodEx", _paymentMethodExBuilder.getBeanDefinition());
                    }
                }
                builder.addPropertyValue("paymentMethod", paymentMethodBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
