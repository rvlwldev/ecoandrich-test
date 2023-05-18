package com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Department;

import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Location.LocationResponse;
import com.ecoandrich.maycodingTest.HR.Department.Entity.Department;
import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.EmployeeResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@ApiModel(value = "부서 정보 조회 결과")
@Data
@Builder
public class DepartmentWithManagerAndLocationResponse {

    @ApiModelProperty(value = "부서명")
    private String departmentName;
    private EmployeeResponse manager;
    private LocationResponse location;

    public static DepartmentWithManagerAndLocationResponse toResponse(Department department) {
        DepartmentWithManagerAndLocationResponseBuilder builder = builder();

        department.getManager()
                .ifPresent(manager -> builder.manager(EmployeeResponse.toResponse(manager)));

        department.getLocation()
                .ifPresent(location -> builder.location(LocationResponse.toResponse(location)));

        return builder
                .departmentName(department.getDepartment_name())
                .build();
    }

}
