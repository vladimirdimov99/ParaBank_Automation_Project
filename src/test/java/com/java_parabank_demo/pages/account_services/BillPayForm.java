package com.java_parabank_demo.pages.account_services;

import com.java_parabank_demo.utils.TestBase;
import org.openqa.selenium.By;

public class BillPayForm extends TestBase {

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

    public void goToTheBillPayForm() {
        getDriver().findElement(billPayButton).click();
        // Accounts Overview Form is displayed with all of the user's accounts and his Balance and Available Amount
    }

    public void payABillWithTheSecondAccount(String payeeName, String addressField, String cityField, String stateField,
                                             String zipCodeField, String phoneField, String account, String verifyAcc, String amount) {
        getDriver().findElement(payeeNameFieldLocator).click();
        getDriver().findElement(payeeNameFieldLocator).sendKeys(payeeName);

        getDriver().findElement(addressFieldLocator).click();
        getDriver().findElement(addressFieldLocator).sendKeys(addressField);

        getDriver().findElement(cityFieldLocator).click();
        getDriver().findElement(cityFieldLocator).sendKeys(cityField);

        getDriver().findElement(stateFieldLocator).click();
        getDriver().findElement(stateFieldLocator).sendKeys(stateField);

        getDriver().findElement(zipCodeFieldLocator).click();
        getDriver().findElement(zipCodeFieldLocator).sendKeys(zipCodeField);

        getDriver().findElement(phoneFieldLocator).click();
        getDriver().findElement(phoneFieldLocator).sendKeys(phoneField);

        getDriver().findElement(accountFieldLocator).click();
        getDriver().findElement(accountFieldLocator).sendKeys(account);

        getDriver().findElement(verifyAccountFieldLocator).click();
        getDriver().findElement(verifyAccountFieldLocator).sendKeys(verifyAcc);

        getDriver().findElement(amountFieldLocator).click();
        getDriver().findElement(amountFieldLocator).sendKeys(amount);

        getDriver().findElement(fromAccountDropMenuLocator).click();
        getDriver().findElement(fromAccountDropMenuSecondAccount).click();
    }

    public void clickOnTheSendPaymentButton() {
        getDriver().findElement(sendPaymentSubmitButton).click();
    }
}
