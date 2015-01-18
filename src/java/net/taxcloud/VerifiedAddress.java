
package net.taxcloud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VerifiedAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VerifiedAddress">
 *   &lt;complexContent>
 *     &lt;extension base="{http://taxcloud.net}Address">
 *       &lt;sequence>
 *         &lt;element name="ErrNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerifiedAddress", propOrder = {
    "errNumber",
    "errDescription"
})
public class VerifiedAddress
    extends Address
{

    @XmlElement(name = "ErrNumber")
    protected String errNumber;
    @XmlElement(name = "ErrDescription")
    protected String errDescription;

    /**
     * Gets the value of the errNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrNumber() {
        return errNumber;
    }

    /**
     * Sets the value of the errNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrNumber(String value) {
        this.errNumber = value;
    }

    /**
     * Gets the value of the errDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrDescription() {
        return errDescription;
    }

    /**
     * Sets the value of the errDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrDescription(String value) {
        this.errDescription = value;
    }

}
