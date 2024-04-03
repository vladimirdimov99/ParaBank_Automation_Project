package com.java_parabank_demo.Pages.Authorization;

import com.java_parabank_demo.utils.LoadTheDriver;
import org.openqa.selenium.By;

public class Sign_Up_Form extends LoadTheDriver {

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

    public void GoToTheSignUpForm (){
        getDriver().findElement(registerButton).click();
    }

    public void SignUpToTheWebsite(String firstName, String lastName, String address, String city, String state, String zipCode,
                                   String phone, String ssn, String username, String password, String confirmPW){
        getDriver().findElement(firstNameField).click();
        getDriver().findElement(firstNameField).sendKeys(firstName);

        getDriver().findElement(lastNameField).click();
        getDriver().findElement(lastNameField).sendKeys(lastName);

        getDriver().findElement(addressField).click();
        getDriver().findElement(addressField).sendKeys(address);

        getDriver().findElement(cityField).click();
        getDriver().findElement(cityField).sendKeys(city);

        getDriver().findElement(stateField).click();
        getDriver().findElement(stateField).sendKeys(state);

        getDriver().findElement(zipCodeField).click();
        getDriver().findElement(zipCodeField).sendKeys(zipCode);

        getDriver().findElement(phoneNumberField).click();
        getDriver().findElement(phoneNumberField).sendKeys(phone);

        getDriver().findElement(SSNField).click();
        getDriver().findElement(SSNField).sendKeys(ssn);

        getDriver().findElement(userNameField).click();
        getDriver().findElement(userNameField).sendKeys(username);

        getDriver().findElement(setPasswordField).click();
        getDriver().findElement(setPasswordField).sendKeys(password);

        getDriver().findElement(confirmPWField).click();
        getDriver().findElement(confirmPWField).sendKeys(confirmPW);
    }

    public void ClickOnRegisterSubmitButton(){
        getDriver().findElement(registerSubmitButton).click();
    }

    public void ClickOnLogOutButton(){
        getDriver().findElement(logOutButton).click();
    }
}
