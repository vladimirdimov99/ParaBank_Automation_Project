package com.java_parabank_demo.Tests.Accounts_Services_Tests.Transfer_Funds_Tests;

import com.java_parabank_demo.Pages.Account_Services.Open_New_Account_Form;
import com.java_parabank_demo.Pages.Account_Services.Transfer_Funds_Form;
import com.java_parabank_demo.Pages.Authorization.Sign_Up_Form;
import com.java_parabank_demo.Pages.LoadTheWebsite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Transfer_Funds_To_The_Same_Acc_With_Empty_Amount_Field {
    WebDriver driver;
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
    private static String username = "papagala25";
    private static String password = "test123";
    private static String confirmPW = "test123";
    private static String amount = "";

    Duration timeout = Duration.ofSeconds(3);

    @BeforeTest
    public void OpenTheWebsite(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
        new LoadTheWebsite().LoadTheWebsite(driver);
    }

    @Test(priority = 1)
    public void checkIfTheWebsiteURLIsCorrect(){
        currentURL = driver.getCurrentUrl();
        expectedURL = "https://parabank.parasoft.com/parabank/index.htm";
        Assert.assertEquals(currentURL, expectedURL);
    }

    @Test(priority = 2)
    public void GoToTheSignUpForm(){
        Sign_Up_Form sign_up_form = new Sign_Up_Form(driver);
        sign_up_form.GoToTheSignUpForm();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(sign_up_form.signUpTitle));
        String signingUpIsEasyText = driver.findElement(sign_up_form.signUpTitle).getText();
        Assert.assertEquals(signingUpIsEasyText, "Signing up is easy!");
    }

    @Test(priority = 3)
    public void SignUpToTheWebsite(){
        Sign_Up_Form sign_up_form = new Sign_Up_Form(driver);
        sign_up_form.SignUpToTheWebsite(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password, confirmPW);
        sign_up_form.ClickOnRegisterSubmitButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(sign_up_form.signUpTitle));
        String welcomeMessage = driver.findElement(sign_up_form.signUpTitle).getText();
        Assert.assertTrue(welcomeMessage.contains(username));
    }

    @Test(priority = 4)
    public void GoToTheOpenNewAccountForm(){
        Open_New_Account_Form open_new_account_form = new Open_New_Account_Form(driver);
        open_new_account_form.GoToTheOpenNewAccountForm();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(open_new_account_form.openNewAccountTitle));
        String openNewAccountTitle = driver.findElement(open_new_account_form.openNewAccountTitle).getText();
        Assert.assertEquals(openNewAccountTitle, "Open New Account");
    }
    @Test(priority = 5)
    public void OpenNewCheckingAccount(){
        Open_New_Account_Form open_new_account_form = new Open_New_Account_Form(driver);
        open_new_account_form.OpenNewCheckingAccountAndDepositFromFirstAccount();
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeSelected(open_new_account_form.selectCheckingAccount));
        open_new_account_form.ClickOnTheOpenNewAccountButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(open_new_account_form.openNewAccountTitle));
        String openNewAccountTitle = driver.findElement(open_new_account_form.openNewAccountTitle).getText();
        Assert.assertEquals(openNewAccountTitle, "Account Opened!");
    }

    @Test(priority = 6)
    public void GoToTheTransferFundsForm(){
        Transfer_Funds_Form transfer_funds_form = new Transfer_Funds_Form(driver);
        transfer_funds_form.GoToTheTransferFundsForm();
        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(transfer_funds_form.transferFundsTitle));
        String transferFundsTitle = driver.findElement(transfer_funds_form.transferFundsTitle).getText();
        Assert.assertEquals(transferFundsTitle, "Transfer Funds");
    }

    @Test(priority = 7)
    public void TransferFundsFromTheSameAccountWithEmptyAmountField(){
        Transfer_Funds_Form transfer_funds_form = new Transfer_Funds_Form(driver);
        transfer_funds_form.TransferFundsFromTheSameAccount(amount);
        transfer_funds_form.ClickOnTheTransferButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(transfer_funds_form.amountError));
        String amountError = driver.findElement(transfer_funds_form.amountError).getText();
        Assert.assertEquals(amountError, "The amount cannot be empty.");
    }

    @AfterTest
    public void closeTheWebsite() {driver.quit();}
}
