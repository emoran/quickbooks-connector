/**
 * Mule QuickBooks Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.08.15 at 05:31:44 PM GMT-03:00 
//


package org.mule.modules.quickbooks.windows.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DetailColumnsEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DetailColumnsEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AccountId"/>
 *     &lt;enumeration value="AccountName"/>
 *     &lt;enumeration value="AccountType"/>
 *     &lt;enumeration value="Amount"/>
 *     &lt;enumeration value="ClassId"/>
 *     &lt;enumeration value="ClassName"/>
 *     &lt;enumeration value="DueDate"/>
 *     &lt;enumeration value="ItemId"/>
 *     &lt;enumeration value="ItemDesc"/>
 *     &lt;enumeration value="ItemName"/>
 *     &lt;enumeration value="ItemType"/>
 *     &lt;enumeration value="Memo"/>
 *     &lt;enumeration value="NameId"/>
 *     &lt;enumeration value="NameType"/>
 *     &lt;enumeration value="Name"/>
 *     &lt;enumeration value="Qnty"/>
 *     &lt;enumeration value="TermId"/>
 *     &lt;enumeration value="TermName"/>
 *     &lt;enumeration value="TxnDate"/>
 *     &lt;enumeration value="TxnType"/>
 *     &lt;enumeration value="UnitPrice"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DetailColumnsEnum")
@XmlEnum
public enum DetailColumnsEnum {

    @XmlEnumValue("AccountId")
    ACCOUNT_ID("AccountId"),
    @XmlEnumValue("AccountName")
    ACCOUNT_NAME("AccountName"),
    @XmlEnumValue("AccountType")
    ACCOUNT_TYPE("AccountType"),
    @XmlEnumValue("Amount")
    AMOUNT("Amount"),
    @XmlEnumValue("ClassId")
    CLASS_ID("ClassId"),
    @XmlEnumValue("ClassName")
    CLASS_NAME("ClassName"),
    @XmlEnumValue("DueDate")
    DUE_DATE("DueDate"),
    @XmlEnumValue("ItemId")
    ITEM_ID("ItemId"),
    @XmlEnumValue("ItemDesc")
    ITEM_DESC("ItemDesc"),
    @XmlEnumValue("ItemName")
    ITEM_NAME("ItemName"),
    @XmlEnumValue("ItemType")
    ITEM_TYPE("ItemType"),
    @XmlEnumValue("Memo")
    MEMO("Memo"),
    @XmlEnumValue("NameId")
    NAME_ID("NameId"),
    @XmlEnumValue("NameType")
    NAME_TYPE("NameType"),
    @XmlEnumValue("Name")
    NAME("Name"),
    @XmlEnumValue("Qnty")
    QNTY("Qnty"),
    @XmlEnumValue("TermId")
    TERM_ID("TermId"),
    @XmlEnumValue("TermName")
    TERM_NAME("TermName"),
    @XmlEnumValue("TxnDate")
    TXN_DATE("TxnDate"),
    @XmlEnumValue("TxnType")
    TXN_TYPE("TxnType"),
    @XmlEnumValue("UnitPrice")
    UNIT_PRICE("UnitPrice");
    private final String value;

    DetailColumnsEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DetailColumnsEnum fromValue(String v) {
        for (DetailColumnsEnum c: DetailColumnsEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
