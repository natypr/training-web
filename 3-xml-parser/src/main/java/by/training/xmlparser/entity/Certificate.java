package by.training.xmlparser.entity;

public class Certificate {

    private int number;
    private String issueDate;
    private String expirationDate;
    private String regOrganization;

    public Certificate() {
    }

    public Certificate(int number, String issueDate, String expirationDate, String regOrganization) {
        this.number = number;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
        this.regOrganization = regOrganization;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getRegOrganization() {
        return regOrganization;
    }

    public void setRegOrganization(String regOrganization) {
        this.regOrganization = regOrganization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Certificate that = (Certificate) o;

        if (number != that.number) return false;
        if (issueDate != null ? !issueDate.equals(that.issueDate) : that.issueDate != null) return false;
        if (expirationDate != null ? !expirationDate.equals(that.expirationDate) : that.expirationDate != null)
            return false;
        return regOrganization != null ? regOrganization.equals(that.regOrganization) : that.regOrganization == null;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (issueDate != null ? issueDate.hashCode() : 0);
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        result = 31 * result + (regOrganization != null ? regOrganization.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "number='" + number + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", regOrganization='" + regOrganization + '\'' +
                '}';
    }
}
