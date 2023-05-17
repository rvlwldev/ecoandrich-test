package com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.Exception;

import static com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.MessageEnum.EmployeeStatus.NOT_FOUND_JOB_HISTORY_FORMAT;

public class JobHistoryNotFoundException extends RuntimeException {

    public JobHistoryNotFoundException(long id) {
        super(NOT_FOUND_JOB_HISTORY_FORMAT.toString(id));
    }
}
