package com.bekacookware.pages;

import com.bekacookware.utility.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CommonActivity {

    WebDriver driver;
    public CommonActivity(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void launchUrl(String url) {
        driver.get(url);
        clickCookiesPopupAcceptance();
        clickCrossButtonOnGermanyCountrySelectionPopup();
        clickCloseButtonOnAddPopUp();
    }

    @FindBy(xpath = "//button[@aria-label='Close dialog']/*[local-name()='svg']")
    private WebElement closeButtonOnAddPopUp;
    public void clickCloseButtonOnAddPopUp() {
        WaitUtils.waitAndClickIfPresent(driver, closeButtonOnAddPopUp);
    }

    @FindBy(xpath = "//button[text()='Cookies accepteren']")
    private WebElement cookiesPopupAcceptance;
    public void clickCookiesPopupAcceptance() {
        WaitUtils.waitUntillElementVisibility(driver,cookiesPopupAcceptance).click();
    }

    @FindBy(xpath = "//button[@class='modal__close | js-modal-close']")
    private WebElement crossButtonOnGermanyCountrySelectionPopup;
    public void clickCrossButtonOnGermanyCountrySelectionPopup() {
        WaitUtils.waitUntillElementVisibility(driver,crossButtonOnGermanyCountrySelectionPopup).click();
    }
}
