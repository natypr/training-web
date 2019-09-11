package by.training.oop.action;

import by.training.oop.entity.Point;
import by.training.oop.entity.Quadrangle;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataComplianceTest {

    private Point p1, p2, p3, p4, p5, p6;
    private Quadrangle quadrangle;
    private DataCompliance dataCompliance;

    @BeforeClass
    public void setUp() {
        p1 = new Point(1.0, 2.0);
        p2 = new Point(1.0, 5.0);
        p3 = new Point(4.0, 5.0);
        p4 = new Point(4.0, 2.0);
        p5 = new Point(7.0, 5.0);
        p6 = new Point(7.0, 2.0);
        dataCompliance = new DataCompliance();
    }

    @Test
    public void testIsSquare() {
        quadrangle = new Quadrangle(p1, p2, p3, p4);
        assertTrue(dataCompliance.isSquare(quadrangle));
    }

    @Test
    public void testIsRhombus() {
        quadrangle = new Quadrangle(p1, p2, p3, p4);
        assertTrue(dataCompliance.isRhombus(quadrangle));
    }

    @Test
    public void testIsTrapeze() {
        quadrangle = new Quadrangle(p1, p2, p3, p6);
        assertTrue(dataCompliance.isTrapeze(quadrangle));
    }

    @Test
    public void testIsLineLengthEquals() {
        quadrangle = new Quadrangle(p1, p2, p3, p4);
        assertTrue(dataCompliance.isLineLengthEquals(quadrangle));
    }

    @Test
    public void testIsQuadrangle() {
        quadrangle = new Quadrangle(p1, p3, p6, p4);
        assertFalse(dataCompliance.isQuadrangle(quadrangle));
    }

    @Test
    public void testIsThreePointsOnOneLine() {
        quadrangle = new Quadrangle(p2, p3, p5, p6);
        assertFalse(dataCompliance.isThreePointsOnOneLine(quadrangle));
    }

    @Test
    public void testIsConvex() {
        quadrangle = new Quadrangle(p1, p2, p5, p4);
        assertTrue(dataCompliance.isConvex(quadrangle));
    }
}