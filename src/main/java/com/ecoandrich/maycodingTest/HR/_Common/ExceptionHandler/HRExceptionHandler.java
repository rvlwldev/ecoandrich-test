package com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler;

import com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.Exception.EmployeeNotFoundException;
import com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.Exception.JobHistoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(basePackages = "com.ecoandrich.maycodingTest.HR")
public class HRExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleOfEmployeeException(EmployeeNotFoundException e) {
        return getResponseBodyMap("error", e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JobHistoryNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleOfEmployeeException(JobHistoryNotFoundException e) {
        return getResponseBodyMap("error", e.getMessage(), HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Map<String, Object>> getResponseBodyMap(String key, Object value, HttpStatus status) {
        HashMap<String, Object> body = new HashMap<>() {{
            put(key, value);
        }};

        return ResponseEntity.status(status).body(body);
    }

}
