package com.ecoandrich.maycodingTest.HR.Job.Repository;

import com.ecoandrich.maycodingTest.HR.Job.Entity.ID.HistoryID;
import com.ecoandrich.maycodingTest.HR.Job.Entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobHistoryRepository extends JpaRepository<JobHistory, HistoryID> {

    List<JobHistory> findAllByEmployeeId(long id);
}
