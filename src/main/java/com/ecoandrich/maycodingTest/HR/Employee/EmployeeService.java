package com.ecoandrich.maycodingTest.HR.Employee;

import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.EmployeeDetailResponse;
import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.JobHistory.JobHistoryResponse;
import com.ecoandrich.maycodingTest.HR.Employee.Entity.Employee;
import com.ecoandrich.maycodingTest.HR.Employee.Repository.EmployeeViewRepository;
import com.ecoandrich.maycodingTest.HR.Employee.Repository.EmployeeRepository;
import com.ecoandrich.maycodingTest.HR.Employee.Repository.JobHistoryRepository;
import com.ecoandrich.maycodingTest.HR.Employee.SubEntity.JobHistory;
import com.ecoandrich.maycodingTest.HR.Employee.VO.EmployeeDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;
    private final EmployeeViewRepository viewRepo;
    private final JobHistoryRepository historyRepo;

    @Autowired
    EmployeeService(EmployeeRepository repo, EmployeeViewRepository viewRepo, JobHistoryRepository historyRepo) {
        this.repo = repo;
        this.viewRepo = viewRepo;
        this.historyRepo = historyRepo;
    }

    public EmployeeDetailResponse getEmployeeDetail(long id) {
        Optional<Employee> optionalEmployee = repo.findById(id);

        if (optionalEmployee.isEmpty()) throw new IllegalArgumentException();

        Employee employee = optionalEmployee.get();

        return EmployeeDetailResponse.toResponse(employee);
    }

    @Transactional
    public JobHistoryResponse getHistory(long id) {
        Optional<Employee> employee = repo.findById(id);
        if(employee.isEmpty()) throw new IllegalArgumentException();

        List<JobHistory> history = historyRepo.findAllByEmployeeId(id);
        if(history.isEmpty()) throw new IllegalArgumentException();

        return JobHistoryResponse.toResponse(employee.get(), history);
    }

    public Optional<EmployeeDetailVO> getEmployeeVO(long id) {
        return viewRepo.findById(id);
    }

}
