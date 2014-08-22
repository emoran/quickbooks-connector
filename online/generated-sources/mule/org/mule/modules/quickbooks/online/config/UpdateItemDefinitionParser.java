
package org.mule.modules.quickbooks.online.config;

import javax.annotation.Generated;
import com.intuit.ipp.data.holders.AttachableRefExpressionHolder;
import com.intuit.ipp.data.holders.CustomFieldExpressionHolder;
import com.intuit.ipp.data.holders.IntuitAnyTypeExpressionHolder;
import com.intuit.ipp.data.holders.ItemAssemblyDetailExpressionHolder;
import com.intuit.ipp.data.holders.ItemComponentLineExpressionHolder;
import com.intuit.ipp.data.holders.ItemExpressionHolder;
import com.intuit.ipp.data.holders.ItemGroupDetailExpressionHolder;
import com.intuit.ipp.data.holders.ModificationMetaDataExpressionHolder;
import com.intuit.ipp.data.holders.ReferenceTypeExpressionHolder;
import org.mule.modules.quickbooks.online.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.quickbooks.online.config.AbstractDefinitionParser.ParseDelegate;
import org.mule.modules.quickbooks.online.processors.UpdateItemMessageProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-22T10:01:32-05:00", comments = "Build 3.4.3.1620.30ea288")
public class UpdateItemDefinitionParser
    extends AbstractDefinitionParser
{


    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(UpdateItemMessageProcessor.class.getName());
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "accessTokenId", "accessTokenId");
        if (!parseObjectRefWithDefault(element, builder, "item", "item", "#[payload]")) {
            BeanDefinitionBuilder itemBuilder = BeanDefinitionBuilder.rootBeanDefinition(ItemExpressionHolder.class.getName());
            Element itemChildElement = DomUtils.getChildElementByTagName(element, "item");
            if (itemChildElement!= null) {
                parseProperty(itemBuilder, itemChildElement, "serialVersionUID", "serialVersionUID");
                parseProperty(itemBuilder, itemChildElement, "id", "id");
                parseProperty(itemBuilder, itemChildElement, "syncToken", "syncToken");
                if (!parseObjectRef(itemChildElement, itemBuilder, "meta-data", "metaData")) {
                    BeanDefinitionBuilder __metaDataBuilder = BeanDefinitionBuilder.rootBeanDefinition(ModificationMetaDataExpressionHolder.class.getName());
                    Element __metaDataChildElement = DomUtils.getChildElementByTagName(itemChildElement, "meta-data");
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
                        itemBuilder.addPropertyValue("metaData", __metaDataBuilder.getBeanDefinition());
                    }
                }
                parseListAndSetProperty(itemChildElement, itemBuilder, "customField", "custom-field", "custom-field", new ParseDelegate<BeanDefinition>() {


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
                parseListAndSetProperty(itemChildElement, itemBuilder, "attachableRef", "attachable-ref", "attachable-ref", new ParseDelegate<BeanDefinition>() {


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
                parseProperty(itemBuilder, itemChildElement, "domain", "domain");
                parseProperty(itemBuilder, itemChildElement, "status", "status");
                parseProperty(itemBuilder, itemChildElement, "sparse", "sparse");
                parseProperty(itemBuilder, itemChildElement, "name", "name");
                parseProperty(itemBuilder, itemChildElement, "description", "description");
                parseProperty(itemBuilder, itemChildElement, "active", "active");
                parseProperty(itemBuilder, itemChildElement, "subItem", "subItem");
                if (!parseObjectRef(itemChildElement, itemBuilder, "parent-ref", "parentRef")) {
                    BeanDefinitionBuilder _parentRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _parentRefChildElement = DomUtils.getChildElementByTagName(itemChildElement, "parent-ref");
                    if (_parentRefChildElement!= null) {
                        parseProperty(_parentRefBuilder, _parentRefChildElement, "value", "value");
                        parseProperty(_parentRefBuilder, _parentRefChildElement, "name", "name");
                        parseProperty(_parentRefBuilder, _parentRefChildElement, "type", "type");
                        itemBuilder.addPropertyValue("parentRef", _parentRefBuilder.getBeanDefinition());
                    }
                }
                parseProperty(itemBuilder, itemChildElement, "level", "level");
                parseProperty(itemBuilder, itemChildElement, "fullyQualifiedName", "fullyQualifiedName");
                parseProperty(itemBuilder, itemChildElement, "taxable", "taxable");
                parseProperty(itemBuilder, itemChildElement, "salesTaxIncluded", "salesTaxIncluded");
                parseProperty(itemBuilder, itemChildElement, "percentBased", "percentBased");
                parseProperty(itemBuilder, itemChildElement, "unitPrice", "unitPrice");
                parseProperty(itemBuilder, itemChildElement, "ratePercent", "ratePercent");
                parseProperty(itemBuilder, itemChildElement, "type", "type");
                if (!parseObjectRef(itemChildElement, itemBuilder, "payment-method-ref", "paymentMethodRef")) {
                    BeanDefinitionBuilder _paymentMethodRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _paymentMethodRefChildElement = DomUtils.getChildElementByTagName(itemChildElement, "payment-method-ref");
                    if (_paymentMethodRefChildElement!= null) {
                        parseProperty(_paymentMethodRefBuilder, _paymentMethodRefChildElement, "value", "value");
                        parseProperty(_paymentMethodRefBuilder, _paymentMethodRefChildElement, "name", "name");
                        parseProperty(_paymentMethodRefBuilder, _paymentMethodRefChildElement, "type", "type");
                        itemBuilder.addPropertyValue("paymentMethodRef", _paymentMethodRefBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(itemChildElement, itemBuilder, "income-account-ref", "incomeAccountRef")) {
                    BeanDefinitionBuilder _incomeAccountRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _incomeAccountRefChildElement = DomUtils.getChildElementByTagName(itemChildElement, "income-account-ref");
                    if (_incomeAccountRefChildElement!= null) {
                        parseProperty(_incomeAccountRefBuilder, _incomeAccountRefChildElement, "value", "value");
                        parseProperty(_incomeAccountRefBuilder, _incomeAccountRefChildElement, "name", "name");
                        parseProperty(_incomeAccountRefBuilder, _incomeAccountRefChildElement, "type", "type");
                        itemBuilder.addPropertyValue("incomeAccountRef", _incomeAccountRefBuilder.getBeanDefinition());
                    }
                }
                parseProperty(itemBuilder, itemChildElement, "purchaseDesc", "purchaseDesc");
                parseProperty(itemBuilder, itemChildElement, "purchaseTaxIncluded", "purchaseTaxIncluded");
                parseProperty(itemBuilder, itemChildElement, "purchaseCost", "purchaseCost");
                if (!parseObjectRef(itemChildElement, itemBuilder, "expense-account-ref", "expenseAccountRef")) {
                    BeanDefinitionBuilder _expenseAccountRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _expenseAccountRefChildElement = DomUtils.getChildElementByTagName(itemChildElement, "expense-account-ref");
                    if (_expenseAccountRefChildElement!= null) {
                        parseProperty(_expenseAccountRefBuilder, _expenseAccountRefChildElement, "value", "value");
                        parseProperty(_expenseAccountRefBuilder, _expenseAccountRefChildElement, "name", "name");
                        parseProperty(_expenseAccountRefBuilder, _expenseAccountRefChildElement, "type", "type");
                        itemBuilder.addPropertyValue("expenseAccountRef", _expenseAccountRefBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(itemChildElement, itemBuilder, "asset-account-ref", "assetAccountRef")) {
                    BeanDefinitionBuilder _assetAccountRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _assetAccountRefChildElement = DomUtils.getChildElementByTagName(itemChildElement, "asset-account-ref");
                    if (_assetAccountRefChildElement!= null) {
                        parseProperty(_assetAccountRefBuilder, _assetAccountRefChildElement, "value", "value");
                        parseProperty(_assetAccountRefBuilder, _assetAccountRefChildElement, "name", "name");
                        parseProperty(_assetAccountRefBuilder, _assetAccountRefChildElement, "type", "type");
                        itemBuilder.addPropertyValue("assetAccountRef", _assetAccountRefBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(itemChildElement, itemBuilder, "pref-vendor-ref", "prefVendorRef")) {
                    BeanDefinitionBuilder _prefVendorRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _prefVendorRefChildElement = DomUtils.getChildElementByTagName(itemChildElement, "pref-vendor-ref");
                    if (_prefVendorRefChildElement!= null) {
                        parseProperty(_prefVendorRefBuilder, _prefVendorRefChildElement, "value", "value");
                        parseProperty(_prefVendorRefBuilder, _prefVendorRefChildElement, "name", "name");
                        parseProperty(_prefVendorRefBuilder, _prefVendorRefChildElement, "type", "type");
                        itemBuilder.addPropertyValue("prefVendorRef", _prefVendorRefBuilder.getBeanDefinition());
                    }
                }
                parseProperty(itemBuilder, itemChildElement, "avgCost", "avgCost");
                parseProperty(itemBuilder, itemChildElement, "trackQtyOnHand", "trackQtyOnHand");
                parseProperty(itemBuilder, itemChildElement, "qtyOnHand", "qtyOnHand");
                parseProperty(itemBuilder, itemChildElement, "qtyOnPurchaseOrder", "qtyOnPurchaseOrder");
                parseProperty(itemBuilder, itemChildElement, "qtyOnSalesOrder", "qtyOnSalesOrder");
                parseProperty(itemBuilder, itemChildElement, "reorderPoint", "reorderPoint");
                parseProperty(itemBuilder, itemChildElement, "manPartNum", "manPartNum");
                if (!parseObjectRef(itemChildElement, itemBuilder, "deposit-to-account-ref", "depositToAccountRef")) {
                    BeanDefinitionBuilder _depositToAccountRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _depositToAccountRefChildElement = DomUtils.getChildElementByTagName(itemChildElement, "deposit-to-account-ref");
                    if (_depositToAccountRefChildElement!= null) {
                        parseProperty(_depositToAccountRefBuilder, _depositToAccountRefChildElement, "value", "value");
                        parseProperty(_depositToAccountRefBuilder, _depositToAccountRefChildElement, "name", "name");
                        parseProperty(_depositToAccountRefBuilder, _depositToAccountRefChildElement, "type", "type");
                        itemBuilder.addPropertyValue("depositToAccountRef", _depositToAccountRefBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(itemChildElement, itemBuilder, "sales-tax-code-ref", "salesTaxCodeRef")) {
                    BeanDefinitionBuilder _salesTaxCodeRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _salesTaxCodeRefChildElement = DomUtils.getChildElementByTagName(itemChildElement, "sales-tax-code-ref");
                    if (_salesTaxCodeRefChildElement!= null) {
                        parseProperty(_salesTaxCodeRefBuilder, _salesTaxCodeRefChildElement, "value", "value");
                        parseProperty(_salesTaxCodeRefBuilder, _salesTaxCodeRefChildElement, "name", "name");
                        parseProperty(_salesTaxCodeRefBuilder, _salesTaxCodeRefChildElement, "type", "type");
                        itemBuilder.addPropertyValue("salesTaxCodeRef", _salesTaxCodeRefBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(itemChildElement, itemBuilder, "purchase-tax-code-ref", "purchaseTaxCodeRef")) {
                    BeanDefinitionBuilder _purchaseTaxCodeRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                    Element _purchaseTaxCodeRefChildElement = DomUtils.getChildElementByTagName(itemChildElement, "purchase-tax-code-ref");
                    if (_purchaseTaxCodeRefChildElement!= null) {
                        parseProperty(_purchaseTaxCodeRefBuilder, _purchaseTaxCodeRefChildElement, "value", "value");
                        parseProperty(_purchaseTaxCodeRefBuilder, _purchaseTaxCodeRefChildElement, "name", "name");
                        parseProperty(_purchaseTaxCodeRefBuilder, _purchaseTaxCodeRefChildElement, "type", "type");
                        itemBuilder.addPropertyValue("purchaseTaxCodeRef", _purchaseTaxCodeRefBuilder.getBeanDefinition());
                    }
                }
                parseProperty(itemBuilder, itemChildElement, "invStartDate", "invStartDate");
                parseProperty(itemBuilder, itemChildElement, "buildPoint", "buildPoint");
                parseProperty(itemBuilder, itemChildElement, "printGroupedItems", "printGroupedItems");
                parseProperty(itemBuilder, itemChildElement, "specialItem", "specialItem");
                parseProperty(itemBuilder, itemChildElement, "specialItemType", "specialItemType");
                if (!parseObjectRef(itemChildElement, itemBuilder, "item-group-detail", "itemGroupDetail")) {
                    BeanDefinitionBuilder _itemGroupDetailBuilder = BeanDefinitionBuilder.rootBeanDefinition(ItemGroupDetailExpressionHolder.class.getName());
                    Element _itemGroupDetailChildElement = DomUtils.getChildElementByTagName(itemChildElement, "item-group-detail");
                    if (_itemGroupDetailChildElement!= null) {
                        parseListAndSetProperty(_itemGroupDetailChildElement, _itemGroupDetailBuilder, "itemGroupLine", "item-group-line", "item-group-line", new ParseDelegate<BeanDefinition>() {


                            public BeanDefinition parse(Element element) {
                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(ItemComponentLineExpressionHolder.class);
                                if (!parseObjectRef(element, builder, "item-ref", "itemRef")) {
                                    BeanDefinitionBuilder ___itemRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                                    Element ___itemRefChildElement = DomUtils.getChildElementByTagName(element, "item-ref");
                                    if (___itemRefChildElement!= null) {
                                        parseProperty(___itemRefBuilder, ___itemRefChildElement, "value", "value");
                                        parseProperty(___itemRefBuilder, ___itemRefChildElement, "name", "name");
                                        parseProperty(___itemRefBuilder, ___itemRefChildElement, "type", "type");
                                        builder.addPropertyValue("itemRef", ___itemRefBuilder.getBeanDefinition());
                                    }
                                }
                                parseProperty(builder, element, "qty", "qty");
                                return builder.getBeanDefinition();
                            }

                        }
                        );
                        itemBuilder.addPropertyValue("itemGroupDetail", _itemGroupDetailBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(itemChildElement, itemBuilder, "item-assembly-detail", "itemAssemblyDetail")) {
                    BeanDefinitionBuilder _itemAssemblyDetailBuilder = BeanDefinitionBuilder.rootBeanDefinition(ItemAssemblyDetailExpressionHolder.class.getName());
                    Element _itemAssemblyDetailChildElement = DomUtils.getChildElementByTagName(itemChildElement, "item-assembly-detail");
                    if (_itemAssemblyDetailChildElement!= null) {
                        parseListAndSetProperty(_itemAssemblyDetailChildElement, _itemAssemblyDetailBuilder, "itemAssemblyLine", "item-assembly-line", "item-assembly-line", new ParseDelegate<BeanDefinition>() {


                            public BeanDefinition parse(Element element) {
                                BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(ItemComponentLineExpressionHolder.class);
                                if (!parseObjectRef(element, builder, "item-ref", "itemRef")) {
                                    BeanDefinitionBuilder ___itemRefBuilder = BeanDefinitionBuilder.rootBeanDefinition(ReferenceTypeExpressionHolder.class.getName());
                                    Element ___itemRefChildElement = DomUtils.getChildElementByTagName(element, "item-ref");
                                    if (___itemRefChildElement!= null) {
                                        parseProperty(___itemRefBuilder, ___itemRefChildElement, "value", "value");
                                        parseProperty(___itemRefBuilder, ___itemRefChildElement, "name", "name");
                                        parseProperty(___itemRefBuilder, ___itemRefChildElement, "type", "type");
                                        builder.addPropertyValue("itemRef", ___itemRefBuilder.getBeanDefinition());
                                    }
                                }
                                parseProperty(builder, element, "qty", "qty");
                                return builder.getBeanDefinition();
                            }

                        }
                        );
                        itemBuilder.addPropertyValue("itemAssemblyDetail", _itemAssemblyDetailBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(itemChildElement, itemBuilder, "item-ex", "itemEx")) {
                    BeanDefinitionBuilder _itemExBuilder = BeanDefinitionBuilder.rootBeanDefinition(IntuitAnyTypeExpressionHolder.class.getName());
                    Element _itemExChildElement = DomUtils.getChildElementByTagName(itemChildElement, "item-ex");
                    if (_itemExChildElement!= null) {
                        parseListAndSetProperty(_itemExChildElement, _itemExBuilder, "any", "any", "any", new ParseDelegate<String>() {


                            public String parse(Element element) {
                                return element.getTextContent();
                            }

                        }
                        );
                        itemBuilder.addPropertyValue("itemEx", _itemExBuilder.getBeanDefinition());
                    }
                }
                builder.addPropertyValue("item", itemBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
