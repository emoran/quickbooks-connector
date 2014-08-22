
package org.mule.modules.quickbooks.online.config;

import javax.annotation.Generated;
import com.intuit.ipp.data.holders.AccountExpressionHolder;
import com.intuit.ipp.data.holders.AttachableRefExpressionHolder;
import com.intuit.ipp.data.holders.CustomFieldExpressionHolder;
import com.intuit.ipp.data.holders.IntuitAnyTypeExpressionHolder;
import com.intuit.ipp.data.holders.ModificationMetaDataExpressionHolder;
import com.intuit.ipp.data.holders.ReferenceTypeExpressionHolder;
import org.mule.modules.quickbooks.online.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.quickbooks.online.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.quickbooks.online.processors.UpdateAccountMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T10:01:32-05:00", comments = "Build 3.4.3.1620.30ea288")
public class UpdateAccountDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(UpdateAccountMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "accessTokenId", "accessTokenId");
        if (!parseObjectRefWithDefault(element, builder, "account", "account", "#[payload]")) {
            BeanDefinitionBuilder accountBuilder = BeanDefinitionBuilder.rootBeanDefinition(AccountExpressionHolder.class.getName());
            Element accountChildElement = DomUtils.getChildElementByTagName(element, "account");
            if (accountChildElement!= null) {
                parseProperty(accountBuilder, accountChildElement, "serialVersionUID", "serialVersionUID");
                parseProperty(accountBuilder, accountChildElement, "id", "id");
                parseProperty(accountBuilder, accountChildElement, "syncToken", "syncToken");
                if (!parseObjectRef(accountChildElement, accountBuilder, "meta-data", "metaData")) {
                    BeanDefinitionBuilder __metaDataBuilder = BeanDefinitionBuilder.rootBeanDefinition(ModificationMetaDataExpressionHolder.class.getName());
                    Element __metaDataChildElement = DomUtils.getChildElementByTagName(accountChildElement, "meta-data");
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
                        accountBuilder.addPropertyValue("metaData", __metaDataBuilder.getBeanDefinition());
                    }
                }
                parseListAndSetProperty(accountChildElement, accountBuilder, "customField", "custom-field", "custom-field", new ParseDelegate<BeanDefinition>() {


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
                parseListAndSetProperty(accountChildElement, accountBuilder, "attachableRef", "attachable-ref", "attachable-ref", new ParseDelegate<BeanDefinition>() {


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
                parseProperty(accountBuilder, accountChildElement, "domain", "domain");
                parseProperty(accountBuilder, accountChildElement, "status", "status");
                parseProperty(accountBuilder, accountChildElement, "sparse", "sparse");
                parseProperty(accountBuilder, accountChildElement, "name", "name");
                parseProperty(accountBuilder, accountChildElement, "subAccount", "subAccount");
                if (!parseObjectRef(accountChildElement, accountBuilder, "parent-ref", "parentRef")) {
                    BeanDefinitionBuilder _parentRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _parentRefChildElement = DomUtils.getChildElementByTagName(accountChildElement, "parent-ref");
                    if (_parentRefChildElement!= null) {
                        parseProperty(_parentRefBuilder, _parentRefChildElement, "value", "value");
                        parseProperty(_parentRefBuilder, _parentRefChildElement, "name", "name");
                        parseProperty(_parentRefBuilder, _parentRefChildElement, "type", "type");
                        accountBuilder.addPropertyValue("parentRef", _parentRefBuilder.getBeanDefinition());
                    }
                }
                parseProperty(accountBuilder, accountChildElement, "description", "description");
                parseProperty(accountBuilder, accountChildElement, "fullyQualifiedName", "fullyQualifiedName");
                parseProperty(accountBuilder, accountChildElement, "active", "active");
                parseProperty(accountBuilder, accountChildElement, "classification", "classification");
                parseProperty(accountBuilder, accountChildElement, "accountType", "accountType");
                parseProperty(accountBuilder, accountChildElement, "accountSubType", "accountSubType");
                parseProperty(accountBuilder, accountChildElement, "acctNum", "acctNum");
                parseProperty(accountBuilder, accountChildElement, "bankNum", "bankNum");
                parseProperty(accountBuilder, accountChildElement, "openingBalance", "openingBalance");
                parseProperty(accountBuilder, accountChildElement, "openingBalanceDate", "openingBalanceDate");
                parseProperty(accountBuilder, accountChildElement, "currentBalance", "currentBalance");
                parseProperty(accountBuilder, accountChildElement, "currentBalanceWithSubAccounts", "currentBalanceWithSubAccounts");
                if (!parseObjectRef(accountChildElement, accountBuilder, "currency-ref", "currencyRef")) {
                    BeanDefinitionBuilder _currencyRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _currencyRefChildElement = DomUtils.getChildElementByTagName(accountChildElement, "currency-ref");
                    if (_currencyRefChildElement!= null) {
                        parseProperty(_currencyRefBuilder, _currencyRefChildElement, "value", "value");
                        parseProperty(_currencyRefBuilder, _currencyRefChildElement, "name", "name");
                        parseProperty(_currencyRefBuilder, _currencyRefChildElement, "type", "type");
                        accountBuilder.addPropertyValue("currencyRef", _currencyRefBuilder.getBeanDefinition());
                    }
                }
                parseProperty(accountBuilder, accountChildElement, "taxAccount", "taxAccount");
                if (!parseObjectRef(accountChildElement, accountBuilder, "tax-code-ref", "taxCodeRef")) {
                    BeanDefinitionBuilder _taxCodeRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _taxCodeRefChildElement = DomUtils.getChildElementByTagName(accountChildElement, "tax-code-ref");
                    if (_taxCodeRefChildElement!= null) {
                        parseProperty(_taxCodeRefBuilder, _taxCodeRefChildElement, "value", "value");
                        parseProperty(_taxCodeRefBuilder, _taxCodeRefChildElement, "name", "name");
                        parseProperty(_taxCodeRefBuilder, _taxCodeRefChildElement, "type", "type");
                        accountBuilder.addPropertyValue("taxCodeRef", _taxCodeRefBuilder.getBeanDefinition());
                    }
                }
                parseProperty(accountBuilder, accountChildElement, "onlineBankingEnabled", "onlineBankingEnabled");
                if (!parseObjectRef(accountChildElement, accountBuilder, "account-ex", "accountEx")) {
                    BeanDefinitionBuilder _accountExBuilder = BeanDefinitionBuilder.rootBeanDefinition(IntuitAnyTypeExpressionHolder.class.getName());
                    Element _accountExChildElement = DomUtils.getChildElementByTagName(accountChildElement, "account-ex");
                    if (_accountExChildElement!= null) {
                        parseListAndSetProperty(_accountExChildElement, _accountExBuilder, "any", "any", "any", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        accountBuilder.addPropertyValue("accountEx", _accountExBuilder.getBeanDefinition());
                    }
                }
                builder.addPropertyValue("account", accountBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
