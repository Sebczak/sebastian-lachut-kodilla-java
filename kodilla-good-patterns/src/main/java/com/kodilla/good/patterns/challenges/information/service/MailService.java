package com.kodilla.good.patterns.challenges.information.service;

import com.kodilla.good.patterns.challenges.User;
import com.kodilla.good.patterns.challenges.information.service.InformationService;

public class MailService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Hello, " + user.getFirstName() + " " + user.getLastName() + "." +
                "You got a mail notification for buying a game.");
    }
}
