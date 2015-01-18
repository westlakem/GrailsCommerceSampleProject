
package net.taxcloud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LookupRsp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LookupRsp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://taxcloud.net}ResponseBase">
 *       &lt;sequence>
 *         &lt;element name="CartID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CartItemsResponse" type="{http://taxcloud.net}ArrayOfCartItemResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LookupRsp", propOrder = {
    "cartID",
    "cartItemsResponse"
})
public class LookupRsp
    extends ResponseBase
{

    @XmlElement(name = "CartID")
    protected String cartID;
    @XmlElement(name = "CartItemsResponse")
    protected ArrayOfCartItemResponse cartItemsResponse;

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
     * Gets the value of the cartItemsResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCartItemResponse }
     *     
     */
    public ArrayOfCartItemResponse getCartItemsResponse() {
        return cartItemsResponse;
    }

    /**
     * Sets the value of the cartItemsResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCartItemResponse }
     *     
     */
    public void setCartItemsResponse(ArrayOfCartItemResponse value) {
        this.cartItemsResponse = value;
    }

}
