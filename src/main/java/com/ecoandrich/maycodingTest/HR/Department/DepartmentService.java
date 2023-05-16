package com.ecoandrich.maycodingTest.HR.Department;

import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.DepartmentResponse;
import com.ecoandrich.maycodingTest.HR.Department.Entity.Department;
import com.ecoandrich.maycodingTest.HR.Department.Repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository repo;

    DepartmentService(DepartmentRepository repo) {
        this.repo = repo;
    }

    public DepartmentResponse getDepartment(long id) {
        Optional<Department> department = repo.findById(id);

        if (department.isEmpty()) throw new IllegalArgumentException();

        return DepartmentResponse.toResponse(department.get());
    }

}
