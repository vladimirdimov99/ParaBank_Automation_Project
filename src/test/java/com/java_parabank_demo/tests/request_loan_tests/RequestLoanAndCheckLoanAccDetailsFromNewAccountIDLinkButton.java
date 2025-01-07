package com.java_parabank_demo.tests.request_loan_tests;

import com.java_parabank_demo.pages.account_services.RequestLoanForm;
import com.java_parabank_demo.pages.authorization.SignUpForm;
import com.java_parabank_demo.utils.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class RequestLoanAndCheckLoanAccDetailsFromNewAccountIDLinkButton extends TestBase {

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
    private static String username = "growth31";
    private static String password = "test123";
    private static String confirmPW = "test123";
    Duration timeout = Duration.ofSeconds(3);
    SignUpForm signUpForm = new SignUpForm();
    RequestLoanForm requestLoanForm = new RequestLoanForm();

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
        signUpForm.GoToTheSignUpForm();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(signUpForm.signUpTitle));
        String signingUpIsEasyText = getDriver().findElement(signUpForm.signUpTitle).getText();
        assertEquals(signingUpIsEasyText, "Signing up is easy!");
    }

    @Test(priority = 3)
    public void signUpToTheWebsite() {
        signUpForm.SignUpToTheWebsite(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password, confirmPW);
        signUpForm.ClickOnRegisterSubmitButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(signUpForm.signUpTitle));
        String welcomeMessage = getDriver().findElement(signUpForm.signUpTitle).getText();
        assertTrue(welcomeMessage.contains(username));
    }

    @Test(priority = 4)
    public void goToTheRequestLoanForm() {
        requestLoanForm.goToTheRequestLoanForm();
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(requestLoanForm.requestLoanTitle));
        String requestLoanTitle = getDriver().findElement(requestLoanForm.requestLoanTitle).getText();
        assertEquals(requestLoanTitle, "Apply for a Loan");
    }

    @Test(priority = 5)
    public void requestLoanFromFirstAccount() {
        requestLoanForm.enterLoanAmountAndApplyForLoanFromFirstAccount();
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.elementToBeSelected(requestLoanForm.fromAccountDropMenuFirstAccount));
        requestLoanForm.clickOnApplyNowButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(requestLoanForm.loanStatus));
        String loanMessage = getDriver().findElement(requestLoanForm.loanStatus).getText();
        assertEquals(loanMessage, "Approved");
    }

    @Test(priority = 6)
    public void checkLoanAccDetailsFromNewAccountIDLinkButton() {
        requestLoanForm.clickOnNewAccountIDLinkButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(requestLoanForm.accountType));
        String accountType = getDriver().findElement(requestLoanForm.accountType).getText();
        assertEquals(accountType, "LOAN");
    }

    @AfterTest
    public void closeTheWebsite() {
        quitTheDriver();
    }
}
