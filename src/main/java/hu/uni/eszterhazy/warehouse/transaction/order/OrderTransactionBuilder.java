package hu.uni.eszterhazy.warehouse.transaction.order;

import hu.uni.eszterhazy.warehouse.Address;
import hu.uni.eszterhazy.warehouse.businesspartner.Customer;

import hu.uni.eszterhazy.warehouse.inventory.Product;
import hu.uni.eszterhazy.warehouse.transaction.payment.PaymentMethod;

public interface OrderTransactionBuilder  {
    OrderTransactionBuilder addProduct(Product product, int amount);
    OrderTransactionBuilder setCustomer(Customer customer);
    OrderTransactionBuilder setShippingAddress(Address address);
    OrderTransactionBuilder setBillingAddress(Address address);
    OrderTransactionBuilder setPaymentMethod(PaymentMethod paymentMethod);

    OrderTransaction build();
}
