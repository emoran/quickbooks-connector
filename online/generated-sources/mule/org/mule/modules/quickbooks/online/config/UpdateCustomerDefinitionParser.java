
package org.mule.modules.quickbooks.online.config;

import javax.annotation.Generated;
import com.intuit.ipp.data.holders.AttachableRefExpressionHolder;
import com.intuit.ipp.data.holders.ContactInfoExpressionHolder;
import com.intuit.ipp.data.holders.CustomFieldExpressionHolder;
import com.intuit.ipp.data.holders.CustomerExpressionHolder;
import com.intuit.ipp.data.holders.EmailAddressExpressionHolder;
import com.intuit.ipp.data.holders.GenericContactTypeExpressionHolder;
import com.intuit.ipp.data.holders.IntuitAnyTypeExpressionHolder;
import com.intuit.ipp.data.holders.JobInfoExpressionHolder;
import com.intuit.ipp.data.holders.ModificationMetaDataExpressionHolder;
import com.intuit.ipp.data.holders.PhysicalAddressExpressionHolder;
import com.intuit.ipp.data.holders.ReferenceTypeExpressionHolder;
import com.intuit.ipp.data.holders.TelephoneNumberExpressionHolder;
import com.intuit.ipp.data.holders.WebSiteAddressExpressionHolder;
import org.mule.modules.quickbooks.online.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.quickbooks.online.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.quickbooks.online.processors.UpdateCustomerMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-15T04:14:53-05:00", comments = "Build 3.4.3.1620.30ea288")
public class UpdateCustomerDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(UpdateCustomerMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "accessTokenId", "accessTokenId");
        if (!parseObjectRefWithDefault(element, builder, "customer", "customer", "#[payload]")) {
            BeanDefinitionBuilder customerBuilder = BeanDefinitionBuilder.rootBeanDefinition(CustomerExpressionHolder.class.getName());
            Element customerChildElement = DomUtils.getChildElementByTagName(element, "customer");
            if (customerChildElement!= null) {
                parseProperty(customerBuilder, customerChildElement, "serialVersionUID", "serialVersionUID");
                parseProperty(customerBuilder, customerChildElement, "intuitId", "intuitId");
                parseProperty(customerBuilder, customerChildElement, "organization", "organization");
                parseProperty(customerBuilder, customerChildElement, "title", "title");
                parseProperty(customerBuilder, customerChildElement, "givenName", "givenName");
                parseProperty(customerBuilder, customerChildElement, "middleName", "middleName");
                parseProperty(customerBuilder, customerChildElement, "familyName", "familyName");
                parseProperty(customerBuilder, customerChildElement, "suffix", "suffix");
                parseProperty(customerBuilder, customerChildElement, "fullyQualifiedName", "fullyQualifiedName");
                parseProperty(customerBuilder, customerChildElement, "companyName", "companyName");
                parseProperty(customerBuilder, customerChildElement, "displayName", "displayName");
                parseProperty(customerBuilder, customerChildElement, "printOnCheckName", "printOnCheckName");
                parseProperty(customerBuilder, customerChildElement, "userId", "userId");
                parseProperty(customerBuilder, customerChildElement, "active", "active");
                if (!parseObjectRef(customerChildElement, customerBuilder, "primary-phone", "primaryPhone")) {
                    BeanDefinitionBuilder __primaryPhoneBuilder = BeanDefinitionBuilder.rootBeanDefinition(TelephoneNumberExpressionHolder.class.getName());
                    Element __primaryPhoneChildElement = DomUtils.getChildElementByTagName(customerChildElement, "primary-phone");
                    if (__primaryPhoneChildElement!= null) {
                        parseProperty(__primaryPhoneBuilder, __primaryPhoneChildElement, "id", "id");
                        parseProperty(__primaryPhoneBuilder, __primaryPhoneChildElement, "deviceType", "deviceType");
                        parseProperty(__primaryPhoneBuilder, __primaryPhoneChildElement, "countryCode", "countryCode");
                        parseProperty(__primaryPhoneBuilder, __primaryPhoneChildElement, "areaCode", "areaCode");
                        parseProperty(__primaryPhoneBuilder, __primaryPhoneChildElement, "exchangeCode", "exchangeCode");
                        parseProperty(__primaryPhoneBuilder, __primaryPhoneChildElement, "extension", "extension");
                        parseProperty(__primaryPhoneBuilder, __primaryPhoneChildElement, "freeFormNumber", "freeFormNumber");
                        parseProperty(__primaryPhoneBuilder, __primaryPhoneChildElement, "tag", "tag");
                        customerBuilder.addPropertyValue("primaryPhone", __primaryPhoneBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(customerChildElement, customerBuilder, "alternate-phone", "alternatePhone")) {
                    BeanDefinitionBuilder __alternatePhoneBuilder = BeanDefinitionBuilder.rootBeanDefinition(TelephoneNumberExpressionHolder.class.getName());
                    Element __alternatePhoneChildElement = DomUtils.getChildElementByTagName(customerChildElement, "alternate-phone");
                    if (__alternatePhoneChildElement!= null) {
                        parseProperty(__alternatePhoneBuilder, __alternatePhoneChildElement, "id", "id");
                        parseProperty(__alternatePhoneBuilder, __alternatePhoneChildElement, "deviceType", "deviceType");
                        parseProperty(__alternatePhoneBuilder, __alternatePhoneChildElement, "countryCode", "countryCode");
                        parseProperty(__alternatePhoneBuilder, __alternatePhoneChildElement, "areaCode", "areaCode");
                        parseProperty(__alternatePhoneBuilder, __alternatePhoneChildElement, "exchangeCode", "exchangeCode");
                        parseProperty(__alternatePhoneBuilder, __alternatePhoneChildElement, "extension", "extension");
                        parseProperty(__alternatePhoneBuilder, __alternatePhoneChildElement, "freeFormNumber", "freeFormNumber");
                        parseProperty(__alternatePhoneBuilder, __alternatePhoneChildElement, "tag", "tag");
                        customerBuilder.addPropertyValue("alternatePhone", __alternatePhoneBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(customerChildElement, customerBuilder, "mobile", "mobile")) {
                    BeanDefinitionBuilder __mobileBuilder = BeanDefinitionBuilder.rootBeanDefinition(TelephoneNumberExpressionHolder.class.getName());
                    Element __mobileChildElement = DomUtils.getChildElementByTagName(customerChildElement, "mobile");
                    if (__mobileChildElement!= null) {
                        parseProperty(__mobileBuilder, __mobileChildElement, "id", "id");
                        parseProperty(__mobileBuilder, __mobileChildElement, "deviceType", "deviceType");
                        parseProperty(__mobileBuilder, __mobileChildElement, "countryCode", "countryCode");
                        parseProperty(__mobileBuilder, __mobileChildElement, "areaCode", "areaCode");
                        parseProperty(__mobileBuilder, __mobileChildElement, "exchangeCode", "exchangeCode");
                        parseProperty(__mobileBuilder, __mobileChildElement, "extension", "extension");
                        parseProperty(__mobileBuilder, __mobileChildElement, "freeFormNumber", "freeFormNumber");
                        parseProperty(__mobileBuilder, __mobileChildElement, "tag", "tag");
                        customerBuilder.addPropertyValue("mobile", __mobileBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(customerChildElement, customerBuilder, "fax", "fax")) {
                    BeanDefinitionBuilder __faxBuilder = BeanDefinitionBuilder.rootBeanDefinition(TelephoneNumberExpressionHolder.class.getName());
                    Element __faxChildElement = DomUtils.getChildElementByTagName(customerChildElement, "fax");
                    if (__faxChildElement!= null) {
                        parseProperty(__faxBuilder, __faxChildElement, "id", "id");
                        parseProperty(__faxBuilder, __faxChildElement, "deviceType", "deviceType");
                        parseProperty(__faxBuilder, __faxChildElement, "countryCode", "countryCode");
                        parseProperty(__faxBuilder, __faxChildElement, "areaCode", "areaCode");
                        parseProperty(__faxBuilder, __faxChildElement, "exchangeCode", "exchangeCode");
                        parseProperty(__faxBuilder, __faxChildElement, "extension", "extension");
                        parseProperty(__faxBuilder, __faxChildElement, "freeFormNumber", "freeFormNumber");
                        parseProperty(__faxBuilder, __faxChildElement, "tag", "tag");
                        customerBuilder.addPropertyValue("fax", __faxBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(customerChildElement, customerBuilder, "primary-email-addr", "primaryEmailAddr")) {
                    BeanDefinitionBuilder __primaryEmailAddrBuilder = BeanDefinitionBuilder.rootBeanDefinition(EmailAddressExpressionHolder.class.getName());
                    Element __primaryEmailAddrChildElement = DomUtils.getChildElementByTagName(customerChildElement, "primary-email-addr");
                    if (__primaryEmailAddrChildElement!= null) {
                        parseProperty(__primaryEmailAddrBuilder, __primaryEmailAddrChildElement, "id", "id");
                        parseProperty(__primaryEmailAddrBuilder, __primaryEmailAddrChildElement, "address", "address");
                        parseProperty(__primaryEmailAddrBuilder, __primaryEmailAddrChildElement, "tag", "tag");
                        customerBuilder.addPropertyValue("primaryEmailAddr", __primaryEmailAddrBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(customerChildElement, customerBuilder, "web-addr", "webAddr")) {
                    BeanDefinitionBuilder __webAddrBuilder = BeanDefinitionBuilder.rootBeanDefinition(WebSiteAddressExpressionHolder.class.getName());
                    Element __webAddrChildElement = DomUtils.getChildElementByTagName(customerChildElement, "web-addr");
                    if (__webAddrChildElement!= null) {
                        parseProperty(__webAddrBuilder, __webAddrChildElement, "id", "id");
                        parseProperty(__webAddrBuilder, __webAddrChildElement, "tag", "tag");
                        customerBuilder.addPropertyValue("webAddr", __webAddrBuilder.getBeanDefinition());
                    }
                }
                parseListAndSetProperty(customerChildElement, customerBuilder, "otherContactInfo", "other-contact-info", "other-contact-info", new ParseDelegate<BeanDefinition>() {


                    public BeanDefinition parse(Element element) {
                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(ContactInfoExpressionHolder.class);
                        parseProperty(builder, element, "type", "type");
                        if (!parseObjectRef(element, builder, "telephone", "telephone")) {
                            BeanDefinitionBuilder ___telephoneBuilder = BeanDefinitionBuilder.rootBeanDefinition(TelephoneNumberExpressionHolder.class.getName());
                            Element ___telephoneChildElement = DomUtils.getChildElementByTagName(element, "telephone");
                            if (___telephoneChildElement!= null) {
                                parseProperty(___telephoneBuilder, ___telephoneChildElement, "id", "id");
                                parseProperty(___telephoneBuilder, ___telephoneChildElement, "deviceType", "deviceType");
                                parseProperty(___telephoneBuilder, ___telephoneChildElement, "countryCode", "countryCode");
                                parseProperty(___telephoneBuilder, ___telephoneChildElement, "areaCode", "areaCode");
                                parseProperty(___telephoneBuilder, ___telephoneChildElement, "exchangeCode", "exchangeCode");
                                parseProperty(___telephoneBuilder, ___telephoneChildElement, "extension", "extension");
                                parseProperty(___telephoneBuilder, ___telephoneChildElement, "freeFormNumber", "freeFormNumber");
                                parseProperty(___telephoneBuilder, ___telephoneChildElement, "tag", "tag");
                                builder.addPropertyValue("telephone", ___telephoneBuilder.getBeanDefinition());
                            }
                        }
                        if (!parseObjectRef(element, builder, "email", "email")) {
                            BeanDefinitionBuilder ___emailBuilder = BeanDefinitionBuilder.rootBeanDefinition(EmailAddressExpressionHolder.class.getName());
                            Element ___emailChildElement = DomUtils.getChildElementByTagName(element, "email");
                            if (___emailChildElement!= null) {
                                parseProperty(___emailBuilder, ___emailChildElement, "id", "id");
                                parseProperty(___emailBuilder, ___emailChildElement, "address", "address");
                                parseProperty(___emailBuilder, ___emailChildElement, "tag", "tag");
                                builder.addPropertyValue("email", ___emailBuilder.getBeanDefinition());
                            }
                        }
                        if (!parseObjectRef(element, builder, "web-site", "webSite")) {
                            BeanDefinitionBuilder ___webSiteBuilder = BeanDefinitionBuilder.rootBeanDefinition(WebSiteAddressExpressionHolder.class.getName());
                            Element ___webSiteChildElement = DomUtils.getChildElementByTagName(element, "web-site");
                            if (___webSiteChildElement!= null) {
                                parseProperty(___webSiteBuilder, ___webSiteChildElement, "id", "id");
                                parseProperty(___webSiteBuilder, ___webSiteChildElement, "tag", "tag");
                                builder.addPropertyValue("webSite", ___webSiteBuilder.getBeanDefinition());
                            }
                        }
                        if (!parseObjectRef(element, builder, "other-contact", "otherContact")) {
                            BeanDefinitionBuilder ___otherContactBuilder = BeanDefinitionBuilder.rootBeanDefinition(GenericContactTypeExpressionHolder.class.getName());
                            Element ___otherContactChildElement = DomUtils.getChildElementByTagName(element, "other-contact");
                            if (___otherContactChildElement!= null) {
                                parseProperty(___otherContactBuilder, ___otherContactChildElement, "id", "id");
                                parseProperty(___otherContactBuilder, ___otherContactChildElement, "name", "name");
                                parseProperty(___otherContactBuilder, ___otherContactChildElement, "value", "value");
                                parseProperty(___otherContactBuilder, ___otherContactChildElement, "type", "type");
                                parseProperty(___otherContactBuilder, ___otherContactChildElement, "tag", "tag");
                                builder.addPropertyValue("otherContact", ___otherContactBuilder.getBeanDefinition());
                            }
                        }
                        return builder.getBeanDefinition();
                    }

                }
                );
                if (!parseObjectRef(customerChildElement, customerBuilder, "default-tax-code-ref", "defaultTaxCodeRef")) {
                    BeanDefinitionBuilder __defaultTaxCodeRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element __defaultTaxCodeRefChildElement = DomUtils.getChildElementByTagName(customerChildElement, "default-tax-code-ref");
                    if (__defaultTaxCodeRefChildElement!= null) {
                        parseProperty(__defaultTaxCodeRefBuilder, __defaultTaxCodeRefChildElement, "value", "value");
                        parseProperty(__defaultTaxCodeRefBuilder, __defaultTaxCodeRefChildElement, "name", "name");
                        parseProperty(__defaultTaxCodeRefBuilder, __defaultTaxCodeRefChildElement, "type", "type");
                        customerBuilder.addPropertyValue("defaultTaxCodeRef", __defaultTaxCodeRefBuilder.getBeanDefinition());
                    }
                }
                parseProperty(customerBuilder, customerChildElement, "serialVersionUID", "serialVersionUID");
                parseProperty(customerBuilder, customerChildElement, "id", "id");
                parseProperty(customerBuilder, customerChildElement, "syncToken", "syncToken");
                if (!parseObjectRef(customerChildElement, customerBuilder, "meta-data", "metaData")) {
                    BeanDefinitionBuilder ___metaDataBuilder = BeanDefinitionBuilder.rootBeanDefinition(ModificationMetaDataExpressionHolder.class.getName());
                    Element ___metaDataChildElement = DomUtils.getChildElementByTagName(customerChildElement, "meta-data");
                    if (___metaDataChildElement!= null) {
                        if (!parseObjectRef(___metaDataChildElement, ___metaDataBuilder, "created-by-ref", "createdByRef")) {
                            BeanDefinitionBuilder ____createdByRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                            Element ____createdByRefChildElement = DomUtils.getChildElementByTagName(___metaDataChildElement, "created-by-ref");
                            if (____createdByRefChildElement!= null) {
                                parseProperty(____createdByRefBuilder, ____createdByRefChildElement, "value", "value");
                                parseProperty(____createdByRefBuilder, ____createdByRefChildElement, "name", "name");
                                parseProperty(____createdByRefBuilder, ____createdByRefChildElement, "type", "type");
                                ___metaDataBuilder.addPropertyValue("createdByRef", ____createdByRefBuilder.getBeanDefinition());
                            }
                        }
                        parseProperty(___metaDataBuilder, ___metaDataChildElement, "createTime", "createTime");
                        if (!parseObjectRef(___metaDataChildElement, ___metaDataBuilder, "last-modified-by-ref", "lastModifiedByRef")) {
                            BeanDefinitionBuilder ____lastModifiedByRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                            Element ____lastModifiedByRefChildElement = DomUtils.getChildElementByTagName(___metaDataChildElement, "last-modified-by-ref");
                            if (____lastModifiedByRefChildElement!= null) {
                                parseProperty(____lastModifiedByRefBuilder, ____lastModifiedByRefChildElement, "value", "value");
                                parseProperty(____lastModifiedByRefBuilder, ____lastModifiedByRefChildElement, "name", "name");
                                parseProperty(____lastModifiedByRefBuilder, ____lastModifiedByRefChildElement, "type", "type");
                                ___metaDataBuilder.addPropertyValue("lastModifiedByRef", ____lastModifiedByRefBuilder.getBeanDefinition());
                            }
                        }
                        parseProperty(___metaDataBuilder, ___metaDataChildElement, "lastUpdatedTime", "lastUpdatedTime");
                        parseProperty(___metaDataBuilder, ___metaDataChildElement, "lastChangedInQB", "lastChangedInQB");
                        customerBuilder.addPropertyValue("metaData", ___metaDataBuilder.getBeanDefinition());
                    }
                }
                parseListAndSetProperty(customerChildElement, customerBuilder, "customField", "custom-field", "custom-field", new ParseDelegate<BeanDefinition>() {


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
                parseListAndSetProperty(customerChildElement, customerBuilder, "attachableRef", "attachable-ref", "attachable-ref", new ParseDelegate<BeanDefinition>() {


                    public BeanDefinition parse(Element element) {
                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(AttachableRefExpressionHolder.class);
                        if (!parseObjectRef(element, builder, "entity-ref", "entityRef")) {
                            BeanDefinitionBuilder ____entityRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                            Element ____entityRefChildElement = DomUtils.getChildElementByTagName(element, "entity-ref");
                            if (____entityRefChildElement!= null) {
                                parseProperty(____entityRefBuilder, ____entityRefChildElement, "value", "value");
                                parseProperty(____entityRefBuilder, ____entityRefChildElement, "name", "name");
                                parseProperty(____entityRefBuilder, ____entityRefChildElement, "type", "type");
                                builder.addPropertyValue("entityRef", ____entityRefBuilder.getBeanDefinition());
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
                            BeanDefinitionBuilder ____attachableRefExBuilder = BeanDefinitionBuilder.rootBeanDefinition(IntuitAnyTypeExpressionHolder.class.getName());
                            Element ____attachableRefExChildElement = DomUtils.getChildElementByTagName(element, "attachable-ref-ex");
                            if (____attachableRefExChildElement!= null) {
                                parseListAndSetProperty(____attachableRefExChildElement, ____attachableRefExBuilder, "any", "any", "any", new ParseDelegate<String>() {


                                    public String parse(Element element) {
                                        return element.getTextContent();
                                    }

                                }
                                );
                                builder.addPropertyValue("attachableRefEx", ____attachableRefExBuilder.getBeanDefinition());
                            }
                        }
                        return builder.getBeanDefinition();
                    }

                }
                );
                parseProperty(customerBuilder, customerChildElement, "domain", "domain");
                parseProperty(customerBuilder, customerChildElement, "status", "status");
                parseProperty(customerBuilder, customerChildElement, "sparse", "sparse");
                parseProperty(customerBuilder, customerChildElement, "taxable", "taxable");
                if (!parseObjectRef(customerChildElement, customerBuilder, "bill-addr", "billAddr")) {
                    BeanDefinitionBuilder _billAddrBuilder = BeanDefinitionBuilder.rootBeanDefinition(PhysicalAddressExpressionHolder.class.getName());
                    Element _billAddrChildElement = DomUtils.getChildElementByTagName(customerChildElement, "bill-addr");
                    if (_billAddrChildElement!= null) {
                        parseProperty(_billAddrBuilder, _billAddrChildElement, "id", "id");
                        parseProperty(_billAddrBuilder, _billAddrChildElement, "line1", "line1");
                        parseProperty(_billAddrBuilder, _billAddrChildElement, "line2", "line2");
                        parseProperty(_billAddrBuilder, _billAddrChildElement, "line3", "line3");
                        parseProperty(_billAddrBuilder, _billAddrChildElement, "line4", "line4");
                        parseProperty(_billAddrBuilder, _billAddrChildElement, "line5", "line5");
                        parseProperty(_billAddrBuilder, _billAddrChildElement, "city", "city");
                        parseProperty(_billAddrBuilder, _billAddrChildElement, "country", "country");
                        parseProperty(_billAddrBuilder, _billAddrChildElement, "countryCode", "countryCode");
                        parseProperty(_billAddrBuilder, _billAddrChildElement, "countrySubDivisionCode", "countrySubDivisionCode");
                        parseProperty(_billAddrBuilder, _billAddrChildElement, "postalCode", "postalCode");
                        parseProperty(_billAddrBuilder, _billAddrChildElement, "postalCodeSuffix", "postalCodeSuffix");
                        parseProperty(_billAddrBuilder, _billAddrChildElement, "lat", "lat");
                        parseProperty(_billAddrBuilder, _billAddrChildElement, "tag", "tag");
                        parseProperty(_billAddrBuilder, _billAddrChildElement, "note", "note");
                        customerBuilder.addPropertyValue("billAddr", _billAddrBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(customerChildElement, customerBuilder, "ship-addr", "shipAddr")) {
                    BeanDefinitionBuilder _shipAddrBuilder = BeanDefinitionBuilder.rootBeanDefinition(PhysicalAddressExpressionHolder.class.getName());
                    Element _shipAddrChildElement = DomUtils.getChildElementByTagName(customerChildElement, "ship-addr");
                    if (_shipAddrChildElement!= null) {
                        parseProperty(_shipAddrBuilder, _shipAddrChildElement, "id", "id");
                        parseProperty(_shipAddrBuilder, _shipAddrChildElement, "line1", "line1");
                        parseProperty(_shipAddrBuilder, _shipAddrChildElement, "line2", "line2");
                        parseProperty(_shipAddrBuilder, _shipAddrChildElement, "line3", "line3");
                        parseProperty(_shipAddrBuilder, _shipAddrChildElement, "line4", "line4");
                        parseProperty(_shipAddrBuilder, _shipAddrChildElement, "line5", "line5");
                        parseProperty(_shipAddrBuilder, _shipAddrChildElement, "city", "city");
                        parseProperty(_shipAddrBuilder, _shipAddrChildElement, "country", "country");
                        parseProperty(_shipAddrBuilder, _shipAddrChildElement, "countryCode", "countryCode");
                        parseProperty(_shipAddrBuilder, _shipAddrChildElement, "countrySubDivisionCode", "countrySubDivisionCode");
                        parseProperty(_shipAddrBuilder, _shipAddrChildElement, "postalCode", "postalCode");
                        parseProperty(_shipAddrBuilder, _shipAddrChildElement, "postalCodeSuffix", "postalCodeSuffix");
                        parseProperty(_shipAddrBuilder, _shipAddrChildElement, "lat", "lat");
                        parseProperty(_shipAddrBuilder, _shipAddrChildElement, "tag", "tag");
                        parseProperty(_shipAddrBuilder, _shipAddrChildElement, "note", "note");
                        customerBuilder.addPropertyValue("shipAddr", _shipAddrBuilder.getBeanDefinition());
                    }
                }
                parseListAndSetProperty(customerChildElement, customerBuilder, "otherAddr", "other-addr", "other-addr", new ParseDelegate<BeanDefinition>() {


                    public BeanDefinition parse(Element element) {
                        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(PhysicalAddressExpressionHolder.class);
                        parseProperty(builder, element, "id", "id");
                        parseProperty(builder, element, "line1", "line1");
                        parseProperty(builder, element, "line2", "line2");
                        parseProperty(builder, element, "line3", "line3");
                        parseProperty(builder, element, "line4", "line4");
                        parseProperty(builder, element, "line5", "line5");
                        parseProperty(builder, element, "city", "city");
                        parseProperty(builder, element, "country", "country");
                        parseProperty(builder, element, "countryCode", "countryCode");
                        parseProperty(builder, element, "countrySubDivisionCode", "countrySubDivisionCode");
                        parseProperty(builder, element, "postalCode", "postalCode");
                        parseProperty(builder, element, "postalCodeSuffix", "postalCodeSuffix");
                        parseProperty(builder, element, "lat", "lat");
                        parseProperty(builder, element, "tag", "tag");
                        parseProperty(builder, element, "note", "note");
                        return builder.getBeanDefinition();
                    }

                }
                );
                parseProperty(customerBuilder, customerChildElement, "contactName", "contactName");
                parseProperty(customerBuilder, customerChildElement, "altContactName", "altContactName");
                parseProperty(customerBuilder, customerChildElement, "notes", "notes");
                parseProperty(customerBuilder, customerChildElement, "job", "job");
                parseProperty(customerBuilder, customerChildElement, "billWithParent", "billWithParent");
                if (!parseObjectRef(customerChildElement, customerBuilder, "root-customer-ref", "rootCustomerRef")) {
                    BeanDefinitionBuilder _rootCustomerRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _rootCustomerRefChildElement = DomUtils.getChildElementByTagName(customerChildElement, "root-customer-ref");
                    if (_rootCustomerRefChildElement!= null) {
                        parseProperty(_rootCustomerRefBuilder, _rootCustomerRefChildElement, "value", "value");
                        parseProperty(_rootCustomerRefBuilder, _rootCustomerRefChildElement, "name", "name");
                        parseProperty(_rootCustomerRefBuilder, _rootCustomerRefChildElement, "type", "type");
                        customerBuilder.addPropertyValue("rootCustomerRef", _rootCustomerRefBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(customerChildElement, customerBuilder, "parent-ref", "parentRef")) {
                    BeanDefinitionBuilder _parentRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _parentRefChildElement = DomUtils.getChildElementByTagName(customerChildElement, "parent-ref");
                    if (_parentRefChildElement!= null) {
                        parseProperty(_parentRefBuilder, _parentRefChildElement, "value", "value");
                        parseProperty(_parentRefBuilder, _parentRefChildElement, "name", "name");
                        parseProperty(_parentRefBuilder, _parentRefChildElement, "type", "type");
                        customerBuilder.addPropertyValue("parentRef", _parentRefBuilder.getBeanDefinition());
                    }
                }
                parseProperty(customerBuilder, customerChildElement, "level", "level");
                if (!parseObjectRef(customerChildElement, customerBuilder, "customer-type-ref", "customerTypeRef")) {
                    BeanDefinitionBuilder _customerTypeRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _customerTypeRefChildElement = DomUtils.getChildElementByTagName(customerChildElement, "customer-type-ref");
                    if (_customerTypeRefChildElement!= null) {
                        parseProperty(_customerTypeRefBuilder, _customerTypeRefChildElement, "value", "value");
                        parseProperty(_customerTypeRefBuilder, _customerTypeRefChildElement, "name", "name");
                        parseProperty(_customerTypeRefBuilder, _customerTypeRefChildElement, "type", "type");
                        customerBuilder.addPropertyValue("customerTypeRef", _customerTypeRefBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(customerChildElement, customerBuilder, "sales-term-ref", "salesTermRef")) {
                    BeanDefinitionBuilder _salesTermRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _salesTermRefChildElement = DomUtils.getChildElementByTagName(customerChildElement, "sales-term-ref");
                    if (_salesTermRefChildElement!= null) {
                        parseProperty(_salesTermRefBuilder, _salesTermRefChildElement, "value", "value");
                        parseProperty(_salesTermRefBuilder, _salesTermRefChildElement, "name", "name");
                        parseProperty(_salesTermRefBuilder, _salesTermRefChildElement, "type", "type");
                        customerBuilder.addPropertyValue("salesTermRef", _salesTermRefBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(customerChildElement, customerBuilder, "sales-rep-ref", "salesRepRef")) {
                    BeanDefinitionBuilder _salesRepRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _salesRepRefChildElement = DomUtils.getChildElementByTagName(customerChildElement, "sales-rep-ref");
                    if (_salesRepRefChildElement!= null) {
                        parseProperty(_salesRepRefBuilder, _salesRepRefChildElement, "value", "value");
                        parseProperty(_salesRepRefBuilder, _salesRepRefChildElement, "name", "name");
                        parseProperty(_salesRepRefBuilder, _salesRepRefChildElement, "type", "type");
                        customerBuilder.addPropertyValue("salesRepRef", _salesRepRefBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(customerChildElement, customerBuilder, "tax-group-code-ref", "taxGroupCodeRef")) {
                    BeanDefinitionBuilder _taxGroupCodeRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _taxGroupCodeRefChildElement = DomUtils.getChildElementByTagName(customerChildElement, "tax-group-code-ref");
                    if (_taxGroupCodeRefChildElement!= null) {
                        parseProperty(_taxGroupCodeRefBuilder, _taxGroupCodeRefChildElement, "value", "value");
                        parseProperty(_taxGroupCodeRefBuilder, _taxGroupCodeRefChildElement, "name", "name");
                        parseProperty(_taxGroupCodeRefBuilder, _taxGroupCodeRefChildElement, "type", "type");
                        customerBuilder.addPropertyValue("taxGroupCodeRef", _taxGroupCodeRefBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(customerChildElement, customerBuilder, "tax-rate-ref", "taxRateRef")) {
                    BeanDefinitionBuilder _taxRateRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _taxRateRefChildElement = DomUtils.getChildElementByTagName(customerChildElement, "tax-rate-ref");
                    if (_taxRateRefChildElement!= null) {
                        parseProperty(_taxRateRefBuilder, _taxRateRefChildElement, "value", "value");
                        parseProperty(_taxRateRefBuilder, _taxRateRefChildElement, "name", "name");
                        parseProperty(_taxRateRefBuilder, _taxRateRefChildElement, "type", "type");
                        customerBuilder.addPropertyValue("taxRateRef", _taxRateRefBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(customerChildElement, customerBuilder, "payment-method-ref", "paymentMethodRef")) {
                    BeanDefinitionBuilder _paymentMethodRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _paymentMethodRefChildElement = DomUtils.getChildElementByTagName(customerChildElement, "payment-method-ref");
                    if (_paymentMethodRefChildElement!= null) {
                        parseProperty(_paymentMethodRefBuilder, _paymentMethodRefChildElement, "value", "value");
                        parseProperty(_paymentMethodRefBuilder, _paymentMethodRefChildElement, "name", "name");
                        parseProperty(_paymentMethodRefBuilder, _paymentMethodRefChildElement, "type", "type");
                        customerBuilder.addPropertyValue("paymentMethodRef", _paymentMethodRefBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(customerChildElement, customerBuilder, "price-level-ref", "priceLevelRef")) {
                    BeanDefinitionBuilder _priceLevelRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _priceLevelRefChildElement = DomUtils.getChildElementByTagName(customerChildElement, "price-level-ref");
                    if (_priceLevelRefChildElement!= null) {
                        parseProperty(_priceLevelRefBuilder, _priceLevelRefChildElement, "value", "value");
                        parseProperty(_priceLevelRefBuilder, _priceLevelRefChildElement, "name", "name");
                        parseProperty(_priceLevelRefBuilder, _priceLevelRefChildElement, "type", "type");
                        customerBuilder.addPropertyValue("priceLevelRef", _priceLevelRefBuilder.getBeanDefinition());
                    }
                }
                parseProperty(customerBuilder, customerChildElement, "balance", "balance");
                parseProperty(customerBuilder, customerChildElement, "openBalanceDate", "openBalanceDate");
                parseProperty(customerBuilder, customerChildElement, "balanceWithJobs", "balanceWithJobs");
                parseProperty(customerBuilder, customerChildElement, "creditLimit", "creditLimit");
                parseProperty(customerBuilder, customerChildElement, "acctNum", "acctNum");
                if (!parseObjectRef(customerChildElement, customerBuilder, "currency-ref", "currencyRef")) {
                    BeanDefinitionBuilder _currencyRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _currencyRefChildElement = DomUtils.getChildElementByTagName(customerChildElement, "currency-ref");
                    if (_currencyRefChildElement!= null) {
                        parseProperty(_currencyRefBuilder, _currencyRefChildElement, "value", "value");
                        parseProperty(_currencyRefBuilder, _currencyRefChildElement, "name", "name");
                        parseProperty(_currencyRefBuilder, _currencyRefChildElement, "type", "type");
                        customerBuilder.addPropertyValue("currencyRef", _currencyRefBuilder.getBeanDefinition());
                    }
                }
                parseProperty(customerBuilder, customerChildElement, "overDueBalance", "overDueBalance");
                parseProperty(customerBuilder, customerChildElement, "totalRevenue", "totalRevenue");
                parseProperty(customerBuilder, customerChildElement, "totalExpense", "totalExpense");
                parseProperty(customerBuilder, customerChildElement, "preferredDeliveryMethod", "preferredDeliveryMethod");
                parseProperty(customerBuilder, customerChildElement, "resaleNum", "resaleNum");
                if (!parseObjectRef(customerChildElement, customerBuilder, "job-info", "jobInfo")) {
                    BeanDefinitionBuilder _jobInfoBuilder = BeanDefinitionBuilder.rootBeanDefinition(JobInfoExpressionHolder.class.getName());
                    Element _jobInfoChildElement = DomUtils.getChildElementByTagName(customerChildElement, "job-info");
                    if (_jobInfoChildElement!= null) {
                        parseProperty(_jobInfoBuilder, _jobInfoChildElement, "status", "status");
                        parseProperty(_jobInfoBuilder, _jobInfoChildElement, "startDate", "startDate");
                        parseProperty(_jobInfoBuilder, _jobInfoChildElement, "projectedEndDate", "projectedEndDate");
                        parseProperty(_jobInfoBuilder, _jobInfoChildElement, "endDate", "endDate");
                        parseProperty(_jobInfoBuilder, _jobInfoChildElement, "description", "description");
                        if (!parseObjectRef(_jobInfoChildElement, _jobInfoBuilder, "job-type-ref", "jobTypeRef")) {
                            BeanDefinitionBuilder __jobTypeRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                            Element __jobTypeRefChildElement = DomUtils.getChildElementByTagName(_jobInfoChildElement, "job-type-ref");
                            if (__jobTypeRefChildElement!= null) {
                                parseProperty(__jobTypeRefBuilder, __jobTypeRefChildElement, "value", "value");
                                parseProperty(__jobTypeRefBuilder, __jobTypeRefChildElement, "name", "name");
                                parseProperty(__jobTypeRefBuilder, __jobTypeRefChildElement, "type", "type");
                                _jobInfoBuilder.addPropertyValue("jobTypeRef", __jobTypeRefBuilder.getBeanDefinition());
                            }
                        }
                        customerBuilder.addPropertyValue("jobInfo", _jobInfoBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(customerChildElement, customerBuilder, "customer-ex", "customerEx")) {
                    BeanDefinitionBuilder _customerExBuilder = BeanDefinitionBuilder.rootBeanDefinition(IntuitAnyTypeExpressionHolder.class.getName());
                    Element _customerExChildElement = DomUtils.getChildElementByTagName(customerChildElement, "customer-ex");
                    if (_customerExChildElement!= null) {
                        parseListAndSetProperty(_customerExChildElement, _customerExBuilder, "any", "any", "any", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        customerBuilder.addPropertyValue("customerEx", _customerExBuilder.getBeanDefinition());
                    }
                }
                builder.addPropertyValue("customer", customerBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
