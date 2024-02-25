package com.kodilla.good.patterns.challenges.online.shop.order.service;

import com.kodilla.good.patterns.challenges.online.shop.user.User;

import java.time.LocalDate;

public class GamesOrderService implements OrderService {
    @Override
    public boolean buy(User user, LocalDate dateOfPurchase, double price) {
        System.out.println("User: " + user.getFirstName() + " " + user.getLastName() + " bought a game.\n" +
                "Date of purchase: " + dateOfPurchase + "\n" +
                "Price: " + price);
        return true;
    }
}
