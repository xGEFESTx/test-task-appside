package com.appside.ui.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageSuccess extends Page{
    public PageSuccess(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//h1")
    WebElement successText;

    @Step
    public String getTextOnTheSuccessPage(){
        String textOnTheSuccessPage;
        if (wait.until(ExpectedConditions.visibilityOf(successText)).isDisplayed()){
            textOnTheSuccessPage = successText.getText();
        }
        else textOnTheSuccessPage = "Текст на странице Success не найден";
        return textOnTheSuccessPage;
    }
}
