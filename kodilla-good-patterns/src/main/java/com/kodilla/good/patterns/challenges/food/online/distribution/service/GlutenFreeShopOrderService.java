package com.kodilla.good.patterns.challenges.food.online.distribution.service;

import com.kodilla.good.patterns.challenges.food.online.distribution.user.User;

import java.time.LocalDate;

public class GlutenFreeShopOrderService implements OrderService{
    @Override
    public boolean orderFood(User user, LocalDate dateOfCreatingOrder, double price) {
        System.out.println("Order for: " + user.getFirstName() + " " + user.getLastName() + " is created.\n" +
                "Date of placing a order: " + dateOfCreatingOrder + "\n" +
                "Price for an order: " + price);
        return true;
    }
}
