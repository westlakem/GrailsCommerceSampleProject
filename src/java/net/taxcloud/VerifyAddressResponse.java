
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
 *         &lt;element name="VerifyAddressResult" type="{http://taxcloud.net}VerifiedAddress" minOccurs="0"/>
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
    "verifyAddressResult"
})
@XmlRootElement(name = "VerifyAddressResponse")
public class VerifyAddressResponse {

    @XmlElement(name = "VerifyAddressResult")
    protected VerifiedAddress verifyAddressResult;

    /**
     * Gets the value of the verifyAddressResult property.
     * 
     * @return
     *     possible object is
     *     {@link VerifiedAddress }
     *     
     */
    public VerifiedAddress getVerifyAddressResult() {
        return verifyAddressResult;
    }

    /**
     * Sets the value of the verifyAddressResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link VerifiedAddress }
     *     
     */
    public void setVerifyAddressResult(VerifiedAddress value) {
        this.verifyAddressResult = value;
    }

}
