
package net.taxcloud;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfExemptState complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfExemptState">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExemptState" type="{http://taxcloud.net}ExemptState" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfExemptState", propOrder = {
    "exemptState"
})
public class ArrayOfExemptState {

    @XmlElement(name = "ExemptState", nillable = true)
    protected List<ExemptState> exemptState;

    /**
     * Gets the value of the exemptState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exemptState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExemptState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExemptState }
     * 
     * 
     */
    public List<ExemptState> getExemptState() {
        if (exemptState == null) {
            exemptState = new ArrayList<ExemptState>();
        }
        return this.exemptState;
    }

}
