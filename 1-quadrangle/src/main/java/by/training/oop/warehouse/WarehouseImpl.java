package by.training.oop.warehouse;

import by.training.oop.entity.QuadrangleWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class WarehouseImpl implements Warehouse {

    private static Logger log = LogManager.getLogger();

    private static WarehouseImpl instance = null;
    private WarehouseImpl(){ }

    public static WarehouseImpl getInstance(){
        if(instance == null){
            instance = new WarehouseImpl();
        }
        return instance;
    }


    private List<QuadrangleWarehouse> records = new ArrayList<>();

    @Override
    public void addRecord(QuadrangleWarehouse record) {
        records.add(record);
    }

    @Override
    public void removeRecord(QuadrangleWarehouse record) {
        records.remove(record);
    }

    @Override
    public void updateRecord(QuadrangleWarehouse record) {
        log.info("Update");
        for (QuadrangleWarehouse recordPrev : records){
            if(recordPrev.getId() == record.getId()) {
                removeRecord(recordPrev);
                break;
            }
        }
        addRecord(record);
    }

    @Override
    public List<QuadrangleWarehouse> getAllRecords() {
        return records;
    }

}
