
package net.taxcloud;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaxIDType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaxIDType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SSN"/>
 *     &lt;enumeration value="FEIN"/>
 *     &lt;enumeration value="StateIssued"/>
 *     &lt;enumeration value="ForeignDiplomat"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaxIDType")
@XmlEnum
public enum TaxIDType {

    SSN("SSN"),
    FEIN("FEIN"),
    @XmlEnumValue("StateIssued")
    STATE_ISSUED("StateIssued"),
    @XmlEnumValue("ForeignDiplomat")
    FOREIGN_DIPLOMAT("ForeignDiplomat");
    private final String value;

    TaxIDType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TaxIDType fromValue(String v) {
        for (TaxIDType c: TaxIDType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
