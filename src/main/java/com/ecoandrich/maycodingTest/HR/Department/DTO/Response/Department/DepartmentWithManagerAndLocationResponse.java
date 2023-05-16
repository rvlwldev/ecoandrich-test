package com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Department;

import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Location.LocationResponse;
import com.ecoandrich.maycodingTest.HR.Department.Entity.Department;
import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.EmployeeResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentWithManagerAndLocationResponse {

    private String departmentName;
    private EmployeeResponse manager;
    private LocationResponse location;

    public static DepartmentWithManagerAndLocationResponse toResponse(Department department) {
        EmployeeResponse manager = EmployeeResponse.toResponse(department.getManager());
        LocationResponse location = LocationResponse.toResponse(department.getLocation());

        return DepartmentWithManagerAndLocationResponse.builder()
                .departmentName(department.getDepartment_name())
                .manager(manager)
                .location(location)
                .build();
    }

}
