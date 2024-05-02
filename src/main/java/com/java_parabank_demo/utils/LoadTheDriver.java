package com.java_parabank_demo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoadTheDriver {

    public static WebDriver driver;
    String websiteURL = "https://parabank.parasoft.com/";

    public LoadTheDriver() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void loadTheWebsite(WebDriver driver) {
        driver.get(websiteURL);
        driver.manage().window().maximize();
    }

    public static void quitTheDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver = null;
        }
    }
}
