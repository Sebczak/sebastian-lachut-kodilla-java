package com.kodilla.good.patterns.challenges.buy.request;

import com.kodilla.good.patterns.challenges.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BuyRequest {

    private User user;
    private LocalDate dateOfPurchase;
    private double price;

    public BuyRequest(User user, LocalDateTime dateOfPurchase, double price) {
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
