package com.kodilla.patterns.strategy.social.publisher;

public final class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Snapchat";
    }
}
