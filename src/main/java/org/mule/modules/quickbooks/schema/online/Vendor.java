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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 *  Describes the Party as a Vendor Role view 
 * 
 * <p>Java class for Vendor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Vendor">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.intuit.com/sb/cdm/v2}RoleBase">
 *       &lt;sequence>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ShowAs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;group ref="{http://www.intuit.com/sb/cdm/v2}VendorTypeReferenceGroup" minOccurs="0"/>
 *         &lt;group ref="{http://www.intuit.com/sb/cdm/v2}SalesTermReferenceGroup" minOccurs="0"/>
 *         &lt;element name="OpenBalance" type="{http://www.intuit.com/sb/cdm/v2}Money" minOccurs="0"/>
 *         &lt;element name="OpenBalanceDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="CreditLimit" type="{http://www.intuit.com/sb/cdm/v2}Money" minOccurs="0"/>
 *         &lt;element name="AcctNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Vendor1099" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Vendor", propOrder = {
    "active",
    "showAs",
    "vendorTypeId",
    "vendorTypeName",
    "salesTermId",
    "salesTermName",
    "openBalance",
    "openBalanceDate",
    "creditLimit",
    "acctNum",
    "vendor1099"
})
public class Vendor
    extends RoleBase
{

    @XmlElement(name = "Active")
    protected Boolean active;
    @XmlElement(name = "ShowAs")
    protected String showAs;
    @XmlElement(name = "VendorTypeId")
    protected IdType vendorTypeId;
    @XmlElement(name = "VendorTypeName")
    protected String vendorTypeName;
    @XmlElement(name = "SalesTermId")
    protected IdType salesTermId;
    @XmlElement(name = "SalesTermName")
    protected String salesTermName;
    @XmlElement(name = "OpenBalance")
    protected Money openBalance;
    @XmlElement(name = "OpenBalanceDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar openBalanceDate;
    @XmlElement(name = "CreditLimit")
    protected Money creditLimit;
    @XmlElement(name = "AcctNum")
    protected String acctNum;
    @XmlElement(name = "Vendor1099")
    protected Boolean vendor1099;

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActive() {
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
     * Gets the value of the showAs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShowAs() {
        return showAs;
    }

    /**
     * Sets the value of the showAs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShowAs(String value) {
        this.showAs = value;
    }

    /**
     * Gets the value of the vendorTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link IdType }
     *     
     */
    public IdType getVendorTypeId() {
        return vendorTypeId;
    }

    /**
     * Sets the value of the vendorTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdType }
     *     
     */
    public void setVendorTypeId(IdType value) {
        this.vendorTypeId = value;
    }

    /**
     * Gets the value of the vendorTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVendorTypeName() {
        return vendorTypeName;
    }

    /**
     * Sets the value of the vendorTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVendorTypeName(String value) {
        this.vendorTypeName = value;
    }

    /**
     * Gets the value of the salesTermId property.
     * 
     * @return
     *     possible object is
     *     {@link IdType }
     *     
     */
    public IdType getSalesTermId() {
        return salesTermId;
    }

    /**
     * Sets the value of the salesTermId property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdType }
     *     
     */
    public void setSalesTermId(IdType value) {
        this.salesTermId = value;
    }

    /**
     * Gets the value of the salesTermName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalesTermName() {
        return salesTermName;
    }

    /**
     * Sets the value of the salesTermName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesTermName(String value) {
        this.salesTermName = value;
    }

    /**
     * Gets the value of the openBalance property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getOpenBalance() {
        return openBalance;
    }

    /**
     * Sets the value of the openBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setOpenBalance(Money value) {
        this.openBalance = value;
    }

    /**
     * Gets the value of the openBalanceDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOpenBalanceDate() {
        return openBalanceDate;
    }

    /**
     * Sets the value of the openBalanceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOpenBalanceDate(XMLGregorianCalendar value) {
        this.openBalanceDate = value;
    }

    /**
     * Gets the value of the creditLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Money }
     *     
     */
    public Money getCreditLimit() {
        return creditLimit;
    }

    /**
     * Sets the value of the creditLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Money }
     *     
     */
    public void setCreditLimit(Money value) {
        this.creditLimit = value;
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
     * Gets the value of the vendor1099 property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVendor1099() {
        return vendor1099;
    }

    /**
     * Sets the value of the vendor1099 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVendor1099(Boolean value) {
        this.vendor1099 = value;
    }

}
