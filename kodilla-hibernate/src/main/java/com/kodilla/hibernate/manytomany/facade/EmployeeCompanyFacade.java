package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeCompanyFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeCompanyFacade.class);
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    public EmployeeCompanyFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public void processEmployeeCompanySearch(CompanyDto company, EmployeeDto employee) throws EmployeeCompanyException {
        LOGGER.info("Finding employees by {} of lastname", employee.threeLettersOfEmployeeName());
        List<Employee> employees = employeeDao.findEmployeesUsingThreeLetters(employee.threeLettersOfEmployeeName());

        if (employees.isEmpty()) {
            LOGGER.info(EmployeeCompanyException.EMPLOYEE_NOT_FOUND);
        } else {
            System.out.println(employees);
            LOGGER.info("Finished searching the employee table. Found {} records", employees.size());
        }

        LOGGER.info("Finding companies by {} letters of company name", company.threeLettersOfCompanyName());
        List<Company> companies = companyDao.findCompaniesUsingThreeLetters(company.threeLettersOfCompanyName());

        if (companies.isEmpty()) {
            LOGGER.info(EmployeeCompanyException.COMPANY_NOT_FOUND);
        } else {
            System.out.println(companies);
            LOGGER.info("Finished searching the company table. Found {} records", companies.size());
        }
    }
}
