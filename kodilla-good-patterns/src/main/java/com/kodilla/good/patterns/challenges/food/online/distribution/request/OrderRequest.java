package com.kodilla.good.patterns.challenges.food.online.distribution.request;


import com.kodilla.good.patterns.challenges.food.online.distribution.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderRequest {

    private User user;
    private LocalDate dateOfPurchase;
    private double price;

    public OrderRequest(User user, LocalDateTime dateOfPurchase, double price) {
        this.user = user;
        this.dateOfPurchase = LocalDate.from(dateOfPurchase);
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public double getPrice() {
        return price;
    }
}
