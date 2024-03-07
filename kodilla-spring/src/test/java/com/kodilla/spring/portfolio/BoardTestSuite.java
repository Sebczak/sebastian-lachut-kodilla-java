package com.kodilla.spring.portfolio;

import com.kodilla.spring.reader.Reader;
import com.kodilla.spring.reader.ReaderConfig;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BoardTestSuite {

    @Autowired
    private Board board;

    @Test
    @Order(1)
    void testEmptyList() {
        //Given

        //When
        String toDoListResult = board.getToDoList().toString();
        String inProgressListResult = board.getInProgressList().toString();
        String doneListResult = board.getDoneList().toString();

        //Then
        assertEquals("TaskList{tasks=[]}", toDoListResult);
        assertEquals("TaskList{tasks=[]}", inProgressListResult);
        assertEquals("TaskList{tasks=[]}", doneListResult);
    }

    @Test
    @Order(2)
    void testAddTaskToList() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        // When
        board.addStringToToDoList("Hello");
        board.addStringToInProgressList("World");
        board.addStringToDoneList("!");
        boolean toDoListExists = context.containsBean("toDoList");
        boolean inProgressListExists = context.containsBean("inProgressList");
        boolean doneListExists = context.containsBean("doneList");
        String toDoListResult = String.valueOf(board.getToDoList());
        String inProgressListResult = String.valueOf(board.getInProgressList());
        String doneListResult = String.valueOf(board.getDoneList());

        // Then
        assertTrue(toDoListExists);
        assertTrue(inProgressListExists);
        assertTrue(doneListExists);
        assertEquals("TaskList{tasks=[Hello]}",toDoListResult);
        assertEquals("TaskList{tasks=[World]}",inProgressListResult);
        assertEquals("TaskList{tasks=[!]}",doneListResult);
    }
}
