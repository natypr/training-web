package by.training.oop.warehouse;

import by.training.oop.entity.Point;
import by.training.oop.entity.Quadrangle;
import by.training.oop.entity.QuadrangleWarehouse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class WarehouseImplTest {

    private Warehouse warehouse;

    @BeforeTest
    public void setUp() {
        warehouse = WarehouseImpl.getInstance();
        warehouse.addRecord(new QuadrangleWarehouse(ONE));
        warehouse.addRecord(new QuadrangleWarehouse(TWO));
        warehouse.addRecord(new QuadrangleWarehouse(THREE));
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

    @Test
    public void testUpdateRecord() {

        QuadrangleWarehouse changedRecord = new QuadrangleWarehouse(
                new Quadrangle(
                    new Point(4.0, 5.0),
                    new Point(4.0, 7.0),
                    new Point(7.0, 7.0),
                    new Point(7.0, 5.0)
                )
        );

        List<QuadrangleWarehouse> expected = new ArrayList<>();

        expected.add(new QuadrangleWarehouse(ONE));
        expected.add(new QuadrangleWarehouse(TWO));
        expected.add(changedRecord);


        List<QuadrangleWarehouse> actual =  warehouse.getAllRecords();

        assertEquals(actual ,expected);
    }
}