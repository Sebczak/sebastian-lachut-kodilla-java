package com.kodilla.good.patterns.challenges.airport.service;

import com.kodilla.good.patterns.challenges.airport.flight.Flight;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AirportFlightService implements FlightService {
    @Override
    public List<Flight> findFlightsFromTheCity(List<Flight> flights, String departureCity) {
        return flights.stream()
                .filter(flight -> flight.getDepartureCity().equals(departureCity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> findFlightsToCity(List<Flight> flights, String destinationCity) {
        return flights.stream()
                .filter(flight -> flight.getDestinationCity().equals(destinationCity))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> findDirectAndThroughCityFlights(List<Flight> flights, String departureCity, String destinationCity) {
        List<Flight> flightsWithStops = new ArrayList<>();

        List<Flight> directFlights = flights.stream()
                .filter(flight -> flight.getDepartureCity().equals(departureCity) && flight.getDestinationCity().equals(destinationCity))
                .toList();

        List<Flight> withProperDestination = flights.stream()
                .filter(f -> f.getDestinationCity().equals(destinationCity))
                .toList();

        List<String> departures = flights.stream()
                .map(Flight::getDepartureCity)
                .toList();

        List<Flight> withProperDeparture = flights.stream()
                .filter(f -> f.getDepartureCity().equals(departureCity) && departures.contains(f.getDestinationCity()))
                .toList();


        List<String> destinations = flights.stream()
                .map(Flight::getDestinationCity)
                .toList();

        withProperDestination = withProperDestination.stream()
                .filter(f -> destinations.contains(f.getDepartureCity()))
                .toList();

        flightsWithStops.addAll(directFlights);
        flightsWithStops.addAll(withProperDeparture);
        flightsWithStops.addAll(withProperDestination);
        return flightsWithStops;
    }
}