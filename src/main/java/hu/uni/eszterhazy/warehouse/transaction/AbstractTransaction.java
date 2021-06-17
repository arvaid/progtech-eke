package hu.uni.eszterhazy.warehouse.transaction;

import hu.uni.eszterhazy.warehouse.inventory.Product;
import hu.uni.eszterhazy.warehouse.transaction.payment.PaymentMethod;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class AbstractTransaction implements Transaction {
    @NonNull
    @Getter
    private final LocalDateTime creationDate;

    @NonNull
    @Getter
    private final Map<Product, Integer> products;

    @NonNull
    @Getter
    private final PaymentMethod paymentMethod;

    @Override
    public int getTotalCost() {
        int total = 0;
        for (Product product : products.keySet()) {
            total += product.getUnitPrice() * products.get(product);
        }
        return total;
    }
}
