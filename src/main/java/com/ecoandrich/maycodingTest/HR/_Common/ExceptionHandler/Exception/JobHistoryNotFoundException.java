package com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.Exception;

import static com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.MessageEnum.EmployeeStatus.JOB_HISTORY_NOT_FOUND_FORMAT;

public class JobHistoryNotFoundException extends RuntimeException {

    public JobHistoryNotFoundException(long id) {
        super(JOB_HISTORY_NOT_FOUND_FORMAT.toString(id));
    }
}
