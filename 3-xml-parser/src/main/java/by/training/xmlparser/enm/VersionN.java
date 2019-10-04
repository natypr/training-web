package by.training.xmlparser.enm;

public enum VersionN {

    TABLETS("tablets"),
    DROPS("drops");

    private String value;

    private VersionN(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
