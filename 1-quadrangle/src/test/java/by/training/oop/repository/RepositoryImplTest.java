package by.training.oop.repository;

import by.training.oop.entity.Point;
import by.training.oop.entity.Quadrangle;
import by.training.oop.repository.impl.RepositoryImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class RepositoryImplTest {

    Repository repository;

    @BeforeTest
    public void setUp() {
        repository = new RepositoryImpl();
        repository.addQuadrangle(ONE);
        repository.addQuadrangle(TWO);
        repository.addQuadrangle(THREE);
        repository.addQuadrangle(FOUR);
        repository.addQuadrangle(FIVE);
    }

    private final static Quadrangle ONE = new Quadrangle(
            new Point(1.0, 2.0),
            new Point(1.0, 4.0),
            new Point(4.0, 4.0),
            new Point(4.0, 2.0)
    );

    private final static Quadrangle TWO = new Quadrangle(
            new Point(3.0, 3.0),
            new Point(3.0, 5.0),
            new Point(7.0, 5.0),
            new Point(7.0, 3.0)
    );

    private final static Quadrangle THREE = new Quadrangle(
            new Point(4.0, 5.0),
            new Point(4.0, 7.0),
            new Point(7.0, 7.0),
            new Point(7.0, 5.0)
    );

    private final static Quadrangle FOUR = new Quadrangle(
            new Point(1.0, 3.0),
            new Point(1.0,7.0),
            new Point(2.0, 7.0),
            new Point(2.0, 3.0)
    );

    private final static Quadrangle FIVE = new Quadrangle(
            new Point(8.0, 2.0),
            new Point(8.0,5.0),
            new Point(9.0, 5.0),
            new Point(9.0, 2.0)
    );

    private final static Quadrangle SIX = new Quadrangle(
            new Point(2.0, 9.0),
            new Point(2.0,11.0),
            new Point(7.0, 11.0),
            new Point(7.0, 9.0)
    );


    @Test
    public void testAddQuadrangle() {
        List<Quadrangle> expected = Arrays.asList(ONE, TWO, THREE, FOUR, FIVE, SIX);

        repository.addQuadrangle(SIX);
        List<Quadrangle> actual = repository.getAllQuadrangle();

        assertEquals(actual ,expected);

    }

    @Test
    public void testRemoveQuadrangle() {
        List<Quadrangle> expected = Arrays.asList(ONE, TWO, FOUR, FIVE);

        repository.removeQuadrangle(THREE);
        repository.removeQuadrangle(SIX);
        List<Quadrangle> actual = repository.getAllQuadrangle();

        assertEquals(actual ,expected);
    }

    @Test
    public void testSortQuadrangle() {
    }

    @Test
    public void testQuery() {
    }

    @Test
    public void testGetQuadrangle() {
    }

    @Test
    public void testGetAllQuadrangle() {
    }
}