package com.java_parabank_demo.Pages.Authorization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Log_In_Form {
    WebDriver driver;
    public Log_In_Form(WebDriver driver) {this.driver = driver;}

    By usernameLogInField = By.name("username");
    By passwordLogInField = By.name("password");
    By loginSubmitButton = By.cssSelector("input[value='Log In']");
    public By welcomeMessageTextLocator = By.className("smallText");
    public By leftPanelLocator = By.id("leftPanel");

    public void LogInToTheWebsite(String username, String password) {
        driver.findElement(usernameLogInField).click();
        driver.findElement(usernameLogInField).sendKeys(username);

        driver.findElement(passwordLogInField).click();
        driver.findElement(passwordLogInField).sendKeys(password);

        driver.findElement(loginSubmitButton).click();
    }
}
