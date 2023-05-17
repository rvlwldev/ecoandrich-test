package com.ecoandrich.maycodingTest.HR.Employee.DTO.Response;

import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Department.DepartmentWithManagerAndLocationResponse;
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

    private EmployeeResponse manager;
    DepartmentWithManagerAndLocationResponse department;

    public static EmployeeDetailResponse toResponse(Employee employee) {
        EmployeeDetailResponseBuilder builder = EmployeeDetailResponse.builder();

        employee.getDepartment()
                .ifPresent(department -> builder.department(DepartmentWithManagerAndLocationResponse.toResponse(department)));

        employee.getManager()
                .ifPresent(manager -> builder.manager(EmployeeResponse.toResponse(manager)));

        return builder
                .firstName(employee.getFirst_name())
                .lastName(employee.getLast_name())
                .jobTitle(employee.getJob().getJob_title())
                .salary(employee.getSalary())
                .commissionPct(employee.getCommission_pct())
                .build();
    }

}
