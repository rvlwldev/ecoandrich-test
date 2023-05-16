package com.ecoandrich.maycodingTest.HR.Department;

import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Department.DepartmentWithManagerAndLocationResponse;
import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Location.LocationWithDepartmentNamesResponse;
import com.ecoandrich.maycodingTest.HR.Department.Entity.Department;
import com.ecoandrich.maycodingTest.HR.Department.Repository.DepartmentRepository;
import com.ecoandrich.maycodingTest.HR.Department.Repository.LocationRepository;
import com.ecoandrich.maycodingTest.HR.Department.SubEntity.Location;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository repo;
    private final LocationRepository locationRepo;

    DepartmentService(DepartmentRepository repo, LocationRepository locationRepo) {
        this.repo = repo;
        this.locationRepo = locationRepo;
    }

    public DepartmentWithManagerAndLocationResponse getDepartment(long id) {
        Optional<Department> department = repo.findById(id);

        if (department.isEmpty()) throw new IllegalArgumentException();

        return DepartmentWithManagerAndLocationResponse.toResponse(department.get());
    }

    public LocationWithDepartmentNamesResponse getLocationWithDepartmentNames(long id) {
        Optional<Location> location = locationRepo.findById(id);

        if(location.isEmpty()) throw new IllegalArgumentException();

        return LocationWithDepartmentNamesResponse.toResponse(location.get());
    }

}
