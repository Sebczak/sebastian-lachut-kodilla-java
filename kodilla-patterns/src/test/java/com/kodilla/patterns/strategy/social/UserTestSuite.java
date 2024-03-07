package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.FacebookPublisher;
import com.kodilla.patterns.strategy.social.publisher.SnapchatPublisher;
import com.kodilla.patterns.strategy.social.publisher.TwitterPublisher;
import com.kodilla.patterns.strategy.social.user.Millenials;
import com.kodilla.patterns.strategy.social.user.User;
import com.kodilla.patterns.strategy.social.user.YGeneration;
import com.kodilla.patterns.strategy.social.user.ZGeneration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserTestSuite {

    private User john;
    private User matt;
    private User ed;

    @BeforeEach
    public void setUp() {
         john = new Millenials("John");
         matt = new YGeneration("Matt");
         ed = new ZGeneration("Ed");
    }

    @Test
    void testDefaultPublisherForUsers() {
        //Given
        //When
        String johnPublishingPlatform = john.sharePost();
        String mattPublishingPlatform = matt.sharePost();
        String eddPublishingPlatform = ed.sharePost();
        //Then
        assertEquals("Share post in: Facebook", johnPublishingPlatform);
        assertEquals("Share post in: Twitter", mattPublishingPlatform);
        assertEquals("Share post in: Snapchat", eddPublishingPlatform);
    }

    @Test
    void testIndividualPublisherForUser() {
        //Given
        //When
        String johnPublishingPlatform = john.sharePost();

        assertEquals("Share post in: Facebook", johnPublishingPlatform);
    }

    @Test
    void testChangingPublishingPlatformByUser() {
        //Given
        //When
        john.setSocialPublisher(new TwitterPublisher());
        String newJohnPublishingPlatform = john.sharePost();

        //Then
        assertNotEquals("Share post in: Facebook","Share post in: Twitter");
        assertEquals("Share post in: Twitter", newJohnPublishingPlatform);
    }
}
