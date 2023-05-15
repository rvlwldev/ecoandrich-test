package com.ecoandrich.maycodingTest.HR.Employee;

import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.EmployeeDetailResponse;
import com.ecoandrich.maycodingTest.HR.Employee.Entity.Employee;
import com.ecoandrich.maycodingTest.HR.Employee.Repository.EmployeeViewRepository;
import com.ecoandrich.maycodingTest.HR.Employee.Repository.EmployeeRepository;
import com.ecoandrich.maycodingTest.HR.Employee.VO.EmployeeDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;
    private final EmployeeViewRepository viewRepo;

    @Autowired
    EmployeeService(EmployeeRepository repo, EmployeeViewRepository viewRepo) {
        this.repo = repo;
        this.viewRepo = viewRepo;
    }

    public EmployeeDetailResponse getEmployeeDetail(long id) {
        Optional<Employee> optionalEmployee = repo.findById(id);

        if (optionalEmployee.isEmpty()) throw new IllegalArgumentException();

        Employee employee = optionalEmployee.get();

        return EmployeeDetailResponse.toResponse(employee);
    }

    public Optional<EmployeeDetailVO> getEmployeeVO(long id) {
        return viewRepo.findById(id);
    }

}
