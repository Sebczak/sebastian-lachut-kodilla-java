package com.kodilla.good.patterns.challenges.food.online.distribution.repository;

import com.kodilla.good.patterns.challenges.food.online.distribution.company.Company;
import com.kodilla.good.patterns.challenges.food.online.distribution.company.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.food.online.distribution.company.GlutenFreeShop;
import com.kodilla.good.patterns.challenges.food.online.distribution.company.HealthyShop;
import com.kodilla.good.patterns.challenges.food.online.distribution.product.Product;
import com.sun.net.httpserver.Headers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Companies {

    public Map<Integer, Company> mapOfCompanies = new HashMap<>();

    public Companies() {
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        HealthyShop healthyShop = new HealthyShop();
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();

        mapOfCompanies.put(1, extraFoodShop);
        mapOfCompanies.put(2, healthyShop);
        mapOfCompanies.put(3, glutenFreeShop);
    }

    public Map<Integer, Company> getMapOfCompanies() {
        return mapOfCompanies;
    }

    public Company getCompanyById(int companyId) {
        return mapOfCompanies.get(companyId);
    }
}
