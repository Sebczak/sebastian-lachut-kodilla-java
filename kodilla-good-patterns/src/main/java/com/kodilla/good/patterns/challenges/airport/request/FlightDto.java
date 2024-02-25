package com.kodilla.good.patterns.challenges.airport.request;

import com.kodilla.good.patterns.challenges.airport.flight.Flight;

import java.util.List;

public class FlightDto {

    private List<Flight> directFlights;
    private List<Flight> returnFlights;
    private List<Flight> connectingFlights;

    public FlightDto(List<Flight> directFlights, List<Flight> returnFlights, List<Flight> connectingFlights) {
        this.directFlights = directFlights;
        this.returnFlights = returnFlights;
        this.connectingFlights = connectingFlights;
    }

    public List<Flight> getDirectFlights() {
        return directFlights;
    }

    public List<Flight> getReturnFlights() {
        return returnFlights;
    }

    public List<Flight> getConnectingFlights() {
        return connectingFlights;
    }
}
