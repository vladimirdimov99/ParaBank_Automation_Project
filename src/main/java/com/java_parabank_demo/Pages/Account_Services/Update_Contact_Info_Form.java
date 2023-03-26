package com.java_parabank_demo.Pages.Account_Services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Update_Contact_Info_Form {
    WebDriver driver;
    public Update_Contact_Info_Form (WebDriver driver) {this.driver = driver;}

    By editFirstName = By.id("customer.firstName");
    By editLastName = By.id("customer.lastName");
    By editAddressField = By.id("customer.address.street");
    By editCityField = By.id("customer.address.city");
    By editStateField = By.id("customer.address.state");
    By editZipCodeField = By.id("customer.address.zipCode");
    By editPhoneNumberField = By.id("customer.phoneNumber");
    By editSSNField = By.id("customer.ssn");
    By updateProfileBtn = By.cssSelector("input[value='Update Profile']");
}
