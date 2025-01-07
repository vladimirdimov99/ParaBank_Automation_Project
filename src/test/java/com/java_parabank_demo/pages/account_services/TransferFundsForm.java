package com.java_parabank_demo.pages.account_services;

import com.java_parabank_demo.utils.TestBase;
import org.openqa.selenium.By;

public class TransferFundsForm extends TestBase {

    By transferFundsButton = By.linkText("Transfer Funds");
    By amountField = By.id("amount");
    By fromAccountId = By.id("fromAccountId");
    By toAccountId = By.id("toAccountId");

    public By transferButton = By.cssSelector("input[value='Transfer']");
    public By transferFundsForm = By.className("ng-scope");
    public By transferFundsTitle = By.className("title");
    public By amountError = By.id("amount.errors");


    public void goToTheTransferFundsForm() {
        getDriver().findElement(transferFundsButton).click();
    }

    public void transferFundsFromTheSameAccount(String amount) {
        getDriver().findElement(fromAccountId).click();
        getDriver().findElement(toAccountId).click();
        getDriver().findElement(amountField).click();
        getDriver().findElement(amountField).sendKeys(amount);
    }

    public void clickOnTheTransferButton() {
        getDriver().findElement(transferButton).click();
    }
}
