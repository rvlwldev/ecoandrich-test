package com.ecoandrich.maycodingTest.HR.Department.SubEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
@Getter
@NoArgsConstructor
public class Region {

    @Id
    @Column(name = "region_id")
    private String id;

    private String region_name;
}
