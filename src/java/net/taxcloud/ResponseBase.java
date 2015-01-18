
package net.taxcloud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseBase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResponseType" type="{http://taxcloud.net}MessageType"/>
 *         &lt;element name="Messages" type="{http://taxcloud.net}ArrayOfResponseMessage" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseBase", propOrder = {
    "responseType",
    "messages"
})
@XmlSeeAlso({
    PingRsp.class,
    ReturnedRsp.class,
    DeleteCertificateRsp.class,
    GetTICGroupsRsp.class,
    AddCertificateRsp.class,
    AuthorizedRsp.class,
    AddTransactionsRsp.class,
    CapturedRsp.class,
    GetTICsRsp.class,
    GetCertificatesRsp.class,
    LookupRsp.class
})
public class ResponseBase {

    @XmlElement(name = "ResponseType", required = true)
    protected MessageType responseType;
    @XmlElement(name = "Messages")
    protected ArrayOfResponseMessage messages;

    /**
     * Gets the value of the responseType property.
     * 
     * @return
     *     possible object is
     *     {@link MessageType }
     *     
     */
    public MessageType getResponseType() {
        return responseType;
    }

    /**
     * Sets the value of the responseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageType }
     *     
     */
    public void setResponseType(MessageType value) {
        this.responseType = value;
    }

    /**
     * Gets the value of the messages property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfResponseMessage }
     *     
     */
    public ArrayOfResponseMessage getMessages() {
        return messages;
    }

    /**
     * Sets the value of the messages property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfResponseMessage }
     *     
     */
    public void setMessages(ArrayOfResponseMessage value) {
        this.messages = value;
    }

}
