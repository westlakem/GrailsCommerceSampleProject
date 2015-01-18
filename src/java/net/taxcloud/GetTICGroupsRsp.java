
package net.taxcloud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetTICGroupsRsp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetTICGroupsRsp">
 *   &lt;complexContent>
 *     &lt;extension base="{http://taxcloud.net}ResponseBase">
 *       &lt;sequence>
 *         &lt;element name="TICGroups" type="{http://taxcloud.net}ArrayOfTICGroup" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetTICGroupsRsp", propOrder = {
    "ticGroups"
})
public class GetTICGroupsRsp
    extends ResponseBase
{

    @XmlElement(name = "TICGroups")
    protected ArrayOfTICGroup ticGroups;

    /**
     * Gets the value of the ticGroups property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTICGroup }
     *     
     */
    public ArrayOfTICGroup getTICGroups() {
        return ticGroups;
    }

    /**
     * Sets the value of the ticGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTICGroup }
     *     
     */
    public void setTICGroups(ArrayOfTICGroup value) {
        this.ticGroups = value;
    }

}
