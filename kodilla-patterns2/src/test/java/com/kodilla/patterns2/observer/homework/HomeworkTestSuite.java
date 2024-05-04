package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeworkTestSuite {

    @Test
    void shouldTestHomeworkObserver() {
        //When
        Homework springHomework = new SpringHomework();
        Homework designPatternsHomework = new DesignPatternsHomework();
        Mentor mentor1 = new Mentor("Mentor 1");
        Mentor mentor2 = new Mentor("Mentor 2");
        springHomework.registerObserver(mentor1);
        springHomework.registerObserver(mentor2);
        designPatternsHomework.registerObserver(mentor1);

        //When
        springHomework.addHomework("Spring task 1");
        springHomework.addHomework("Spring task 2");
        springHomework.addHomework("Spring task 3");
        designPatternsHomework.addHomework("Design patterns task 1");
        designPatternsHomework.addHomework("Design patterns task 2");

        //Then
        assertEquals(5, mentor1.getHomeworkToCheck());
        assertEquals(3, mentor2.getHomeworkToCheck());
    }
}
