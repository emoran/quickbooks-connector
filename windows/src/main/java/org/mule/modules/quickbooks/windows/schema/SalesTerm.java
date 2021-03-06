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
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         Product: QBO
 *         Description: Terms under which a sale will be paid, typically expressed in form of days due after goods received.  There is an optional discount part of the sales term, where  a discount of total amount can automatically be taken if payment is made by some  period.  (e.g. net 30 means payment within 30 days; 2%/15 net 60 means payment must be made within 60 days, and a 2% discount can be taken if payment is made within 15 days) Also Supports the ability to specify an absolute due date, a number of days from a start date, a percent discount or an absolute discount. A common term like "Net30Days" is explicitly code as either a calculated DueDateTime or a PaymentTermsDateTime and NumberOfDays.
 *         Endpoint: qbo.intuit.com
 *         Business Rules: None        
 *         Product: QBW
 *         Description: Terms under which a sale will be paid, typically expressed in form of days due after goods received.  There is an optional discount part of the sales term, where  a discount of total amount can automatically be taken if payment is made by some  period.  (e.g. net 30 means payment within 30 days; 2%/15 net 60 means payment must be made within 60 days, and a 2% discount can be taken if payment is made within 15 days) Also Supports the ability to specify an absolute due date, a number of days from a start date, a percent discount or an absolute discount. A common term like "Net30Days" is explicitly code as either a calculated DueDateTime or a PaymentTermsDateTime and NumberOfDays.
 *         Endpoint: services.intuit.com
 *         Business Rules: None        
 *       
 * 
 * <p>Java class for SalesTerm complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SalesTerm">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.intuit.com/sb/cdm/v2}CdmBase">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;sequence>
 *             &lt;element name="DueDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *             &lt;element name="DiscountDays" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *             &lt;element name="DiscountPercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element name="DayOfMonthDue" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *             &lt;element name="DueNextMonthDays" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *             &lt;element name="DiscountDayOfMonth" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *             &lt;element name="DateDiscountPercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SalesTerm", propOrder = {
    "name",
    "active",
    "type",
    "dueDays",
    "discountDays",
    "discountPercent",
    "dayOfMonthDue",
    "dueNextMonthDays",
    "discountDayOfMonth",
    "dateDiscountPercent"
})
public class SalesTerm
    extends CdmBase
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Active")
    protected Boolean active;
    @XmlElement(name = "Type")
    protected String type;
    @XmlElement(name = "DueDays")
    protected BigInteger dueDays;
    @XmlElement(name = "DiscountDays")
    protected BigInteger discountDays;
    @XmlElement(name = "DiscountPercent")
    protected BigDecimal discountPercent;
    @XmlElement(name = "DayOfMonthDue")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger dayOfMonthDue;
    @XmlElement(name = "DueNextMonthDays")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger dueNextMonthDays;
    @XmlElement(name = "DiscountDayOfMonth")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger discountDayOfMonth;
    @XmlElement(name = "DateDiscountPercent")
    protected BigDecimal dateDiscountPercent;

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
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the dueDays property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDueDays() {
        return dueDays;
    }

    /**
     * Sets the value of the dueDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDueDays(BigInteger value) {
        this.dueDays = value;
    }

    /**
     * Gets the value of the discountDays property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDiscountDays() {
        return discountDays;
    }

    /**
     * Sets the value of the discountDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDiscountDays(BigInteger value) {
        this.discountDays = value;
    }

    /**
     * Gets the value of the discountPercent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    /**
     * Sets the value of the discountPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDiscountPercent(BigDecimal value) {
        this.discountPercent = value;
    }

    /**
     * Gets the value of the dayOfMonthDue property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDayOfMonthDue() {
        return dayOfMonthDue;
    }

    /**
     * Sets the value of the dayOfMonthDue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDayOfMonthDue(BigInteger value) {
        this.dayOfMonthDue = value;
    }

    /**
     * Gets the value of the dueNextMonthDays property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDueNextMonthDays() {
        return dueNextMonthDays;
    }

    /**
     * Sets the value of the dueNextMonthDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDueNextMonthDays(BigInteger value) {
        this.dueNextMonthDays = value;
    }

    /**
     * Gets the value of the discountDayOfMonth property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDiscountDayOfMonth() {
        return discountDayOfMonth;
    }

    /**
     * Sets the value of the discountDayOfMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDiscountDayOfMonth(BigInteger value) {
        this.discountDayOfMonth = value;
    }

    /**
     * Gets the value of the dateDiscountPercent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDateDiscountPercent() {
        return dateDiscountPercent;
    }

    /**
     * Sets the value of the dateDiscountPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDateDiscountPercent(BigDecimal value) {
        this.dateDiscountPercent = value;
    }

}
