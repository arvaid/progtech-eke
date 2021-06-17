package hu.uni.eszterhazy.warehouse.inventory;

import hu.uni.eszterhazy.warehouse.Address;

import java.util.Map;

public interface Warehouse {
    String getName();

    Address getLocation();

    int getCapacity();

    int getTotalStockCount();

    int getTotalStockValue();

    int getUsedCapacity();
    int getUsedCapacityPercentage();

    int getFreeCapacity();
    int getFreeCapacityPercentage();

    Map<Product, Integer> getInventory();

    void addProduct(Product product, int amount);

    void removeProduct(Product product, int amount);
}
