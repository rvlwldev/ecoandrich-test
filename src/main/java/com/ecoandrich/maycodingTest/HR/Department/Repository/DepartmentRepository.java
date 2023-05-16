package com.ecoandrich.maycodingTest.HR.Department.Repository;

import com.ecoandrich.maycodingTest.HR.Department.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
