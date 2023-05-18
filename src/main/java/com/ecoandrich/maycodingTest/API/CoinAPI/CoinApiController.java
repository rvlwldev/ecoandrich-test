package com.ecoandrich.maycodingTest.API.CoinAPI;

import com.ecoandrich.maycodingTest.API.CoinAPI.DTO.Response.CryptoDetailResponse;
import com.ecoandrich.maycodingTest.API.CoinAPI.DTO.Response.CryptoInfoResponse;
import com.ecoandrich.maycodingTest.API.PublicAPI._Common.Exception.ApiRequestException;
import com.ecoandrich.maycodingTest.API.Util.Exception.JsonToClassException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Tag(name = "External API", description = "외부 API 조회")
@RestController
@RequestMapping("api/coin")
public class CoinApiController {

    private final CoinApiService service;

    CoinApiController(CoinApiService service) {
        this.service = service;
    }

    @Operation(summary = "조회 가능한 코인명 목록 조회", tags = "External API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "조회 실패, 또는 외부 서버의 응답이 없을 경우")
    })
    @GetMapping
    public ResponseEntity<List<CryptoInfoResponse>> getAllCryptos() throws ApiRequestException, JsonToClassException {
        return ResponseEntity.ok(service.getAllCryptoInfo());
    }

    @Operation(summary = "코인 가격 정보 조회", tags = "External API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "외부 서버의 응답이 없을 경우, 확인할 수 없는 코인 ID일 경우")
    })
    @GetMapping("/{ids}")
    public ResponseEntity<List<CryptoDetailResponse>> getCryptoById(@PathVariable("ids") String ids) throws ApiRequestException, JsonToClassException {
        return ResponseEntity.ok(service.getCryptoDetailInfo(ids));
    }
}
