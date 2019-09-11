package by.training.oop.entity;

import by.training.oop.creation.BaseShape;
import by.training.oop.observer.Observable;
import by.training.oop.observer.Observer;

import java.util.Objects;

public class Quadrangle implements BaseShape, Observable {

    private Observer observer;
    private Point p1, p2, p3, p4;
    private int id;

    @Override
    public void initialize(Point[] points) {
        p1 = points[0];
        p2 = points[1];
        p3 = points[2];
        p4 = points[3];
    }

    public Quadrangle() {
    }

    public Quadrangle(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getP3() {
        return p3;
    }

    public Point getP4() {
        return p4;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
        notifyObserver();
    }

    public void setP2(Point p2) {
        this.p2 = p2;
        notifyObserver();
    }

    public void setP3(Point p3) {
        this.p3 = p3;
        notifyObserver();
    }

    public void setP4(Point p4) {
        this.p4 = p4;
        notifyObserver();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quadrangle that = (Quadrangle) o;
        return Objects.equals(p1, that.p1) &&
                Objects.equals(p2, that.p2) &&
                Objects.equals(p3, that.p3) &&
                Objects.equals(p4, that.p4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2, p3, p4);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Quadrangle{");
        sb.append("p1=").append(p1);
        sb.append(", p2=").append(p2);
        sb.append(", p3=").append(p3);
        sb.append(", p4=").append(p4);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void notifyObserver() {
        observer.update(this);
    }
}
