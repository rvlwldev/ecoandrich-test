package com.ecoandrich.maycodingTest.HR.Employee;

import com.ecoandrich.maycodingTest.HR.Employee.DTO.Request.EmployeeRequest;
import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.EmployeeDetailResponse;
import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.JobHistory.JobHistoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hr/employees")
public class EmployeeController {

    private final EmployeeService service;

    EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeDetailResponse> updateEmployeeInformation(@PathVariable("id") long id,
                                                                            @RequestBody EmployeeRequest request) {
        return ResponseEntity.accepted().body(service.updateEmployee(id, request));
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<EmployeeDetailResponse> getEmployeeInformation(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.getEmployeeDetail(id));
    }

    @GetMapping("/histories/{id}")
    public ResponseEntity<JobHistoryResponse> getEmployeeHistory(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.getHistory(id));
    }

}
