package com.ecoandrich.maycodingTest.API.PublicAPI._Common.Constant;

public enum PublicApiInformation {
    BASE_URL("https://api.odcloud.kr/api"),
    GET_FLIGHT_STATUS_SERVICE_URL("/FlightStatusListDTL/v1/getFlightStatusListDetail"),
    API_KEY("*");

    private final String info;

    PublicApiInformation(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return this.info;
    }

}
