package com.kodilla;

import com.kodilla.input.Scanner;
import com.kodilla.messages.Messages;
import com.kodilla.output.ConsoleOut;
import com.kodilla.sudoku.SudokuGame;

public class Main {
    public static void main(String[] args) {
        boolean gameFinished = false;
        SudokuGame theGame = new SudokuGame();

        Scanner scanner = new Scanner();

        ConsoleOut.println(Messages.SUDOKU_START_MSG);

        while (!gameFinished) {
            theGame.resolveSudoku();
            ConsoleOut.println(Messages.ASK_FOR_PLAY_AGAIN);
            String playerChoiceForPlayAgain = scanner.nextLine();
            if (playerChoiceForPlayAgain.equals("Yes")) {
            } else {
                gameFinished = true;
                ConsoleOut.println(Messages.SUDOKU_END_MSG);
            }
        }
    }
}