package com.ecoandrich.maycodingTest.HR.Employee.DTO.Response;

import com.ecoandrich.maycodingTest.HR.Employee.Entity.Employee;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@ApiModel(value = "사원 간략 정보 조회 결과")
@Data
@Builder
public class EmployeeResponse {

    @ApiModelProperty(value = "이름")
    private String firstName;

    @ApiModelProperty(value = "성")
    private String lastName;

    @ApiModelProperty(value = "이메일")
    private String email;

    @ApiModelProperty(value = "휴대폰 번호")
    private String phoneNumber;

    @ApiModelProperty(value = "고용일")
    private LocalDate hireDate;

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
