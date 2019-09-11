package by.training.oop.repository;

import by.training.oop.entity.Quadrangle;

import java.util.Comparator;

public class QuadrangleComparator {

    public final static Comparator<Quadrangle> ID_COMPARATOR = Comparator.comparing(Quadrangle::getId);

    public final static Comparator<Quadrangle> FIRST_X_COMPARATOR = Comparator.comparing(t -> t.getP1().getX());

    public final static Comparator<Quadrangle> FIRST_Y_COMPARATOR = Comparator.comparing(t -> t.getP1().getY());

}
