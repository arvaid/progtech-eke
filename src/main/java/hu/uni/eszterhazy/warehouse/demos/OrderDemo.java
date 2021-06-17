package hu.uni.eszterhazy.warehouse.demos;

import hu.uni.eszterhazy.warehouse.*;
import hu.uni.eszterhazy.warehouse.businesspartner.*;
import hu.uni.eszterhazy.warehouse.inventory.Product;
import hu.uni.eszterhazy.warehouse.inventory.ProductImpl;
import hu.uni.eszterhazy.warehouse.transaction.*;
import hu.uni.eszterhazy.warehouse.transaction.order.*;
import hu.uni.eszterhazy.warehouse.transaction.payment.CreditCardPayment;

public class OrderDemo implements Demo {
    @Override
    public void demo() {
        OrderTransactionBuilderImpl builder = new OrderTransactionBuilderImpl();
        Address customerAddress = new Address("Hungary", "3300", "Heves", "Eger", "Leányka utca 9.", "");
        Customer customer = new Customer("Teszt Elek", "06301234567", "teszt@teszt.com", customerAddress);

        Product product1 = new ProductImpl("Soproni IPA", "alkoholos ital", "db");
        Product product2 = new ProductImpl("sertéscomb", "élelmiszer", "kg");

        Transaction transaction = builder.setCustomer(customer)
                .setBillingAddress(customerAddress)
                .setShippingAddress(customerAddress)
                .setPaymentMethod(new CreditCardPayment())
                .addProduct(product1, 6)
                .addProduct(product2, 2)
                .build();

        System.out.println(transaction);
    }

}
