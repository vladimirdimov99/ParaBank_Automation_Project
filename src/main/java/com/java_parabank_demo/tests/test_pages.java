package com.tests;

import com.pages.page_elements;
import com.pages.page_home;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test_pages {

    WebDriver driver;
    page_elements pageElements;
    page_home pageHome;


    @BeforeTest
    public void loadTheHomePage() throws InterruptedException {
        // Will be run once before all other tests i.e. they will then inherit the driver
        pageHome = new page_home();
        pageElements = new page_elements();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(pageHome.getUrl());
        Thread.sleep(1000);
    }

    // Note that priority value is set as otherwise the tests will be run by name which will break the inheritance chain

    @Test(priority = 0)
    public void testTheHomePageUrl() {
        // Launch the home page, generate expected and actual URLs and compare them
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = pageHome.getUrl()+"/";
        Assert.assertEquals("[ERROR] Different than the expected URL!", expectedUrl, currentUrl);
    }

    @Test(priority = 1)
    public void testGoToElementsPage() throws InterruptedException {
        // Then click the Elements button and verify if the related page is loaded
        String expectedUrl = pageHome.getUrl() + pageElements.getPageUrl();
        pageHome.clickElementsButton(driver);
        Thread.sleep(1500);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("[ERROR] ", expectedUrl, currentUrl);
    }

    @Test(priority = 2)
    public void testGoToTextForm() throws InterruptedException {
        // Finally click on the text-box button on the Elements page and verify the text-form is loaded
        pageElements.clickTextBoxButton(driver);
        Thread.sleep(1500);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("[ERROR] ", "https://demoqa.com/text-box", currentUrl);
    }

    @AfterTest
    public void cleanup() {
        driver.quit();
    }
}
