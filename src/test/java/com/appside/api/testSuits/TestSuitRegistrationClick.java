package com.appside.api.testSuits;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.appside.api")
@IncludeTags("RegistrationClick")
public class TestSuitRegistrationClick {
}
