package com.java_parabank_demo.Tests.Accounts_Services_Tests.Transfer_Funds_Tests;

import com.java_parabank_demo.Pages.Account_Services.Open_New_Account_Form;
import com.java_parabank_demo.Pages.Account_Services.Transfer_Funds_Form;
import com.java_parabank_demo.Pages.Authorization.Sign_Up_Form;
import com.java_parabank_demo.utils.LoadTheDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Transfer_Funds_To_The_Same_Acc_With_Empty_Amount_Field extends LoadTheDriver {

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
    public void openTheWebsite() {
        new LoadTheDriver().loadTheWebsite(getDriver());
    }

    @Test(priority = 1)
    public void checkIfTheWebsiteURLIsCorrect() {
        currentURL = getDriver().getCurrentUrl();
        expectedURL = "https://parabank.parasoft.com/parabank/index.htm";
        Assert.assertEquals(currentURL, expectedURL);
    }

    @Test(priority = 2)
    public void goToTheSignUpForm() {
        Sign_Up_Form sign_up_form = new Sign_Up_Form();
        sign_up_form.GoToTheSignUpForm();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(sign_up_form.signUpTitle));
        String signingUpIsEasyText = getDriver().findElement(sign_up_form.signUpTitle).getText();
        Assert.assertEquals(signingUpIsEasyText, "Signing up is easy!");
    }

    @Test(priority = 3)
    public void signUpToTheWebsite() {
        Sign_Up_Form sign_up_form = new Sign_Up_Form();
        sign_up_form.SignUpToTheWebsite(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password, confirmPW);
        sign_up_form.ClickOnRegisterSubmitButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(sign_up_form.signUpTitle));
        String welcomeMessage = getDriver().findElement(sign_up_form.signUpTitle).getText();
        Assert.assertTrue(welcomeMessage.contains(username));
    }

    @Test(priority = 4)
    public void goToTheOpenNewAccountForm() {
        Open_New_Account_Form open_new_account_form = new Open_New_Account_Form();
        open_new_account_form.goToTheOpenNewAccountForm();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(open_new_account_form.openNewAccountTitle));
        String openNewAccountTitle = getDriver().findElement(open_new_account_form.openNewAccountTitle).getText();
        Assert.assertEquals(openNewAccountTitle, "Open New Account");
    }

    @Test(priority = 5)
    public void openNewCheckingAccount() {
        Open_New_Account_Form open_new_account_form = new Open_New_Account_Form();
        open_new_account_form.openNewCheckingAccountAndDepositFromFirstAccount();
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.elementToBeSelected(open_new_account_form.selectCheckingAccount));
        open_new_account_form.clickOnTheOpenNewAccountButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(open_new_account_form.openNewAccountTitle));
        String openNewAccountTitle = getDriver().findElement(open_new_account_form.openNewAccountTitle).getText();
        Assert.assertEquals(openNewAccountTitle, "Account Opened!");
    }

    @Test(priority = 6)
    public void goToTheTransferFundsForm() {
        Transfer_Funds_Form transfer_funds_form = new Transfer_Funds_Form();
        transfer_funds_form.goToTheTransferFundsForm();
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(transfer_funds_form.transferFundsTitle));
        String transferFundsTitle = getDriver().findElement(transfer_funds_form.transferFundsTitle).getText();
        Assert.assertEquals(transferFundsTitle, "Transfer Funds");
    }

    @Test(priority = 7)
    public void transferFundsFromTheSameAccountWithEmptyAmountField() {
        Transfer_Funds_Form transfer_funds_form = new Transfer_Funds_Form();
        transfer_funds_form.transferFundsFromTheSameAccount(amount);
        transfer_funds_form.clickOnTheTransferButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(transfer_funds_form.amountError));
        String amountError = getDriver().findElement(transfer_funds_form.amountError).getText();
        Assert.assertEquals(amountError, "The amount cannot be empty.");
    }

    @AfterTest
    public void closeTheWebsite() {
        quitTheDriver();
    }
}
