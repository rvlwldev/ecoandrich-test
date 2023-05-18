package com.ecoandrich.maycodingTest.HR.Department;

import com.ecoandrich.maycodingTest.HR.Department.DTO.Request.IncreaseSalaryRequest;
import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Department.DepartmentWithManagerAndLocationResponse;
import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Location.LocationWithDepartmentNamesResponse;
import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.EmployeeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hr/departments")
public class DepartmentController {

    private final DepartmentService service;

    DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentWithManagerAndLocationResponse> getDepartment(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.getDepartment(id));
    }

    @PatchMapping("/{id}/increase-salaries")
    public ResponseEntity<List<EmployeeResponse>> increaseSalaryForAllEmployeesInDepartment(@PathVariable("id") long id,
                                                                                            @RequestBody IncreaseSalaryRequest request) {
        return ResponseEntity.ok(service.increaseSalaryForAllEmployeesInDepartment(id, request.getIncreasePercent()));
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<LocationWithDepartmentNamesResponse> getLocationAndDepartmentNames(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.getLocationWithDepartmentNames(id));
    }

}
