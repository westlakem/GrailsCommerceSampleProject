
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
 *         &lt;element name="LookupResult" type="{http://taxcloud.net}LookupRsp" minOccurs="0"/>
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
    "lookupResult"
})
@XmlRootElement(name = "LookupResponse")
public class LookupResponse {

    @XmlElement(name = "LookupResult")
    protected LookupRsp lookupResult;

    /**
     * Gets the value of the lookupResult property.
     * 
     * @return
     *     possible object is
     *     {@link LookupRsp }
     *     
     */
    public LookupRsp getLookupResult() {
        return lookupResult;
    }

    /**
     * Sets the value of the lookupResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link LookupRsp }
     *     
     */
    public void setLookupResult(LookupRsp value) {
        this.lookupResult = value;
    }

}
