package com.ecoandrich.maycodingTest.HR.Employee;

import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.EmployeeDetailResponse;
import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.JobHistory.JobHistoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hr/employees")
public class EmployeeController {

    private final EmployeeService service;

    EmployeeController(EmployeeService service) {
        this.service = service;
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
