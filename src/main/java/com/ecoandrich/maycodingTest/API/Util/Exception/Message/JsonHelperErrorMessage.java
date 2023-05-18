package com.ecoandrich.maycodingTest.API.Util.Exception.Message;

public enum JsonHelperErrorMessage {

    INVALID_RESPONSE_DATA_TYPE("데이터를 처리할 수 없습니다. 올바르지 않은 응답값이 포함되어 있습니다."),
    FAIL_SET_VALUE_TO_DTO("외부 서버에서 데이터 요청에 실패했습니다. 올바르지 않은 응답 형식입니다."),
    NOT_PROPER_ID("올바르지 않은 입력값 입니다. 결과를 조회할 수 없습니다. (404)");

    private final String message;

    JsonHelperErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
