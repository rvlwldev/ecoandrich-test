package com.ecoandrich.maycodingTest.API.PublicAPI;

import com.ecoandrich.maycodingTest.API.PublicAPI._Common.Exception.ApiRequestException;
import com.ecoandrich.maycodingTest.API.Util.ApiClient;
import com.ecoandrich.maycodingTest.API.Util.JsonHelper;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import static com.ecoandrich.maycodingTest.API.PublicAPI._Common.Constant.PublicApiInformation.*;
import static com.ecoandrich.maycodingTest.API.PublicAPI._Common.Exception.MessageEnum.PublicApiErrorMessage.INVALID_SERVER_SERVICE_KEY;

@Service
public class PublicApiService {

    private final ApiClient client;
    private final JsonHelper jsonHelper;

    PublicApiService(ApiClient client, JsonHelper jsonHelper) {
        this.client = client;
        this.jsonHelper = jsonHelper;
    }

    public JSONObject requestFlightInfo() throws ApiRequestException, ParseException {
        String requestUrl = BASE_URL.toString() + GET_FLIGHT_STATUS_SERVICE_URL;
        String response = client.getRequestResultByString(requestUrl, API_KEY.toString());
        JSONObject result = jsonHelper.toJSONObject(response);

        validateApiRequestResponse(result);

        return result;
    }

    private void validateApiRequestResponse(JSONObject result) throws ApiRequestException {
        if (result.containsKey("code") && result.get("code").toString().equals("-4")) {
            throw new ApiRequestException(INVALID_SERVER_SERVICE_KEY.toString());
        }
    }


}
