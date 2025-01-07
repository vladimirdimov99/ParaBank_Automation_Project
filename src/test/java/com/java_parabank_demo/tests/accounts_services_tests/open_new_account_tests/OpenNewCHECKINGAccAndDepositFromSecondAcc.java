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

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(log_in_form.welcomeMessageTextLocator));
        String welcomeLogInMessage = getDriver().findElement(log_in_form.welcomeMessageTextLocator).getText();
        assertTrue(welcomeLogInMessage.contains(firstName + lastName));
    }

    @Test(priority = 3)
    public void goToTheOpenNewAccountForm() {
        OpenNewAccountForm open_new_account_form = new OpenNewAccountForm();
        open_new_account_form.goToTheOpenNewAccountForm();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(open_new_account_form.openNewAccountTitle));
        openNewAccountTitle = getDriver().findElement(open_new_account_form.openNewAccountTitle).getText();
        assertEquals(openNewAccountTitle, "Open New Account");
    }

    @Test(priority = 4)
    public void openNewCheckingAccountAndDepositFromSecondAccount() {
        OpenNewAccountForm open_new_account_form = new OpenNewAccountForm();
        open_new_account_form.openNewCheckingAccountAndDepositFromSecondAccount();
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.elementToBeSelected(open_new_account_form.selectTheSecondAccount));
        open_new_account_form.clickOnTheOpenNewAccountButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(open_new_account_form.openNewAccountTitle));
        openNewAccountTitle = getDriver().findElement(open_new_account_form.openNewAccountTitle).getText();
        assertEquals(openNewAccountTitle, "Account Opened!");
    }

    @AfterTest
    public void closeTheWebsite() {
        quitTheDriver();
    }
}
