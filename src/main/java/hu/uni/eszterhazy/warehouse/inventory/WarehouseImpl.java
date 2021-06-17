package hu.uni.eszterhazy.warehouse.inventory;

import hu.uni.eszterhazy.warehouse.Address;
import lombok.Data;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

@Data
public class WarehouseImpl implements Warehouse, Comparable<Warehouse> {
    private final Map<Product, Integer> inventory = new HashMap<>();

    @NonNull
    String name;

    @NonNull
    Address location;

    @NonNull
    int capacity;

    @Override
    public int getTotalStockCount() {
        return inventory.values().stream().reduce(0, Integer::sum);
    }

    @Override
    public int getTotalStockValue() {
        int total = 0;
        for (Map.Entry<Product, Integer> entry : inventory.entrySet()) {
            total += entry.getKey().getUnitPrice() * entry.getValue();
        }
        return total;
    }

    @Override
    public int getUsedCapacity() {
        return inventory.size();
    }

    @Override
    public int getUsedCapacityPercentage() {
        return (int) ((double) getUsedCapacity() / capacity * 100);
    }

    @Override
    public int getFreeCapacity() {
        return capacity - getUsedCapacity();
    }

    @Override
    public int getFreeCapacityPercentage() {
        return (int) ((double) getFreeCapacity() / capacity * 100);
    }

    @Override
    public void addProduct(Product product, int amount) {
        inventory.put(product, amount);
    }

    @Override
    public void removeProduct(Product product, int amount) {
        if (inventory.containsKey(product)) {
            int inventoryCount = inventory.get(product);

            if (inventoryCount >= amount) {
                inventory.put(product, inventoryCount - amount);
            }
        }
    }

    @Override
    public int compareTo(Warehouse o) {
        return Integer.compare(getUsedCapacity(), o.getUsedCapacity());
    }
}
