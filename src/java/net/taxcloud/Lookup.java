
package net.taxcloud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="apiLoginID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apiKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cartID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cartItems" type="{http://taxcloud.net}ArrayOfCartItem" minOccurs="0"/>
 *         &lt;element name="origin" type="{http://taxcloud.net}Address" minOccurs="0"/>
 *         &lt;element name="destination" type="{http://taxcloud.net}Address" minOccurs="0"/>
 *         &lt;element name="deliveredBySeller" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="exemptCert" type="{http://taxcloud.net}ExemptionCertificate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "apiLoginID",
    "apiKey",
    "customerID",
    "cartID",
    "cartItems",
    "origin",
    "destination",
    "deliveredBySeller",
    "exemptCert"
})
@XmlRootElement(name = "Lookup")
public class Lookup {

    protected String apiLoginID;
    protected String apiKey;
    protected String customerID;
    protected String cartID;
    protected ArrayOfCartItem cartItems;
    protected Address origin;
    protected Address destination;
    protected boolean deliveredBySeller;
    protected ExemptionCertificate exemptCert;

    /**
     * Gets the value of the apiLoginID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiLoginID() {
        return apiLoginID;
    }

    /**
     * Sets the value of the apiLoginID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiLoginID(String value) {
        this.apiLoginID = value;
    }

    /**
     * Gets the value of the apiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the value of the apiKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiKey(String value) {
        this.apiKey = value;
    }

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
     * Gets the value of the cartItems property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCartItem }
     *     
     */
    public ArrayOfCartItem getCartItems() {
        return cartItems;
    }

    /**
     * Sets the value of the cartItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCartItem }
     *     
     */
    public void setCartItems(ArrayOfCartItem value) {
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

}
