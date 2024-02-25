package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.*;
import com.kodilla.good.patterns.challenges.food.online.distribution.information.PhoneInformationService;
import com.kodilla.good.patterns.challenges.food.online.distribution.processor.FoodOrderProcessor;
import com.kodilla.good.patterns.challenges.food.online.distribution.repository.Companies;
import com.kodilla.good.patterns.challenges.food.online.distribution.repository.ExtraFoodShopOrderRepository;
import com.kodilla.good.patterns.challenges.food.online.distribution.request.OrderRequest;
import com.kodilla.good.patterns.challenges.food.online.distribution.request.OrderRequestRetriever;
import com.kodilla.good.patterns.challenges.food.online.distribution.service.ExtraFoodShopOrderService;
import com.kodilla.good.patterns.challenges.food.online.distribution.user.User;
import com.kodilla.good.patterns.challenges.online.shop.service.order.ProductOrderProcessor;
import com.kodilla.good.patterns.challenges.online.shop.request.BuyRequest;
import com.kodilla.good.patterns.challenges.online.shop.request.BuyRequestRetriever;
import com.kodilla.good.patterns.challenges.online.shop.information.MailService;
import com.kodilla.good.patterns.challenges.online.shop.order.repository.GamesOrderRepository;
import com.kodilla.good.patterns.challenges.online.shop.order.service.GamesOrderService;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        Factorial factorial = new Factorial();

        System.out.println(factorial.factorialCalculator(6));


        List<String> moviesWithExclamationMarkAtTheEnd = movieStore.getMovies().values().stream()
                .flatMap(List::stream)
                .map( m -> m + "!")
                .toList();

        System.out.println(moviesWithExclamationMarkAtTheEnd);
        System.out.println("================");

        ProductOrderProcessor productOrderProcessor = new ProductOrderProcessor(
                 new MailService(), new GamesOrderService(), new GamesOrderRepository()
        );
        BuyRequestRetriever buyRequestRetriever = new BuyRequestRetriever();
        BuyRequest buyRequest = buyRequestRetriever.retrieve();
        productOrderProcessor.process(buyRequest);

        System.out.println("================");

        FoodOrderProcessor foodOrderProcessor = new FoodOrderProcessor(
                new PhoneInformationService(), new ExtraFoodShopOrderService(), new ExtraFoodShopOrderRepository()
        );
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieveData();
        foodOrderProcessor.process(orderRequest);
    }
}