
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
 *         &lt;element name="GetTICGroupsResult" type="{http://taxcloud.net}GetTICGroupsRsp" minOccurs="0"/>
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
    "getTICGroupsResult"
})
@XmlRootElement(name = "GetTICGroupsResponse")
public class GetTICGroupsResponse {

    @XmlElement(name = "GetTICGroupsResult")
    protected GetTICGroupsRsp getTICGroupsResult;

    /**
     * Gets the value of the getTICGroupsResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetTICGroupsRsp }
     *     
     */
    public GetTICGroupsRsp getGetTICGroupsResult() {
        return getTICGroupsResult;
    }

    /**
     * Sets the value of the getTICGroupsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetTICGroupsRsp }
     *     
     */
    public void setGetTICGroupsResult(GetTICGroupsRsp value) {
        this.getTICGroupsResult = value;
    }

}
