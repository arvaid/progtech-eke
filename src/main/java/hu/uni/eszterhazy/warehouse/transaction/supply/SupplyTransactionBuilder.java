package hu.uni.eszterhazy.warehouse.transaction.supply;

import hu.uni.eszterhazy.warehouse.businesspartner.Supplier;
import hu.uni.eszterhazy.warehouse.inventory.Product;
import hu.uni.eszterhazy.warehouse.transaction.payment.PaymentMethod;

public interface SupplyTransactionBuilder {
    SupplyTransactionBuilder addProduct(Product product, int amount);
    SupplyTransactionBuilder setPaymentMethod(PaymentMethod method);
    SupplyTransactionBuilder setSupplier(Supplier supplier);
    SupplyTransaction build();
}
