package com.java_parabank_demo.Pages.Account_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Transfer_Funds_Form {
    WebDriver driver;
    public Transfer_Funds_Form (WebDriver driver) {this.driver = driver;}

    By transferFundsButton = By.linkText("Transfer Funds");
    By amountField = By.id("amount");
    By fromAccountId = By.id("fromAccountId");
    By toAccountId = By.id("toAccountId");

    public By transferButton = By.cssSelector("input[value='Transfer']");
    public By transferFundsForm = By.className("ng-scope");
    public By transferFundsTitle = By.className("title");
    public By amountError = By.id("amount.errors");


    public void GoToTheTransferFundsForm(){
        driver.findElement(transferFundsButton).click();
    }

    public void TransferFundsFromTheSameAccount(String amount){
        driver.findElement(fromAccountId).click();
        driver.findElement(toAccountId).click();
        driver.findElement(amountField).click();
        driver.findElement(amountField).sendKeys(amount);
    }

    public void ClickOnTheTransferButton(){
        driver.findElement(transferButton).click();
    }
}
