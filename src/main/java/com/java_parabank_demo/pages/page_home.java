package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class page_home {

    private String baseUrl = "https://demoqa.com";
    private By elementsButtonLocator = By.xpath("//*[@class='category-cards']/div[1]");


    public String getUrl() {
        return baseUrl;
    }

    public WebDriver clickElementsButton(WebDriver driver) {
        driver.findElement(elementsButtonLocator).click();
        return driver;
    }

}
