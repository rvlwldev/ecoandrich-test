package com.ecoandrich.maycodingTest.API.CoinAPI.DTO.Response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "코인 정보")
@Data
public class CryptoInfoResponse {

    @ApiModelProperty(value = "마켓", example = "화폐 - 코인시그니처아이디, ex.) KRW-BTC")
    String market;

    @ApiModelProperty(value = "한글이름")
    String koreanName;

    @ApiModelProperty(value = "영어이름")
    String englishName;
}
