package com.ecoandrich.maycodingTest.API.Util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class JsonHelper {

    private final JSONParser parser = new JSONParser();

    public JSONObject toJSONObject(String jsonData) throws ParseException {
        return (JSONObject) parser.parse(jsonData);
    }

    public JSONArray toJSONArray(String jsonData) throws ParseException {
        return (JSONArray) parser.parse(jsonData);
    }

    public <T> List<T> getResponseClassByApiResponseList(String jsonData, Class<T> clazz) throws ParseException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        List<T> responseList = new ArrayList<>();

        JSONArray jsonArray = toJSONArray(jsonData);

        for (Object json : jsonArray) responseList.add(getResponseClassByApiResponse(json.toString(), clazz));

        return responseList;
    }

    public <T> T getResponseClassByApiResponse(String jsonData, Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ParseException {
        JSONObject json = toJSONObject(jsonData);

        HashMap<String, Object> jsonMap = new HashMap<>() {{
            for (Object key : json.keySet()) put(toCamelCase(key.toString()), json.get(key));
        }};

        T result = clazz.getDeclaredConstructor().newInstance();
        List<Method> setterMethodList = Stream.of(clazz.getMethods())
                .filter(method -> method.getName().startsWith("set"))
                .collect(Collectors.toList());

        for (Method setter : setterMethodList) {
            String jsonKey = getFieldNameBySetterMethod(setter.getName());
            setter.invoke(result, convertType(jsonMap.get(jsonKey), setter.getParameterTypes()[0]));
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
