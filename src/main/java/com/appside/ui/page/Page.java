package com.appside.ui.page;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;


    public Page(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 3);
    }

    protected void openUrl(String url){
        driver.get(url);
    }

    protected Alert switchToAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    protected boolean isAlertPresent(){
        try{
            wait.until(ExpectedConditions.alertIsPresent());

            return true;
        }
        catch (NoAlertPresentException ex){
            return false;
        }
    }
}
