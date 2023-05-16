package com.ecoandrich.maycodingTest.HR.Employee.Repository;

import com.ecoandrich.maycodingTest.HR.Employee.SubEntity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, String> {
}
