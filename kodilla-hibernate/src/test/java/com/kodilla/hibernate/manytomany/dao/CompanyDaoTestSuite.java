package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.facade.CompanyDto;
import com.kodilla.hibernate.manytomany.facade.EmployeeCompanyException;
import com.kodilla.hibernate.manytomany.facade.EmployeeCompanyFacade;
import com.kodilla.hibernate.manytomany.facade.EmployeeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class CompanyDaoTestSuite {

    @Autowired
    private EmployeeCompanyFacade employeeCompanyFacade;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //Cleanup
        companyDao.deleteById(softwareMachineId);
        companyDao.deleteById(dataMaestersId);
        companyDao.deleteById(greyMatterId);
    }

    @Test
    void testFindEmployeeUsingLastname() {
        //Given

        //When
        List<Employee> employees = employeeDao.findEmployeesWithLastName("Smith");

        //Then
        assertEquals(1, employees.size());
    }

    @Test
    void testFindCompaniesUsingFirstThreeLettersOfCompany() {
        //Given

        //When
        List<Company> companies = companyDao.findCompaniesUsingFirstThreeLetters("Gre");

        //Then
        assertEquals(1, companies.size());
    }

    @Test
    void testFindEmployeeCompanyUsingThreeLetters() throws EmployeeCompanyException {
        //Given
        EmployeeDto employeeDto = new EmployeeDto("ith");
        CompanyDto companyDto = new CompanyDto("ata");
        //When
        employeeCompanyFacade.processEmployeeCompanySearch(companyDto, employeeDto);
    }
}
