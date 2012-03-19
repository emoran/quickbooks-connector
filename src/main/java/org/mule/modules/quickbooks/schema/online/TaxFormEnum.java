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
 * <p>Java class for TaxFormEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaxFormEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Form1040"/>
 *     &lt;enumeration value="Form1065"/>
 *     &lt;enumeration value="Form1120"/>
 *     &lt;enumeration value="Form1120S"/>
 *     &lt;enumeration value="Form990"/>
 *     &lt;enumeration value="Form990PF"/>
 *     &lt;enumeration value="Form990T"/>
 *     &lt;enumeration value="OtherOrNone"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaxFormEnum")
@XmlEnum
public enum TaxFormEnum {

    @XmlEnumValue("Form1040")
    FORM_1040("Form1040"),
    @XmlEnumValue("Form1065")
    FORM_1065("Form1065"),
    @XmlEnumValue("Form1120")
    FORM_1120("Form1120"),
    @XmlEnumValue("Form1120S")
    FORM_1120_S("Form1120S"),
    @XmlEnumValue("Form990")
    FORM_990("Form990"),
    @XmlEnumValue("Form990PF")
    FORM_990_PF("Form990PF"),
    @XmlEnumValue("Form990T")
    FORM_990_T("Form990T"),
    @XmlEnumValue("OtherOrNone")
    OTHER_OR_NONE("OtherOrNone");
    private final String value;

    TaxFormEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TaxFormEnum fromValue(String v) {
        for (TaxFormEnum c: TaxFormEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
