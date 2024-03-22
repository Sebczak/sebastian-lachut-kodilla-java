package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.TaskFinancialDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface TaskFinancialDetailsDao extends CrudRepository<TaskFinancialDetails, Integer> {

    List<TaskFinancialDetails> findByPaid(boolean paid);
}
