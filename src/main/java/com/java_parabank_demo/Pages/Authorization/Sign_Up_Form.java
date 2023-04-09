package com.java_parabank_demo.Pages.Authorization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sign_Up_Form {
    WebDriver driver;

    By registerButton = By.linkText("Register");
    By firstNameField = By.id("customer.firstName");
    By lastNameField = By.id("customer.lastName");
    By addressField = By.id("customer.address.street");
    By cityField = By.id("customer.address.city");
    By stateField = By.id("customer.address.state");
    By zipCodeField = By.id("customer.address.zipCode");
    By phoneNumberField = By.id("customer.phoneNumber");
    By SSNField = By.id("customer.ssn");
    By userNameField = By.id("customer.username");
    By setPasswordField = By.id("customer.password");
    By confirmPWField = By.id("repeatedPassword");
    By registerSubmitButton = By.cssSelector("input[value='Register']");
    public By signUpTitle = By.className("title");
    public By signUpForm = By.className("form2");
    public By logOutButton = By.linkText("Log Out");
    public By customerLoginTitle = By.xpath("//*[@id='leftPanel']/h2");
    public By usernameTakenError = By.id("customer.username.errors");


    public Sign_Up_Form (WebDriver driver) {this.driver = driver;}

    public void GoToTheSignUpForm (){
        driver.findElement(registerButton).click();
    }

    public void SignUpToTheWebsite(String firstName, String lastName, String address, String city, String state, String zipCode,
                                   String phone, String ssn, String username, String password, String confirmPW){
        driver.findElement(firstNameField).click();
        driver.findElement(firstNameField).sendKeys(firstName);

        driver.findElement(lastNameField).click();
        driver.findElement(lastNameField).sendKeys(lastName);

        driver.findElement(addressField).click();
        driver.findElement(addressField).sendKeys(address);

        driver.findElement(cityField).click();
        driver.findElement(cityField).sendKeys(city);

        driver.findElement(stateField).click();
        driver.findElement(stateField).sendKeys(state);

        driver.findElement(zipCodeField).click();
        driver.findElement(zipCodeField).sendKeys(zipCode);

        driver.findElement(phoneNumberField).click();
        driver.findElement(phoneNumberField).sendKeys(phone);

        driver.findElement(SSNField).click();
        driver.findElement(SSNField).sendKeys(ssn);

        driver.findElement(userNameField).click();
        driver.findElement(userNameField).sendKeys(username);

        driver.findElement(setPasswordField).click();
        driver.findElement(setPasswordField).sendKeys(password);

        driver.findElement(confirmPWField).click();
        driver.findElement(confirmPWField).sendKeys(confirmPW);
    }

    public void ClickOnRegisterSubmitButton(){
        driver.findElement(registerSubmitButton).click();
    }

    public void ClickOnLogOutButton(){
        driver.findElement(logOutButton).click();
    }
}
