package com.kodilla.good.patterns.challenges.food.online.distribution.repository;

import com.kodilla.good.patterns.challenges.food.online.distribution.company.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.food.online.distribution.product.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Companies {

    private Map<String, List<Product>> mapOfCompanies = new HashMap<>();
    private ExtraFoodShop extraFoodShop = new ExtraFoodShop();

    public Companies() {
        mapOfCompanies.put(ExtraFoodShop.COMPANY_NAME, extraFoodShop.getProducts());
    }

    public Map<String, List<Product>> getMapOfCompanies() {
        return mapOfCompanies;
    }

    public ExtraFoodShop getExtraFoodShop() {
        return extraFoodShop;
    }
}
