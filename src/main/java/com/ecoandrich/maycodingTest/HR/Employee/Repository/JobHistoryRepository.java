package com.ecoandrich.maycodingTest.HR.Employee.Repository;

import com.ecoandrich.maycodingTest.HR.Employee.SubEntity.ID.HistoryID;
import com.ecoandrich.maycodingTest.HR.Employee.SubEntity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobHistoryRepository extends JpaRepository<JobHistory, HistoryID> {

    List<JobHistory> findAllByEmployeeId(long id);
}
