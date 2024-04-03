package com.java_parabank_demo.Pages.Account_Services;

import com.java_parabank_demo.utils.LoadTheDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Transfer_Funds_Form extends LoadTheDriver {

    By transferFundsButton = By.linkText("Transfer Funds");
    By amountField = By.id("amount");
    By fromAccountId = By.id("fromAccountId");
    By toAccountId = By.id("toAccountId");

    public By transferButton = By.cssSelector("input[value='Transfer']");
    public By transferFundsForm = By.className("ng-scope");
    public By transferFundsTitle = By.className("title");
    public By amountError = By.id("amount.errors");


    public void GoToTheTransferFundsForm(){
        getDriver().findElement(transferFundsButton).click();
    }

    public void TransferFundsFromTheSameAccount(String amount){
        getDriver().findElement(fromAccountId).click();
        getDriver().findElement(toAccountId).click();
        getDriver().findElement(amountField).click();
        getDriver().findElement(amountField).sendKeys(amount);
    }

    public void ClickOnTheTransferButton(){
        getDriver().findElement(transferButton).click();
    }
}
