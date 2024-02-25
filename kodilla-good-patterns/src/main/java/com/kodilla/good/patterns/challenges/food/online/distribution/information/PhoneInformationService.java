package com.kodilla.good.patterns.challenges.food.online.distribution.information;

import com.kodilla.good.patterns.challenges.food.online.distribution.user.User;

public class PhoneInformationService implements InformationService{
    @Override
    public void inform(User user) {
        System.out.println("Phone number: " + user.getPhoneNumber() + "Sending message to: " + user.getFirstName() + " " +  user.getLastName());
    }
}
