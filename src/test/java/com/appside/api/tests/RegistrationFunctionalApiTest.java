package com.appside.api.tests;

import com.appsode.api.model.RegistrationClick;
import com.appsode.api.model.RegistrationLid;
import com.appsode.api.resopnses.RegistrationResponse;
import com.appsode.api.services.ClickApiService;
import com.appsode.api.services.LidApiService;

import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static com.appsode.api.conditions.Conditioins.bodyField;
import static com.appsode.api.conditions.Conditioins.statusCode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

public class RegistrationFunctionalApiTest extends BaseTest{

    ClickApiService clickApiService = new ClickApiService();
    LidApiService lidApiService = new LidApiService();

    @Story("Success registration click")
    @Tags({@Tag("ApiTest"), @Tag("RegistrationClick")})
    @ParameterizedTest(name = "dataForRegistrationClick = {0}")
    @MethodSource("com.appside.api.dataProvider.DataProviderRegistrationApi#successRegistrationNewClick")
    public void successRegistrationNewClick(RegistrationClick click){

            clickApiService.registrationClick(click)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("id", not(emptyOrNullString())));
    }

    @Story("Failed registration click")
    @Tags({@Tag("ApiTest"), @Tag("RegistrationClick")})
    @ParameterizedTest(name = "dataForRegistrationClick = {0}, errorMessage = {1}")
    @MethodSource("com.appside.api.dataProvider.DataProviderRegistrationApi#failedRegistrationNewClick")
    public void failedRegistrationNewClick(RegistrationClick click, List<String> errorMessage){

        RegistrationResponse registrationResponse = clickApiService.registrationClick(click)
                .shouldHave(statusCode(400))
                .asPojo(RegistrationResponse.class);

        assertThat(registrationResponse.getMessage()).isEqualTo(errorMessage);
    }

    @Story("Success registration lid")
    @Tags({@Tag("ApiTest"), @Tag("RegistrationLid")})
    @ParameterizedTest(name = "dataForRegistrationClick = {0}, dataForRegistrationLid = {1}")
    @MethodSource("com.appside.api.dataProvider.DataProviderRegistrationApi#successRegistrationNewLid")
    public void successRegistrationNewLead(RegistrationClick click, RegistrationLid lid){

        RegistrationResponse registrationClick = clickApiService.registrationClick(click)
                .shouldHave(statusCode(200))
                .asPojo(RegistrationResponse.class);

        lid.setClick(registrationClick.getId());

        RegistrationResponse registrationLid = lidApiService.registrationLid(lid)
                .shouldHave(statusCode(200))
                .asPojo(RegistrationResponse.class);

        SoftAssertions softy = new SoftAssertions();
        softy.assertThat(registrationLid.getResult()).isEqualTo("ok");
        softy.assertThat(registrationLid.getLidId()).isNotNull();

    }

    @Story("Failed registration lid")
    @Tags({@Tag("ApiTest"), @Tag("RegistrationLid")})
    @ParameterizedTest(name = "dataForRegistrationClick = {0}, dataForRegistrationLid = {1}, errorMessage = {2}")
    @MethodSource("com.appside.api.dataProvider.DataProviderRegistrationApi#failedRegistrationNewLid")
    public void failedRegistrationNewLead(RegistrationClick click, RegistrationLid lid, List<String> errorMessage) {

        RegistrationResponse registrationClick = clickApiService.registrationClick(click)
                .shouldHave(statusCode(200))
                .asPojo(RegistrationResponse.class);

        lid.setClick(registrationClick.getId());

        RegistrationResponse registrationLid = lidApiService.registrationLid(lid)
                .shouldHave(statusCode(400))
                .asPojo(RegistrationResponse.class);

        assertThat(registrationLid.getMessage()).isEqualTo(errorMessage);
    }
}
