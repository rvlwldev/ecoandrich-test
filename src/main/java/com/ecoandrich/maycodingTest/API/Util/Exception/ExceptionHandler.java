package com.ecoandrich.maycodingTest.API.Util.Exception;

import com.ecoandrich.maycodingTest.API.PublicAPI._Common.Exception.ApiRequestException;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static com.ecoandrich.maycodingTest.API.Util.Exception.Message.JsonHelperErrorMessage.NOT_PROPER_ID;

@ControllerAdvice("com.ecoandrich.maycodingTest.API")
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<Map<String, Object>> handleOfException(ApiRequestException e) {
        return getResponseEntityWithBody("connectionError", e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(JsonToClassException.class)
    public ResponseEntity<Map<String, Object>> handleOfException(JsonToClassException e) {
        return getResponseEntityWithBody("DataError", e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ParseException.class)
    public ResponseEntity<Map<String, Object>> handleOfException(ParseException e) {
        return getResponseEntityWithBody("DataError", e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ClassCastException.class)
    public ResponseEntity<Map<String, Object>> handleOfException(ClassCastException e) {
        return getResponseEntityWithBody("Error", NOT_PROPER_ID.toString(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Map<String, Object>> getResponseEntityWithBody(String key, Object value, HttpStatus status) {
        HashMap<String, Object> body = new HashMap<>() {{
            put(key, value);
        }};

        return ResponseEntity.status(status).body(body);
    }
}
