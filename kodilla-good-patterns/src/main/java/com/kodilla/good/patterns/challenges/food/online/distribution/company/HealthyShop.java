package com.kodilla.good.patterns.challenges.food.online.distribution.company;

import com.kodilla.good.patterns.challenges.food.online.distribution.product.Product;
import com.kodilla.good.patterns.challenges.food.online.distribution.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class HealthyShop implements Company{

    public final static String COMPANY_NAME = "Healthy Shop";
    private final List<Product> products = new ArrayList<>();

    public HealthyShop() {
        products.add(new Product("Soup", 28, "Good soup"));
        products.add(new Product("Turkey", 35, "Tasty Turkey"));
    }
    @Override
    public String getCompanyName() {
        return COMPANY_NAME;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
