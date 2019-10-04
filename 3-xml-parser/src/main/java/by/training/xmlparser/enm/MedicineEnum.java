package by.training.xmlparser.enm;

public enum MedicineEnum {

    MEDICINES("medicines"),
    ID("id"),
    GROUP("group"),
    MEDICINE("medicine"),
    NAME("name"),
    PHARM("pharm"),
    ANALOGS("analogs"),
    MANUFACTURER("manufacturer"),
    VERSIONN("versionn"),
    CERTIFICATE("certificate"),
    NUMBER("number"),
    ISSUE_DATE("issue-date"),
    EXPIRATION_DATE("expiration-date"),
    REG_ORGANISATION("reg-organisation"),
    PACKAGES("packages"),
    QUANTITY_IN_PACK("quantity-in-pack"),
    PRICE("price"),
    DOSAGE("dosage"),
    QUANTITY_PER_DAY("quantity-per-day"),
    PERIOD_OF_USE_DAY("period-of-use-day");

    private String value;

    private MedicineEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
