package com.ecoandrich.maycodingTest.API.Util;

import com.ecoandrich.maycodingTest.API.PublicAPI._Common.Exception.ApiRequestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static com.ecoandrich.maycodingTest.API.PublicAPI._Common.Exception.MessageEnum.PublicApiErrorMessage.API_REQUEST_EXCEPTION_IN_SERVER;
import static com.ecoandrich.maycodingTest.API.PublicAPI._Common.Exception.MessageEnum.PublicApiErrorMessage.NOT_PROPER_URL_REQUEST;

@Component
public class ApiClient {

    private final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .build();

    public String getRequestResultByString(String url, String authKey) throws ApiRequestException {
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(url + "?serviceKey=" + authKey))
                    .GET()
                    .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                    .build();

            return client.send(request, HttpResponse.BodyHandlers.ofString())
                    .body();

        } catch (URISyntaxException | IOException | InterruptedException e) {
            if (e instanceof URISyntaxException || e instanceof IOException)
                throw new ApiRequestException(NOT_PROPER_URL_REQUEST.toString());

            throw new ApiRequestException(API_REQUEST_EXCEPTION_IN_SERVER.toString());
        }

    }

}
