package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.*;
import com.kodilla.good.patterns.challenges.airport.information.AirportFlightInformationService;
import com.kodilla.good.patterns.challenges.airport.processor.FlightProcessor;
import com.kodilla.good.patterns.challenges.airport.repository.AirportFlightRepository;
import com.kodilla.good.patterns.challenges.airport.request.FlightRequest;
import com.kodilla.good.patterns.challenges.airport.request.FlightRequestRetriever;
import com.kodilla.good.patterns.challenges.airport.service.AirportFlightService;
import com.kodilla.good.patterns.challenges.food.online.distribution.information.PhoneInformationService;
import com.kodilla.good.patterns.challenges.food.online.distribution.processor.FoodOrderProcessor;
import com.kodilla.good.patterns.challenges.food.online.distribution.repository.Companies;
import com.kodilla.good.patterns.challenges.food.online.distribution.repository.ExtraFoodShopOrderRepository;
import com.kodilla.good.patterns.challenges.food.online.distribution.request.OrderRequest;
import com.kodilla.good.patterns.challenges.food.online.distribution.request.OrderRequestRetriever;
import com.kodilla.good.patterns.challenges.food.online.distribution.service.ExtraFoodShopOrderService;
import com.kodilla.good.patterns.challenges.food.online.distribution.units.MapOfUnits;
import com.kodilla.good.patterns.challenges.food.online.distribution.units.Unit;
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
        Companies companies = new Companies();

        System.out.println("================");
        MapOfUnits mapOfUnits = new MapOfUnits();
        FoodOrderProcessor foodOrderProcessor = new FoodOrderProcessor(mapOfUnits.mapOfCompanyUnits);
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieveData();
        foodOrderProcessor.processUnit(orderRequest);
        foodOrderProcessor.process(orderRequest);

        System.out.println("================");

        FlightProcessor flightProcessor = new FlightProcessor(
                new AirportFlightInformationService(), new AirportFlightService(), new AirportFlightRepository()
        );

        FlightRequestRetriever flightRequestRetriever = new FlightRequestRetriever();
        FlightRequest flightRequest = flightRequestRetriever.retrieveData();
        flightProcessor.checkFlight(flightRequest);
    }
}