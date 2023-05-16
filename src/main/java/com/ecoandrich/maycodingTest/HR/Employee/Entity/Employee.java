package com.ecoandrich.maycodingTest.HR.Employee.Entity;

import com.ecoandrich.maycodingTest.HR.Department.Entity.Department;
import com.ecoandrich.maycodingTest.HR.Employee.SubEntity.Job;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Employee {

    @Id
    @Column(name = "employee_id")
    private long id;

    private String first_name;

    private String last_name;

    private String email;

    private String phone_number;

    private LocalDate hire_date;

    private double salary;

    private Double commission_pct;

    private Long manager_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}
