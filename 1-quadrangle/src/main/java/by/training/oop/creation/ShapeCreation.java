package by.training.oop.creation;

import by.training.oop.factory.ShapeFactory;
import by.training.oop.validation.ShapeValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ShapeCreation {

    private static Logger log = LogManager.getLogger();

    private static final String SEPARATOR_REGEX = "[ ]";

    public static CorrectShapeList createShapeList(List<String> stringList) {

        CorrectShapeList shapeList = CorrectShapeList.getInstance();

        for (String line : stringList) {
            String[] parameters = line.split(SEPARATOR_REGEX);

            if (ShapeValidation.validate(parameters)) {
                BaseShape shape = ShapeFactory.create(parameters[0]);
                shape.initialize(ShapeValidation.getPoints(parameters));
                log.info("Created figure with Id ", shape.getId());
                shapeList.addShape(shape);
            }
        }
        return shapeList;
    }
}
