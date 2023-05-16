package com.ecoandrich.maycodingTest.HR.Department;

import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Department.DepartmentWithManagerAndLocationResponse;
import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Location.LocationWithDepartmentNamesResponse;
import com.ecoandrich.maycodingTest.HR.Department.Entity.Department;
import com.ecoandrich.maycodingTest.HR.Department.Repository.DepartmentRepository;
import com.ecoandrich.maycodingTest.HR.Department.Repository.LocationRepository;
import com.ecoandrich.maycodingTest.HR.Department.SubEntity.Location;
import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.EmployeeResponse;
import com.ecoandrich.maycodingTest.HR.Employee.Entity.Employee;
import com.ecoandrich.maycodingTest.HR.Employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository repo;
    private final LocationRepository locationRepo;
    private final EmployeeRepository employeeRepo;

    @Autowired
    DepartmentService(DepartmentRepository repo, LocationRepository locationRepo, EmployeeRepository employeeRepo) {
        this.repo = repo;
        this.locationRepo = locationRepo;
        this.employeeRepo = employeeRepo;
    }

    public DepartmentWithManagerAndLocationResponse getDepartment(long id) {
        Optional<Department> department = repo.findById(id);

        if (department.isEmpty()) throw new IllegalArgumentException();

        return DepartmentWithManagerAndLocationResponse.toResponse(department.get());
    }

    public LocationWithDepartmentNamesResponse getLocationWithDepartmentNames(long id) {
        Optional<Location> location = locationRepo.findById(id);

        if (location.isEmpty()) throw new IllegalArgumentException();

        return LocationWithDepartmentNamesResponse.toResponse(location.get());
    }

    @Transactional
    public List<EmployeeResponse> increaseSalaryForAllEmployeesInDepartment(long id, double increasePercent) {
        Optional<Department> department = repo.findById(id);
        if(department.isEmpty()) throw new IllegalArgumentException();

        List<Employee> employees = employeeRepo.findAllByDepartment(department.get());
        if(employees.isEmpty()) throw new IllegalArgumentException();

        if(increasePercent >= 1) increasePercent = increasePercent / 100;
        for (Employee employee : employees) employee.increaseSalaryByPercent(increasePercent);

        return employees.stream()
                .map(EmployeeResponse::toResponse)
                .collect(Collectors.toList());
    }

}
