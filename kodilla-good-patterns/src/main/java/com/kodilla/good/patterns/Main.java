package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
                 new InformationService(), new OrderService(), new ProductOrderRepository()
        );
        BuyRequestRetriever buyRequestRetriever = new BuyRequestRetriever();
        BuyRequest buyRequest = buyRequestRetriever.retrieve();
        productOrderProcessor.process(buyRequest);
    }
}