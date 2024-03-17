package com.kodilla.sudoku;

import com.kodilla.input.Scanner;
import com.kodilla.messages.Messages;
import com.kodilla.output.ConsoleOut;

public class SudokuGame {
    private final SudokuBoard sudokuBoard = new SudokuBoard();
    private final Scanner scanner = new Scanner();
    private final ConsoleOut consoleOut;

    public SudokuGame() {
        this(new ConsoleOut());
    }

    public SudokuGame(ConsoleOut consoleOut) {
        this.consoleOut = consoleOut;
    }

    public boolean resolveSudoku() {
        boolean isGameFinished = false;

        while(!isGameFinished) {
//            ConsoleOut.println(Messages.COLUMN);
//            int col = scanner.nextInt() - 1;
//            ConsoleOut.println(Messages.ROW);
//            int row = scanner.nextInt() - 1;
//            ConsoleOut.println(Messages.VALUE);
//            int value = scanner.nextInt();
            System.out.println(sudokuBoard);
            sudokuBoard.setAndRemoveValueInList(1, 2, 8);
            sudokuBoard.setAndRemoveValueInList(0, 3, 2);
            sudokuBoard.setAndRemoveValueInList(0, 4, 6);
            sudokuBoard.setAndRemoveValueInList(0, 6, 7);
            sudokuBoard.setAndRemoveValueInList(0, 8, 1);
//            sudokuBoard.setAndRemoveValueInList(1, 4, 7);
//            sudokuBoard.setAndRemoveValueInList(1, 7, 9);
//            sudokuBoard.setAndRemoveValueInList(2, 0, 1);
//            sudokuBoard.setAndRemoveValueInList(2, 1, 9);
//            sudokuBoard.setAndRemoveValueInList(2, 5, 4);
//            sudokuBoard.setAndRemoveValueInList(2, 6, 5);
//            sudokuBoard.setAndRemoveValueInList(3, 0, 8);
//            sudokuBoard.setAndRemoveValueInList(3, 1, 2);
//            sudokuBoard.setAndRemoveValueInList(3, 3, 1);
//            sudokuBoard.setAndRemoveValueInList(3, 7, 4);
//            sudokuBoard.setAndRemoveValueInList(4, 2, 4);
//            sudokuBoard.setAndRemoveValueInList(4, 3, 6);
//            sudokuBoard.setAndRemoveValueInList(4, 5, 2);
//            sudokuBoard.setAndRemoveValueInList(4, 6, 9);
//            sudokuBoard.setAndRemoveValueInList(5, 1, 5);
//            sudokuBoard.setAndRemoveValueInList(5, 5, 3);
//            sudokuBoard.setAndRemoveValueInList(5, 7, 2);
//            sudokuBoard.setAndRemoveValueInList(5, 8, 8);
//            sudokuBoard.setAndRemoveValueInList(6, 2, 9);
//            sudokuBoard.setAndRemoveValueInList(6, 3, 3);
//            sudokuBoard.setAndRemoveValueInList(6, 7, 7);
//            sudokuBoard.setAndRemoveValueInList(6, 8, 4);
//            sudokuBoard.setAndRemoveValueInList(7, 1, 4);
//            sudokuBoard.setAndRemoveValueInList(7, 4, 5);
//            sudokuBoard.setAndRemoveValueInList(7, 7, 3);
//            sudokuBoard.setAndRemoveValueInList(7, 8, 6);
//            sudokuBoard.setAndRemoveValueInList(8, 0, 7);
//            sudokuBoard.setAndRemoveValueInList(8, 2, 3);
//            sudokuBoard.setAndRemoveValueInList(8, 4, 1);
//            sudokuBoard.setAndRemoveValueInList(8, 5, 8);
            isGameFinished = sudokuBoard.solveBoard();
            System.out.println(sudokuBoard);
        }
        return isGameFinished;
    }
}
