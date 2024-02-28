package com.kodilla.rps;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.ByteArrayInputStream;
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
            WinnerChecker winnerChecker = new WinnerChecker();

            //When
            p1.setUsername("Player");
            com.setUsername("Computer");
            p1.setChoice(1);
            com.setChoice(1);
            String tieResult = String.valueOf(winnerChecker.checkWinner(choices,p1,com));
            p1.setChoice(1);
            com.setChoice(2);
            String playerLossResult = String.valueOf(winnerChecker.checkWinner(choices,p1,com));
            p1.setChoice(4);
            com.setChoice(0);
            String playerWinResult = String.valueOf(winnerChecker.checkWinner(choices,p1,com));

            //Then
            assertEquals("null", tieResult);
            assertEquals("Computer wins a round!", playerLossResult);
            //assertEquals("Player wins a round!", playerWinResult);
        }
        
//        @Test
//        void testLosingMove() {
//            //Given
//            WinnerChecker winnerChecker = new WinnerChecker();
//
//            //When
//            int result = winnerChecker.getLosingMove(choices, 2);
//
//            //Then
//            assertEquals(0, result);
//        }
//
//        @Test
//        void testWinningMove() {
//            //Given
//            WinnerChecker winnerChecker = new WinnerChecker();
//
//            //When
//            int result = winnerChecker.getWinningMove(choices, 2);
//
//            //Then
//            assertEquals(1, result);
//        }
    }
    @Nested
    @DisplayName("Tests for user choices")
    class UserChoices {

        @Test
        void testUserChoiceRock() {
            //Given
            String playerInput = "1";
            Player p1 = new Player();
            ByteArrayInputStream input = new ByteArrayInputStream(playerInput.getBytes());
            System.setIn(input);

            //When
            Game game = new Game();
            game.getPlayerChoice(p1);

            //Then
            assertEquals(0, p1.getChoice() );
        }

        @Test
        void testUserChoicePaper() {
            // Given
            String playerInput = "2";
            Player p1 = new Player();
            ByteArrayInputStream input = new ByteArrayInputStream(playerInput.getBytes());
            System.setIn(input);

            // When
            Game game = new Game();
            game.getPlayerChoice(p1);

            // Then
            assertEquals(1, p1.getChoice());
        }

        @Test
        void testUserChoiceScissors() {
            // Given
            String playerInput = "3";
            Player p1 = new Player();
            ByteArrayInputStream input = new ByteArrayInputStream(playerInput.getBytes());
            System.setIn(input);

            // When
            Game game = new Game();
            game.getPlayerChoice(p1);

            // Then
            assertEquals(2, p1.getChoice());
        }

        @Test
        void testUserChoiceLizard() {
            // Given
            String playerInput = "4";
            Player p1 = new Player();
            ByteArrayInputStream input = new ByteArrayInputStream(playerInput.getBytes());
            System.setIn(input);

            // When
            Game game = new Game();
            game.getPlayerChoice(p1);

            // Then
            assertEquals(3, p1.getChoice());
        }

        @Test
        void testUserChoiceSpock() {
            // Given
            String playerInput = "5";
            Player p1 = new Player();
            ByteArrayInputStream input = new ByteArrayInputStream(playerInput.getBytes());
            System.setIn(input);

            // When
            Game game = new Game();
            game.getPlayerChoice(p1);

            // Then
            assertEquals(4, p1.getChoice());
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
            game.getComputerChoice(com);

            //Then
            //assertEquals(p1.getChoice(), com.getChoice());
        }

        @Test
        void testComLossChoice() {
//            //Given
//            MockitoAnnotations.openMocks(this);
//            Player p1 = new Player();
//            Player com = new Player();
//            p1.setChoice(2);
//
//            //When
//            Game game = new Game();
//            when(randomNumber.nextInt(100)).thenReturn(50);
//            System.out.println(randomNumber.nextInt(100));
//            int comResult = game.getComputerChoice(p1, com);
//
//            //Then
//            assertEquals(1, comResult);
        }

        @Test
        void testComWinChoice() {
            //            //Given
//            MockitoAnnotations.openMocks(this);
//            Player p1 = new Player();
//            Player com = new Player();
//            p1.setChoice(2);
//
//            //When
//            Game game = new Game();
//            when(randomNumber.nextInt(100)).thenReturn(99);
//            System.out.println(randomNumber.nextInt(100));
//            int comResult = game.getComputerChoice(p1, com);
//
//            //Then
//            assertEquals(1, comResult);

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
            String expectedResult1 = game.displayGameSummary(p1, com);
            String result1 = "Final Score: Player: 2 | Computer: 1";

            p1.setScore(1);
            com.setScore(2);
            String expectedResult2 = game.displayGameSummary(p1, com);
            String result2 = "Final Score: Player: 1 | Computer: 2";

            p1.setScore(2);
            com.setScore(2);
            String expectedResult3 = game.displayGameSummary(p1, com);
            String result3 = "Final Score: Player: 2 | Computer: 2";

            //Then
            assertEquals(expectedResult1, result1);
            assertEquals(expectedResult2, result2);
            assertEquals(expectedResult3, result3);

        }

        @Test
        void testPlayAnotherGameOrExit() {
        }

        @Test
        void testGame() {

        }
    }
}
