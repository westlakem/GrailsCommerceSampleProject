
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
 *         &lt;element name="DeleteExemptCertificateResult" type="{http://taxcloud.net}DeleteCertificateRsp" minOccurs="0"/>
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
    "deleteExemptCertificateResult"
})
@XmlRootElement(name = "DeleteExemptCertificateResponse")
public class DeleteExemptCertificateResponse {

    @XmlElement(name = "DeleteExemptCertificateResult")
    protected DeleteCertificateRsp deleteExemptCertificateResult;

    /**
     * Gets the value of the deleteExemptCertificateResult property.
     * 
     * @return
     *     possible object is
     *     {@link DeleteCertificateRsp }
     *     
     */
    public DeleteCertificateRsp getDeleteExemptCertificateResult() {
        return deleteExemptCertificateResult;
    }

    /**
     * Sets the value of the deleteExemptCertificateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeleteCertificateRsp }
     *     
     */
    public void setDeleteExemptCertificateResult(DeleteCertificateRsp value) {
        this.deleteExemptCertificateResult = value;
    }

}
