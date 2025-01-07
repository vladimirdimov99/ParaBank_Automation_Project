package com.java_parabank_demo.tests.accounts_services_tests.open_new_account_tests;

import com.java_parabank_demo.pages.account_services.OpenNewAccountForm;
import com.java_parabank_demo.pages.authorization.SignUpForm;
import com.java_parabank_demo.utils.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class OpenNewSAVINGSAccAndDepositFromFirstAcc extends TestBase {

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
    private static String username = "growth45";
    private static String password = "test123";
    private static String confirmPW = "test123";

    Duration timeout = Duration.ofSeconds(3);
    SignUpForm signUpForm = new SignUpForm();
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
    public void goToTheSignUpForm() {
        signUpForm.GoToTheSignUpForm();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(signUpForm.signUpTitle));
        String signingUpIsEasyText = driver.findElement(signUpForm.signUpTitle).getText();
        assertEquals(signingUpIsEasyText, "Signing up is easy!");
    }

    @Test(priority = 3)
    public void signUpToTheWebsite() {
        signUpForm.SignUpToTheWebsite(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password, confirmPW);
        signUpForm.ClickOnRegisterSubmitButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(signUpForm.signUpTitle));
        String welcomeMessage = driver.findElement(signUpForm.signUpTitle).getText();
        assertTrue(welcomeMessage.contains(username));
    }

    @Test(priority = 4)
    public void goToTheOpenNewAccountForm() {
        openNewAccountForm.goToTheOpenNewAccountForm();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(openNewAccountForm.openNewAccountTitle));
        openNewAccountTitle = driver.findElement(openNewAccountForm.openNewAccountTitle).getText();
        assertEquals(openNewAccountTitle, "Open New Account");
    }

    @Test(priority = 5)
    public void openNewSavingsAccountAndDepositFromFirstAccount() {
        openNewAccountForm.openNewSavingsAccountAndDepositFromFirstAccount();
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeSelected(openNewAccountForm.selectTheFirstAccount));
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
