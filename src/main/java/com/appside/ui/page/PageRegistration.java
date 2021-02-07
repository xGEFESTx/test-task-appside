package com.appside.ui.page;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageRegistration extends Page {

    public PageRegistration(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//input[@placeholder='Имя']")
    WebElement firstNameField;

    @FindBy(xpath = ".//input[@placeholder='Фамилия']")
    WebElement lastNameField;

    @FindBy(xpath = ".//input[@placeholder='E-mail']")
    WebElement emailField;

    @FindBy(xpath = ".//input[@placeholder='Номер телефона']")
    WebElement phoneNumberField;

    @FindBy(xpath = ".//button")
    WebElement submitButton;

    @Step
    public PageRegistration openPageRegistration(String url){
        openUrl(url);
        return this;
    }

    @Step
    public PageRegistration registrationWithNotValidData(String firstName, String lastName, String email, String phoneNumber){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        phoneNumberField.sendKeys(phoneNumber);
        submitButton.click();
        return this;
    }


    @Step
    public void acceptAlert(){
        switchToAlert().accept();
    }

    @Step
    public String getAlertText(){
        return switchToAlert().getText();
    }

    @Step
    public boolean isAlertPresent(){
        try{
            wait.until(ExpectedConditions.alertIsPresent());
            switchToAlert();
            return true;
        }
        catch (TimeoutException ex){
            return false;
        }
    }

    @Step
    public PageSuccess registrationWithValidData(String firstName, String lastName, String email, String phoneNumber){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        phoneNumberField.sendKeys(phoneNumber);
        submitButton.click();
        return new PageSuccess(driver);
    }

    @Step
    public PageRegistration registrationWithIncorrectParametersInScript(String firstName, String lastName, String email, String phoneNumber){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        phoneNumberField.sendKeys(phoneNumber);
        submitButton.click();
        return this;
    }
}
