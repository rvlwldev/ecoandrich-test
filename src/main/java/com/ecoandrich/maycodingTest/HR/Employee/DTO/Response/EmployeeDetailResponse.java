package com.ecoandrich.maycodingTest.HR.Employee.DTO.Response;

import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Department.DepartmentWithManagerAndLocationResponse;
import com.ecoandrich.maycodingTest.HR.Employee.Entity.Employee;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@ApiModel(value = "사원 상세 정보 결과")
@Data
@Builder
public class EmployeeDetailResponse {

    @ApiModelProperty(value = "이름")
    private String firstName;

    @ApiModelProperty(value = "성")
    private String lastName;


    @ApiModelProperty(value = "직무명")
    private String jobTitle;

    @ApiModelProperty(value = "급여")
    private double salary;

    @ApiModelProperty(value = "커미션 비율")
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
