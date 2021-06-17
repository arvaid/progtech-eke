package hu.uni.eszterhazy.warehouse.transaction.order;

import hu.uni.eszterhazy.warehouse.Address;
import hu.uni.eszterhazy.warehouse.businesspartner.Customer;
import hu.uni.eszterhazy.warehouse.inventory.Product;
import hu.uni.eszterhazy.warehouse.transaction.payment.PaymentMethod;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class OrderTransactionBuilderImpl implements OrderTransactionBuilder {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private PaymentMethod paymentMethod;

    private final Map<Product, Integer> products = new HashMap<>();

    @Override
    public OrderTransactionBuilder addProduct(Product product, int amount) {
        products.put(product, amount);
        return this;
    }

    @Override
    public OrderTransactionBuilder setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    @Override
    public OrderTransactionBuilder setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    @Override
    public OrderTransactionBuilder setShippingAddress(Address address) {
        this.shippingAddress = address;
        return this;
    }

    @Override
    public OrderTransactionBuilder setBillingAddress(Address address) {
        this.billingAddress = address;
        return this;
    }

    @Override
    public OrderTransaction build() {
        shippingAddress = shippingAddress == null ? billingAddress : shippingAddress;
        return new OrderTransaction(LocalDateTime.now(), products, paymentMethod, customer, billingAddress, shippingAddress);
    }
}
