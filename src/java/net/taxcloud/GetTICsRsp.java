
package net.taxcloud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetTICsRsp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetTICsRsp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://taxcloud.net}ResponseBase">
 *       &lt;sequence>
 *         &lt;element name="TICs" type="{http://taxcloud.net}ArrayOfTIC" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTICsRsp", propOrder = {
    "tiCs"
})
public class GetTICsRsp
    extends ResponseBase
{

    @XmlElement(name = "TICs")
    protected ArrayOfTIC tiCs;

    /**
     * Gets the value of the tiCs property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTIC }
     *     
     */
    public ArrayOfTIC getTICs() {
        return tiCs;
    }

    /**
     * Sets the value of the tiCs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTIC }
     *     
     */
    public void setTICs(ArrayOfTIC value) {
        this.tiCs = value;
    }

}
