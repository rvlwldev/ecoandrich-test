package com.ecoandrich.maycodingTest.HR.Department.Repository;

import com.ecoandrich.maycodingTest.HR.Department.SubEntity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
