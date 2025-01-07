package com.java_parabank_demo.tests.accounts_services_tests.accounts_overview_tests;

import com.java_parabank_demo.pages.account_services.AccountsOverviewForm;
import com.java_parabank_demo.pages.authorization.SignUpForm;
import com.java_parabank_demo.utils.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class CheckFirstAccDetailsAndActivityAfterRegistering extends TestBase {

    String currentURL;
    String expectedURL;
    String accountsOverviewTitle;

    private static String firstName = "Vladimir";
    private static String lastName = "Dimov";
    private static String address = "Sofia";
    private static String city = "Sofia";
    private static String state = "Sofia";
    private static String zipCode = "12345";
    private static String phone = "12345";
    private static String ssn = "12345";
    private static String username = "papagala2";
    private static String password = "test123";
    private static String confirmPW = "test123";

    Duration timeout = Duration.ofSeconds(3);
    SignUpForm signUpForm = new SignUpForm();
    AccountsOverviewForm accountsOverviewForm = new AccountsOverviewForm();

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

        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(signUpForm.signUpForm));
        String signingUpIsEasyText = driver.findElement(signUpForm.signUpTitle).getText();
        assertEquals(signingUpIsEasyText, "Signing up is easy!");
    }

    @Test(priority = 3)
    public void signUpToTheWebsite() {
        signUpForm.SignUpToTheWebsite(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password, confirmPW);

        signUpForm.ClickOnRegisterSubmitButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(signUpForm.signUpTitle));
        String welcomeMessage = driver.findElement(signUpForm.signUpTitle).getText();
        assertTrue(welcomeMessage.contains(username));
    }

    @Test(priority = 4)
    public void goToTheAccountOverviewForm() {
        accountsOverviewForm.goToTheAccountsOverviewForm();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(accountsOverviewForm.accountsOverviewForm));
        accountsOverviewTitle = driver.findElement(accountsOverviewForm.accountsOverviewTitle).getText();
        assertEquals(accountsOverviewTitle, "Accounts Overview");
    }

    @Test(priority = 5)
    public void selectTheFirstAccAndCheckDetails() {
        //The First Account type after registering should be a CHECKING Account
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(accountsOverviewForm.firstAccount));
        accountsOverviewForm.selectTheFirstAccount();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(accountsOverviewForm.accountType));
        String accountType = driver.findElement(accountsOverviewForm.accountType).getText();
        assertEquals(accountType, "CHECKING");
    }

    @Test(priority = 6)
    public void checkAccountActivity() {
        // There should be no Transactions found since we just created our account
        // Activity Period and Transaction Type is left default on "All"
        accountsOverviewForm.checkAccountActivity();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(accountsOverviewForm.transactionActivityMessage));
        String transactionActivityMessage = driver.findElement(accountsOverviewForm.transactionActivityMessage).getText();
        assertEquals(transactionActivityMessage, "No transactions found.");
    }

    @AfterTest
    public void closeTheWebsite() {
        quitTheDriver();
    }
}
