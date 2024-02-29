package com.kodilla.good.patterns.challenges.food.online.distribution.units;

import com.kodilla.good.patterns.challenges.food.online.distribution.information.InformationService;
import com.kodilla.good.patterns.challenges.food.online.distribution.repository.FoodOrderRepository;
import com.kodilla.good.patterns.challenges.food.online.distribution.service.OrderService;

public class Unit {

    private InformationService informationService;
    private FoodOrderRepository foodOrderRepository;
    private OrderService orderService;

    public Unit(InformationService informationService, FoodOrderRepository foodOrderRepository, OrderService orderService) {
        this.informationService = informationService;
        this.foodOrderRepository = foodOrderRepository;
        this.orderService = orderService;
    }

    public InformationService getInformationService() {
        return informationService;
    }

    public FoodOrderRepository getFoodOrderRepository() {
        return foodOrderRepository;
    }

    public OrderService getOrderService() {
        return orderService;
    }
}
