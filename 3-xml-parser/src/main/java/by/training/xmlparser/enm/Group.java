package by.training.xmlparser.enm;

public enum Group {

    ANTIBIOTIC("antibiotic"),
    SEDATIVE("sedative"),
    VITAMIN("vitamin");

    private String value;

    private Group(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
