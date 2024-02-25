package com.kodilla.good.patterns.challenges.food.online.distribution.user;

public class User {

    private String firstName;
    private String lastName;
    private int phoneNumber;

    public User(String firstName, String lastName, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
