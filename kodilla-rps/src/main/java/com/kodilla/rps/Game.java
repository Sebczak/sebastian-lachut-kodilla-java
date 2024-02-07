package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private final static String[] choices = {"rock", "paper", "scissors", "lizard", "Spock"};
    private final Player p1;
    private final Player com;
    private final Scanner scanner = new Scanner(System.in);
    private final Random randomNumber = new Random();
    private WinnerChecker winner;

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
            winner = new WinnerChecker();
            getPlayerChoice(p1);
            getComputerChoice(p1, com);
            String result = String.valueOf(winner.checkWinner(choices,p1,com));
            System.out.println(result);

            roundsLeft--;
        }

        System.out.println(displayGameSummary(p1, com));

        System.out.println("Do you want to play another game? (Press 'n' for new game or 'x' to leave)");
        scanner.nextLine();
        playAnotherGameOrExit(scanner.nextLine());

        scanner.close();
    }

    public void getPlayerChoice(Player p1) {
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
    }

    protected void getComputerChoice(Player p1, Player com) {
        int playerChoice = p1.getChoice();
        int rnd = randomNumber.nextInt(100);
        winner = new WinnerChecker();
        if ( rnd <= 25) {
            com.setChoice(playerChoice);
        } else if (rnd <= 50) {
            int comChoice = randomNumber.nextInt(5);
            com.setChoice(comChoice);

        } else {
            Figure playerFigure = winner.getFigureFromIndex(playerChoice);
            Figure comChoice;
            do {
                int randomIndex = randomNumber.nextInt(5);
                comChoice = winner.getFigureFromIndex(randomIndex);
            } while (playerFigure.checkIfsWinningAgainst(comChoice));
            System.out.println(comChoice);
            //
            //com.setChoice(winner.getFigureFromIndex(com.getChoice()));
        }
    }

    protected String displayGameSummary(Player p1, Player com) {
        System.out.println("Game Summary:");

        if (p1.getScore() > com.getScore()) {
            System.out.println("Player wins!");
        } else if (p1.getScore() < com.getScore()) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("It's a tie!");
        }
        Figure f = new Figure("f");
        System.out.println(f.getWinningAgainst());

        return "Final Score: Player: " + p1.getScore() + " | Computer: " + com.getScore();
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
