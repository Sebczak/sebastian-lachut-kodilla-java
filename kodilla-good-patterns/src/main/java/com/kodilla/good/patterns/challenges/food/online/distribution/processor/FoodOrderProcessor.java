package com.kodilla.good.patterns.challenges.food.online.distribution.processor;

import com.kodilla.good.patterns.challenges.food.online.distribution.company.Company;
import com.kodilla.good.patterns.challenges.food.online.distribution.company.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.food.online.distribution.company.GlutenFreeShop;
import com.kodilla.good.patterns.challenges.food.online.distribution.company.HealthyShop;
import com.kodilla.good.patterns.challenges.food.online.distribution.information.InformationService;
import com.kodilla.good.patterns.challenges.food.online.distribution.repository.ExtraFoodShopOrderRepository;
import com.kodilla.good.patterns.challenges.food.online.distribution.repository.FoodOrderRepository;
import com.kodilla.good.patterns.challenges.food.online.distribution.repository.GlutenFreeShopOrderRepository;
import com.kodilla.good.patterns.challenges.food.online.distribution.repository.HealthyShopOrderRepository;
import com.kodilla.good.patterns.challenges.food.online.distribution.request.OrderDto;
import com.kodilla.good.patterns.challenges.food.online.distribution.request.OrderRequest;
import com.kodilla.good.patterns.challenges.food.online.distribution.service.ExtraFoodShopOrderService;
import com.kodilla.good.patterns.challenges.food.online.distribution.service.GlutenFreeShopOrderService;
import com.kodilla.good.patterns.challenges.food.online.distribution.service.HealthyShopOrderService;
import com.kodilla.good.patterns.challenges.food.online.distribution.service.OrderService;
import com.kodilla.good.patterns.challenges.food.online.distribution.units.MapOfUnits;
import com.kodilla.good.patterns.challenges.food.online.distribution.units.Unit;
import com.kodilla.good.patterns.challenges.food.online.distribution.user.User;

import java.util.Map;


public class FoodOrderProcessor {

    private Map<String, Unit> mapOfUnits;

    public FoodOrderProcessor(Map<String, Unit> mapOfUnits) {
        this.mapOfUnits = mapOfUnits;
    }

    public Unit processUnit(OrderRequest orderRequest) {
        String companyName = orderRequest.getCompanyName();

        if (mapOfUnits.containsKey(companyName)) {
            Unit unit = mapOfUnits.get(companyName);


            return mapOfUnits.get(companyName);
        } else {
            return null;
        }
    }

    public OrderDto process(OrderRequest orderRequest) {
        Unit unit = processUnit(orderRequest);

        boolean isBought = unit.getOrderService().orderFood(orderRequest.getUser(), orderRequest.getDateOfPurchase(), orderRequest.getPrice());
        if (isBought) {
            unit.getInformationService().inform(orderRequest.getUser());
            unit.getFoodOrderRepository().createOrder(orderRequest);
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}

