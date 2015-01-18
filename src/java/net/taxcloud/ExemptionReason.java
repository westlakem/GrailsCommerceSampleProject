
package net.taxcloud;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExemptionReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExemptionReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FederalGovernmentDepartment"/>
 *     &lt;enumeration value="StateOrLocalGovernmentName"/>
 *     &lt;enumeration value="TribalGovernmentName"/>
 *     &lt;enumeration value="ForeignDiplomat"/>
 *     &lt;enumeration value="CharitableOrganization"/>
 *     &lt;enumeration value="ReligiousOrEducationalOrganization"/>
 *     &lt;enumeration value="Resale"/>
 *     &lt;enumeration value="AgriculturalProduction"/>
 *     &lt;enumeration value="IndustrialProductionOrManufacturing"/>
 *     &lt;enumeration value="DirectPayPermit"/>
 *     &lt;enumeration value="DirectMail"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExemptionReason")
@XmlEnum
public enum ExemptionReason {

    @XmlEnumValue("FederalGovernmentDepartment")
    FEDERAL_GOVERNMENT_DEPARTMENT("FederalGovernmentDepartment"),
    @XmlEnumValue("StateOrLocalGovernmentName")
    STATE_OR_LOCAL_GOVERNMENT_NAME("StateOrLocalGovernmentName"),
    @XmlEnumValue("TribalGovernmentName")
    TRIBAL_GOVERNMENT_NAME("TribalGovernmentName"),
    @XmlEnumValue("ForeignDiplomat")
    FOREIGN_DIPLOMAT("ForeignDiplomat"),
    @XmlEnumValue("CharitableOrganization")
    CHARITABLE_ORGANIZATION("CharitableOrganization"),
    @XmlEnumValue("ReligiousOrEducationalOrganization")
    RELIGIOUS_OR_EDUCATIONAL_ORGANIZATION("ReligiousOrEducationalOrganization"),
    @XmlEnumValue("Resale")
    RESALE("Resale"),
    @XmlEnumValue("AgriculturalProduction")
    AGRICULTURAL_PRODUCTION("AgriculturalProduction"),
    @XmlEnumValue("IndustrialProductionOrManufacturing")
    INDUSTRIAL_PRODUCTION_OR_MANUFACTURING("IndustrialProductionOrManufacturing"),
    @XmlEnumValue("DirectPayPermit")
    DIRECT_PAY_PERMIT("DirectPayPermit"),
    @XmlEnumValue("DirectMail")
    DIRECT_MAIL("DirectMail"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    ExemptionReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExemptionReason fromValue(String v) {
        for (ExemptionReason c: ExemptionReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
