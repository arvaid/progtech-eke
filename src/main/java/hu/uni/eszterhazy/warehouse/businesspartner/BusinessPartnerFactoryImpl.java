package hu.uni.eszterhazy.warehouse.businesspartner;

public class BusinessPartnerFactoryImpl implements BusinessPartnerFactory {
    @Override
    public BusinessPartner create(String businessPartnerType) {
        if ("customer".equalsIgnoreCase(businessPartnerType)) {
            return new Customer();
        }
        else if ("supplier".equalsIgnoreCase(businessPartnerType)) {
            return new Supplier();
        }
        else {
            try {
                throw new NotSupportedPartnerTypeException();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
