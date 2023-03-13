package com.java_parabank_demo.Tests;

import com.java_parabank_demo.Pages.Authorization.Log_In_Form;
import com.java_parabank_demo.Pages.LoadTheWebsite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogInToTheWebsite {
    WebDriver driver;
    String currentURL;
    String expectedURL;

    String username = "papagala77";
    String password = "test123";

    @BeforeTest
    public void OpenTheWebsite(){
        driver = new ChromeDriver();
        new LoadTheWebsite().LoadTheWebsite(driver);
    }

    @Test(priority = 1)
    public void checkIfTheWebsiteURLIsCorrect(){
        currentURL = driver.getCurrentUrl();
        expectedURL = "https://parabank.parasoft.com/parabank/index.htm";
        Assert.assertEquals(currentURL, expectedURL);
    }

    @Test(priority = 2)
    public void LogInToTheWebsite(){
        Log_In_Form log_in_form = new Log_In_Form(driver);
        log_in_form.LogInToTheWebsite(username, password);
    }

    @AfterTest
    public void closeTheWebsite() {driver.quit();}
}
