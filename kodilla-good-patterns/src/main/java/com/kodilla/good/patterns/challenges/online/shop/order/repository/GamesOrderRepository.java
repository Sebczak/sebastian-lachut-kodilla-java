package com.kodilla.good.patterns.challenges.online.shop.order.repository;

import com.kodilla.good.patterns.challenges.online.shop.user.User;

import java.time.LocalDate;

public class GamesOrderRepository implements ProductOrderRepository {
    @Override
    public void createOrder(User user, LocalDate dateOfPurchase, double price) {
        System.out.println("Game order for: " + user.getFirstName() + " " + user.getLastName() +
                "is created.\n" +
                "Date of purchase: " + dateOfPurchase +
                "\nPrice: " + price);
    }
}
