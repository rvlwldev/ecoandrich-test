package com.ecoandrich.maycodingTest.API.CoinAPI;

import com.ecoandrich.maycodingTest.API.CoinAPI.DTO.Response.CryptoDetailResponse;
import com.ecoandrich.maycodingTest.API.CoinAPI.DTO.Response.CryptoInfoResponse;
import com.ecoandrich.maycodingTest.API.PublicAPI._Common.Exception.ApiRequestException;
import com.ecoandrich.maycodingTest.API.Util.ApiClient;
import com.ecoandrich.maycodingTest.API.Util.Exception.JsonToClassException;
import com.ecoandrich.maycodingTest.API.Util.JsonHelper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ecoandrich.maycodingTest.API.CoinAPI._Common.Constant.UpBitTickerApiInformation.ALL_CRYPTO_INFO_URL;
import static com.ecoandrich.maycodingTest.API.CoinAPI._Common.Constant.UpBitTickerApiInformation.CRYPTO_DETAIL_INFO_URL;

@Service
public class CoinApiService {

    private final ApiClient client;
    private final JsonHelper jsonHelper;

    CoinApiService(ApiClient client, JsonHelper jsonHelper) {
        this.client = client;
        this.jsonHelper = jsonHelper;
    }

    public List<CryptoInfoResponse> getAllCryptoInfo() throws ApiRequestException, JsonToClassException {
        String apiResponse = client.getRequestResultByString(ALL_CRYPTO_INFO_URL.toString());

        return jsonHelper.getResponseClassByApiResponseList(apiResponse, CryptoInfoResponse.class);
    }

    public List<CryptoDetailResponse> getCryptoDetailInfo(String ids) throws ApiRequestException, JsonToClassException {
        String apiResponse = client.getRequestResultByString(CRYPTO_DETAIL_INFO_URL + ids);

        return jsonHelper.getResponseClassByApiResponseList(apiResponse, CryptoDetailResponse.class);
    }

}
