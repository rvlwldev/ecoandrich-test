package com.ecoandrich.maycodingTest.API.CoinAPI.DTO.Response;

import lombok.Data;

@Data
public class CryptoDetailResponse {
    Double openingPrice;
    Double highPrice;
    Double lowPrice;
    Double signedChangeRate;

    public void setSignedChangeRate(Double signedChangeRate) {
        this.signedChangeRate = (double) Math.round(signedChangeRate * 100 * 100) / 1000;
    }
}
