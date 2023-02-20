package com.java_parabank_demo.tests;


import helpers.ConfigFileParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class
test_pages {

    WebDriver driver;

    public static String baseURL;

    @BeforeTest
    public void loadTheHomePage() throws InterruptedException, IOException, ParseException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Samuil/JQAChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        ConfigFileParser configFileParser = new ConfigFileParser();
        configFileParser.configCredentialsParsing();
        baseURL = ConfigFileParser.baseURLGet();

        // Will be run once before all other tests i.e. they will then inherit the driver

    }



    @AfterTest
    public void cleanup() {
        driver.quit();
    }
}
