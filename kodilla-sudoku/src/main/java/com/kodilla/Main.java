package com.kodilla;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SudokuBoard sudokuBoard = new SudokuBoard();

        System.out.println(sudokuBoard);
        sudokuBoard.setValueInList(2,2,3);
        System.out.println(sudokuBoard);
    }
}
