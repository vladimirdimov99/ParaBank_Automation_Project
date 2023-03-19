package com.java_parabank_demo.Tests;

import com.java_parabank_demo.Pages.Authorization.Log_In_Form;
import com.java_parabank_demo.Pages.LoadTheWebsite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogInToTheWebsite {
    WebDriver driver;
    String currentURL;
    String expectedURL;
    String firstName = "Vladimir";
    String lastName = "Dimov";
    String username = "papagala77";
    String password = "test123";
    Duration timeout = Duration.ofSeconds(3);

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

        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(log_in_form.leftPanelLocator));
        String welcomeLogInMessage = driver.findElement(log_in_form.welcomeMessageTextLocator).getText();
        Assert.assertTrue(welcomeLogInMessage.contains(firstName + lastName));
    }

    @AfterTest
    public void closeTheWebsite() {driver.quit();}
}
