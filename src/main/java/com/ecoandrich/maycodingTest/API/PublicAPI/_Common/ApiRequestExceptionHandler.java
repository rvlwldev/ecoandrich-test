package com.ecoandrich.maycodingTest.API.PublicAPI._Common;

import com.ecoandrich.maycodingTest.API.PublicAPI._Common.Exception.ApiRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice(basePackages = "com.ecoandrich.maycodingTest.API")
public class ApiRequestExceptionHandler {

    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<HashMap<String, String>> handleOfRequestValidation(ApiRequestException e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new HashMap<>() {{
                    put("error", e.getMessage());
                }});
    }

}
