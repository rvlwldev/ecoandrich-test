package com.ecoandrich.maycodingTest.API.PublicAPI;

import com.ecoandrich.maycodingTest.API.PublicAPI._Common.Exception.ApiRequestException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/public/flights")
public class PublicApiController {

    private final PublicApiService service;

    PublicApiController(PublicApiService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<JSONObject> getFlightInfo() throws ApiRequestException, ParseException {
        return ResponseEntity.ok(service.requestFlightInfo());
    }

}
