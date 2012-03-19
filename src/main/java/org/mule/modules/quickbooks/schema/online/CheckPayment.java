//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.19 at 02:46:29 PM ART 
//


package org.mule.modules.quickbooks.schema.online;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Holds information about a payment received by check
 * 
 * <p>Java class for CheckPayment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckPayment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CheckNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameOnAcct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AcctNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RoutingNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckPayment", propOrder = {
    "checkNum",
    "status",
    "nameOnAcct",
    "acctNum",
    "routingNum",
    "bankName"
})
public class CheckPayment {

    @XmlElement(name = "CheckNum")
    protected String checkNum;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "NameOnAcct")
    protected String nameOnAcct;
    @XmlElement(name = "AcctNum")
    protected String acctNum;
    @XmlElement(name = "RoutingNum")
    protected String routingNum;
    @XmlElement(name = "BankName")
    protected String bankName;

    /**
     * Gets the value of the checkNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckNum() {
        return checkNum;
    }

    /**
     * Sets the value of the checkNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckNum(String value) {
        this.checkNum = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the nameOnAcct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOnAcct() {
        return nameOnAcct;
    }

    /**
     * Sets the value of the nameOnAcct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOnAcct(String value) {
        this.nameOnAcct = value;
    }

    /**
     * Gets the value of the acctNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctNum() {
        return acctNum;
    }

    /**
     * Sets the value of the acctNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctNum(String value) {
        this.acctNum = value;
    }

    /**
     * Gets the value of the routingNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoutingNum() {
        return routingNum;
    }

    /**
     * Sets the value of the routingNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoutingNum(String value) {
        this.routingNum = value;
    }

    /**
     * Gets the value of the bankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets the value of the bankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankName(String value) {
        this.bankName = value;
    }

}
