package by.training.xmlparser.entity;

public class Packages {

    private int quantityInPackage;
    private int price;

    public Packages() {
    }

    public Packages(int quantityInPackage, int price) {
        this.quantityInPackage = quantityInPackage;
        this.price = price;
    }

    public int getQuantityInPackage() {
        return quantityInPackage;
    }

    public void setQuantityInPackage(int quantityInPackage) {
        this.quantityInPackage = quantityInPackage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Packages packages = (Packages) o;

        if (quantityInPackage != packages.quantityInPackage) return false;
        return price == packages.price;
    }

    @Override
    public int hashCode() {
        int result = quantityInPackage;
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Packages{" +
                "quantityInPackage=" + quantityInPackage +
                ", price=" + price +
                '}';
    }
}
