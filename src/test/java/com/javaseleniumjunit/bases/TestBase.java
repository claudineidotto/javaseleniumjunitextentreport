package com.javaseleniumjunit.bases;

import org.junit.After;
import org.junit.Before;
import com.javaseleniumjunit.utils.DriverFactory;

public class TestBase {

    @Before
    public void setup(){
    System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
    DriverFactory.createInstance();
    DriverFactory.Instance.manage().window().maximize();

    }
    @After
    public void teardown(){
    DriverFactory.Instance.quit();
    }
}
