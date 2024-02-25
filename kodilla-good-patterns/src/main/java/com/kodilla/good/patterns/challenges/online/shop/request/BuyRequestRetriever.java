package com.kodilla.good.patterns.challenges.online.shop.request;

import com.kodilla.good.patterns.challenges.online.shop.user.User;

import java.time.LocalDateTime;

public class BuyRequestRetriever {

    public BuyRequest retrieve() {
        User user = new User("John", "Week");

        LocalDateTime buyDate = LocalDateTime.of(2017, 8, 1, 12, 0);
        double price = 125.12;

        return new BuyRequest(user, buyDate, price);
    }
}
