
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
 *         &lt;element name="ReturnedResult" type="{http://taxcloud.net}ReturnedRsp" minOccurs="0"/>
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
    "returnedResult"
})
@XmlRootElement(name = "ReturnedResponse")
public class ReturnedResponse {

    @XmlElement(name = "ReturnedResult")
    protected ReturnedRsp returnedResult;

    /**
     * Gets the value of the returnedResult property.
     * 
     * @return
     *     possible object is
     *     {@link ReturnedRsp }
     *     
     */
    public ReturnedRsp getReturnedResult() {
        return returnedResult;
    }

    /**
     * Sets the value of the returnedResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnedRsp }
     *     
     */
    public void setReturnedResult(ReturnedRsp value) {
        this.returnedResult = value;
    }

}
