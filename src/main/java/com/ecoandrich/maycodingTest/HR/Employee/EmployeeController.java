package com.ecoandrich.maycodingTest.HR.Employee;

import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.EmployeeDetailResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @RequestMapping(value = "detail/{id}")
    public ResponseEntity<EmployeeDetailResponse> getEmployeeInformation(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.getEmployeeDetail(id));
    }

}
