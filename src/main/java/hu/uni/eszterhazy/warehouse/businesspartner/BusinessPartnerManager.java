package hu.uni.eszterhazy.warehouse.businesspartner;

import java.util.ArrayList;
import java.util.List;

public class BusinessPartnerManager {
    List<BusinessPartner> businessPartnerList = new ArrayList<>();

    public void addBusinessPartner(BusinessPartner partner) {
        businessPartnerList.add(partner);
    }

    public void removeBusinessPartner(BusinessPartner partner) {
        businessPartnerList.remove(partner);
    }
}
