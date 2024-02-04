package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private final static String[] choices = {"rock", "paper", "scissors", "lizard", "Spock"};
    private final Player p1;
    private final Player com;
    private final Scanner scanner = new Scanner(System.in);
    private final Random randomNumber = new Random();
    private DetermineWinner winner;

    public Game() {
        this.p1 = new Player();
        this.com = new Player();
    }

    public void play() {
        System.out.println("Enter amount of rounds");
        int roundsLeft;

        while (true) {
            if (scanner.hasNextInt()) {
                roundsLeft = scanner.nextInt();
                if (roundsLeft > 0) {
                    break;
                } else {
                    System.out.println("Enter positive number");
                }
            } else {
                System.out.println("Type a number.");
                scanner.next();
            }
        }
        scanner.nextLine();

        System.out.println("Enter username");
        String playerUsername = scanner.nextLine();
        p1.setUsername(playerUsername);
        com.setUsername("COM");

        while (roundsLeft > 0) {
            int playerInput = getPlayerChoice(p1);
            int comInput = getComputerChoice(p1, com);

            winner = new DetermineWinner(p1, com);
            String result = winner.checkWinner(choices, playerInput, comInput);
            System.out.println(result);

            roundsLeft--;
        }
        int playerScore = p1.getScore();
        int comScore = com.getScore();
        System.out.println(displayGameSummary(playerScore, comScore));

        System.out.println("Do you want to play another game? (Press 'n' for new game or 'x' to leave)");
        scanner.nextLine();
        playAnotherGameOrExit(scanner.nextLine());

        scanner.close();
    }

    public int getPlayerChoice(Player p1) {
        System.out.println(p1.getUsername() + ", enter your choice(rock, paper, scissors, lizard, Spock)");
        int playerChoice;
        while (true) {
            if (scanner.hasNextInt()) {
                playerChoice = scanner.nextInt();
                if (playerChoice <= choices.length) {
                    break;
                } else {
                    System.out.println("You chose wrong number.");
                }
            } else {
                System.out.println("Type a number.");
                scanner.next();
            }
        }
        p1.setChoice(playerChoice - 1);
        return playerChoice - 1;
    }

    protected int getComputerChoice(Player p1, Player com) {
        int playerChoice = p1.getChoice();
        int rnd = randomNumber.nextInt(100);
        winner = new DetermineWinner(p1, com);
        if ( rnd <= 25) {
            com.setChoice(playerChoice);
        } else if (rnd <= 50) {

            com.setChoice(winner.getLosingMove(choices, playerChoice));
        } else {
            com.setChoice(winner.getWinningMove(choices, playerChoice));
        }

        return com.getChoice();
    }

    protected String displayGameSummary(int playerScore, int comScore) {
        System.out.println("Game Summary:");

        if (playerScore > comScore) {
            System.out.println("Player wins!");
        } else if (playerScore < comScore) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("It's a tie!");
        }

        return "Final Score: Player: " + playerScore + " | Computer: " + comScore;
    }

    protected void playAnotherGameOrExit(String userInput) {
        char c;

        while (true) {
            if (userInput.length() == 1) {
                c = userInput.toLowerCase().charAt(0);

                if (c == 'n') {
                    resetGame();
                    play();
                    break;
                } else if (c == 'x') {
                    System.out.println("Thanks for playing.");
                    break;
                } else {
                    System.out.println("Incorrect input. Enter 'n' for a new game or 'x' to leave.");
                }
            } else {
                System.out.println("Invalid input. Enter a single character ('n' or 'x').");
            }

            userInput = scanner.nextLine();
        }
    }

    private void resetGame() {
        p1.setScore(0);
        com.setScore(0);
    }
}
