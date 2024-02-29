package com.kodilla.good.patterns.challenges.food.online.distribution.units;

import com.kodilla.good.patterns.challenges.food.online.distribution.company.Company;
import com.kodilla.good.patterns.challenges.food.online.distribution.company.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.food.online.distribution.company.GlutenFreeShop;
import com.kodilla.good.patterns.challenges.food.online.distribution.company.HealthyShop;
import com.kodilla.good.patterns.challenges.food.online.distribution.information.PhoneInformationService;
import com.kodilla.good.patterns.challenges.food.online.distribution.repository.ExtraFoodShopOrderRepository;
import com.kodilla.good.patterns.challenges.food.online.distribution.repository.GlutenFreeShopOrderRepository;
import com.kodilla.good.patterns.challenges.food.online.distribution.repository.HealthyShopOrderRepository;
import com.kodilla.good.patterns.challenges.food.online.distribution.service.ExtraFoodShopOrderService;
import com.kodilla.good.patterns.challenges.food.online.distribution.service.GlutenFreeShopOrderService;
import com.kodilla.good.patterns.challenges.food.online.distribution.service.HealthyShopOrderService;

import java.util.HashMap;
import java.util.Map;

public class MapOfUnits {

    public Map<String, Unit> mapOfCompanyUnits = new HashMap<>();

    public MapOfUnits() {
        mapOfCompanyUnits.put(ExtraFoodShop.COMPANY_NAME,new Unit(new PhoneInformationService(), new ExtraFoodShopOrderRepository(), new ExtraFoodShopOrderService()));
        mapOfCompanyUnits.put(HealthyShop.COMPANY_NAME,new Unit(new PhoneInformationService(), new HealthyShopOrderRepository(), new HealthyShopOrderService()));
        mapOfCompanyUnits.put(GlutenFreeShop.COMPANY_NAME,new Unit(new PhoneInformationService(), new GlutenFreeShopOrderRepository(), new GlutenFreeShopOrderService()));
    }

    public Map<String, Unit> getMapOfCompanyUnits() {
        return mapOfCompanyUnits;
    }
}
