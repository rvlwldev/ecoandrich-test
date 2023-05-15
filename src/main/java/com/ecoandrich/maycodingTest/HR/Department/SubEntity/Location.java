package com.ecoandrich.maycodingTest.HR.Department.SubEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "locations")
@Getter
@NoArgsConstructor
public class Location {

    @Id
    @Column(name = "location_id")
    private long id;

    private String street_address;

    private String postal_code;

    private String city;

    private String state_province;

    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
