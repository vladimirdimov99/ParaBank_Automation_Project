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
        getDriver().findElement(openNewAccountButton).click();
        // Open New Account Form is displayed
    }

    public void openNewCheckingAccountAndDepositFromSecondAccount() {
        getDriver().findElement(accountTypeDropMenuLocator).click();
        getDriver().findElement(selectCheckingAccount).click();

        getDriver().findElement(selectAccountDropMenuLocator).click();
        getDriver().findElement(selectTheSecondAccount).click();
    }

    public void openNewSavingsAccountAndDepositFromFirstAccount() {
        getDriver().findElement(accountTypeDropMenuLocator).click();
        getDriver().findElement(selectSavingsAccount).click();

        getDriver().findElement(selectAccountDropMenuLocator).click();
        getDriver().findElement(selectTheFirstAccount).click();
    }

    public void openNewCheckingAccountAndDepositFromFirstAccount() {
        getDriver().findElement(accountTypeDropMenuLocator).click();
        getDriver().findElement(selectCheckingAccount).click();

        getDriver().findElement(selectAccountDropMenuLocator).click();
        getDriver().findElement(selectTheFirstAccount).click();
    }

    public void clickOnTheOpenNewAccountButton() {
        getDriver().findElement(openNewAccountSubmitButton).click();
    }
}
