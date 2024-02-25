package com.kodilla.good.patterns.challenges.food.online.distribution.company;

import com.kodilla.good.patterns.challenges.food.online.distribution.product.Product;

import java.util.List;

public interface Company {

    String getCompanyName();
    List<Product> getProducts();
}
