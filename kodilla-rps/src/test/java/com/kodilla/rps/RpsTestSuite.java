package com.kodilla.rps;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class RpsTestSuite {

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
            game.getComputerChoice(com, new Random());
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
        game.getPlayerChoice(p1, new java.util.Scanner(System.in));
        //Then
        assertEquals(2, p1.getChoice() );
    }

    @Test
    void test() {
        //Given
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Game game = new Game(1);
        Player p1 = new Player("TestPlayer");
        game.playerScore = 0;
        game.computerScore = 0;

        //When
        game.getPlayerChoice(p1, new java.util.Scanner(System.in));
        //Then
        assertEquals(2, p1.getChoice());
    }
}
