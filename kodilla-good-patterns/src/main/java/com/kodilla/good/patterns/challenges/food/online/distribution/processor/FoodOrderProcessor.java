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
import com.kodilla.good.patterns.challenges.food.online.distribution.user.User;

import java.util.Map;


public class FoodOrderProcessor {

    private InformationService informationService;
    private Map<Integer, Company> mapOfCompanies;
    private FoodOrderRepository foodOrderRepository;
    private OrderService orderService;

    private ExtraFoodShopOrderRepository extraFoodShopOrderRepository = new ExtraFoodShopOrderRepository();
    private GlutenFreeShopOrderRepository glutenFreeShopOrderRepository = new GlutenFreeShopOrderRepository();
    private HealthyShopOrderRepository healthyShopOrderRepository = new HealthyShopOrderRepository();
    private ExtraFoodShopOrderService extraFoodShopOrderService = new ExtraFoodShopOrderService();
    private GlutenFreeShopOrderService glutenFreeShopOrderService = new GlutenFreeShopOrderService();
    private HealthyShopOrderService healthyShopOrderService = new HealthyShopOrderService();

    public FoodOrderProcessor(InformationService informationService, Map<Integer, Company> mapOfCompanies, OrderService orderService, FoodOrderRepository foodOrderRepository) {
        this.informationService = informationService;
        this.mapOfCompanies = mapOfCompanies;
        this.orderService = orderService;
        this.foodOrderRepository = foodOrderRepository;
    }

    public OrderDto process(OrderRequest orderRequest) {
        String requestedFood = orderRequest.getFood();

        for (Map.Entry<Integer, Company> entry : mapOfCompanies.entrySet()) {
            Company company = entry.getValue();

            if (companyHasRequestedFood(company, requestedFood)) {
                switch (company.getCompanyName()) {
                    case ExtraFoodShop.COMPANY_NAME:
                        return processOrder(extraFoodShopOrderRepository, extraFoodShopOrderService, orderRequest);
                    case GlutenFreeShop.COMPANY_NAME:
                        return processOrder(glutenFreeShopOrderRepository, glutenFreeShopOrderService, orderRequest);
                    case HealthyShop.COMPANY_NAME:
                        return processOrder(healthyShopOrderRepository, healthyShopOrderService, orderRequest);
                    // Add cases for other companies if needed
                }
            }
        }

        return new OrderDto(orderRequest.getUser(), false);
    }

    private boolean companyHasRequestedFood(Company company, String requestedFood) {
        return company.getProducts().stream()
                .anyMatch(product -> product.getName().equalsIgnoreCase(requestedFood));
    }

    private OrderDto processOrder(FoodOrderRepository repository, OrderService service, OrderRequest orderRequest) {
        boolean isOrdered = service.orderFood(orderRequest.getUser(), orderRequest.getDateOfPurchase(), orderRequest.getPrice());
        if (isOrdered) {
            informationService.inform(orderRequest.getUser());
            repository.createOrder(orderRequest.getUser(), orderRequest.getDateOfPurchase(), orderRequest.getPrice());
            return new OrderDto(orderRequest.getUser(), true);
        }
        return new OrderDto(orderRequest.getUser(), false);
    }
}
