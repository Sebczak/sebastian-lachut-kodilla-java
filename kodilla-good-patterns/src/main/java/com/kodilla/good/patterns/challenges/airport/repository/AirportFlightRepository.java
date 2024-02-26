package com.kodilla.good.patterns.challenges.airport.repository;

import com.kodilla.good.patterns.challenges.airport.flight.Flight;

import java.util.ArrayList;
import java.util.List;

public class AirportFlightRepository implements FlightRepository{

    private List<Flight> flights;

    public AirportFlightRepository() {
        this.flights = new ArrayList<>();
    }
    @Override
    public List<Flight> initializeFlights() {
        flights.add(new Flight("Gdańsk", "Wrocław"));
        flights.add(new Flight("Kraków", "Wrocław"));
        flights.add(new Flight("Gdańsk", "Kraków"));
        flights.add(new Flight("Warszawa", "Gdańsk"));

        return flights;
    }

    public List<Flight> getFlights() {
        return new ArrayList<>(flights);
    }
}
