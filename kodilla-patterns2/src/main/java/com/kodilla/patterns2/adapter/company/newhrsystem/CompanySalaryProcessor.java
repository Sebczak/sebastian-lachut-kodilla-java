package com.kodilla.patterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;
import java.util.List;

public class CompanySalaryProcessor implements SalaryProcessor {
    @Override
    public BigDecimal calculateSalary(List<Employee> employees) {
        BigDecimal salary = BigDecimal.ZERO;
        return employees.stream()
                .map(employee -> employee.getBaseSalary().add(salary))
                .reduce(salary, BigDecimal::add);
    }
}
