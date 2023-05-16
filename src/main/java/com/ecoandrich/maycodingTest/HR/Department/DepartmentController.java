package com.ecoandrich.maycodingTest.HR.Department;

import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.DepartmentWithManagerAndLocationResponse;
import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.LocationWithDepartmentNamesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/location/{id}")
    public ResponseEntity<LocationWithDepartmentNamesResponse> getLocationAndDepartmentNames(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.getLocationWithDepartmentNames(id));
    }

}
