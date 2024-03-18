package com.kodilla;

import com.kodilla.sudoku.SudokuGame;

public class Main {
    public static void main(String[] args) {
        boolean gameFinished = false;
        SudokuGame theGame = new SudokuGame();
        theGame.resolveSudoku();

//        while (!gameFinished) {
//            gameFinished = theGame.resolveSudoku();
//        }
    }
}
