
package net.taxcloud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Transaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Transaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cartID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orderID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cartItems" type="{http://taxcloud.net}ArrayOfTransactionCartItem" minOccurs="0"/>
 *         &lt;element name="origin" type="{http://taxcloud.net}Address" minOccurs="0"/>
 *         &lt;element name="destination" type="{http://taxcloud.net}Address" minOccurs="0"/>
 *         &lt;element name="deliveredBySeller" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="exemptCert" type="{http://taxcloud.net}ExemptionCertificate" minOccurs="0"/>
 *         &lt;element name="dateTransaction" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="dateAuthorized" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="dateCaptured" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transaction", propOrder = {
    "customerID",
    "cartID",
    "orderID",
    "cartItems",
    "origin",
    "destination",
    "deliveredBySeller",
    "exemptCert",
    "dateTransaction",
    "dateAuthorized",
    "dateCaptured"
})
public class Transaction {

    protected String customerID;
    protected String cartID;
    protected String orderID;
    protected ArrayOfTransactionCartItem cartItems;
    protected Address origin;
    protected Address destination;
    protected boolean deliveredBySeller;
    protected ExemptionCertificate exemptCert;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTransaction;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateAuthorized;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCaptured;

    /**
     * Gets the value of the customerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerID() {
        return customerID;
    }

    /**
     * Sets the value of the customerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerID(String value) {
        this.customerID = value;
    }

    /**
     * Gets the value of the cartID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCartID() {
        return cartID;
    }

    /**
     * Sets the value of the cartID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCartID(String value) {
        this.cartID = value;
    }

    /**
     * Gets the value of the orderID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * Sets the value of the orderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderID(String value) {
        this.orderID = value;
    }

    /**
     * Gets the value of the cartItems property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTransactionCartItem }
     *     
     */
    public ArrayOfTransactionCartItem getCartItems() {
        return cartItems;
    }

    /**
     * Sets the value of the cartItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTransactionCartItem }
     *     
     */
    public void setCartItems(ArrayOfTransactionCartItem value) {
        this.cartItems = value;
    }

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setOrigin(Address value) {
        this.origin = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setDestination(Address value) {
        this.destination = value;
    }

    /**
     * Gets the value of the deliveredBySeller property.
     * 
     */
    public boolean isDeliveredBySeller() {
        return deliveredBySeller;
    }

    /**
     * Sets the value of the deliveredBySeller property.
     * 
     */
    public void setDeliveredBySeller(boolean value) {
        this.deliveredBySeller = value;
    }

    /**
     * Gets the value of the exemptCert property.
     * 
     * @return
     *     possible object is
     *     {@link ExemptionCertificate }
     *     
     */
    public ExemptionCertificate getExemptCert() {
        return exemptCert;
    }

    /**
     * Sets the value of the exemptCert property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExemptionCertificate }
     *     
     */
    public void setExemptCert(ExemptionCertificate value) {
        this.exemptCert = value;
    }

    /**
     * Gets the value of the dateTransaction property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTransaction() {
        return dateTransaction;
    }

    /**
     * Sets the value of the dateTransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTransaction(XMLGregorianCalendar value) {
        this.dateTransaction = value;
    }

    /**
     * Gets the value of the dateAuthorized property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateAuthorized() {
        return dateAuthorized;
    }

    /**
     * Sets the value of the dateAuthorized property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateAuthorized(XMLGregorianCalendar value) {
        this.dateAuthorized = value;
    }

    /**
     * Gets the value of the dateCaptured property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCaptured() {
        return dateCaptured;
    }

    /**
     * Sets the value of the dateCaptured property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCaptured(XMLGregorianCalendar value) {
        this.dateCaptured = value;
    }

}
