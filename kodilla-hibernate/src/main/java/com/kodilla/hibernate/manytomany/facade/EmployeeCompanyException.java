package com.kodilla.hibernate.manytomany.facade;

public class EmployeeCompanyException extends Exception {
    public static final String COMPANY_NOT_FOUND = "Company with %s letters not found";
    public static final String EMPLOYEE_NOT_FOUND = "Employee with %s letters not found";

    public EmployeeCompanyException(String message) {
        super(message);
    }
}
