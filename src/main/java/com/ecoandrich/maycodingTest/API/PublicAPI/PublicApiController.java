package com.ecoandrich.maycodingTest.API.PublicAPI;

import com.ecoandrich.maycodingTest.API.PublicAPI._Common.Exception.ApiRequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "External API", description = "외부 API 조회")
@RestController
@RequestMapping("api/public/flights")
public class PublicApiController {

    private final PublicApiService service;

    PublicApiController(PublicApiService service) {
        this.service = service;
    }

    @Operation(summary = "실시간 항공 운항 현황 조회", tags = "External API",
            description = "현재 기관별 인증키 동기화 시간이 상이하여 기다리고 있는 상태",
            deprecated = true)
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "조회 실패, 또는 외부 서버의 응답이 없을 경우")
    })
    @GetMapping
    public ResponseEntity<JSONObject> getFlightInfo() throws ApiRequestException, ParseException {
        return ResponseEntity.ok(service.requestFlightInfo());
    }

}
