package com.kodilla.hibernate.manytomany;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "Company.findCompaniesUsingFirstThreeLetters",
        query = "SELECT * FROM companies WHERE LEFT(company_name, 3) = :FIRSTTHREELETTERSOFCOMPANYNAME",
        resultClass = Company.class
)

@Entity
@Table(name = "companies")
public class Company {

    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "company_id", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Column(name = "company_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
