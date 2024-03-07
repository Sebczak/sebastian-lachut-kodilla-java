package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTestSuite {

    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library("Library 1");

        IntStream.iterate( 1, i -> i + 1)
                .limit(5)
                .forEach(i -> library.getBooks().add(new Book("Book title " + i,"Author number " + i, LocalDate.now())));
    }

    @Test
    void testAdding5BooksToLibrary() {
        //Given
        //When
        int librarySize = library.getBooks().size();

        //Then
        assertEquals(5, librarySize);
    }

    @Test
    void testShallowCopyOfLibrary() {
        //Given
        Library shallowCopyOfLibrary = null;
        try {
            shallowCopyOfLibrary = library.shallowCopy();
            shallowCopyOfLibrary.setName("Library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //When

        Book firstBook = library.getBooks().stream()
                .findFirst()
                .orElse(null);

        library.getBooks().remove(firstBook);

        int librarySize = library.getBooks().size();
        int shallowCopyOfLibrarySize = shallowCopyOfLibrary.getBooks().size();

        assertEquals(4, librarySize);
        assertEquals(4, shallowCopyOfLibrarySize);
    }

    @Test
    void testDeepCopyOfLibrary() {
        //Given
        Library deepCopyOfLibrary = null;
        try {
            deepCopyOfLibrary = library.deepCopy();
            deepCopyOfLibrary.setName("Library 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //When
        Book firstBook = library.getBooks().stream()
                .findFirst()
                .orElse(null);

        library.getBooks().remove(firstBook);

        int librarySize = library.getBooks().size();
        int deepCopyOfLibrarySize = deepCopyOfLibrary.getBooks().size();
        //Then
        assertEquals(4, librarySize);
        assertEquals(5, deepCopyOfLibrarySize);

    }
}
