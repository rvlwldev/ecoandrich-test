package com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.MessageEnum;

public enum DepartmentStatus {

    DEPARTMENT_NOT_FOUND("존재하지 않는 부서입니다."),
    EMPLOYEES_IN_DEPARTMENT_NOT_EXIST("해당 부서에 사원이 존재하지 않습니다."),
    LOCATION_NOT_FOUND("등록되지 않은 부서 위치 정보입니다.");

    private final String message;

    DepartmentStatus(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
