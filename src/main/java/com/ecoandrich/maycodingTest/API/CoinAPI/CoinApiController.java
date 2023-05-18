package com.ecoandrich.maycodingTest.API.CoinAPI;

import com.ecoandrich.maycodingTest.API.CoinAPI.DTO.Response.CryptoDetailResponse;
import com.ecoandrich.maycodingTest.API.CoinAPI.DTO.Response.CryptoInfoResponse;
import com.ecoandrich.maycodingTest.API.PublicAPI._Common.Exception.ApiRequestException;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("api/coin")
public class CoinApiController {

    private final CoinApiService service;

    CoinApiController(CoinApiService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CryptoInfoResponse>> getAllCryptos() throws ApiRequestException, ParseException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return ResponseEntity.ok(service.getAllCryptoInfo());
    }

    @GetMapping("/{ids}")
    public ResponseEntity<List<CryptoDetailResponse>> getCryptoById(@PathVariable("ids") String ids) throws ApiRequestException, ParseException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return ResponseEntity.ok(service.getCryptoDetailInfo(ids));
    }
}
