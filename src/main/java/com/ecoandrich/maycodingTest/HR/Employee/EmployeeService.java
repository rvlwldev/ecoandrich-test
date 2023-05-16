package com.ecoandrich.maycodingTest.HR.Employee;

import com.ecoandrich.maycodingTest.HR.Department.Repository.DepartmentRepository;
import com.ecoandrich.maycodingTest.HR.Employee.DTO.Request.EmployeeRequest;
import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.EmployeeDetailResponse;
import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.JobHistory.JobHistoryResponse;
import com.ecoandrich.maycodingTest.HR.Employee.Entity.Employee;
import com.ecoandrich.maycodingTest.HR.Employee.Repository.EmployeeRepository;
import com.ecoandrich.maycodingTest.HR.Employee.Repository.EmployeeViewRepository;
import com.ecoandrich.maycodingTest.HR.Employee.Repository.JobHistoryRepository;
import com.ecoandrich.maycodingTest.HR.Employee.Repository.JobRepository;
import com.ecoandrich.maycodingTest.HR.Employee.SubEntity.JobHistory;
import com.ecoandrich.maycodingTest.HR.Employee.VO.EmployeeDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;
    private final EmployeeViewRepository viewRepo;
    private final JobHistoryRepository historyRepo;

    private final JobRepository jobRepo;
    private final DepartmentRepository departmentRepo;

    @Autowired
    EmployeeService(EmployeeRepository repo,
                    EmployeeViewRepository viewRepo,
                    JobHistoryRepository historyRepo,
                    JobRepository jobRepo,
                    DepartmentRepository departmentRepo) {
        this.repo = repo;
        this.viewRepo = viewRepo;
        this.historyRepo = historyRepo;
        this.jobRepo = jobRepo;
        this.departmentRepo = departmentRepo;
    }

    public EmployeeDetailResponse getEmployeeDetail(long id) {
        Optional<Employee> optionalEmployee = repo.findById(id);

        if (optionalEmployee.isEmpty()) throw new IllegalArgumentException();

        Employee employee = optionalEmployee.get();

        return EmployeeDetailResponse.toResponse(employee);
    }

    @Transactional
    public EmployeeDetailResponse updateEmployee(long id, EmployeeRequest request) {
        Employee employee = repo.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        employee = updateEmployeeRelation(employee, request);
        employee = updateEmployeeField(employee, request);

        return EmployeeDetailResponse.toResponse(employee);
    }

    private Employee updateEmployeeRelation(Employee employee, EmployeeRequest request) {
        if (request.getManagerId() != 0) employee.setManager_id(request.getManagerId());

        if (request.getJobId() != null) employee.setJob(jobRepo.findById(request.getJobId())
                .orElseThrow(IllegalArgumentException::new));

        if (request.getDepartmentId() != 0) employee.setDepartment(departmentRepo.findById(request.getDepartmentId())
                .orElseThrow(IllegalArgumentException::new));

        return employee;
    }

    private Employee updateEmployeeField(Employee employee, EmployeeRequest request) {
        if (request.getFirstName() != null) employee.setFirst_name(request.getFirstName());
        if (request.getLastName() != null) employee.setLast_name(request.getLastName());
        if (request.getEmail() != null) employee.setEmail(request.getEmail());
        if (request.getPhoneNumber() != null) employee.setPhone_number(request.getPhoneNumber());
        if (request.getHireDate() != null) employee.setHire_date(request.getHireDate());
        if (request.getSalary() != null) employee.setSalary(request.getSalary());
        if (request.getCommissionPercent() != null) employee.setCommission_pct(request.getCommissionPercent());

        return employee;
    }

    @Transactional
    public JobHistoryResponse getHistory(long id) {
        Optional<Employee> employee = repo.findById(id);
        if (employee.isEmpty()) throw new IllegalArgumentException();

        List<JobHistory> history = historyRepo.findAllByEmployeeId(id);
        if (history.isEmpty()) throw new IllegalArgumentException();

        return JobHistoryResponse.toResponse(employee.get(), history);
    }

    public Optional<EmployeeDetailVO> getEmployeeVO(long id) {
        return viewRepo.findById(id);
    }

}
