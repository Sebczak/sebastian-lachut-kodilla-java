package com.kodilla.good.patterns.challenges.online.shop.order.repository;

import com.kodilla.good.patterns.challenges.online.shop.user.User;

import java.time.LocalDate;

public interface ProductOrderRepository {

    void createOrder(User user, LocalDate dateOfPurchase, double price);
}
