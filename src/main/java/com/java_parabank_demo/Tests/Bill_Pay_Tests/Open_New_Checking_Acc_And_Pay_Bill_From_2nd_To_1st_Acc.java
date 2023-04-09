package com.java_parabank_demo.Tests.Bill_Pay_Tests;

import com.java_parabank_demo.Pages.Account_Services.Bill_Pay_Form;
import com.java_parabank_demo.Pages.Account_Services.Open_New_Account_Form;
import com.java_parabank_demo.Pages.Authorization.Sign_Up_Form;
import com.java_parabank_demo.Pages.LoadTheWebsite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Open_New_Checking_Acc_And_Pay_Bill_From_2nd_To_1st_Acc {
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
    private static String username = "papagala69";
    private static String password = "test123";
    private static String confirmPW = "test123";
    private static String amount = "100";
    String secondAcc;
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

        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sign_up_form.signUpForm));
        String signingUpIsEasyText = driver.findElement(sign_up_form.signUpTitle).getText();
        Assert.assertEquals(signingUpIsEasyText, "Signing up is easy!");
    }

    @Test(priority = 3)
    public void SignUpToTheWebsite(){
        Sign_Up_Form sign_up_form = new Sign_Up_Form(driver);
        sign_up_form.SignUpToTheWebsite(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password, confirmPW);

        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sign_up_form.signUpTitle));
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
    public void OpenNewCheckingAccountAndDepositFromSecondAccount(){
        Open_New_Account_Form open_new_account_form = new Open_New_Account_Form(driver);
        //Default drop menu is set to CHECKING account
        open_new_account_form.OpenNewCheckingAccountAndDepositFromFirst();
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(open_new_account_form.openNewAccountSubmitButton));
        open_new_account_form.ClickOnTheOpenNewAccountButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(open_new_account_form.createdNewAccountID));
        secondAcc = driver.findElement(open_new_account_form.createdNewAccountID).getText();
        String openNewAccountTitle = driver.findElement(open_new_account_form.openNewAccountTitle).getText();
        Assert.assertEquals(openNewAccountTitle, "Account Opened!");
    }

    @Test(priority = 6)
    public void GoToTheBillPayForm(){
        Bill_Pay_Form bill_pay_form = new Bill_Pay_Form(driver);
        bill_pay_form.GoToTheBillPayForm();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(bill_pay_form.billPayTitle));
        String billPayTitle = driver.findElement(bill_pay_form.billPayTitle).getText();
        Assert.assertEquals(billPayTitle, "Bill Payment Service");
    }

    @Test(priority = 7)
    public void EnterPayeeInformation(){
        Bill_Pay_Form bill_pay_form = new Bill_Pay_Form(driver);
        bill_pay_form.PayABillWithTheSecondAccount(firstName, address, city, state, zipCode, phone, secondAcc, secondAcc,amount);
        bill_pay_form.ClickOnTheSendPaymentButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(bill_pay_form.billPayTitle));
        String billPayTitle = driver.findElement(bill_pay_form.billPayTitle).getText();
        Assert.assertEquals(billPayTitle, "Bill Payment Complete");
    }
}
