
package net.taxcloud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="AuthorizedResult" type="{http://taxcloud.net}AuthorizedRsp" minOccurs="0"/>
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
    "authorizedResult"
})
@XmlRootElement(name = "AuthorizedResponse")
public class AuthorizedResponse {

    @XmlElement(name = "AuthorizedResult")
    protected AuthorizedRsp authorizedResult;

    /**
     * Gets the value of the authorizedResult property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorizedRsp }
     *     
     */
    public AuthorizedRsp getAuthorizedResult() {
        return authorizedResult;
    }

    /**
     * Sets the value of the authorizedResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorizedRsp }
     *     
     */
    public void setAuthorizedResult(AuthorizedRsp value) {
        this.authorizedResult = value;
    }

}
