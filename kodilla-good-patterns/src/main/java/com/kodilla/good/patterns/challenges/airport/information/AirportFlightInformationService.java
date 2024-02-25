package com.kodilla.good.patterns.challenges.airport.information;

public class AirportFlightInformationService implements FlightInformationService{
    @Override
    public void inform() {
        System.out.println("Sending flight list");
    }
}
