package com.kodilla.testing.forum;

import com.kodilla.testing.forum.statistics.Statistics;
import com.kodilla.testing.forum.statistics.StatisticsCalculation;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@DisplayName("Statistics Test Suite")
@ExtendWith(MockitoExtension.class)
public class StatisticsTestSuite {

    @Mock
    private Statistics statisticsMock;
    private StatisticsCalculation statisticsCalculation;

    @BeforeEach
    void setUp() {
        statisticsCalculation = new StatisticsCalculation(statisticsMock);
        when(statisticsMock.usersNames()).thenReturn(List.of("userexample"));
    }

    @Nested
    @DisplayName("Tests for Posts")
    class TestPosts {

        @Test
        void testZeroPosts() {
            //Given
            when(statisticsMock.postsCount()).thenReturn(0);
            when(statisticsMock.usersNames()).thenReturn(List.of("user1"));


            //When
            statisticsCalculation.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0, statisticsCalculation.getPostsCount());
        }

        @Test
        void testThousandPosts() {
            //Given
            when(statisticsMock.postsCount()).thenReturn(1000);

            //When
            statisticsCalculation.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(1000, statisticsCalculation.getPostsCount());
        }
    }
    @Nested
    @DisplayName("Tests for Comments")
    class TestComments {

        @Test
        void testZeroComments() {
            //Given
            when(statisticsMock.commentsCount()).thenReturn(0);

            //When
            statisticsCalculation.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0, statisticsCalculation.getCommentsCount());
        }

        @Test
        void testThousandComments() {
            //Given
            when(statisticsMock.commentsCount()).thenReturn(1000);

            //When
            statisticsCalculation.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(1000, statisticsCalculation.getCommentsCount());
        }
        @Test
        void testCommentsLessThanPosts() {
            //Given
            when(statisticsMock.commentsCount()).thenReturn(5);
            when(statisticsMock.postsCount()).thenReturn(10);

            //When
            statisticsCalculation.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(5, statisticsCalculation.getCommentsCount());
            assertEquals(10, statisticsCalculation.getPostsCount());
            assertTrue(statisticsCalculation.getCommentsCount() < statisticsCalculation.getPostsCount());
        }

        @Test
        void testCommentsGreaterThanPosts() {
            //Given
            when(statisticsMock.commentsCount()).thenReturn(10);
            when(statisticsMock.postsCount()).thenReturn(4);

            //When
            statisticsCalculation.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(10, statisticsCalculation.getCommentsCount());
            assertEquals(4, statisticsCalculation.getPostsCount());
            assertTrue(statisticsCalculation.getCommentsCount() > statisticsCalculation.getPostsCount());
        }
    }
    @Nested
    @DisplayName("Test for Users")
    class TestUsers {

        @Test
        void testZeroUsers() {
            //Given
            when(statisticsMock.usersNames()).thenReturn(Collections.emptyList());

            //When
            statisticsCalculation.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(0, statisticsCalculation.getUsersCount());
        }

        @Test
        void testThousandUsers() {
            //Given
            List<String> userList = new ArrayList<>();
            for (int i = 1; i <= 1000; i++) {
                String user = "User" + i;
                userList.add(user);
            }
            when(statisticsMock.usersNames()).thenReturn(userList);

            //When
            statisticsCalculation.calculateAdvStatistics(statisticsMock);

            //Then
            assertEquals(1000, statisticsCalculation.getUsersCount());
        }
    }
}
