package by.training.oop.factory;


import by.training.oop.creation.BaseShape;
import by.training.oop.entity.Quadrangle;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ShapeFactory {

    private static int idFactory = 0;
    private static Map<String, Supplier<BaseShape>> shapesMap = new HashMap<>();

    static {
        shapesMap.put("Quadrangle", Quadrangle::new);
    }

    public static BaseShape create(String shapeId) {
         BaseShape shape = shapesMap.get(shapeId).get();
         shape.setId(++idFactory);
         return shape;
    }
}
