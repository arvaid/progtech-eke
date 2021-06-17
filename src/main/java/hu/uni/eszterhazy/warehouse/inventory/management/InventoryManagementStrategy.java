package hu.uni.eszterhazy.warehouse.inventory.management;

import hu.uni.eszterhazy.warehouse.Address;
import hu.uni.eszterhazy.warehouse.inventory.Product;
import hu.uni.eszterhazy.warehouse.inventory.Warehouse;

import java.util.List;

public interface InventoryManagementStrategy {
    void addProduct(List<Warehouse> warehouseList, Product product, int amount);

    void shipProduct(List<Warehouse> warehouseList, Product product, int amount, Address shippingAddress);

    void disposeProduct(Warehouse warehouse, Product product, int amount);
}
