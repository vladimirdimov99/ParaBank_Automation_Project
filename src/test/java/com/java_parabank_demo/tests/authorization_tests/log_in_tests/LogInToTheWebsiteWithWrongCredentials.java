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

public class LogInToTheWebsiteWithWrongCredentials extends TestBase {

    String currentURL;
    String expectedURL;
    String firstName = "Vladimir";
    String lastName = "Dimov";
    String username = "zazadada";
    String password = "fafa333";
    Duration timeout = Duration.ofSeconds(3);

    @BeforeTest
    public void openTheWebsite() throws Exception {
        initializeBrowserDriver();
        loadTheWebsite();
    }

    @Test(priority = 1)
    public void checkIfTheWebsiteURLIsCorrect() {
        currentURL = getDriver().getCurrentUrl();
        expectedURL = "https://parabank.parasoft.com/parabank/index.htm";
        assertEquals(currentURL, expectedURL);
    }

    @Test(priority = 2)
    public void logInToTheWebsite() {
        LogInForm log_in_form = new LogInForm();
        log_in_form.LogInToTheWebsite(username, password);
        log_in_form.ClickOnTheLogInButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(log_in_form.welcomeMessageTextLocator));
        String welcomeLogInMessage = getDriver().findElement(log_in_form.welcomeMessageTextLocator).getText();
        assertTrue(welcomeLogInMessage.contains(firstName + lastName));
    }

    @AfterTest
    public void closeTheWebsite() {
        quitTheDriver();
    }
}
