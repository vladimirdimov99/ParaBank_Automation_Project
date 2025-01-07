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
    public void goToTheSignUpForm() {
        SignUpForm sign_up_form = new SignUpForm();
        sign_up_form.GoToTheSignUpForm();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sign_up_form.signUpForm));
        String signingUpIsEasyText = getDriver().findElement(sign_up_form.signUpTitle).getText();
        assertEquals(signingUpIsEasyText, "Signing up is easy!");
    }

    @Test(priority = 3)
    public void signUpToTheWebsite() {
        SignUpForm sign_up_form = new SignUpForm();
        sign_up_form.SignUpToTheWebsite(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password, confirmPW);
        sign_up_form.ClickOnRegisterSubmitButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sign_up_form.signUpTitle));
        String welcomeMessage = getDriver().findElement(sign_up_form.signUpTitle).getText();
        assertTrue(welcomeMessage.contains(username));
    }

    @Test(priority = 4)
    public void goToTheAccountOverviewForm() {
        AccountsOverviewForm accounts_overview_form = new AccountsOverviewForm();
        accounts_overview_form.goToTheAccountsOverviewForm();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(accounts_overview_form.accountsOverviewForm));
        accountsOverviewTitle = getDriver().findElement(accounts_overview_form.accountsOverviewTitle).getText();
        assertEquals(accountsOverviewTitle, "Accounts Overview");
    }

    @Test(priority = 5)
    public void selectTheFirstAccAndCheckDetails() {
        //The First Account type after registering should be a CHECKING Account
        AccountsOverviewForm accounts_overview_form = new AccountsOverviewForm();
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(accounts_overview_form.firstAccount));
        accounts_overview_form.selectTheFirstAccount();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(accounts_overview_form.accountType));
        String accountType = getDriver().findElement(accounts_overview_form.accountType).getText();
        assertEquals(accountType, "CHECKING");
    }

    @Test(priority = 6)
    public void checkAccountActivity() {
        // There should be no Transactions found since we just created our account
        // Activity Period and Transaction Type is left default on "All"

        AccountsOverviewForm accounts_overview_form = new AccountsOverviewForm();
        accounts_overview_form.checkAccountActivity();
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(accounts_overview_form.transactionActivityMessage));
        String transactionActivityMessage = getDriver().findElement(accounts_overview_form.transactionActivityMessage).getText();
        assertEquals(transactionActivityMessage, "No transactions found.");
    }

    @AfterTest
    public void closeTheWebsite() {
        quitTheDriver();
    }
}
