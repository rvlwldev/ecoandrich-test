package com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.Exception;

import static com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.MessageEnum.DepartmentStatus.LOCATION_NOT_FOUND;

public class LocationNotFound extends RuntimeException {

    public LocationNotFound(){
        super(LOCATION_NOT_FOUND.toString());
    }

}
