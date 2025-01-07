package com.java_parabank_demo.pages.authorization;

import com.java_parabank_demo.utils.TestBase;
import org.openqa.selenium.By;

public class LogInForm extends TestBase {

    By usernameLogInField = By.name("username");
    By passwordLogInField = By.name("password");
    By loginSubmitButton = By.cssSelector("input[value='Log In']");
    public By welcomeMessageTextLocator = By.className("smallText");
    public By leftPanelLocator = By.id("leftPanel");
    public By loginErrorMessage = By.className("error");

    public void LogInToTheWebsite(String username, String password) {
        getDriver().findElement(usernameLogInField).click();
        getDriver().findElement(usernameLogInField).sendKeys(username);

        getDriver().findElement(passwordLogInField).click();
        getDriver().findElement(passwordLogInField).sendKeys(password);

    }

    public void ClickOnTheLogInButton() {
        getDriver().findElement(loginSubmitButton).click();
    }
}
