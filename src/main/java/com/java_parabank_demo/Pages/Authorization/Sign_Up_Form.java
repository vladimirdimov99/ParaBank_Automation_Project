package com.java_parabank_demo.Pages.Authorization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sign_Up_Form {
    WebDriver driver;

    public Sign_Up_Form(WebDriver driver) {this.driver = driver;}

    By registerButton = By.linkText("Register");
    public void GoToTheSignUpForm(){
        driver.findElement(registerButton).click();
    }
}
