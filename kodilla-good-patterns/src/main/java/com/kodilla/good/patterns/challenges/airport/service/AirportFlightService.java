package com.kodilla.good.patterns.challenges.airport.service;

import com.kodilla.good.patterns.challenges.airport.flight.Flight;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    public List<Flight> findFlightsThroughCity(List<Flight> flights, String departureCity, String destinationCity) {
        List<Flight> flightsWithStops = new ArrayList<>();

        List<Flight> directFlights = flights.stream()
                .filter(flight -> flight.getDepartureCity().equals(departureCity) && flight.getDestinationCity().equals(destinationCity))
                .toList();

        if (!directFlights.isEmpty()) {
            flightsWithStops.addAll(directFlights);
        } else {
            flightsWithStops.addAll(findFlightsFromTheCity(flights, departureCity));
            flightsWithStops.addAll(findFlightsToCity(flights, destinationCity));

            Iterator<Flight> iterator = flightsWithStops.iterator();
            Flight previousFlight = null;

            while (iterator.hasNext()) {
                Flight currentFlight = iterator.next();

                if (previousFlight != null && !previousFlight.getDestinationCity().equals(currentFlight.getDepartureCity())) {
                    iterator.remove();
                }

                previousFlight = currentFlight;
            }

        }
        return flightsWithStops;
    }
}