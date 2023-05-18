package com.ecoandrich.maycodingTest.API.Util.Exception;

import static com.ecoandrich.maycodingTest.API.Util.Exception.Message.JsonHelperErrorMessage.FAIL_SET_VALUE_TO_DTO;

public class JsonToClassException extends Exception {

    public JsonToClassException() {
        super(FAIL_SET_VALUE_TO_DTO.toString());
    }

    public JsonToClassException(String message) {
        super(message);
    }

}
