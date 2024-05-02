package com.java_parabank_demo.Pages.Account_Services;

import com.java_parabank_demo.utils.LoadTheDriver;
import org.openqa.selenium.By;

public class Request_Loan_Form extends LoadTheDriver {

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
        getDriver().findElement(requestLoanButton).click();
        // Request Loan Form is displayed
    }

    public void enterLoanAmountAndApplyForLoanFromFirstAccount() {
        getDriver().findElement(loanAmountFieldLocator).click();
        getDriver().findElement(loanAmountFieldLocator).sendKeys("100");

        getDriver().findElement(downPaymentFieldLocator).click();
        driver.findElement(downPaymentFieldLocator).sendKeys("110");

        getDriver().findElement(fromAccountDropMenuLocator).click();
        getDriver().findElement(fromAccountDropMenuFirstAccount).click();

        // User successfully applied for a Loan
    }

    public void enterLoanAmountAndApplyForLoanFromSecondAccount() {
        getDriver().findElement(loanAmountFieldLocator).click();
        getDriver().findElement(loanAmountFieldLocator).sendKeys();

        getDriver().findElement(downPaymentFieldLocator).click();
        getDriver().findElement(downPaymentFieldLocator).sendKeys();

        getDriver().findElement(fromAccountDropMenuLocator).click();
        getDriver().findElement(fromAccountDropMenuSecondAccount).click();

        // User successfully applied for a Loan
    }

    public void clickOnApplyNowButton() {
        getDriver().findElement(applyNowButton).click();
    }

    public void clickOnNewAccountIDLinkButton() {
        getDriver().findElement(newAccountId).click();
    }
}
