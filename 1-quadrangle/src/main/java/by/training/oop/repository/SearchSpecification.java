package by.training.oop.repository;

import by.training.oop.action.Calculation;

public class SearchSpecification {

    private long minId;
    private long maxId;
    private double minSquare;
    private double minPerimeter;


    public final Specification MORE_THEN_MIN_ID = t -> t.getId() >= minId;

    public final Specification LESS_THEN_MAX_ID = t -> t.getId() <= maxId;

    public final Specification MORE_THEN_MIN_SQUARE = t -> Calculation.areaShape(t) >= minSquare;

    public final Specification MORE_THEN_MIN_PERIMETER = t -> Calculation.perimeterShape(t) >= minPerimeter;

    public final Specification IN_THE_FIRST_QUADRANT = t -> {
        return
                t.getP1().getX() >= 0 &&
                t.getP1().getY() >= 0 &&

                t.getP2().getX() >= 0 &&
                t.getP2().getY() >= 0 &&

                t.getP3().getX() >= 0 &&
                t.getP3().getY() >= 0 &&

                t.getP4().getX() >= 0 &&
                t.getP4().getY() >= 0;
    };

    public void setMinId(long minId) {
        this.minId = minId;
    }

    public void setMaxId(long maxId) {
        this.maxId = maxId;
    }

    public void setMinSquare(double minSquare) {
        this.minSquare = minSquare;
    }

    public void setMinPerimeter(double minPerimeter) {
        this.minPerimeter = minPerimeter;
    }
}
