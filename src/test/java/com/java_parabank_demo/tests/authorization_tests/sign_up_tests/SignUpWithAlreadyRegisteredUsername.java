package com.java_parabank_demo.tests.authorization_tests.sign_up_tests;

import com.java_parabank_demo.pages.authorization.SignUpForm;
import com.java_parabank_demo.utils.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class SignUpWithAlreadyRegisteredUsername extends TestBase {

    String currentURL;
    String expectedURL;

    private static String firstName = "Vladimir";
    private static String lastName = "Dimov";
    private static String address = "Sofia";
    private static String city = "Sofia";
    private static String state = "Sofia";
    private static String zipCode = "12345";
    private static String phone = "12345";
    private static String ssn = "12345";
    private static String username = "growth27";
    private static String password = "test123";
    private static String confirmPW = "test123";
    Duration timeout = Duration.ofSeconds(3);
    SignUpForm signUpForm = new SignUpForm();

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

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(signUpForm.signUpTitle));
        String welcomeMessage = driver.findElement(signUpForm.signUpTitle).getText();
        assertTrue(welcomeMessage.contains(username));
    }

    @Test(priority = 4)
    public void logOutFromTheAccount() {
        new WebDriverWait(driver(), timeout).until(ExpectedConditions.elementToBeClickable(signUpForm.logOutButton));
        signUpForm.ClickOnLogOutButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(signUpForm.customerLoginTitle));
        String customerLoginTitle = driver.findElement(signUpForm.customerLoginTitle).getText();
        assertEquals(customerLoginTitle, "Customer Login");
    }

    @Test(priority = 5)
    public void goToTheSignUpFormAgain() {
        signUpForm.GoToTheSignUpForm();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(signUpForm.signUpTitle));
        String signingUpIsEasyText = driver.findElement(signUpForm.signUpTitle).getText();
        assertEquals(signingUpIsEasyText, "Signing up is easy!");
    }

    @Test(priority = 5)
    public void signUpToTheWebsiteAgain() {
        signUpForm.SignUpToTheWebsite(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password, confirmPW);
        signUpForm.ClickOnRegisterSubmitButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(signUpForm.usernameTakenError));
        String usernameTakenError = driver.findElement(signUpForm.usernameTakenError).getText();
        assertEquals(usernameTakenError, "This username already exists.");
    }

    @AfterTest
    public void closeTheWebsite() {
        quitTheDriver();
    }
}
