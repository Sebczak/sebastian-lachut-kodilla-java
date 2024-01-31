package com.kodilla.rps;

import java.util.Scanner;

public class Game {
    private final String[] choices = {null, "rock", "paper", "scissors", "lizard", "Spock"};
    private int rounds;
    protected int playerScore = 0;
    protected int computerScore = 0;
    private final Scanner scanner = new Scanner(System.in);

    public Game(int rounds) {
        this.rounds = rounds;
    }

    public Game() {
    }

    public void play() {
        try {
            System.out.println("Enter amount of rounds");
            rounds = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter username");
            Player p1 = new Player(scanner.next());
            Player com = new Player("COM");

            while (rounds > 0) {
                p1.getPlayerChoice1(p1);
                com.getComputerChoice(com, choices);
                System.out.println(determineWinner(p1, com));
                rounds--;
            }
            System.out.println(displayGameSummary());

            System.out.println("Do you want to play another game? (Press 'n' for new game or 'x' to leave)");
            scanner.nextLine();
            playAnotherGameOrExit(scanner.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    protected String determineWinner(Player p1, Player com) {
        System.out.println(p1.getUsername() + " chose: " + choices[p1.getChoice()]);
        System.out.println(com.getUsername() + " chose: " + choices[com.getChoice()]);
        if (p1.getChoice() == com.getChoice()) {
            return "Tie\nScore: Player: " + playerScore + " | Computer: " +  computerScore;
        } else if (
                p1.getChoice() == 1 && com.getChoice() == 3 ||
                p1.getChoice() == 1 && com.getChoice() == 4 ||
                p1.getChoice() == 2 && com.getChoice() == 1 ||
                p1.getChoice() == 2 && com.getChoice() == 5 ||
                p1.getChoice() == 3 && com.getChoice() == 2 ||
                p1.getChoice() == 3 && com.getChoice() == 4 ||
                p1.getChoice() == 4 && com.getChoice() == 5 ||
                p1.getChoice() == 4 && com.getChoice() == 2 ||
                p1.getChoice() == 5 && com.getChoice() == 3 ||
                p1.getChoice() == 5 && com.getChoice() == 1 ){
                    playerScore++;
                    return "Player wins\nScore: Player: " + playerScore + " | Computer: " +  computerScore;
        } else {
            computerScore++;
            return "Computer wins\nScore: Player: " + playerScore + " | Computer: " +  computerScore;
        }
    }

    protected String displayGameSummary() {
        System.out.println("Game Summary:");

        if (playerScore > computerScore) {
            System.out.println("Player wins!");
        } else if (playerScore < computerScore) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("It's a tie!");
        }

        return "Final Score: Player: " + playerScore + " | Computer: " + computerScore;
    }

    protected void playAnotherGameOrExit(String userInput) {
        char c = userInput.toLowerCase().charAt(0);

        if (c == 'n') {
            resetGame();
            play();
        } else if (c == 'x') {
            System.out.println("Thanks for playing.");
        } else {
            System.out.println("Incorrect input");
            scanner.next();
        }
    }

    private void resetGame() {
        playerScore = 0;
        computerScore = 0;
    }
}
