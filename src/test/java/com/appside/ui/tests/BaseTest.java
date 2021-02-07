package com.appside.ui.tests;

import com.IAppConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

import java.io.File;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;
    protected IAppConfig appConfig = ConfigFactory.create(IAppConfig.class);

    @BeforeAll
    public void setUp(){
        WebDriverManager.chromedriver().setup();


        if(driver != null){
            return;
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        Runtime.getRuntime().addShutdownHook(
                new Thread( () -> {driver.quit();})
        );
    }

    @AfterEach
    public void tearDown(){
        getLogBrowserConsole();
    }

    @Attachment
    protected byte [] getLogBrowserConsole() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        byte [] arr = (logEntries.getAll()).toString().getBytes();
        return  arr;
    }

    protected String localUrl(String path){
        return new File("").getAbsolutePath() + path;
    }

    protected void sleep(long sec){
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
