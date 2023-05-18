package com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.MessageEnum;

public enum EmployeeStatus {
    EMPLOYEE_NOT_FOUND("존재하지 않는 사원입니다."),
    EMPLOYEE_NOT_FOUND_FORMAT("%d번 사원의 정보를 찾을 수 없습니다."),
    JOB_HISTORY_NOT_FOUND_FORMAT("%d번 사원의 이력을 찾을 수 없습니다."),
    JOB_NOT_FOUND("존재하지 않는 직무입니다.");

    private final String message;

    EmployeeStatus(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public String toString(long id) {
        return String.format(message, id);
    }

}
