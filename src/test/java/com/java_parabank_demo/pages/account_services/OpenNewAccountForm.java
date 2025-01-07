package com.java_parabank_demo.pages.account_services;

import com.java_parabank_demo.utils.TestBase;
import org.openqa.selenium.By;

public class OpenNewAccountForm extends TestBase {

    By openNewAccountButton = By.linkText("Open New Account");
    By accountTypeDropMenuLocator = By.id("type");
    By selectAccountDropMenuLocator = By.id("fromAccountId");
    public By openNewAccountSubmitButton = By.cssSelector("input[type='submit']");
    public By selectCheckingAccount = By.xpath("//*[@id='type']/option[1]");
    public By selectSavingsAccount = By.xpath("//*[@id='type']/option[2]");

    public By selectTheFirstAccount = By.xpath("//*[@id='fromAccountId']/option[1]");
    public By selectTheSecondAccount = By.xpath("//*[@id='fromAccountId']/option[2]");
    public By openNewAccountTitle = By.xpath("//*[@id='rightPanel']/div/div/h1[1]");
    public By openNewAccountForm = By.className("ng-scope");
    public By createdNewAccountID = By.id("newAccountId");

    public void goToTheOpenNewAccountForm() {
        driver().findElement(openNewAccountButton).click();
        // Open New Account Form is displayed
    }

    public void openNewCheckingAccountAndDepositFromSecondAccount() {
        driver().findElement(accountTypeDropMenuLocator).click();
        driver().findElement(selectCheckingAccount).click();

        driver().findElement(selectAccountDropMenuLocator).click();
        driver().findElement(selectTheSecondAccount).click();
    }

    public void openNewSavingsAccountAndDepositFromFirstAccount() {
        driver().findElement(accountTypeDropMenuLocator).click();
        driver().findElement(selectSavingsAccount).click();

        driver().findElement(selectAccountDropMenuLocator).click();
        driver().findElement(selectTheFirstAccount).click();
    }

    public void openNewCheckingAccountAndDepositFromFirstAccount() {
        driver().findElement(accountTypeDropMenuLocator).click();
        driver().findElement(selectCheckingAccount).click();

        driver().findElement(selectAccountDropMenuLocator).click();
        driver().findElement(selectTheFirstAccount).click();
    }

    public void clickOnTheOpenNewAccountButton() {
        driver().findElement(openNewAccountSubmitButton).click();
    }
}
