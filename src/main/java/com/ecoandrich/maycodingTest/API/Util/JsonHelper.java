package com.ecoandrich.maycodingTest.API.Util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

@Component
public class JsonHelper {

    private final JSONParser parser = new JSONParser();

    public JSONObject toJSONObject(String jsonData) throws ParseException {
        return (JSONObject) parser.parse(jsonData);
    }

    public Object getValue(JSONObject jsonData, String key) {
        return jsonData.get(key);
    }

}
