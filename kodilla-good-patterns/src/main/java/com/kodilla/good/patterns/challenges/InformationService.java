package com.kodilla.good.patterns.challenges;

public class InformationService {

    public void inform(User user) {
        System.out.println("Hello, " + user.getFirstName() + " " + user.getLastName() + " a transaction for an item is being processed");
    }
}
