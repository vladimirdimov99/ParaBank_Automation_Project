package com.java_parabank_demo.Pages.Account_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Request_Loan_Form {
    WebDriver driver;
    public Request_Loan_Form (WebDriver driver) {this.driver = driver;}

    By requestLoanButton = By.linkText("Request Loan");
    By loanAmountFieldLocator = By.id("amount");
    By downPaymentFieldLocator = By.id("downPayment");
    By fromAccountDropMenuLocator = By.id("fromAccountId");
    By applyNowSubmitButton = By.cssSelector("input[value='Apply Now']");
    By fromAccountDropMenuFirstAccount = By.xpath("//*[@id='fromAccountId']/option[1]");
    By fromAccountDropMenuSecondAccount = By.xpath("//*[@id='fromAccountId']/option[2]");
    public By loanStatus = By.id("loanStatus");

    public By requestLoanForm = By.className("ng-scope");
    public By requestLoanTitle = By.className("title");

    public void GoToTheRequestLoanForm(){
        driver.findElement(requestLoanButton).click();
        // Request Loan Form is displayed
    }

    public void EnterCredentialsAndApplyForLoanFromFirstAccount(){
        driver.findElement(loanAmountFieldLocator).click();
        driver.findElement(loanAmountFieldLocator).sendKeys("100");

        driver.findElement(downPaymentFieldLocator).click();
        driver.findElement(downPaymentFieldLocator).sendKeys("110");

        driver.findElement(fromAccountDropMenuLocator).click();
        driver.findElement(fromAccountDropMenuFirstAccount).click();

        driver.findElement(applyNowSubmitButton).click();

        // User successfully applied for a Loan
    }

    public void EnterCredentialsAndApplyForLoanFromSecondAccount(){
        driver.findElement(loanAmountFieldLocator).click();
        driver.findElement(loanAmountFieldLocator).sendKeys();

        driver.findElement(downPaymentFieldLocator).click();
        driver.findElement(downPaymentFieldLocator).sendKeys();

        driver.findElement(fromAccountDropMenuLocator).click();
        driver.findElement(fromAccountDropMenuSecondAccount).click();

        driver.findElement(applyNowSubmitButton).click();

        // User successfully applied for a Loan
    }
}
