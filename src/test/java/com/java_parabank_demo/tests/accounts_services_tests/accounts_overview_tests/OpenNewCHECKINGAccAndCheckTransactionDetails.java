package com.java_parabank_demo.tests.accounts_services_tests.accounts_overview_tests;

import com.java_parabank_demo.pages.account_services.AccountsOverviewForm;
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

public class OpenNewCHECKINGAccAndCheckTransactionDetails extends TestBase {

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
    private static String username = "papagala69";
    private static String password = "test123";
    private static String confirmPW = "test123";

    Duration timeout = Duration.ofSeconds(3);
    SignUpForm signUpForm = new SignUpForm();
    OpenNewAccountForm openNewAccountForm = new OpenNewAccountForm();
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
    public void goToTheOpenNewAccountForm() {
        openNewAccountForm.goToTheOpenNewAccountForm();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(openNewAccountForm.openNewAccountTitle));
        String openNewAccountTitle = driver.findElement(openNewAccountForm.openNewAccountTitle).getText();
        assertEquals(openNewAccountTitle, "Open New Account");
    }

    @Test(priority = 5)
    public void openNewCheckingAccountAndCheckAccDetails() {
        openNewAccountForm.openNewCheckingAccountAndDepositFromFirstAccount();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeSelected(openNewAccountForm.selectCheckingAccount));
        openNewAccountForm.clickOnTheOpenNewAccountButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(openNewAccountForm.openNewAccountTitle));
        String openNewAccountTitle = driver.findElement(openNewAccountForm.openNewAccountTitle).getText();
        assertEquals(openNewAccountTitle, "Account Opened!");
    }

    @Test(priority = 6)
    public void goToTheAccountOverviewForm() {
        accountsOverviewForm.goToTheAccountsOverviewForm();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(accountsOverviewForm.accountsOverviewForm));
        String accountsOverviewTitle = driver.findElement(accountsOverviewForm.accountsOverviewTitle).getText();
        assertEquals(accountsOverviewTitle, "Accounts Overview");
    }

    @Test(priority = 7)
    public void selectTheSecondAccAndCheckDetails() {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(accountsOverviewForm.secondAccount));
        accountsOverviewForm.selectTheSecondAccount();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(accountsOverviewForm.accountType));
        String accountType = driver.findElement(accountsOverviewForm.accountType).getText();
        assertEquals(accountType, "CHECKING");
    }

    @Test(priority = 8)
    public void checkTransactionDetails() {
        // From CHECKING Account the transaction type should be Debit
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(accountsOverviewForm.transactionLink));
        accountsOverviewForm.checkTransactionDetails();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(accountsOverviewForm.transactionType));
        String transactionType = driver.findElement(accountsOverviewForm.transactionType).getText();
        assertEquals(transactionType, "Debit");
    }

    @AfterTest
    public void closeTheWebsite() {
        quitTheDriver();
    }
}
