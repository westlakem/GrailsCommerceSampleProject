
package net.taxcloud;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfExemptionCertificate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfExemptionCertificate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExemptionCertificate" type="{http://taxcloud.net}ExemptionCertificate" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfExemptionCertificate", propOrder = {
    "exemptionCertificate"
})
public class ArrayOfExemptionCertificate {

    @XmlElement(name = "ExemptionCertificate", nillable = true)
    protected List<ExemptionCertificate> exemptionCertificate;

    /**
     * Gets the value of the exemptionCertificate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exemptionCertificate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExemptionCertificate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExemptionCertificate }
     * 
     * 
     */
    public List<ExemptionCertificate> getExemptionCertificate() {
        if (exemptionCertificate == null) {
            exemptionCertificate = new ArrayList<ExemptionCertificate>();
        }
        return this.exemptionCertificate;
    }

}
