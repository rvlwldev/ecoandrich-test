package com.ecoandrich.maycodingTest.HR.Employee.DTO.Request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@ApiModel(value = "사원 정보 수정 요청 양식", description = "사원 정보 수정 Request DTO")
@Data
public class EmployeeRequest {

    @ApiModelProperty(value = "이름")
    private String firstName;

    @ApiModelProperty(value = "성")
    private String lastName;

    @ApiModelProperty(value = "이메일")
    private String email;

    @ApiModelProperty(value = "휴대폰번호", example = "515.127.1234")
    private String phoneNumber;

    @ApiModelProperty(value = "고용일", example = "2023-05-17")
    private LocalDate hireDate;

    @ApiModelProperty(value = "직무 번호")
    private String jobId;

    @ApiModelProperty(value = "급여")
    private Double salary;

    @ApiModelProperty(value = "커미션 퍼센트")
    private Double commissionPct;

    @ApiModelProperty(value = "매니저 번호")
    private Long managerId;

    @ApiModelProperty(value = "부서 번호")
    private Long departmentId;
}
