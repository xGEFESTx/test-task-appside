package com.appside.api.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    public void setUp(){
        RestAssured.baseURI = "https://admin.neogara.com/";
    }
}
