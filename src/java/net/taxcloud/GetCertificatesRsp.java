
package net.taxcloud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetCertificatesRsp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCertificatesRsp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://taxcloud.net}ResponseBase">
 *       &lt;sequence>
 *         &lt;element name="ExemptCertificates" type="{http://taxcloud.net}ArrayOfExemptionCertificate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCertificatesRsp", propOrder = {
    "exemptCertificates"
})
public class GetCertificatesRsp
    extends ResponseBase
{

    @XmlElement(name = "ExemptCertificates")
    protected ArrayOfExemptionCertificate exemptCertificates;

    /**
     * Gets the value of the exemptCertificates property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfExemptionCertificate }
     *     
     */
    public ArrayOfExemptionCertificate getExemptCertificates() {
        return exemptCertificates;
    }

    /**
     * Sets the value of the exemptCertificates property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfExemptionCertificate }
     *     
     */
    public void setExemptCertificates(ArrayOfExemptionCertificate value) {
        this.exemptCertificates = value;
    }

}
