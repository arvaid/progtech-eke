package hu.uni.eszterhazy.warehouse.transaction.supply;

import hu.uni.eszterhazy.warehouse.businesspartner.Supplier;
import hu.uni.eszterhazy.warehouse.inventory.Product;
import hu.uni.eszterhazy.warehouse.transaction.AbstractTransaction;
import hu.uni.eszterhazy.warehouse.transaction.payment.PaymentMethod;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@ToString
public class SupplyTransaction extends AbstractTransaction {
    @NonNull
    Supplier supplier;

    public SupplyTransaction(@NonNull LocalDateTime creationDate, @NonNull Map<Product, Integer> products, @NonNull PaymentMethod paymentMethod,
                             @NonNull Supplier supplier) {
        super(creationDate, products, paymentMethod);
        this.supplier = supplier;
    }
}
