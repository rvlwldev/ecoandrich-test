package com.ecoandrich.maycodingTest.HR.Employee.SubEntity;

import com.ecoandrich.maycodingTest.HR.Department.Entity.Department;
import com.ecoandrich.maycodingTest.HR.Employee.Entity.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jobs")
@Getter
@NoArgsConstructor
public class Job {

    @Id
    @Column(name = "job_id")
    private String id;

    private String job_title;

    private double min_salary;

    private double max_salary;

    @OneToMany(mappedBy = "job")
    private List<Employee> employees;
}
