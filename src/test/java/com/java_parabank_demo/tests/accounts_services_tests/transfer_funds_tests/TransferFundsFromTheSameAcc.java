package com.java_parabank_demo.tests.accounts_services_tests.transfer_funds_tests;

import com.java_parabank_demo.pages.account_services.OpenNewAccountForm;
import com.java_parabank_demo.pages.account_services.TransferFundsForm;
import com.java_parabank_demo.pages.authorization.SignUpForm;
import com.java_parabank_demo.utils.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class TransferFundsFromTheSameAcc extends TestBase {

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
    private static String username = "growth25";
    private static String password = "test123";
    private static String confirmPW = "test123";
    private static String amount = "100";

    Duration timeout = Duration.ofSeconds(3);
    SignUpForm signUpForm = new SignUpForm();
    TransferFundsForm transferFundsForm = new TransferFundsForm();

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
        OpenNewAccountForm open_new_account_form = new OpenNewAccountForm();
        open_new_account_form.goToTheOpenNewAccountForm();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(open_new_account_form.openNewAccountTitle));
        String openNewAccountTitle = driver.findElement(open_new_account_form.openNewAccountTitle).getText();
        assertEquals(openNewAccountTitle, "Open New Account");
    }

    @Test(priority = 5)
    public void openNewCheckingAccount() {
        OpenNewAccountForm openNewAccountForm = new OpenNewAccountForm();
        openNewAccountForm.openNewCheckingAccountAndDepositFromFirstAccount();
        new WebDriverWait(driver(), timeout).until(ExpectedConditions.elementToBeSelected(openNewAccountForm.selectCheckingAccount));
        openNewAccountForm.clickOnTheOpenNewAccountButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(openNewAccountForm.openNewAccountTitle));
        String openNewAccountTitle = driver.findElement(openNewAccountForm.openNewAccountTitle).getText();
        assertEquals(openNewAccountTitle, "Account Opened!");
    }

    @Test(priority = 6)
    public void goToTheTransferFundsForm() {
        transferFundsForm.goToTheTransferFundsForm();
        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(transferFundsForm.transferFundsTitle));
        String transferFundsTitle = driver.findElement(transferFundsForm.transferFundsTitle).getText();
        assertEquals(transferFundsTitle, "Transfer Funds");
    }

    @Test(priority = 7)
    public void transferFundsFromTheSameAccount() {
        transferFundsForm.transferFundsFromTheSameAccount(amount);
        transferFundsForm.clickOnTheTransferButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(transferFundsForm.transferFundsTitle));
        String transferCompleteMessage = driver.findElement(transferFundsForm.transferFundsTitle).getText();
        assertEquals(transferCompleteMessage, "Transfer Complete!");
    }

    @AfterTest
    public void closeTheWebsite() {
        quitTheDriver();
    }
}
