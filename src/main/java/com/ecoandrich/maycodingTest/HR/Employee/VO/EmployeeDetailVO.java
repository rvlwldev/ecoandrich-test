package com.ecoandrich.maycodingTest.HR.Employee.VO;

import lombok.Getter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_details_view")
@Immutable
@Getter
public class EmployeeDetailVO {
    @Id
    private long employee_id;

    private String job_id;
    private Long manager_id;
    private long department_id;
    private long location_id;
    private String country_id;
    private String first_name;
    private String last_name;
    private double salary;
    private Double commission_pct;
    private String department_name;
    private String job_title;
    private String city;
    private String state_province;
    private String country_name;
    private String region_name;
}
