
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
 *         &lt;element name="GetTICsResult" type="{http://taxcloud.net}GetTICsRsp" minOccurs="0"/>
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
    "getTICsResult"
})
@XmlRootElement(name = "GetTICsResponse")
public class GetTICsResponse {

    @XmlElement(name = "GetTICsResult")
    protected GetTICsRsp getTICsResult;

    /**
     * Gets the value of the getTICsResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetTICsRsp }
     *     
     */
    public GetTICsRsp getGetTICsResult() {
        return getTICsResult;
    }

    /**
     * Sets the value of the getTICsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetTICsRsp }
     *     
     */
    public void setGetTICsResult(GetTICsRsp value) {
        this.getTICsResult = value;
    }

}
