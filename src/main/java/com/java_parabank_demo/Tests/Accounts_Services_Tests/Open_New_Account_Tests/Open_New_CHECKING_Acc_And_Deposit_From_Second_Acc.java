package com.java_parabank_demo.Tests.Accounts_Services_Tests.Open_New_Account_Tests;

import com.java_parabank_demo.Pages.Account_Services.Open_New_Account_Form;
import com.java_parabank_demo.Pages.Authorization.Log_In_Form;
import com.java_parabank_demo.Pages.Authorization.Sign_Up_Form;
import com.java_parabank_demo.Pages.LoadTheWebsite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Open_New_CHECKING_Acc_And_Deposit_From_Second_Acc {
    WebDriver driver;
    String currentURL;
    String expectedURL;
    String openNewAccountTitle;

    private static String firstName = "Vladimir";
    private static String lastName = "Dimov";
    private static String address = "Sofia";
    private static String city = "Sofia";
    private static String state = "Sofia";
    private static String zipCode = "12345";
    private static String phone = "12345";
    private static String ssn = "12345";
    private static String username = "papagala44";
    private static String password = "test123";
    private static String confirmPW = "test123";
    Duration timeout = Duration.ofSeconds(3);

    @BeforeTest
    public void OpenTheWebsite(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(option);
        new LoadTheWebsite().LoadTheWebsite(driver);
    }

    @Test(priority = 1)
    public void checkIfTheWebsiteURLIsCorrect(){
        currentURL = driver.getCurrentUrl();
        expectedURL = "https://parabank.parasoft.com/parabank/index.htm";
        Assert.assertEquals(currentURL, expectedURL);
    }

    @Test(priority = 2)
    public void LogInToTheWebsite(){
        Log_In_Form log_in_form = new Log_In_Form(driver);
        log_in_form.LogInToTheWebsite(username, password);

        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(log_in_form.leftPanelLocator));
        String welcomeLogInMessage = driver.findElement(log_in_form.welcomeMessageTextLocator).getText();
        Assert.assertTrue(welcomeLogInMessage.contains(firstName + lastName));
    }

    @Test(priority = 3)
    public void GoToTheOpenNewAccountForm(){
        Open_New_Account_Form open_new_account_form = new Open_New_Account_Form(driver);
        open_new_account_form.GoToTheOpenNewAccountForm();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(open_new_account_form.openNewAccountForm));
        openNewAccountTitle = driver.findElement(open_new_account_form.openNewAccountTitle).getText();
        Assert.assertEquals(openNewAccountTitle, "Open New Account");
    }

    @Test(priority = 4)
    public void OpenNewCheckingAccountAndDepositFromSecondAccount(){
        Open_New_Account_Form open_new_account_form = new Open_New_Account_Form(driver);
        open_new_account_form.OpenNewCheckingAccountAndDepositFromSecondAccount();
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeSelected(open_new_account_form.selectTheSecondAccount));
        open_new_account_form.ClickOnTheOpenNewAccountButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(open_new_account_form.openNewAccountForm));
        openNewAccountTitle = driver.findElement(open_new_account_form.openNewAccountTitle).getText();
        Assert.assertEquals(openNewAccountTitle, "Account Opened!");
    }

    @AfterTest
    public void closeTheWebsite() {driver.quit();}
}
