package com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Location;

import com.ecoandrich.maycodingTest.HR.Department.SubEntity.Country;
import com.ecoandrich.maycodingTest.HR.Department.SubEntity.Location;
import com.ecoandrich.maycodingTest.HR.Department.SubEntity.Region;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@ApiModel(value = "위치 정보 조회 결과")
@Data
@Builder
public class LocationResponse {

    @ApiModelProperty(value = "대륙")
    private String regionName;

    @ApiModelProperty(value = "국가")
    private String countryName;

    @ApiModelProperty(value = "주", example = "주가 존재하는 국가일 경우")
    private String stateProvince;

    @ApiModelProperty(value = "도시")
    private String city;

    @ApiModelProperty(value = "우편번호")
    private String postalCode;

    @ApiModelProperty(value = "상세주소")
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
