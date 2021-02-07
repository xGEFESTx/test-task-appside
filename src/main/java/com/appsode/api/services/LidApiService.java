package com.appsode.api.services;

import com.appsode.api.assertions.AssertableResponse;
import com.appsode.api.model.RegistrationLid;
import io.qameta.allure.Step;

public class LidApiService extends ApiService{

    @Step
    public AssertableResponse registrationLid(RegistrationLid click){
        return new AssertableResponse(setUp()
                .body(click)
                .when()
                .post("register/lid"));
    }
}
