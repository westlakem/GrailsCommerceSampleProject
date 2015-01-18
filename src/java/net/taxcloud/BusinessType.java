
package net.taxcloud;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BusinessType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BusinessType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AccommodationAndFoodServices"/>
 *     &lt;enumeration value="Agricultural_Forestry_Fishing_Hunting"/>
 *     &lt;enumeration value="Construction"/>
 *     &lt;enumeration value="FinanceAndInsurance"/>
 *     &lt;enumeration value="Information_PublishingAndCommunications"/>
 *     &lt;enumeration value="Manufacturing"/>
 *     &lt;enumeration value="Mining"/>
 *     &lt;enumeration value="RealEstate"/>
 *     &lt;enumeration value="RentalAndLeasing"/>
 *     &lt;enumeration value="RetailTrade"/>
 *     &lt;enumeration value="TransportationAndWarehousing"/>
 *     &lt;enumeration value="Utilities"/>
 *     &lt;enumeration value="WholesaleTrade"/>
 *     &lt;enumeration value="BusinessServices"/>
 *     &lt;enumeration value="ProfessionalServices"/>
 *     &lt;enumeration value="EducationAndHealthCareServices"/>
 *     &lt;enumeration value="NonprofitOrganization"/>
 *     &lt;enumeration value="Government"/>
 *     &lt;enumeration value="NotABusiness"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BusinessType")
@XmlEnum
public enum BusinessType {

    @XmlEnumValue("AccommodationAndFoodServices")
    ACCOMMODATION_AND_FOOD_SERVICES("AccommodationAndFoodServices"),
    @XmlEnumValue("Agricultural_Forestry_Fishing_Hunting")
    AGRICULTURAL_FORESTRY_FISHING_HUNTING("Agricultural_Forestry_Fishing_Hunting"),
    @XmlEnumValue("Construction")
    CONSTRUCTION("Construction"),
    @XmlEnumValue("FinanceAndInsurance")
    FINANCE_AND_INSURANCE("FinanceAndInsurance"),
    @XmlEnumValue("Information_PublishingAndCommunications")
    INFORMATION_PUBLISHING_AND_COMMUNICATIONS("Information_PublishingAndCommunications"),
    @XmlEnumValue("Manufacturing")
    MANUFACTURING("Manufacturing"),
    @XmlEnumValue("Mining")
    MINING("Mining"),
    @XmlEnumValue("RealEstate")
    REAL_ESTATE("RealEstate"),
    @XmlEnumValue("RentalAndLeasing")
    RENTAL_AND_LEASING("RentalAndLeasing"),
    @XmlEnumValue("RetailTrade")
    RETAIL_TRADE("RetailTrade"),
    @XmlEnumValue("TransportationAndWarehousing")
    TRANSPORTATION_AND_WAREHOUSING("TransportationAndWarehousing"),
    @XmlEnumValue("Utilities")
    UTILITIES("Utilities"),
    @XmlEnumValue("WholesaleTrade")
    WHOLESALE_TRADE("WholesaleTrade"),
    @XmlEnumValue("BusinessServices")
    BUSINESS_SERVICES("BusinessServices"),
    @XmlEnumValue("ProfessionalServices")
    PROFESSIONAL_SERVICES("ProfessionalServices"),
    @XmlEnumValue("EducationAndHealthCareServices")
    EDUCATION_AND_HEALTH_CARE_SERVICES("EducationAndHealthCareServices"),
    @XmlEnumValue("NonprofitOrganization")
    NONPROFIT_ORGANIZATION("NonprofitOrganization"),
    @XmlEnumValue("Government")
    GOVERNMENT("Government"),
    @XmlEnumValue("NotABusiness")
    NOT_A_BUSINESS("NotABusiness"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    BusinessType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BusinessType fromValue(String v) {
        for (BusinessType c: BusinessType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
