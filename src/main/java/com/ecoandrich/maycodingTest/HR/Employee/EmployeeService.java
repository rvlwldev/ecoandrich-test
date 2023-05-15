package com.ecoandrich.maycodingTest.HR.Employee;

import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.EmployeeDetailResponse;
import com.ecoandrich.maycodingTest.HR.Employee.Entity.Employee;
import com.ecoandrich.maycodingTest.HR.Employee.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public EmployeeDetailResponse getEmployeeDetail(long id) {
        Optional<Employee> optionalEmployee = repo.findById(id);

        if (optionalEmployee.isEmpty()) throw new IllegalArgumentException();

        Employee employee = optionalEmployee.get();

        return EmployeeDetailResponse.toResponse(employee);
    }

}
