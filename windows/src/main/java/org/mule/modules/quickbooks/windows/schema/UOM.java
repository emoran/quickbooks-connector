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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         Product: QBW
 *         Description: You can use the UOM (Unit of Measure) object to represent data such as quantities, prices, rates, and costs, in units. This object also helps you to convert these units to related units. The UOM type defines the data used to represent a set of equivalent units and the conversion rates to other related units. It allows showing what quantities, prices, rates, and costs are based on.
 *         Endpoint: services.intuit.com
 *         Business Rules: None        
 *       
 * 
 * <p>Java class for UOM complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UOM">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.intuit.com/sb/cdm/v2}CdmBase">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Abbrv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BaseType" type="{http://www.intuit.com/sb/cdm/v2}UOMBaseTypeEnum" minOccurs="0"/>
 *         &lt;element name="ConvUnit" type="{http://www.intuit.com/sb/cdm/v2}UOMConvUnit" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UOM", propOrder = {
    "name",
    "abbrv",
    "baseType",
    "convUnit"
})
public class UOM
    extends CdmBase
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Abbrv")
    protected String abbrv;
    @XmlElement(name = "BaseType")
    protected UOMBaseTypeEnum baseType;
    @XmlElement(name = "ConvUnit")
    protected List<UOMConvUnit> convUnit;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the abbrv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAbbrv() {
        return abbrv;
    }

    /**
     * Sets the value of the abbrv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAbbrv(String value) {
        this.abbrv = value;
    }

    /**
     * Gets the value of the baseType property.
     * 
     * @return
     *     possible object is
     *     {@link UOMBaseTypeEnum }
     *     
     */
    public UOMBaseTypeEnum getBaseType() {
        return baseType;
    }

    /**
     * Sets the value of the baseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link UOMBaseTypeEnum }
     *     
     */
    public void setBaseType(UOMBaseTypeEnum value) {
        this.baseType = value;
    }

    /**
     * Gets the value of the convUnit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the convUnit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConvUnit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UOMConvUnit }
     * 
     * 
     */
    public List<UOMConvUnit> getConvUnit() {
        if (convUnit == null) {
            convUnit = new ArrayList<UOMConvUnit>();
        }
        return this.convUnit;
    }

    /**
     * Sets the value of the convUnit property.
     * 
     * @param convUnit
     *     allowed object is
     *     {@link UOMConvUnit }
     *     
     */
    public void setConvUnit(List<UOMConvUnit> convUnit) {
        this.convUnit = convUnit;
    }

}