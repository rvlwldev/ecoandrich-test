package com.ecoandrich.maycodingTest.HR.Department;

import com.ecoandrich.maycodingTest.HR.Department.DTO.Request.IncreaseSalaryRequest;
import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Department.DepartmentWithManagerAndLocationResponse;
import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Location.LocationWithDepartmentNamesResponse;
import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.EmployeeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "HR")
@RestController
@RequestMapping("/hr/departments")
public class DepartmentController {

    private final DepartmentService service;

    DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @Operation(summary = "특정 부서 정보 조회", tags = "HR",
            description = "부서의 매니저, 위치 정보를 포함합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "404", description = "해당 ID로 부서 정보를 찾을 수 없을 때")
    })
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentWithManagerAndLocationResponse> getDepartment(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.getDepartment(id));
    }

    @Operation(summary = "특정 부서의 모든 사원들의 급여를 퍼센트 단위로 인상합니다.", tags = "HR",
            description = "increasePercent 값은 소수점퍼센트(0.205), 퍼센트(20.5) 모두 가능합니다.\n수정 성공 시, 급여가 인상된 사원들의 간략한 정보를 반환합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "수정 성공"),
            @ApiResponse(responseCode = "404", description = "해당 ID로 부서 정보를 찾을 수 없거나 부서에 사원이 존재하지 않을 때")
    })
    @PatchMapping("/{id}/increase-salaries")
    public ResponseEntity<List<EmployeeResponse>> increaseSalaryForAllEmployeesInDepartment(@PathVariable("id") long id,
                                                                                            @RequestBody IncreaseSalaryRequest request) {
        return ResponseEntity.ok(service.increaseSalaryForAllEmployeesInDepartment(id, request.getIncreasePercent()));
    }

    @Operation(summary = "각 사무실 위치 정보를 조회합니다.", tags = "HR",
            description = "위치 정보 조회 시, 해당 위치의 부서들의 이름 목록을 반환합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "수정 성공"),
            @ApiResponse(responseCode = "404", description = "해당 ID로 부서 정보를 찾을 수 없거나 부서에 사원이 존재하지 않을 때")
    })
    @GetMapping("/locations/{id}")
    public ResponseEntity<LocationWithDepartmentNamesResponse> getLocationAndDepartmentNames(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.getLocationWithDepartmentNames(id));
    }

}
