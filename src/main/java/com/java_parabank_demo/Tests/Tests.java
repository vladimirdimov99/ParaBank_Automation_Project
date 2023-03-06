package com.java_parabank_demo.Tests;

import com.java_parabank_demo.Pages.Authorization.Sign_Up_Form;
import com.java_parabank_demo.Pages.LoadTheWebsite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tests {
    WebDriver driver;
    String currentURL;
    String expectedURL;

    @BeforeTest
    public void OpenTheWebsite(){
        driver = new ChromeDriver();
        new LoadTheWebsite().LoadTheWebsite(driver);
    }

    @Test(priority = 1)
    public void checkIfTheWebsiteURLIsCorrect(){
        currentURL = driver.getCurrentUrl();
        expectedURL = "https://parabank.parasoft.com/parabank/index.htm";
        Assert.assertEquals(currentURL, expectedURL);
    }

//    @Test(priority = 2)
//    public void GoToTheSignUpForm(){
//        Sign_Up_Form sign_up_form = new Sign_Up_Form(driver);
//        sign_up_form.GoToTheSignUpForm();
//    }

}
