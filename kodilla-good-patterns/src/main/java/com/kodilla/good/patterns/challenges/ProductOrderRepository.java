package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class ProductOrderRepository {

    public void createOrder(User user, LocalDate dateOfPurchase, double price) {
        System.out.println(user.getFirstName() + " " + user.getLastName() + " is buying an item.\n" +
                "Date: " + dateOfPurchase +
                "\nPrice: " + price);
    }
}
