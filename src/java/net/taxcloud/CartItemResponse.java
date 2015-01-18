
package net.taxcloud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CartItemResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CartItemResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CartItemIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TaxAmount" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CartItemResponse", propOrder = {
    "cartItemIndex",
    "taxAmount"
})
public class CartItemResponse {

    @XmlElement(name = "CartItemIndex")
    protected int cartItemIndex;
    @XmlElement(name = "TaxAmount")
    protected float taxAmount;

    /**
     * Gets the value of the cartItemIndex property.
     * 
     */
    public int getCartItemIndex() {
        return cartItemIndex;
    }

    /**
     * Sets the value of the cartItemIndex property.
     * 
     */
    public void setCartItemIndex(int value) {
        this.cartItemIndex = value;
    }

    /**
     * Gets the value of the taxAmount property.
     * 
     */
    public float getTaxAmount() {
        return taxAmount;
    }

    /**
     * Sets the value of the taxAmount property.
     * 
     */
    public void setTaxAmount(float value) {
        this.taxAmount = value;
    }

}
