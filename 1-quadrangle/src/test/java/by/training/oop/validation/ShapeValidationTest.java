package by.training.oop.validation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ShapeValidationTest {

    @DataProvider(name = "dataForParameters")
    public Object[][] dataForParameters() {
        return new Object[][]{
                {"Quadrangle", "2.0", "3.0", "3.0", "6.0", "5.0", "5.0", "7.0", "5.0", true},
                {"Quadrangle", "2.0", "3.dsd0", "3.0", "6.0", "5.0", "50ff", "7.0", "5.0", false},
                {"Qungle", "2.0", "3.0", "3.0", "6.0", "5.0", "5.0", "7.0", "5.0", false},
                {"Quadrangle", "2.0", "3.0", "3.0", "6.0", "5.0", "5.0", "7.0", "5.0", true}
        };
    }


    @Parameters({"name", "x1", "y1", "x2", "y2", "x3", "y3", "x4", "y4", "expected"})
    @Test(dataProvider = "dataForParameters")
    public void testValidate(String name,
                             String x1, String y1, String x2, String y2,
                             String x3, String y3, String x4, String y4, boolean expected) {

        String[] shapeParameters = {name, x1, y1, x2, y2, x3, y3, x4, y4};
        boolean actual = ShapeValidation.validate(shapeParameters);

        assertEquals(actual, expected);
    }
}