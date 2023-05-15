package com.ecoandrich.maycodingTest.HR.Employee.Repository;

import com.ecoandrich.maycodingTest.HR.Employee.VO.EmployeeDetailVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeViewRepository extends JpaRepository<EmployeeDetailVO, Long> {
}
