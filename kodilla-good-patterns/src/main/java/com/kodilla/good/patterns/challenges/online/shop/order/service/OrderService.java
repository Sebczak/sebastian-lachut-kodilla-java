package com.kodilla.good.patterns.challenges.online.shop.order.service;

import com.kodilla.good.patterns.challenges.online.shop.user.User;

import java.time.LocalDate;

public interface OrderService {

    boolean buy(User user, LocalDate dateOfPurchase, double price);
}
