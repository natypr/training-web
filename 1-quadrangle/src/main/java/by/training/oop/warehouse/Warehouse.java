package by.training.oop.warehouse;

import by.training.oop.entity.QuadrangleWarehouse;

import java.util.List;

public interface Warehouse {

    void addRecord(QuadrangleWarehouse record);
    void removeRecord(QuadrangleWarehouse record);
    void updateRecord(QuadrangleWarehouse record);

    List<QuadrangleWarehouse> getAllRecords();
}
