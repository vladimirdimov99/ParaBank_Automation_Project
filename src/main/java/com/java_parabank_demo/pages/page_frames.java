package com.pages;

import org.openqa.selenium.WebDriver;

public class page_frames {

    String pageUrl = "/elements";

    public WebDriver goToElementsPage(WebDriver driver, String url) {
        driver.get(url);
        return driver;
    };

}
