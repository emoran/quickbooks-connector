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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         Product: QBW
 *         Description: Object that allows adding a role that will allow for filtering data pertaining only to the requestor.
 *       
 * 
 * <p>Java class for ExternalRole complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExternalRole">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.intuit.com/sb/cdm/v2}CdmObject">
 *       &lt;sequence>
 *         &lt;element name="AuthId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RoleId">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;restriction base="&lt;http://www.intuit.com/sb/cdm/v2>IdType">
 *                 &lt;attribute name="idDomain" use="required" type="{http://www.intuit.com/sb/cdm/v2}idDomainEnum" fixed="QB" />
 *               &lt;/restriction>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RoleType" type="{http://www.intuit.com/sb/cdm/v2}roleType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalRole", propOrder = {
    "authId",
    "roleId",
    "roleType"
})
public class ExternalRole
    extends CdmObject
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "AuthId", required = true)
    protected String authId;
    @XmlElement(name = "RoleId", required = true)
    protected ExternalRole.RoleId roleId;
    @XmlElement(name = "RoleType")
    protected RoleType roleType;

    /**
     * Gets the value of the authId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthId() {
        return authId;
    }

    /**
     * Sets the value of the authId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthId(String value) {
        this.authId = value;
    }

    /**
     * Gets the value of the roleId property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalRole.RoleId }
     *     
     */
    public ExternalRole.RoleId getRoleId() {
        return roleId;
    }

    /**
     * Sets the value of the roleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalRole.RoleId }
     *     
     */
    public void setRoleId(ExternalRole.RoleId value) {
        this.roleId = value;
    }

    /**
     * Gets the value of the roleType property.
     * 
     * @return
     *     possible object is
     *     {@link RoleType }
     *     
     */
    public RoleType getRoleType() {
        return roleType;
    }

    /**
     * Sets the value of the roleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoleType }
     *     
     */
    public void setRoleType(RoleType value) {
        this.roleType = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;restriction base="&lt;http://www.intuit.com/sb/cdm/v2>IdType">
     *       &lt;attribute name="idDomain" use="required" type="{http://www.intuit.com/sb/cdm/v2}idDomainEnum" fixed="QB" />
     *     &lt;/restriction>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class RoleId
        extends IdType
        implements Serializable
    {

        private final static long serialVersionUID = 1L;

    }

}