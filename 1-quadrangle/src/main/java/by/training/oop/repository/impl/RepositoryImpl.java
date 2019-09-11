package by.training.oop.repository.impl;

import by.training.oop.entity.Quadrangle;
import by.training.oop.repository.Repository;
import by.training.oop.repository.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RepositoryImpl implements Repository {

    List<Quadrangle> quadrs = new ArrayList<>();

    @Override
    public void addQuadrangle(Quadrangle quadrangle) {
        quadrs.add(quadrangle);
    }

    @Override
    public void removeQuadrangle(Quadrangle quadrangle) {
        quadrs.remove(quadrangle);
    }

    @Override
    public List<Quadrangle> sortQuadrangle(Comparator<Quadrangle> comparator) {
        List<Quadrangle> quadrangles = new ArrayList<>(quadrs);
        quadrangles.sort(comparator);
        return  quadrangles;
    }

    @Override
    public List<Quadrangle> query(Specification specification) {
        return quadrs.stream()
                .filter(specification::specified)
                .collect(Collectors.toList());
    }

    @Override
    public Quadrangle getQuadrangle(int index) {
        return quadrs.get(index);
    }

    @Override
    public List<Quadrangle> getAllQuadrangle() {
        return quadrs;
    }
}
