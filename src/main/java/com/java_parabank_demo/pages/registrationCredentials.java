package com.java_parabank_demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class registrationCredentials {
    WebDriver driver;

    public registrationCredentials(WebDriver driver) {
        this.driver = driver;
    }

    Duration timeout = Duration.ofSeconds(5);

    By firstNameField = By.id("customer.firstName");
    By lastNameField = By.id("customer.lastName");
    By addressField = By.id("customer.address.street");
    By cityField = By.id("customer.address.city");
    By stateField = By.id("customer.address.state");
    By zipCodeField = By.id("customer.address.zipCode");
    By phoneNumberField = By.id("customer.phoneNumber");
    By SSNField = By.id("customer.ssn");
    By usernameField = By.id("customer.username");
    By passwordField = By.id("customer.password");
    By confirmPasswordField = By.id("repeatedPassword");
    By registerButton = By.xpath("//input[@value='Register']");


    public void enterFirstNameCredentials(String firstName) {
        homePageElements hpe = new homePageElements();
        driver.findElement(firstNameField).click();
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastNameCredentials(String lastName) {
        homePageElements hpe = new homePageElements();
        driver.findElement(lastNameField).click();
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterAddressCredentials(String address) {
        homePageElements hpe = new homePageElements();
        driver.findElement(addressField).click();
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
    }

    public void enterCityCredentials(String city) {
        homePageElements hpe = new homePageElements();
        driver.findElement(cityField).click();
        driver.findElement(cityField).clear();
        driver.findElement(cityField).sendKeys(city);
    }

    public void enterStateCredentials(String state) {
        homePageElements hpe = new homePageElements();
        driver.findElement(stateField).click();
        driver.findElement(stateField).clear();
        driver.findElement(stateField).sendKeys(state);
    }

    public void enterZipCodeCredentials(String ZIPCode) {
        homePageElements hpe = new homePageElements();
        driver.findElement(zipCodeField).click();
        driver.findElement(zipCodeField).clear();
        driver.findElement(zipCodeField).sendKeys(ZIPCode);
    }

    public void enterPhoneNumberCredentials(String phoneNumber) {
        homePageElements hpe = new homePageElements();
        driver.findElement(phoneNumberField).click();
        driver.findElement(phoneNumberField).clear();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void enterSSNCredentials(String SSN) {
        homePageElements hpe = new homePageElements();
        driver.findElement(SSNField).click();
        driver.findElement(SSNField).clear();
        driver.findElement(SSNField).sendKeys(SSN);
    }

    public void enterUsernameCredentials(String username) {
        homePageElements hpe = new homePageElements();
        driver.findElement(usernameField).click();
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPasswordCredentials(String password) {
        homePageElements hpe = new homePageElements();
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void confirmPasswordCredentials(String password) {
        homePageElements hpe = new homePageElements();
        driver.findElement(confirmPasswordField).click();
        driver.findElement(confirmPasswordField).clear();
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    public void registerButtonClick() {
        driver.findElement(registerButton).click();

    }

    public void assertSuccessfulLogin() {
//        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(logOutButton));
//        driver.findElement(logOutButton).isDisplayed();
    }
}
