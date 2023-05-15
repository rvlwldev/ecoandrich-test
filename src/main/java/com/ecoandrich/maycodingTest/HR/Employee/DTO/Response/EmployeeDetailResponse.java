package com.ecoandrich.maycodingTest.HR.Employee.DTO.Response;

import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.DepartmentResponse;
import com.ecoandrich.maycodingTest.HR.Employee.Entity.Employee;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDetailResponse {

    private String firstName;
    private String lastName;

    private String jobTitle;
    private double salary;
    private Double commissionPct;

    DepartmentResponse department;

    public static EmployeeDetailResponse toResponse(Employee employee) {

        DepartmentResponse department = DepartmentResponse.toResponse(employee.getDepartment());

        return EmployeeDetailResponse.builder()
                .firstName(employee.getFirst_name())
                .lastName(employee.getLast_name())
                .jobTitle(employee.getJob().getJob_title())
                .salary(employee.getSalary())
                .commissionPct(employee.getCommission_pct())
                .department(department)
                .build();
    }

}