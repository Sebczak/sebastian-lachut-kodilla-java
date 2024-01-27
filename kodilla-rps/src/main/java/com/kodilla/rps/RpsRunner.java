package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount of rounds");
        int rounds = scanner.nextInt();
        Game game = new Game(rounds);
        game.play();

    }
}
