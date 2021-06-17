package hu.uni.eszterhazy.warehouse.demos;

import hu.uni.eszterhazy.warehouse.businesspartner.BusinessPartner;
import hu.uni.eszterhazy.warehouse.businesspartner.BusinessPartnerFactory;
import hu.uni.eszterhazy.warehouse.businesspartner.BusinessPartnerFactoryImpl;

public class FactoryDemo implements Demo {
    @Override
    public void demo() {
        BusinessPartnerFactory factory = new BusinessPartnerFactoryImpl();

        BusinessPartner partner1 = factory.create("customer");
        BusinessPartner partner2 = factory.create("supplier");

        System.out.println(partner1);
        System.out.println(partner2);
    }
}
