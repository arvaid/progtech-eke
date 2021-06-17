package hu.uni.eszterhazy.warehouse.businesspartner;

import hu.uni.eszterhazy.warehouse.Address;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements BusinessPartner {
    @NonNull
    private String name;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String email;

    @NonNull
    private Address address;
}