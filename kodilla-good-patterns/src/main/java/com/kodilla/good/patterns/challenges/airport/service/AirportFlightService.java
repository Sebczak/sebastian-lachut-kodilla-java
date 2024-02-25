package com.kodilla.good.patterns.challenges.airport.service;

import com.kodilla.good.patterns.challenges.airport.flight.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class AirportFlightService implements FlightService{
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
    public List<Flight> findFlightsThroughCity(List<Flight> flights, String departureCity, String destinationCity) {
        return flights.stream()
                .filter(flight -> flight.getDepartureCity().equals(departureCity))
                .filter(flight -> flight.getDestinationCity().equals(destinationCity))
                .collect(Collectors.toList());
    }
}
