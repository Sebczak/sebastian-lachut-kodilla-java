package com.kodilla.good.patterns.challenges.order.service;

import com.kodilla.good.patterns.challenges.User;

import java.time.LocalDate;

public interface OrderService {

    boolean buy(User user, LocalDate dateOfPurchase, double price);
}
