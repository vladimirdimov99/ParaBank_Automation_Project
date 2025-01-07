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

public class TransferFundsToTheSameAccWithEmptyAmountField extends TestBase {

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
    private static String amount = "";

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

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(sign_up_form.signUpTitle));
        String signingUpIsEasyText = getDriver().findElement(sign_up_form.signUpTitle).getText();
        assertEquals(signingUpIsEasyText, "Signing up is easy!");
    }

    @Test(priority = 3)
    public void signUpToTheWebsite() {
        SignUpForm sign_up_form = new SignUpForm();
        sign_up_form.SignUpToTheWebsite(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password, confirmPW);
        sign_up_form.ClickOnRegisterSubmitButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(sign_up_form.signUpTitle));
        String welcomeMessage = getDriver().findElement(sign_up_form.signUpTitle).getText();
        assertTrue(welcomeMessage.contains(username));
    }

    @Test(priority = 4)
    public void goToTheOpenNewAccountForm() {
        OpenNewAccountForm open_new_account_form = new OpenNewAccountForm();
        open_new_account_form.goToTheOpenNewAccountForm();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(open_new_account_form.openNewAccountTitle));
        String openNewAccountTitle = getDriver().findElement(open_new_account_form.openNewAccountTitle).getText();
        assertEquals(openNewAccountTitle, "Open New Account");
    }

    @Test(priority = 5)
    public void openNewCheckingAccount() {
        OpenNewAccountForm open_new_account_form = new OpenNewAccountForm();
        open_new_account_form.openNewCheckingAccountAndDepositFromFirstAccount();
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.elementToBeSelected(open_new_account_form.selectCheckingAccount));
        open_new_account_form.clickOnTheOpenNewAccountButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(open_new_account_form.openNewAccountTitle));
        String openNewAccountTitle = getDriver().findElement(open_new_account_form.openNewAccountTitle).getText();
        assertEquals(openNewAccountTitle, "Account Opened!");
    }

    @Test(priority = 6)
    public void goToTheTransferFundsForm() {
        TransferFundsForm transfer_funds_form = new TransferFundsForm();
        transfer_funds_form.goToTheTransferFundsForm();
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(transfer_funds_form.transferFundsTitle));
        String transferFundsTitle = getDriver().findElement(transfer_funds_form.transferFundsTitle).getText();
        assertEquals(transferFundsTitle, "Transfer Funds");
    }

    @Test(priority = 7)
    public void transferFundsFromTheSameAccountWithEmptyAmountField() {
        TransferFundsForm transfer_funds_form = new TransferFundsForm();
        transfer_funds_form.transferFundsFromTheSameAccount(amount);
        transfer_funds_form.clickOnTheTransferButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(transfer_funds_form.amountError));
        String amountError = getDriver().findElement(transfer_funds_form.amountError).getText();
        assertEquals(amountError, "The amount cannot be empty.");
    }

    @AfterTest
    public void closeTheWebsite() {
        quitTheDriver();
    }
}
