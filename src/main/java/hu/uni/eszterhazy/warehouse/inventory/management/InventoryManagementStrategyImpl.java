package hu.uni.eszterhazy.warehouse.inventory.management;

import hu.uni.eszterhazy.warehouse.Address;
import hu.uni.eszterhazy.warehouse.inventory.Product;
import hu.uni.eszterhazy.warehouse.inventory.Warehouse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryManagementStrategyImpl implements InventoryManagementStrategy {
    @Override
    public void addProduct(List<Warehouse> warehouseList, Product product, int amount) {
        // example implementation: put it into the first (biggest) place that fits
        // doesn't account for distances
        // doesn't account for other products needing the space
        List<Warehouse> sortedCopy = warehouseList.stream().sorted().collect(Collectors.toCollection(ArrayList::new));

        int remainingAmount = amount;

        for (Warehouse warehouse : sortedCopy) {
            if (remainingAmount == 0) { break;}

            int storedAmount = Math.min(remainingAmount, warehouse.getFreeCapacity());
            warehouse.addProduct(product, storedAmount);
            product.setWarehouse(warehouse);
            remainingAmount -= storedAmount;
        }
    }

    @Override
    public void shipProduct(List<Warehouse> warehouseList, Product product, int amount, Address shippingAddress) {
        // TODO: ship products from warehouses to customer in an efficient way
    }

    @Override
    public void disposeProduct(Warehouse warehouse, Product product, int amount) {
        warehouse.removeProduct(product, amount);
    }
}
