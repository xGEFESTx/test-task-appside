package com.appsode.api.assertions;

import com.appsode.api.conditions.ICondition;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class AssertableResponse {
    private Response response;

    public  AssertableResponse(Response response) {
        this.response = response;
    }

    @Step("api response should have {condition}")
    public AssertableResponse shouldHave(ICondition condition){
        condition.check(response);
        return this;
    }

    public <T> T asPojo(Class<T> tClass){
        return response.as(tClass);
    }
}
