package com.ecoandrich.maycodingTest.HR.Job;

import com.ecoandrich.maycodingTest.HR.Employee.Entity.Employee;
import com.ecoandrich.maycodingTest.HR.Employee.Repository.EmployeeRepository;
import com.ecoandrich.maycodingTest.HR.Job.DTO.Response.JobHistoryResponse;
import com.ecoandrich.maycodingTest.HR.Job.Entity.JobHistory;
import com.ecoandrich.maycodingTest.HR.Job.Repository.JobHistoryRepository;
import com.ecoandrich.maycodingTest.HR.Job.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private final JobRepository repo;
    private final JobHistoryRepository historyRepo;
    private final EmployeeRepository employeeRepo;

    @Autowired
    JobService(JobRepository repo, JobHistoryRepository historyRepo, EmployeeRepository employeeRepo) {
        this.repo = repo;
        this.historyRepo = historyRepo;
        this.employeeRepo = employeeRepo;
    }

    @Transactional
    public JobHistoryResponse getHistory(long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        List<JobHistory> history = historyRepo.findAllByEmployeeId(id);

        if(employee.isEmpty()) throw new IllegalArgumentException();

        return JobHistoryResponse.toResponse(employee.get(), history);
    }
}
