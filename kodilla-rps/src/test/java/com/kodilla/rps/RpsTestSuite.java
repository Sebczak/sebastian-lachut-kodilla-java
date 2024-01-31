package com.kodilla.rps;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class RpsTestSuite {

    private final String[] choices = {null, "rock", "paper", "scissors", "lizard", "Spock"};

    @Test
    void testUserWins() {
        //Given
        Game game = new Game(1);
        Player p1 = new Player("TestPlayer");
        Player com = new Player("COM");
        game.playerScore = 0;
        game.computerScore = 0;

        //When
        p1.setChoice(1);
        com.setChoice(3);
        game.determineWinner(p1, com);

        //Then
        assertEquals(1, game.playerScore);
        assertEquals(0, game.computerScore);
    }

    @Test
    void testComWins() {
        //Given
        Game game = new Game(1);
        Player p1 = new Player("TestPlayer");
        Player com = new Player("COM");
        game.playerScore = 0;
        game.computerScore = 0;

        //When
        p1.setChoice(1);
        com.setChoice(5);
        game.determineWinner(p1, com);

        //Then
        assertEquals(0, game.playerScore);
        assertEquals(1, game.computerScore);
    }

    @Test
    void testTie() {
        //Given
        Game game = new Game(1);
        Player p1 = new Player("TestPlayer");
        Player com = new Player("COM");
        game.playerScore = 0;
        game.computerScore = 0;

        //When
        p1.setChoice(1);
        com.setChoice(1);
        game.determineWinner(p1, com);

        //Then
        assertEquals(0, game.playerScore);
        assertEquals(0, game.computerScore);
    }

    @Test
    void testUserInvalidChoice() {
        //Given
        Game game = new Game(1);
        Player p1 = new Player("TestPlayer");
        Player com = new Player("COM");
        game.playerScore = 0;
        game.computerScore = 0;

        //When
        p1.setChoice(6);
        com.setChoice(1);

        //Then
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            game.determineWinner(p1, com);
        });
    }

    @Test
    void testMultipleRounds() {
        //Given
        Game game = new Game(3);
        Player p1 = new Player("TestPlayer");
        Player com = new Player("COM");
        game.playerScore = 0;
        game.computerScore = 0;

        //When
        for (int i = 1; i < 3; i++) {
            p1.setChoice(i);
            com.getComputerChoice(com, choices);
            game.determineWinner(p1, com);
        }

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        game.displayGameSummary();

        assertFalse(outContent.toString().contains("Final Score: Player: 3 | Computer: 3"));
    }

    @Test
    void testGetPlayerChoice() {
        //Given
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Game game = new Game(1);
        Player p1 = new Player("TestPlayer");
        game.playerScore = 0;
        game.computerScore = 0;

        //When
        p1.getPlayerChoice1(p1);
        //Then
        assertEquals(2, p1.getChoice() );
    }

    @Test
    void testUserInput() {
        //Given
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Game game = new Game(1);
        Player p1 = new Player("TestPlayer");
        game.playerScore = 0;
        game.computerScore = 0;

        //When
        p1.getPlayerChoice1(p1);
        //Then
        assertEquals(2, p1.getChoice());
    }

    @Test
    void testUserInputNAnotherGame() {
        //Given
        Game game = new Game();
        String nInput = "n";

        //When
        game.playAnotherGameOrExit(nInput);

        //Then
        assertEquals(0, game.playerScore);
        assertEquals(0, game.computerScore);
    }

    @Test
    void testUserXInputAnotherGame() {
        //Given
        Game game = new Game();
        String xInput = "x";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //When
        game.playAnotherGameOrExit(xInput);
        System.setOut(System.out);

        //Then
        assertEquals("Thanks for playing.\n", outContent.toString());
    }

    @Test
    void testUserInvalidInputAnotherGame() {
        //Given
        Game game = new Game();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //When
        game.playAnotherGameOrExit("i");
        System.setOut(System.out);

        //Then
        assertEquals("Incorrect input\n", outContent.toString());
    }
}
