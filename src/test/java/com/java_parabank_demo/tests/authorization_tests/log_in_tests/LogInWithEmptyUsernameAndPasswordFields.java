package com.java_parabank_demo.tests.authorization_tests.log_in_tests;

import com.java_parabank_demo.pages.authorization.LogInForm;
import com.java_parabank_demo.utils.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class LogInWithEmptyUsernameAndPasswordFields extends TestBase {

    String currentURL;
    String expectedURL;
    String firstName = "Vladimir";
    String lastName = "Dimov";
    String username = "growth77";
    String password = "test123";
    Duration timeout = Duration.ofSeconds(3);
    LogInForm logInForm = new LogInForm();

    @BeforeTest
    public void openTheWebsite() throws Exception {
        initializeBrowserDriver();
        loadTheWebsite();
    }

    @Test(priority = 1)
    public void checkIfTheWebsiteURLIsCorrect() {
        currentURL = driver.getCurrentUrl();
        expectedURL = "https://parabank.parasoft.com/parabank/index.htm";
        assertEquals(currentURL, expectedURL);
    }

    @Test(priority = 2)
    public void logInWithEmptyUsernameAndPassword() {
        logInForm.ClickOnTheLogInButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(logInForm.loginErrorMessage));
        String loginErrorMessage = driver.findElement(logInForm.loginErrorMessage).getText();
        assertEquals(loginErrorMessage, "An internal error has occurred and has been logged.");
    }

    @AfterTest
    public void closeTheWebsite() {
        quitTheDriver();
    }
}
