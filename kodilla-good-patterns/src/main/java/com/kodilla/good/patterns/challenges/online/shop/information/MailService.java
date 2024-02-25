package com.kodilla.good.patterns.challenges.online.shop.information;

import com.kodilla.good.patterns.challenges.online.shop.user.User;

public class MailService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Hello, " + user.getFirstName() + " " + user.getLastName() + "." +
                "You got a mail notification for buying a game.");
    }
}
