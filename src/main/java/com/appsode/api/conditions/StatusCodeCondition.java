package com.appsode.api.conditions;

import io.restassured.response.Response;

public class StatusCodeCondition implements ICondition{
    private final int statusCode;

    public StatusCodeCondition(int statusCode) {
        this.statusCode = statusCode;
    }

    public void check(Response response) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Override
    public String toString() {
        return "statusCode= " + statusCode;
    }
}
