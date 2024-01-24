package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public String beautify(String b, PoemDecorator poemDecorator) {
        return poemDecorator.decorate(b);
    }
}
