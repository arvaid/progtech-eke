package hu.uni.eszterhazy.warehouse.businesspartner;

import hu.uni.eszterhazy.warehouse.Address;

public interface BusinessPartner {
    String getName();

    String getEmail();

    String getPhoneNumber();

    Address getAddress();
}
