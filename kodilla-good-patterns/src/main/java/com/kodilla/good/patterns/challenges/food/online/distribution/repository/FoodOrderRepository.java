package com.kodilla.good.patterns.challenges.food.online.distribution.repository;

import com.kodilla.good.patterns.challenges.food.online.distribution.request.OrderRequest;
import com.kodilla.good.patterns.challenges.food.online.distribution.user.User;

import java.time.LocalDate;

public interface FoodOrderRepository {

    boolean createOrder(OrderRequest orderRequest);
}
