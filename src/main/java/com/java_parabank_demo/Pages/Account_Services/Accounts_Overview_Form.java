package com.java_parabank_demo.Pages.Account_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Accounts_Overview_Form {
    WebDriver driver;
    public Accounts_Overview_Form (WebDriver driver) {this.driver = driver;}

    By accountsOverviewButton = By.linkText("Accounts Overview");
    By accountActivityGoButton = By.cssSelector("input[value='Go']");

    public By firstAccount = By.xpath("//*[@id='accountTable']/tbody/tr[1]/td[1]/a");
    public By accountsOverviewTitle = By.xpath("//*[@id='rightPanel']/div/div/h1[1]");
    public By accountsOverviewForm = By.className("ng-scope");
    public By accountDetailsForm = By.id("rightPanel");
    public By accountType = By.id("accountType");
    public By transactionActivityMessage = By.xpath("//*[@ng-if='showActivity']/p");


    public void GoToTheAccountsOverviewForm(){
        driver.findElement(accountsOverviewButton).click();
        // Accounts Overview Form is displayed with all of the user's accounts and his Balance and Available Amount
    }

    public void SelectTheFirstAccount(){
        driver.findElement(firstAccount).click();
    }

    public void CheckAccountActivity(){
        driver.findElement(accountActivityGoButton).click();
    }
}
