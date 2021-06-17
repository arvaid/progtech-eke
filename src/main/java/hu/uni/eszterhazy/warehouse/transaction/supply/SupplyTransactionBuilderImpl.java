package hu.uni.eszterhazy.warehouse.transaction.supply;

import hu.uni.eszterhazy.warehouse.businesspartner.Supplier;
import hu.uni.eszterhazy.warehouse.inventory.Product;
import hu.uni.eszterhazy.warehouse.transaction.payment.PaymentMethod;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


public class SupplyTransactionBuilderImpl implements SupplyTransactionBuilder {
    private Supplier supplier;
    private PaymentMethod paymentMethod;

    private final Map<Product, Integer> products = new HashMap<>();

    @Override
    public SupplyTransactionBuilder addProduct(Product product, int amount) {
        products.put(product, amount);
        return this;
    }

    @Override
    public SupplyTransactionBuilder setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    @Override
    public SupplyTransactionBuilder setSupplier(Supplier supplier) {
        this.supplier = supplier;
        return this;
    }

    @Override
    public SupplyTransaction build() {
        return new SupplyTransaction(LocalDateTime.now(), products, paymentMethod, supplier);
    }
}
