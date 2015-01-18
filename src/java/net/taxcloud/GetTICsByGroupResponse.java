
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
 *         &lt;element name="GetTICsByGroupResult" type="{http://taxcloud.net}GetTICsRsp" minOccurs="0"/>
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
    "getTICsByGroupResult"
})
@XmlRootElement(name = "GetTICsByGroupResponse")
public class GetTICsByGroupResponse {

    @XmlElement(name = "GetTICsByGroupResult")
    protected GetTICsRsp getTICsByGroupResult;

    /**
     * Gets the value of the getTICsByGroupResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetTICsRsp }
     *     
     */
    public GetTICsRsp getGetTICsByGroupResult() {
        return getTICsByGroupResult;
    }

    /**
     * Sets the value of the getTICsByGroupResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetTICsRsp }
     *     
     */
    public void setGetTICsByGroupResult(GetTICsRsp value) {
        this.getTICsByGroupResult = value;
    }

}
