package com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Department;

import com.ecoandrich.maycodingTest.HR.Department.Entity.Department;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class DepartmentNameListResponse {
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
