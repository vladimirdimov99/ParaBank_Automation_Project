package com.java_parabank_demo.Pages.Account_Services;

import org.openqa.selenium.By;

public class Transfer_Funds_Form {

    public By transferFundsLinkText= By.xpath("//a[.='Transfer Funds']");
    public By amountField= By.xpath("//input[@id='amount']");
    public By fromAccField= By.xpath("//select[@id='fromAccountId']");
    public By toAccField= By.xpath("//select[@id='toAccountId']");
    public By transferButton= By.cssSelector("[type='submit']");
}
