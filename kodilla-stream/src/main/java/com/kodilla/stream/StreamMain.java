package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Module 7.");
        SaySomething saySomething = new SaySomething();
        saySomething.say();

        Processor processor = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);

        Executor codeToExecute = () -> System.out.println("Example text 2");
        processor.execute(codeToExecute);

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        expressionExecutor.executeExpression(10, 5, (a,b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a,b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a,b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a,b) -> a / b);

        System.out.println("Calculating expressions with method references");

        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Witam z rana", (b) -> System.out.println(b.toUpperCase()));
        poemBeautifier.beautify("Witam z rana", (b) -> System.out.println(b + "ABC"));
        poemBeautifier.beautify("Witam z rana", (b) -> System.out.println("ABC" + b));
        poemBeautifier.beautify("Witam z rana", (b) -> {
            StringBuilder input = new StringBuilder();
            input.append(b);
            input.setLength(6);
            System.out.println(input.toString());
        });
        poemBeautifier.beautify("Witam z rana", (b) -> {
            StringBuilder input = new StringBuilder();
            input.append(b);
            System.out.println(input.reverse());
        });

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
