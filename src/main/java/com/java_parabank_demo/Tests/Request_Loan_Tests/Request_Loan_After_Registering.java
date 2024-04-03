package com.java_parabank_demo.Tests.Request_Loan_Tests;

import com.java_parabank_demo.Pages.Account_Services.Request_Loan_Form;
import com.java_parabank_demo.Pages.Authorization.Sign_Up_Form;
import com.java_parabank_demo.utils.LoadTheDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Request_Loan_After_Registering extends LoadTheDriver {

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

    @BeforeTest
    public void OpenTheWebsite() {
        new LoadTheDriver().LoadTheWebsite(getDriver());
    }

    @Test(priority = 1)
    public void checkIfTheWebsiteURLIsCorrect() {
        currentURL = getDriver().getCurrentUrl();
        expectedURL = "https://parabank.parasoft.com/parabank/index.htm";
        Assert.assertEquals(currentURL, expectedURL);
    }

    @Test(priority = 2)
    public void GoToTheSignUpForm() {
        Sign_Up_Form sign_up_form = new Sign_Up_Form();
        sign_up_form.GoToTheSignUpForm();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(sign_up_form.signUpTitle));
        String signingUpIsEasyText = getDriver().findElement(sign_up_form.signUpTitle).getText();
        Assert.assertEquals(signingUpIsEasyText, "Signing up is easy!");
    }

    @Test(priority = 3)
    public void SignUpToTheWebsite() {
        Sign_Up_Form sign_up_form = new Sign_Up_Form();
        sign_up_form.SignUpToTheWebsite(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password, confirmPW);
        sign_up_form.ClickOnRegisterSubmitButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(sign_up_form.signUpTitle));
        String welcomeMessage = getDriver().findElement(sign_up_form.signUpTitle).getText();
        Assert.assertTrue(welcomeMessage.contains(username));
    }

    @Test(priority = 4)
    public void GoToTheRequestLoanForm() {
        Request_Loan_Form request_loan_form = new Request_Loan_Form();
        request_loan_form.GoToTheRequestLoanForm();
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(request_loan_form.requestLoanTitle));
        String requestLoanTitle = getDriver().findElement(request_loan_form.requestLoanTitle).getText();
        Assert.assertEquals(requestLoanTitle, "Apply for a Loan");
    }

    @Test(priority = 5)
    public void RequestLoanFromFirstAccount() {
        Request_Loan_Form request_loan_form = new Request_Loan_Form();
        request_loan_form.EnterLoanAmountAndApplyForLoanFromFirstAccount();
        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.elementToBeSelected(request_loan_form.fromAccountDropMenuFirstAccount));
        request_loan_form.ClickOnApplyNowButton();

        new WebDriverWait(getDriver(), timeout).until(ExpectedConditions.presenceOfElementLocated(request_loan_form.loanStatus));
        String loanMessage = getDriver().findElement(request_loan_form.loanStatus).getText();
        Assert.assertEquals(loanMessage, "Approved");
    }

    @AfterTest
    public void closeTheWebsite() {
        quitTheDriver();
    }
}
