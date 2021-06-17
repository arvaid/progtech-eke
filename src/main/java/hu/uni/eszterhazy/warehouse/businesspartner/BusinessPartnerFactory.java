package hu.uni.eszterhazy.warehouse.businesspartner;

public interface BusinessPartnerFactory {
    BusinessPartner create(String businessPartnerType);
}
