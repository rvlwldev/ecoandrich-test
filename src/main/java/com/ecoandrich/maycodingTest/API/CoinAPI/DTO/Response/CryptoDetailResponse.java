package com.ecoandrich.maycodingTest.API.CoinAPI.DTO.Response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "코인 가격 정보")
@Data
public class CryptoDetailResponse {

    @ApiModelProperty(value = "시가")
    Double openingPrice;

    @ApiModelProperty(value = "고가")
    Double highPrice;

    @ApiModelProperty(value = "저가")
    Double lowPrice;

    @ApiModelProperty(value = "변동률")
    Double signedChangeRate;

    public void setSignedChangeRate(Double signedChangeRate) {
        this.signedChangeRate = (double) Math.round(signedChangeRate * 100 * 100) / 1000;
    }
}
