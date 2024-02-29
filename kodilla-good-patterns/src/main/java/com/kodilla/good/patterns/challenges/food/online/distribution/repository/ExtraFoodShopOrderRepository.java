package com.kodilla.good.patterns.challenges.food.online.distribution.repository;

import com.kodilla.good.patterns.challenges.food.online.distribution.company.Company;
import com.kodilla.good.patterns.challenges.food.online.distribution.company.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.food.online.distribution.product.Product;
import com.kodilla.good.patterns.challenges.food.online.distribution.request.OrderRequest;
import com.kodilla.good.patterns.challenges.food.online.distribution.user.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ExtraFoodShopOrderRepository implements FoodOrderRepository{

    private final Companies companies = new Companies();

    @Override
    public boolean createOrder(OrderRequest orderRequest) {
        System.out.println("Creating an order from:" + ExtraFoodShop.COMPANY_NAME + "\n" +
                "for: " + orderRequest.getUser().getFirstName() + orderRequest.getUser().getLastName() + "\n" +
                "Dish chosen: " + returnSpecificDishFromMap(companies) + "\n" +
                "Date of placing an order: " + orderRequest.getDateOfPurchase() + "\n" +
                "Price: " + orderRequest.getPrice());
        return true;
    }

    private String returnSpecificDishFromMap(Companies companies) {
        Map<String, Company> mapOfCompanies = companies.getMapOfCompanies();

        String desiredDishName = "Spaghetti";


        Optional<String> dish = mapOfCompanies.values()
                .stream()
                .flatMap(company -> company.getProducts().stream())
                .map(Product::getName)
                .filter(name -> name.equals(desiredDishName))
                .findFirst();

        return dish.orElse("Dish not found");
    }
}
