package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.*;
import com.kodilla.good.patterns.challenges.buy.request.BuyRequest;
import com.kodilla.good.patterns.challenges.buy.request.BuyRequestRetriever;
import com.kodilla.good.patterns.challenges.information.service.MailService;
import com.kodilla.good.patterns.challenges.order.repository.GamesOrderRepository;
import com.kodilla.good.patterns.challenges.order.service.GamesOrderService;

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

        ProductOrderProcessor productOrderProcessor = new ProductOrderProcessor(
                 new MailService(), new GamesOrderService(), new GamesOrderRepository()
        );
        BuyRequestRetriever buyRequestRetriever = new BuyRequestRetriever();
        BuyRequest buyRequest = buyRequestRetriever.retrieve();
        productOrderProcessor.process(buyRequest);
    }
}