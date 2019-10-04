package by.training.xmlparser.entity;

public class Manufacturer {
    private Certificate certificate;
    private Packages packages;
    private Dosage dosage;
    private String versionn;


    public Manufacturer() {
    }

    public Manufacturer(Certificate certificate, Packages packages, Dosage dosage, String versionn) {
        this.certificate = certificate;
        this.packages = packages;
        this.dosage = dosage;
        this.versionn = versionn;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Packages getPackages() {
        return packages;
    }

    public void setPackages(Packages packages) {
        this.packages = packages;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    public String getVersionn() {
        return versionn;
    }

    public void setVersionn(String versionn) {
        this.versionn = versionn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manufacturer that = (Manufacturer) o;

        if (certificate != null ? !certificate.equals(that.certificate) : that.certificate != null) return false;
        if (packages != null ? !packages.equals(that.packages) : that.packages != null) return false;
        if (dosage != null ? !dosage.equals(that.dosage) : that.dosage != null) return false;
        return versionn == that.versionn;
    }

    @Override
    public int hashCode() {
        int result = certificate != null ? certificate.hashCode() : 0;
        result = 31 * result + (packages != null ? packages.hashCode() : 0);
        result = 31 * result + (dosage != null ? dosage.hashCode() : 0);
        result = 31 * result + (versionn != null ? versionn.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "certificate=" + certificate +
                ", packages=" + packages +
                ", dosage=" + dosage +
                ", version=" + versionn +
                '}';
    }
}
