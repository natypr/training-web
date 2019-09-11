package by.training.oop.creation;

import by.training.oop.entity.Point;

public interface BaseShape {

    int getId();
    void setId(int id);
    void initialize(Point[] points);

}
