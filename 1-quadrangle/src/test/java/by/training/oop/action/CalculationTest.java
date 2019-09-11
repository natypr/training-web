package by.training.oop.action;

import by.training.oop.entity.Point;
import by.training.oop.entity.Quadrangle;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static by.training.oop.action.Calculation.*;
import static org.testng.Assert.assertEquals;

public class CalculationTest {

    private static final double DELTA = 0.0001;

    private Point p1, p2, p3, p4;

    @BeforeClass
    public void setUp() {
        p1 = new Point(1.0, 2.0);
        p2 = new Point(1.0, 5.0);
        p3 = new Point(3.0, 5.0);
        p4 = new Point(5.0, 2.0);
    }

    @DataProvider(name = "dataForPoints")
    public Object[][] dataForPoints() {
        return new Object[][]{
                {p1, p2, 3.0},
                {p2, p3, 2.0},
                {p3, p4, 3.6055}
        };
    }

    @Parameters({"firstPoint", "secondPoint", "expectedValue"})
    @Test(dataProvider = "dataForPoints")
    public void testDistanceBetweenTwoPoints(Point firstPoint, Point secondPoint, double expectedValue) {
        double actualValue = Calculation.distanceBetweenTwoPoints(firstPoint, secondPoint);
        assertEquals(actualValue, expectedValue, DELTA);
    }

    @Test
    public void testLineCoefficient() {
        double actualLineCoefficient = lineCoefficient(p3, p4);
        double expectedLineCoefficient = 0.0;
        assertEquals(actualLineCoefficient, expectedLineCoefficient, DELTA);
    }

    @Test(description = "angle between two lines")
    public void testAngle() {
        double actualAngle = Calculation.angle(0.75, 0.0);
        double expectedAngle = 0.6435;
        assertEquals(actualAngle, expectedAngle, DELTA);
    }

    @Test
    public void testListOfAngle() {
        List<Double> expectedList = new ArrayList<>();
        expectedList.add(0.6435011087932844);
        expectedList.add(0.3929111870854913);
        expectedList.add(-0.1296579427421352);
        expectedList.add(-0.2051011575236992);

        List<Double> actualList = new ArrayList<>();
        actualList.add(angle(0.75, 0.0));
        actualList.add(angle(0.67, 0.2));
        actualList.add(angle(0.32, 0.47));
        actualList.add(angle(0.29, 0.53));

        assertEquals(actualList, expectedList);
    }

    @Test
    public void testPerimeterShape() {
        Quadrangle qdr = new Quadrangle(p1, p2, p3, p4);

        double actualPerimeter = Calculation.perimeterShape(qdr);
        double expectedPerimeter = 12.6055;
        assertEquals(actualPerimeter, expectedPerimeter, DELTA);

    }

    @Test
    public void testAreaShape() {
        Quadrangle qdr = new Quadrangle(p1, p2, p3, p4);
        double actualArea = Calculation.areaShape(qdr);
        double expectedArea= 9.3950;
        assertEquals(actualArea, expectedArea, DELTA);
    }
}