//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.19 at 02:46:29 PM ART 
//


package org.mule.modules.quickbooks.schema.online;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the CdmBase type which can be used as base type for all Intuit CDM objects that can be identified and modified as a top level CDM, example for top level CDMs are Party, Customer, Vendor in case of CMO these can extend from CdmBase. Though Physical Address, EmailAddress belong to a Party it can be manipulated as a independent object hence these also can be a "extension" of CdmBase. However CustomFields, Money is always associated with another top level CDM and will not be manipulated as independent object hence these CDMs are not considered as extension of CdmBase 
 * 
 * <p>Java class for CdmBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CdmBase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.intuit.com/sb/cdm/v2}IdType" minOccurs="0"/>
 *         &lt;element name="SyncToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MetaData" type="{http://www.intuit.com/sb/cdm/v2}ModificationMetaData" minOccurs="0"/>
 *         &lt;element name="ExternalKey" type="{http://www.intuit.com/sb/cdm/v2}IdType" minOccurs="0"/>
 *         &lt;element name="Synchronized" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AlternateId" type="{http://www.intuit.com/sb/cdm/v2}NameValue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CdmBase", propOrder = {
    "id",
    "syncToken",
    "metaData",
    "externalKey",
    "_synchronized",
    "alternateId"
})
@XmlSeeAlso({
    TimeActivity.class,
    CreditCardCharge.class,
    Payment.class,
    Item.class,
    SalesReceipt.class,
    Discount.class,
    SalesTaxCode.class,
    CreditMemo.class,
    Party.class,
    Invoice.class,
    Charge.class,
    PaymentMethod.class,
    CreditCardCredit.class,
    PurchaseOrder.class,
    SalesOrder.class,
    Class.class,
    ItemReceipt.class,
    SalesRep.class,
    ShipMethod.class,
    Account.class,
    SalesTax.class,
    SalesTaxGroup.class,
    CashPurchase.class,
    InventoryAdjustment.class,
    SalesTerm.class,
    Check.class,
    Estimate.class,
    JournalEntry.class,
    VendorCreditToApply.class,
    TxnGeneric.class,
    VendorCredit.class,
    Parties.class,
    Bill.class,
    BillPayment.class,
    UOM.class,
    SalesTaxPaymentCheck.class,
    Person.class,
    Note.class,
    Organization.class,
    RoleBase.class,
    PayrollTxnBase.class
})
public abstract class CdmBase {

    @XmlElement(name = "Id")
    protected IdType id;
    @XmlElement(name = "SyncToken")
    protected String syncToken;
    @XmlElement(name = "MetaData")
    protected ModificationMetaData metaData;
    @XmlElement(name = "ExternalKey")
    protected IdType externalKey;
    @XmlElement(name = "Synchronized")
    protected Boolean _synchronized;
    @XmlElement(name = "AlternateId")
    protected List<NameValue> alternateId;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link IdType }
     *     
     */
    public IdType getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdType }
     *     
     */
    public void setId(IdType value) {
        this.id = value;
    }

    /**
     * Gets the value of the syncToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSyncToken() {
        return syncToken;
    }

    /**
     * Sets the value of the syncToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSyncToken(String value) {
        this.syncToken = value;
    }

    /**
     * Gets the value of the metaData property.
     * 
     * @return
     *     possible object is
     *     {@link ModificationMetaData }
     *     
     */
    public ModificationMetaData getMetaData() {
        return metaData;
    }

    /**
     * Sets the value of the metaData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModificationMetaData }
     *     
     */
    public void setMetaData(ModificationMetaData value) {
        this.metaData = value;
    }

    /**
     * Gets the value of the externalKey property.
     * 
     * @return
     *     possible object is
     *     {@link IdType }
     *     
     */
    public IdType getExternalKey() {
        return externalKey;
    }

    /**
     * Sets the value of the externalKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdType }
     *     
     */
    public void setExternalKey(IdType value) {
        this.externalKey = value;
    }

    /**
     * Gets the value of the synchronized property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSynchronized() {
        return _synchronized;
    }

    /**
     * Sets the value of the synchronized property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSynchronized(Boolean value) {
        this._synchronized = value;
    }

    /**
     * Gets the value of the alternateId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alternateId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlternateId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NameValue }
     * 
     * 
     */
    public List<NameValue> getAlternateId() {
        if (alternateId == null) {
            alternateId = new ArrayList<NameValue>();
        }
        return this.alternateId;
    }

}
