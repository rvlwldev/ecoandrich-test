package com.ecoandrich.maycodingTest.HR.Department.SubEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "countries")
@Getter
@NoArgsConstructor
public class Country {

    @Id
    @Column(name = "country_id")
    private String id;

    private String country_name;

    @OneToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
