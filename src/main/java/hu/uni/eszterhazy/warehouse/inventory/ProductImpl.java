package hu.uni.eszterhazy.warehouse.inventory;

import lombok.*;

@Data
public class ProductImpl implements Product {
    @Getter
    @Setter
    @ToString.Exclude
    Warehouse warehouse;

    @NonNull
    String name;

    @NonNull
    String category;

    @NonNull
    String unit;

    int unitPrice;

    @Override
    public void discount(int percent) {
        unitPrice *= (double) percent / 100;
    }
}
