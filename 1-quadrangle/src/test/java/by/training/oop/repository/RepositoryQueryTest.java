package by.training.oop.repository;

import by.training.oop.entity.Point;
import by.training.oop.entity.Quadrangle;
import by.training.oop.repository.impl.RepositoryImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class RepositoryQueryTest {

    private Repository repository;

    @BeforeTest
    public void setUp() {
        repository = new RepositoryImpl();
        repository.addQuadrangle(ONE);
        repository.addQuadrangle(TWO);
        repository.addQuadrangle(THREE);
    }

    private final static Quadrangle ONE = new Quadrangle(
            new Point(1.0, 3.0),
            new Point(1.0,7.0),
            new Point(2.0, 7.0),
            new Point(2.0, 3.0)
    );

    private final static Quadrangle TWO = new Quadrangle(
            new Point(8.0, 2.0),
            new Point(8.0,5.0),
            new Point(9.0, 5.0),
            new Point(9.0, 2.0)
    );

    private final static Quadrangle THREE = new Quadrangle(
            new Point(2.0, 9.0),
            new Point(2.0,11.0),
            new Point(7.0, 11.0),
            new Point(7.0, 9.0)
    );

    @Test
    public void testQueryMinId() {
        SearchSpecification specification = new SearchSpecification();
        specification.setMinId(100);

        List<Quadrangle> expected = Arrays.asList();
        List<Quadrangle> actual = repository.query(specification.MORE_THEN_MIN_ID);

        assertEquals(actual, expected);
    }

    @Test
    public void testQueryMaxId() {
        SearchSpecification specification = new SearchSpecification();
        specification.setMaxId(0);

        List<Quadrangle> expected = Arrays.asList(ONE, TWO, THREE);
        List<Quadrangle> actual = repository.query(specification.LESS_THEN_MAX_ID);

        assertEquals(actual, expected);
    }

    @Test
    public void testQueryMinSquare() {
        SearchSpecification specification = new SearchSpecification();
        specification.setMinSquare(100);

        List<Quadrangle> expected = Arrays.asList();
        List<Quadrangle> actual = repository.query(specification.MORE_THEN_MIN_SQUARE);

        assertEquals(actual, expected);
    }

    @Test
    public void testQueryMinPerimeter() {
        SearchSpecification specification = new SearchSpecification();
        specification.setMinPerimeter(100);
        List<Quadrangle> expected = Arrays.asList();

        List<Quadrangle> actual = repository.query(specification.MORE_THEN_MIN_PERIMETER);

        assertEquals(actual, expected);
    }

    @Test
    public void testQueryInTheFirstQuadrant() {
        SearchSpecification specification = new SearchSpecification();
        specification.setMinId(100);

        List<Quadrangle> expected = Arrays.asList(ONE, TWO, THREE);
        List<Quadrangle> actual = repository.query(specification.IN_THE_FIRST_QUADRANT);

        assertEquals(actual, expected);
    }

}
