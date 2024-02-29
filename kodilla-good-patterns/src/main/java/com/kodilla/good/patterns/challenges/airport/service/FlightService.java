package com.kodilla.good.patterns.challenges.airport.service;

import com.kodilla.good.patterns.challenges.airport.flight.Flight;

import java.util.List;

public interface FlightService {

    List<Flight> findFlightsFromTheCity(List<Flight> flights, String departureCity);
    List<Flight> findFlightsToCity(List<Flight> flights, String destinationCity);
    List<Flight> findDirectAndThroughCityFlights(List<Flight> flights, String departureCity, String destinationCity);
}
