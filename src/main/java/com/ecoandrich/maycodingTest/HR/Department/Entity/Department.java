package com.ecoandrich.maycodingTest.HR.Department.Entity;

import com.ecoandrich.maycodingTest.HR.Department.SubEntity.Location;
import com.ecoandrich.maycodingTest.HR.Employee.Entity.Employee;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@Getter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Department {

    @Id
    @Column(name = "department_id")
    private long id;

    private String department_name;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
