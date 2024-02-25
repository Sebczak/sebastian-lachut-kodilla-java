package com.kodilla.good.patterns.challenges.food.online.distribution.company;

import com.kodilla.good.patterns.challenges.food.online.distribution.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ExtraFoodShop implements Company{

    public final static String COMPANY_NAME = "ExtraFoodShop";
    private final List<Product> products = new ArrayList<>();

    public ExtraFoodShop() {
        products.add(new Product("Spaghetti", 30, "Italian pasta with tomato sauce"));
        products.add(new Product("Carbonara", 25, "Italian pasta with eggs and pecorino"));
    }

    @Override
    public String getCompanyName() {
        return COMPANY_NAME;
    }

    public List<Product> getProducts() {
        return products;
    }
}
