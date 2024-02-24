package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrderService {

    public boolean buy(final User user, LocalDate dateOfPurchase, double price) {
        System.out.println("Buying item by: " + user.getFirstName() + user.getLastName()
                + " date: " + dateOfPurchase.toString() + " price: " + price);

        return true;
    }
}
