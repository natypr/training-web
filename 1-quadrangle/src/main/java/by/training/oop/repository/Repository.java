package by.training.oop.repository;

import by.training.oop.entity.Quadrangle;

import java.util.Comparator;
import java.util.List;

public interface Repository {

    void addQuadrangle(Quadrangle quadrangle);
    void removeQuadrangle(Quadrangle quadrangle);

    List<Quadrangle> sortQuadrangle(Comparator<Quadrangle> comparator);
    List<Quadrangle> query(Specification specification);

    Quadrangle getQuadrangle(int index);

    List<Quadrangle> getAllQuadrangle();

}
