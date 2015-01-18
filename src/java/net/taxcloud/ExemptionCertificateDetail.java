
package net.taxcloud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ExemptionCertificateDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExemptionCertificateDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ExemptStates" type="{http://taxcloud.net}ArrayOfExemptState" minOccurs="0"/>
 *         &lt;element name="SinglePurchase" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SinglePurchaseOrderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PurchaserFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PurchaserLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PurchaserTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PurchaserAddress1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PurchaserAddress2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PurchaserCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PurchaserState" type="{http://taxcloud.net}State"/>
 *         &lt;element name="PurchaserZip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PurchaserTaxID" type="{http://taxcloud.net}TaxID" minOccurs="0"/>
 *         &lt;element name="PurchaserBusinessType" type="{http://taxcloud.net}BusinessType"/>
 *         &lt;element name="PurchaserBusinessTypeOtherValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PurchaserExemptionReason" type="{http://taxcloud.net}ExemptionReason"/>
 *         &lt;element name="PurchaserExemptionReasonValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreatedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExemptionCertificateDetail", propOrder = {
    "exemptStates",
    "singlePurchase",
    "singlePurchaseOrderNumber",
    "purchaserFirstName",
    "purchaserLastName",
    "purchaserTitle",
    "purchaserAddress1",
    "purchaserAddress2",
    "purchaserCity",
    "purchaserState",
    "purchaserZip",
    "purchaserTaxID",
    "purchaserBusinessType",
    "purchaserBusinessTypeOtherValue",
    "purchaserExemptionReason",
    "purchaserExemptionReasonValue",
    "createdDate"
})
public class ExemptionCertificateDetail {

    @XmlElement(name = "ExemptStates")
    protected ArrayOfExemptState exemptStates;
    @XmlElement(name = "SinglePurchase")
    protected boolean singlePurchase;
    @XmlElement(name = "SinglePurchaseOrderNumber")
    protected String singlePurchaseOrderNumber;
    @XmlElement(name = "PurchaserFirstName")
    protected String purchaserFirstName;
    @XmlElement(name = "PurchaserLastName")
    protected String purchaserLastName;
    @XmlElement(name = "PurchaserTitle")
    protected String purchaserTitle;
    @XmlElement(name = "PurchaserAddress1")
    protected String purchaserAddress1;
    @XmlElement(name = "PurchaserAddress2")
    protected String purchaserAddress2;
    @XmlElement(name = "PurchaserCity")
    protected String purchaserCity;
    @XmlElement(name = "PurchaserState", required = true)
    protected State purchaserState;
    @XmlElement(name = "PurchaserZip")
    protected String purchaserZip;
    @XmlElement(name = "PurchaserTaxID")
    protected TaxID purchaserTaxID;
    @XmlElement(name = "PurchaserBusinessType", required = true)
    protected BusinessType purchaserBusinessType;
    @XmlElement(name = "PurchaserBusinessTypeOtherValue")
    protected String purchaserBusinessTypeOtherValue;
    @XmlElement(name = "PurchaserExemptionReason", required = true)
    protected ExemptionReason purchaserExemptionReason;
    @XmlElement(name = "PurchaserExemptionReasonValue")
    protected String purchaserExemptionReasonValue;
    @XmlElement(name = "CreatedDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;

    /**
     * Gets the value of the exemptStates property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfExemptState }
     *     
     */
    public ArrayOfExemptState getExemptStates() {
        return exemptStates;
    }

    /**
     * Sets the value of the exemptStates property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfExemptState }
     *     
     */
    public void setExemptStates(ArrayOfExemptState value) {
        this.exemptStates = value;
    }

    /**
     * Gets the value of the singlePurchase property.
     * 
     */
    public boolean isSinglePurchase() {
        return singlePurchase;
    }

    /**
     * Sets the value of the singlePurchase property.
     * 
     */
    public void setSinglePurchase(boolean value) {
        this.singlePurchase = value;
    }

    /**
     * Gets the value of the singlePurchaseOrderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSinglePurchaseOrderNumber() {
        return singlePurchaseOrderNumber;
    }

    /**
     * Sets the value of the singlePurchaseOrderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSinglePurchaseOrderNumber(String value) {
        this.singlePurchaseOrderNumber = value;
    }

    /**
     * Gets the value of the purchaserFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaserFirstName() {
        return purchaserFirstName;
    }

    /**
     * Sets the value of the purchaserFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaserFirstName(String value) {
        this.purchaserFirstName = value;
    }

    /**
     * Gets the value of the purchaserLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaserLastName() {
        return purchaserLastName;
    }

    /**
     * Sets the value of the purchaserLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaserLastName(String value) {
        this.purchaserLastName = value;
    }

    /**
     * Gets the value of the purchaserTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaserTitle() {
        return purchaserTitle;
    }

    /**
     * Sets the value of the purchaserTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaserTitle(String value) {
        this.purchaserTitle = value;
    }

    /**
     * Gets the value of the purchaserAddress1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaserAddress1() {
        return purchaserAddress1;
    }

    /**
     * Sets the value of the purchaserAddress1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaserAddress1(String value) {
        this.purchaserAddress1 = value;
    }

    /**
     * Gets the value of the purchaserAddress2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaserAddress2() {
        return purchaserAddress2;
    }

    /**
     * Sets the value of the purchaserAddress2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaserAddress2(String value) {
        this.purchaserAddress2 = value;
    }

    /**
     * Gets the value of the purchaserCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaserCity() {
        return purchaserCity;
    }

    /**
     * Sets the value of the purchaserCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaserCity(String value) {
        this.purchaserCity = value;
    }

    /**
     * Gets the value of the purchaserState property.
     * 
     * @return
     *     possible object is
     *     {@link State }
     *     
     */
    public State getPurchaserState() {
        return purchaserState;
    }

    /**
     * Sets the value of the purchaserState property.
     * 
     * @param value
     *     allowed object is
     *     {@link State }
     *     
     */
    public void setPurchaserState(State value) {
        this.purchaserState = value;
    }

    /**
     * Gets the value of the purchaserZip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaserZip() {
        return purchaserZip;
    }

    /**
     * Sets the value of the purchaserZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaserZip(String value) {
        this.purchaserZip = value;
    }

    /**
     * Gets the value of the purchaserTaxID property.
     * 
     * @return
     *     possible object is
     *     {@link TaxID }
     *     
     */
    public TaxID getPurchaserTaxID() {
        return purchaserTaxID;
    }

    /**
     * Sets the value of the purchaserTaxID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaxID }
     *     
     */
    public void setPurchaserTaxID(TaxID value) {
        this.purchaserTaxID = value;
    }

    /**
     * Gets the value of the purchaserBusinessType property.
     * 
     * @return
     *     possible object is
     *     {@link BusinessType }
     *     
     */
    public BusinessType getPurchaserBusinessType() {
        return purchaserBusinessType;
    }

    /**
     * Sets the value of the purchaserBusinessType property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessType }
     *     
     */
    public void setPurchaserBusinessType(BusinessType value) {
        this.purchaserBusinessType = value;
    }

    /**
     * Gets the value of the purchaserBusinessTypeOtherValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaserBusinessTypeOtherValue() {
        return purchaserBusinessTypeOtherValue;
    }

    /**
     * Sets the value of the purchaserBusinessTypeOtherValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaserBusinessTypeOtherValue(String value) {
        this.purchaserBusinessTypeOtherValue = value;
    }

    /**
     * Gets the value of the purchaserExemptionReason property.
     * 
     * @return
     *     possible object is
     *     {@link ExemptionReason }
     *     
     */
    public ExemptionReason getPurchaserExemptionReason() {
        return purchaserExemptionReason;
    }

    /**
     * Sets the value of the purchaserExemptionReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExemptionReason }
     *     
     */
    public void setPurchaserExemptionReason(ExemptionReason value) {
        this.purchaserExemptionReason = value;
    }

    /**
     * Gets the value of the purchaserExemptionReasonValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaserExemptionReasonValue() {
        return purchaserExemptionReasonValue;
    }

    /**
     * Sets the value of the purchaserExemptionReasonValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaserExemptionReasonValue(String value) {
        this.purchaserExemptionReasonValue = value;
    }

    /**
     * Gets the value of the createdDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDate(XMLGregorianCalendar value) {
        this.createdDate = value;
    }

}
