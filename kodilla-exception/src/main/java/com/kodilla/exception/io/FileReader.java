package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public void readFile(final String fileName) throws FileReaderException{
        ClassLoader classLoader = getClass().getClassLoader();
        URI uri;

        try {
           uri = classLoader.getResource(fileName).toURI();
        } catch (NullPointerException | URISyntaxException e) {
            throw new FileReaderException();
        }

        try (Stream<String> fileLines = Files.lines(Path.of(uri))) {
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            throw new FileReaderException();
        }  finally {
            System.out.println("stop");
        }
    }
}
