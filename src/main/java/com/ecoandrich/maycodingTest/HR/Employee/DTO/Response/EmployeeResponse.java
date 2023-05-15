package com.ecoandrich.maycodingTest.HR.Employee.DTO.Response;

import com.ecoandrich.maycodingTest.HR.Employee.Entity.Employee;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EmployeeResponse {
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    LocalDate hireDate;

    public static EmployeeResponse toResponse(Employee employee) {
        return EmployeeResponse.builder()
                .firstName(employee.getFirst_name())
                .lastName(employee.getLast_name())
                .email(employee.getEmail())
                .phoneNumber(employee.getPhone_number())
                .hireDate(employee.getHire_date())
                .build();
    }
}
