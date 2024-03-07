package com.kodilla.patterns.strategy.social.publisher;

public sealed interface SocialPublisher permits FacebookPublisher, TwitterPublisher, SnapchatPublisher {

    String share();
}
