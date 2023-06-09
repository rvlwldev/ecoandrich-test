package com.ecoandrich.maycodingTest.HR.Employee.Entity;

import com.ecoandrich.maycodingTest.HR.Department.Entity.Department;
import com.ecoandrich.maycodingTest.HR.Employee.SubEntity.Job;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;

@Entity
@Table(name = "employees")
@DynamicUpdate
@Getter
@Setter
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

    @OneToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public void increaseSalaryByPercent(double increasePercent) {
        setSalary(salary * increasePercent);
    }

    private void setSalary(double salary) {
        this.salary += salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Optional<Department> getDepartment() {
        return Optional.ofNullable(this.department);
    }

    public Optional<Employee> getManager() {
        return Optional.ofNullable(this.manager);
    }

}
