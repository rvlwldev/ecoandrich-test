package com.ecoandrich.maycodingTest.HR.Employee;

import com.ecoandrich.maycodingTest.HR.Employee.DTO.Request.EmployeeRequest;
import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.EmployeeDetailResponse;
import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.JobHistory.JobHistoryResponse;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "HR", description = "사원/부서 관련 정보 API")
@RestController
@RequestMapping("hr/employees")
public class EmployeeController {

    private final EmployeeService service;

    EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @Operation(summary = "특정 사원 정보 수정", tags = "HR"
            , description = "ID를 제외한 모든 정보를 수정합니다.\n외래키(부서, 직무 등)은 해당 ID 값을 넣어줘서 수정할 수 있습니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "유효하지 않은 사원 ID 조회 시")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeDetailResponse> updateEmployeeInformation(@PathVariable("id") long id,
                                                                            @RequestBody EmployeeRequest request) {
        return ResponseEntity.accepted().body(service.updateEmployee(id, request));
    }

    @Operation(summary = "특정 사원의 상세 정보 조회", tags = "HR")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "유효하지 않은 사원 ID 조회 시")
    })
    @GetMapping("/details/{id}")
    public ResponseEntity<EmployeeDetailResponse> getEmployeeInformation(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.getEmployeeDetail(id));
    }

    @Operation(summary = "특정 사원의 이력 정보 조회", tags = "HR")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "유효하지 않은 사원 ID 조회 시"),
            @ApiResponse(responseCode = "404", description = "해당 사원의 이력이 존재하지 않을 때")
    })
    @GetMapping("/histories/{id}")
    public ResponseEntity<JobHistoryResponse> getEmployeeHistory(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.getHistory(id));
    }

}
