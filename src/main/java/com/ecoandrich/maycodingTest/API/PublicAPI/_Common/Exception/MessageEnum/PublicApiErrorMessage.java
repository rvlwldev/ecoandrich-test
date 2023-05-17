package com.ecoandrich.maycodingTest.API.PublicAPI._Common.Exception.MessageEnum;

public enum PublicApiErrorMessage {

    INVALID_SERVER_SERVICE_KEY("서버 내부의 인증키가 제공기관별 동기화시간이 상이하여 유효하지 않습니다.\n현재 문의 답변을 기다리고 있습니다."),
    NOT_PROPER_URL_REQUEST("공공데이터 API 요청경로가 유효하지 않습니다."),
    API_REQUEST_EXCEPTION_IN_SERVER("공공데이터 API 호출 에러가 발생했습니다.");

    private final String message;

    PublicApiErrorMessage(String message) {
        this.message = message;
    }

}
