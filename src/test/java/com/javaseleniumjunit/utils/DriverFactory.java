package com.javaseleniumjunit.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver Instance = null;

    public static void createInstance() {
        Instance = new ChromeDriver();
        Instance.get("http://demo.automationtesting.in/Register.html");
    }
    public static void quitInstance() {
        Instance.quit();
        Instance=null;
    }

}
