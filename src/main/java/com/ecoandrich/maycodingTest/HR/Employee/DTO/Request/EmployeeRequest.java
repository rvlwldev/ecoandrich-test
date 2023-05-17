package com.ecoandrich.maycodingTest.HR.Employee.DTO.Request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;
    private String jobId;
    private Double salary;
    private Double commissionPct;
    private Long managerId;
    private Long departmentId;
}
