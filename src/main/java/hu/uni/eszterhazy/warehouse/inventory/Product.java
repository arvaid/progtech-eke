package hu.uni.eszterhazy.warehouse.inventory;

public interface Product {
    Warehouse getWarehouse();
    void setWarehouse(Warehouse warehouse);

    String getName();

    String getCategory();

    String getUnit();

    int getUnitPrice();

    void discount(int percent);
}
