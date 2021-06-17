package hu.uni.eszterhazy.warehouse.transaction.order;

import hu.uni.eszterhazy.warehouse.businesspartner.Customer;
import hu.uni.eszterhazy.warehouse.Address;
import hu.uni.eszterhazy.warehouse.inventory.Product;
import hu.uni.eszterhazy.warehouse.transaction.AbstractTransaction;
import hu.uni.eszterhazy.warehouse.transaction.payment.PaymentMethod;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@ToString
public class OrderTransaction extends AbstractTransaction {
    @Getter
    @NonNull
    Customer customer;

    @Getter
    @NonNull
    Address billingAddress;

    @Getter
    Address shippingAddress;

    @Getter
    LocalDateTime completedAt;

    public OrderTransaction(@NonNull LocalDateTime creationDate, @NonNull Map<Product, Integer> products, @NonNull PaymentMethod paymentMethod,
                            @NonNull Customer customer, @NonNull Address billingAddress, Address shippingAddress) {
        super(creationDate, products, paymentMethod);
        this.customer = customer;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
    }

    public boolean isCompleted() {
        return completedAt != null;
    }

    public void setCompleted() {
        this.completedAt = LocalDateTime.now();
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}
