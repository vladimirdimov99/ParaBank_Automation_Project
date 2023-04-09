package com.java_parabank_demo.Tests.Accounts_Services_Tests.Accounts_Overview_Tests;

import com.java_parabank_demo.Pages.Account_Services.Accounts_Overview_Form;
import com.java_parabank_demo.Pages.Authorization.Sign_Up_Form;
import com.java_parabank_demo.Pages.LoadTheWebsite;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Check_The_First_Acc_Details_And_Activity_After_Registering {
    WebDriver driver;
    String currentURL;
    String expectedURL;
    String accountsOverviewTitle;

    private static String firstName = "Vladimir";
    private static String lastName = "Dimov";
    private static String address = "Sofia";
    private static String city = "Sofia";
    private static String state = "Sofia";
    private static String zipCode = "12345";
    private static String phone = "12345";
    private static String ssn = "12345";
    private static String username = "papagala2";
    private static String password = "test123";
    private static String confirmPW = "test123";
    Duration timeout = Duration.ofSeconds(3);

    @BeforeTest
    public void OpenTheWebsite(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
//        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
//        String browserName = caps.getBrowserName();
//        String browserVersion = caps.getVersion();
//        System.out.println(browserName+" "+browserVersion);
        new LoadTheWebsite().LoadTheWebsite(driver);
    }

    @Test(priority = 1)
    public void checkIfTheWebsiteURLIsCorrect(){
        currentURL = driver.getCurrentUrl();
        expectedURL = "https://parabank.parasoft.com/parabank/index.htm";
        Assert.assertEquals(currentURL, expectedURL);
    }

    @Test(priority = 2)
    public void GoToTheSignUpForm(){
        Sign_Up_Form sign_up_form = new Sign_Up_Form(driver);
        sign_up_form.GoToTheSignUpForm();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sign_up_form.signUpForm));
        String signingUpIsEasyText = driver.findElement(sign_up_form.signUpTitle).getText();
        Assert.assertEquals(signingUpIsEasyText, "Signing up is easy!");
    }

    @Test(priority = 3)
    public void SignUpToTheWebsite(){
        Sign_Up_Form sign_up_form = new Sign_Up_Form(driver);
        sign_up_form.SignUpToTheWebsite(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password, confirmPW);
        sign_up_form.ClickOnRegisterSubmitButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sign_up_form.signUpTitle));
        String welcomeMessage = driver.findElement(sign_up_form.signUpTitle).getText();
        Assert.assertTrue(welcomeMessage.contains(username));
    }

    @Test(priority = 4)
    public void GoToTheAccountOverviewForm(){
        Accounts_Overview_Form accounts_overview_form = new Accounts_Overview_Form(driver);
        accounts_overview_form.GoToTheAccountsOverviewForm();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(accounts_overview_form.accountsOverviewForm));
        accountsOverviewTitle = driver.findElement(accounts_overview_form.accountsOverviewTitle).getText();
        Assert.assertEquals(accountsOverviewTitle, "Accounts Overview");
    }

    @Test(priority = 5)
    public void SelectTheFirstAccAndCheckDetails(){
        //The First Account type after registering should be a CHECKING Account
        Accounts_Overview_Form accounts_overview_form = new Accounts_Overview_Form(driver);
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(accounts_overview_form.firstAccount));
        accounts_overview_form.SelectTheFirstAccount();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(accounts_overview_form.accountType));
        String accountType = driver.findElement(accounts_overview_form.accountType).getText();
        Assert.assertEquals(accountType, "CHECKING");
    }

    @Test(priority = 6)
    public void CheckAccountActivity(){
        // There should be no Transactions found since we just created our account
        // Activity Period and Transaction Type is left default on "All"

        Accounts_Overview_Form accounts_overview_form = new Accounts_Overview_Form(driver);
        accounts_overview_form.CheckAccountActivity();
        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(accounts_overview_form.transactionActivityMessage));
        String transactionActivityMessage = driver.findElement(accounts_overview_form.transactionActivityMessage).getText();
        Assert.assertEquals(transactionActivityMessage, "No transactions found.");
    }

    @AfterTest
    public void closeTheWebsite() {driver.quit();}
}
