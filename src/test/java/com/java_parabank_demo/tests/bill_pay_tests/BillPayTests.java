package com.java_parabank_demo.tests.bill_pay_tests;

import com.java_parabank_demo.pages.account_services.BillPayForm;
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

public class BillPayTests extends TestBase {

    String currentURL;
    String expectedURL;

    private final String firstName = "Vladimir";
    private final String lastName = "Dimov";
    private final String address = "Sofia";
    private final String city = "Sofia";
    private final String state = "Sofia";
    private final String zipCode = "12345";
    private final String phone = "12345";
    private final String ssn = "12345";
    private final String username = "growth77";
    private final String password = "test123";
    private final String confirmPW = "test123";
    private final String amount = "100";

    String secondAcc;
    Duration timeout = Duration.ofSeconds(3);
    SignUpForm signUpForm = new SignUpForm();
    BillPayForm billPayForm = new BillPayForm();
    OpenNewAccountForm openNewAccountForm = new OpenNewAccountForm();

    @BeforeTest
    public void openTheWebsite() throws Exception {
        initializeBrowserDriver();
        loadTheWebsite();
    }

    @Test(priority = 1)
    public void checkIfTheWebsiteURLIsCorrect() {
        currentURL = getDriver().getCurrentUrl();
        expectedURL = "https://parabank.parasoft.com/parabank/index.htm";
        assertTrue(currentURL.contains(expectedURL));
    }

    @Test(priority = 2)
    public void goToTheSignUpForm() {
        signUpForm.GoToTheSignUpForm();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(signUpForm.signUpForm));
        String signingUpIsEasyText = getDriver().findElement(signUpForm.signUpTitle).getText();
        assertEquals(signingUpIsEasyText, "Signing up is easy!");
    }

    @Test(priority = 3)
    public void signUpToTheWebsite() {
        signUpForm.SignUpToTheWebsite(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password, confirmPW);
        signUpForm.ClickOnRegisterSubmitButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(signUpForm.signUpTitle));
        String welcomeMessage = getDriver().findElement(signUpForm.signUpTitle).getText();
        assertTrue(welcomeMessage.contains(username));
    }

    @Test(priority = 4)
    public void goToTheOpenNewAccountForm() {
        openNewAccountForm.goToTheOpenNewAccountForm();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(openNewAccountForm.openNewAccountTitle));
        String openNewAccountTitle = getDriver().findElement(openNewAccountForm.openNewAccountTitle).getText();
        assertEquals(openNewAccountTitle, "Open New Account");
    }

    @Test(priority = 5)
    public void openNewCheckingAccountAndDepositFromSecondAccount() {
        //Default drop menu is set to CHECKING account
        openNewAccountForm.openNewCheckingAccountAndDepositFromFirstAccount();
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.elementToBeClickable(openNewAccountForm.openNewAccountSubmitButton));
        openNewAccountForm.clickOnTheOpenNewAccountButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(openNewAccountForm.createdNewAccountID));
        secondAcc = getDriver().findElement(openNewAccountForm.createdNewAccountID).getText();
        String openNewAccountTitle = getDriver().findElement(openNewAccountForm.openNewAccountTitle).getText();
        assertEquals(openNewAccountTitle, "Account Opened!");
    }

    @Test(priority = 6)
    public void goToTheBillPayForm() {
        billPayForm.goToTheBillPayForm();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(billPayForm.billPayTitle));
        String billPayTitle = getDriver().findElement(billPayForm.billPayTitle).getText();
        assertEquals(billPayTitle, "Bill Payment Service");
    }

    @Test(priority = 7)
    public void enterPayeeInformation() {
        billPayForm.payABillWithTheSecondAccount(firstName, address, city, state, zipCode, phone, secondAcc, secondAcc, amount);
        billPayForm.clickOnTheSendPaymentButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(billPayForm.billPayTitle));
        String billPayTitle = getDriver().findElement(billPayForm.billPayTitle).getText();
        assertEquals(billPayTitle, "Bill Payment Complete");
    }

    @AfterTest
    public void closeTheWebsite() {
        quitTheDriver();
    }
}
