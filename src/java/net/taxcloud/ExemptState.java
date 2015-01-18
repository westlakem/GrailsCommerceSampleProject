
package net.taxcloud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExemptState complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExemptState">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StateAbbr" type="{http://taxcloud.net}State"/>
 *         &lt;element name="ReasonForExemption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdentificationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExemptState", propOrder = {
    "stateAbbr",
    "reasonForExemption",
    "identificationNumber"
})
public class ExemptState {

    @XmlElement(name = "StateAbbr", required = true)
    protected State stateAbbr;
    @XmlElement(name = "ReasonForExemption")
    protected String reasonForExemption;
    @XmlElement(name = "IdentificationNumber")
    protected String identificationNumber;

    /**
     * Gets the value of the stateAbbr property.
     * 
     * @return
     *     possible object is
     *     {@link State }
     *     
     */
    public State getStateAbbr() {
        return stateAbbr;
    }

    /**
     * Sets the value of the stateAbbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link State }
     *     
     */
    public void setStateAbbr(State value) {
        this.stateAbbr = value;
    }

    /**
     * Gets the value of the reasonForExemption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonForExemption() {
        return reasonForExemption;
    }

    /**
     * Sets the value of the reasonForExemption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonForExemption(String value) {
        this.reasonForExemption = value;
    }

    /**
     * Gets the value of the identificationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Sets the value of the identificationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificationNumber(String value) {
        this.identificationNumber = value;
    }

}
