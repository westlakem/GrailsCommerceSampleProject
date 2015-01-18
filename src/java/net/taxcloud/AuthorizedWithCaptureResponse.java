
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
 *         &lt;element name="AuthorizedWithCaptureResult" type="{http://taxcloud.net}AuthorizedRsp" minOccurs="0"/>
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
    "authorizedWithCaptureResult"
})
@XmlRootElement(name = "AuthorizedWithCaptureResponse")
public class AuthorizedWithCaptureResponse {

    @XmlElement(name = "AuthorizedWithCaptureResult")
    protected AuthorizedRsp authorizedWithCaptureResult;

    /**
     * Gets the value of the authorizedWithCaptureResult property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorizedRsp }
     *     
     */
    public AuthorizedRsp getAuthorizedWithCaptureResult() {
        return authorizedWithCaptureResult;
    }

    /**
     * Sets the value of the authorizedWithCaptureResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorizedRsp }
     *     
     */
    public void setAuthorizedWithCaptureResult(AuthorizedRsp value) {
        this.authorizedWithCaptureResult = value;
    }

}
