package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskFinancialDetailsDaoTestSuite {

    @Autowired
    private TaskFinancialDetailsDao taskFinancialDetailsDao;

    @Test
    void testFindByPaid() {
        //Given
        TaskFinancialDetails taskFinancialDetails = new TaskFinancialDetails(new BigDecimal(100), true);
        taskFinancialDetailsDao.save(taskFinancialDetails);
        int id = taskFinancialDetails.getId();

        //When
        List<TaskFinancialDetails> paidTasks = taskFinancialDetailsDao.findByPaid(true);

        //Then
        assertEquals(1, paidTasks.size());

        //Cleanup
        taskFinancialDetailsDao.deleteById(id);
    }
}
