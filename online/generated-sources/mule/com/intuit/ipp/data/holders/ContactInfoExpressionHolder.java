
package com.intuit.ipp.data.holders;

import javax.annotation.Generated;
import com.intuit.ipp.data.ContactTypeEnum;
import com.intuit.ipp.data.EmailAddress;
import com.intuit.ipp.data.GenericContactType;
import com.intuit.ipp.data.TelephoneNumber;
import com.intuit.ipp.data.WebSiteAddress;

@Generated(value = "Mule DevKit Version 3.4.3", date = "2014-08-15T04:14:53-05:00", comments = "Build 3.4.3.1620.30ea288")
public class ContactInfoExpressionHolder {

    protected Object type;
    protected ContactTypeEnum _typeType;
    protected Object telephone;
    protected TelephoneNumber _telephoneType;
    protected Object email;
    protected EmailAddress _emailType;
    protected Object webSite;
    protected WebSiteAddress _webSiteType;
    protected Object otherContact;
    protected GenericContactType _otherContactType;

    /**
     * Sets type
     * 
     * @param value Value to set
     */
    public void setType(Object value) {
        this.type = value;
    }

    /**
     * Retrieves type
     * 
     */
    public Object getType() {
        return this.type;
    }

    /**
     * Sets telephone
     * 
     * @param value Value to set
     */
    public void setTelephone(Object value) {
        this.telephone = value;
    }

    /**
     * Retrieves telephone
     * 
     */
    public Object getTelephone() {
        return this.telephone;
    }

    /**
     * Sets email
     * 
     * @param value Value to set
     */
    public void setEmail(Object value) {
        this.email = value;
    }

    /**
     * Retrieves email
     * 
     */
    public Object getEmail() {
        return this.email;
    }

    /**
     * Sets webSite
     * 
     * @param value Value to set
     */
    public void setWebSite(Object value) {
        this.webSite = value;
    }

    /**
     * Retrieves webSite
     * 
     */
    public Object getWebSite() {
        return this.webSite;
    }

    /**
     * Sets otherContact
     * 
     * @param value Value to set
     */
    public void setOtherContact(Object value) {
        this.otherContact = value;
    }

    /**
     * Retrieves otherContact
     * 
     */
    public Object getOtherContact() {
        return this.otherContact;
    }

}
