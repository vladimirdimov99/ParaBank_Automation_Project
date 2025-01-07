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
        driver().findElement(transferFundsButton).click();
    }

    public void transferFundsFromTheSameAccount(String amount) {
        driver().findElement(fromAccountId).click();
        driver().findElement(toAccountId).click();
        driver().findElement(amountField).click();
        driver().findElement(amountField).sendKeys(amount);
    }

    public void clickOnTheTransferButton() {
        driver().findElement(transferButton).click();
    }
}
