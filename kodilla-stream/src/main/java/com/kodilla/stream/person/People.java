package com.kodilla.stream.person;

import java.util.ArrayList;
import java.util.List;

public class People {

    public static List<String> getList() {
        final List<String> theList = new ArrayList<>();

        theList.add("John Smith");
        theList.add("John Wick");
        theList.add("Daniel Craig");
        theList.add("Lara Croft");
        theList.add("Nickolas Cage");
        theList.add("John Travolta");
        theList.add("Michael Jordan");
        theList.add("Kanye West");
        theList.add("Robert Downey JR");
        theList.add("Bruce Lee");

        return new ArrayList<>(theList);
    }
}
