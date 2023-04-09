package com.java_parabank_demo.Pages.Account_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Open_New_Account_Form {
    WebDriver driver;
    public Open_New_Account_Form (WebDriver driver) {this.driver = driver;}

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

    public void GoToTheOpenNewAccountForm(){
        driver.findElement(openNewAccountButton).click();
        // Open New Account Form is displayed
    }

    public void OpenNewCheckingAccountAndDepositFromSecondAccount(){
        driver.findElement(accountTypeDropMenuLocator).click();
        driver.findElement(selectCheckingAccount).click();

        driver.findElement(selectAccountDropMenuLocator).click();
        driver.findElement(selectTheSecondAccount).click();
    }

    public void OpenNewSavingsAccountAndDepositFromFirstAccount(){
        driver.findElement(accountTypeDropMenuLocator).click();
        driver.findElement(selectSavingsAccount).click();

        driver.findElement(selectAccountDropMenuLocator).click();
        driver.findElement(selectTheFirstAccount).click();
    }

    public void OpenNewCheckingAccountAndDepositFromFirstAccount(){
        driver.findElement(accountTypeDropMenuLocator).click();
        driver.findElement(selectCheckingAccount).click();

        driver.findElement(selectAccountDropMenuLocator).click();
        driver.findElement(selectTheFirstAccount).click();
    }

    public void ClickOnTheOpenNewAccountButton(){
        driver.findElement(openNewAccountSubmitButton).click();
    }
}
