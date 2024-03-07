package com.kodilla.patterns.strategy.social.publisher;

public final class FacebookPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Facebook";
    }


}
