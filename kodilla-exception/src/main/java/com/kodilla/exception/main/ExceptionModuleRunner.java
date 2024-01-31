package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;

public class ExceptionModuleRunner {

    public static void main(String[] args) {
        //FileReaderWithoutHandling = new FileReaderWithoutHandling();
        FileReader fileReader = new FileReader();
        try {
            //fileReaderWithoutHandling.readLine();
            fileReader.readFile("names.txt");

        } catch (FileReaderException e) {
            System.out.println("Problem while reading a file");
        }
    }
}
