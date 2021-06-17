package hu.uni.eszterhazy.warehouse.demos;

import hu.uni.eszterhazy.warehouse.Address;
import hu.uni.eszterhazy.warehouse.inventory.*;
import hu.uni.eszterhazy.warehouse.inventory.management.InventoryManagementStrategy;
import hu.uni.eszterhazy.warehouse.inventory.management.InventoryManagementStrategyImpl;

public class InventoryManagementDemo implements Demo {
    @Override
    public void demo() {
        InventoryManagementStrategy strategy = new InventoryManagementStrategyImpl();
        InventoryManager manager = new InventoryManager(strategy);

        Address warehouseAddress = new Address("Hungary", "3300", "Heves", "Eger", "Leányka utca 9.", "");
        Warehouse warehouse = new WarehouseImpl("Teszt", warehouseAddress, 200);

        Product product1 = new ProductImpl("Soproni IPA", "alkoholtartalmú ital", "db");
        Product product2 = new ProductImpl("sertéscomb", "élelmiszer", "kg");

        manager.addWarehouse(warehouse);

        try {
            manager.addProduct(product1, 120);
            manager.addProduct(product2, 80);
        } catch (NotEnoughStorageException e) {
            e.printStackTrace();
        }

        System.out.println(manager.getWarehouseList());
    }
}
