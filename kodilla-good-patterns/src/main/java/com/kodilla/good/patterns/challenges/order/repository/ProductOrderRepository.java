package com.kodilla.good.patterns.challenges.order.repository;

import com.kodilla.good.patterns.challenges.User;

import java.time.LocalDate;

public interface ProductOrderRepository {

    void createOrder(User user, LocalDate dateOfPurchase, double price);
}
