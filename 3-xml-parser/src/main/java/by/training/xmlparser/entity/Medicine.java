package by.training.xmlparser.entity;


public class Medicine {

    private String name;
    private String pharm;
    private String analogs;
    private Manufacturer manufacturer;
    private String id;
    private String group;

    public Medicine() {
    }

    public Medicine(String name, String pharm, String analogs, Manufacturer manufacturer, String id, String group) {
        this.name = name;
        this.pharm = pharm;
        this.analogs = analogs;
        this.manufacturer = manufacturer;
        this.id = id;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPharm() {
        return pharm;
    }

    public void setPharm(String pharm) {
        this.pharm = pharm;
    }

    public String getAnalogs() {
        return analogs;
    }

    public void setAnalogs(String analogs) {
        this.analogs = analogs;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medicine medicine = (Medicine) o;

        if (name != null ? !name.equals(medicine.name) : medicine.name != null) return false;
        if (pharm != null ? !pharm.equals(medicine.pharm) : medicine.pharm != null) return false;
        if (analogs != null ? !analogs.equals(medicine.analogs) : medicine.analogs != null) return false;
        if (manufacturer != null ? !manufacturer.equals(medicine.manufacturer) : medicine.manufacturer != null)
            return false;
        if (id != null ? !id.equals(medicine.id) : medicine.id != null) return false;
        return group == medicine.group;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (pharm != null ? pharm.hashCode() : 0);
        result = 31 * result + (analogs != null ? analogs.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "name='" + name + '\'' +
                ", pharm='" + pharm + '\'' +
                ", analogs='" + analogs + '\'' +
                ", manufacturer=" + manufacturer +
                ", id='" + id + '\'' +
                ", group=" + group +
                '}';
    }
}
