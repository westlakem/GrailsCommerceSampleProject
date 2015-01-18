
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
 *         &lt;element name="GetExemptCertificatesResult" type="{http://taxcloud.net}GetCertificatesRsp" minOccurs="0"/>
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
    "getExemptCertificatesResult"
})
@XmlRootElement(name = "GetExemptCertificatesResponse")
public class GetExemptCertificatesResponse {

    @XmlElement(name = "GetExemptCertificatesResult")
    protected GetCertificatesRsp getExemptCertificatesResult;

    /**
     * Gets the value of the getExemptCertificatesResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetCertificatesRsp }
     *     
     */
    public GetCertificatesRsp getGetExemptCertificatesResult() {
        return getExemptCertificatesResult;
    }

    /**
     * Sets the value of the getExemptCertificatesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCertificatesRsp }
     *     
     */
    public void setGetExemptCertificatesResult(GetCertificatesRsp value) {
        this.getExemptCertificatesResult = value;
    }

}
