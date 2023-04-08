package com.java_parabank_demo.Pages.Account_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Bill_Pay_Form {
    WebDriver driver;
    public Bill_Pay_Form (WebDriver driver) {this.driver = driver;}

    By billPayButton = By.linkText("Bill Pay");
    By payeeNameFieldLocator = By.name("payee.name");
    By addressFieldLocator = By.name("payee.address.street");
    By cityFieldLocator = By.name("payee.address.city");
    By stateFieldLocator = By.name("payee.address.state");
    By zipCodeFieldLocator = By.name("payee.address.zipCode");
    By phoneFieldLocator = By.name("payee.phoneNumber");
    By accountFieldLocator = By.name("payee.accountNumber");
    By verifyAccountFieldLocator = By.name("verifyAccount");
    By amountFieldLocator = By.name("amount");
    By fromAccountDropMenuLocator = By.name("fromAccountId");
    By sendPaymentSubmitButton = By.cssSelector("input[value='Send Payment']");
    By fromAccountDropMenuFirstAccount = By.xpath("//*[@id='rightPanel']/div/div[1]/form/table/tbody/tr[13]/td[2]/select/option[1]");
    By fromAccountDropMenuSecondAccount = By.xpath("//*[@id='rightPanel']/div/div[1]/form/table/tbody/tr[13]/td[2]/select/option[2]");
    public By billPayTitle = By.className("title");

    public void GoToTheBillPayForm(){
        driver.findElement(billPayButton).click();
        // Accounts Overview Form is displayed with all of the user's accounts and his Balance and Available Amount
    }

    public void PayABillWithTheSecondAccount(String payeeName, String addressField, String cityField, String stateField,
                                            String zipCodeField, String phoneField, String account, String verifyAcc, String amount){
        driver.findElement(payeeNameFieldLocator).click();
        driver.findElement(payeeNameFieldLocator).sendKeys(payeeName);

        driver.findElement(addressFieldLocator).click();
        driver.findElement(addressFieldLocator).sendKeys(addressField);

        driver.findElement(cityFieldLocator).click();
        driver.findElement(cityFieldLocator).sendKeys(cityField);

        driver.findElement(stateFieldLocator).click();
        driver.findElement(stateFieldLocator).sendKeys(stateField);

        driver.findElement(zipCodeFieldLocator).click();
        driver.findElement(zipCodeFieldLocator).sendKeys(zipCodeField);

        driver.findElement(phoneFieldLocator).click();
        driver.findElement(phoneFieldLocator).sendKeys(phoneField);

        driver.findElement(accountFieldLocator).click();
        driver.findElement(accountFieldLocator).sendKeys(account);

        driver.findElement(verifyAccountFieldLocator).click();
        driver.findElement(verifyAccountFieldLocator).sendKeys(verifyAcc);

        driver.findElement(amountFieldLocator).click();
        driver.findElement(amountFieldLocator).sendKeys(amount);

        driver.findElement(fromAccountDropMenuLocator).click();
        driver.findElement(fromAccountDropMenuSecondAccount).click();
    }

    public void ClickOnTheSendPaymentButton(){
        driver.findElement(sendPaymentSubmitButton).click();
    }
}
