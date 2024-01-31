package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Player {

    private String username;
    private int choice;
    private final Random randomNumber = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public Player(String username) {
        this.username = username;
    }

    public int getPlayerChoice1(Player p1) {
        System.out.println(p1.getUsername() + ", enter your choice(rock, paper, scissors, lizard, Spock)\"");
        p1.setChoice(scanner.nextInt());
        return p1.getChoice();
    }

    protected int getComputerChoice(Player com, String[] choices) {
        int rnd = randomNumber.nextInt(100) + 1;

        if (rnd <= 25) {
            com.setChoice(1);
        } else if (rnd <= 50) {
            com.setChoice(2);
        } else
            com.setChoice(randomNumber.nextInt(choices.length - 3) + 3);

        return com.getChoice();
    }

    public String getUsername() {
        return username;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }
}
