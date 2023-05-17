package com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler;

import com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.Exception.EmployeeNotFoundException;
import com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.Exception.JobHistoryNotFoundException;
import com.ecoandrich.maycodingTest.HR._Common.ExceptionHandler.Exception.JobNotFoundException;
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
        return getResponseEntityWithBody("error", e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JobHistoryNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleOfEmployeeException(JobHistoryNotFoundException e) {
        return getResponseEntityWithBody("error", e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleOfEmployeeException(JobNotFoundException e) {
        HashMap<String, Object> body = new HashMap<>() {{
            put("error", e.getMessage());
            put("inputJobId", e.getInvalidJobId());
        }};

        return getResponseEntityWithBody(body, HttpStatus.NOT_FOUND);
    }


    private ResponseEntity<Map<String, Object>> getResponseEntityWithBody(String key, Object value, HttpStatus status) {
        HashMap<String, Object> body = new HashMap<>() {{
            put(key, value);
        }};

        return ResponseEntity.status(status).body(body);
    }

    private ResponseEntity<Map<String, Object>> getResponseEntityWithBody(Map<String, Object> body, HttpStatus status) {
        return ResponseEntity.status(status).body(body);
    }

}
