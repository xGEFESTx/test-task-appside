package com.appside.ui.testSuit;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("com.appside.ui")
@IncludeTags("OpenRegistrationForm")
public class TestSuitOpenRegistrationForm {
}
