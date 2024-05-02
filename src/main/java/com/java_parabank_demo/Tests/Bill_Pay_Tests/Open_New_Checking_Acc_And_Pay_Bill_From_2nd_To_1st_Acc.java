package com.java_parabank_demo.Tests.Bill_Pay_Tests;

import com.java_parabank_demo.Pages.Account_Services.Bill_Pay_Form;
import com.java_parabank_demo.Pages.Account_Services.Open_New_Account_Form;
import com.java_parabank_demo.Pages.Authorization.Sign_Up_Form;
import com.java_parabank_demo.utils.LoadTheDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Open_New_Checking_Acc_And_Pay_Bill_From_2nd_To_1st_Acc extends LoadTheDriver {

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
    private static String username = "growth77";
    private static String password = "test123";
    private static String confirmPW = "test123";
    private static String amount = "100";
    String secondAcc;
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

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sign_up_form.signUpForm));
        String signingUpIsEasyText = getDriver().findElement(sign_up_form.signUpTitle).getText();
        Assert.assertEquals(signingUpIsEasyText, "Signing up is easy!");
    }

    @Test(priority = 3)
    public void signUpToTheWebsite() {
        Sign_Up_Form sign_up_form = new Sign_Up_Form();
        sign_up_form.SignUpToTheWebsite(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password, confirmPW);
        sign_up_form.ClickOnRegisterSubmitButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sign_up_form.signUpTitle));
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
    public void openNewCheckingAccountAndDepositFromSecondAccount() {
        Open_New_Account_Form open_new_account_form = new Open_New_Account_Form();
        //Default drop menu is set to CHECKING account
        open_new_account_form.openNewCheckingAccountAndDepositFromFirstAccount();
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(open_new_account_form.openNewAccountSubmitButton));
        open_new_account_form.clickOnTheOpenNewAccountButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(open_new_account_form.createdNewAccountID));
        secondAcc = getDriver().findElement(open_new_account_form.createdNewAccountID).getText();
        String openNewAccountTitle = getDriver().findElement(open_new_account_form.openNewAccountTitle).getText();
        Assert.assertEquals(openNewAccountTitle, "Account Opened!");
    }

    @Test(priority = 6)
    public void goToTheBillPayForm() {
        Bill_Pay_Form bill_pay_form = new Bill_Pay_Form();
        bill_pay_form.goToTheBillPayForm();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(bill_pay_form.billPayTitle));
        String billPayTitle = getDriver().findElement(bill_pay_form.billPayTitle).getText();
        Assert.assertEquals(billPayTitle, "Bill Payment Service");
    }

    @Test(priority = 7)
    public void enterPayeeInformation() {
        Bill_Pay_Form bill_pay_form = new Bill_Pay_Form();
        bill_pay_form.payABillWithTheSecondAccount(firstName, address, city, state, zipCode, phone, secondAcc, secondAcc, amount);
        bill_pay_form.clickOnTheSendPaymentButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(bill_pay_form.billPayTitle));
        String billPayTitle = getDriver().findElement(bill_pay_form.billPayTitle).getText();
        Assert.assertEquals(billPayTitle, "Bill Payment Complete");
    }

    @AfterTest
    public void closeTheWebsite() {
        quitTheDriver();
    }
}
