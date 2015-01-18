
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
 *         &lt;element name="CapturedResult" type="{http://taxcloud.net}CapturedRsp" minOccurs="0"/>
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
    "capturedResult"
})
@XmlRootElement(name = "CapturedResponse")
public class CapturedResponse {

    @XmlElement(name = "CapturedResult")
    protected CapturedRsp capturedResult;

    /**
     * Gets the value of the capturedResult property.
     * 
     * @return
     *     possible object is
     *     {@link CapturedRsp }
     *     
     */
    public CapturedRsp getCapturedResult() {
        return capturedResult;
    }

    /**
     * Sets the value of the capturedResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CapturedRsp }
     *     
     */
    public void setCapturedResult(CapturedRsp value) {
        this.capturedResult = value;
    }

}
