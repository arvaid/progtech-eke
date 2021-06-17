package hu.uni.eszterhazy.warehouse.inventory;

import hu.uni.eszterhazy.warehouse.inventory.management.InventoryManagementStrategy;
import hu.uni.eszterhazy.warehouse.transaction.order.OrderTransaction;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InventoryManager {
    private final List<Warehouse> warehouseList = new ArrayList<>();

    @Getter
    @Setter
    private InventoryManagementStrategy managementStrategy;

    public InventoryManager(InventoryManagementStrategy managementStrategy) {
        this.managementStrategy = managementStrategy;
    }

    public void addWarehouse(Warehouse warehouse) {
        warehouseList.add(warehouse);
    }

    public void removeWarehosue(Warehouse warehouse) {
        warehouseList.remove(warehouse);
    }

    public void addProduct(Product product, int amount) throws NotEnoughStorageException {
        if (getTotalFreeCapacity() < amount) {
            throw new NotEnoughStorageException();
        }

        managementStrategy.addProduct(warehouseList, product, amount);
    }

    public void shipProducts(OrderTransaction transaction) {
        Map<Product, Integer> products = transaction.getProducts();

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            managementStrategy.shipProduct(warehouseList, entry.getKey(), entry.getValue(), transaction.getShippingAddress());
        }
        transaction.setCompleted();
    }

    public int getTotalFreeCapacity() {
        return warehouseList.stream().map(Warehouse::getFreeCapacity).reduce(0, Integer::sum);
    }

    public List<Warehouse> getWarehouseList() {
        return warehouseList;
    }
}
