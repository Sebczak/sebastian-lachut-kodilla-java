package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private final String[] choices = {null, "rock", "paper", "scissors", "lizard", "Spock"};
    private int rounds;
    private int playerScore = 0;
    private int computerScore = 0;

    public Game(int rounds) {
        this.rounds = rounds;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter username");
        Player p1 = new Player(scanner.nextLine());
        Player p2 = new Player("COM");

        while (rounds > 0) {
            getPlayerChoice(p1, scanner);
            getComputerChoice(p2, random);
            determineWinner(p1, p2);
            rounds--;
        }
        displayGameSummary();

        System.out.println("Do you want to play another game? (Press 'n' for new game or 'x' to leave)");

        char choice = scanner.next().toLowerCase().charAt(0);

        if (choice == 'n') {
            resetGame(scanner);
            play();
        } else if (choice == 'x') {
            System.out.println("Thanks for playing.");
        } else {
            System.out.println("Incorrect input");
            scanner.next();
        }
        scanner.close();

    }

    private void determineWinner(Player p1, Player p2) {
        System.out.println(p1.getUsername() + " chose: " + choices[p1.getChoice()]);
        System.out.println(p2.getUsername() + " chose: " + choices[p2.getChoice()]);
        if (p1.getChoice() == p2.getChoice()) {
            System.out.println("Tie");
            System.out.println("Score: Player: " + playerScore + " | Computer: " +  computerScore);
        } else if (p1.getChoice() == 1 && p2.getChoice() == 3 ||
                p1.getChoice() == 1 && p2.getChoice() == 4 ||
                p1.getChoice() == 2 && p2.getChoice() == 1 ||
                p1.getChoice() == 2 && p2.getChoice() == 5 ||
                p1.getChoice() == 3 && p2.getChoice() == 2 ||
                p1.getChoice() == 3 && p2.getChoice() == 4 ||
                p1.getChoice() == 4 && p2.getChoice() == 5 ||
                p1.getChoice() == 4 && p2.getChoice() == 2 ||
                p1.getChoice() == 5 && p2.getChoice() == 3 ||
                p1.getChoice() == 5 && p2.getChoice() == 1 ){
                    System.out.println("Player wins.");
                    playerScore++;
                    System.out.println("Score: Player: " + playerScore + " | Computer: " +  computerScore);
        } else {
            System.out.println("Computer wins");
            computerScore++;
            System.out.println("Score: Player: " + playerScore + " | Computer: " +  computerScore);
        }
    }

    private void displayGameSummary() {
        System.out.println("Game Summary:");

        if (playerScore > computerScore) {
            System.out.println("Player wins!");
        } else if (playerScore < computerScore) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("It's a tie!");
        }

        System.out.println("Final Score: Player: " + playerScore + " | Computer: " + computerScore);
    }

    private void getPlayerChoice(Player player, Scanner scanner) {
        System.out.println(player.getUsername() + ", enter your choice(rock, paper, scissors, lizard, Spock)");
        int playerChoice = scanner.nextInt();

        if (!(playerChoice >= 1 && playerChoice < choices.length)) {
            System.out.println("Invalid choice");
            playerChoice = scanner.nextInt();
        }
        player.setChoice(playerChoice);
    }

    private void getComputerChoice(Player player, Random random) {
        int rnd = random.nextInt(1, choices.length);
        player.setChoice(rnd);
    }

    private void resetGame(Scanner scanner) {
        playerScore = 0;
        computerScore = 0;
        System.out.println("Enter amount of rounds");
        rounds = scanner.nextInt();
    }
}
