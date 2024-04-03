package com.java_parabank_demo.Pages.Account_Services;

import com.java_parabank_demo.utils.LoadTheDriver;
import org.openqa.selenium.By;

public class Accounts_Overview_Form extends LoadTheDriver {

    By accountsOverviewButton = By.linkText("Accounts Overview");
    By accountActivityGoButton = By.cssSelector("input[value='Go']");

    public By transactionType = By.xpath("//*[@id='rightPanel']/table/tbody/tr[4]/td[2]");
    public By transactionLink = By.linkText("Funds Transfer Received");
    public By firstAccount = By.xpath("//*[@id='accountTable']/tbody/tr[1]/td[1]/a");
    public By secondAccount = By.xpath("//*[@id='accountTable']/tbody/tr[2]/td[1]/a");
    public By accountsOverviewTitle = By.xpath("//*[@id='rightPanel']/div/div/h1[1]");
    public By accountsOverviewForm = By.className("ng-scope");
    public By accountDetailsForm = By.id("rightPanel");
    public By accountType = By.id("accountType");
    public By transactionActivityMessage = By.xpath("//*[@ng-if='showActivity']/p");


    public void GoToTheAccountsOverviewForm() {
        getDriver().findElement(accountsOverviewButton).click();
        // Accounts Overview Form is displayed with all of the user's accounts and his Balance and Available Amount
    }

    public void SelectTheFirstAccount() {
        getDriver().findElement(firstAccount).click();
    }

    public void SelectTheSecondAccount() {
        getDriver().findElement(secondAccount).click();
    }

    public void CheckAccountActivity() {
        getDriver().findElement(accountActivityGoButton).click();
    }

    public void CheckTransactionDetails() {
        getDriver().findElement(transactionLink).click();
    }
}
