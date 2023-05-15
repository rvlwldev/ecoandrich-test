package com.ecoandrich.maycodingTest.HR.Department.DTO.Response;

import com.ecoandrich.maycodingTest.HR.Department.Entity.Department;
import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.EmployeeResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentResponse {

    String departmentName;
    EmployeeResponse manager;
    LocationResponse location;

    public static DepartmentResponse toResponse(Department department) {
        EmployeeResponse manager = EmployeeResponse.toResponse(department.getManager());
        LocationResponse location = LocationResponse.toResponse(department.getLocation());

        return DepartmentResponse.builder()
                .departmentName(department.getDepartment_name())
                .manager(manager)
                .location(location)
                .build();
    }

}
