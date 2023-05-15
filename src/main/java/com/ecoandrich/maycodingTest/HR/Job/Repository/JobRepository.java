package com.ecoandrich.maycodingTest.HR.Job.Repository;

import com.ecoandrich.maycodingTest.HR.Job.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, String> {
}
