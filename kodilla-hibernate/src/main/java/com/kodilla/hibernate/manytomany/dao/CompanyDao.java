package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query(nativeQuery = true)
    List<Company> findCompaniesUsingFirstThreeLetters(@Param("FIRSTTHREELETTERSOFCOMPANYNAME") String firstThreeLettersOfCompanyName);

    @Query
    List<Company> findCompaniesUsingThreeLetters(@Param("THREELETTERSOFCOMPANYNAME") String threeLettersOfCompanyName);
}
