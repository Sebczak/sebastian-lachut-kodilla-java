package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    void shouldReturnLibraryAMedianFromLibraryB() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        MedianAdapter adapter = new MedianAdapter();
        bookSet.add(new Book("test1","test2", 2000 ,"test3"));
        bookSet.add(new Book("test4","test5", 1900 ,"test6"));
        bookSet.add(new Book("test7","test8", 2100 ,"test9"));

        //When
        int median = adapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(2000, median);
    }
}
