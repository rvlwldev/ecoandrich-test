package com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.Exception;

import static com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.MessageEnum.EmployeeStatus.JOB_NOT_FOUND;

public class JobNotFoundException extends RuntimeException {

    private final String invalidJobId;

    public JobNotFoundException(String id) {
        super(JOB_NOT_FOUND.toString());
        this.invalidJobId = id;
    }

    public String getInvalidJobId() {
        return this.invalidJobId;
    }

}
