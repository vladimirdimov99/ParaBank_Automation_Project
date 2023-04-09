package com.java_parabank_demo.Tests.Authorization_Tests.Sign_Up_Tests;

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

public class Sign_Up_And_Log_Out_From_The_Acc {
    WebDriver driver;
    String currentURL;
    String expectedURL;

    private static String firstName = "Vladimir";
    private static String lastName = "Dimov";
    private static String address = "Sofia";
    private static String city = "Sofia";
    private static String state = "Sofia";
    private static String zipCode = "12345";
    private static String phone = "12345";
    private static String ssn = "12345";
    private static String username = "papagala27";
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
    public void GoToTheSignUpForm(){
        Sign_Up_Form sign_up_form = new Sign_Up_Form(driver);
        sign_up_form.GoToTheSignUpForm();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(sign_up_form.signUpTitle));
        String signingUpIsEasyText = driver.findElement(sign_up_form.signUpTitle).getText();
        Assert.assertEquals(signingUpIsEasyText, "Signing up is easy!");
    }

    @Test(priority = 3)
    public void SignUpToTheWebsite(){
        Sign_Up_Form sign_up_form = new Sign_Up_Form(driver);
        sign_up_form.SignUpToTheWebsite(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password, confirmPW);
        sign_up_form.ClickOnRegisterSubmitButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(sign_up_form.signUpTitle));
        String welcomeMessage = driver.findElement(sign_up_form.signUpTitle).getText();
        Assert.assertTrue(welcomeMessage.contains(username));
    }

    @Test(priority = 4)
    public void LogOutFromTheAccount(){
        Sign_Up_Form sign_up_form = new Sign_Up_Form(driver);
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(sign_up_form.logOutButton));
        sign_up_form.ClickOnLogOutButton();

        new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(sign_up_form.customerLoginTitle));
        String customerLoginTitle = driver.findElement(sign_up_form.customerLoginTitle).getText();
        Assert.assertEquals(customerLoginTitle, "Customer Login");
    }

    @AfterTest
    public void closeTheWebsite() {driver.quit();}
}
