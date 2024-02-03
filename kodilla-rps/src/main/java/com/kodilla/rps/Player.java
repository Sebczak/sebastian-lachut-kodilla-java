package com.kodilla.rps;

public class Player {

    private String username;
    private int choice;
    private int score = 0;

    public Player() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public int getScore() {
        return score;
    }
    public void incrementScore() {
        this.score++;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
