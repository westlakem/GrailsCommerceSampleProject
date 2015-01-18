
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
 *         &lt;element name="LookupForDateResult" type="{http://taxcloud.net}LookupRsp" minOccurs="0"/>
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
    "lookupForDateResult"
})
@XmlRootElement(name = "LookupForDateResponse")
public class LookupForDateResponse {

    @XmlElement(name = "LookupForDateResult")
    protected LookupRsp lookupForDateResult;

    /**
     * Gets the value of the lookupForDateResult property.
     * 
     * @return
     *     possible object is
     *     {@link LookupRsp }
     *     
     */
    public LookupRsp getLookupForDateResult() {
        return lookupForDateResult;
    }

    /**
     * Sets the value of the lookupForDateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link LookupRsp }
     *     
     */
    public void setLookupForDateResult(LookupRsp value) {
        this.lookupForDateResult = value;
    }

}
