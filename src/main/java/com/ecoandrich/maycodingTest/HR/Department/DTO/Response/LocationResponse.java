package com.ecoandrich.maycodingTest.HR.Department.DTO.Response;

import com.ecoandrich.maycodingTest.HR.Department.SubEntity.Country;
import com.ecoandrich.maycodingTest.HR.Department.SubEntity.Location;
import com.ecoandrich.maycodingTest.HR.Department.SubEntity.Region;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationResponse {

    private String regionName;
    private String countryName;
    private String stateProvince;
    private String city;
    private String postalCode;
    private String streetAddress;

    public static LocationResponse toResponse(Location location) {
        Country country = location.getCountry();
        Region region = country.getRegion();

        return LocationResponse.builder()
                .regionName(region.getRegion_name())
                .countryName(country.getCountry_name())
                .stateProvince(location.getState_province())
                .city(location.getCity())
                .postalCode(location.getPostal_code())
                .streetAddress(location.getStreet_address())
                .build();
    }

}
