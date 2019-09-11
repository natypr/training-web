package by.training.oop.creation;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class ShapeCreationTest {

    @Test
    public void testCreateShapeList() {
        List<String> str = new ArrayList<String>(2){{
            add("Quadrangle 2.0 1.0 3.0 6.0 5.0 5.0 7.0 3.0");
            add("Quadrangle 2.0 1.0 3.0 6.0 5.0 5.0 7.0 3.0");
        }};
        CorrectShapeList shapeList = ShapeCreation.createShapeList(str);
        assertEquals(2, shapeList.getCount());
    }
}