package com.kodilla;

import com.kodilla.messages.Messages;
import com.kodilla.output.ConsoleOut;
import com.kodilla.sudoku.SudokuGame;

public class Main {
    public static void main(String[] args) {
        ConsoleOut consoleOut = new ConsoleOut();
        SudokuGame theGame = new SudokuGame();
        consoleOut.println(Messages.SUDOKU_START_MSG);
        theGame.resolveSudoku();
        consoleOut.println(Messages.SUDOKU_END_MSG);
    }
}