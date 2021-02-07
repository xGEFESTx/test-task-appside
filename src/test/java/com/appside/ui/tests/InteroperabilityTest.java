package com.appside.ui.tests;

import com.appside.ui.page.PageRegistration;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class InteroperabilityTest extends BaseTest{

    PageRegistration pageRegistration;

    @Tags({@Tag("UI test"), @Tag("OpenRegistrationForm")})
    @Story("Open  registration form if parameter group is Empty")
    @Test
    public void openTheRegistrationFormWithScriptParameterGroupIsEmpty(){
        pageRegistration = new PageRegistration(driver);
        String expectedAlertText = "offer: Пропущено обязательное поле для формы";

        String actualAlertText = pageRegistration.openPageRegistration(localUrl(appConfig.pageGroupIsEmpty())).getAlertText().trim();
        pageRegistration.acceptAlert();
        boolean isAlertPresent = pageRegistration.isAlertPresent();

        SoftAssertions softy = new SoftAssertions();
        softy.assertThat(actualAlertText).isEqualTo(expectedAlertText);
        softy.assertThat(isAlertPresent).isFalse();
        softy.assertAll();
    }

    @Tags({@Tag("UI test"), @Tag("OpenRegistrationForm")})
    @Story("Open  registration form if parameter offer is Empty")
    @Test
    public void openTheRegistrationFormWithScriptParameterOfferIsEmpty(){
        pageRegistration = new PageRegistration(driver);
        String expectedAlertText = "offer: Пропущено обязательное поле для формы";

        String actualAlertText = pageRegistration.openPageRegistration(localUrl(appConfig.pageOfferIsEmpty())).getAlertText().trim();
        pageRegistration.acceptAlert();
        boolean isAlertPresent = pageRegistration.isAlertPresent();

        SoftAssertions softy = new SoftAssertions();
        softy.assertThat(actualAlertText).isEqualTo(expectedAlertText);
        softy.assertThat(isAlertPresent).isFalse();
        softy.assertAll();
    }

    @Tags({@Tag("UI test"), @Tag("OpenRegistrationForm")})
    @Story("Open  registration form if parameter pid is Empty")
    @Test
    public void openTheRegistrationFormWithScriptParameterPidIsEmpty(){
        pageRegistration = new PageRegistration(driver);
        String expectedAlertText = "pid: Пропущено обязательное поле для формы";

        String actualAlertText = pageRegistration.openPageRegistration(localUrl(appConfig.pagePidIsEmpty())).getAlertText().trim();
        pageRegistration.acceptAlert();
        boolean isAlertPresent = pageRegistration.isAlertPresent();

        SoftAssertions softy = new SoftAssertions();
        softy.assertThat(actualAlertText).isEqualTo(expectedAlertText);
        softy.assertThat(isAlertPresent).isFalse();
        softy.assertAll();
    }
}
