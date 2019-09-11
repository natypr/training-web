package by.training.oop.entity;

import by.training.oop.action.Calculation;

import java.util.Objects;

public class QuadrangleWarehouse {

    private int id;
    private double square;
    private double perimeter;

    public QuadrangleWarehouse(int id, double square, double perimeter) {
        this.id = id;
        this.square = square;
        this.perimeter = perimeter;
    }

    public QuadrangleWarehouse(Quadrangle quadrangle){
        this.id = quadrangle.getId();
        this.square = Calculation.areaShape(quadrangle);
        this.perimeter = Calculation.perimeterShape(quadrangle);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuadrangleWarehouse that = (QuadrangleWarehouse) o;
        return id == that.id &&
                Double.compare(that.square, square) == 0 &&
                Double.compare(that.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, square, perimeter);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuadrangleWarehouse{");
        sb.append("id=").append(id);
        sb.append(", square=").append(square);
        sb.append(", perimeter=").append(perimeter);
        sb.append('}');
        return sb.toString();
    }
}
