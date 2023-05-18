package com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Department;

import com.ecoandrich.maycodingTest.HR.Department.Entity.Department;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@ApiModel(value = "해당 위치 부서명 목록", description = "위치 조회 시 해당 위치의 부서명 목록")
@Data
@Builder
public class DepartmentNameListResponse {

    @ApiModelProperty(value = "부서명 목록")
    private List<String> names;

    public static DepartmentNameListResponse toResponse(List<Department> department) {
        List<String> nameList = department.stream()
                .map(Department::getDepartment_name)
                .collect(Collectors.toList());

        return DepartmentNameListResponse.builder()
                .names(nameList)
                .build();
    }
}
