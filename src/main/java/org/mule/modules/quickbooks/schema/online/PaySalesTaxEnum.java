//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.19 at 02:46:29 PM ART 
//


package org.mule.modules.quickbooks.schema.online;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaySalesTaxEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PaySalesTaxEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Annually"/>
 *     &lt;enumeration value="Monthly"/>
 *     &lt;enumeration value="Quarterly"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaySalesTaxEnum")
@XmlEnum
public enum PaySalesTaxEnum {

    @XmlEnumValue("Annually")
    ANNUALLY("Annually"),
    @XmlEnumValue("Monthly")
    MONTHLY("Monthly"),
    @XmlEnumValue("Quarterly")
    QUARTERLY("Quarterly");
    private final String value;

    PaySalesTaxEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PaySalesTaxEnum fromValue(String v) {
        for (PaySalesTaxEnum c: PaySalesTaxEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
