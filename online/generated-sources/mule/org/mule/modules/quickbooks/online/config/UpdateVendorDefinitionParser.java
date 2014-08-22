
package org.mule.modules.quickbooks.online.config;

import javax.annotation.Generated;
import com.intuit.ipp.data.holders.AttachableRefExpressionHolder;
import com.intuit.ipp.data.holders.ContactInfoExpressionHolder;
import com.intuit.ipp.data.holders.CustomFieldExpressionHolder;
import com.intuit.ipp.data.holders.EmailAddressExpressionHolder;
import com.intuit.ipp.data.holders.GenericContactTypeExpressionHolder;
import com.intuit.ipp.data.holders.IntuitAnyTypeExpressionHolder;
import com.intuit.ipp.data.holders.ModificationMetaDataExpressionHolder;
import com.intuit.ipp.data.holders.PhysicalAddressExpressionHolder;
import com.intuit.ipp.data.holders.ReferenceTypeExpressionHolder;
import com.intuit.ipp.data.holders.TelephoneNumberExpressionHolder;
import com.intuit.ipp.data.holders.VendorExpressionHolder;
import com.intuit.ipp.data.holders.WebSiteAddressExpressionHolder;
import org.mule.modules.quickbooks.online.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.quickbooks.online.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.quickbooks.online.processors.UpdateVendorMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T02:35:33-05:00", comments = "Build 3.4.3.1620.30ea288")
public class UpdateVendorDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(UpdateVendorMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "accessTokenId", "accessTokenId");
        if (!parseObjectRefWithDefault(element, builder, "vendor", "vendor", "#[payload]")) {
            BeanDefinitionBuilder vendorBuilder = BeanDefinitionBuilder.rootBeanDefinition(VendorExpressionHolder.class.getName());
            Element vendorChildElement = DomUtils.getChildElementByTagName(element, "vendor");
            if (vendorChildElement!= null) {
                parseProperty(vendorBuilder, vendorChildElement, "serialVersionUID", "serialVersionUID");
                parseProperty(vendorBuilder, vendorChildElement, "intuitId", "intuitId");
                parseProperty(vendorBuilder, vendorChildElement, "organization", "organization");
                parseProperty(vendorBuilder, vendorChildElement, "title", "title");
                parseProperty(vendorBuilder, vendorChildElement, "givenName", "givenName");
                parseProperty(vendorBuilder, vendorChildElement, "middleName", "middleName");
                parseProperty(vendorBuilder, vendorChildElement, "familyName", "familyName");
                parseProperty(vendorBuilder, vendorChildElement, "suffix", "suffix");
                parseProperty(vendorBuilder, vendorChildElement, "fullyQualifiedName", "fullyQualifiedName");
                parseProperty(vendorBuilder, vendorChildElement, "companyName", "companyName");
                parseProperty(vendorBuilder, vendorChildElement, "displayName", "displayName");
                parseProperty(vendorBuilder, vendorChildElement, "printOnCheckName", "printOnCheckName");
                parseProperty(vendorBuilder, vendorChildElement, "userId", "userId");
                parseProperty(vendorBuilder, vendorChildElement, "active", "active");
                if (!parseObjectRef(vendorChildElement, vendorBuilder, "primary-phone", "primaryPhone")) {
                    BeanDefinitionBuilder __primaryPhoneBuilder = BeanDefinitionBuilder.rootBeanDefinition(TelephoneNumberExpressionHolder.class.getName());
                    Element __primaryPhoneChildElement = DomUtils.getChildElementByTagName(vendorChildElement, "primary-phone");
                    if (__primaryPhoneChildElement!= null) {
                        parseProperty(__primaryPhoneBuilder, __primaryPhoneChildElement, "id", "id");
                        parseProperty(__primaryPhoneBuilder, __primaryPhoneChildElement, "deviceType", "deviceType");
                        parseProperty(__primaryPhoneBuilder, __primaryPhoneChildElement, "countryCode", "countryCode");
                        parseProperty(__primaryPhoneBuilder, __primaryPhoneChildElement, "areaCode", "areaCode");
                        parseProperty(__primaryPhoneBuilder, __primaryPhoneChildElement, "exchangeCode", "exchangeCode");
                        parseProperty(__primaryPhoneBuilder, __primaryPhoneChildElement, "extension", "extension");
                        parseProperty(__primaryPhoneBuilder, __primaryPhoneChildElement, "freeFormNumber", "freeFormNumber");
                        parseProperty(__primaryPhoneBuilder, __primaryPhoneChildElement, "tag", "tag");
                        vendorBuilder.addPropertyValue("primaryPhone", __primaryPhoneBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(vendorChildElement, vendorBuilder, "alternate-phone", "alternatePhone")) {
                    BeanDefinitionBuilder __alternatePhoneBuilder = BeanDefinitionBuilder.rootBeanDefinition(TelephoneNumberExpressionHolder.class.getName());
                    Element __alternatePhoneChildElement = DomUtils.getChildElementByTagName(vendorChildElement, "alternate-phone");
                    if (__alternatePhoneChildElement!= null) {
                        parseProperty(__alternatePhoneBuilder, __alternatePhoneChildElement, "id", "id");
                        parseProperty(__alternatePhoneBuilder, __alternatePhoneChildElement, "deviceType", "deviceType");
                        parseProperty(__alternatePhoneBuilder, __alternatePhoneChildElement, "countryCode", "countryCode");
                        parseProperty(__alternatePhoneBuilder, __alternatePhoneChildElement, "areaCode", "areaCode");
                        parseProperty(__alternatePhoneBuilder, __alternatePhoneChildElement, "exchangeCode", "exchangeCode");
                        parseProperty(__alternatePhoneBuilder, __alternatePhoneChildElement, "extension", "extension");
                        parseProperty(__alternatePhoneBuilder, __alternatePhoneChildElement, "freeFormNumber", "freeFormNumber");
                        parseProperty(__alternatePhoneBuilder, __alternatePhoneChildElement, "tag", "tag");
                        vendorBuilder.addPropertyValue("alternatePhone", __alternatePhoneBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(vendorChildElement, vendorBuilder, "mobile", "mobile")) {
                    BeanDefinitionBuilder __mobileBuilder = BeanDefinitionBuilder.rootBeanDefinition(TelephoneNumberExpressionHolder.class.getName());
                    Element __mobileChildElement = DomUtils.getChildElementByTagName(vendorChildElement, "mobile");
                    if (__mobileChildElement!= null) {
                        parseProperty(__mobileBuilder, __mobileChildElement, "id", "id");
                        parseProperty(__mobileBuilder, __mobileChildElement, "deviceType", "deviceType");
                        parseProperty(__mobileBuilder, __mobileChildElement, "countryCode", "countryCode");
                        parseProperty(__mobileBuilder, __mobileChildElement, "areaCode", "areaCode");
                        parseProperty(__mobileBuilder, __mobileChildElement, "exchangeCode", "exchangeCode");
                        parseProperty(__mobileBuilder, __mobileChildElement, "extension", "extension");
                        parseProperty(__mobileBuilder, __mobileChildElement, "freeFormNumber", "freeFormNumber");
                        parseProperty(__mobileBuilder, __mobileChildElement, "tag", "tag");
                        vendorBuilder.addPropertyValue("mobile", __mobileBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(vendorChildElement, vendorBuilder, "fax", "fax")) {
                    BeanDefinitionBuilder __faxBuilder = BeanDefinitionBuilder.rootBeanDefinition(TelephoneNumberExpressionHolder.class.getName());
                    Element __faxChildElement = DomUtils.getChildElementByTagName(vendorChildElement, "fax");
                    if (__faxChildElement!= null) {
                        parseProperty(__faxBuilder, __faxChildElement, "id", "id");
                        parseProperty(__faxBuilder, __faxChildElement, "deviceType", "deviceType");
                        parseProperty(__faxBuilder, __faxChildElement, "countryCode", "countryCode");
                        parseProperty(__faxBuilder, __faxChildElement, "areaCode", "areaCode");
                        parseProperty(__faxBuilder, __faxChildElement, "exchangeCode", "exchangeCode");
                        parseProperty(__faxBuilder, __faxChildElement, "extension", "extension");
                        parseProperty(__faxBuilder, __faxChildElement, "freeFormNumber", "freeFormNumber");
                        parseProperty(__faxBuilder, __faxChildElement, "tag", "tag");
                        vendorBuilder.addPropertyValue("fax", __faxBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(vendorChildElement, vendorBuilder, "primary-email-addr", "primaryEmailAddr")) {
                    BeanDefinitionBuilder __primaryEmailAddrBuilder = BeanDefinitionBuilder.rootBeanDefinition(EmailAddressExpressionHolder.class.getName());
                    Element __primaryEmailAddrChildElement = DomUtils.getChildElementByTagName(vendorChildElement, "primary-email-addr");
                    if (__primaryEmailAddrChildElement!= null) {
                        parseProperty(__primaryEmailAddrBuilder, __primaryEmailAddrChildElement, "id", "id");
                        parseProperty(__primaryEmailAddrBuilder, __primaryEmailAddrChildElement, "address", "address");
                        parseProperty(__primaryEmailAddrBuilder, __primaryEmailAddrChildElement, "tag", "tag");
                        vendorBuilder.addPropertyValue("primaryEmailAddr", __primaryEmailAddrBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(vendorChildElement, vendorBuilder, "web-addr", "webAddr")) {
                    BeanDefinitionBuilder __webAddrBuilder = BeanDefinitionBuilder.rootBeanDefinition(WebSiteAddressExpressionHolder.class.getName());
                    Element __webAddrChildElement = DomUtils.getChildElementByTagName(vendorChildElement, "web-addr");
                    if (__webAddrChildElement!= null) {
                        parseProperty(__webAddrBuilder, __webAddrChildElement, "id", "id");
                        parseProperty(__webAddrBuilder, __webAddrChildElement, "tag", "tag");
                        vendorBuilder.addPropertyValue("webAddr", __webAddrBuilder.getBeanDefinition());
                    }
                }
                parseListAndSetProperty(vendorChildElement, vendorBuilder, "otherContactInfo", "other-contact-info", "other-contact-info", new ParseDelegate<BeanDefinition>() {


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
                if (!parseObjectRef(vendorChildElement, vendorBuilder, "default-tax-code-ref", "defaultTaxCodeRef")) {
                    BeanDefinitionBuilder __defaultTaxCodeRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element __defaultTaxCodeRefChildElement = DomUtils.getChildElementByTagName(vendorChildElement, "default-tax-code-ref");
                    if (__defaultTaxCodeRefChildElement!= null) {
                        parseProperty(__defaultTaxCodeRefBuilder, __defaultTaxCodeRefChildElement, "value", "value");
                        parseProperty(__defaultTaxCodeRefBuilder, __defaultTaxCodeRefChildElement, "name", "name");
                        parseProperty(__defaultTaxCodeRefBuilder, __defaultTaxCodeRefChildElement, "type", "type");
                        vendorBuilder.addPropertyValue("defaultTaxCodeRef", __defaultTaxCodeRefBuilder.getBeanDefinition());
                    }
                }
                parseProperty(vendorBuilder, vendorChildElement, "serialVersionUID", "serialVersionUID");
                parseProperty(vendorBuilder, vendorChildElement, "id", "id");
                parseProperty(vendorBuilder, vendorChildElement, "syncToken", "syncToken");
                if (!parseObjectRef(vendorChildElement, vendorBuilder, "meta-data", "metaData")) {
                    BeanDefinitionBuilder ___metaDataBuilder = BeanDefinitionBuilder.rootBeanDefinition(ModificationMetaDataExpressionHolder.class.getName());
                    Element ___metaDataChildElement = DomUtils.getChildElementByTagName(vendorChildElement, "meta-data");
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
                        vendorBuilder.addPropertyValue("metaData", ___metaDataBuilder.getBeanDefinition());
                    }
                }
                parseListAndSetProperty(vendorChildElement, vendorBuilder, "customField", "custom-field", "custom-field", new ParseDelegate<BeanDefinition>() {


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
                parseListAndSetProperty(vendorChildElement, vendorBuilder, "attachableRef", "attachable-ref", "attachable-ref", new ParseDelegate<BeanDefinition>() {


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
                parseProperty(vendorBuilder, vendorChildElement, "domain", "domain");
                parseProperty(vendorBuilder, vendorChildElement, "status", "status");
                parseProperty(vendorBuilder, vendorChildElement, "sparse", "sparse");
                parseProperty(vendorBuilder, vendorChildElement, "contactName", "contactName");
                parseProperty(vendorBuilder, vendorChildElement, "altContactName", "altContactName");
                parseProperty(vendorBuilder, vendorChildElement, "notes", "notes");
                if (!parseObjectRef(vendorChildElement, vendorBuilder, "bill-addr", "billAddr")) {
                    BeanDefinitionBuilder _billAddrBuilder = BeanDefinitionBuilder.rootBeanDefinition(PhysicalAddressExpressionHolder.class.getName());
                    Element _billAddrChildElement = DomUtils.getChildElementByTagName(vendorChildElement, "bill-addr");
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
                        vendorBuilder.addPropertyValue("billAddr", _billAddrBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(vendorChildElement, vendorBuilder, "ship-addr", "shipAddr")) {
                    BeanDefinitionBuilder _shipAddrBuilder = BeanDefinitionBuilder.rootBeanDefinition(PhysicalAddressExpressionHolder.class.getName());
                    Element _shipAddrChildElement = DomUtils.getChildElementByTagName(vendorChildElement, "ship-addr");
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
                        vendorBuilder.addPropertyValue("shipAddr", _shipAddrBuilder.getBeanDefinition());
                    }
                }
                parseListAndSetProperty(vendorChildElement, vendorBuilder, "otherAddr", "other-addr", "other-addr", new ParseDelegate<BeanDefinition>() {


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
                parseProperty(vendorBuilder, vendorChildElement, "taxCountry", "taxCountry");
                parseProperty(vendorBuilder, vendorChildElement, "taxIdentifier", "taxIdentifier");
                parseProperty(vendorBuilder, vendorChildElement, "businessNumber", "businessNumber");
                if (!parseObjectRef(vendorChildElement, vendorBuilder, "parent-ref", "parentRef")) {
                    BeanDefinitionBuilder _parentRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _parentRefChildElement = DomUtils.getChildElementByTagName(vendorChildElement, "parent-ref");
                    if (_parentRefChildElement!= null) {
                        parseProperty(_parentRefBuilder, _parentRefChildElement, "value", "value");
                        parseProperty(_parentRefBuilder, _parentRefChildElement, "name", "name");
                        parseProperty(_parentRefBuilder, _parentRefChildElement, "type", "type");
                        vendorBuilder.addPropertyValue("parentRef", _parentRefBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(vendorChildElement, vendorBuilder, "vendor-type-ref", "vendorTypeRef")) {
                    BeanDefinitionBuilder _vendorTypeRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _vendorTypeRefChildElement = DomUtils.getChildElementByTagName(vendorChildElement, "vendor-type-ref");
                    if (_vendorTypeRefChildElement!= null) {
                        parseProperty(_vendorTypeRefBuilder, _vendorTypeRefChildElement, "value", "value");
                        parseProperty(_vendorTypeRefBuilder, _vendorTypeRefChildElement, "name", "name");
                        parseProperty(_vendorTypeRefBuilder, _vendorTypeRefChildElement, "type", "type");
                        vendorBuilder.addPropertyValue("vendorTypeRef", _vendorTypeRefBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(vendorChildElement, vendorBuilder, "term-ref", "termRef")) {
                    BeanDefinitionBuilder _termRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _termRefChildElement = DomUtils.getChildElementByTagName(vendorChildElement, "term-ref");
                    if (_termRefChildElement!= null) {
                        parseProperty(_termRefBuilder, _termRefChildElement, "value", "value");
                        parseProperty(_termRefBuilder, _termRefChildElement, "name", "name");
                        parseProperty(_termRefBuilder, _termRefChildElement, "type", "type");
                        vendorBuilder.addPropertyValue("termRef", _termRefBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(vendorChildElement, vendorBuilder, "prefill-account-ref", "prefillAccountRef")) {
                    BeanDefinitionBuilder _prefillAccountRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _prefillAccountRefChildElement = DomUtils.getChildElementByTagName(vendorChildElement, "prefill-account-ref");
                    if (_prefillAccountRefChildElement!= null) {
                        parseProperty(_prefillAccountRefBuilder, _prefillAccountRefChildElement, "value", "value");
                        parseProperty(_prefillAccountRefBuilder, _prefillAccountRefChildElement, "name", "name");
                        parseProperty(_prefillAccountRefBuilder, _prefillAccountRefChildElement, "type", "type");
                        vendorBuilder.addPropertyValue("prefillAccountRef", _prefillAccountRefBuilder.getBeanDefinition());
                    }
                }
                parseProperty(vendorBuilder, vendorChildElement, "balance", "balance");
                parseProperty(vendorBuilder, vendorChildElement, "openBalanceDate", "openBalanceDate");
                parseProperty(vendorBuilder, vendorChildElement, "creditLimit", "creditLimit");
                parseProperty(vendorBuilder, vendorChildElement, "acctNum", "acctNum");
                parseProperty(vendorBuilder, vendorChildElement, "vendor1099", "vendor1099");
                parseProperty(vendorBuilder, vendorChildElement, "t4AEligible", "t4AEligible");
                parseProperty(vendorBuilder, vendorChildElement, "t5018Eligible", "t5018Eligible");
                if (!parseObjectRef(vendorChildElement, vendorBuilder, "currency-ref", "currencyRef")) {
                    BeanDefinitionBuilder _currencyRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _currencyRefChildElement = DomUtils.getChildElementByTagName(vendorChildElement, "currency-ref");
                    if (_currencyRefChildElement!= null) {
                        parseProperty(_currencyRefBuilder, _currencyRefChildElement, "value", "value");
                        parseProperty(_currencyRefBuilder, _currencyRefChildElement, "name", "name");
                        parseProperty(_currencyRefBuilder, _currencyRefChildElement, "type", "type");
                        vendorBuilder.addPropertyValue("currencyRef", _currencyRefBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(vendorChildElement, vendorBuilder, "vendor-ex", "vendorEx")) {
                    BeanDefinitionBuilder _vendorExBuilder = BeanDefinitionBuilder.rootBeanDefinition(IntuitAnyTypeExpressionHolder.class.getName());
                    Element _vendorExChildElement = DomUtils.getChildElementByTagName(vendorChildElement, "vendor-ex");
                    if (_vendorExChildElement!= null) {
                        parseListAndSetProperty(_vendorExChildElement, _vendorExBuilder, "any", "any", "any", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        vendorBuilder.addPropertyValue("vendorEx", _vendorExBuilder.getBeanDefinition());
                    }
                }
                builder.addPropertyValue("vendor", vendorBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
