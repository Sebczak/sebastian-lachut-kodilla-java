package com.kodilla.good.patterns.challenges.food.online.distribution.service;

import com.kodilla.good.patterns.challenges.food.online.distribution.user.User;

import java.time.LocalDate;

public interface OrderService {

    boolean orderFood(User user, LocalDate dateOfCreatingOrder, double price);
}
