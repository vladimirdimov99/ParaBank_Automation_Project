package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class page_elements {

        private String pageUrl = "/elements";
        private By textBoxButtonLocator = By.id("item-0");

        public String getPageUrl() {
            return pageUrl;
        }

        public WebDriver clickTextBoxButton(WebDriver driver) {
            driver.findElement(textBoxButtonLocator).click();
            return driver;
        }

}
