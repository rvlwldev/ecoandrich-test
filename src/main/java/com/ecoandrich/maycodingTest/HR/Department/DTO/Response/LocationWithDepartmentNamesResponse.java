package com.ecoandrich.maycodingTest.HR.Department.DTO.Response;

import com.ecoandrich.maycodingTest.HR.Department.SubEntity.Location;
import lombok.Builder;
import lombok.Data;

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
