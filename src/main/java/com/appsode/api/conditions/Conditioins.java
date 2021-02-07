package com.appsode.api.conditions;

import org.hamcrest.Matcher;

public class Conditioins {
    private Conditioins(){}

    public static StatusCodeCondition statusCode(int code){
        return new StatusCodeCondition(code);
    }

    public static BodyFieldCondition bodyField(String jsonPath, Matcher matcher){
        return new BodyFieldCondition(jsonPath, matcher);
    }
}
