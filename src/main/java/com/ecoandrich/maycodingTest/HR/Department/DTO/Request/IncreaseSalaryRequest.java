package com.ecoandrich.maycodingTest.HR.Department.DTO.Request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "부서 급여 인상 요청 양식")
@Data
public class IncreaseSalaryRequest {
    @ApiModelProperty(value = "인상 비율", example = "15.5% 경우, 0.155 또는 15.5")
    private double increasePercent;
}
