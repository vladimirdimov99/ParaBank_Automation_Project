package com.java_parabank_demo.tests.accounts_services_tests.open_new_account_tests;

import com.java_parabank_demo.pages.account_services.OpenNewAccountForm;
import com.java_parabank_demo.pages.authorization.LogInForm;
import com.java_parabank_demo.utils.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class OpenNewCHECKINGAccAndDepositFromSecondAcc extends TestBase {

    String currentURL;
    String expectedURL;
    String openNewAccountTitle;

    private static String firstName = "Vladimir";
    private static String lastName = "Dimov";
    private static String address = "Sofia";
    private static String city = "Sofia";
    private static String state = "Sofia";
    private static String zipCode = "12345";
    private static String phone = "12345";
    private static String ssn = "12345";
    private static String username = "growth44";
    private static String password = "test123";
    private static String confirmPW = "test123";

    Duration timeout = Duration.ofSeconds(3);
    LogInForm logInForm = new LogInForm();
    OpenNewAccountForm openNewAccountForm = new OpenNewAccountForm();

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
    public void logInToTheWebsite() {
        logInForm.LogInToTheWebsite(username, password);

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(logInForm.welcomeMessageTextLocator));
        String welcomeLogInMessage = driver.findElement(logInForm.welcomeMessageTextLocator).getText();
        assertTrue(welcomeLogInMessage.contains(firstName + lastName));
    }

    @Test(priority = 3)
    public void goToTheOpenNewAccountForm() {
        openNewAccountForm.goToTheOpenNewAccountForm();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(openNewAccountForm.openNewAccountTitle));
        openNewAccountTitle = driver.findElement(openNewAccountForm.openNewAccountTitle).getText();
        assertEquals(openNewAccountTitle, "Open New Account");
    }

    @Test(priority = 4)
    public void openNewCheckingAccountAndDepositFromSecondAccount() {
        openNewAccountForm.openNewCheckingAccountAndDepositFromSecondAccount();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeSelected(openNewAccountForm.selectTheSecondAccount));
        openNewAccountForm.clickOnTheOpenNewAccountButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(openNewAccountForm.openNewAccountTitle));
        openNewAccountTitle = driver.findElement(openNewAccountForm.openNewAccountTitle).getText();
        assertEquals(openNewAccountTitle, "Account Opened!");
    }

    @AfterTest
    public void closeTheWebsite() {
        quitTheDriver();
    }
}
