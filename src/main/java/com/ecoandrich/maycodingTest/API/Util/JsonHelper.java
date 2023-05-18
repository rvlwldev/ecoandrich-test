package com.ecoandrich.maycodingTest.API.Util;

import com.ecoandrich.maycodingTest.API.Util.Exception.JsonToClassException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.ecoandrich.maycodingTest.API.Util.Exception.Message.JsonHelperErrorMessage.INVALID_RESPONSE_DATA_TYPE;

@Component
public class JsonHelper {

    private final JSONParser parser = new JSONParser();

    public JSONObject toJSONObject(String jsonData) throws ParseException {
        return (JSONObject) parser.parse(jsonData);
    }

    public JSONArray toJSONArray(String jsonData) throws ParseException {
        return (JSONArray) parser.parse(jsonData);
    }

    public <T> List<T> getResponseClassByApiResponseList(String jsonData, Class<T> clazz) throws JsonToClassException {
        List<T> responseList = new ArrayList<>();
        JSONArray jsonArray;

        try {
            jsonArray = toJSONArray(jsonData);
        } catch (ParseException e) {
            throw new JsonToClassException();
        }

        try {
            for (Object json : jsonArray) responseList.add(getResponseClassByApiResponse(json.toString(), clazz));
        } catch (Exception e) {
            throw new JsonToClassException(INVALID_RESPONSE_DATA_TYPE.toString());
        }

        return responseList;
    }

    public <T> T getResponseClassByApiResponse(String jsonData, Class<T> clazz) throws JsonToClassException {
        JSONObject json;
        T result;

        try {
            json = toJSONObject(jsonData);
        } catch (ParseException e) {
            throw new JsonToClassException();
        }

        HashMap<String, Object> jsonMap = new HashMap<>() {{
            for (Object key : json.keySet()) put(toCamelCase(key.toString()), json.get(key));
        }};

        try {
            result = clazz.getDeclaredConstructor().newInstance();
            List<Method> setterMethodList = Stream.of(clazz.getMethods())
                    .filter(method -> method.getName().startsWith("set"))
                    .collect(Collectors.toList());

            for (Method setter : setterMethodList) {
                String jsonKey = getFieldNameBySetterMethod(setter.getName());
                setter.invoke(result, convertType(jsonMap.get(jsonKey), setter.getParameterTypes()[0]));
            }
        } catch (Exception e) {
            throw new JsonToClassException(INVALID_RESPONSE_DATA_TYPE.toString());
        }

        return result;
    }

    private String getFieldNameBySetterMethod(String methodName) {
        if (methodName.startsWith("set")) {
            methodName = methodName.replace("set", "");
            methodName = Character.toLowerCase(methodName.charAt(0)) + methodName.substring(1);
        }

        return toCamelCase(methodName);
    }

    private <T> T convertType(Object value, Class<T> type) {
        if (value == null) return null;
        return type.cast(value);
    }

    public String toCamelCase(String str) {
        StringBuilder builder = new StringBuilder();

        String[] split = str.split("_");

        for (String word : split) {
            builder.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1));
        }

        return builder.toString();
    }

}
