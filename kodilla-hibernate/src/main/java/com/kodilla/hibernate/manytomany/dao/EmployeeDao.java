package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query
    List<Employee> findEmployeesWithLastName(@Param("LASTNAME") String lastname);

    @Query
    List<Employee> findEmployeesUsingThreeLetters(@Param("THREELETTERSOFLASTNAME") String threeLettersOfCompanyName);
}
