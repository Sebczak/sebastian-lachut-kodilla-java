package com.kodilla.good.patterns.challenges.airport.service;

import com.kodilla.good.patterns.challenges.airport.flight.Flight;

import java.util.ArrayList;
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
    public List<Flight> findFlightsThroughCity(List<Flight> flights, String departureCity, String planeStopCity, String destinationCity) {
        List<Flight> flightsWithStops = new ArrayList<>();

        List<Flight> firstPartFlights = flights.stream()
                .filter(flight -> flight.getDepartureCity().equals(departureCity) && flight.getDestinationCity().equals(planeStopCity))
                .toList();

        for (Flight firstPartFlight : firstPartFlights) {
            List<Flight> secondPartFlights = flights.stream()
                    .filter(flight -> flight.getDepartureCity().equals(planeStopCity) && flight.getDestinationCity().equals(destinationCity))
                    .toList();

            for (Flight secondPartFlight : secondPartFlights) {

                flightsWithStops.add(firstPartFlight);
                flightsWithStops.add(secondPartFlight);
            }
        }

        return flightsWithStops;
    }
}
