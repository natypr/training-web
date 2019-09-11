package by.training.oop.validation;

import by.training.oop.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ShapeValidation {

    private static Logger log = LogManager.getLogger();

    private static Map<String, Integer> shapeProperties = new HashMap<>();

    static {
        shapeProperties.put("Quadrangle", 8);
    }

    public static boolean validate(String[] shapeParameters) {
        if (shapeParameters == null || shapeParameters.length == 0) {
            return false;
        }
        String shapeName = shapeParameters[0];
        Integer parametersCount = shapeProperties.get(shapeName);
        if (parametersCount == null || parametersCount + 1 != shapeParameters.length) {
            return false;
        }
        for (int i = 1; i < shapeParameters.length; i++) {
            try {
                Double.parseDouble(shapeParameters[i]);
            } catch (NumberFormatException e) {
                log.error(e);
                return false;
            }
        }
        return true;
    }

    public static Point[] getPoints(String[] parameters) {
        Integer parametersCount = shapeProperties.get(parameters[0]);
        int pointCount = parametersCount / 2;

        Point[] points = new Point[pointCount];
        for (int i = 0; i < pointCount; i++) {
            try {
                points[i] = new Point(
                        Double.parseDouble(parameters[i*2+1]),
                        Double.parseDouble(parameters[i*2+2]));
            } catch (NumberFormatException e) {
                log.error(e);
            }
        }
        return points;
    }
}