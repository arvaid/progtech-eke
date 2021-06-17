package hu.uni.eszterhazy.warehouse.transaction;

import hu.uni.eszterhazy.warehouse.inventory.Product;
import hu.uni.eszterhazy.warehouse.transaction.payment.PaymentMethod;

import java.time.LocalDateTime;
import java.util.Map;

public interface Transaction {
    LocalDateTime getCreationDate();

    Map<Product, Integer> getProducts();

    PaymentMethod getPaymentMethod();

    int getTotalCost();
}
