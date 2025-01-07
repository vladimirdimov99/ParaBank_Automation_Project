package com.java_parabank_demo.pages.account_services;

import com.java_parabank_demo.utils.TestBase;
import org.openqa.selenium.By;

public class UpdateContactInfoForm extends TestBase {

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
