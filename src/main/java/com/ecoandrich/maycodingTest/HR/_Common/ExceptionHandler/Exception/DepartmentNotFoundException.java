package com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.Exception;

import static com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.MessageEnum.DepartmentStatus.DEPARTMENT_NOT_FOUND;
import static com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.MessageEnum.DepartmentStatus.EMPLOYEES_IN_DEPARTMENT_NOT_EXIST;

public class DepartmentNotFoundException extends RuntimeException {

    public static DepartmentNotFoundException employeesInDepartmentNotExist() {
        return new DepartmentNotFoundException(EMPLOYEES_IN_DEPARTMENT_NOT_EXIST.toString());
    }

    public DepartmentNotFoundException(String message) {
        super(message);
    }

    public DepartmentNotFoundException() {
        super(DEPARTMENT_NOT_FOUND.toString());
    }
}
