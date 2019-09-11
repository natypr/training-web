package by.training.oop.observer;

import by.training.oop.action.Calculation;
import by.training.oop.entity.Quadrangle;
import by.training.oop.entity.QuadrangleWarehouse;
import by.training.oop.warehouse.Warehouse;
import by.training.oop.warehouse.WarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ObserverImpl implements Observer {

    private static Logger log = LogManager.getLogger();
    private String name;

    public ObserverImpl(String name) {
        this.name = name;
    }

    @Override
    public void update(Quadrangle quadrangle) {

        log.info("\n===" + name + ", we have some changes: " + quadrangle + "===");

        int id = quadrangle.getId();
        double area = Calculation.areaShape(quadrangle);
        double perimeter = Calculation.perimeterShape(quadrangle);

        Warehouse warehouse = WarehouseImpl.getInstance();
        warehouse.updateRecord(new QuadrangleWarehouse(id, area, perimeter));

    }
}
