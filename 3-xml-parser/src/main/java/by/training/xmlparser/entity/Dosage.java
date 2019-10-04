package by.training.xmlparser.entity;

public class Dosage {
    private int quantityPerDay;
    private int periodOfUseDay;

    public Dosage() {
    }

    public Dosage(int quantityPerDay, int periodOfUseDay) {
        this.quantityPerDay = quantityPerDay;
        this.periodOfUseDay = periodOfUseDay;
    }

    public int getQuantityPerDay() {
        return quantityPerDay;
    }

    public void setQuantityPerDay(int quantityPerDay) {
        this.quantityPerDay = quantityPerDay;
    }

    public int getPeriodOfUseDay() {
        return periodOfUseDay;
    }

    public void setPeriodOfUseDay(int periodOfUseDay) {
        this.periodOfUseDay = periodOfUseDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dosage dosage = (Dosage) o;

        if (quantityPerDay != dosage.quantityPerDay) return false;
        return periodOfUseDay == dosage.periodOfUseDay;
    }

    @Override
    public int hashCode() {
        int result = quantityPerDay;
        result = 31 * result + periodOfUseDay;
        return result;
    }

    @Override
    public String toString() {
        return "Dosage{" +
                "quantityPerDay=" + quantityPerDay +
                ", periodOfUseDay=" + periodOfUseDay +
                '}';
    }
}
