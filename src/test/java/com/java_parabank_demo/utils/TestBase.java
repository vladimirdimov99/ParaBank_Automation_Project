package com.java_parabank_demo.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;
    public static Properties properties;
    private String browserName;
    public static final int TIMEOUT = 10;

    String websiteURL = "https://parabank.parasoft.com/";

    public TestBase() {
        try {
            properties = new Properties();
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initializeBrowserDriver() throws Exception {
        browserName = properties.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-search-engine-choice-screen");
            //options.addArguments("--headless");
            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else {
            throw new Exception("Unsupported browser!!!");
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void loadTheWebsite() {
        driver.get(websiteURL);
        driver.manage().window().maximize();
    }

    public void waitForVisibilityOfElementLocated(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForVisibilityOfElementLocated(String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitForInvisibilityOfElementLocated(By element) {

        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void waitForInvisibilityOfElementLocated(String locator) {

        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitForElementToBeClickable(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickElement(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    public void clickElement(String element) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
        driver.findElement(By.xpath(element)).click();
    }

    public void clickElement(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void enterText(By element, String text) {

        waitForVisibilityOfElementLocated(element);

        //driver.findElement(element).clear();
        //driver.findElement(element).click();
        driver.findElement(element).sendKeys(text);
    }

    public void enterTextButClearInputField(By element, String text) {

        waitForElementToBeClickable(element);

        driver.findElement(element).click();
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
    }

    public static void quitTheDriver() {
        if (driver!= null) {
            driver.quit();
            driver = null;
        }
    }
}
