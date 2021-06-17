package hu.uni.eszterhazy.warehouse.demos;

import hu.uni.eszterhazy.warehouse.Address;
import hu.uni.eszterhazy.warehouse.businesspartner.Supplier;
import hu.uni.eszterhazy.warehouse.inventory.Product;
import hu.uni.eszterhazy.warehouse.inventory.ProductImpl;
import hu.uni.eszterhazy.warehouse.transaction.Transaction;
import hu.uni.eszterhazy.warehouse.transaction.payment.WireTransferPayment;
import hu.uni.eszterhazy.warehouse.transaction.supply.SupplyTransactionBuilderImpl;

public class SupplyDemo implements Demo {
    @Override
    public void demo() {
        Address supplierAddress = new Address("Hungary", "3300", "Heves", "Eger", "Leányka utca 9.", "");
        Supplier supplier = new Supplier("Teszt Kft.", "Teszt Elek", "06301234567", "teszt@teszt.hu", supplierAddress);

        Product product1 = new ProductImpl("Soproni IPA", "alkoholos ital", "db");
        Product product2 = new ProductImpl("sertéscomb", "élelmiszer", "kg");

        SupplyTransactionBuilderImpl builder = new SupplyTransactionBuilderImpl();
        Transaction transaction = builder.setSupplier(supplier)
                .addProduct(product1, 120)
                .addProduct(product2, 80)
                .setPaymentMethod(new WireTransferPayment())
                .build();

        System.out.println(transaction);
    }
}
