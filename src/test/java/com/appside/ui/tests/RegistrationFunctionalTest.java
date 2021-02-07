package com.appside.ui.tests;

import com.appside.ui.model.User;
import com.appside.ui.page.PageRegistration;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationFunctionalTest extends BaseTest{

    PageRegistration pageRegistration;

    @Tags({@Tag("UiTest"), @Tag("UiRegistration}")})
    @Story("User can registration with parameter group from web-form")
    @ParameterizedTest(name = "User = {0}")
    @MethodSource("com.appside.ui.dataProvider.DataProviderRegistrationPage#userCanRegistration")
    public void userCanRegistrationWithParameterGroupInScript(User user){
        pageRegistration = new PageRegistration(driver);
        String expectedText = "Success";

        String textOnTheSuccessPage = pageRegistration.openPageRegistration(localUrl(appConfig.pageWithGroup()))
                .registrationWithValidData(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber())
                .getTextOnTheSuccessPage();

        assertThat(textOnTheSuccessPage).isEqualTo(expectedText);
    }

    @Tags({@Tag("UiTest"), @Tag("UiRegistration}")})
    @Story("User can registration with parameter offer from web-form")
    @ParameterizedTest(name = "firstName = {0}, lastName = {1}, email = {2}, phoneNumber = {3}")
    @MethodSource("com.appside.ui.dataProvider.DataProviderRegistrationPage#userCanRegistration")
    public void userCanRegistrationWithParameterOfferInScript(String firstName, String lastName, String email, String phoneNumber){
        pageRegistration = new PageRegistration(driver);
        String expectedText = "Success";

        String textOnTheSuccessPage = pageRegistration.openPageRegistration(localUrl(appConfig.pageWithOffer()))
                .registrationWithValidData(firstName, lastName, email, phoneNumber).getTextOnTheSuccessPage();

        assertThat(textOnTheSuccessPage).isEqualTo(expectedText);
    }

    @Tags({@Tag("UiTest"), @Tag("UiRegistration}")})
    @Story("User can not registration with parameter group from web-form")
    @ParameterizedTest(name = "firstName = {0}, lastName = {1}, email = {2}, phoneNumber = {3}, errorMessage = {4}")
    @MethodSource("com.appside.ui.dataProvider.DataProviderRegistrationPage#userCanNotRegistration")
    public void userCanNotRegistrationWithParameterGroupInScript(String firstName, String lastName, String email,
                                                                 String phoneNumber, String errorMessage){
        pageRegistration = new PageRegistration(driver);

        String alertText = pageRegistration.openPageRegistration(localUrl(appConfig.pageWithGroup()))
                .registrationWithNotValidData(firstName, lastName, email, phoneNumber).getAlertText().trim();

        pageRegistration.acceptAlert();
        boolean isAlertPresent = pageRegistration.isAlertPresent();

        SoftAssertions softy = new SoftAssertions();
        softy.assertThat(alertText).isEqualTo(errorMessage);
        softy.assertThat(isAlertPresent).isFalse();
        softy.assertAll();
    }

    @Tags({@Tag("UiTest"), @Tag("UiRegistration")})
    @Story("User can not registration with parameter offer from web-form")
    @ParameterizedTest(name = "firstName = {0}, lastName = {1}, email = {2}, phoneNumber = {3}, errorMessage = {4}")
    @MethodSource("com.appside.ui.dataProvider.DataProviderRegistrationPage#userCanNotRegistration")
    public void userCanNotRegistrationWithParameterOfferInScript(String firstName, String lastName, String email,
                                                                 String phoneNumber, String errorMessage){
        pageRegistration = new PageRegistration(driver);

        String alertText = pageRegistration.openPageRegistration(localUrl(appConfig.pageWithOffer()))
                .registrationWithNotValidData(firstName, lastName, email, phoneNumber).getAlertText().trim();

        pageRegistration.acceptAlert();
        boolean isAlertPresent = pageRegistration.isAlertPresent();

        SoftAssertions softy = new SoftAssertions();
        softy.assertThat(alertText).isEqualTo(errorMessage);
        softy.assertThat(isAlertPresent).isFalse();
        softy.assertAll();
    }
}
