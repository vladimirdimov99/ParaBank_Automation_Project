package com.java_parabank_demo.pages.account_services;

import com.java_parabank_demo.utils.TestBase;
import org.openqa.selenium.By;

public class RequestLoanForm extends TestBase {

    By requestLoanButton = By.linkText("Request Loan");
    By loanAmountFieldLocator = By.id("amount");
    By downPaymentFieldLocator = By.id("downPayment");
    By fromAccountDropMenuLocator = By.id("fromAccountId");
    public By applyNowButton = By.cssSelector("input[value='Apply Now']");
    public By fromAccountDropMenuFirstAccount = By.xpath("//*[@id='fromAccountId']/option[1]");
    By fromAccountDropMenuSecondAccount = By.xpath("//*[@id='fromAccountId']/option[2]");
    public By errorMessage = By.className("error");
    public By newAccountId = By.id("newAccountId");
    public By loanStatus = By.id("loanStatus");
    public By requestLoanForm = By.className("ng-scope");
    public By requestLoanTitle = By.className("title");
    public By accountType = By.id("accountType");

    public void goToTheRequestLoanForm() {
        driver().findElement(requestLoanButton).click();
        // Request Loan Form is displayed
    }

    public void enterLoanAmountAndApplyForLoanFromFirstAccount() {
        driver().findElement(loanAmountFieldLocator).click();
        driver().findElement(loanAmountFieldLocator).sendKeys("100");

        driver().findElement(downPaymentFieldLocator).click();
        driver.findElement(downPaymentFieldLocator).sendKeys("110");

        driver().findElement(fromAccountDropMenuLocator).click();
        driver().findElement(fromAccountDropMenuFirstAccount).click();

        // User successfully applied for a Loan
    }

    public void enterLoanAmountAndApplyForLoanFromSecondAccount() {
        driver().findElement(loanAmountFieldLocator).click();
        driver().findElement(loanAmountFieldLocator).sendKeys();

        driver().findElement(downPaymentFieldLocator).click();
        driver().findElement(downPaymentFieldLocator).sendKeys();

        driver().findElement(fromAccountDropMenuLocator).click();
        driver().findElement(fromAccountDropMenuSecondAccount).click();

        // User successfully applied for a Loan
    }

    public void clickOnApplyNowButton() {
        driver().findElement(applyNowButton).click();
    }

    public void clickOnNewAccountIDLinkButton() {
        driver().findElement(newAccountId).click();
    }
}
