package com.kodilla.good.patterns.challenges.food.online.distribution.processor;

import com.kodilla.good.patterns.challenges.food.online.distribution.information.InformationService;
import com.kodilla.good.patterns.challenges.food.online.distribution.repository.FoodOrderRepository;
import com.kodilla.good.patterns.challenges.food.online.distribution.request.OrderDto;
import com.kodilla.good.patterns.challenges.food.online.distribution.request.OrderRequest;
import com.kodilla.good.patterns.challenges.food.online.distribution.service.OrderService;
import com.kodilla.good.patterns.challenges.food.online.distribution.user.User;


public class FoodOrderProcessor {

    private InformationService informationService;
    private OrderService orderService;
    private FoodOrderRepository foodOrderRepository;

    public FoodOrderProcessor(InformationService informationService, OrderService orderService, FoodOrderRepository foodOrderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.foodOrderRepository = foodOrderRepository;
    }

    public OrderDto process(OrderRequest orderRequest) {

        boolean isOrdered = orderService.orderFood(orderRequest.getUser(), orderRequest.getDateOfPurchase(),
                orderRequest.getPrice());
        if (isOrdered) {
            informationService.inform(orderRequest.getUser());
            foodOrderRepository.createOrder(orderRequest.getUser(), orderRequest.getDateOfPurchase(), orderRequest.getPrice());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
