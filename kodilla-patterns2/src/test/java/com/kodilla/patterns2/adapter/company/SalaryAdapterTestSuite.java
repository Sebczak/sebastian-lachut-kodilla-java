package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalaryAdapterTestSuite {

    @Test
    void testTotalSalary() {
        //Given
        Workers workers = new Workers();
        SalaryAdapter adapter = new SalaryAdapter();

        //When
        double totalSalary = adapter.totalSalary(workers.getWorkers(), workers.getSalaries());

        //Then
        assertEquals(27750, totalSalary);
    }
}
