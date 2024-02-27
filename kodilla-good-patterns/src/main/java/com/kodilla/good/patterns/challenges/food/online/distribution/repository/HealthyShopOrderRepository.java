package com.kodilla.good.patterns.challenges.food.online.distribution.repository;

import com.kodilla.good.patterns.challenges.food.online.distribution.company.Company;
import com.kodilla.good.patterns.challenges.food.online.distribution.company.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.food.online.distribution.product.Product;
import com.kodilla.good.patterns.challenges.food.online.distribution.user.User;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public class HealthyShopOrderRepository implements FoodOrderRepository{

    private final Companies companies = new Companies();
    @Override
    public boolean createOrder(User user, LocalDate dateOfCreatingOrder, double price) {
        System.out.println("Creating an order from:" + ExtraFoodShop.COMPANY_NAME + "\n" +
                "for: " + user.getFirstName() + user.getLastName() + "\n" +
                "Dish chosen: " + returnSpecificDishFromMap(companies) + "\n" +
                "Date of placing an order: " + dateOfCreatingOrder + "\n" +
                "Price: " + companies.getCompanyById(2).getProducts().get(0).getPriceTag());
        return true;
    }

    private String returnSpecificDishFromMap(Companies companies) {
        Map<Integer, Company> mapOfCompanies = companies.getMapOfCompanies();

        String desiredDishName = "Turkey";


        Optional<String> dish = mapOfCompanies.values()
                .stream()
                .flatMap(company -> company.getProducts().stream())
                .map(Product::getName)
                .filter(name -> name.equals(desiredDishName))
                .findFirst();

        return dish.orElse("Dish not found");
    }
}
