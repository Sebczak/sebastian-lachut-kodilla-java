package com.kodilla.good.patterns.challenges.food.online.distribution.company;

import com.kodilla.good.patterns.challenges.food.online.distribution.product.Product;
import com.kodilla.good.patterns.challenges.food.online.distribution.service.OrderService;

import java.util.ArrayList;
import java.util.List;

public class GlutenFreeShop implements Company{

    public final static String COMPANY_NAME = "GlutenFreeShop";
    private final List<Product> products = new ArrayList<>();

    public GlutenFreeShop() {
        products.add(new Product("Water", 5, "Sparkling water"));
        products.add(new Product("Rice", 15, "Really good rice"));
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
