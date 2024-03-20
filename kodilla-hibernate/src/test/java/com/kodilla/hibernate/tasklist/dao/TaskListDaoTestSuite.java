package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String LISTNAME = "1. Working on Hibernate";
    private static final String DESCRIPTION = "Hibernate Hibernate Hibernate";
    @Test
    void testTaskListDaoFindByListName() {
        //Given
        TaskList taskList = new TaskList(LISTNAME, DESCRIPTION);
        taskListDao.save(taskList);
        String listNameFromTaskList = taskList.getListName();

        //When
        List<TaskList> findTasksByListName = taskListDao.findByListName(listNameFromTaskList);

        //Then
        assertEquals(1, findTasksByListName.size());

        //Cleanup
        taskListDao.delete(taskList);


    }
}
