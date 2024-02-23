package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.Factorial;
import com.kodilla.good.patterns.challenges.MovieStore;

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
    }
}