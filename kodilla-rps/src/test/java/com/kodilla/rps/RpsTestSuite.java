package com.kodilla.rps;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class RpsTestSuite {

    private Game game;
    private Player p1;
    private Player com;
    private final String[] choices = {"rock", "paper", "scissors", "lizard", "Spock"};

    @BeforeEach
    public void setUp() {
        game = new Game();
        p1 = new Player();
        com = new Player();
    }
    @Nested
    @DisplayName("Tests for checkWinner, getLosingMove and getWinningMove")
    class WinningPossibilities {

        @Test
        void testDetermineWinner() {
            //Given
            DetermineWinner determineWinner = new DetermineWinner(p1, com);

            //When
            String tieResult = determineWinner.checkWinner(choices,0,0);
            String playerLossResult = determineWinner.checkWinner(choices,0,1);
            String playerWinResult = determineWinner.checkWinner(choices,0,2);

            //Then
            assertEquals("It's a tie.", tieResult);
            assertEquals("Computer won a round", playerLossResult);
            assertEquals("Player won a round", playerWinResult);
        }
        
        @Test
        void testLosingMove() {
            //Given
            DetermineWinner determineWinner = new DetermineWinner(p1, com);

            //When
            int result = determineWinner.getLosingMove(choices, 2);

            //Then
            assertEquals(0, result);
        }

        @Test
        void testWinningMove() {
            //Given
            DetermineWinner determineWinner = new DetermineWinner(p1, com);

            //When
            int result = determineWinner.getWinningMove(choices, 2);

            //Then
            assertEquals(1, result);
        }
    }
    @Nested
    @DisplayName("Tests for user choices")
    class UserChoices {

        @Test
        void testUserChoiceRock() {

        }

        @Test
        void testUserChoicePaper() {

        }

        @Test
        void testUserChoiceScissors() {

        }

        @Test
        void testUserChoiceLizard() {

        }

        @Test
        void testUserChoiceSpock() {

        }
    }

    @Nested
    @DisplayName("Tests for com choices")
    class ComChoices {

        @Mock
        private Random randomNumber;
        @Test
        void testComTieChoice() {
            //Given
            MockitoAnnotations.openMocks(this);
            Player p1 = new Player();
            Player com = new Player();

            //When
            when(randomNumber.nextInt(100)).thenReturn(25);
            game.getComputerChoice(p1, com);

            //Then
            assertEquals(p1.getChoice(), com.getChoice());
        }

        @Test
        void testComLossChoice() {
            //Given
//            MockitoAnnotations.openMocks(this);
//            Player p1 = new Player();
//            Player com = new Player();
//            p1.setChoice(1);
//
//            //When
//            when(randomNumber.nextInt(100)).thenReturn(50);
//            game.getComputerChoice(p1, com);
//
//            //Then
//            assertNotEquals(p1.getChoice(), com.getChoice());
        }

        @Test
        void testComWinChoice() {
            //Given
//            MockitoAnnotations.openMocks(this);
//            Player p1 = new Player();
//            Player com = new Player();
//
//            //When
//            when(randomNumber.nextInt(100)).thenReturn(100);
//            game.getComputerChoice(p1, com);
//
//            //Then
//            assertNotEquals(p1.getChoice(), com.getChoice());
        }
    }

    @Nested
    @DisplayName("Other game method tests")
    class OtherGameTests {
        @Test
        void testGameSummary() {
            //Given
            Player p1 = new Player();
            Player com = new Player();

            //When
            p1.setScore(2);
            com.setScore(1);
            String result = "Final Score: Player: " + p1.getScore() + " | Computer: " + com.getScore();

            //Then
            assertEquals("Final Score: Player: 2 | Computer: 1", result);

        }

        @Test
        void testPlayAnotherGameOrExit() {


        }

        @Test
        void testGame() {

        }
    }
}
