package com.kodilla.rps;

import java.util.Scanner;

public class Player {

    private String username;
    private int choice;

    public Player(String username) {
        this.username = username;
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
