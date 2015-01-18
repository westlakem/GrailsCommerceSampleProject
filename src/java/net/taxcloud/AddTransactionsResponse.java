
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
 *         &lt;element name="AddTransactionsResult" type="{http://taxcloud.net}AddTransactionsRsp" minOccurs="0"/>
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
    "addTransactionsResult"
})
@XmlRootElement(name = "AddTransactionsResponse")
public class AddTransactionsResponse {

    @XmlElement(name = "AddTransactionsResult")
    protected AddTransactionsRsp addTransactionsResult;

    /**
     * Gets the value of the addTransactionsResult property.
     * 
     * @return
     *     possible object is
     *     {@link AddTransactionsRsp }
     *     
     */
    public AddTransactionsRsp getAddTransactionsResult() {
        return addTransactionsResult;
    }

    /**
     * Sets the value of the addTransactionsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddTransactionsRsp }
     *     
     */
    public void setAddTransactionsResult(AddTransactionsRsp value) {
        this.addTransactionsResult = value;
    }

}
