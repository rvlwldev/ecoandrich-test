package com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Location;

import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Department.DepartmentNameListResponse;
import com.ecoandrich.maycodingTest.HR.Department.SubEntity.Location;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

@ApiModel(value = "위치별 부서명 조회 결과")
@Data
@Builder
public class LocationWithDepartmentNamesResponse {

    private LocationResponse location;
    DepartmentNameListResponse departments;

    public static LocationWithDepartmentNamesResponse toResponse(Location locationEntity) {
        LocationResponse locationResponse = LocationResponse
                .toResponse(locationEntity);

        DepartmentNameListResponse departmentNameList = DepartmentNameListResponse
                .toResponse(locationEntity.getDepartments());

        return LocationWithDepartmentNamesResponse.builder()
                .location(locationResponse)
                .departments(departmentNameList)
                .build();
    }
}
