package hu.uni.eszterhazy.warehouse;

import lombok.NonNull;
import lombok.Value;

@Value
public class Address {
    @NonNull
    String country;

    @NonNull
    String zipCode;

    @NonNull
    String state;

    @NonNull
    String city;

    @NonNull
    String addressLine1;

    @NonNull
    String addressLine2;
}
