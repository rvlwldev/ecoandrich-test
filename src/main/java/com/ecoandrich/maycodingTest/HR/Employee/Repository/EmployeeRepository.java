package com.ecoandrich.maycodingTest.HR.Employee.Repository;

import com.ecoandrich.maycodingTest.HR.Employee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
