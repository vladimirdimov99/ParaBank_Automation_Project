package com.java_parabank_demo.Pages.Account_Services;

import com.java_parabank_demo.utils.LoadTheDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Open_New_Account_Form extends LoadTheDriver {

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

    public void GoToTheOpenNewAccountForm() {
        getDriver().findElement(openNewAccountButton).click();
        // Open New Account Form is displayed
    }

    public void OpenNewCheckingAccountAndDepositFromSecondAccount() {
        getDriver().findElement(accountTypeDropMenuLocator).click();
        getDriver().findElement(selectCheckingAccount).click();

        getDriver().findElement(selectAccountDropMenuLocator).click();
        getDriver().findElement(selectTheSecondAccount).click();
    }

    public void OpenNewSavingsAccountAndDepositFromFirstAccount() {
        getDriver().findElement(accountTypeDropMenuLocator).click();
        getDriver().findElement(selectSavingsAccount).click();

        getDriver().findElement(selectAccountDropMenuLocator).click();
        getDriver().findElement(selectTheFirstAccount).click();
    }

    public void OpenNewCheckingAccountAndDepositFromFirstAccount() {
        getDriver().findElement(accountTypeDropMenuLocator).click();
        getDriver().findElement(selectCheckingAccount).click();

        getDriver().findElement(selectAccountDropMenuLocator).click();
        getDriver().findElement(selectTheFirstAccount).click();
    }

    public void ClickOnTheOpenNewAccountButton() {
        getDriver().findElement(openNewAccountSubmitButton).click();
    }
}
