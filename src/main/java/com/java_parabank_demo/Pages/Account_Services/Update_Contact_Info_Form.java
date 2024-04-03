package com.java_parabank_demo.Pages.Account_Services;

import com.java_parabank_demo.utils.LoadTheDriver;
import org.openqa.selenium.By;

public class Update_Contact_Info_Form extends LoadTheDriver {

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
