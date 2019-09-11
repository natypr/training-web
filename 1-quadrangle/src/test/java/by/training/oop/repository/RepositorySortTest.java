package by.training.oop.repository;

import by.training.oop.entity.Point;
import by.training.oop.entity.Quadrangle;
import by.training.oop.repository.impl.RepositoryImpl;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class RepositorySortTest {

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
    public void testSortQuadrangleById() {
        List<Quadrangle> expected = Arrays.asList(ONE, TWO, THREE);
        List<Quadrangle> actual = repository.sortQuadrangle(QuadrangleComparator.ID_COMPARATOR);

        assertEquals(actual ,expected);
    }

    @Test
    public void testSortQuadrangleByFirstX() {
        List<Quadrangle> expected = Arrays.asList(ONE, THREE, TWO);
        List<Quadrangle> actual = repository.sortQuadrangle(QuadrangleComparator.FIRST_X_COMPARATOR);

        assertEquals(actual ,expected);
    }

    @Test
    public void testSortQuadrangleByFirstY() {
        List<Quadrangle> expected = Arrays.asList(TWO, ONE, THREE);
        List<Quadrangle> actual = repository.sortQuadrangle(QuadrangleComparator.FIRST_Y_COMPARATOR);

        assertEquals(actual ,expected);
    }
}
