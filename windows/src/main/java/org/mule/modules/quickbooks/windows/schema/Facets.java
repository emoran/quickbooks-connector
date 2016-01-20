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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Facets complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Facets">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;element name="FacetType" minOccurs="0">
 *         &lt;complexType>
 *           &lt;complexContent>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *               &lt;element name="facet" type="{http://www.intuit.com/sb/cdm/v2}facet" maxOccurs="unbounded" minOccurs="0"/>
 *               &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *             &lt;/restriction>
 *           &lt;/complexContent>
 *         &lt;/complexType>
 *       &lt;/element>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Facets", propOrder = {
    "facetType"
})
public class Facets
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "FacetType")
    protected Facets.FacetType facetType;

    /**
     * Gets the value of the facetType property.
     * 
     * @return
     *     possible object is
     *     {@link Facets.FacetType }
     *     
     */
    public Facets.FacetType getFacetType() {
        return facetType;
    }

    /**
     * Sets the value of the facetType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Facets.FacetType }
     *     
     */
    public void setFacetType(Facets.FacetType value) {
        this.facetType = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;element name="facet" type="{http://www.intuit.com/sb/cdm/v2}facet" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "facet"
    })
    public static class FacetType
        implements Serializable
    {

        private final static long serialVersionUID = 1L;
        protected List<Facet> facet;
        @XmlAttribute(name = "name")
        protected String name;

        /**
         * Gets the value of the facet property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the facet property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFacet().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Facet }
         * 
         * 
         */
        public List<Facet> getFacet() {
            if (facet == null) {
                facet = new ArrayList<Facet>();
            }
            return this.facet;
        }

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
         * Sets the value of the facet property.
         * 
         * @param facet
         *     allowed object is
         *     {@link Facet }
         *     
         */
        public void setFacet(List<Facet> facet) {
            this.facet = facet;
        }

    }

}