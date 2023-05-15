package com.ecoandrich.maycodingTest.HR.Job.Entity;

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
    String id;

    String job_title;

    double min_salary;

    double max_salary;

    @OneToMany(mappedBy = "job")
    private List<Employee> employees;
}
