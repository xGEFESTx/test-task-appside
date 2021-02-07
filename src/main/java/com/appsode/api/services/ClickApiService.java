package com.appsode.api.services;

import com.appsode.api.assertions.AssertableResponse;
import com.appsode.api.model.RegistrationClick;
import io.qameta.allure.Step;

public class ClickApiService extends ApiService{

    @Step
    public AssertableResponse registrationClick(RegistrationClick lead){
        return new AssertableResponse(setUp()
                                        .body(lead)
                                        .when()
                                        .post("clicks"));
    }

}
