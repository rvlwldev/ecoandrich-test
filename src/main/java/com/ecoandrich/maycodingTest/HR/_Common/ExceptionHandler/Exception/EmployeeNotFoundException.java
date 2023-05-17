package com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.Exception;

import lombok.Getter;

import static com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.MessageEnum.EmployeeStatus.EMPLOYEE_NOT_FOUND;
import static com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.MessageEnum.EmployeeStatus.EMPLOYEE_NOT_FOUND_FORMAT;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException() {
        super(EMPLOYEE_NOT_FOUND.toString());
    }

    public EmployeeNotFoundException(long id) {
        super(EMPLOYEE_NOT_FOUND_FORMAT.toString(id));
    }

}
