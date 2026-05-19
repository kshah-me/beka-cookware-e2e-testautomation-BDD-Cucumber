package com.bekacookware.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }
}