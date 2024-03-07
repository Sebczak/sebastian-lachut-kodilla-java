package com.kodilla.patterns.strategy.social.user;

import com.kodilla.patterns.strategy.customer.Customer;
import com.kodilla.patterns.strategy.social.publisher.FacebookPublisher;
import com.kodilla.patterns.strategy.social.publisher.SocialPublisher;

public class Millenials extends User {

    public Millenials(String name) {
        super(name);
        this.socialPublisher = new FacebookPublisher();
    }


}
