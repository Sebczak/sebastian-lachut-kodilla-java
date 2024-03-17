package com.kodilla.input;

public class Scanner {

    private static final java.util.Scanner defaultScanner = new java.util.Scanner(System.in);

    public String nextLine() {
        return defaultScanner.nextLine();
    }

    public Integer nextInt() {return defaultScanner.nextInt();}
}
