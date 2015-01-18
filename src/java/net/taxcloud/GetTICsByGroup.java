
package net.taxcloud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="apiLoginID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="apiKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ticGroup" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "apiLoginID",
    "apiKey",
    "ticGroup"
})
@XmlRootElement(name = "GetTICsByGroup")
public class GetTICsByGroup {

    protected String apiLoginID;
    protected String apiKey;
    protected int ticGroup;

    /**
     * Gets the value of the apiLoginID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiLoginID() {
        return apiLoginID;
    }

    /**
     * Sets the value of the apiLoginID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiLoginID(String value) {
        this.apiLoginID = value;
    }

    /**
     * Gets the value of the apiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the value of the apiKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiKey(String value) {
        this.apiKey = value;
    }

    /**
     * Gets the value of the ticGroup property.
     * 
     */
    public int getTicGroup() {
        return ticGroup;
    }

    /**
     * Sets the value of the ticGroup property.
     * 
     */
    public void setTicGroup(int value) {
        this.ticGroup = value;
    }

}
