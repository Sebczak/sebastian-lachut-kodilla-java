package com.kodilla.good.patterns.challenges.food.online.distribution.company;

import com.kodilla.good.patterns.challenges.food.online.distribution.product.Product;
import com.kodilla.good.patterns.challenges.food.online.distribution.service.OrderService;
import com.kodilla.good.patterns.challenges.online.shop.information.InformationService;

import java.util.List;

public interface Company {

    String getCompanyName();
    List<Product> getProducts();
}
